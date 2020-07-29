import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends BaseTest {
    @Test
    public void TC04(){
        System.out.println("TC04: User is redirected to Book ticket page after logging in");

        HomePage hompage = new HomePage(driver);
        hompage.open();

        String pageheader1 = hompage.gotoBookticketPage(driver).currentPageHeader(driver);

        if(pageheader1.equalsIgnoreCase("Login page")){
            LoginPage loginpage = new LoginPage(driver);
            String pageheader2 = loginpage.login(Constant.USERNAME,Constant.PASSWORD).currentPageHeader(driver);
            Assert.assertEquals(pageheader2,"Book ticket","Book Ticket page is not display as expected!");
        }
        else {
            System.out.println("Login page is not displayed!");
            Assert.assertEquals(1,2);
        }
    }
}
