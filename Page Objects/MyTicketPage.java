import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MyTicketPage extends GeneralPage {

    //Elements

    protected WebElement getDepartStationBox(){
        fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='FilterDpStation']")));
        return Constant.webdriver.findElement(By.xpath("//select[@name='FilterDpStation']"));
    }

    protected WebElement getArriveStationBox(){
        fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='FilterArStation']")));
        return Constant.webdriver.findElement(By.xpath("//select[@name='FilterArStation']"));
    }

    protected WebElement getDepartDateBox(){
        fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='FilterDpDate']")));
        return Constant.webdriver.findElement(By.xpath("//input[@name = 'FilterDpDate']"));
    }

    protected WebElement getStatusBox(){
        fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='FilterStatus']")));
        return Constant.webdriver.findElement(By.xpath("//select[@name='FilterStatus']"));
    }

    protected WebElement getApplyFilterBtn(){
        fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value = 'Apply filter']")));
        return Constant.webdriver.findElement(By.xpath("//input[@value = 'Apply filter']"));
    }

    protected WebElement getCancelBtn(String departstation, String arrivestation, String seattype, String departdate, String status, String amount){
        return Constant.webdriver.findElement(By.xpath("//td[count(//tr[@class='TableSmallHeader']//th[text()='Depart Station']//preceding-sibling::th)+1][text()='"+departstation+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Arrive Station']//preceding-sibling::th)+1][text()='"+arrivestation+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Seat Type']//preceding-sibling::th)+1][text()='"+seattype+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Depart Date']//preceding-sibling::th)+1][text()='"+departdate+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Amount']//preceding-sibling::th)+1][text()='"+amount+"']//parent::tr//input[@value='Cancel']"));
    }

    protected List<WebElement> findCancelButtons (String departstation, String arrivestation, String seattype, String departdate, String status, String amount){
        return Constant.webdriver.findElements(By.xpath("//td[count(//tr[@class='TableSmallHeader']//th[text()='Depart Station']//preceding-sibling::th)+1][text()='"+departstation+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Arrive Station']//preceding-sibling::th)+1][text()='"+arrivestation+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Seat Type']//preceding-sibling::th)+1][text()='"+seattype+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Depart Date']//preceding-sibling::th)+1][text()='"+departdate+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Amount']//preceding-sibling::th)+1][text()='"+amount+"']//parent::tr//input[@value='Cancel']"));
    }

    //Methods

    public void searchTicket(String departstation, String arrivestation, String departdate, String status){

        selectCombobox(getDepartStationBox(),departstation);
        selectCombobox(getArriveStationBox(),arrivestation);
        getDepartDateBox().clear();
        getDepartDateBox().sendKeys(departdate);
        selectCombobox(getStatusBox(),status);

        getApplyFilterBtn().click();
    }

    public void cancelTicket(String departstation, String arrivestation, String seattype, String departdate, String status, String amount){

        WebElement cancelButton = getCancelBtn(departstation,arrivestation,seattype,departdate,status,amount);

        fluentwait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButton.click();

        fluentwait.until(ExpectedConditions.alertIsPresent());
        Constant.webdriver.switchTo().alert().accept();


    }
}
