import Constant.Constant;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends BaseTest {
    @Test
    public void TC06(){
        System.out.println("TC06: User is redirected to Home page after logging out");
        HomePage homepage = new HomePage().open();

        LoginPage loginpage = homepage.gotoLoginPage();

        ContactPage contactpage = loginpage.login(Constant.username, Constant.password).gotoContactPage();

        HomePage newpage = contactpage.Logout();

        if(Constant.webdriver.findElements(By.xpath("//div[@id='menu']//span[text()='Log out']")).isEmpty()){
            String pageheader = newpage.currentPageHeader();
            Assert.assertEquals(pageheader,"Welcome to Safe Railway","HomePage is not displayed as expected");
        }
        else{
            System.out.println("Log out Tab is displayed!");
            Assert.assertEquals(1,2);
        }
    }

}
