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
public class BenefitAmtTrackerPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public BenefitAmtTrackerPage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Funds validation || Funds-Funds Received validation")
public boolean BenefitAmtTrackerData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
    IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
        ISLocatorDisplayed(GetLocator("BenefitAmtTrackerLink"), extentTest);
  //      Boolean BenefitAmtTrackerLinkPresent = driver.findElement(GetLocator("BenefitAmtTrackerLink").getBy()).isDisplayed();
  //  BooleanAsseration(BenefitAmtTrackerLinkPresent, extentTest, "BenefitAmtTrackerLink Present", "BenefitAmtTrackerLink Not Present");
  //  System.out.println("BenefitAmtTrackerLinkPresent validation success");
    Thread.sleep(20000);
    ISLocatorDisplayed(GetLocator("BenefitAmtTrackerLink"), extentTest);
   // Boolean BenefitAmtTrackerLinkClick = driver.findElement(GetLocator("BenefitAmtTrackerLink").getBy()).isDisplayed();
    click(GetLocator("BenefitAmtTrackerLink"), extentTest);
   // BooleanAsseration(BenefitAmtTrackerLinkClick, extentTest, "BenefitAmtTracker Link is clickable", "BenefitAmtTracker Link Not clickable");
   // System.out.println("BenefitAmtTracker Link  Click validation success");
    Thread.sleep(50000);
    ISLocatorDisplayed(GetLocator("EnterCustomerID"), extentTest);
 //   Boolean CustID = driver.findElement(GetLocator("EnterCustomerID").getBy()).isDisplayed();
    click(GetLocator("EnterCustomerID"), extentTest);
    //contextMenu(GetLocator("EnterPlaceFreeOrderCustID"));
    EnterValue(GetLocator("EnterCustomerID"),accountData.getEnterCustomerID(), extentTest);
  //  BooleanAsseration(CustID, extentTest, "User able to enter BenefitAmtTracker Cust ID", "User not able to enter BenefitAmtTracker Cust ID");
  //  System.out.println("BenefitAmtTracker CustID validation success");
    Thread.sleep(10000);
   
    ISLocatorDisplayed(GetLocator("BenefitAmtTrackerSearchBtn"), extentTest);
   // Boolean BenefitAmtTrackerSearchBtn = driver.findElement(GetLocator("BenefitAmtTrackerSearchBtn").getBy()).isDisplayed();
    click(GetLocator("BenefitAmtTrackerSearchBtn"), extentTest);
   // BooleanAsseration(BenefitAmtTrackerSearchBtn, extentTest, "User able to click BenefitAmtTracker Search Button", "User not able to click BenefitAmtTracker Search Button");
   // System.out.println("BenefitAmtTracker Search Button validation success");
    
   
        return true;
    }

}