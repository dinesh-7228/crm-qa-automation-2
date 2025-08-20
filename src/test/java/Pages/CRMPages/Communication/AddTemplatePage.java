package Pages.CRMPages.Communication;

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
public class AddTemplatePage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AddTemplatePage (WebDriver driver) {

        this.driver = driver;
        
    }

    
    @Step("Add Template Page Validation || Add Template Page validation")
public boolean AddTemplateData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {

//    	IsNavigationOpen(GetLocator("Funds_navigation"), extentTest);
//	    Thread.sleep(1000);
	    
        ISLocatorDisplayed(GetLocator("Filter_btn"), extentTest);
        click(GetLocator("Filter_btn"), extentTest);
        Thread.sleep(4000);
        
        ISLocatorDisplayed(GetLocator("Select_Template_Mode"), extentTest);
        click(GetLocator("Select_Template_Mode"), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("Select_Mode"), extentTest);
        click(GetLocator("Select_Mode"), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("Submit_Button_New"), extentTest);
        click(GetLocator("Submit_Button_New"), extentTest);
        Thread.sleep(4000);
        
        ISLocatorDisplayed(GetLocator("Slide_Toggle_Active"), extentTest);
        click(GetLocator("Slide_Toggle_Active"), extentTest);
        Thread.sleep(2000);   
        ISLocatorDisplayed(GetLocator("Template_Status_Update"), extentTest);
        click(GetLocator("Template_Status_Update"), extentTest);
        Thread.sleep(4000);

        ISLocatorDisplayed(GetLocator("Slide_Toggle_Inactive"), extentTest);
        click(GetLocator("Slide_Toggle_Inactive"), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("Template_Status_Update"), extentTest);
        click(GetLocator("Template_Status_Update"), extentTest);
        Thread.sleep(4000);

        ISLocatorDisplayed(GetLocator("Edit_Template"), extentTest);
        click(GetLocator("Edit_Template"), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("Update_Template_Button"), extentTest);
        click(GetLocator("Update_Template_Button"), extentTest);
        Thread.sleep(4000);

        ISLocatorDisplayed(GetLocator("Select_Cancel_Button"), extentTest);
        click(GetLocator("Select_Cancel_Button"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Add_Template_Button"), extentTest);
        click(GetLocator("Add_Template_Button"), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("Select_Cancel_Button"), extentTest);
        click(GetLocator("Select_Cancel_Button"), extentTest);
        Thread.sleep(2000);

        
         return true;
    }
 }
        
        


