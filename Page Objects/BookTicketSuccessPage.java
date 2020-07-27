import Constant.Constant;
import org.openqa.selenium.By;

public class BookTicketSuccessPage extends GeneralPage {

    public String getSuccessTableColumnText(String columName){
        return Constant.WEBDRIVER.findElement(By.xpath("//td[count(//th[text()='"+columName+"']//preceding-sibling::th)+1]")).getText();
    }
}
