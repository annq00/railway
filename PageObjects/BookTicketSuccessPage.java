import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookTicketSuccessPage extends GeneralPage {

    public BookTicketSuccessPage (WebDriver webDriver){
        this.driver = webDriver;

    }

    public String getSuccessTableColumnText(String columName){
        return this.driver.findElement(By.xpath("//td[count(//th[text()='"+columName+"']//preceding-sibling::th)+1]")).getText();
    }
}
