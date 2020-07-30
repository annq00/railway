import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends BaseTest {
    @Test
    public void TC01(){
        System.out.println("TC01: User can log into Railway with valid username and password");

        System.out.println("Step 1: Navigate to Railway's HomePage");
        HomePage homepage = new HomePage(driver);
        homepage.open();

        System.out.println("Step 2: Go to Login Page");
        LoginPage loginpage = homepage.gotoLoginPage(driver);

        System.out.println("Step 3: Login with valid account");
        String actualMessage = loginpage.login(Constant.USERNAME,Constant.PASSWORD).getWelcomeMessageLbl(driver).getAttribute("innerText").trim();

        System.out.println("Step 4: Verify that welcome message is displayed as expected");
        String expectedMessage = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMessage,expectedMessage,"Welcome message is not displayed as expected!");
    }
}
