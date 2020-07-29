import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends BaseTest {
    @Test
    public void TC06(){
        System.out.println("TC06: User is redirected to Home page after logging out");
        HomePage homepage = new HomePage(driver).open();

        LoginPage loginpage = homepage.gotoLoginPage(driver);

        ContactPage contactpage = loginpage.login(Constant.USERNAME, Constant.PASSWORD).gotoContactPage(driver);

        HomePage newpage = contactpage.Logout(driver);

        if(newpage.getTabsLogout(driver).isEmpty()){
            String pageheader = newpage.currentPageHeader(driver);
            Assert.assertEquals(pageheader,"Welcome to Safe Railway","HomePage is not displayed as expected");
        }
        else{
            System.out.println("Log out Tab is displayed!");
            Assert.assertEquals(1,2);
        }
    }

}
