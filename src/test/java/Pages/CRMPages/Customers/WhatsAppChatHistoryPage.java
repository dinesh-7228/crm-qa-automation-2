package Pages.CRMPages.Customers;
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
public class WhatsAppChatHistoryPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public WhatsAppChatHistoryPage(WebDriver driver) {
        this.driver = driver;
    }
@Step("Customer validation || Whats App Chat History Page validation") 
public boolean WhatsAppChatHistoryData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
//  Boolean CustomerLinkPresent = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
//  BooleanAsseration(CustomerLinkPresent, extentTest, "Customer Link Present", "Customer Link Not Present");
//  System.out.println("Customer Link validation success");
//  Thread.sleep(2000);
//
//  Boolean CustomerLinkClick = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
//  click(GetLocator("CustomerLink"));
//  BooleanAsseration(CustomerLinkClick, extentTest, "Customer Link is clickable", "Customer Link Not clickable");
//  System.out.println("Customer Link  Click validation success");
//  Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("WhatsAppChatHistoryLink"), extentTest);
  //  Boolean WhatsAppChatHistoryLinkPresent = driver.findElement(GetLocator("WhatsAppChatHistoryLink").getBy()).isDisplayed();
  //  BooleanAsseration(WhatsAppChatHistoryLinkPresent, extentTest, "Whats App Chat History Link Present", "Whats App Chat History Link Not Present");
    //System.out.println("Whats App Chat History Link validation success");
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("WhatsAppChatHistoryLink"), extentTest);
   // Boolean WhatsAppChatHistoryLinkClick = driver.findElement(GetLocator("WhatsAppChatHistoryLink").getBy()).isDisplayed();
    click(GetLocator("WhatsAppChatHistoryLink"), extentTest);
    //BooleanAsseration(WhatsAppChatHistoryLinkClick, extentTest, "Whats App Chat History Link is clickable", "Whats App Chat History Link Not clickable");
    //System.out.println("Whats App Chat History Link Click validation success");
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("SelectRouteWhatsAppChatHistory"), extentTest);
   // Boolean SelectRouteWhatsAppChatHistory = driver.findElement(GetLocator("SelectRouteWhatsAppChatHistory").getBy()).isDisplayed();
    click(GetLocator("SelectRouteWhatsAppChatHistory"), extentTest);
    Thread.sleep(3000);
    EnterValue(GetLocator("SelectRouteWhatsAppChatHistory"),accountData.getRouteForWhatsAppChat(), extentTest);
    Thread.sleep(4000);
    click(GetLocator("SelectActiveStatus"), extentTest);
    Thread.sleep(2000);
    //BooleanAsseration(SelectRouteWhatsAppChatHistory, extentTest, "User is able to select Route for Whats App Chat History", "User is not able to Select Route for Whats App Chat History");
    System.out.println("Select Route for Whats App Chat History validation success");
    ISLocatorDisplayed(GetLocator("SearchButton"), extentTest);
   // Boolean WhatsAppChatHistorySearchBtn = driver.findElement(GetLocator("SearchButton").getBy()).isDisplayed();
    click(GetLocator("SearchButton"), extentTest);
   // BooleanAsseration(WhatsAppChatHistorySearchBtn, extentTest, "User able to click Whats App Chat History Search Button", "User not able to click Whats App Chat History Search Button");
    //System.out.println("Whats App Chat History Search validation success");
    Thread.sleep(5000);
    
        return true;
    }
}