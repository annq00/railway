import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage {

    //Elements

    protected WebElement getTicketPriceTableHeader(){
        return Constant.webdriver.findElement(By.xpath("//tr[@class='TableSmallHeader']//th"));
    }

    public String getTicketPriceBySeat(String seattypecode){
        return Constant.webdriver.findElement(By.xpath("//th[contains(text(),'Price')]//parent::tr//td[count(//td[text()='"+seattypecode+"']//preceding-sibling::td)+1]")).getText();
    }
}
