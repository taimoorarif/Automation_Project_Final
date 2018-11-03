package Yahoo;

import ReusableObjects.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Yahoo_Search_Result {

    /*
    1. Navigate to yahoo
    2. Verify the homepage title as Yahoo
    3. Verify the count of text links exists on home page
    4. Enter a keyword on search field
    5. Click on search
    6. Scroll to bottom for search result
    7. Capture search result
    8. Send it to Extent Report
     */

    //Declare all the global variables before annotation methds
    WebDriver driver;
    ExtentReports report;
    ExtentTest logger;



    @BeforeSuite
    public void openBrowser(){

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito");
        driver = new ChromeDriver(options);
        //timeout using implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //define the report path
        report = new ExtentReports("src\\main\\java\\Report_Folder" + UUID.randomUUID() + ".html",true);

    }//end of before suite

    @AfterSuite
    public void closeBrowser(){
    }//end of after suite

    @Test
    public void YahooSearchResult() throws InterruptedException, IOException {
        //start the test
        logger = report.startTest(" Yahoo Search Result");
        //Navigate to yahoo homepage
        Reusable_Methods_Loggers.navigate(logger, driver, "https//www.yahoo.com");
        //verify the homepage title
        String yahooTitle= driver.getTitle();
        if (yahooTitle.equalsIgnoreCase("Yahoo")) {

            logger.log(LogStatus.PASS, "The yahoo title matches");

        } else {

            logger.log(LogStatus.FAIL, "The yahoo title doesn't match " + yahooTitle);

        }


        //verify the list count for the link

        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'Mstart(')]"));

        logger.log(LogStatus.INFO, "The link count is " + linkCount.size());


        //enter a keyword on a search field

        Reusable_Methods_Loggers.sendKeysMethod(logger, driver, "//*[@name='p']", "Brooklyn", "Search Field");


        //click on search icon

        Reusable_Methods_Loggers.clickMethod(logger, driver, "//*[@id='uh-search-button']", "Search Icon");


        //define javascrip executor

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //scroll to the bottom of the page

        logger.log(LogStatus.INFO, "Scrolling to the bottom of the search result page");

        Thread.sleep(1500);

        jse.executeScript("scroll(0,2000)");




    }//end of Test


}// end of parent class
