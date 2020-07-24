import Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    @Parameters({"browser"})
    @BeforeMethod
    public void BeforeMethod(String browser){
        System.out.println("Pre-Condition");
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\SATTDN20.01.01\\IdeaProjects\\An_Railway_SeleniumExercise\\Executables\\chromedriver.exe");
            Constant.webdriver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\SATTDN20.01.01\\IdeaProjects\\An_Railway_SeleniumExercise\\Executables\\geckodriver.exe");
            Constant.webdriver = new FirefoxDriver();
        }
        Constant.webdriver.manage().window().maximize();
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("Post-Condition");
        Constant.webdriver.quit();
    }
}
