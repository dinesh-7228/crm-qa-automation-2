package Pages.CRMPages.Customers;
import Data.AccountData;
import FrameWork.BrowserAction;
import FrameWork.TestListner;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

@Listeners(TestListner.class)
public class AttritionTrackerPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AttritionTrackerPage(WebDriver driver) {
        this.driver = driver;
    }
@Step("Customer validation || Customer-Attrition Tracker validation")
public boolean AttritionTrackerData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
//    Boolean CustomerLinkPresent = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
//    BooleanAsseration(CustomerLinkPresent, extentTest, "Customer Link Present", "Customer Link Not Present");
//    System.out.println("Customer Link validation success");
//    Thread.sleep(2000);
//    Boolean CustomerLinkClick = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
//    click(GetLocator("CustomerLink"));
//    BooleanAsseration(CustomerLinkClick, extentTest, "Customer Link is clickable", "Customer Link Not clickable");
//    System.out.println("Customer Link  Click validation success");
//    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("AttritionTrackerLink"), extentTest);
   // Boolean AttritionTrackerLinkPresent = driver.findElement(GetLocator("AttritionTrackerLink").getBy()).isDisplayed();
   // BooleanAsseration(AttritionTrackerLinkPresent, extentTest, "AttritionTrackerLinkPresent Present", "AttritionTrackerLinkPresent Not Present");
   // System.out.println("AttritionTrackerLinkPresent validation success");
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("AttritionTrackerLink"), extentTest);
   // Boolean AttritionTrackerLinkClick = driver.findElement(GetLocator("AttritionTrackerLink").getBy()).isDisplayed();
    click(GetLocator("AttritionTrackerLink"), extentTest);
   // BooleanAsseration(AttritionTrackerLinkClick, extentTest, "AttritionTracker Link is clickable", "AttritionTracker Link Not clickable");
   // System.out.println("AttritionTracker Link  Click validation success");
    Thread.sleep(15000);
    ISLocatorDisplayed(GetLocator("AttritionTrackerFromDate"), extentTest);
    //Boolean AttritionTrackerFromDateSelect = driver.findElement(GetLocator("AttritionTrackerFromDate").getBy()).isDisplayed();
    click(GetLocator("AttritionTrackerFromDate"), extentTest);
    Thread.sleep(4000);
    click(GetLocator("DateSelect"), extentTest);
    Thread.sleep(4000);
    //BooleanAsseration(AttritionTrackerFromDateSelect, extentTest, "User able to select Attrition Tracker From Date of Customer", "User not able to select Attrition Tracker From Date of Customer");
    //System.out.println("Select Attrition Tracker From Date of Customer validation success");
    
//    Boolean AttritionTrackerArea = driver.findElement(GetLocator("SetPenaltyArea").getBy()).isDisplayed();
//    click(GetLocator("SetPenaltyArea"));
//    Thread.sleep(3000);
//    click(GetLocator("SelectActiveStatus"));
//    Thread.sleep(3000);
//    BooleanAsseration(AttritionTrackerArea, extentTest, "User able to enter AttritionTracker Area", "User not able to enter AttritionTracker Area");
//    System.out.println("AttritionTracker Area validation success");
    
    ISLocatorDisplayed(GetLocator("AttritionTrackerSearchBtn"), extentTest);
   // Boolean AttritionTrackerSearchBtn = driver.findElement(GetLocator("AttritionTrackerSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AttritionTrackerSearchBtn"), extentTest);
   // BooleanAsseration(AttritionTrackerSearchBtn, extentTest, "User able to click AttritionTracker Search Button", "User not able to click AttritionTracker Search Button");
   // System.out.println("AttritionTracker Search Button validation success");
    Thread.sleep(30000);
        return true;
    }
}