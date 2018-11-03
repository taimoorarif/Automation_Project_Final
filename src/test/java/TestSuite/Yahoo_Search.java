package TestSuite;

import ReusableObjects.Reusable_Methods;
import ReusableObjects.Reusable_Methods_Loggers;
import Utilities.Abstract_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Yahoo_Search extends Abstract_Class{


    @Test
    public void YahooSearchResult() throws InterruptedException, IOException {
        //start the test
        //logger = report.startTest(" Yahoo Search Result");
        //Navigate to yahoo homepage
        Reusable_Methods_Loggers.navigate(logger, driver, "https://www.yahoo.com");
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

}//
