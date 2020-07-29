import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookTicketPage extends GeneralPage {

    public BookTicketPage(WebDriver webDriver){
        this.driver = webDriver;
    }


    //Elements
    protected WebElement getDepartDateBox() {
        return this.driver.findElement(By.xpath("//select[@name='Date']"));
    }

    protected WebElement getDepartFromBox(){
        return this.driver.findElement(By.xpath("//select[@name='DepartStation']"));
    }

    protected  WebElement getArriveAtBox(){
        return this.driver.findElement(By.xpath("//select[@name='ArriveStation']"));
    }

    protected  WebElement getSeatTypeBox(){
        return this.driver.findElement(By.xpath("//select[@name='SeatType']"));
    }

    protected  WebElement getTicketAmountBox(){
        return this.driver.findElement(By.xpath("//select[@name='TicketAmount']"));
    }

    protected  WebElement getBookTicketBtn(){

        return this.driver.findElement(By.xpath("//input"));
    }


    //Methods
    public BookTicketSuccessPage bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) throws InterruptedException {


        script(driver).executeScript("arguments[0].scrollIntoView(true)",getPageFooter(this.driver));

        selectCombobox(driver,getDepartDateBox(),departDate);
        selectCombobox(driver,getDepartFromBox(),departFrom);
        selectCombobox(driver,getSeatTypeBox(),seatType);
        selectCombobox(driver,getTicketAmountBox(),ticketAmount);
        selectCombobox(driver,getArriveAtBox(),arriveAt);

        wait(driver).until(ExpectedConditions.elementToBeClickable(getBookTicketBtn()));
        getBookTicketBtn().click();

        return new BookTicketSuccessPage(this.driver);
    }

}
