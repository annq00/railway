import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookTicketPage extends GeneralPage {

    //Elements
    protected WebElement getDepartDateBox() {
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name='Date']"));
    }

    protected WebElement getDepartFromBox(){
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name='DepartStation']"));
    }

    protected  WebElement getArriveAtBox(){
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name='ArriveStation']"));
    }

    protected  WebElement getSeatTypeBox(){
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name='SeatType']"));
    }

    protected  WebElement getTicketAmountBox(){
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name='TicketAmount']"));
    }

    protected  WebElement getBookTicketBtn(){

        return Constant.WEBDRIVER.findElement(By.xpath("//input"));
    }


    //Methods
    public BookTicketSuccessPage BookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount){

        js.executeScript("arguments[0].scrollIntoView(true)",getPageFooter());

        SelectCombobox(getDepartDateBox(),departDate);
        SelectCombobox(getDepartFromBox(),departFrom);
        SelectCombobox(getSeatTypeBox(),seatType);
        SelectCombobox(getTicketAmountBox(),ticketAmount);
        SelectCombobox(getArriveAtBox(),arriveAt);

        wait.until(ExpectedConditions.elementToBeClickable(getBookTicketBtn()));
        getBookTicketBtn().click();

        return new BookTicketSuccessPage();
    }

}
