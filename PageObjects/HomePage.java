import Constant.Constant;
import org.openqa.selenium.WebDriver;

public class HomePage extends GeneralPage {
    private WebDriver driver;
    public HomePage (WebDriver webDriver){
        this.driver = webDriver;
    }

    public HomePage open(){
        this.driver.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
}
