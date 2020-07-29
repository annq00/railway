import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15 extends BaseTest {
    @Test
    public void TC15(){
        System.out.println("TC15: 'Ticket price' page displays with ticket details after clicking on 'check price' link in 'Train timetable' page");

        HomePage homepage = new HomePage(driver).open();

        LoginPage loginpage = homepage.gotoLoginPage(driver);

        TimetablePage timetablepage = loginpage.login(Constant.USERNAME,Constant.PASSWORD).gotoTimetablePage(driver);

        TicketPricePage ticketpricepage = timetablepage.clickCheckPriceLink(timetablepage.departStation,timetablepage.arriveStation);

        String actualpageheader = ticketpricepage.currentPageHeader(driver);

        String actualtableheader = ticketpricepage.getTicketPriceTableHeader().getText();

        String expectedtableheader = "Ticket price from "+ticketpricepage.departStation+" to "+ticketpricepage.arriveStation;


        Assert.assertEquals(actualpageheader,"Ticket Price","Ticket Price is not displayed as expected!");
        Assert.assertEquals(actualtableheader,expectedtableheader,"Check Price Table Header is not displayed as expected!");
        Assert.assertEquals(ticketpricepage.getTicketPriceBySeat("HS"),ticketpricepage.priceHS);
        Assert.assertEquals(ticketpricepage.getTicketPriceBySeat("SS"),ticketpricepage.priceSS);
        Assert.assertEquals(ticketpricepage.getTicketPriceBySeat("SSC"),ticketpricepage.priceSSC);
        Assert.assertEquals(ticketpricepage.getTicketPriceBySeat("HB"),ticketpricepage.priceHB);
        Assert.assertEquals(ticketpricepage.getTicketPriceBySeat("SB"),ticketpricepage.priceSB);
        Assert.assertEquals(ticketpricepage.getTicketPriceBySeat("SBC"),ticketpricepage.priceSBC);
    }
}
