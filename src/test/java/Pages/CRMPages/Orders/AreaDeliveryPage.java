package Pages.CRMPages.Orders;

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
public class AreaDeliveryPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AreaDeliveryPage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Order validation || AreaDelivery validation")
public boolean AreaDeliveryData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
//    Boolean AdministrationLinkPresent = driver.findElement(GetLocator("AdministrationLink").getBy()).isDisplayed();
//    BooleanAsseration(AdministrationLinkPresent, extentTest, "AdminLink Present", "AdminLink Not Present");
//    System.out.println("AdminLink validation success");
//    Thread.sleep(3000);
//
//    Boolean AdministrationLinkClick = driver.findElement(GetLocator("AdministrationLink").getBy()).isDisplayed();
//    click(GetLocator("AdministrationLink"));
//    BooleanAsseration(AdministrationLinkClick, extentTest, "Administration Link is clickable", "Administration Link Not clickable");
//    System.out.println("Administration Link  Click validation success");
//    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("AreaDeliveryLink"), extentTest);
   // Boolean AreaDeliveryLinkPresent = driver.findElement(GetLocator("AreaDeliveryLink").getBy()).isDisplayed();
   // BooleanAsseration(AreaDeliveryLinkPresent, extentTest, "AreaDelivery Present", "AreaDelivery Not Present");
   // System.out.println("AreaDelivery Link validation success");
    ISLocatorDisplayed(GetLocator("AreaDeliveryLink"), extentTest);
   // Boolean AreaDeliveryLinkClick = driver.findElement(GetLocator("AreaDeliveryLink").getBy()).isDisplayed();
    click(GetLocator("AreaDeliveryLink"), extentTest);
   // BooleanAsseration(AreaDeliveryLinkClick, extentTest, "AreaDelivery Link Clickable", "AreaDelivery Link Not Clickable");
   // System.out.println("AreaDelivery Link Click validation success");
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("EnterAreaDeliveryFranchise"), extentTest);
  //  Boolean AreaDeliveryFranchise = driver.findElement(GetLocator("EnterAreaDeliveryFranchise").getBy()).isDisplayed();
    //click(GetLocator("EnterAreaDeliveryFranchise"));
    contextMenu(GetLocator("EnterAreaDeliveryFranchise"));
    EnterValue(GetLocator("EnterAreaDeliveryFranchise"),accountData.getCityName(), extentTest);
   // BooleanAsseration(AreaDeliveryFranchise, extentTest, "User able to enter Area DeliveryFranchise", "User not able to enter Area Delivery Franchise");
   // System.out.println("Order Tracker Franchise validation success");
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("AreaDeliverySearchBtn"), extentTest);
  //  Boolean AreaDeliverySearchBtn = driver.findElement(GetLocator("AreaDeliverySearchBtn").getBy()).isDisplayed();
    click(GetLocator("AreaDeliverySearchBtn"), extentTest);
  //  BooleanAsseration(AreaDeliverySearchBtn, extentTest, "User able to click AreaDelivery Search Button", "User not able to click AreaDelivery Search Button");
  //  System.out.println("AreaDelivery Search validation success");
    ISLocatorDisplayed(GetLocator("AreaDeliveryExportBtn"), extentTest);
  //  Boolean AreaDeliveryExportBtn = driver.findElement(GetLocator("AreaDeliveryExportBtn").getBy()).isDisplayed();
    click(GetLocator("AreaDeliveryExportBtn"), extentTest);
  //  BooleanAsseration(AreaDeliveryExportBtn, extentTest, "User able to click AreaDelivery Export Button", "User not able to click AreaDelivery Export Button");
  //  System.out.println("AreaDelivery Export validation success");
    
    return true;
    }

}