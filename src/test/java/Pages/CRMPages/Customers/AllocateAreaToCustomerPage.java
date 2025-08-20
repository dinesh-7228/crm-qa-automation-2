package Pages.CRMPages.Customers;
import Data.AccountData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
//import com.relevantcodes.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTest;
import FrameWork.BrowserAction;
import FrameWork.TestListner;
import io.qameta.allure.Step;

import java.io.IOException;

@Listeners(TestListner.class)
public class AllocateAreaToCustomerPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AllocateAreaToCustomerPage (WebDriver driver) {
        this.driver = driver;
        
    }
    
    @Step("Allocate Area To Customer Page Validation || Allocate Area To Customer Page validation")
public boolean AllocateAreaToCustomerData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
        
//      Boolean CustomerLinkPresent = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
//        BooleanAsseration(CustomerLinkPresent, extentTest, "Customer Link Present", "Customer Link Not Present");
//        System.out.println("Customer Link Present validation success");
//        Thread.sleep(3000);
//
//        Boolean CustomerLinkClick = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
//        click(GetLocator("CustomerLink"));
//        BooleanAsseration(CustomerLinkClick, extentTest, "Customer Link is clickable", "Customer Link Not clickable");
//        System.out.println("Customer Link Click validation success");
//        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("AllocateAreaToCustomerLink"), extentTest);
       // Boolean AllocateAreaToCustomerLinkPresent = driver.findElement(GetLocator("AllocateAreaToCustomerLink").getBy()).isDisplayed();
       // BooleanAsseration(AllocateAreaToCustomerLinkPresent, extentTest, "Allocate Area To Customer Link Present", "Send Communication Link Not Present");
       // System.out.println("Allocate Area To Customer Link Present validation success");
        Thread.sleep(2000);
       // Boolean AllocateAreaToCustomerLinkClick = driver.findElement(GetLocator("AllocateAreaToCustomerLink").getBy()).isDisplayed();
        click(GetLocator("AllocateAreaToCustomerLink"), extentTest);
      //  BooleanAsseration(AllocateAreaToCustomerLinkClick, extentTest, "Allocate Area To Customer Link is clickable", "Ask Exact Location Link Not clickable");
      //  System.out.println("Allocate Area To Customer Link Click validation success");
        Thread.sleep(20000);
        
        
       // Boolean SelectCity = driver.findElement(GetLocator("SelectCity").getBy()).isDisplayed();
        click(GetLocator("SelectCity"), extentTest);
        EnterValue(GetLocator("SelectCity"),accountData.getCityName(), extentTest);
        Thread.sleep(4000);
        click(GetLocator("SelectCityDropdown"), extentTest);
        Thread.sleep(2000);
       // BooleanAsseration(SelectCity, extentTest, "User able to Select City", "User not able to SelectCity");
       // System.out.println("Select City validation success");
        
        ISLocatorDisplayed(GetLocator("GetCustomersBtn_Customer"), extentTest);
      //  Boolean GetCustomersBtnPresent = driver.findElement(GetLocator("GetCustomersBtn_Customer").getBy()).isDisplayed();
      //  BooleanAsseration(GetCustomersBtnPresent, extentTest, "Get Customers Button Clickable", "Get Customers Button Not Clickable");
      //  System.out.println("Get Customers Button validation success");
        Thread.sleep(10000);
        
      //  Boolean GetCustomersBtnClick = driver.findElement(GetLocator("GetCustomersBtn_Customer").getBy()).isDisplayed();
        click(GetLocator("GetCustomersBtn_Customer"), extentTest);
      //  BooleanAsseration(GetCustomersBtnClick, extentTest, "Get Customers Button Clickable", "Get Customers Button Not Clickable");
      //  System.out.println("Get Customers Button validation success");
         Thread.sleep(10000);
        
         click(GetLocator("SelectAreatoAllocate"), extentTest);
         Thread.sleep(5000);
         click(GetLocator("SelectFranchiseDropdown"), extentTest);
         Thread.sleep(5000);
       //  Boolean SaveBtnClick = driver.findElement(GetLocator("SaveButton").getBy()).isDisplayed();
         click(GetLocator("SaveButton"), extentTest);
       // BooleanAsseration(SaveBtnClick, extentTest, "Save Button Clickable", "Save Button Not Clickable");
       // System.out.println("Allocate Area Save validation success");
         Thread.sleep(15000);
         
//        Boolean GetSummaryTableBtnPresent = driver.findElement(GetLocator("GetSummaryTableBtn").getBy()).isDisplayed();
//          BooleanAsseration(GetSummaryTableBtnPresent, extentTest, "Get Summary Button Clickable", "Get Summary Button Not Clickable");
//          System.out.println("Get Summary Button validation success");
//          Thread.sleep(1000);
//          
//          Boolean GetSummaryTableBtnClick = driver.findElement(GetLocator("GetSummaryTableBtn").getBy()).isDisplayed();
//          click(GetLocator("GetSummaryTableBtn"));
//          BooleanAsseration(GetSummaryTableBtnClick, extentTest, "Get Summary Button Clickable", "Get Summary Button Not Clickable");
//          System.out.println("Get Summary Button Click validation success");
//           Thread.sleep(35000);
        
        
        return true;
        
    }}
