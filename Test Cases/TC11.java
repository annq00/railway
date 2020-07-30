import Common.Utilities;
import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends BaseTest {
    @Test
    public void TC11(){
        System.out.println("TC11: User can't create account while password and PID fields are empty");

        System.out.println("Step 1: Navigate to Railway's HomePage");
        HomePage homePage = new HomePage(driver).open();

        System.out.println("Step 2: Go to Register Page");
        RegisterPage registerPage = homePage.gotoRegisterPage(driver);

        System.out.println("Step 3: Create an account with blank password field and blank PID field");
        registerPage.createAccount(Utilities.generateRandomString(Constant.SMALLNUM)+"a@.com","","");

        System.out.println("Step 4: Verify that error message about invalid password and PID are displayed as expected");
        String actualGeneralErrorMsg = registerPage.getRegisterErrorMsg().getText();
        String actualPasswordErrorMsg = registerPage.getPasswordErrorMsg().getText();
        String actualPIDErrorMsg = registerPage.getPIDErrorMsg().getText();
        Assert.assertEquals(actualGeneralErrorMsg,"There're errors in the form. Please correct the errors and try again.");
        Assert.assertEquals(actualPasswordErrorMsg,"Invalid password length");
        Assert.assertEquals(actualPIDErrorMsg,"Invalid ID length");
    }
}
