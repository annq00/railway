import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends BaseTest {
    @Test
    public void TC01(){
        System.out.println("TC01: User can log into Railway with valid username and password");

        HomePage homepage = new HomePage();
        homepage.open();

        LoginPage loginpage = homepage.gotoLoginPage();

        String actualMessage = loginpage.login(Constant.username,Constant.password).getWelcomeMessageLbl().getText();
        String expectedMessage = "Welcome " + Constant.username;
        Assert.assertEquals(actualMessage,expectedMessage,"Welcome message is not displayed as expected!");
    }
}
