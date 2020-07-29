import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;


public class GeneralPage {

    protected WebDriver driver;
    protected String jsonFile = "testdata.json";
    protected String bookTicket1 = "ticket1";
    protected String bookTicket2 = "ticket2";

    protected String departDate1 = Utilities.getDataTest(jsonFile, bookTicket1,"departdate");
    protected String departFrom1 = Utilities.getDataTest(jsonFile, bookTicket1,"departure");
    protected String arriveAt1 = Utilities.getDataTest(jsonFile, bookTicket1,"arrival");
    protected String seatType1 = Utilities.getDataTest(jsonFile, bookTicket1,"seattype");
    protected String ticketAmount1 = Utilities.getDataTest(jsonFile, bookTicket1,"ticketamount");

    protected String departDate2 = Utilities.getDataTest(jsonFile, bookTicket2,"departdate");
    protected String departFrom2 = Utilities.getDataTest(jsonFile, bookTicket2,"departure");
    protected String arriveAt2 = Utilities.getDataTest(jsonFile, bookTicket2,"arrival");
    protected String seatType2 = Utilities.getDataTest(jsonFile, bookTicket2,"seattype");
    protected String ticketAmount2 = Utilities.getDataTest(jsonFile, bookTicket2,"ticketamount");

    protected String checkPrice = "price2";
    protected String departStation = Utilities.getDataTest(jsonFile,checkPrice, "departure");
    protected String arriveStation = Utilities.getDataTest(jsonFile,checkPrice, "arrival");
    protected String priceHS = Utilities.getDataTest(jsonFile,checkPrice, "HS");
    protected String priceSS = Utilities.getDataTest(jsonFile,checkPrice, "SS");
    protected String priceSSC = Utilities.getDataTest(jsonFile,checkPrice, "SSC");
    protected String priceHB = Utilities.getDataTest(jsonFile,checkPrice, "HB");
    protected String priceSB = Utilities.getDataTest(jsonFile,checkPrice, "SB");
    protected String priceSBC = Utilities.getDataTest(jsonFile,checkPrice, "SBC");

    public GeneralPage(WebDriver webDriver){
        this.driver = webDriver;
    }

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        Wait fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
//                .pollingEvery(Duration.ofSeconds(4)).ignoring(StaleElementReferenceException.class);

    public GeneralPage() {
    }

    JavascriptExecutor script(WebDriver webDriver){
        return (JavascriptExecutor) webDriver;
    }

    WebDriverWait wait (WebDriver webDriver){
        return new WebDriverWait(webDriver, 20);
    }

    Wait fluentWait (WebDriver webDriver){
        return new FluentWait<WebDriver>(webDriver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(4)).ignoring(StaleElementReferenceException.class);
    }

    //Elements
    protected WebElement getTabHome(WebDriver webDriver){
       return webDriver.findElement(By.xpath("//div[@id='menu']//span[text()='Home']"));
    }

    protected WebElement getTabLogin(WebDriver webDriver){
       return webDriver.findElement(By.xpath("//div[@id='menu']//span[text()='Login']"));
    }

    protected WebElement getWelcomeMessageLbl (WebDriver webDriver) {
        return webDriver.findElement(By.xpath("//div[@id='banner']//strong"));
    }

    protected WebElement getTabBookticket(WebDriver webDriver){
        return webDriver.findElement(By.xpath("//div[@id='menu']//span[text()='Book ticket']"));
    }

    protected WebElement getPageHeader(WebDriver webDriver){
        return webDriver.findElement(By.xpath("//div[@id='content']/h1"));
    }

    protected WebElement getTabContact(WebDriver webDriver){
        return webDriver.findElement(By.xpath("//div[@id='menu']//span[text()='Contact']"));
    }

    protected WebElement getTabLogOut(WebDriver webDriver){
        return webDriver.findElement(By.xpath("//div[@id='menu']//span[text()='Log out']"));
    }

    protected WebElement getTabRegister(WebDriver webDriver){
        return webDriver.findElement(By.xpath("//div[@id='menu']//span[text()='Register']"));
    }

    protected WebElement getSuccessfullyCreateAccountMsg(WebDriver webDriver){
        return webDriver.findElement(By.xpath("//p[contains(text(),'Registration Confirmed')]"));
    }

    protected WebElement getChangePasswordTab(WebDriver webDriver){
        return webDriver.findElement(By.xpath("//div[@id='menu']//span[text()='Change password']"));

    }

    protected  WebElement getTimetableTab(WebDriver webDriver){
        return webDriver.findElement(By.xpath("//div[@id='menu']//span[text()='Timetable']"));
    }

    protected WebElement getMyTicketTab(WebDriver webDriver){
        return webDriver.findElement(By.xpath("//div[@id='menu']//span[text()='My ticket']"));
    }

    protected WebElement getPageFooter(WebDriver webDriver){
        return webDriver.findElement(By.cssSelector("#footer"));
    }

    protected List<WebElement> getTabsLogout (WebDriver webDriver){
        return webDriver.findElements(By.xpath("//div[@id='menu']//span[text()='Log out']"));
    }

    //Methods



    public HomePage gotoHomePage(WebDriver webDriver){
        getTabHome(webDriver).click();
        return new HomePage(webDriver);
    }

    public LoginPage gotoLoginPage(WebDriver webDriver){
        getTabLogin(webDriver).click();
        return new LoginPage(webDriver);
    }

    public GeneralPage gotoBookticketPage(WebDriver webDriver){
        getTabBookticket(webDriver).click();
        return new GeneralPage(webDriver);
    }

    public ContactPage gotoContactPage(WebDriver webDriver){
        getTabContact(webDriver).click();
        return new ContactPage(webDriver);
    }

    public HomePage Logout(WebDriver webDriver){
        getTabLogOut(webDriver).click();
        return new HomePage(webDriver);
    }

    public RegisterPage gotoRegisterPage(WebDriver webDriver){
        getTabRegister(webDriver).click();
        return new RegisterPage(webDriver);
    }

    public ChangePasswordPage gotoChangePasswordPage(WebDriver webDriver){
        getChangePasswordTab(webDriver).click();
        return new ChangePasswordPage(webDriver);

    }

    public TimetablePage gotoTimetablePage(WebDriver webDriver){
        getTimetableTab(webDriver).click();
        return new TimetablePage(webDriver);
    }

    public MyTicketPage gotoMyTicketPage(WebDriver webDriver){
        getMyTicketTab(webDriver).click();
        return new MyTicketPage(webDriver);
    }

    public String currentPageHeader(WebDriver webDriver){
        return getPageHeader(webDriver).getText();
    }

    public void selectCombobox(WebDriver webDriver, WebElement comboBox, String value) throws InterruptedException {

        wait(webDriver).until(ExpectedConditions.elementToBeClickable(comboBox));
        Select selectBox = new Select(comboBox);

        Thread.sleep(400);

        fluentWait(webDriver).until(ExpectedConditions.elementToBeClickable(comboBox));
        selectBox.selectByVisibleText(value);
    }


}
