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
public class AnalyticsCustomerSourceTrack extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsCustomerSourceTrack(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-Customer Source Track validation")
public boolean AnalyticsCustomerSourceTrackData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
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
    ISLocatorDisplayed(GetLocator("AnalyticsCustomerSourceTrackLink"), extentTest);
   // Boolean AnalyticsCustomerSourceTrackLinkPresent = driver.findElement(GetLocator("AnalyticsCustomerSourceTrackLink").getBy()).isDisplayed();
   // BooleanAsseration(AnalyticsCustomerSourceTrackLinkPresent, extentTest, "AnalyticsCustomerSourceTrackLinkPresent Present", "AnalyticsCustomerSourceTrackLinkPresent Not Present");
   // System.out.println("AnalyticsCustomerSourceTrackLinkPresent validation success");
    Thread.sleep(20000);
    ISLocatorDisplayed(GetLocator("AnalyticsCustomerSourceTrackLink"), extentTest);
  //  Boolean AnalyticsCustomerSourceTrackLinkClick = driver.findElement(GetLocator("AnalyticsCustomerSourceTrackLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticsCustomerSourceTrackLink"), extentTest);
  //  BooleanAsseration(AnalyticsCustomerSourceTrackLinkClick, extentTest, "AnalyticsCustomerSourceTrack Link is clickable", "AnalyticsCustomerSourceTrack Link Not clickable");
  //  System.out.println("AnalyticsCustomerSourceTrack Link  Click validation success");
    Thread.sleep(50000);
    
    click(GetLocator("AnalyticsCustomerSourceTrackFromDate"), extentTest);
    Thread.sleep(2000);
    click(GetLocator("PreviousMonth"), extentTest);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("DateSelect"), extentTest);
    Thread.sleep(1000);
    ISLocatorDisplayed(GetLocator("EnterAnalyticsCustomerSourceTrackCity"), extentTest);
   // Boolean AnalyticsCustomerSourceTrackCity = driver.findElement(GetLocator("EnterAnalyticsCustomerSourceTrackCity").getBy()).isDisplayed();
    click(GetLocator("EnterAnalyticsCustomerSourceTrackCity"), extentTest);
//  contextMenu(GetLocator("EnterAnalyticsCustomerSourceTrackCity"));
    EnterValue(GetLocator("EnterAnalyticsCustomerSourceTrackCity"),accountData.getCityName(), extentTest);
    Thread.sleep(1000);
    click(GetLocator("SelectActiveStatus"), extentTest);
  //  BooleanAsseration(AnalyticsCustomerSourceTrackCity, extentTest, "User able to enter Analytics Customer Source Track Franchise", "User not able to enter Analytics New Customer Franchise");
  //  System.out.println("Analytics Customer Source Track City validation success");
    Thread.sleep(1000);
    ISLocatorDisplayed(GetLocator("AnalyticsCustomerSourceTrackSearchBtn"), extentTest);
   // Boolean AnalyticsCustomerSourceTrackSearchBtn = driver.findElement(GetLocator("AnalyticsCustomerSourceTrackSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticsCustomerSourceTrackSearchBtn"), extentTest);
   // BooleanAsseration(AnalyticsCustomerSourceTrackSearchBtn, extentTest, "User able to click AnalyticsCustomerSourceTrack Search Button", "User not able to click AnalyticsCustomerSourceTrack Search Button");
   // System.out.println("AnalyticsCustomerSourceTrack Search Button validation success");
    Thread.sleep(6000);
    ISLocatorDisplayed(GetLocator("AnalyticsCustomerSourceTrackExportBtn"), extentTest);
  //  Boolean AnalyticsCustomerSourceTrackExportBtn = driver.findElement(GetLocator("AnalyticsCustomerSourceTrackExportBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticsCustomerSourceTrackExportBtn"), extentTest);
  //  BooleanAsseration(AnalyticsCustomerSourceTrackExportBtn, extentTest, "User able to click AnalyticsCustomerSourceTrack Export Button", "User not able to click AnalyticsCustomerSourceTrack Export Button");
  //  System.out.println("AnalyticsCustomerSourceTrack Export Button validation success");
    Thread.sleep(6000);
    
        return true;
    }

}