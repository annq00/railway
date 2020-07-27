import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15 extends BaseTest {
    @Test
    public void TC15(){
        System.out.println("TC15: 'Ticket price' page displays with ticket details after clicking on 'check price' link in 'Train timetable' page");

        HomePage homepage = new HomePage().Open();

        LoginPage loginpage = homepage.gotoLoginPage();

        TimetablePage timetablepage = loginpage.Login(Constant.USERNAME,Constant.PASSWORD).gotoTimetablePage();

        TicketPricePage ticketpricepage = timetablepage.ClickCheckPriceLink(Constant.checkpricedepartstation,Constant.checkpricearrivestation);

        String actualpageheader = ticketpricepage.currentPageHeader();

        String actualtableheader = ticketpricepage.getTicketPriceTableHeader().getText();

        String expectedtableheader = "Ticket price from "+Constant.checkpricedepartstation+" to "+Constant.checkpricearrivestation;


        Assert.assertEquals(actualpageheader,"Ticket Price","Ticket Price is not displayed as expected!");
        Assert.assertEquals(actualtableheader,expectedtableheader,"Check Price Table Header is not displayed as expected!");
        Assert.assertEquals(ticketpricepage.getTicketPriceBySeat("HS"),"310000");
        Assert.assertEquals(ticketpricepage.getTicketPriceBySeat("SS"),"335000");
        Assert.assertEquals(ticketpricepage.getTicketPriceBySeat("SSC"),"360000");
        Assert.assertEquals(ticketpricepage.getTicketPriceBySeat("HB"),"410000");
        Assert.assertEquals(ticketpricepage.getTicketPriceBySeat("SB"),"460000");
        Assert.assertEquals(ticketpricepage.getTicketPriceBySeat("SBC"),"510000");
    }
}
