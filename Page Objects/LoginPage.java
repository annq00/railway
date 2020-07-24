import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    //Elements

    public WebElement getUsernameTxt() {
        return Constant.webdriver.findElement(By.xpath("//input[@id='username']"));
    }

    public WebElement getPasswordTxt() {
        return Constant.webdriver.findElement(By.xpath("//input[@id='password']"));
    }

    public WebElement getLoginBtn() {
        return Constant.webdriver.findElement(By.xpath("//input[@title='Login']"));
    }

    public WebElement getGeneralErrorMsg(){
        return Constant.webdriver.findElement(By.xpath("//p[@class='message error LoginForm']"));
    }

    //Methods

    public GeneralPage login(String username, String password){

        js.executeScript("arguments[0].scrollIntoView(true)",Constant.webdriver.findElement(By.xpath("//div[@id='footer']")));
        getUsernameTxt().clear();
        getPasswordTxt().clear();
        getUsernameTxt().sendKeys(username);
        getPasswordTxt().sendKeys(password);
        getLoginBtn().click();
        return new GeneralPage();
    }



}
