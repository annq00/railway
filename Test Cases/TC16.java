import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16 extends BaseTest {
    @Test
    public void TC16() throws InterruptedException {
        System.out.println("TC16: User can cancel a ticket");

        System.out.println("Step 1: Navigate to Railway's HomePage");
        HomePage homePage = new HomePage(driver).open();

        System.out.println("Step 2: Go to Login Page");
        LoginPage loginPage = homePage.gotoLoginPage(driver);

        System.out.println("Step 3: Login with registered account");
        GeneralPage newPage = loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("Step 4: Go to Book Ticket Page");
        newPage.gotoBookticketPage(driver);
        BookTicketPage bookTicketPage = new BookTicketPage(driver);

        System.out.println("Step 5: Book a ticket");
        bookTicketPage.bookTicket(bookTicketPage.departDate2,bookTicketPage.departFrom2,bookTicketPage.arriveAt2,bookTicketPage.seatType2,bookTicketPage.ticketAmount2);

        System.out.println("Step 6: Go to My Ticket Page and cancel ticket");
        MyTicketPage myTicketPage = new MyTicketPage(driver);
        cancelTickets(bookTicketPage.departFrom2,bookTicketPage.arriveAt2,bookTicketPage.seatType2,bookTicketPage.departDate2,"New",bookTicketPage.ticketAmount2);

        System.out.println("Step 7: Verify that ticket is canceled successfully");
        Assert.assertTrue(myTicketPage.findCancelButtons(myTicketPage.departFrom2,myTicketPage.arriveAt2,myTicketPage.seatType2,myTicketPage.departDate2,"New",myTicketPage.ticketAmount2).isEmpty());
    }
}
