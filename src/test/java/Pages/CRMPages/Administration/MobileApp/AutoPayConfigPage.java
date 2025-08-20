package Pages.CRMPages.Administration.MobileApp;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

//import com.relevantcodes.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTest;
import Data.AccountData;
import FrameWork.BrowserAction;
import FrameWork.TestListner;
import io.qameta.allure.Step;

import java.io.IOException;

@Listeners(TestListner.class)
public class AutoPayConfigPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AutoPayConfigPage(WebDriver driver) {

        this.driver = driver;
    }
@Step("Administration validation || Auto-Pay Config Page validation")
public boolean AutoPayConfigData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
    ISLocatorDisplayed(GetLocator("AutoPay_New_Button"), extentTest);
    click(GetLocator("AutoPay_New_Button"), extentTest);

    ISLocatorDisplayed(GetLocator("Cancel_Button"), extentTest);
    click(GetLocator("Cancel_Button"), extentTest);

    ISLocatorDisplayed(GetLocator("Name_field"), extentTest);
    click(GetLocator("Name_field"), extentTest);
    EnterValue(GetLocator("Name_field"), "Test", extentTest);
    click(GetLocator("Filter_btn_new"), extentTest);

    click(GetLocator("Action_Button"), extentTest);
    click(GetLocator("Edit_Button"), extentTest);
    Thread.sleep(1000);

    ClearandEnterValue_New(GetLocator("Autopay_OfferName"), "Test123", extentTest);
    ClearandEnterValue_New(GetLocator("AppText"), "Test", extentTest);
    click(GetLocator("OnboardingFromDate"), extentTest);
    click(GetLocator("PreviousMonth"), extentTest);
    click(GetLocator("DateSelect"), extentTest);
    ClearandEnterValue_New(GetLocator("WalletAmount"), "200", extentTest);
    ClearandEnterValue_New(GetLocator("RechargeAmount"), "10", extentTest);
    DropdownSelectfromList(GetLocator("IsActive"), "No");
    Thread.sleep(1000);
    tabKey(GetLocator("Autopay_config_update"));
    click(GetLocator("Autopay_config_update"), extentTest);
    click(GetLocator("Cancel_Button"),extentTest);

   /*
    Boolean AddAutoPaySaveBtnPresent = driver.findElement(GetLocator("AddCitySaveBtn").getBy()).isDisplayed();
    BooleanAsseration(AddAutoPaySaveBtnPresent, extentTest, "Add Autopay Save Button Present", "Add Autopay Save Button Not Present");
    System.out.println("Add Autopay Save Button validation success");
    
    Boolean AddAutoPaySaveBtnClick = driver.findElement(GetLocator("AddCitySaveBtn").getBy()).isDisplayed();
    click(GetLocator("AddCitySaveBtn"), extentTest);
	BooleanAsseration(AddAutoPaySaveBtnClick, extentTest, "Add Autopay Save Button Clickable", "Add Autopay Save Button Not Clickable");
	System.out.println("Add Autopay Save Button validation success");
	Thread.sleep(6000);
*/
        return true;
    }

}
