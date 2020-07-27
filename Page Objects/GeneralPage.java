import Constant.Constant;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;


public class GeneralPage {
    //Elements
    protected JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
    protected WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER,20);
    protected Wait fluentWait = new FluentWait<WebDriver>(Constant.WEBDRIVER).withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(4)).ignoring(StaleElementReferenceException.class);

    protected WebElement getTabHome(){
       return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//span[text()='Home']"));
    }

    protected WebElement getTabLogin(){
       return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//span[text()='Login']"));
    }

    protected WebElement getWelcomeMessageLbl () {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='banner']//strong"));
    }

    protected WebElement getTabBookticket(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//span[text()='Book ticket']"));
    }

    protected WebElement getPageHeader(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']/h1"));
    }

    protected WebElement getTabContact(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//span[text()='Contact']"));
    }

    protected WebElement getTabLogOut(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//span[text()='Log out']"));
    }

    protected WebElement getTabRegister(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//span[text()='Register']"));
    }

    protected WebElement getSuccessfullyCreateAccountMsg(){
        return Constant.WEBDRIVER.findElement(By.xpath("//p[contains(text(),'Registration Confirmed')]"));
    }

    protected WebElement getChangePasswordTab(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//span[text()='Change password']"));

    }

    protected  WebElement getTimetableTab(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//span[text()='Timetable']"));
    }

    protected WebElement getMyTicketTab(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//span[text()='My ticket']"));
    }

    protected WebElement getPageFooter(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("#footer"));
    }

    //Methods

    public HomePage gotoHomePage(){
        getTabHome().click();
        return new HomePage();
    }

    public LoginPage gotoLoginPage(){
        getTabLogin().click();
        return new LoginPage();
    }

    public GeneralPage gotoBookticketPage(){
        getTabBookticket().click();
        return new GeneralPage();
    }

    public ContactPage gotoContactPage(){
        getTabContact().click();
        return new ContactPage();
    }

    public HomePage Logout(){
        getTabLogOut().click();
        return new HomePage();
    }

    public RegisterPage gotoRegisterPage(){
        getTabRegister().click();
        return new RegisterPage();
    }

    public ChangePasswordPage gotoChangePasswordPage(){
        getChangePasswordTab().click();
        return new ChangePasswordPage();

    }

    public TimetablePage gotoTimetablePage(){
        getTimetableTab().click();
        return new TimetablePage();
    }

    public MyTicketPage gotoMyTicketPage(){
        getMyTicketTab().click();
        return new MyTicketPage();
    }

    public String currentPageHeader(){
        return getPageHeader().getText();
    }

    public void SelectCombobox(WebElement comboBox, String value){
        wait.until(ExpectedConditions.elementToBeClickable(comboBox));
        Select selectBox = new Select(comboBox);
        fluentWait.until(ExpectedConditions.elementToBeClickable(comboBox));
        selectBox.selectByVisibleText(value);
    }


}
