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
public class AnalyticsCustomerTrack extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsCustomerTrack(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics App Customer Track validation")
public boolean AnalyticCustomerTrackData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
//	Boolean AnalyticsLinkPresent = driver.findElement(GetLocator("AnalyticsLink").getBy()).isDisplayed();
//    BooleanAsseration(AnalyticsLinkPresent, extentTest, "Analytics Link Present", "Analytics Link Not Present");
//    System.out.println("Analytics Link validation success");
//    Thread.sleep(2000);
//
//    Boolean AnalyticsLinkClick = driver.findElement(GetLocator("AnalyticsLink").getBy()).isDisplayed();
//    click(GetLocator("AnalyticsLink"));
//    BooleanAsseration(AnalyticsLinkClick, extentTest, "Analytics Link is clickable", "Analytics Link Not clickable");
//    System.out.println("Analytics Link Click validation success");
//    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("AnalyticCustomerTrackLink"), extentTest);
  //  Boolean AnalyticCustomerTrackLinkPresent = driver.findElement(GetLocator("AnalyticCustomerTrackLink").getBy()).isDisplayed();
  //  BooleanAsseration(AnalyticCustomerTrackLinkPresent, extentTest, "Analytic App Customer Track Present", "Analytic App Customer Track Not Present");
  //  System.out.println("Analytic App Customer Track validation success");
    Thread.sleep(80000);
    ISLocatorDisplayed(GetLocator("AnalyticCustomerTrackLink"), extentTest);
  //  Boolean AnalyticCustomerTrackLinkClick = driver.findElement(GetLocator("AnalyticCustomerTrackLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticCustomerTrackLink"), extentTest);
 //   BooleanAsseration(AnalyticCustomerTrackLinkClick, extentTest, "Analytic App Customer Track Link is clickable", "Analytic App Customer Track Link Not clickable");
 //   System.out.println("Analytic App Customer Track Link  Click validation success");
    Thread.sleep(20000);
    ISLocatorDisplayed(GetLocator("EnterAnalyticCustomerTrackDate"), extentTest);
   // Boolean AnalyticCustomerTrackDate = driver.findElement(GetLocator("EnterAnalyticCustomerTrackDate").getBy()).isDisplayed();
    click(GetLocator("EnterAnalyticCustomerTrackDate"), extentTest);
    click(GetLocator("PreviousMonth"), extentTest);
    click(GetLocator("PreviousMonth"), extentTest);
    click(GetLocator("PreviousMonth"), extentTest);
    click(GetLocator("DateSelect"), extentTest);
   // BooleanAsseration(AnalyticCustomerTrackDate, extentTest, "User able to enter Analytics App Customer Track Date", "User not able to enter Analytics App Customer Track Date");
   // System.out.println("Analytics Customer Track Date validation success");
	Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("AnalyticCustomerTrackSearchBtn"), extentTest);
   // Boolean AnalyticCustomerTrackSearchBtn = driver.findElement(GetLocator("AnalyticCustomerTrackSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticCustomerTrackSearchBtn"), extentTest);
  //  BooleanAsseration(AnalyticCustomerTrackSearchBtn, extentTest, "User able to click Get Customer Tracking Button", "User not able to click Get Customer Tracking Button");
  //  System.out.println("Get Customer Tracking Button validation success");
	Thread.sleep(5000);
    ISLocatorDisplayed(GetLocator("AnalyticCustomerTrackIos"), extentTest);
  //  Boolean AnalyticCustomerTrackIos = driver.findElement(GetLocator("AnalyticCustomerTrackIos").getBy()).isDisplayed();
    click(GetLocator("AnalyticCustomerTrackIos"), extentTest);
  //  BooleanAsseration(AnalyticCustomerTrackIos, extentTest, "User able to click Ios Button", "User not able to click Ios Button");
  //  System.out.println("Ios Button validation success");
	Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("AnalyticCustomerTrackAndroid"), extentTest);
   // Boolean AnalyticCustomerTrackAndroid = driver.findElement(GetLocator("AnalyticCustomerTrackAndroid").getBy()).isDisplayed();
    click(GetLocator("AnalyticCustomerTrackAndroid"), extentTest);
   // BooleanAsseration(AnalyticCustomerTrackAndroid, extentTest, "User able to click Android Button", "User not able to click Android Button");
   // System.out.println("Android Button validation success");
	Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("AppCustExportBtn"), extentTest);
   // Boolean ExportBtnPresent = driver.findElement(GetLocator("AppCustExportBtn").getBy()).isDisplayed();
   // BooleanAsseration(ExportBtnPresent, extentTest, "Export Button Present", "Export Button Not Present");
   // System.out.println("Export Button validation success");
    ISLocatorDisplayed(GetLocator("AppCustExportBtn"), extentTest);
//	Boolean ExportBtnClick = driver.findElement(GetLocator("AppCustExportBtn").getBy()).isDisplayed();
	click(GetLocator("AppCustExportBtn"), extentTest);
//	BooleanAsseration(ExportBtnClick, extentTest, "Export Button Clickable", "Export Button Not Clickable");
//	System.out.println("Export Button click validation success");
	Thread.sleep(3000);
    
        return true;
    }

}