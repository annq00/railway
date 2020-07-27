import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends BaseTest {
    @Test
    public void TC14() throws InterruptedException{
        System.out.println("TC14: User can book many tickets at a time");

        HomePage homepage = new HomePage().Open();

        LoginPage loginpage = homepage.gotoLoginPage();

        loginpage.Login(Constant.USERNAME,Constant.PASSWORD).gotoBookticketPage();

        BookTicketPage bookticketpage = new BookTicketPage();

        BookTicketSuccessPage successpage = bookticketpage.BookTicket(Constant.departdate,Constant.departfrom,Constant.arriveat,Constant.seattype,Constant.ticketamount);

        String actualheader = successpage.currentPageHeader();

        Assert.assertEquals(successpage.getSuccessTableColumnText("Depart Date"),Constant.departdate);
        Assert.assertEquals(successpage.getSuccessTableColumnText("Depart Station"),Constant.departfrom);
        Assert.assertEquals(successpage.getSuccessTableColumnText("Arrive Station"),Constant.arriveat);
        Assert.assertEquals(successpage.getSuccessTableColumnText("Seat Type"),Constant.seattype);
        Assert.assertEquals(successpage.getSuccessTableColumnText("Amount"),Constant.ticketamount);

        Assert.assertEquals(actualheader,"Ticket booked successfully!","Success Page is not displayed as expected!");

        MyTicketPage myticketpage = successpage.gotoMyTicketPage();

        myticketpage.CancelTicket(Constant.departfrom,Constant.arriveat,Constant.seattype,Constant.departdate,"New",Constant.ticketamount);

        Thread.sleep(800);
    }


}
