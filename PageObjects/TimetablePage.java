import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {
    
    public TimetablePage (WebDriver webDriver){
        driver = webDriver;
        
    }

    //Elements

    protected WebElement getLinkByDepartAndArriveStation(String linkName, String departStation, String arriveStation){
        return driver.findElement(By.xpath("//td[count(//th[text()='Depart Station']//preceding-sibling::th)+1][text()='"+departStation+"']//ancestor::tr//td[count(//th[text()='Arrive Station']//preceding-sibling::th)+1][text()='"+arriveStation+"']//ancestor::tr//td[count(//th[text()='"+linkName+"']//preceding-sibling::th)+1]//a"));
    }

    //Methods

    public TicketPricePage clickCheckPriceLink(String departStation, String arriveStation){

        script(driver).executeScript("arguments[0].scrollIntoView(true)",getLinkByDepartAndArriveStation("Check Price",departStation,arriveStation));

        getLinkByDepartAndArriveStation("Check Price",departStation,arriveStation).click();
        return new TicketPricePage(driver);
    }

    public BookTicketPage clickBookTicketLink(String departStation, String arriveStation){
        script(driver).executeScript("arguments[0].scrollIntoView(true)",getLinkByDepartAndArriveStation("Book Ticket",departStation,arriveStation));

        getLinkByDepartAndArriveStation("Book Ticket",departStation,arriveStation).click();
        return new BookTicketPage(driver);
    }
}
