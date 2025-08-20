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
public class AnalyticsDailyComplaint extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsDailyComplaint(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-New Customer validation")
public boolean AnalyticsDailyComplaintData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
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
    ISLocatorDisplayed(GetLocator("AnalyticsDailyComplaintLink"), extentTest);
   // Boolean AnalyticsDailyComplaintLinkPresent = driver.findElement(GetLocator("AnalyticsDailyComplaintLink").getBy()).isDisplayed();
  //  BooleanAsseration(AnalyticsDailyComplaintLinkPresent, extentTest, "AnalyticsDailyComplaintLinkPresent Present", "AnalyticsDailyComplaintLinkPresent Not Present");
  //  System.out.println("AnalyticsDailyComplaintLinkPresent validation success");
    Thread.sleep(30000);
    ISLocatorDisplayed(GetLocator("AnalyticsDailyComplaintLink"), extentTest);
   // Boolean AnalyticsDailyComplaintLinkClick = driver.findElement(GetLocator("AnalyticsDailyComplaintLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticsDailyComplaintLink"), extentTest);
  //  BooleanAsseration(AnalyticsDailyComplaintLinkClick, extentTest, "AnalyticsDailyComplaint Link is clickable", "AnalyticsDailyComplaint Link Not clickable");
  //  System.out.println("AnalyticsDailyComplaint Link  Click validation success");
    Thread.sleep(50000);

    click(GetLocator("AnalyticsCustomerSourceTrackFromDate"), extentTest);
    Thread.sleep(2000);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("DateSelect"), extentTest);
    Thread.sleep(1000);
    ISLocatorDisplayed(GetLocator("EnterAnalyticsDailyComplaintFranchise"), extentTest);
   // Boolean AnalyticsDailyComplaintFranchise = driver.findElement(GetLocator("EnterAnalyticsDailyComplaintFranchise").getBy()).isDisplayed();
    click(GetLocator("EnterAnalyticsDailyComplaintFranchise"), extentTest);
  //  contextMenu(GetLocator("EnterAnalyticsDailyComplaintFranchise"));
    EnterValue(GetLocator("EnterAnalyticsDailyComplaintFranchise"),accountData.getCityName(), extentTest);
    Thread.sleep(1000);
    click(GetLocator("SelectActiveStatus"), extentTest);
  //  BooleanAsseration(AnalyticsDailyComplaintFranchise, extentTest, "User able to enter Analytics Daily Complaint Franchise", "User not able to enter Analytics Daily Complaint Franchise");
  //  System.out.println("Daily Complaint Franchise validation success");
    ISLocatorDisplayed(GetLocator("AnalyticsDailyComplaintSearchBtn"), extentTest);
   // Boolean AnalyticsDailyComplaintSearchBtn = driver.findElement(GetLocator("AnalyticsDailyComplaintSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticsDailyComplaintSearchBtn"), extentTest);
   // BooleanAsseration(AnalyticsDailyComplaintSearchBtn, extentTest, "User able to click AnalyticsDailyComplaint Search Button", "User not able to click AnalyticsDailyComplaint Search Button");
   // System.out.println("AnalyticsDailyComplaint Search Button validation success");
    Thread.sleep(6000);
    
    
//    BooleanAsseration(AnalyticsDailyComplaintSearchBtn, extentTest, "User able to click AnalyticsDailyComplaint Search Button", "User not able to click AnalyticsDailyComplaint Search Button");
  
    
    ISLocatorDisplayed(GetLocator("AnalyticsDailyComplaintExportBtn"), extentTest);
   // Boolean AnalyticsDailyComplaintExportBtn = driver.findElement(GetLocator("AnalyticsDailyComplaintExportBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticsDailyComplaintExportBtn"), extentTest);
   // BooleanAsseration(AnalyticsDailyComplaintExportBtn, extentTest, "User able to click AnalyticsDailyComplaint Export Button", "User not able to click AnalyticsDailyComplaint Export Button");
   // System.out.println("AnalyticsDailyComplaint Export Button validation success");
    Thread.sleep(3000);
    
        return true;
    }

}