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
public class AnalyticsCustomersOrderTrack extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsCustomersOrderTrack(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-Customer Order Track validation")
public boolean AnalyticCustomerOrderTrackData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
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
    ISLocatorDisplayed(GetLocator("AnalyticCustomerOrderTrackLink"), extentTest);
  //  Boolean AnalyticCustomerOrderTrackLinkPresent = driver.findElement(GetLocator("AnalyticCustomerOrderTrackLink").getBy()).isDisplayed();
  //  BooleanAsseration(AnalyticCustomerOrderTrackLinkPresent, extentTest, "AnalyticCustomerOrderTrackLinkPresent Present", "AnalyticCustomerOrderTrackLinkPresent Not Present");
  //  System.out.println("AnalyticCustomerOrderTrackLinkPresent validation success");
    Thread.sleep(40000);
    ISLocatorDisplayed(GetLocator("AnalyticCustomerOrderTrackLink"), extentTest);
  //  Boolean AnalyticCustomerOrderTrackLinkClick = driver.findElement(GetLocator("AnalyticCustomerOrderTrackLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticCustomerOrderTrackLink"), extentTest);
  //  BooleanAsseration(AnalyticCustomerOrderTrackLinkClick, extentTest, "AnalyticCustomerOrderTrack Link is clickable", "AnalyticCustomerOrderTrack Link Not clickable");
  //  System.out.println("AnalyticCustomerOrderTrack Link  Click validation success");
    Thread.sleep(20000);
    ISLocatorDisplayed(GetLocator("CustomerOrderTrackFromDate"), extentTest);
   // Boolean CustomerOrderTrackFromDate = driver.findElement(GetLocator("CustomerOrderTrackFromDate").getBy()).isDisplayed();
    click(GetLocator("CustomerOrderTrackFromDate"), extentTest);
    Thread.sleep(2000);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("DateSelect"), extentTest);
  //  BooleanAsseration(CustomerOrderTrackFromDate, extentTest, "User able to select Analytics Customer Order Track From Date", "User not able to select Customer Order Track From Date");
  //  System.out.println("Analytics Customer Order Track From Date validation success");
    ISLocatorDisplayed(GetLocator("AnalyticCustomerOrderTrackSearchBtn"), extentTest);
  //  Boolean AnalyticCustomerOrderTrackSearchBtn = driver.findElement(GetLocator("AnalyticCustomerOrderTrackSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticCustomerOrderTrackSearchBtn"), extentTest);
  //  BooleanAsseration(AnalyticCustomerOrderTrackSearchBtn, extentTest, "User able to click AnalyticCustomerOrderTrack Search Button", "User not able to click AnalyticCustomerOrderTrack Search Button");
  //  System.out.println("AnalyticCustomerOrderTrack Search Button validation success");
    Thread.sleep(6000);
    ISLocatorDisplayed(GetLocator("AnalyticChatbotAnalyticsCityWise"), extentTest);
  //  Boolean CustomerOrderTrackRegion = driver.findElement(GetLocator("AnalyticChatbotAnalyticsCityWise").getBy()).isDisplayed();
    click(GetLocator("AnalyticChatbotAnalyticsCityWise"), extentTest);
  //  BooleanAsseration(CustomerOrderTrackRegion, extentTest, "User able to select Analytics Customer Order Track Region", "User not able to select Customer Order Track Region");
  //  System.out.println("Analytics Customer Order Track Region validation success");
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("AnalyticChatbotAnalyticsCityWiseComplaint"), extentTest);
   // Boolean CustomerOrderTrackFranchise = driver.findElement(GetLocator("AnalyticChatbotAnalyticsCityWiseComplaint").getBy()).isDisplayed();
    click(GetLocator("AnalyticChatbotAnalyticsCityWiseComplaint"), extentTest);
   // BooleanAsseration(CustomerOrderTrackFranchise, extentTest, "User able to select Analytics Customer Order Track Franchise", "User not able to select Customer Order Track Franchise");
   // System.out.println("Analytics Customer Order Track Franchise validation success");
    Thread.sleep(2000);

    
        return true;
    }

}