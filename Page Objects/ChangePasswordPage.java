import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    //Elements
    protected WebElement getCurrentPasswordTxt(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("#currentPassword"));
    }

    protected WebElement getNewPasswordTxt(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("#newPassword"));
    }

    protected  WebElement getConfirmPassword(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("#confirmPassword"));
    }

    protected WebElement getChangePasswordBtn(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("input[value='Change Password']"));
    }

    protected WebElement getChangePasswordMsg(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("p[class*='message']"));
    }

    //Methods
    public void ChangePassword(String currentPassword, String newPassword, String confirmPassword){

        js.executeScript("arguments[0].scrollIntoView(true)",getPageFooter());

        getCurrentPasswordTxt().clear();
        getNewPasswordTxt().clear();
        getConfirmPassword().clear();

        getCurrentPasswordTxt().sendKeys(currentPassword);
        getNewPasswordTxt().sendKeys(newPassword);
        getConfirmPassword().sendKeys(confirmPassword);
        getChangePasswordBtn().click();

    }

}
