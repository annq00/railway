import Common.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    WebDriver driver;
    @Parameters({"browser"})
    @BeforeMethod
    public void BeforeMethod(String browser){
        System.out.println("Pre-Condition");

        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()+"\\Executables\\chromedriver_84.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath()+"\\Executables\\geckodriver_24.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("Post-Condition");
        driver.quit();
    }

    public void cancelTickets(String status) throws InterruptedException {

        GeneralPage successpage = new GeneralPage(driver);

        MyTicketPage myticketpage = successpage.gotoMyTicketPage(driver);

        myticketpage.cancelTicket(myticketpage.departFrom1,myticketpage.arriveAt1,myticketpage.seatType1,myticketpage.departDate1,status,myticketpage.ticketAmount1);

        Thread.sleep(800);
    }
}
