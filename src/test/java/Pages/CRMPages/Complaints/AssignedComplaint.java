
package Pages.CRMPages.Complaints;

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
public class AssignedComplaint extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AssignedComplaint (WebDriver driver) {

        this.driver = driver;
        
    }
 
    @Step("Complaint Validation || Assigned Complaint Page validation")
public boolean AssignedComplaintData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {

    /*	
    	Boolean ComplaintLinkPresent = driver.findElement(GetLocator("ComplaintLink").getBy()).isDisplayed();
        BooleanAsseration(ComplaintLinkPresent, extentTest, "Complaint Link Present", "Complaint Link Not Present");
        System.out.println("Complaint Link Present validation success");
        Thread.sleep(3000);

        Boolean ComplaintLinkClick = driver.findElement(GetLocator("ComplaintLink").getBy()).isDisplayed();
        click(GetLocator("ComplaintLink"));
        BooleanAsseration(ComplaintLinkClick, extentTest, "Complaint Link is clickable", "Customer Link Not clickable");
        System.out.println("Complaint Link Click validation success");
        Thread.sleep(2000);
    */	
        ISLocatorDisplayed(GetLocator("AssignedComplaintLink"), extentTest);
      //  Boolean AssignedComplaintLinkPresent = driver.findElement(GetLocator("AssignedComplaintLink").getBy()).isDisplayed();
      //  BooleanAsseration(AssignedComplaintLinkPresent, extentTest, "Assigned Complaint Link Present", "Assigned Complaint Link Not Present");
      //  System.out.println("Assigned Complaint Link Present validation success");
        Thread.sleep(5000);
        ISLocatorDisplayed(GetLocator("AssignedComplaintLink"), extentTest);
       // Boolean AssignedComplaintLinkClick = driver.findElement(GetLocator("AssignedComplaintLink").getBy()).isDisplayed();
        click(GetLocator("AssignedComplaintLink"), extentTest);
       // BooleanAsseration(AssignedComplaintLinkClick, extentTest, "Assigned Complaint Link is clickable", "Assigned Complaint Link Not clickable");
       // System.out.println("Assigned Complaint Link Click validation success");
        Thread.sleep(10000);
 
       // Boolean CreditLimitCheckFranchise = driver.findElement(GetLocator("EnterCreditLimitCheckFranchise").getBy()).isDisplayed();
        click(GetLocator("EnterCreditLimitCheckFranchise"), extentTest);
        EnterValue(GetLocator("EnterCreditLimitCheckFranchise"),accountData.getCityName(), extentTest);
        Thread.sleep(2000);
        click(GetLocator("SelectActiveStatus"), extentTest);
      //  Thread.sleep(2000);
       // BooleanAsseration(CreditLimitCheckFranchise, extentTest, "User able to enter Franchise", "User not able to enter Franchise");
       // System.out.println(" Franchise validation success");
        ISLocatorDisplayed(GetLocator("ReviewDeliveryTimeSearch"), extentTest);
       // Boolean ReviewDeliveryTimeSearchPresent = driver.findElement(GetLocator("ReviewDeliveryTimeSearch").getBy()).isDisplayed();
       // BooleanAsseration(ReviewDeliveryTimeSearchPresent, extentTest, "Search Button Present", "Search Button Not Present");
       // System.out.println("Search Button validation success");
       // Thread.sleep(20000);
        ISLocatorDisplayed(GetLocator("ReviewDeliveryTimeSearch"), extentTest);
       // Boolean ReviewDeliveryTimeSearchClick = driver.findElement(GetLocator("ReviewDeliveryTimeSearch").getBy()).isDisplayed();
        click(GetLocator("ReviewDeliveryTimeSearch"), extentTest);
       // BooleanAsseration(ReviewDeliveryTimeSearchClick, extentTest, "Search Button Clickable", "Search Button Not Clickable");
       // System.out.println("Search Button validation success");
       // Thread.sleep(20000);
        ISLocatorDisplayed(GetLocator("ReviewDeliveryTimeExport"), extentTest);
     //   Boolean ReviewDeliveryTimeExportPresent = driver.findElement(GetLocator("ReviewDeliveryTimeExport").getBy()).isDisplayed();
      //  BooleanAsseration(ReviewDeliveryTimeExportPresent, extentTest, "Generate Export Button Present", "Generate Export Button Not Present");
      //  System.out.println("Generate Export Button validation success");
       // Thread.sleep(10000);
        ISLocatorDisplayed(GetLocator("ReviewDeliveryTimeExport"), extentTest);
        //Boolean ReviewDeliveryTimeExportBtnClick = driver.findElement(GetLocator("ReviewDeliveryTimeExport").getBy()).isDisplayed();
        click(GetLocator("ReviewDeliveryTimeExport"), extentTest);
      //  BooleanAsseration(ReviewDeliveryTimeExportBtnClick, extentTest, "Generate Export Button Clickable", "Generate Export Not Clickable");
       // System.out.println("Generate Export click validation success");
        Thread.sleep(4000);
      
        
        return true;
    }}
