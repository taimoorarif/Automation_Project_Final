package Google;

import ReusableObjects.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Test_01_Google_Searh_Result {

    //global or shared variables across methods need to be declared
    //before calling annotations
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito");
        driver = new ChromeDriver(options);
        //timeout using implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void  TestCase1(){
        System.out.println("Navigating to google home page");
        driver.navigate().to("https://www.google.com");
        //enter keyword in google search
        Reusable_Methods.sendKeysMethod(driver, "//*[@name='q']", "Brooklyn", "Search Field");
        //submit on google search
        Reusable_Methods.submitMethod(driver, "//*[@value='Google Search']","Google Search" );

    }

    @Test(dependsOnMethods = "TestCase1")
    public void TestCase2() {
        try {
            String searchResult = driver.findElement(By.xpath("//*[@id='resultStats']")).getText();
            String[] searchNumber = searchResult.split(" ");
            System.out.println("My search number is " + searchNumber[1]);
        } catch (Exception err) {
            System.out.println("Unable to capture text for search result");
        }
    }//

}//end of parent class
