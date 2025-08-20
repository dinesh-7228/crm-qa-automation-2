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
public class AnalyticsCustomerCashback extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsCustomerCashback(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-Collection Summary validation")
public boolean AnalyticCustomerCashbackData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
	ISLocatorDisplayed(GetLocator("AnalyticsLink"),extentTest);
  //    Boolean AnalyticsLinkPresent = driver.findElement(GetLocator("AnalyticsLink").getBy()).isDisplayed();
 // BooleanAsseration(AnalyticsLinkPresent, extentTest, "Analytics Link Present", "Analytics Link Not Present");
 // System.out.println("Analytics Link validation success");
  Thread.sleep(2000);
 ISLocatorDisplayed(GetLocator("AnalyticsLink"), extentTest);
 // Boolean AnalyticsLinkClick = driver.findElement(GetLocator("AnalyticsLink").getBy()).isDisplayed();
  click(GetLocator("AnalyticsLink"), extentTest);
 // BooleanAsseration(AnalyticsLinkClick, extentTest, "Analytics Link is clickable", "Analytics Link Not clickable");
 // System.out.println("Analytics Link Click validation success");
  Thread.sleep(2000);
   ISLocatorDisplayed(GetLocator("AnalyticCustomerCashbackLink"),extentTest);
  //  Boolean AnalyticCustomerCashbackLinkPresent = driver.findElement(GetLocator("AnalyticCustomerCashbackLink").getBy()).isDisplayed();
  //  BooleanAsseration(AnalyticCustomerCashbackLinkPresent, extentTest, "Customer Cashback Link Present", "Customer Cashback Link Not Present");
  //  System.out.println("Customer Cashback Link validation success");
    Thread.sleep(6000);
    ISLocatorDisplayed(GetLocator("AnalyticCustomerCashbackLink"), extentTest);
  //  Boolean AnalyticCustomerCashbackLinkClick = driver.findElement(GetLocator("AnalyticCustomerCashbackLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticCustomerCashbackLink"), extentTest);
 //   BooleanAsseration(AnalyticCustomerCashbackLinkClick, extentTest, "Customer Cashback Link is clickable", "Customer Cashback Link Not clickable");
 //   System.out.println("Customer Cashback Link  Click validation success");
    Thread.sleep(20000);
    ISLocatorDisplayed(GetLocator("EnterAnalyticCustomerCashbackFranchise"), extentTest);
 //   Boolean AnalyticCustomerCashbackFranchise = driver.findElement(GetLocator("EnterAnalyticCustomerCashbackFranchise").getBy()).isDisplayed();
    click(GetLocator("EnterAnalyticCustomerCashbackFranchise"), extentTest);
    EnterValue(GetLocator("EnterAnalyticCustomerCashbackFranchise"),accountData.getCityName(), extentTest);
    Thread.sleep(2000);
    click(GetLocator("SelectActiveStatus"), extentTest);
//    BooleanAsseration(AnalyticCustomerCashbackFranchise, extentTest, "User able to enter Analytics Customer Cashback Franchise", "User not able to enter Analytics Customer Cashback Franchise");
//    System.out.println("Analytics Customer Cashback Franchise validation success");
   ISLocatorDisplayed(GetLocator("AnalyticCustomerCashbackSearchBtn"), extentTest);
  //  Boolean AnalyticCustomerCashbackSearchBtn = driver.findElement(GetLocator("AnalyticCustomerCashbackSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticCustomerCashbackSearchBtn"), extentTest);
   // BooleanAsseration(AnalyticCustomerCashbackSearchBtn, extentTest, "User able to click Get Customer Cashback Button", "User not able to click Get Customer Cashback Button");
   // System.out.println("Get Customer Cashback Button validation success");
    Thread.sleep(15000);
    ISLocatorDisplayed(GetLocator("AnalyticCustomerCashbackExportBtn"), extentTest);
   // Boolean AnalyticCustomerCashbackExportBtn = driver.findElement(GetLocator("AnalyticCustomerCashbackExportBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticCustomerCashbackExportBtn"), extentTest);
  //  BooleanAsseration(AnalyticCustomerCashbackExportBtn, extentTest, "User able to click AnalyticCustomerCashback Export Button", "User not able to click AnalyticCustomerCashback Export Button");
  //  System.out.println("AnalyticCustomerCashback Export Button validation success");
    Thread.sleep(5000);

    
        return true;
    }

}