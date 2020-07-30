import Common.Utilities;
import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC05 extends BaseTest {

    @Test
    public void TC05(){
        System.out.println("TC05: System shows message when user enters wrong password several times");

        System.out.println("Step 1: Navigate to Railway's HomePage");
        HomePage homePage = new HomePage(driver);
        homePage.open();

        System.out.println("Step 2: Go to Login Page");
        LoginPage loginPage = homePage.gotoLoginPage(driver);

        System.out.println("Step 3: Login with a wrong password 4 times");
        loginPage.loginMultipleTime(Constant.SMALLNUM,Constant.USERNAME,Utilities.generateRandomString(Constant.SMALLNUM));

        System.out.println("Step 4: Verify that alert message is displayed as expected");
        String actualMessage = loginPage.getGeneralErrorMsg().getText();
        String expectedMessage = "You have used "+Constant.SMALLNUM+" out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMessage,expectedMessage,"Error message is not displayed as expected!");
    }
}
