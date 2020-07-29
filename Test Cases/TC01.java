import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends BaseTest {
    @Test
    public void TC01(){
        System.out.println("TC01: User can log into Railway with valid username and password");
        HomePage homepage = new HomePage(driver);
        homepage.open();

        LoginPage loginpage = homepage.gotoLoginPage(driver);

        String actualMessage = loginpage.login(Constant.USERNAME,Constant.PASSWORD).getWelcomeMessageLbl(driver).getAttribute("innerText").trim();
        String expectedMessage = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMessage,expectedMessage,"Welcome message is not displayed as expected!");
    }
}
