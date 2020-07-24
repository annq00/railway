import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC16 extends BaseTest {
    @Test
    public void TC16() throws InterruptedException {

        System.out.println("TC16: User can cancel a ticket");

        HomePage homepage = new HomePage().open();

        LoginPage loginpage = homepage.gotoLoginPage();

        loginpage.login(Constant.username, Constant.password).gotoBookticketPage();

        BookTicketPage bookticketpage = new BookTicketPage();

        BookTicketSuccessPage successpage = bookticketpage.bookticket(Constant.departdate,Constant.departfrom,Constant.arriveat,Constant.seattype,Constant.ticketamount);

        MyTicketPage myticketpage = successpage.gotoMyTicketPage();

        myticketpage.cancelTicket(Constant.departfrom,Constant.arriveat,Constant.seattype,Constant.departdate,"New",Constant.ticketamount);

        Thread.sleep(800);

        Assert.assertTrue(myticketpage.findCancelButtons(Constant.departfrom,Constant.arriveat,Constant.seattype,Constant.departdate,"New",Constant.ticketamount).isEmpty());

    }
}
