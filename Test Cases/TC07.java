import Common.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends BaseTest {
    @Test
    public void TC07(){

        System.out.println("TC07: User can create new account");

        HomePage homepage = new HomePage().Open();

        RegisterPage registerpage = homepage.gotoRegisterPage();

        registerpage.CreateAccount(Utilities.generateRandomString(6)+"@a.com",Utilities.generateRandomString(8),Utilities.generateRandomString(10));

        String successfullMsg = registerpage.getSuccessfullyCreateAccountMsg().getText();

        Assert.assertEquals(successfullMsg,"Registration Confirmed! You can now log in to the site.","Message is not displayed as expected!");

    }

}
