import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {

    //Elements

    protected WebElement getLinkByDepartAndArriveStation(String linkname, String departstation, String arrivestation){
        return Constant.webdriver.findElement(By.xpath("//td[count(//th[text()='Depart Station']//preceding-sibling::th)+1][text()='"+departstation+"']//ancestor::tr//td[count(//th[text()='Arrive Station']//preceding-sibling::th)+1][text()='"+arrivestation+"']//ancestor::tr//td[count(//th[text()='"+linkname+"']//preceding-sibling::th)+1]//a"));
    }

    //Methods

    public TicketPricePage clickCheckPriceLink(String departstation, String arrivestation){

        js.executeScript("arguments[0].scrollIntoView(true)",getLinkByDepartAndArriveStation("Check Price",departstation,arrivestation));

        getLinkByDepartAndArriveStation("Check Price",departstation,arrivestation).click();
        return new TicketPricePage();
    }

    public BookTicketPage clickBookTicketLink(String departstation, String arrivestation){

        js.executeScript("arguments[0].scrollIntoView(true)",getLinkByDepartAndArriveStation("Book Ticket",departstation,arrivestation));

        getLinkByDepartAndArriveStation("Book Ticket",departstation,arrivestation).click();
        return new BookTicketPage();
    }
}
