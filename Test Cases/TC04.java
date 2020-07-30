import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends BaseTest {
    @Test
    public void TC04(){
        System.out.println("TC04: User is redirected to Book ticket page after logging in");

        System.out.println("Step 1: Navigate to Railway's HomePage");
        HomePage homePage = new HomePage(driver);
        homePage.open();

        System.out.println("Step 2: Go to Book Ticket Page");
        GeneralPage newPage1 = homePage.gotoBookticketPage(driver);

        System.out.println("Step 3: Verify that Login Page is displayed");
        String pageHeader1 = newPage1.currentPageHeader(driver);
        Assert.assertEquals(pageHeader1,"Login Page","Book Ticket page is not display as expected!");

        System.out.println("Step 4: Login with a valid account");
        LoginPage loginPage = new LoginPage(driver);
        GeneralPage newPage2 = loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("Step 5: Verify that Book Ticket Page is displayed after login");
        String pageHeader2 = newPage2.currentPageHeader(driver);
        Assert.assertEquals(pageHeader2,"Book ticket","Book Ticket page is not display as expected!");
    }
}
