import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {

    //Elements

    protected WebElement getLinkByDepartAndArriveStation(String linkName, String departStation, String arriveStation){
        return Constant.WEBDRIVER.findElement(By.xpath("//td[count(//th[text()='Depart Station']//preceding-sibling::th)+1][text()='"+departStation+"']//ancestor::tr//td[count(//th[text()='Arrive Station']//preceding-sibling::th)+1][text()='"+arriveStation+"']//ancestor::tr//td[count(//th[text()='"+linkName+"']//preceding-sibling::th)+1]//a"));
    }

    //Methods

    public TicketPricePage ClickCheckPriceLink(String departStation, String arriveStation){

        js.executeScript("arguments[0].scrollIntoView(true)",getLinkByDepartAndArriveStation("Check Price",departStation,arriveStation));

        getLinkByDepartAndArriveStation("Check Price",departStation,arriveStation).click();
        return new TicketPricePage();
    }

    public BookTicketPage ClickBookTicketLink(String departStation, String arriveStation){

        js.executeScript("arguments[0].scrollIntoView(true)",getLinkByDepartAndArriveStation("Book Ticket",departStation,arriveStation));

        getLinkByDepartAndArriveStation("Book Ticket",departStation,arriveStation).click();
        return new BookTicketPage();
    }
}
