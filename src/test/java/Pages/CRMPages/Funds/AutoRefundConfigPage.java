package Pages.CRMPages.Funds;

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
public class AutoRefundConfigPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AutoRefundConfigPage (WebDriver driver) {

        this.driver = driver;
        
    }

    
    @Step("Auto Refund Config Validation || Auto Refund Config Page validation")
public boolean AutoRefundConfigData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {

  /*
    	Boolean FundsLinkPresent = driver.findElement(GetLocator("FundsLink").getBy()).isDisplayed();
        BooleanAsseration(FundsLinkPresent, extentTest, "Funds Link Present", "Funds Link Not Present");
        System.out.println("Funds Link Present validation success");
        Thread.sleep(3000);

        Boolean FundsLinkClick = driver.findElement(GetLocator("FundsLink").getBy()).isDisplayed();
        click(GetLocator("FundsLink"));
        BooleanAsseration(FundsLinkClick, extentTest, "Funds Link is clickable", "Funds Link Not clickable");
        System.out.println("Funds Link  Click validation success");
        Thread.sleep(1000);
      */
            IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
            ISLocatorDisplayed(GetLocator("AutoRefundConfigLink"), extentTest);
       // Boolean AutoRefundConfigLinkPresent = driver.findElement(GetLocator("AutoRefundConfigLink").getBy()).isDisplayed();
       // BooleanAsseration(AutoRefundConfigLinkPresent, extentTest, "Auto Refund Config Link Present", "Auto Refund Config Link Not Present");
       // System.out.println("Auto Refund Config Link Present validation success");
        Thread.sleep(10000);
        ISLocatorDisplayed(GetLocator("AutoRefundConfigLink"), extentTest);
        Boolean AutoRefundConfigLinkClick = driver.findElement(GetLocator("AutoRefundConfigLink").getBy()).isDisplayed();
        click(GetLocator("AutoRefundConfigLink"), extentTest);
     //   BooleanAsseration(AutoRefundConfigLinkClick, extentTest, "Auto Refund Config Link is clickable", "Auto Refund Config Link Not clickable");
     //   System.out.println("Auto Refund Config Link validation success");
        Thread.sleep(20000);
        ISLocatorDisplayed(GetLocator("GameConfigurationFilterBtn"), extentTest);
      //  Boolean GameConfigurationFilterBtnPresent = driver.findElement(GetLocator("GameConfigurationFilterBtn").getBy()).isDisplayed();
      //  BooleanAsseration(GameConfigurationFilterBtnPresent, extentTest, "Filter Button Present", "Filter Button Not Present");
      //  System.out.println("Filter Button validation success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("GameConfigurationFilterBtn"), extentTest);
      //  Boolean GameConfigurationFilterBtnClick = driver.findElement(GetLocator("GameConfigurationFilterBtn").getBy()).isDisplayed();
        click(GetLocator("GameConfigurationFilterBtn"), extentTest);
      //  BooleanAsseration(GameConfigurationFilterBtnClick, extentTest, "Filter Button Clickable", "Filter Button Not Clickable");
      //  System.out.println("Filter Button validation success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("AddAutoRefundConfigBtn"), extentTest);
      //  Boolean AddAutoRefundConfigBtnPresent = driver.findElement(GetLocator("AddAutoRefundConfigBtn").getBy()).isDisplayed();
      //  BooleanAsseration( AddAutoRefundConfigBtnPresent, extentTest, "Add Auto Refund Config Button Present", "Add Auto Refund Config Button Not Present");
      //  System.out.println("Add Auto Refund Config Button validation success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("AddAutoRefundConfigBtn"), extentTest);
    //    Boolean AddAutoRefundConfigBtnClick = driver.findElement(GetLocator("AddAutoRefundConfigBtn").getBy()).isDisplayed();
        click(GetLocator("AddAutoRefundConfigBtn"), extentTest);
     //   BooleanAsseration(AddAutoRefundConfigBtnClick, extentTest, "Filter Button Clickable", "Add Auto Refund Config Button Not Clickable");
     //   System.out.println("Add Auto Refund Config Button validation success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("EnterLsProductTypeCategory"), extentTest);
       // Boolean EnterLsProductTypeCategory= driver.findElement(GetLocator("EnterLsProductTypeCategory").getBy()).isDisplayed();
        click(GetLocator("EnterLsProductTypeCategory"), extentTest);
        EnterValue(GetLocator("EnterLsProductTypeCategory"),accountData.getConcernArea(), extentTest);
      //  BooleanAsseration(EnterLsProductTypeCategory, extentTest, "User able to enter Concern Area", "User not able to enter Concern Area");
      //  System.out.println("Concern Area Click Validation Success");
        Thread.sleep(2000);
       // click(GetLocator("SelectFranchiseDropdown"), extentTest);
        Thread.sleep(2000);
        
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
        click(GetLocator("SelectFranchiseDropdown"), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("ConcernLevel1"), extentTest);
       // Boolean ConcernLevel1= driver.findElement(GetLocator("ConcernLevel1").getBy()).isDisplayed();
        click(GetLocator("ConcernLevel1"), extentTest);
       // BooleanAsseration(ConcernLevel1, extentTest, "User able to enter Concern level 1", "User not able to enter Concern level 1");
       // System.out.println("Concern level 1 Click Validation Success");
        Thread.sleep(2000);
        click(GetLocator("SelectFranchiseDropdown"), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("RouteSaveBtn"), extentTest);
      //  Boolean RouteSaveBtnPresent = driver.findElement(GetLocator("RouteSaveBtn").getBy()).isDisplayed();
       // BooleanAsseration(RouteSaveBtnPresent, extentTest, "Save Button Present", "Save Button Not Present");
       // System.out.println("Save Button validation success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("RouteSaveBtn"), extentTest);
     //   Boolean RouteSaveBtnClick = driver.findElement(GetLocator("RouteSaveBtn").getBy()).isDisplayed();
        click(GetLocator("RouteSaveBtn"), extentTest);
     //   BooleanAsseration(RouteSaveBtnClick, extentTest, "Save Button Clickable", "Save Button Not Clickable");
     //   System.out.println("Save Button validation success");
        Thread.sleep(2000);
        click(GetLocator("VoiceNotePopUp"), extentTest);
        Thread.sleep(2000);

      

        return true;
    }}
        
        
