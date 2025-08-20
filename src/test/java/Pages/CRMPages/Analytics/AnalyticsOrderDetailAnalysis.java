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
public class AnalyticsOrderDetailAnalysis extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsOrderDetailAnalysis(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-Order Detail Analytics validation")
public boolean AnalyticOrderDetailAnalyticsData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
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
//
    ISLocatorDisplayed(GetLocator("AnalyticOrderDetailAnalyticsLink"), extentTest);
 //   Boolean AnalyticOrderDetailAnalyticsLinkPresent = driver.findElement(GetLocator("AnalyticOrderDetailAnalyticsLink").getBy()).isDisplayed();
 //   BooleanAsseration(AnalyticOrderDetailAnalyticsLinkPresent, extentTest, "Order Detail Analytics Link Present", "Order Detail Analytics Link Not Present");
 //   System.out.println("Order Detail Analytics Link validation success");
    Thread.sleep(30000);
    ISLocatorDisplayed(GetLocator("AnalyticOrderDetailAnalyticsLink"), extentTest);
  //  Boolean AnalyticOrderDetailAnalyticsLinkClick = driver.findElement(GetLocator("AnalyticOrderDetailAnalyticsLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticOrderDetailAnalyticsLink"),extentTest);
  //  BooleanAsseration(AnalyticOrderDetailAnalyticsLinkClick, extentTest, "Order Detail Analytics Link is clickable", "Order Detail Analytics Link Not clickable");
  //  System.out.println("Order Detail Analytics Link Click validation success");
    Thread.sleep(50000);
    ISLocatorDisplayed(GetLocator("EnterAnalyticOrderDetailAnalyticsDate"), extentTest);
   // Boolean AnalyticOrderDetailAnalyticsDate = driver.findElement(GetLocator("EnterAnalyticOrderDetailAnalyticsDate").getBy()).isDisplayed();
    click(GetLocator("EnterAnalyticOrderDetailAnalyticsDate"), extentTest);
    Thread.sleep(2000);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("DateSelect"), extentTest);
   // BooleanAsseration(AnalyticOrderDetailAnalyticsDate, extentTest, "User able to select Order Detail Analytics Date", "User not able to select Order Detail Analytics Date");
   // System.out.println("Order Detail Analytics Date select validation success");
    ISLocatorDisplayed(GetLocator("AnalyticOrderDetailAnalyticsSearchBtn"), extentTest);
   // Boolean AnalyticOrderDetailAnalyticsSearchBtn = driver.findElement(GetLocator("AnalyticOrderDetailAnalyticsSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticOrderDetailAnalyticsSearchBtn"), extentTest);
   // BooleanAsseration(AnalyticOrderDetailAnalyticsSearchBtn, extentTest, "User able to click AnalyticSaleAnanlysis Search Button", "User not able to click AnalyticSaleAnanlysis Search Button");
   // System.out.println("AnalyticOrderDetailAnalytics Search Button validation success");
    Thread.sleep(6000);
    ISLocatorDisplayed(GetLocator("AnalyticOrderDetailAnalyticsCityWise"), extentTest);
   // Boolean AnalyticOrderDetailAnalyticsCityWise = driver.findElement(GetLocator("AnalyticOrderDetailAnalyticsCityWise").getBy()).isDisplayed();
    click(GetLocator("AnalyticOrderDetailAnalyticsCityWise"), extentTest);
   // BooleanAsseration(AnalyticOrderDetailAnalyticsCityWise, extentTest, "User able to click AnalyticOrderDetailAnalytics CityWise Button", "User not able to click AnalyticOrderDetailAnalytics CityWise Button");
   // System.out.println("AnalyticOrderDetailAnalytics CityWise Button validation success");
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("AnalyticOrderDetailAnalyticsProductWise"), extentTest);
   // Boolean AnalyticOrderDetailAnalyticsProductWise = driver.findElement(GetLocator("AnalyticOrderDetailAnalyticsProductWise").getBy()).isDisplayed();
    click(GetLocator("AnalyticOrderDetailAnalyticsProductWise"), extentTest);
   // BooleanAsseration(AnalyticOrderDetailAnalyticsProductWise, extentTest, "User able to click AnalyticOrderDetailAnalytics ProductWise Button", "User not able to click AnalyticOrderDetailAnalytics ProductWise Button");
   // System.out.println("AnalyticOrderDetailAnalytics ProductWise Button validation success");
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("AnalyticOrderDetailAnalyticsFranchiseWise"), extentTest);
  //  Boolean AnalyticOrderDetailAnalyticsFranchiseWise = driver.findElement(GetLocator("AnalyticOrderDetailAnalyticsFranchiseWise").getBy()).isDisplayed();
    click(GetLocator("AnalyticOrderDetailAnalyticsFranchiseWise"), extentTest);
  //  BooleanAsseration(AnalyticOrderDetailAnalyticsFranchiseWise, extentTest, "User able to click AnalyticOrderDetailAnalytics FranchiseWise Button", "User not able to click AnalyticOrderDetailAnalytics FranchiseWise Button");
  //  System.out.println("AnalyticOrderDetailAnalytics FranchiseWise Button validation success");
    Thread.sleep(2000);


    
        return true;
    }

}