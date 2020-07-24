import Constant.Constant;

public class HomePage extends GeneralPage {

    public HomePage open(){
        Constant.webdriver.navigate().to(Constant.railway_url);
        return this;
    }
}
