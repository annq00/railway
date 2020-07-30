import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    private WebDriver driver;
    
    public LoginPage(WebDriver webDriver){
        driver = webDriver;
    }

    //Elements
    public WebElement getUsernameTxt() {
        return driver.findElement(By.xpath("//input[@id='username']"));
    }

    public WebElement getPasswordTxt() {
        return driver.findElement(By.xpath("//input[@id='password']"));
    }

    public WebElement getLoginBtn() {
        return driver.findElement(By.xpath("//input[@title='Login']"));
    }

    public WebElement getGeneralErrorMsg(){
        return driver.findElement(By.xpath("//p[@class='message error LoginForm']"));
    }

    //Methods

    public GeneralPage login(String username, String password){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",getPageFooter(driver));

        getUsernameTxt().clear();
        getPasswordTxt().clear();
        getUsernameTxt().sendKeys(username);
        getPasswordTxt().sendKeys(password);
        getLoginBtn().click();
        return new GeneralPage(driver);
    }

    public void loginMultipleTime(int time, String username, String password){
        int count = 0;
        LoginPage loginPage = new LoginPage(driver);
        while(count < time ) {
            loginPage.login(username, password);
            count+=1;
        }

    }

}
