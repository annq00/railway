import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15 extends BaseTest {
    @Test
    public void TC15(){
        System.out.println("TC15: 'Ticket price' page displays with ticket details after clicking on 'check price' link in 'Train timetable' page");

        System.out.println("Step 1: Navigate to Railway's HomePage");
        HomePage homePage = new HomePage(driver).open();

        System.out.println("Step 2: Go to Login Page");
        LoginPage loginPage = homePage.gotoLoginPage(driver);

        System.out.println("Step 3: Login with a registered account");
        GeneralPage newPage = loginPage.login(Constant.USERNAME,Constant.PASSWORD).gotoTimetablePage(driver);

        System.out.println("Step 4: Go to Timetable Page");
        TimetablePage timetablePage = newPage.gotoTimetablePage(driver);

        System.out.println("Step 4: Click a 'check price' link");
        TicketPricePage ticketPricePage = timetablePage.clickCheckPriceLink(timetablePage.departStation,timetablePage.arriveStation);

        System.out.println("Step 5: Verify that Ticket Price Page is displayed");
        String actualPageHeader = ticketPricePage.currentPageHeader(driver);
        String actualTableHeader = ticketPricePage.getTicketPriceTableHeader().getText();
        String expectedTableHeader = "Ticket price from "+ticketPricePage.departStation+" to "+ticketPricePage.arriveStation;
        Assert.assertEquals(actualPageHeader,"Ticket Price","Ticket Price is not displayed as expected!");
        Assert.assertEquals(actualTableHeader,expectedTableHeader,"Check Price Table Header is not displayed as expected!");

        System.out.println("Step 6: Verify that Ticket details are displayed correctly");
        Assert.assertEquals(ticketPricePage.getTicketPriceBySeat("HS"),ticketPricePage.priceHS);
        Assert.assertEquals(ticketPricePage.getTicketPriceBySeat("SS"),ticketPricePage.priceSS);
        Assert.assertEquals(ticketPricePage.getTicketPriceBySeat("SSC"),ticketPricePage.priceSSC);
        Assert.assertEquals(ticketPricePage.getTicketPriceBySeat("HB"),ticketPricePage.priceHB);
        Assert.assertEquals(ticketPricePage.getTicketPriceBySeat("SB"),ticketPricePage.priceSB);
        Assert.assertEquals(ticketPricePage.getTicketPriceBySeat("SBC"),ticketPricePage.priceSBC);
    }
}
