import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends BaseTest {
    @Test
    public void TC14() throws InterruptedException {
        System.out.println("TC14: User can book many tickets at a time");

        System.out.println("Step 1: Navigate to Railway's HomePage");
        HomePage homePage = new HomePage(driver).open();

        System.out.println("Step 2: Go to Login Page");
        LoginPage loginPage = homePage.gotoLoginPage(driver);

        System.out.println("Step 3: Login with registered account");
        GeneralPage newPage = loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("Step 4: Go to Book Ticket Page");
        newPage.gotoBookticketPage(driver);
        BookTicketPage bookTicketPage = new BookTicketPage(driver);

        System.out.println("Step 5: Book 5 tickets at a time");
        BookTicketSuccessPage successPage = bookTicketPage.bookTicket(bookTicketPage.departDate1,bookTicketPage.departFrom1,bookTicketPage.arriveAt1,bookTicketPage.seatType1,bookTicketPage.ticketAmount1);

        System.out.println("Step 6: Verify that Success Page is displayed");
        String actualheader = successPage.currentPageHeader(driver);
        Assert.assertEquals(actualheader,"Ticket booked successfully!","Success Page is not displayed as expected!");

        System.out.println("Step 7: Verify that ticket's detail is displayed correctly");
        Assert.assertEquals(successPage.getSuccessTableColumnText("Depart Date"),bookTicketPage.departDate1);
        Assert.assertEquals(successPage.getSuccessTableColumnText("Depart Station"),bookTicketPage.departFrom1);
        Assert.assertEquals(successPage.getSuccessTableColumnText("Arrive Station"),bookTicketPage.arriveAt1);
        Assert.assertEquals(successPage.getSuccessTableColumnText("Seat Type"),bookTicketPage.seatType1);
        Assert.assertEquals(successPage.getSuccessTableColumnText("Amount"),bookTicketPage.ticketAmount1);

        System.out.println("Step 8: Cancel ticket");
        cancelTickets(bookTicketPage.departFrom1,bookTicketPage.arriveAt1,bookTicketPage.seatType1,bookTicketPage.departDate1,"New",bookTicketPage.ticketAmount1);
    }
}
