import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {

    //Elements
    protected WebElement getDepartDateBox() {
        return Constant.webdriver.findElement(By.xpath("//select[@name='Date']"));
    }

    protected WebElement getDepartFromBox(){
        return Constant.webdriver.findElement(By.xpath("//select[@name='DepartStation']"));
    }

    protected  WebElement getArriveAtBox(){
        return Constant.webdriver.findElement(By.xpath("//select[@name='ArriveStation']"));
    }

    protected  WebElement getSeatTypeBox(){
        return Constant.webdriver.findElement(By.xpath("//select[@name='SeatType']"));
    }

    protected  WebElement getTicketAmountBox(){
        return Constant.webdriver.findElement(By.xpath("//select[@name='TicketAmount']"));
    }

    protected  WebElement getBookTicketBtn(){

        return Constant.webdriver.findElement(By.xpath("//input"));
    }


    //Methods
    public BookTicketSuccessPage bookticket(String departdate, String departfrom, String arriveat, String seattype, String ticketamount){

        js.executeScript("arguments[0].scrollIntoView(true)",Constant.webdriver.findElement(By.cssSelector("#footer")));

        selectCombobox(getDepartDateBox(),departdate);
        selectCombobox(getDepartFromBox(),departfrom);
        selectCombobox(getSeatTypeBox(),seattype);
        selectCombobox(getTicketAmountBox(),ticketamount);
        selectCombobox(getArriveAtBox(),arriveat);

        wait.until(ExpectedConditions.elementToBeClickable(getBookTicketBtn()));
        getBookTicketBtn().click();

        return new BookTicketSuccessPage();
    }

}
