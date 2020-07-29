import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends BaseTest {
    @Test
    public void TC14() throws InterruptedException{
        System.out.println("TC14: User can book many tickets at a time");

        HomePage homepage = new HomePage(driver).open();

        LoginPage loginpage = homepage.gotoLoginPage(driver);

        loginpage.login(Constant.USERNAME,Constant.PASSWORD).gotoBookticketPage(driver);

        BookTicketPage bookticketpage = new BookTicketPage(driver);

        BookTicketSuccessPage successpage = bookticketpage.bookTicket(bookticketpage.departDate1,bookticketpage.departFrom1,bookticketpage.arriveAt1,bookticketpage.seatType1,bookticketpage.ticketAmount1);

        String actualheader = successpage.currentPageHeader(driver);

        Assert.assertEquals(successpage.getSuccessTableColumnText("Depart Date"),bookticketpage.departDate1);
        Assert.assertEquals(successpage.getSuccessTableColumnText("Depart Station"),bookticketpage.departFrom1);
        Assert.assertEquals(successpage.getSuccessTableColumnText("Arrive Station"),bookticketpage.arriveAt1);
        Assert.assertEquals(successpage.getSuccessTableColumnText("Seat Type"),bookticketpage.seatType1);
        Assert.assertEquals(successpage.getSuccessTableColumnText("Amount"),bookticketpage.ticketAmount1);

        Assert.assertEquals(actualheader,"Ticket booked successfully!","Success Page is not displayed as expected!");

        cancelTickets("New");
    }


}
