import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16 extends BaseTest {
    @Test
    public void TC16() throws InterruptedException {

        System.out.println("TC16: User can cancel a ticket");

        HomePage homepage = new HomePage().Open();

        LoginPage loginpage = homepage.gotoLoginPage();

        loginpage.Login(Constant.USERNAME, Constant.PASSWORD).gotoBookticketPage();

        BookTicketPage bookticketpage = new BookTicketPage();

        BookTicketSuccessPage successpage = bookticketpage.BookTicket(Constant.departdate,Constant.departfrom,Constant.arriveat,Constant.seattype,Constant.ticketamount);

        MyTicketPage myticketpage = successpage.gotoMyTicketPage();

        myticketpage.CancelTicket(Constant.departfrom,Constant.arriveat,Constant.seattype,Constant.departdate,"New",Constant.ticketamount);

        Thread.sleep(800);

        Assert.assertTrue(myticketpage.findCancelButtons(Constant.departfrom,Constant.arriveat,Constant.seattype,Constant.departdate,"New",Constant.ticketamount).isEmpty());

    }
}
