import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends BaseTest {
    @Test
    public void TC03(){
        System.out.println("TC03: User cannot log into Railway with invalid password");

        HomePage hompage = new HomePage(driver);
        hompage.open();

        LoginPage loginpage = hompage.gotoLoginPage(driver);
        loginpage.login(Constant.USERNAME,"111");

        String actualMessage = loginpage.getGeneralErrorMsg().getText();
        String expectedMessage = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMessage,expectedMessage,"Error message is not displayed as expected!");

    }
}
