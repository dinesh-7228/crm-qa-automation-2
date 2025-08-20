package Pages.CRMPages.Analytics;

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
public class AnalyticsCustomersMonthlyOrderTrack extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsCustomersMonthlyOrderTrack(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-Customer Order Track validation")
public boolean AnalyticCustomerMonthlyOrderTrackData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
//	Boolean AnalyticsLinkPresent = driver.findElement(GetLocator("AnalyticsLink").getBy()).isDisplayed();
//  BooleanAsseration(AnalyticsLinkPresent, extentTest, "Analytics Link Present", "Analytics Link Not Present");
//  System.out.println("Analytics Link validation success");
//  Thread.sleep(2000);
//
//  Boolean AnalyticsLinkClick = driver.findElement(GetLocator("AnalyticsLink").getBy()).isDisplayed();
//  click(GetLocator("AnalyticsLink"));
//  BooleanAsseration(AnalyticsLinkClick, extentTest, "Analytics Link is clickable", "Analytics Link Not clickable");
//  System.out.println("Analytics Link Click validation success");
//  Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("AnalyticCustomerMonthlyOrderTrackLink"), extentTest);
  //  Boolean AnalyticCustomerMonthlyOrderTrackLinkPresent = driver.findElement(GetLocator("AnalyticCustomerMonthlyOrderTrackLink").getBy()).isDisplayed();
  //  BooleanAsseration(AnalyticCustomerMonthlyOrderTrackLinkPresent, extentTest, "AnalyticCustomerMonthlyOrderTrackLink Present", "AnalyticCustomerMonthlyOrderTrackLink Not Present");
    System.out.println("AnalyticCustomerMonthlyOrderTrackLink validation success");
    ISLocatorDisplayed(GetLocator("AnalyticCustomerMonthlyOrderTrackLink"), extentTest);
   // Boolean AnalyticCustomerMonthlyOrderTrackLinkClick = driver.findElement(GetLocator("AnalyticCustomerMonthlyOrderTrackLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticCustomerMonthlyOrderTrackLink"), extentTest);
   // BooleanAsseration(AnalyticCustomerMonthlyOrderTrackLinkClick, extentTest, "AnalyticCustomerMonthlyOrderTrack Link is clickable", "AnalyticCustomerMonthlyOrderTrack Link Not clickable");
   // System.out.println("AnalyticCustomerMonthlyOrderTrack Link  Click validation success");
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("CustomerMonthlyOrderTrackCutOffMonth"), extentTest);
   // Boolean CustomerMonthlyOrderTrackCutOffMonth = driver.findElement(GetLocator("CustomerMonthlyOrderTrackCutOffMonth").getBy()).isDisplayed();
    click(GetLocator("CustomerMonthlyOrderTrackCutOffMonth"), extentTest);
    click(GetLocator("SelectActiveStatus"), extentTest);
   // BooleanAsseration(CustomerMonthlyOrderTrackCutOffMonth, extentTest, "User able to enter Analytics Customer Monthly Order Track Cutoff Month", "User not able to enter Customer Monthly Order Track Cutoff Month");
   // System.out.println("Analytics Customer Order Track Cutoff Month validation success");
    ISLocatorDisplayed(GetLocator("CustomerMonthlyOrderTrackCutOffYear"), extentTest);
 //   Boolean CustomerMonthlyOrderTrackCutOffYear = driver.findElement(GetLocator("CustomerMonthlyOrderTrackCutOffYear").getBy()).isDisplayed();
    click(GetLocator("CustomerMonthlyOrderTrackCutOffYear"), extentTest);
 //   EnterValue(GetLocator("EnterAnalyticCustomerCashbackFranchise"),accountData.getCutOffYear());
    click(GetLocator("SelectFranchiseDropdown"), extentTest);
   // BooleanAsseration(CustomerMonthlyOrderTrackCutOffYear, extentTest, "User able to enter Analytics Customer Monthly Order Track Cutoff Year", "User not able to enter Customer Monthly Order Track Cutoff Year");
   // System.out.println("Analytics Customer Order Track Cutoff Year validation success");
    ISLocatorDisplayed(GetLocator("AnalyticCustomerMonthlyOrderTrackSearchBtn"), extentTest);
  //  Boolean AnalyticCustomerMonthlyOrderTrackSearchBtn = driver.findElement(GetLocator("AnalyticCustomerMonthlyOrderTrackSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticCustomerMonthlyOrderTrackSearchBtn"), extentTest);
  //  BooleanAsseration(AnalyticCustomerMonthlyOrderTrackSearchBtn, extentTest, "User able to click AnalyticCustomerMonthlyOrderTrack Search Button", "User not able to click AnalyticCustomerMonthlyOrderTrack Search Button");
  //  System.out.println("AnalyticCustomerMonthlyOrderTrack Search Button validation success");
    Thread.sleep(20000);
  
    
        return true;
    }

}