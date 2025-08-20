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
public class CashHPPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public CashHPPage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Customer validation || Customer-Cash HP validation") 
public boolean CashHPData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
	ISLocatorDisplayed(GetLocator("CustomerLink"), extentTest);
     //   Boolean CustomerLinkPresent = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
//	BooleanAsseration(CustomerLinkPresent, extentTest, "Customer Link Present", "Customer Link Not Present");
	//System.out.println("Customer Link validation success");
	Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("CustomerLink"), extentTest);
	//Boolean CustomerLinkClick = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
	click(GetLocator("CustomerLink"), extentTest);
	//BooleanAsseration(CustomerLinkClick, extentTest, "Customer Link is clickable", "Customer Link Not clickable");
	//System.out.println("Customer Link  Click validation success");
	Thread.sleep(2000);
	ISLocatorDisplayed(GetLocator("CashHPLink"), extentTest);
   // Boolean CashHPLinkPresent = driver.findElement(GetLocator("CashHPLink").getBy()).isDisplayed();
   // BooleanAsseration(CashHPLinkPresent, extentTest, "CashHPLinkPresent Present", "CashHPLinkPresent Not Present");
   // System.out.println("CashHPLinkPresent validation success");
    Thread.sleep(20000);
    ISLocatorDisplayed(GetLocator("CashHPLink"), extentTest);
   // Boolean CashHPLinkClick = driver.findElement(GetLocator("CashHPLink").getBy()).isDisplayed();
    click(GetLocator("CashHPLink"), extentTest);
  //  BooleanAsseration(CashHPLinkClick, extentTest, "CashHP Link is clickable", "CashHP Link Not clickable");
  //  System.out.println("CashHP Link  Click validation success");
    Thread.sleep(15000);
    ISLocatorDisplayed(GetLocator("EnterCashHpFranchise"),extentTest);
    //Boolean CashHpFranchise = driver.findElement(GetLocator("EnterCashHpFranchise").getBy()).isDisplayed();
    click(GetLocator("EnterCashHpFranchise"), extentTest);
 // EnterValue(GetLocator("EnterCashHpFranchise"),accountData.getRouteFranchise());
    Thread.sleep(3000);
    click(GetLocator("SelectActiveStatus"), extentTest);
    Thread.sleep(2000);
    //BooleanAsseration(CashHpFranchise, extentTest, "User able to enter Cash HP Franchise", "User not able to enter Cash HP Franchise");
   // System.out.println("Cash HP Franchise validation success");
    ISLocatorDisplayed(GetLocator("SetPenaltyArea"), extentTest);
  //  Boolean CashHPAreaSelect = driver.findElement(GetLocator("SetPenaltyArea").getBy()).isDisplayed();
    click(GetLocator("SetPenaltyArea"),extentTest);
    Thread.sleep(3000);
    click(GetLocator("SelectActiveStatus"),extentTest);
    Thread.sleep(3000);
    //BooleanAsseration(CashHPAreaSelect, extentTest, "User able to select Cash HP Area", "User not able to select Cash HP Area");
    //System.out.println("Select Cash HP Area validation success");
    ISLocatorDisplayed(GetLocator("CashHPSearchBtn"), extentTest);
    //Boolean CashHPSearchBtn = driver.findElement(GetLocator("CashHPSearchBtn").getBy()).isDisplayed();
    click(GetLocator("CashHPSearchBtn"), extentTest);
   // BooleanAsseration(CashHPSearchBtn, extentTest, "User able to click CashHP Search Button", "User not able to click CashHP Search Button");
   // System.out.println("CashHP Search Button validation success");
    Thread.sleep(6000);
    ISLocatorDisplayed(GetLocator("CashHPExportBtn"), extentTest);
   // Boolean CashHPExportBtn = driver.findElement(GetLocator("CashHPExportBtn").getBy()).isDisplayed();
    click(GetLocator("CashHPExportBtn"), extentTest);
   // BooleanAsseration(CashHPExportBtn, extentTest, "User able to click CashHP Export Button", "User not able to click CashHP Export Button");
   // System.out.println("CashHP Export Button validation success");
    Thread.sleep(2000);

    
        return true;
    }

}