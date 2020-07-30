import Common.Utilities;
import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends BaseTest {

    @Test
    public void TC09(){
        System.out.println("User can't change password when 'New Password' and 'Confirm Password' are different.");

        System.out.println("Step 1: Navigate to Railway's HomePage");
        HomePage homePage = new HomePage(driver).open();

        System.out.println("Step 2: Go to Login Page ");
        LoginPage loginPage = homePage.gotoLoginPage(driver);

        System.out.println("Step 3: Login with a registered account");
        GeneralPage newPage = loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Step 4: Go to Change Password Page");
        ChangePasswordPage changePasswordPage = newPage.gotoChangePasswordPage(driver);

        System.out.println("Step 5: Change Password with New Password and Confirm Password are different");
        changePasswordPage.changePassword(Constant.PASSWORD,Constant.NEWPASSWORD, Utilities.generateRandomString(Constant.MEDIUMNUM));

        System.out.println("Step 6: Verify that error message is displayed as expected");
        String actualMsg = changePasswordPage.getChangePasswordMsg().getText();
        String expectedMsg = "Password change failed. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg,expectedMsg,"Actual Message is not displayed as expected message");
    }
}
