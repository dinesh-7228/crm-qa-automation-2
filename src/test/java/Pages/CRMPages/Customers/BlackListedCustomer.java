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
public class BlackListedCustomer extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public BlackListedCustomer(WebDriver driver) {
        this.driver = driver;
    }
@Step("Customer validation || Customer-BlackListedCustomer Validation")
public boolean BlackListedCustomerData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
	  ISLocatorDisplayed(GetLocator("CustomerLink"),extentTest);
	//  Boolean CustomerLinkPresent = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
	//  BooleanAsseration(CustomerLinkPresent, extentTest, "Customer Link Present", "Customer Link Not Present");
	//  System.out.println("Customer Link validation success");
	//  Thread.sleep(10000);
    //  ISLocatorDisplayed(GetLocator("CustomerLink"), extentTest);
	//  Boolean CustomerLinkClick = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
	  click(GetLocator("CustomerLink"), extentTest);
	//  BooleanAsseration(CustomerLinkClick, extentTest, "Customer Link is clickable", "Customer Link Not clickable");
	//  System.out.println("Customer Link  Click validation success");
	  Thread.sleep(10000);
      ISLocatorDisplayed(GetLocator("BlackListedCustomerLink"), extentTest);
   // Boolean BlackListedCustomerLinkPresent = driver.findElement(GetLocator("BlackListedCustomerLink").getBy()).isDisplayed();
   // BooleanAsseration(BlackListedCustomerLinkPresent, extentTest, "Black Listed Customer Link Present", "Black Listed Customer Link Not Present");
   // System.out.println("Black Listed Customer validation success");
	//  Thread.sleep(10000);
    //ISLocatorDisplayed(GetLocator("BlackListedCustomerLink"), extentTest);
   //   Boolean BlackListedCustomerLinkClick = driver.findElement(GetLocator("BlackListedCustomerLink").getBy()).isDisplayed();
    click(GetLocator("BlackListedCustomerLink"), extentTest);
   // BooleanAsseration(BlackListedCustomerLinkClick, extentTest, "BlackListedCustomer Link is clickable", "BlackListedCustomer Link Not clickable");
   // System.out.println("BlackListedCustomer Link  Click validation success");
    Thread.sleep(12000);
    ISLocatorDisplayed(GetLocator("EnterBlackListedCustomerCity"), extentTest);
   // Boolean BlackListedCustomerSelectCity = driver.findElement(GetLocator("EnterBlackListedCustomerCity").getBy()).isDisplayed();
    click(GetLocator("EnterBlackListedCustomerCity"), extentTest);
    EnterValue(GetLocator("EnterBlackListedCustomerCity"),accountData.getCityName(), extentTest);
	  Thread.sleep(10000);
    click(GetLocator("SelectActiveStatus"), extentTest);
	  Thread.sleep(10000);
   // BooleanAsseration(BlackListedCustomerSelectCity, extentTest, "User able to enter BlackListed Customer Select City", "User not able to enter BlackListed Customer SelectCity");
   // System.out.println("BlackListed Customer Select City validation success");
    
  //  Boolean BlackListedCustomerSearchBtn = driver.findElement(GetLocator("BlackListedCustomerSearchBtn").getBy()).isDisplayed();
    click(GetLocator("BlackListedCustomerSearchBtn"), extentTest);
  //  BooleanAsseration(BlackListedCustomerSearchBtn, extentTest, "User able to click BlackListedCustomer Search Button", "User not able to click BlackListedCustomer Search Button");
  //  System.out.println("BlackListedCustomer Search Button validation success");
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("BlackListedCustomerExportBtn"), extentTest);
    //Boolean BlackListedCustomerExportBtn = driver.findElement(GetLocator("BlackListedCustomerExportBtn").getBy()).isDisplayed();
    click(GetLocator("BlackListedCustomerExportBtn"), extentTest);
   // BooleanAsseration(BlackListedCustomerExportBtn, extentTest, "User able to click BlackListedCustomer Export Button", "User not able to click BlackListedCustomer Export Button");
   // System.out.println("BlackListedCustomer Export Button validation success");
    Thread.sleep(6000);
    
        return true;
    }
}
