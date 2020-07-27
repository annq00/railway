import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends BaseTest {
    @Test
    public void TC01(){
        System.out.println("TC01: User can log into Railway with valid username and password");

        HomePage homepage = new HomePage();
        homepage.Open();

        LoginPage loginpage = homepage.gotoLoginPage();

        String actualMessage = loginpage.Login(Constant.USERNAME,Constant.PASSWORD).getWelcomeMessageLbl().getText();
        String expectedMessage = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMessage,expectedMessage,"Welcome message is not displayed as expected!");
    }
}
