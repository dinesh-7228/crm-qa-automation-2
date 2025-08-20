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
public class AnalyticsComplaintAnalysis extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsComplaintAnalysis(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-Complaint Analysis validation")
public boolean AnalyticComplaintAnalysisData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
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
    ISLocatorDisplayed(GetLocator("AnalyticComplaintAnalysisLink"), extentTest);
  //  Boolean AnalyticComplaintAnanlysisLinkPresent = driver.findElement(GetLocator("AnalyticComplaintAnalysisLink").getBy()).isDisplayed();
  //  BooleanAsseration(AnalyticComplaintAnanlysisLinkPresent, extentTest, "AnalyticSaleAnanlysisLinkPresent Present", "AnalyticSaleAnanlysisLinkPresent Not Present");
  //  System.out.println("AnalyticSaleAnanlysisLinkPresent validation success");
   // WebDriverWait wait = new WebDriverWait(driver, 30);
    ISLocatorDisplayed(GetLocator("AnalyticComplaintAnalysisLink"), extentTest);
 //   Boolean AnalyticComplaintAnalysisLinkClick = driver.findElement(GetLocator("AnalyticComplaintAnalysisLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticComplaintAnalysisLink"), extentTest);
 //   BooleanAsseration(AnalyticComplaintAnalysisLinkClick, extentTest, "Complaint Analysis Link is clickable", "Complaint Analysis Link Not clickable");
 //   System.out.println("Complaint Analysis Link Click validation success");
    Thread.sleep(50000);
    ISLocatorDisplayed(GetLocator("EnterAnalyticComplaintAnalysisCity"), extentTest);
 //   Boolean AnalyticComplaintAnalysisCity = driver.findElement(GetLocator("EnterAnalyticComplaintAnalysisCity").getBy()).isDisplayed();
    click(GetLocator("EnterAnalyticComplaintAnalysisCity"), extentTest);
    Thread.sleep(1000);
    EnterValue(GetLocator("EnterAnalyticComplaintAnalysisCity"),accountData.getCityName(), extentTest);
    Thread.sleep(1000);
    click(GetLocator("SelectActiveStatus"), extentTest);
    Thread.sleep(1000);
  //  BooleanAsseration(AnalyticComplaintAnalysisCity, extentTest, "User able to enter Complaint Analytics City", "User not able to enter Complaint Analytics City");
  //  System.out.println("Complaint Analytics City validation success");
    ISLocatorDisplayed(GetLocator("AnalyticComplaintAnalysisSearchBtn"), extentTest);
   // Boolean AnalyticComplaintAnalysisSearchBtn = driver.findElement(GetLocator("AnalyticComplaintAnalysisSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticComplaintAnalysisSearchBtn"), extentTest);
  //  BooleanAsseration(AnalyticComplaintAnalysisSearchBtn, extentTest, "User able to click Complaint Analytics Search Button", "User not able to click Complaint Analytics Search Button");
  //  System.out.println("Complaint Analytics Search Button validation success");
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("AnalyticComplaintAnalysisSummary"), extentTest);
  //  Boolean AnalyticComplaintAnalysisSummary = driver.findElement(GetLocator("AnalyticComplaintAnalysisSummary").getBy()).isDisplayed();
    click(GetLocator("AnalyticComplaintAnalysisSummary"), extentTest);
  //  BooleanAsseration(AnalyticComplaintAnalysisSummary, extentTest, "User able to click Complaint Analytics Summary Button", "User not able to click Complaint Analytics Summary Button");
  //  System.out.println("Complaint Analytics Summary Button validation success");
    Thread.sleep(1000);
    ISLocatorDisplayed(GetLocator("AnalyticComplaintAnalysisCenterWise"), extentTest);
  //  Boolean AnalyticComplaintAnalysisCenterWise = driver.findElement(GetLocator("AnalyticComplaintAnalysisCenterWise").getBy()).isDisplayed();
    click(GetLocator("AnalyticComplaintAnalysisCenterWise"), extentTest);
   // BooleanAsseration(AnalyticComplaintAnalysisCenterWise, extentTest, "User able to click Complaint Analytics CenterWise Button", "User not able to click Complaint Analytics CenterWise Button");
   // System.out.println("Complaint Analytics CenterWise Button validation success");
    Thread.sleep(1000);
    ISLocatorDisplayed(GetLocator("AnalyticComplaintAnalysisOverall"), extentTest);
   // Boolean AnalyticComplaintAnalysisOverall = driver.findElement(GetLocator("AnalyticComplaintAnalysisOverall").getBy()).isDisplayed();
    click(GetLocator("AnalyticComplaintAnalysisOverall"), extentTest);
   // BooleanAsseration(AnalyticComplaintAnalysisOverall, extentTest, "User able to click Complaint Analytics Overall Button", "User not able to click Complaint Analytics Overall Button");
   // System.out.println("Complaint Analytics Overall Button validation success");
    Thread.sleep(1000);
    ISLocatorDisplayed(GetLocator("AnalyticComplaintAnalysisUserWise"), extentTest);
   // Boolean AnalyticComplaintAnalysisUserWise = driver.findElement(GetLocator("AnalyticComplaintAnalysisUserWise").getBy()).isDisplayed();
    click(GetLocator("AnalyticComplaintAnalysisUserWise"), extentTest);
   // BooleanAsseration(AnalyticComplaintAnalysisUserWise, extentTest, "User able to click Complaint Analytics UserWise Button", "User not able to click Complaint Analytics UserWise Button");
   // System.out.println("Complaint Analytics UserWise Button validation success");
    Thread.sleep(1000);
    
    
        return true;
    }

}