import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    @Parameters({"browser"})
    @BeforeClass
    public void BeforeClass(String browser){
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

    @AfterClass
    public void AfterClass(){
        System.out.println("Post-Condition");
        driver.quit();
    }

    public void cancelTickets(String departFrom, String arriveAt, String seatType, String departDate, String status, String ticketAmount) {

        GeneralPage successPage = new GeneralPage(driver);

        MyTicketPage myTicketPage = successPage.gotoMyTicketPage(driver);

        myTicketPage.cancelTicket(departFrom,arriveAt,seatType,departDate,status,ticketAmount);

        myTicketPage.explicitWait(driver).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value = 'Apply filter']")));
    }
}
