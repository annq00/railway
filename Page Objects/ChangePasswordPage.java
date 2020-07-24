import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    //Elements
    protected WebElement getCurrentPasswordTxt(){
        return Constant.webdriver.findElement(By.cssSelector("#currentPassword"));
    }

    protected WebElement getNewPasswordTxt(){
        return Constant.webdriver.findElement(By.cssSelector("#newPassword"));
    }

    protected  WebElement getConfirmPassword(){
        return Constant.webdriver.findElement(By.cssSelector("#confirmPassword"));
    }

    protected WebElement getChangePasswordBtn(){
        return Constant.webdriver.findElement(By.cssSelector("input[value='Change Password']"));
    }

    protected WebElement getChangePasswordMsg(){
        return Constant.webdriver.findElement(By.cssSelector("p[class*='message']"));
    }

    //Methods
    public void ChangePassword(String currentpassword, String newpassword, String confirmpassword){

        js.executeScript("arguments[0].scrollIntoView(true)",Constant.webdriver.findElement(By.cssSelector("#footer")));

        getCurrentPasswordTxt().clear();
        getNewPasswordTxt().clear();
        getConfirmPassword().clear();

        getCurrentPasswordTxt().sendKeys(currentpassword);
        getNewPasswordTxt().sendKeys(newpassword);
        getConfirmPassword().sendKeys(confirmpassword);
        getChangePasswordBtn().click();

    }

}
