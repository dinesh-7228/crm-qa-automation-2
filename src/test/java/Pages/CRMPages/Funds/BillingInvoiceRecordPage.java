package Pages.CRMPages.Funds;

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
public class BillingInvoiceRecordPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public BillingInvoiceRecordPage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Funds validation || Funds-Funds Received validation")
public boolean BillingInvoiceRecordData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
    IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
        ISLocatorDisplayed(GetLocator("BillingInvoiceRecordLink"), extentTest);
  //      Boolean BillingInvoiceRecordLinkPresent = driver.findElement(GetLocator("BillingInvoiceRecordLink").getBy()).isDisplayed();
  //  BooleanAsseration(BillingInvoiceRecordLinkPresent, extentTest, "BillingInvoiceRecordLinkPresent Present", "BillingInvoiceRecordLinkPresent Not Present");
  //  System.out.println("BillingInvoiceRecordLinkPresent validation success");
    Thread.sleep(3000);
    ISLocatorDisplayed(GetLocator("BillingInvoiceRecordLink"), extentTest);
  //  Boolean BillingInvoiceRecordLinkClick = driver.findElement(GetLocator("BillingInvoiceRecordLink").getBy()).isDisplayed();
    click(GetLocator("BillingInvoiceRecordLink"), extentTest);
  //  BooleanAsseration(BillingInvoiceRecordLinkClick, extentTest, "BillingInvoiceRecord Link is clickable", "BillingInvoiceRecord Link Not clickable");
  //  System.out.println("BillingInvoiceRecord Link  Click validation success");
    Thread.sleep(10000);
    
//    Boolean BillingInvoiceRecordFranchise = driver.findElement(GetLocator("EnterCreditLimitCheckFranchise").getBy()).isDisplayed();
//    click(GetLocator("EnterCreditLimitCheckFranchise"));
//    EnterValue(GetLocator("EnterCreditLimitCheckFranchise"),accountData.getCityName());
//    Thread.sleep(2000);
//    click(GetLocator("SelectActiveStatus"));
//    Thread.sleep(2000);
//    BooleanAsseration(BillingInvoiceRecordFranchise, extentTest, "User able to enter BillingInvoiceRecord Franchise", "User not able to enter BillingInvoiceRecord Franchise");
//    System.out.println(" Franchise validation success");
//    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("EnterCustomerID"), extentTest);
 //   Boolean CustID = driver.findElement(GetLocator("EnterCustomerID").getBy()).isDisplayed();
    click(GetLocator("EnterCustomerID"), extentTest);
    //contextMenu(GetLocator("EnterPlaceFreeOrderCustID"));
    EnterValue(GetLocator("EnterCustomerID"),accountData.getEnterCustomerID(), extentTest);
 //   BooleanAsseration(CustID, extentTest, "User able to enter BenefitAmtTracker Cust ID", "User not able to enter BenefitAmtTracker Cust ID");
 //   System.out.println("BenefitAmtTracker CustID validation success");
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("BillingInvoiceRecordSearchBtn"), extentTest);
  //  Boolean BillingInvoiceRecordSearchBtn = driver.findElement(GetLocator("BillingInvoiceRecordSearchBtn").getBy()).isDisplayed();
    click(GetLocator("BillingInvoiceRecordSearchBtn"), extentTest);
 //   BooleanAsseration(BillingInvoiceRecordSearchBtn, extentTest, "User able to click BillingInvoiceRecord Search Button", "User not able to click BillingInvoiceRecord Search Button");
 //   System.out.println("BillingInvoiceRecord Search Button validation success");
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("BillingInvoiceRecordExportBtn"), extentTest);
 //   Boolean BillingInvoiceRecordExportBtn = driver.findElement(GetLocator("BillingInvoiceRecordExportBtn").getBy()).isDisplayed();
    click(GetLocator("BillingInvoiceRecordExportBtn"), extentTest);
 //   BooleanAsseration(BillingInvoiceRecordExportBtn, extentTest, "User able to click BillingInvoiceRecord Export Button", "User not able to click BillingInvoiceRecord Export Button");
 //   System.out.println("BillingInvoiceRecord Export Button validation success");
    
        return true;
    }

}