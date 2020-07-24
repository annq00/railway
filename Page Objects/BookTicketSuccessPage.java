import Constant.Constant;
import org.openqa.selenium.By;

public class BookTicketSuccessPage extends GeneralPage {

    public String getSuccessTableColumnText(String columname){
        return Constant.webdriver.findElement(By.xpath("//td[count(//th[text()='"+columname+"']//preceding-sibling::th)+1]")).getText();
    }
}
