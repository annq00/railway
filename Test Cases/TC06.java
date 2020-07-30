import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends BaseTest {
    @Test
    public void TC06(){
        System.out.println("TC06: User is redirected to HomePage after logging out");

        System.out.println("Step 1: Navigate to Railway's HomePage");
        HomePage homePage = new HomePage(driver).open();

        System.out.println("Step 2: Go to Login Page");
        LoginPage loginPage = homePage.gotoLoginPage(driver);

        System.out.println("Step 3: Login with an valid account");
        GeneralPage newPage1 = loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Step 4: Go to Contact Page");
        ContactPage contactPage = newPage1.gotoContactPage(driver);

        System.out.println("Step 5: Log out");
        HomePage newPage2 = contactPage.Logout(driver);

        System.out.println("Step 6: Verify that HomePage is displayed after log out");
        String pageHeader = newPage2.currentPageHeader(driver);
        Assert.assertEquals(pageHeader,"Welcome to Safe Railway","HomePage is not displayed as expected");

        System.out.println("Step 7: Verify that Log Out Tab is not displayed");
        boolean temp = newPage2.getTabsLogout(driver).isEmpty();
        Assert.assertEquals(temp,true,"Log out Tab is displayed!");

   }
}
