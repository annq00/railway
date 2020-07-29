import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends BaseTest {
    @Test
    public void TC02 (){
        System.out.println("TC02: User can't login with blank 'Username' textbox");

        HomePage homepage = new HomePage(driver);
        homepage.open();

        LoginPage loginpage = homepage.gotoLoginPage(driver);
        loginpage.login("", Constant.PASSWORD);

        String actualMessage = loginpage.getGeneralErrorMsg().getText();
        String expectedMessage = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMessage,expectedMessage,"Error message is not displayed as expected!");

    }
}
