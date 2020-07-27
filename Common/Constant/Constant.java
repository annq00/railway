package Constant;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String USERNAME ="test01@a.com";
    public static final String PASSWORD ="11111111";
    public static final String NEWPASSWORD = "22222222";
    public static final String RAILWAY_URL = "http://railway.somee.com/";

    public static final String departdate = "8/18/2020";
    public static final String departfrom = "Nha Trang";
    public static final String arriveat  = "Sài Gòn";
    public static final String seattype = "Soft seat with air conditioner";
    public static final String ticketamount = "5";

    public static final String checkpricedepartstation = "Đà Nẵng";
    public static final String checkpricearrivestation = "Sài Gòn";
}
