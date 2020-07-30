import Common.Utilities;
import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends BaseTest {
    @Test
    public void TC07(){
        System.out.println("TC07: User can create new account");

        System.out.println("Step 1: Navigate to Railway's HomePage");
        HomePage homePage = new HomePage(driver).open();

        System.out.println("Step 2: Go to Register Page");
        RegisterPage registerPage = homePage.gotoRegisterPage(driver);

        System.out.println("Step 3: Fill all fields with valid information");
        registerPage.createAccount(Utilities.generateRandomString(Constant.SMALLNUM)+"@a.com",Utilities.generateRandomString(Constant.MEDIUMNUM),Utilities.generateRandomString(Constant.MEDIUMNUM));

        System.out.println("Step 4: Verify that account is created successfully and confirm message is dislayed");
        String successfullMsg = registerPage.getSuccessfullyCreateAccountMsg(driver).getText();
        Assert.assertEquals(successfullMsg,"Registration Confirmed! You can now log in to the site.","Message is not displayed as expected!");
    }
}
