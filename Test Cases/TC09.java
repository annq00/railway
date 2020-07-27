import Common.Utilities;
import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends BaseTest {

    @Test
    public void TC09(){
        System.out.println("User can't change password when 'New Password' and 'Confirm Password' are different.");

        HomePage hompage = new HomePage().Open();

        LoginPage loginpage = hompage.gotoLoginPage();

        ChangePasswordPage changepasswordpage = loginpage.Login(Constant.USERNAME, Constant.PASSWORD).gotoChangePasswordPage();

        changepasswordpage.ChangePassword(Constant.PASSWORD,Constant.NEWPASSWORD, Utilities.generateRandomString(8));

        String actualMsg = changepasswordpage.getChangePasswordMsg().getText();

        String expectedMsg = "Password change failed. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg,expectedMsg,"Actual Message is not displayed as expected message");
    }
}
