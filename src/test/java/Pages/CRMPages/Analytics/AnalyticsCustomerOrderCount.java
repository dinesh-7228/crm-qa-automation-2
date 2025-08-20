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
public class AnalyticsCustomerOrderCount extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsCustomerOrderCount(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-Customer Order Count validation")
public boolean AnalyticsCustomerOrderCountData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
//	Boolean AnalyticsLinkPresent = driver.findElement(GetLocator("AnalyticsLink").getBy()).isDisplayed();
//  BooleanAsseration(AnalyticsLinkPresent, extentTest, "Analytics Link Present", "Analytics Link Not Present");
//  System.out.println("Analytics Link validation success");
//  Thread.sleep(2000);
//
//  Boolean AnalyticsLinkClick = driver.findElement(GetLocator("AnalyticsLink").getBy()).isDisplayed();
//  click(GetLocator("AnalyticsLink"));
//  BooleanAsseration(AnalyticsLinkClick, extentTest, "Analytics Link is clickable", "Analytics Link Not clickable");
//  System.out.println("Analytics Link Click validation success");
//  Thread.sleep(6000);
	ISLocatorDisplayed(GetLocator("AnalyticsCustomerOrderCountLink"), extentTest);
  //  Boolean AnalyticsCustomerOrderCountLinkPresent = driver.findElement(GetLocator("AnalyticsCustomerOrderCountLink").getBy()).isDisplayed();
  //  BooleanAsseration(AnalyticsCustomerOrderCountLinkPresent, extentTest, "AnalyticsCustomerOrderCountLinkPresent Present", "AnalyticsCustomerOrderCountLinkPresent Not Present");
  //  System.out.println("AnalyticsCustomerOrderCountLinkPresent validation success");
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("AnalyticsCustomerOrderCountLink"), extentTest);
  //  Boolean AnalyticsCustomerOrderCountLinkClick = driver.findElement(GetLocator("AnalyticsCustomerOrderCountLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticsCustomerOrderCountLink"), extentTest);
 //   BooleanAsseration(AnalyticsCustomerOrderCountLinkClick, extentTest, "AnalyticsCustomerOrderCount Link is clickable", "AnalyticsCustomerOrderCount Link Not clickable");
 //   System.out.println("AnalyticsCustomerOrderCount Link  Click validation success");
    Thread.sleep(10000);
    
    click(GetLocator("AnalyticsCustomerSourceTrackFromDate"), extentTest);
    Thread.sleep(2000);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("DateSelect"), extentTest);
    Thread.sleep(1000);
    ISLocatorDisplayed(GetLocator("EnterAnalyticsCustomerOrderCountCity"), extentTest);
  //  Boolean AnalyticsCustomerOrderCountCity = driver.findElement(GetLocator("EnterAnalyticsCustomerOrderCountCity").getBy()).isDisplayed();
    click(GetLocator("EnterAnalyticsCustomerOrderCountCity"), extentTest);
  //contextMenu(GetLocator("EnterAnalyticsCustomerOrderCountCity"));
    EnterValue(GetLocator("EnterAnalyticsCustomerOrderCountCity"),accountData.getCityName(), extentTest);
    Thread.sleep(1000);
    click(GetLocator("SelectActiveStatus"), extentTest);
   // BooleanAsseration(AnalyticsCustomerOrderCountCity, extentTest, "User able to enter Analytics Customer Order Count City", "User not able to enter Analytics Customer Order Count City");
   // System.out.println("Analytics Customer Order Count City validation success");
    ISLocatorDisplayed(GetLocator("AnalyticsCustomerOrderCountSearchBtn"), extentTest);
   // Boolean AnalyticsCustomerOrderCountSearchBtn = driver.findElement(GetLocator("AnalyticsCustomerOrderCountSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticsCustomerOrderCountSearchBtn"), extentTest);
  //  BooleanAsseration(AnalyticsCustomerOrderCountSearchBtn, extentTest, "User able to click AnalyticsCustomerOrderCount Search Button", "User not able to click AnalyticsCustomerOrderCount Search Button");
  //  System.out.println("AnalyticsCustomerOrderCount Search Button validation success");
    Thread.sleep(8000);
    ISLocatorDisplayed(GetLocator("AnalyticsCustomerOrderCountExportBtn"),extentTest );
    Boolean AnalyticsCustomerOrderCountExportBtn = driver.findElement(GetLocator("AnalyticsCustomerOrderCountExportBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticsCustomerOrderCountExportBtn"), extentTest);
  //  BooleanAsseration(AnalyticsCustomerOrderCountExportBtn, extentTest, "User able to click AnalyticsCustomerOrderCount Export Button", "User not able to click AnalyticsCustomerOrderCount Export Button");
  //  System.out.println("AnalyticsCustomerOrderCount Export Button validation success");
    Thread.sleep(15000);
    
        return true;
    }

}