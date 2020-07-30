import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage {

    public BookTicketPage(WebDriver webDriver){
        driver = webDriver;
    }


    //Elements
    protected WebElement getDepartDateBox() {
        return this.driver.findElement(By.xpath("//select[@name='Date']"));
    }

    protected WebElement getDepartFromBox(){
        return driver.findElement(By.xpath("//select[@name='DepartStation']"));
    }

    protected  WebElement getArriveAtBox(){
        return driver.findElement(By.xpath("//select[@name='ArriveStation']"));
    }

    protected  WebElement getSeatTypeBox(){
        return driver.findElement(By.xpath("//select[@name='SeatType']"));
    }

    protected  WebElement getTicketAmountBox(){
        return driver.findElement(By.xpath("//select[@name='TicketAmount']"));
    }

    protected  WebElement getBookTicketBtn(){

        return driver.findElement(By.xpath("//input"));
    }


    //Methods
    public BookTicketSuccessPage bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) throws InterruptedException {


        script(driver).executeScript("arguments[0].scrollIntoView(true)",getPageFooter(driver));

        selectCombobox(getDepartDateBox(),departDate);
        selectCombobox(getDepartFromBox(),departFrom);
        selectCombobox(getSeatTypeBox(),seatType);
        selectCombobox(getTicketAmountBox(),ticketAmount);

        Thread.sleep(Constant.SHORTWAIT);

        selectCombobox(getArriveAtBox(),arriveAt);

        fluentWait(driver);
        getBookTicketBtn().click();

        return new BookTicketSuccessPage(driver);
    }

}
