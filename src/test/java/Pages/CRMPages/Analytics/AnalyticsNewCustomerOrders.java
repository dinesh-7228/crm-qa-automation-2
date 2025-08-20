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
public class AnalyticsNewCustomerOrders extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsNewCustomerOrders(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-NewCustomerOrders validation")
public boolean AnalyticNewCustomerOrdersData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
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
    ISLocatorDisplayed(GetLocator("AnalyticNewCustomerOrdersLink"), extentTest);
  //  Boolean AnalyticNewCustomerOrdersLinkPresent = driver.findElement(GetLocator("AnalyticNewCustomerOrdersLink").getBy()).isDisplayed();
  //  BooleanAsseration(AnalyticNewCustomerOrdersLinkPresent, extentTest, "Analytics New Customer Orders Link Present", "Analytics New Customer Orders Link Not Present");
  //  System.out.println("Analytics New Customer Orders Link validation success");
    Thread.sleep(3000);
    ISLocatorDisplayed(GetLocator("AnalyticNewCustomerOrdersLink"), extentTest);
  //  Boolean AnalyticNewCustomerOrdersLinkClick = driver.findElement(GetLocator("AnalyticNewCustomerOrdersLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticNewCustomerOrdersLink"), extentTest);
   // BooleanAsseration(AnalyticNewCustomerOrdersLinkClick, extentTest, "AnalyticNewCustomerOrders Link is clickable", "AnalyticNewCustomerOrders Link Not clickable");
   // System.out.println("AnalyticNewCustomerOrders Link  Click validation success");
    Thread.sleep(30000);
    ISLocatorDisplayed(GetLocator("EnterAnalyticNewCustomerOrdersDate"), extentTest);
   // Boolean AnalyticNewCustomerOrdersDate = driver.findElement(GetLocator("EnterAnalyticNewCustomerOrdersDate").getBy()).isDisplayed();
    click(GetLocator("EnterAnalyticNewCustomerOrdersDate"), extentTest);
    Thread.sleep(2000);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("DateSelect"), extentTest);
   // BooleanAsseration(AnalyticNewCustomerOrdersDate, extentTest, "User able to enter Analytics NewCustomerOrders Date", "User not able to enter Analytics NewCustomerOrders Date");
   // System.out.println("Analytics NewCustomerOrders Date validation success");
    ISLocatorDisplayed(GetLocator("AnalyticNewCustomerOrdersSearchBtn"), extentTest);
   // Boolean AnalyticNewCustomerOrdersSearchBtn = driver.findElement(GetLocator("AnalyticNewCustomerOrdersSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticNewCustomerOrdersSearchBtn"), extentTest);
  //  BooleanAsseration(AnalyticNewCustomerOrdersSearchBtn, extentTest, "User able to click AnalyticNewCustomerOrders Search Button", "User not able to click AnalyticNewCustomerOrders Search Button");
  //  System.out.println("AnalyticNewCustomerOrders Search Button validation success");
    Thread.sleep(20000);
    ISLocatorDisplayed(GetLocator("HideShowChartBtn"), extentTest);
  //  Boolean AnalyticsNewCustomerHideShowChartBtn = driver.findElement(GetLocator("HideShowChartBtn").getBy()).isDisplayed();
    click(GetLocator("HideShowChartBtn"), extentTest);
    Thread.sleep(2000);
    click(GetLocator("HideShowChartBtn"), extentTest);
    Thread.sleep(2000);
   // BooleanAsseration(AnalyticsNewCustomerHideShowChartBtn, extentTest, "User able to click Hide Show Chart Button", "User not able to click Hide Show Chart Button");
   // System.out.println("Hide Show Chart Button validation success");
    ISLocatorDisplayed(GetLocator("AnalyticNewCustomerOrdersExportBtn"), extentTest);
 //   Boolean AnalyticNewCustomerOrdersExportBtn = driver.findElement(GetLocator("AnalyticNewCustomerOrdersExportBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticNewCustomerOrdersExportBtn"), extentTest);
 //   BooleanAsseration(AnalyticNewCustomerOrdersExportBtn, extentTest, "User able to click AnalyticNewCustomerOrders Export Button", "User not able to click AnalyticNewCustomerOrders Export Button");
 //   System.out.println("AnalyticNewCustomerOrders Export Button validation success");
    
    
        return true;
    }

}