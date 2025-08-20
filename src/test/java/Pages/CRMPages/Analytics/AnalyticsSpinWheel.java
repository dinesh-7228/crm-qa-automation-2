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
public class AnalyticsSpinWheel extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsSpinWheel(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-Spin Wheel validation")
public boolean AnalyticSpinWheelData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
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
    ISLocatorDisplayed(GetLocator("AnalyticSpinWheelLink"), extentTest);
   // Boolean AnalyticSpinWheelLinkPresent = driver.findElement(GetLocator("AnalyticSpinWheelLink").getBy()).isDisplayed();
   // BooleanAsseration(AnalyticSpinWheelLinkPresent, extentTest, "AnalyticSpinWheelLinkPresent Present", "AnalyticSpinWheelLinkPresent Not Present");
   // System.out.println("AnalyticSpinWheelLinkPresent validation success");
    Thread.sleep(20000);
    ISLocatorDisplayed(GetLocator("AnalyticSpinWheelLink"), extentTest);
  //  Boolean AnalyticSpinWheelLinkClick = driver.findElement(GetLocator("AnalyticSpinWheelLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticSpinWheelLink"), extentTest);
   // BooleanAsseration(AnalyticSpinWheelLinkClick, extentTest, "AnalyticSpinWheel Link is clickable", "AnalyticSpinWheel Link Not clickable");
   // System.out.println("AnalyticSpinWheel Link  Click validation success");
    Thread.sleep(20000);
    ISLocatorDisplayed(GetLocator("EnterAnalyticSpinWheelCity"), extentTest);
  //  Boolean AnalyticSpinWheelCity = driver.findElement(GetLocator("EnterAnalyticSpinWheelCity").getBy()).isDisplayed();
    click(GetLocator("EnterAnalyticSpinWheelCity"), extentTest);
    EnterValue(GetLocator("EnterAnalyticSpinWheelCity"),accountData.getCityName(), extentTest);
    Thread.sleep(1000);
    click(GetLocator("SelectActiveStatus"), extentTest);
    Thread.sleep(1000);
  //  BooleanAsseration(AnalyticSpinWheelCity, extentTest, "User able to enter Analytics Spin Wheel City", "User not able to enter Analytics Spin Wheel City");
  //  System.out.println("Analytics Spin Wheel City validation success");
   ISLocatorDisplayed(GetLocator("AnalyticSpinWheelSearchBtn"), extentTest);
  //  Boolean AnalyticSpinWheelSearchBtn = driver.findElement(GetLocator("AnalyticSpinWheelSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticSpinWheelSearchBtn"), extentTest);
  //  BooleanAsseration(AnalyticSpinWheelSearchBtn, extentTest, "User able to click AnalyticSpinWheel Search Button", "User not able to click AnalyticSpinWheel Search Button");
  //  System.out.println("AnalyticSpinWheel Search Button validation success");
    Thread.sleep(10000);


    
        return true;
    }

}