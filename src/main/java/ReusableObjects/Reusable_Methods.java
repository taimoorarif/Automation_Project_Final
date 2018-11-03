package ReusableObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reusable_Methods {

   //method for clicking on an element

    //method for clicking on an element

    public static void clickMethod(WebDriver driver, String locator, String elementName){
        try{

            System.out.println("Clicking on element " + elementName);

            //store the locator into WebElement variable

            WebElement clickbtn = driver.findElement(By.xpath(locator));

            clickbtn.click();

        }catch (Exception err){

            System.out.println("Unable to click on element " + elementName);

        }//end of try catch

    }//end of click method



    //method for clicking on an element by index

    public static void clickMethodByIndex(WebDriver driver, String locator, int indexNumber, String elementName){



        try{

            System.out.println("Clicking on element " + elementName);

            //store the locator into WebElement variable

            WebElement clickbtn = driver.findElements(By.xpath(locator)).get(indexNumber);

            clickbtn.click();

        }catch (Exception err){

            System.out.println("Unable to click on element " + elementName);

        }//end of try catch

    }//end of click by index method



    //method for submitting on an element

    public static void submitMethod(WebDriver driver, String locator, String elementName){

        try{

            System.out.println("Submitting  on element " + elementName);

            //store the locator into WebElement variable

            WebElement submitBtn = driver.findElement(By.xpath(locator));

            submitBtn.submit();

        }catch (Exception err){

            System.out.println("Unable to Submit on element " + elementName + " " + err);

        }//end of try catch

    }//end of submit method



    //method for entering on an element

    public static void sendKeysMethod(WebDriver driver, String locator, String userInput, String elementName){

        try{

            System.out.println("Entering " + userInput + " in element " + elementName);

            //store the locator into WebElement variable

            WebElement input = driver.findElement(By.xpath(locator));

            input.sendKeys(userInput);

        }catch (Exception err){

            System.out.println("Unable to send info on element " + elementName);

        }//end of try catch

    }//end of Send Keys method



    //method for navigating to a url

    public static void navigate(WebDriver driver, String url) {
        try{
            System.out.println("Navigate to " + url);

            driver.navigate().to(url);

        }catch (Exception err){
            System.out.println("Unable to navigate to " + url);
        }

    }



    //method for Clearing field

    public static void clearMethod(WebDriver driver, String locator, String elementName){
        try{

            System.out.println("Clearing on element " + elementName);

            //store the locator into WebElement variable

            WebElement clrbtn = driver.findElement(By.xpath(locator));

            clrbtn.clear();

        }catch (Exception err){

            System.out.println("Unable to clear on element " + elementName + " " + err);

        }//end of try catch

    }




    //method for selecting a dropdown method by visible text

   /* public static void selectByText (WebDriver driver, String locator, String value, String elementName) {
        try{
            System.out.println("Selecting " + value + " from dropdown " + elementName);
            WebElement element = driver.findElement(By.xpath(locator));
            Select select = new Select(element);
            select.selectByVisibleText(value);

        }catch (Exception err){
            System.out.println("Unable to select value from dropdown " + elementName + " " + err);
        }

    }*/




    //method for getText

    public static String captureText (WebDriver driver, String locator, int indexNumber, String elementName) {
        String textValue = null;
        try {
            System.out.println("Capturing text " + elementName);
            textValue = driver.findElements(By.xpath(locator)).get(indexNumber).getText();

        }catch (Exception err) {
            System.out.println("Unable to capture text " + elementName + " " + err);
        }
        return textValue;

    }


}//end of parent class
