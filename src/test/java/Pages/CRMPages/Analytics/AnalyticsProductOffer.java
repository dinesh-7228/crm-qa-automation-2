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
public class AnalyticsProductOffer extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsProductOffer(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-Product Offer validation")
public boolean AnalyticProductOfferData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
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
    Boolean AnalyticProductOfferLinkPresent = driver.findElement(GetLocator("AnalyticProductOfferLink").getBy()).isDisplayed();
    BooleanAsseration(AnalyticProductOfferLinkPresent, extentTest, "AnalyticProductOfferLinkPresent Present", "AnalyticProductOfferLinkPresent Not Present");
    System.out.println("AnalyticProductOfferLinkPresent validation success");
    Thread.sleep(3000);

    Boolean AnalyticProductOfferLinkClick = driver.findElement(GetLocator("AnalyticProductOfferLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticProductOfferLink"), extentTest);
    BooleanAsseration(AnalyticProductOfferLinkClick, extentTest, "AnalyticProductOffer Link is clickable", "AnalyticProductOffer Link Not clickable");
    System.out.println("AnalyticProductOffer Link  Click validation success");
    Thread.sleep(35000);
    
    Boolean AnalyticProductOfferCity = driver.findElement(GetLocator("EnterAnalyticProductOfferCity").getBy()).isDisplayed();
    click(GetLocator("EnterAnalyticProductOfferCity"), extentTest);
    Thread.sleep(1000);
    EnterValue(GetLocator("EnterAnalyticProductOfferCity"),accountData.getCityName(), extentTest);
    Thread.sleep(1000);
//    click(GetLocator("SelectFranchiseDropdown"));
//    Thread.sleep(1000);
    click(GetLocator("CustomerCreatedFromDate"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("DateSelect"), extentTest);
    Thread.sleep(1000);
//    click(GetLocator("CustomerStatusSelect"));
//    Thread.sleep(1000);
//    click(GetLocator("SelectActiveStatus"));
//    Thread.sleep(1000);    
    BooleanAsseration(AnalyticProductOfferCity, extentTest, "User able to enter Analytics Product Offer City", "User not able to enter Analytics Product Offer City");
    System.out.println("Analytics Product Offer City validation success");
    
    Boolean AnalyticProductOfferSearchBtn = driver.findElement(GetLocator("AnalyticProductOfferSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticProductOfferSearchBtn"), extentTest);
    BooleanAsseration(AnalyticProductOfferSearchBtn, extentTest, "User able to click AnalyticProductOffer Search Button", "User not able to click AnalyticProductOffer Search Button");
    System.out.println("AnalyticProductOffer Search Button validation success");
    Thread.sleep(10000);

    Boolean AnalyticProductOfferExportBtn = driver.findElement(GetLocator("AnalyticProductOfferExportBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticProductOfferExportBtn"), extentTest);
    BooleanAsseration(AnalyticProductOfferExportBtn, extentTest, "User able to click AnalyticProductOffer Export Button", "User not able to click AnalyticProductOffer Export Button");
    System.out.println("AnalyticProductOffer Export Button validation success");
    Thread.sleep(8000);

    
        return true;
    }

}