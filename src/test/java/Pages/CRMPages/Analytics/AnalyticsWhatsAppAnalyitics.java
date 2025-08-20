package Pages.CRMPages.Analytics;

import Data.AccountData;
import FrameWork.BrowserAction;
import FrameWork.Locator;
import FrameWork.TestListner;
import FrameWork.TestRunner;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
@Listeners(TestListner.class)
public class AnalyticsWhatsAppAnalyitics extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsWhatsAppAnalyitics(WebDriver driver) {
    	
        this.driver = driver;
    }

@Step("Analytics validation || Analytics-WhatsApp Analytics validation")
public boolean AnalyticWhatsAppAnalyticsData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
 
	  Boolean AnalyticsLinkPresent = driver.findElement(GetLocator("AnalyticsLink").getBy()).isDisplayed();
	  BooleanAsseration(AnalyticsLinkPresent, extentTest, "Analytics Link Present", "Analytics Link Not Present");
	  System.out.println("Analytics Link validation success");
	  Thread.sleep(2000);
	
	  Boolean AnalyticsLinkClick = driver.findElement(GetLocator("AnalyticsLink").getBy()).isDisplayed();
	  click(GetLocator("AnalyticsLink"), extentTest);
	  BooleanAsseration(AnalyticsLinkClick, extentTest, "Analytics Link is clickable", "Analytics Link Not clickable");
	  System.out.println("Analytics Link Click validation success");
	  Thread.sleep(2000);
  
    Boolean AnalyticWhatsAppAnalyticsLinkPresent = driver.findElement(GetLocator("AnalyticWhatsAppAnalyticsLink").getBy()).isDisplayed();
    BooleanAsseration(AnalyticWhatsAppAnalyticsLinkPresent, extentTest, "WhatsApp Analytics Link Present", "WhatsApp Analytics Link Not Present");
    System.out.println("WhatsApp Analytics Link validation success");
    Thread.sleep(10000);

    Boolean AnalyticWhatsAppAnalyticsLinkClick = driver.findElement(GetLocator("AnalyticWhatsAppAnalyticsLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticWhatsAppAnalyticsLink"), extentTest);
    BooleanAsseration(AnalyticWhatsAppAnalyticsLinkClick, extentTest, "WhatsApp Analytics Link is clickable", "WhatsApp Analytics Link Not clickable");
    System.out.println("WhatsApp Analytics Link Click validation success");
    Thread.sleep(45000);
    
    Boolean EnterWhatsAppAnalyticsFromDate = driver.findElement(GetLocator("CustomerOrderTrackFromDate").getBy()).isDisplayed();
    click(GetLocator("CustomerOrderTrackFromDate"), extentTest);
    Thread.sleep(10000);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(10000);
    click(GetLocator("DateSelect"), extentTest);
    BooleanAsseration(EnterWhatsAppAnalyticsFromDate, extentTest, "User able to select WhatsApp Analytics From Date", "User not able to select WhatsApp Analytics From Date");
    System.out.println("WhatsApp Analytics From Date validation success");
    
    Boolean AnalyticWhatsAppAnalyticsSearchBtn = driver.findElement(GetLocator("AnalyticWhatsAppAnalyticsSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticWhatsAppAnalyticsSearchBtn"), extentTest);
    BooleanAsseration(AnalyticWhatsAppAnalyticsSearchBtn, extentTest, "User able to click AnalyticWhatsAppAnalytics Search Button", "User not able to click AnalyticWhatsAppAnalytics Search Button");
    System.out.println("AnalyticWhatsAppAnalytics Search Button validation success");
    Thread.sleep(15000);
   
    Boolean ExportBtnPresent = driver.findElement(GetLocator("AddRouteExportBtn").getBy()).isDisplayed();
    BooleanAsseration(ExportBtnPresent, extentTest, "Export Button Present", "Export Button Not Present");
    System.out.println("Export Button validation success");

	Boolean ExportBtnClick = driver.findElement(GetLocator("AddRouteExportBtn").getBy()).isDisplayed();
	click(GetLocator("AddRouteExportBtn"), extentTest);
	BooleanAsseration(ExportBtnClick, extentTest, "Export Button Clickable", "Export Button Not Clickable");
	System.out.println("Export Button click validation success");
	Thread.sleep(2000);
        return true;
    }

}