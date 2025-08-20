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
public class AnalyticsSaleAnalysis extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsSaleAnalysis(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-Collection Summary validation")
public boolean AnalyticSaleAnalysisData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
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
    ISLocatorDisplayed(GetLocator("AnalyticSaleAnalysisLink"), extentTest);
   // Boolean AnalyticSaleAnanlysisLinkPresent = driver.findElement(GetLocator("AnalyticSaleAnalysisLink").getBy()).isDisplayed();
   // BooleanAsseration(AnalyticSaleAnanlysisLinkPresent, extentTest, "AnalyticSaleAnanlysisLinkPresent Present", "AnalyticSaleAnanlysisLinkPresent Not Present");
  //  System.out.println("AnalyticSaleAnanlysisLinkPresent validation success");
    WebDriverWait wait = new WebDriverWait(driver, 60);
    ISLocatorDisplayed(GetLocator("AnalyticSaleAnalysisLink"), extentTest);
 //   Boolean AnalyticSaleAnalysisLinkClick = driver.findElement(GetLocator("AnalyticSaleAnalysisLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticSaleAnalysisLink"), extentTest);
 //   BooleanAsseration(AnalyticSaleAnalysisLinkClick, extentTest, "AnalyticSaleAnalysisLinkClick Link is clickable", "AnalyticSaleAnanlysis Link Not clickable");
 //   System.out.println("AnalyticSaleAnalysis Link  Click validation success");
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("EnterAnalyticSaleAnalysisCity"), extentTest);
   // Boolean AnalyticSaleAnalysisCity = driver.findElement(GetLocator("EnterAnalyticSaleAnalysisCity").getBy()).isDisplayed();
    click(GetLocator("EnterAnalyticSaleAnalysisCity"), extentTest);
    EnterValue(GetLocator("EnterAnalyticSaleAnalysisCity"),accountData.getCityName(), extentTest);
    click(GetLocator("SelectActiveStatus"), extentTest);
   // BooleanAsseration(AnalyticSaleAnalysisCity, extentTest, "User able to enter Analytics Sale Analysis Franchise", "User not able to enter Analytics Sale Analysis Franchise");
   // System.out.println("Analytics Sale Analysis Franchise validation success");
    ISLocatorDisplayed(GetLocator("AnalyticSaleAnalysisSearchBtn"), extentTest);
   // Boolean AnalyticSaleAnalysisSearchBtn = driver.findElement(GetLocator("AnalyticSaleAnalysisSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticSaleAnalysisSearchBtn"), extentTest);
  //  BooleanAsseration(AnalyticSaleAnalysisSearchBtn, extentTest, "User able to click Get Sale Recharge Button", "User not able to click Get Sale Recharge Button");
  //  System.out.println("Get Sale Recharge Button validation success");
    Thread.sleep(90000);
    ISLocatorDisplayed(GetLocator("AnalyticSaleAnalysisExportBtn"), extentTest);
   // Boolean AnalyticSaleAnalysisExportBtn = driver.findElement(GetLocator("AnalyticSaleAnalysisExportBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticSaleAnalysisExportBtn"), extentTest);
  //  BooleanAsseration(AnalyticSaleAnalysisExportBtn, extentTest, "User able to click AnalyticSaleAnalysis Export Button", "User not able to click AnalyticSaleAnalysis Export Button");
  //  System.out.println("AnalyticSaleAnalysis Export Button validation success");
    Thread.sleep(4000);

    
        return true;
    }

}