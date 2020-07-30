import Common.Utilities;
import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends BaseTest {
    @Test
    public void TC10(){
        System.out.println("TC10: User can't create account with an already in-use email");

        System.out.println("Step 1: Navigate to Railway's HomePage");
        HomePage homePage = new HomePage(driver).open();

        System.out.println("Step 2: Go to Register Page");
        RegisterPage registerPage = homePage.gotoRegisterPage(driver);

        System.out.println("Step 3: Create an account with a registered email");
        registerPage.createAccount(Constant.USERNAME,Constant.PASSWORD, Utilities.generateRandomString(Constant.MEDIUMNUM));

        System.out.println("Step 4: Verify that message about email address is already in use is displayed as expected");
        String actualMsg  = registerPage.getRegisterErrorMsg().getText();
        String expectedMsg = "This email address is already in use.";
        Assert.assertEquals(actualMsg,expectedMsg,"Actual Message is not displayed as expected message!");
    }
}
