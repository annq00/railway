import Common.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends BaseTest {
    @Test
    public void TC11(){
        System.out.println("TC11: User can't create account while password and PID fields are empty");

        HomePage homepage = new HomePage().open();

        RegisterPage registerpage = homepage.gotoRegisterPage();

        registerpage.CreateAccount(Utilities.generateRandomString(6)+"a@.com","","");

        String actualGeneralErrorMsg = registerpage.getRegisterErrorMsg().getText();
        String actualPasswordErrorMsg = registerpage.getPasswordErrorMsg().getText();
        String actualPIDErrorMsg = registerpage.getPIDErrorMsg().getText();

        Assert.assertEquals(actualGeneralErrorMsg,"There're errors in the form. Please correct the errors and try again.");
        Assert.assertEquals(actualPasswordErrorMsg,"Invalid password length");
        Assert.assertEquals(actualPIDErrorMsg,"Invalid ID length");
    }
}
