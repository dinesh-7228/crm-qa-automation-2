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
public class BillingReportPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public BillingReportPage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Funds validation || Funds-Funds Received validation")
public boolean BillingReportData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
    IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
    ISLocatorDisplayed(GetLocator("BillingReportLink"), extentTest);
   // Boolean BillingReportLinkPresent = driver.findElement(GetLocator("BillingReportLink").getBy()).isDisplayed();
   // BooleanAsseration(BillingReportLinkPresent, extentTest, "BillingReportLinkPresent Present", "BillingReportLinkPresent Not Present");
   // System.out.println("BillingReportLinkPresent validation success");
    Thread.sleep(3000);
    ISLocatorDisplayed(GetLocator("BillingReportLink"), extentTest);
   // Boolean BillingReportLinkClick = driver.findElement(GetLocator("BillingReportLink").getBy()).isDisplayed();
    click(GetLocator("BillingReportLink"), extentTest);
  //  BooleanAsseration(BillingReportLinkClick, extentTest, "BillingReport Link is clickable", "BillingReport Link Not clickable");
  //  System.out.println("BillingReport Link  Click validation success");
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("EnterCreditLimitCheckFranchise"), extentTest);
   // Boolean BillingReportFranchise = driver.findElement(GetLocator("EnterCreditLimitCheckFranchise").getBy()).isDisplayed();
    click(GetLocator("EnterCreditLimitCheckFranchise"), extentTest);
    EnterValue(GetLocator("EnterCreditLimitCheckFranchise"),accountData.getCityName(), extentTest);
    Thread.sleep(2000);
    click(GetLocator("SelectActiveStatus"), extentTest);
    Thread.sleep(2000);
   // BooleanAsseration(BillingReportFranchise, extentTest, "User able to enter BillingReport Franchise", "User not able to enter BillingReport Franchise");
   // System.out.println(" Franchise validation success");
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("SelectBrandPartnerDate"), extentTest);
  //  Boolean Date = driver.findElement(GetLocator("SelectBrandPartnerDate").getBy()).isDisplayed();
    click(GetLocator("SelectBrandPartnerDate"), extentTest);
    click(GetLocator("PreviousMonth"), extentTest);
    click(GetLocator("DateSelect"), extentTest);
   // BooleanAsseration(Date, extentTest, "User able to enter BillingReport date", "User not able to enter BillingReport date");
   // System.out.println("BillingReport date validation success");
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("BillingReportSearchBtn"), extentTest);
   // Boolean BillingReportSearchBtn = driver.findElement(GetLocator("BillingReportSearchBtn").getBy()).isDisplayed();
    click(GetLocator("BillingReportSearchBtn"), extentTest);
   // BooleanAsseration(BillingReportSearchBtn, extentTest, "User able to click BillingReport Search Button", "User not able to click BillingReport Search Button");
   // System.out.println("BillingReport Search Button validation success");
    Thread.sleep(60000);
    ISLocatorDisplayed(GetLocator("BillingReportExportBtn"), extentTest);
   // Boolean BillingReportExportBtn = driver.findElement(GetLocator("BillingReportExportBtn").getBy()).isDisplayed();
    click(GetLocator("BillingReportExportBtn"), extentTest);
  //  BooleanAsseration(BillingReportExportBtn, extentTest, "User able to click BillingReport Export Button", "User not able to click BillingReport Export Button");
  //  System.out.println("BillingReport Export Button validation success");
    
        return true;
    }
	
}