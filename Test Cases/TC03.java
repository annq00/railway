import Common.Utilities;
import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends BaseTest {
    @Test
    public void TC03(){
        System.out.println("TC03: User cannot log into Railway with invalid password");

        System.out.println("Step 1: Navigate to Railway's HomePage");
        HomePage hompage = new HomePage(driver);
        hompage.open();

        System.out.println("Step 2: Go to Login Page");
        LoginPage loginpage = hompage.gotoLoginPage(driver);

        System.out.println("Step 3: Login with an invalid password");
        loginpage.login(Constant.USERNAME, Utilities.generateRandomString(Constant.SMALLNUM));

        System.out.println("Step 4: Verify that login error message is displayed as expected");
        String actualMessage = loginpage.getGeneralErrorMsg().getText();
        String expectedMessage = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMessage,expectedMessage,"Error message is not displayed as expected!");

    }
}
