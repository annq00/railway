import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage {

    public TicketPricePage(WebDriver webDriver){
        driver = webDriver;
    }

    //Elements

    protected WebElement getTicketPriceTableHeader(){
        return driver.findElement(By.xpath("//tr[@class='TableSmallHeader']//th"));
    }

    public String getTicketPriceBySeat(String seatTypeCode){
        return driver.findElement(By.xpath("//th[contains(text(),'Price')]//parent::tr//td[count(//td[text()='"+seatTypeCode+"']//preceding-sibling::td)+1]")).getText();
    }
}
