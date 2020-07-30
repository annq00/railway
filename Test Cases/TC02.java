import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends BaseTest {
    @Test
    public void TC02 (){
        System.out.println("TC02: User can't login with blank 'Username' textbox");

        System.out.println("Step 1: Navigate to Railway's HomePage");
        HomePage homepage = new HomePage(driver);
        homepage.open();

        System.out.println("Step 2: Go to Login Page");
        LoginPage loginpage = homepage.gotoLoginPage(driver);

        System.out.println("Step 3: Login with blank username");
        loginpage.login("", Constant.PASSWORD);

        System.out.println("Step 4: Verify that login error message is displayed as expected");
        String actualMessage = loginpage.getGeneralErrorMsg().getText();
        String expectedMessage = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMessage,expectedMessage,"Error message is not displayed as expected!");

    }
}
