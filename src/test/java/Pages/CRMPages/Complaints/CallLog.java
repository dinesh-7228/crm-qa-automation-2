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
public class CallLog extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public CallLog (WebDriver driver) {

        this.driver = driver;
        
    }

    
    @Step("Non Delivery Set Priority Validation || Non Delivery Set Priority Page validation")
public boolean CallLogData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {

    	
//    	Boolean ComplaintLinkPresent = driver.findElement(GetLocator("ComplaintLink").getBy()).isDisplayed();
//        BooleanAsseration(ComplaintLinkPresent, extentTest, "Complaint Link Present", "Complaint Link Not Present");
//        System.out.println("Complaint Link Present validation success");
//        Thread.sleep(3000);
//
//        Boolean ComplaintLinkClick = driver.findElement(GetLocator("ComplaintLink").getBy()).isDisplayed();
//        click(GetLocator("ComplaintLink"));
//        BooleanAsseration(ComplaintLinkClick, extentTest, "Complaint Link is clickable", "Customer Link Not clickable");
//        System.out.println("Complaint Link Click validation success");
//        Thread.sleep(2000);
//    	
        ISLocatorDisplayed(GetLocator("CallLogLink"), extentTest);
      //  Boolean CallLogLinkPresent = driver.findElement(GetLocator("CallLogLink").getBy()).isDisplayed();
      //  BooleanAsseration(CallLogLinkPresent, extentTest, "Call Log Link Present", "Call Log Link Not Present");
      //  System.out.println("Call Log Link Present validation success");
        Thread.sleep(2000);

      //  Boolean CallLogLinkClick = driver.findElement(GetLocator("CallLogLink").getBy()).isDisplayed();
        click(GetLocator("CallLogLink"), extentTest);
      //  BooleanAsseration(CallLogLinkClick, extentTest, "CallLog Link is clickable", "CallLog Link Not clickable");
      //  System.out.println("CallLog Link Click validation success");
        Thread.sleep(25000);
 
        
      //  Boolean SelectCampaign = driver.findElement(GetLocator("CallLogSelectCampaign").getBy()).isDisplayed();
        click(GetLocator("CallLogSelectCampaign"), extentTest);
        Thread.sleep(2000);
        EnterValue(GetLocator("CallLogSelectCampaign"),accountData.getEnterCampaign(), extentTest);
        Thread.sleep(2000);
        click(GetLocator("SelectActiveStatus"),extentTest);
        Thread.sleep(2000);
      //  BooleanAsseration(SelectCampaign, extentTest, "User able to Select Campaign", "User not able to Select Campaign");
      //  System.out.println(" SelectCampaign Validation Success");
        Thread.sleep(6000);
        ISLocatorDisplayed(GetLocator("SearchButton"), extentTest);
       // Boolean SearchBtnPresent = driver.findElement(GetLocator("SearchButton").getBy()).isDisplayed();
       // BooleanAsseration(SearchBtnPresent, extentTest, "Search Button Present", "Search Button Not Present");
       // System.out.println("Search Button validation success");
        Thread.sleep(2000);

      //  Boolean SearchBtnClick = driver.findElement(GetLocator("SearchButton").getBy()).isDisplayed();
        click(GetLocator("SearchButton"), extentTest);
      //  BooleanAsseration(SearchBtnClick, extentTest, "Search Button Clickable", "Search Button Not Clickable");
       // System.out.println("Search Button validation success");
        Thread.sleep(10000);
        
                return true;
    }}
