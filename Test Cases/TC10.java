import Common.Utilities;
import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends BaseTest {
    @Test
    public void TC10(){
        System.out.println("TC10: User can't create account with an already in-use email");

        HomePage homepage = new HomePage().open();

        RegisterPage registerpage = homepage.gotoRegisterPage();

        registerpage.CreateAccount(Constant.username,Constant.password, Utilities.generateRandomString(10));

        String actualMsg  = registerpage.getRegisterErrorMsg().getText();
        String expectedMsg = "This email address is already in use.";

        Assert.assertEquals(actualMsg,expectedMsg,"Actual Message is not displayed as expected message!");

    }
}
