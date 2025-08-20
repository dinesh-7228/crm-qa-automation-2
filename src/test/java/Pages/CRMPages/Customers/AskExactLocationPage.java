package Pages.CRMPages.Customers;

import Data.AccountData;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

//import com.relevantcodes.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTest;

import FrameWork.BrowserAction;
import FrameWork.TestListner;
import io.qameta.allure.Step;

import java.io.IOException;

@Listeners(TestListner.class)
public class AskExactLocationPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AskExactLocationPage (WebDriver driver) {

        this.driver = driver;
        
    }

    
    @Step("Ask Exact Location Validation || Ask Exact Location Page validation")
public boolean AskExactLocationData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {

    /*	Boolean CustomerLinkPresent = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
        BooleanAsseration(CustomerLinkPresent, extentTest, "Customer Link Present", "Customer Link Not Present");
        System.out.println("Customer Link Present validation success");
        Thread.sleep(3000);

        Boolean CustomerLinkClick = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
        click(GetLocator("CustomerLink"));
        BooleanAsseration(CustomerLinkClick, extentTest, "Customer Link is clickable", "Customer Link Not clickable");
        System.out.println("Customer Link Click validation success");
        Thread.sleep(1000);
      */
            ISLocatorDisplayed(GetLocator("AskExactLocationLink"), extentTest);
       // Boolean AskExactLocationLinkPresent = driver.findElement(GetLocator("AskExactLocationLink").getBy()).isDisplayed();
       // BooleanAsseration(AskExactLocationLinkPresent, extentTest, "Ask Exact Location Link Present", "Ask Exact Location Link Not Present");
       // System.out.println("Ask Exact Location Link Present validation success");
        //Thread.sleep(3000);
        ISLocatorDisplayed(GetLocator("AskExactLocationLink"), extentTest);
      //  Boolean AskExactLocationLinkClick = driver.findElement(GetLocator("AskExactLocationLink").getBy()).isDisplayed();
        click(GetLocator("AskExactLocationLink"), extentTest);
       // BooleanAsseration(AskExactLocationLinkClick, extentTest, "Ask Exact Location Link is clickable", "Ask Exact Location Link Not clickable");
       // System.out.println("Ask Exact Location Link Click validation success");
        Thread.sleep(20000);
        ISLocatorDisplayed(GetLocator("AskExactLocationPhoneInput"), extentTest);
      //  Boolean AskExactLocationPhoneInput = driver.findElement(GetLocator("AskExactLocationPhoneInput").getBy()).isDisplayed();
        click(GetLocator("AskExactLocationPhoneInput"), extentTest);
        EnterValue(GetLocator("AskExactLocationPhoneInput"),accountData.getMobile(), extentTest);
      //  BooleanAsseration(AskExactLocationPhoneInput, extentTest, "User able to enter phone number", "User not able to enter phone number");
       // System.out.println("Phone number Validation Success");
        Thread.sleep(2000);
        
        ISLocatorDisplayed(GetLocator("AskExactLocationSearchBtn"), extentTest);
       // Boolean AskExactLocationSearchBtnPresent = driver.findElement(GetLocator("AskExactLocationSearchBtn").getBy()).isDisplayed();
       // BooleanAsseration(AskExactLocationSearchBtnPresent, extentTest, "Search Button Present", "Search Button Not Present");
       // System.out.println("Search Button validation success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("AskExactLocationSearchBtn"), extentTest);
      //  Boolean AskExactLocationSearchBtnClick = driver.findElement(GetLocator("AskExactLocationSearchBtn").getBy()).isDisplayed();
        click(GetLocator("AskExactLocationSearchBtn"), extentTest);
       // BooleanAsseration(AskExactLocationSearchBtnClick, extentTest, "Search Button Clickable", "Search Button Not Clickable");
       // System.out.println("Search Button validation success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("AskExactLocationCheckbox"), extentTest);
       // Boolean AskExactLocationCheckbox = driver.findElement(GetLocator("AskExactLocationCheckbox").getBy()).isDisplayed();
        click(GetLocator("AskExactLocationCheckbox"), extentTest);
        //BooleanAsseration(AskExactLocationCheckbox, extentTest, "User able to click on checkbox", "User not able to click on checkbox");
        //System.out.println("Checkbox Validation Success");
        Thread.sleep(5000);
        ISLocatorDisplayed(GetLocator("AskExactLocationSmsBtn"), extentTest);
       // Boolean AskExactLocationSmsBtnPresent = driver.findElement(GetLocator("AskExactLocationSmsBtn").getBy()).isDisplayed();
       // BooleanAsseration(AskExactLocationSmsBtnPresent, extentTest, "Search Button Present", "Search Button Not Present");
       // System.out.println("Search Button validation success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("AskExactLocationSmsBtn"), extentTest);
      //  Boolean AskExactLocationSmsBtnClick = driver.findElement(GetLocator("AskExactLocationSmsBtn").getBy()).isDisplayed();
        click(GetLocator("AskExactLocationSmsBtn"), extentTest);
       // BooleanAsseration(AskExactLocationSmsBtnClick, extentTest, "Send SMS Button Clickable", "Send SMS Button Not Clickable");
       // System.out.println("Send SMS Button validation success");
        Thread.sleep(2000);
        
        
        return true;
        
    }}


        
        


























