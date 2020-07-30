import Constant.Constant;
import org.openqa.selenium.WebDriver;

public class HomePage extends GeneralPage {

    public HomePage (WebDriver webDriver){
        driver = webDriver;
    }

    public HomePage open(){
        driver.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
}
