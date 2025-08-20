package Pages.CRMPages.Orders;
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
public class ViewIndentPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public ViewIndentPage(WebDriver driver) {
        this.driver = driver;
    }
@Step("Order validation || ViewIndent validation")
public boolean ViewIndentData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
//  Boolean OrderLinkPresent = driver.findElement(GetLocator("OrderLink").getBy()).isDisplayed();
//  BooleanAsseration(OrderLinkPresent, extentTest, "Order Link Present", "Order Link Not Present");
//  System.out.println("Order Link validation success");
//  Thread.sleep(2000);
//
//  Boolean OrderLinkClick = driver.findElement(GetLocator("OrderLink").getBy()).isDisplayed();
//  click(GetLocator("OrderLink"));
//  BooleanAsseration(OrderLinkClick, extentTest, "Order Link is clickable", "Order Link Not clickable");
//  System.out.println("Order Link  Click validation success");
//  Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("ViewIndentLink"), extentTest);
   // Boolean ViewIndentLinkPresent = driver.findElement(GetLocator("ViewIndentLink").getBy()).isDisplayed();
   // BooleanAsseration(ViewIndentLinkPresent, extentTest, "ViewIndent Present", "ViewIndent Not Present");
   // System.out.println("ViewIndent Link validation success");
    ISLocatorDisplayed(GetLocator("ViewIndentLink"), extentTest);
   // Boolean ViewIndentLinkClick = driver.findElement(GetLocator("ViewIndentLink").getBy()).isDisplayed();
    click(GetLocator("ViewIndentLink"), extentTest);
   // BooleanAsseration(ViewIndentLinkClick, extentTest, "ViewIndent Link Clickable", "ViewIndent Link Not Clickable");
   // System.out.println("ViewIndent Link Click validation success");
    Thread.sleep(6000);
    ISLocatorDisplayed(GetLocator("ViewIndentGenerateBtn"), extentTest);
   // Boolean ViewIndentGenerateBtn = driver.findElement(GetLocator("ViewIndentGenerateBtn").getBy()).isDisplayed();
    click(GetLocator("ViewIndentGenerateBtn"), extentTest);
   // BooleanAsseration(ViewIndentGenerateBtn, extentTest, "User able to click ViewIndent Generate Button", "User not able to click ViewIndent Generate Button");
   // System.out.println("ViewIndent Generate validation success");
    Thread.sleep(6000);
    ISLocatorDisplayed(GetLocator("CustomSearchFromDate"), extentTest);
  //  Boolean CustomSearchFromDateSelect = driver.findElement(GetLocator("CustomSearchFromDate").getBy()).isDisplayed();
    click(GetLocator("CustomSearchFromDate"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("DateSelect"), extentTest);
    Thread.sleep(1000);
  //  BooleanAsseration(CustomSearchFromDateSelect, extentTest, "User able to select Custom Search From Date", "User not able to search Custom Search From Date");
    //System.out.println("Custom Search From Date validation success");
    ISLocatorDisplayed(GetLocator("CustomSearchBtn"), extentTest);
   // Boolean CustomSearchBtnClick = driver.findElement(GetLocator("CustomSearchBtn").getBy()).isDisplayed();
    click(GetLocator("CustomSearchBtn"), extentTest);
   // BooleanAsseration(CustomSearchBtnClick, extentTest, "User able to click GenerateRouteSheet Generate Button", "User not able to click GenerateRouteSheet Generate Button");
   // System.out.println("GenerateRouteSheet Generate validation success");
    Thread.sleep(6000);
    return true;
    }
}














