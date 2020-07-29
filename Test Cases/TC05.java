import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends BaseTest {

    @Test
    public void TC05(){
        System.out.println("TC05: System shows message when user enters wrong password several times");

        HomePage hompage = new HomePage(driver);
        hompage.open();

        LoginPage loginpage = hompage.gotoLoginPage(driver);
        int count = 0;
        while(count < 4 ) {
            loginpage.login(Constant.USERNAME, "111");
            count+=1;
        }
        String actualMessage = loginpage.getGeneralErrorMsg().getText();
        String expectedMessage = "You have used "+ count +" out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        Assert.assertEquals(actualMessage,expectedMessage,"Error message is not displayed as expected!");

    }

}
