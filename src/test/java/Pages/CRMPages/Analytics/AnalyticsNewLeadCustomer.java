package Pages.CRMPages.Analytics;

import Data.AccountData;
import FrameWork.BrowserAction;
import FrameWork.TestListner;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

@Listeners(TestListner.class)
public class AnalyticsNewLeadCustomer extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsNewLeadCustomer(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-New Lead Customer validation")
public boolean AnalyticNewLeadCustomerData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
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
    ISLocatorDisplayed(GetLocator("AnalyticNewLeadCustomerLink"), extentTest);
  //  Boolean AnalyticNewLeadCustomerLinkPresent = driver.findElement(GetLocator("AnalyticNewLeadCustomerLink").getBy()).isDisplayed();
  //  BooleanAsseration(AnalyticNewLeadCustomerLinkPresent, extentTest, "Analytics New Lead Customer Link Present", "Analytics New Lead Customer Link Not Present");
  //  System.out.println("Analytics New Lead Customer Link validation success");
    Thread.sleep(50000);
    ISLocatorDisplayed(GetLocator("AnalyticNewLeadCustomerLink"), extentTest);
   // Boolean AnalyticNewLeadCustomerLinkClick = driver.findElement(GetLocator("AnalyticNewLeadCustomerLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticNewLeadCustomerLink"), extentTest);
   // BooleanAsseration(AnalyticNewLeadCustomerLinkClick, extentTest, "Analytics New Lead Customer Link is clickable", "Analytics New Lead Customer Link Not clickable");
   // System.out.println("Analytics New Lead Customer Link Click validation success");
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("EnterAnalyticNewLeadCustomerCity"), extentTest);
  //  Boolean AnalyticNewLeadCustomerCity = driver.findElement(GetLocator("EnterAnalyticNewLeadCustomerCity").getBy()).isDisplayed();
    click(GetLocator("EnterAnalyticNewLeadCustomerCity"), extentTest);
    EnterValue(GetLocator("EnterAnalyticNewLeadCustomerCity"),accountData.getCityName(), extentTest);
    WebDriverWait wait2 = new WebDriverWait(driver, 100);
    click(GetLocator("SelectActiveStatus"), extentTest);
    WebDriverWait wait3 = new WebDriverWait(driver, 100);
  //  BooleanAsseration(AnalyticNewLeadCustomerCity, extentTest, "User able to enter Analytics New Lead Customer City", "User not able to enter Analytics New Lead Customer City");
   // System.out.println("Analytics New Lead Customer validation success");
   // WebDriverWait wait4 = new WebDriverWait(driver, 100);
    ISLocatorDisplayed(GetLocator("AnalyticNewLeadCustomerSearchBtn"), extentTest);
   // Boolean AnalyticNewLeadCustomerSearchBtn = driver.findElement(GetLocator("AnalyticNewLeadCustomerSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticNewLeadCustomerSearchBtn"), extentTest);
   // BooleanAsseration(AnalyticNewLeadCustomerSearchBtn, extentTest, "User able to click AnalyticNewLeadCustomer Search Button", "User not able to click AnalyticNewLeadCustomer Search Button");
   // System.out.println("AnalyticNewLeadCustomer Search Button validation success");
    Thread.sleep(10000);

    
        return true;
    }

}