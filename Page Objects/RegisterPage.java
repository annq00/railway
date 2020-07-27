import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    //Elements

    protected WebElement getRegEmailTxt(){

        return Constant.WEBDRIVER.findElement(By.cssSelector("#email"));
    }

    protected WebElement getRegPasswordTxt(){

        return Constant.WEBDRIVER.findElement(By.cssSelector("#password"));
    }

    protected WebElement getRegConfirmPaswordTxt(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("#confirmPassword"));
    }

    protected WebElement getPIDTxt(){

        return Constant.WEBDRIVER.findElement(By.cssSelector("#pid"));
    }

    protected WebElement getRegisterBtn(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("input[value='Register']"));
    }

    protected WebElement getRegisterErrorMsg(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("p[class*='message']"));

    }

    protected  WebElement getPasswordErrorMsg(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("label[for='password'][class='validation-error']"));
    }

    protected  WebElement getPIDErrorMsg(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("label[for='pid'][class='validation-error']"));
    }

    //Methods

    public void CreateAccount(String email, String password, String pid){

        js.executeScript("arguments[0].scrollIntoView(true)", getPageFooter());

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
