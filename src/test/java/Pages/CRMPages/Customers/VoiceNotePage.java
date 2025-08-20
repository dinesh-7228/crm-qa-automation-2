package Pages.CRMPages.Customers;

import Data.AccountData;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

//import com.relevantcodes.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTest;
import FrameWork.BrowserAction;
import FrameWork.TestListner;
import io.qameta.allure.Step;

import java.io.IOException;

@Listeners(TestListner.class)
public class VoiceNotePage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public VoiceNotePage (WebDriver driver) {

        this.driver = driver;
        
    }

    
    @Step("Voice Note Validation || Voice Note Page validation")
public boolean VoiceNoteData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {

    /*	
    	Boolean CustomerLinkPresent = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
        BooleanAsseration(CustomerLinkPresent, extentTest, "Customer Link Present", "Customer Link Not Present");
        System.out.println("Customer Link Present validation success");
        Thread.sleep(3000);

        Boolean CustomerLinkClick = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
        click(GetLocator("CustomerLink"));
        BooleanAsseration(CustomerLinkClick, extentTest, "Customer Link is clickable", "Customer Link Not clickable");
        System.out.println("Customer Link Click validation success");
        Thread.sleep(2000);
    	
    */	
        
        Boolean PreferenceVoiceNoteClickPresent = driver.findElement(GetLocator("PreferenceVoiceNoteClick").getBy()).isDisplayed();
        BooleanAsseration(PreferenceVoiceNoteClickPresent, extentTest, "Preference Voice Note Link Present", "Preference Voice Note Not Present");
        System.out.println("Preference Voice Note Link Present validation success");
        Thread.sleep(2000);

        Boolean PreferenceVoiceNoteClick = driver.findElement(GetLocator("CriteriaCustomerLink").getBy()).isDisplayed();
        click(GetLocator("PreferenceVoiceNoteClick"), extentTest);
        BooleanAsseration(PreferenceVoiceNoteClick, extentTest, "Preference Voice Note Link is clickable", "Preference Voice Note Link Not clickable");
        System.out.println("Preference Voice Note Link Click validation success");
        Thread.sleep(2000);
        
        click(GetLocator("PushDate"), extentTest);
        click(GetLocator("PreviousMonth"), extentTest);
        click(GetLocator("PreviousMonth"), extentTest);
        click(GetLocator("PreviousMonth"), extentTest);
        click(GetLocator("DateSelect"), extentTest);
        Thread.sleep(3000);
        
        Boolean NonServiceableSearchBtnPresent = driver.findElement(GetLocator("NonServiceableSearchBtn").getBy()).isDisplayed();
        BooleanAsseration(NonServiceableSearchBtnPresent, extentTest, "Search Button Present", "Search Button Not Present");
        System.out.println("Search Button Present validation success");
        Thread.sleep(2000);

        Boolean NonServiceableSearchBtnClick = driver.findElement(GetLocator("NonServiceableSearchBtn").getBy()).isDisplayed();
        click(GetLocator("NonServiceableSearchBtn"), extentTest);
        BooleanAsseration(NonServiceableSearchBtnClick, extentTest, "Search Button Clickable", "Search Button Not Clickable");
        System.out.println("Search Button Click validation success");
        Thread.sleep(10000);
        
        Boolean VoiceNoteCheckbox = driver.findElement(GetLocator("VoiceNoteCheckbox").getBy()).isDisplayed();
        click(GetLocator("VoiceNoteCheckbox"), extentTest);
        BooleanAsseration(VoiceNoteCheckbox, extentTest, "Checkbox Clickable", "Checkbox Not Clickable");
        System.out.println("Checkbox click validation success");
        Thread.sleep(2000);
        
        Boolean AcceptVoiceNoteBtnPresent = driver.findElement(GetLocator("AcceptVoiceNoteBtn").getBy()).isDisplayed();
        BooleanAsseration(AcceptVoiceNoteBtnPresent, extentTest, "Accept Button Present", "Accept Button Not Present");
        System.out.println("Accept Button validation success");
        Thread.sleep(2000);

        Boolean AcceptVoiceNoteBtnClick = driver.findElement(GetLocator("AcceptVoiceNoteBtn").getBy()).isDisplayed();
        click(GetLocator("AcceptVoiceNoteBtn"), extentTest);
        BooleanAsseration(AcceptVoiceNoteBtnClick, extentTest, "Accept Button Clickable", "Accept Button Not Clickable");
        System.out.println("Accept Button validation success");
        Thread.sleep(1000);
        click(GetLocator("VoiceNotePopUp"), extentTest);
        Thread.sleep(2000);
        
        Boolean VoiceNoteCheckboxClick2 = driver.findElement(GetLocator("VoiceNoteCheckbox").getBy()).isDisplayed();
        click(GetLocator("VoiceNoteCheckbox"), extentTest);
        BooleanAsseration(VoiceNoteCheckboxClick2, extentTest, "Checkbox Clickable", "Checkbox Not Clickable");
        System.out.println("Checkbox click validation success");
        Thread.sleep(2000);
        
        Boolean RejectVoiceNoteBtnPresent = driver.findElement(GetLocator("RejectVoiceNoteBtn").getBy()).isDisplayed();
        BooleanAsseration(RejectVoiceNoteBtnPresent, extentTest, "Accept Button Present", "Accept Button Not Present");
        System.out.println("Accept Button validation success");
        Thread.sleep(2000);

        Boolean RejectVoiceNoteBtnClick = driver.findElement(GetLocator("RejectVoiceNoteBtn").getBy()).isDisplayed();
        click(GetLocator("RejectVoiceNoteBtn"), extentTest);
        BooleanAsseration(RejectVoiceNoteBtnClick, extentTest, "Reject Button Clickable", "Reject Button Not Clickable");
        System.out.println("Reject Button validation success");
        Thread.sleep(20000);
        click(GetLocator("VoiceNotePopUp"), extentTest);
        Thread.sleep(4000);

        
        return true;
        
    }}

       