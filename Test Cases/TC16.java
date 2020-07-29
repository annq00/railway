import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16 extends BaseTest {
    @Test
    public void TC16() throws InterruptedException {

        System.out.println("TC16: User can cancel a ticket");

        HomePage homepage = new HomePage(driver).open();

        LoginPage loginpage = homepage.gotoLoginPage(driver);

        loginpage.login(Constant.USERNAME, Constant.PASSWORD).gotoBookticketPage(driver);

        BookTicketPage bookticketpage = new BookTicketPage(driver);

        BookTicketSuccessPage successpage = bookticketpage.bookTicket(bookticketpage.departDate2,bookticketpage.departFrom2,bookticketpage.arriveAt2,bookticketpage.seatType2,bookticketpage.ticketAmount2);

        MyTicketPage myticketpage = successpage.gotoMyTicketPage(driver);

        myticketpage.cancelTicket(myticketpage.departFrom2,myticketpage.arriveAt2,myticketpage.seatType2,myticketpage.departDate2,"New",myticketpage.ticketAmount2);

        Thread.sleep(800);

        Assert.assertTrue(myticketpage.findCancelButtons(myticketpage.departFrom2,myticketpage.arriveAt2,myticketpage.seatType2,myticketpage.departDate2,"New",myticketpage.ticketAmount2).isEmpty());

    }
}
