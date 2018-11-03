package Utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class Abstract_Class_Parallel{

    public static WebDriver driver;
    public static ExtentReports report;
    public static ExtentTest logger;
    public static JavascriptExecutor jse;

    @BeforeSuite
    public void openBrowser (){

        report = new ExtentReports("src\\main\\java\\Report_Folder\\ExtentReport.html", true);



    }

    @Parameters("browser")
    @BeforeMethod
    public void loggerSession(String browser, Method methodName){

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            options.addArguments("start-maximized", "incognito", "disable-infobars");

            driver = new ChromeDriver(options);
        }else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            driver.navigate().to("https://www.firefox.com");
            driver.manage().window().maximize();
        }else if (browser.equalsIgnoreCase("ie")){
            //this is where your ie driver would go
        }else if (browser.equalsIgnoreCase("safari")){
            //this is where your safari driver would go
        }

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        //define the javascript
        jse = (JavascriptExecutor)driver;
        logger=report.startTest(methodName.getName());
        logger.log(LogStatus.INFO, "Automation Test Suite has started. . . . ");
    }

    @AfterMethod()
    public void endLogger(){
        report.endTest(logger);
    }

    @AfterSuite()
    public void closeBrowser(){
        report.flush();
        report.close();
        //driver.quit();
        logger.log(LogStatus.INFO, "Automation Test Suite has Ended. . . . ");

    }

}// end of parent class