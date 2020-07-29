import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    
    public RegisterPage(WebDriver webDriver){
        this.driver = webDriver;
    }

    //Elements

    protected WebElement getRegEmailTxt(){

        return this.driver.findElement(By.cssSelector("#email"));
    }

    protected WebElement getRegPasswordTxt(){

        return this.driver.findElement(By.cssSelector("#password"));
    }

    protected WebElement getRegConfirmPaswordTxt(){
        return this.driver.findElement(By.cssSelector("#confirmPassword"));
    }

    protected WebElement getPIDTxt(){

        return this.driver.findElement(By.cssSelector("#pid"));
    }

    protected WebElement getRegisterBtn(){
        return this.driver.findElement(By.cssSelector("input[value='Register']"));
    }

    protected WebElement getRegisterErrorMsg(){
        return this.driver.findElement(By.cssSelector("p[class*='message']"));

    }

    protected  WebElement getPasswordErrorMsg(){
        return this.driver.findElement(By.cssSelector("label[for='password'][class='validation-error']"));
    }

    protected  WebElement getPIDErrorMsg(){
        return this.driver.findElement(By.cssSelector("label[for='pid'][class='validation-error']"));
    }

    //Methods

    public void createAccount(String email, String password, String pid){

        script(driver).executeScript("arguments[0].scrollIntoView(true)", getPageFooter(driver));

        getRegEmailTxt().clear();
        getRegPasswordTxt().clear();
        getRegConfirmPaswordTxt().clear();
        getPIDTxt().clear();

        getRegEmailTxt().sendKeys(email);
        getRegPasswordTxt().sendKeys(password);
        getRegConfirmPaswordTxt().sendKeys(password);
        getPIDTxt().sendKeys(pid);

        getRegisterBtn().click();
    }
}
