import Constant.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;

public class BaseTest1 {

    @Parameters({"browser"})
    @BeforeMethod
    public void BeforeMethod(String browser){
        System.out.println("Pre-Condition");
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\SATTDN20.01.01\\IdeaProjects\\An_Railway_SeleniumExercise\\Executables\\chromedriver.exe");
            Constant.WEBDRIVER = new ChromeDriver();

        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\SATTDN20.01.01\\IdeaProjects\\An_Railway_SeleniumExercise\\Executables\\geckodriver.exe");
            Constant.WEBDRIVER = new FirefoxDriver();
        }
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("Post-Condition");
        Constant.WEBDRIVER.quit();
    }
}
