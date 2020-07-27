import Constant.Constant;

public class HomePage extends GeneralPage {

    public HomePage Open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
}
