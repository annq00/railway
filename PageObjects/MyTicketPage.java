import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MyTicketPage extends GeneralPage {
    
    public MyTicketPage(WebDriver webDriver){
        driver = webDriver;
    }

    //Elements


    protected WebElement getDepartStationBox(){
        fluentWait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='FilterDpStation']")));
        return driver.findElement(By.xpath("//select[@name='FilterDpStation']"));
    }

    protected WebElement getArriveStationBox(){
        fluentWait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='FilterArStation']")));
        return driver.findElement(By.xpath("//select[@name='FilterArStation']"));
    }

    protected WebElement getDepartDateBox(){
        fluentWait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='FilterDpDate']")));
        return driver.findElement(By.xpath("//input[@name = 'FilterDpDate']"));
    }

    protected WebElement getStatusBox(){
        fluentWait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='FilterStatus']")));
        return driver.findElement(By.xpath("//select[@name='FilterStatus']"));
    }

    protected WebElement getApplyFilterBtn(){
        fluentWait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value = 'Apply filter']")));
        return driver.findElement(By.xpath("//input[@value = 'Apply filter']"));
    }

    protected WebElement getCancelBtn(String departStation, String arriveStation, String seatType, String departDate, String status, String amount){
        return driver.findElement(By.xpath("//td[count(//tr[@class='TableSmallHeader']//th[text()='Depart Station']//preceding-sibling::th)+1][text()='"+departStation+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Arrive Station']//preceding-sibling::th)+1][text()='"+arriveStation+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Seat Type']//preceding-sibling::th)+1][text()='"+seatType+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Depart Date']//preceding-sibling::th)+1][text()='"+departDate+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Amount']//preceding-sibling::th)+1][text()='"+amount+"']//parent::tr//input[@value='Cancel']"));
    }

    protected List<WebElement> findCancelButtons (String departstation, String arriveStation, String seatType, String departDate, String status, String amount){
        return driver.findElements(By.xpath("//td[count(//tr[@class='TableSmallHeader']//th[text()='Depart Station']//preceding-sibling::th)+1][text()='"+departstation+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Arrive Station']//preceding-sibling::th)+1][text()='"+arriveStation+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Seat Type']//preceding-sibling::th)+1][text()='"+seatType+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Depart Date']//preceding-sibling::th)+1][text()='"+departDate+"']//parent::tr//td[count(//tr[@class='TableSmallHeader']//th[text()='Amount']//preceding-sibling::th)+1][text()='"+amount+"']//parent::tr//input[@value='Cancel']"));
    }

    //Methods

    public void searchTicket(String departStation, String arriveStation, String departDate, String status) throws InterruptedException {

        selectCombobox(getDepartStationBox(),departStation);
        selectCombobox(getArriveStationBox(),arriveStation);
        getDepartDateBox().clear();
        getDepartDateBox().sendKeys(departDate);
        selectCombobox(getStatusBox(),status);

        getApplyFilterBtn().click();
    }

    public void cancelTicket(String departStation, String arriveStation, String seatType, String departDate, String status, String amount){

        WebElement cancelButton = getCancelBtn(departStation,arriveStation,seatType,departDate,status,amount);

        fluentWait(driver).until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButton.click();

        fluentWait(driver).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();


    }
}
