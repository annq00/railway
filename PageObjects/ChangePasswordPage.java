import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {
    
    public ChangePasswordPage (WebDriver webDriver){
        driver = webDriver;
    }

    //Elements
    protected WebElement getCurrentPasswordTxt(){
        return driver.findElement(By.cssSelector("#currentPassword"));
    }

    protected WebElement getNewPasswordTxt(){
        return driver.findElement(By.cssSelector("#newPassword"));
    }

    protected  WebElement getConfirmPassword(){
        return driver.findElement(By.cssSelector("#confirmPassword"));
    }

    protected WebElement getChangePasswordBtn(){
        return driver.findElement(By.cssSelector("input[value='Change Password']"));
    }

    protected WebElement getChangePasswordMsg(){
        return driver.findElement(By.cssSelector("p[class*='message']"));
    }

    //Methods
    public void changePassword(String currentPassword, String newPassword, String confirmPassword){

        script(driver).executeScript("arguments[0].scrollIntoView(true)",getPageFooter(driver));

        getCurrentPasswordTxt().clear();
        getNewPasswordTxt().clear();
        getConfirmPassword().clear();

        getCurrentPasswordTxt().sendKeys(currentPassword);
        getNewPasswordTxt().sendKeys(newPassword);
        getConfirmPassword().sendKeys(confirmPassword);
        getChangePasswordBtn().click();

    }

}
