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
public class AddComplaintPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AddComplaintPage (WebDriver driver) {

        this.driver = driver;
        
    }

    
    @Step("Add Complaint Validation || Add Complaint Page validation")
public boolean AddComplaintData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {

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
    
    	ISLocatorDisplayed(GetLocator("AddComplaintLink"), extentTest);
       // Boolean AddComplaintLinkPresent = driver.findElement(GetLocator("AddComplaintLink").getBy()).isDisplayed();
       // BooleanAsseration(AddComplaintLinkPresent, extentTest, "Add Complaint  Link Present", "Add Complaint Link Not Present");
       // System.out.println("Add Complaint Link Present validation success");
        Thread.sleep(5000);

       // Boolean AddComplaintLinkClick = driver.findElement(GetLocator("AddComplaintLink").getBy()).isDisplayed();
        click(GetLocator("AddComplaintLink"), extentTest);
       // BooleanAsseration(AddComplaintLinkClick, extentTest, "Add Complaint Link is clickable", "Late Complaint Link Not clickable");
       // System.out.println("Add Complaint Link Click validation success");
        Thread.sleep(10000);
 
        
       // Boolean SearchCustomerAddComplaint = driver.findElement(GetLocator("SearchCustomerAddComplaint").getBy()).isDisplayed();
        click(GetLocator("SearchCustomerAddComplaint"), extentTest);
        EnterValue(GetLocator("SearchCustomerAddComplaint"),accountData.getEnterPhoneNumber(), extentTest);
       // BooleanAsseration(SearchCustomerAddComplaint, extentTest, "User able to enter phone number", "User not able to enter phone number");
       // System.out.println("Phone number Validation Success");
        Thread.sleep(20000);
        click(GetLocator("AddComplaintSearchIcon"), extentTest);
        Thread.sleep(20000);
        click(GetLocator("SearchCustomerDropdown"), extentTest);
        Thread.sleep(2000);
        

       // Boolean EnterLsProductTypeCategory= driver.findElement(GetLocator("EnterLsProductTypeCategory").getBy()).isDisplayed();
        click(GetLocator("EnterLsProductTypeCategory"), extentTest);
       // BooleanAsseration(EnterLsProductTypeCategory, extentTest, "User able to enter Concern Area", "User not able to enter Concern Area");
        System.out.println("Concern Area Click Validation Success");
        Thread.sleep(2000);
        click(GetLocator("ConcernAreaDropdown"), extentTest);
        Thread.sleep(2000);
        
      //  Boolean ConcernType = driver.findElement(GetLocator("ConcernType").getBy()).isDisplayed();
        click(GetLocator("ConcernType"), extentTest);
      //  BooleanAsseration(ConcernType, extentTest, "User able to enter Concern Type", "User not able to enter Concern Type");
        System.out.println("Concern Type Click Validation Success");
        Thread.sleep(2000);
        click(GetLocator("ConcernTypeDropdown"), extentTest);
        Thread.sleep(2000);
        
      //  Boolean ConcernLevel1 = driver.findElement(GetLocator("ConcernLevel1").getBy()).isDisplayed();
        click(GetLocator("ConcernLevel1"), extentTest);
      //  BooleanAsseration(ConcernLevel1, extentTest, "User able to enter Concern Level 1", "User not able to enter Concern Level 1");
        System.out.println("Concern Level 1 Click Validation Success");
        Thread.sleep(2000);
        click(GetLocator("ConcernLevel1Dropdown"), extentTest);
        Thread.sleep(2000);
        
       // Boolean IssueTimeSlot = driver.findElement(GetLocator("IssueTimeSlot").getBy()).isDisplayed();
        click(GetLocator("IssueTimeSlot"), extentTest);
       // BooleanAsseration(IssueTimeSlot, extentTest, "User able to select Issue Time Slot", "User not able to select Issue Time Slot");
        System.out.println("Issue Time Slot Click Validation Success");
        Thread.sleep(2000);
        click(GetLocator("IssueTimeSlotDropdown"), extentTest);
        Thread.sleep(4000);
        
      //  Boolean AddComplaintBusinessSegment = driver.findElement(GetLocator("AddComplaintBusinessSegment").getBy()).isDisplayed();
        click(GetLocator("AddComplaintBusinessSegment"), extentTest);
      //  BooleanAsseration(AddComplaintBusinessSegment, extentTest, "User able to select Business Segment", "User not able to select Business Segment");
      //  System.out.println("Business Segment Click Validation Success");
        Thread.sleep(2000);
        click(GetLocator("BusinessSegmentDropdown"), extentTest);
        Thread.sleep(2000);
        
        
     //   Boolean CancelBtn = driver.findElement(GetLocator("CancelBtn").getBy()).isDisplayed();
        click(GetLocator("CancelBtn"), extentTest);
     //   BooleanAsseration(CancelBtn, extentTest, "User able to select Cancel Btn", "User not able to select Cancel Btn");
     //   System.out.println("Cancel Btn Click Validation Success");
        Thread.sleep(2000);

     //   Boolean EnterCityDescription = driver.findElement(GetLocator("EnterCityDescription").getBy()).isDisplayed();
        click(GetLocator("EnterCityDescription"), extentTest);
        EnterValue(GetLocator("EnterCityDescription"),accountData.getTestcaseid(), extentTest);
    //    BooleanAsseration(EnterCityDescription, extentTest, "User able to enter complaint description", "User not able to enter complaint description");
     //   System.out.println("complaint description Validation Success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("AddComplaintSaveBtn"), extentTest);
       // Boolean AddComplaintSaveBtnPresent = driver.findElement(GetLocator("AddComplaintSaveBtn").getBy()).isDisplayed();
       // BooleanAsseration(AddComplaintSaveBtnPresent, extentTest, "Save Button Present", "Save Button Not Present");
       // System.out.println("Save Button validation success");
        Thread.sleep(2000);

     //   Boolean AddComplaintSaveBtnClick = driver.findElement(GetLocator("AddComplaintSaveBtn").getBy()).isDisplayed();
        click(GetLocator("AddComplaintSaveBtn"), extentTest);
     //   BooleanAsseration(AddComplaintSaveBtnClick, extentTest, "Save Button Clickable", "Save Button Not Clickable");
     //   System.out.println("Save Button Click validation success");
        Thread.sleep(2000);
        click(GetLocator("AddComplaintOkBtn"), extentTest);
        Thread.sleep(2000);
        
        
        
        return true;
    }}
