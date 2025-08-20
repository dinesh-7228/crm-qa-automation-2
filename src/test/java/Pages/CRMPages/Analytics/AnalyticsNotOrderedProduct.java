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
public class AnalyticsNotOrderedProduct extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsNotOrderedProduct(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-Not Ordered Product validation")
public boolean AnalyticsNotOrderedProductData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
    IsNavigationOpen(GetLocator("AnalyticsLink"), extentTest);
    Thread.sleep(2000);
    IsNavigationOpen(GetLocator("AnalyticsNotOrderedProductLink"), extentTest);
    Thread.sleep(10000);
  //  click(GetLocator("NotOrderedProductFromDate"), extentTest);
  //  Thread.sleep(2000);
  //  click(GetLocator("PreviousMonth"), extentTest);
  //  Thread.sleep(1000);
  //  click(GetLocator("DateSelect"), extentTest);
    click(GetLocator("Search_City_Filter"), extentTest);
    DropdownSelectfromListextent(GetLocator("Dropdown_value"),"Gurgaon" ,extentTest);
    click(GetLocator("SelectFranchise"), extentTest);
    DropdownSelectfromListextent(GetLocator("Dropdown_value"),"Gurgaon Ardee City" ,extentTest);
    dateselector_Past_date(GetLocator("NotOrderedProductFromDate"), extentTest);
    click(GetLocator("customer_status"), extentTest);
    DropdownSelectfromListextent(GetLocator("Dropdown_value_new"), "New",extentTest);
    click(GetLocator("Search_Product_Filter"), extentTest);
  //  ISLocatorDisplayed(GetLocator("EnterAnalyticsNotOrderedProductFranchise"), extentTest);
  //  Boolean AnalyticsNotOrderedProductFranchise = driver.findElement(GetLocator("EnterAnalyticsNotOrderedProductFranchise").getBy()).isDisplayed();
  //  click(GetLocator("EnterAnalyticsNotOrderedProductFranchise"), extentTest);
   // contextMenu(GetLocator("EnterAnalyticsNotOrderedProductFranchise"));
    //  EnterValue(GetLocator("EnterAnalyticsNotOrderedProductFranchise"),accountData.getCityName(), extentTest);
   // Thread.sleep(1000);
    click(GetLocator("SelectActiveStatus"), extentTest);
  //  BooleanAsseration(AnalyticsNotOrderedProductFranchise, extentTest, "User able to enter Analytics Not Ordered Product Franchise", "User not able to enter Analytics Not Ordered Product Franchise");
  //  System.out.println("Analytics Not Ordered Product Franchise validation success");
    
    ISLocatorDisplayed(GetLocator("NotOrderedProductCustomerStatus"), extentTest);
   // Boolean NotOrderedProductCustomerStatus = driver.findElement(GetLocator("NotOrderedProductCustomerStatus").getBy()).isDisplayed();
    click(GetLocator("NotOrderedProductCustomerStatus"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("SelectActiveStatus"), extentTest);
  //  BooleanAsseration(NotOrderedProductCustomerStatus, extentTest, "User able to select Not Ordered Product Customer Status", "User not able to select Not Ordered Product Customer Status");
  //  System.out.println("Not Ordered Product Customer Status validation success");
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("NotOrderedProductSelectProduct"), extentTest);
   // Boolean NotOrderedProductSelectProduct = driver.findElement(GetLocator("NotOrderedProductSelectProduct").getBy()).isDisplayed();
    click(GetLocator("NotOrderedProductSelectProduct"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("SelectFranchiseDropdown"), extentTest);
    Thread.sleep(2000);
   // BooleanAsseration(NotOrderedProductSelectProduct, extentTest, "User able to select Not Ordered Product Select Product", "User not able to select Not Ordered Product Select Product");
   // System.out.println("Not Ordered Product Select Product validation success");
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("AnalyticsNotOrderedProductSearchBtn"), extentTest);
   // Boolean AnalyticsNotOrderedProductSearchBtn = driver.findElement(GetLocator("AnalyticsNotOrderedProductSearchBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticsNotOrderedProductSearchBtn"), extentTest);
   // BooleanAsseration(AnalyticsNotOrderedProductSearchBtn, extentTest, "User able to click AnalyticsNotOrderedProduct Search Button", "User not able to click AnalyticsNotOrderedProduct Search Button");
   // System.out.println("AnalyticsNotOrderedProduct Search Button validation success");
    Thread.sleep(6000);
    ISLocatorDisplayed(GetLocator("AnalyticsNotOrderedProductExportBtn"), extentTest);
  //  Boolean AnalyticsNotOrderedProductExportBtn = driver.findElement(GetLocator("AnalyticsNotOrderedProductExportBtn").getBy()).isDisplayed();
    click(GetLocator("AnalyticsNotOrderedProductExportBtn"), extentTest);
  //  BooleanAsseration(AnalyticsNotOrderedProductExportBtn, extentTest, "User able to click AnalyticsNotOrderedProduct Export Button", "User not able to click AnalyticsNotOrderedProduct Export Button");
  //  System.out.println("AnalyticsNotOrderedProduct Export Button validation success");
    
    
        return true;
    }

}