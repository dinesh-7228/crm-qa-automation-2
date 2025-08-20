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
public class AnalyticsChatbotAnalysis extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsChatbotAnalysis(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-Collection Summary validation")
public boolean AnalyticChatbotAnalyticsData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
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
    Boolean AnalyticChatbotAnalyticsLinkPresent = driver.findElement(GetLocator("AnalyticChatbotAnalyticsLink").getBy()).isDisplayed();
    BooleanAsseration(AnalyticChatbotAnalyticsLinkPresent, extentTest, "Chatbot Analytics Link Present", "Chatbot Analytics Link Not Present");
    System.out.println("Chatbot Analytics Link validation success");
    Thread.sleep(3000);

    Boolean AnalyticChatbotAnalyticsLinkClick = driver.findElement(GetLocator("AnalyticChatbotAnalyticsLink").getBy()).isDisplayed();
    click(GetLocator("AnalyticChatbotAnalyticsLink"), extentTest);
    BooleanAsseration(AnalyticChatbotAnalyticsLinkClick, extentTest, "Chatbot Analytics Link is clickable", "Chatbot Analytics Link Not clickable");
    System.out.println("Chatbot Analytics Link Click validation success");
    Thread.sleep(12000);
    
    Boolean AnalyticChatbotAnalyticsCity = driver.findElement(GetLocator("EnterAnalyticChatbotAnalyticsCity").getBy()).isDisplayed();
    click(GetLocator("EnterAnalyticChatbotAnalyticsCity"), extentTest);
    EnterValue(GetLocator("EnterAnalyticChatbotAnalyticsCity"),accountData.getCityName(), extentTest);
    BooleanAsseration(AnalyticChatbotAnalyticsCity, extentTest, "User able to enter Analytics Chatbot Analytics City", "User not able to enter Analytics Chatbot Analytics City");
    System.out.println("Analytics Chatbot Analytics City validation success");
    
    Boolean AnalyticChatbotAnalyticsSearchBtn = driver.findElement(GetLocator("AnalyticChatbotAnalyticsSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticChatbotAnalyticsSearchBtn"), extentTest);
    BooleanAsseration(AnalyticChatbotAnalyticsSearchBtn, extentTest, "User able to click AnalyticSaleAnanlysis Search Button", "User not able to click AnalyticSaleAnanlysis Search Button");
    System.out.println("AnalyticChatbotAnalyticsSearchBtn Search Button validation success");
    Thread.sleep(15000);

    Boolean AnalyticChatbotAnalyticsCityWise = driver.findElement(GetLocator("AnalyticChatbotAnalyticsCityWise").getBy()).isDisplayed();
    click(GetLocator("AnalyticChatbotAnalyticsCityWise"), extentTest);
    BooleanAsseration(AnalyticChatbotAnalyticsCityWise, extentTest, "User able to click AnalyticChatbotAnalytics CityWise Button", "User not able to click AnalyticChatbotAnalytics CityWise Button");
    System.out.println("AnalyticChatbotAnalytics CityWise Button validation success");
    Thread.sleep(1000);

    Boolean AnalyticChatbotAnalyticsCityWiseComplaint = driver.findElement(GetLocator("AnalyticChatbotAnalyticsCityWiseComplaint").getBy()).isDisplayed();
    click(GetLocator("AnalyticChatbotAnalyticsCityWiseComplaint"), extentTest);
    BooleanAsseration(AnalyticChatbotAnalyticsCityWiseComplaint, extentTest, "User able to click AnalyticChatbotAnalytics CityWise Complaint Button", "User not able to click AnalyticChatbotAnalytics CityWise Complaint Button");
    System.out.println("AnalyticChatbotAnalytics CityWiseComplaint Button validation success");
    Thread.sleep(1000);

    Boolean AnalyticChatbotAnalyticsCustomerWise = driver.findElement(GetLocator("AnalyticChatbotAnalyticsCustomerWise").getBy()).isDisplayed();
    click(GetLocator("AnalyticChatbotAnalyticsCustomerWise"), extentTest);
    BooleanAsseration(AnalyticChatbotAnalyticsCustomerWise, extentTest, "User able to click AnalyticChatbotAnalytics CustomerWise Button", "User not able to click AnalyticChatbotAnalytics CustomerWise Button");
    System.out.println("AnalyticChatbotAnalytics CustomerWise Button validation success");
    Thread.sleep(1000);

    Boolean AnalyticChatbotAnalyticsCustomerWiseComplaint = driver.findElement(GetLocator("AnalyticChatbotAnalyticsCustomerWiseComplaint").getBy()).isDisplayed();
    click(GetLocator("AnalyticChatbotAnalyticsCustomerWiseComplaint"), extentTest);
    BooleanAsseration(AnalyticChatbotAnalyticsCustomerWiseComplaint, extentTest, "User able to click AnalyticChatbotAnalytics CustomerWise Complaint Button", "User not able to click AnalyticChatbotAnalytics CustomerWise Complaint Button");
    System.out.println("AnalyticChatbotAnalytics CustomerWiseComplaint Button validation success");
    Thread.sleep(1000);

    
        return true;
    }

}