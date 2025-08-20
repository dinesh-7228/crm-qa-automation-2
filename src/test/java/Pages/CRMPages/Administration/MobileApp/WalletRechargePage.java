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
public class WalletRechargePage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();

    public WalletRechargePage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Administration validation || Wallet Recharge Page validation")
    public boolean WalletRechargeData(ExtentTest extentTest, AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
      //  IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
      //  ISLocatorDisplayed(GetLocator("WalletRechargeLink"), extentTest);
      //  ISLocatorDisplayed(GetLocator("WalletRechargeLink"), extentTest);
      //  click(GetLocator("WalletRechargeLink"), extentTest);
        Thread.sleep(6000);
        ISLocatorDisplayed(GetLocator("RateReviewSelectCity"), extentTest);
        click(GetLocator("RateReviewSelectCity"), extentTest);
        EnterValue(GetLocator("RateReviewSelectCity"), accountData.getCityName(), extentTest);
        click(GetLocator("SelectActiveStatus"), extentTest);
        ISLocatorDisplayed(GetLocator("Search_Btn"), extentTest);
        click(GetLocator("Search_Btn"), extentTest);
        Thread.sleep(5000);
        ISLocatorDisplayed(GetLocator("EditProductCategory"), extentTest);
        click(GetLocator("EditProductCategory"), extentTest);
        Thread.sleep(5000);
        ISLocatorDisplayed(GetLocator("TagSaveBtn"), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("TagSaveBtn"), extentTest);
        click(GetLocator("TagSaveBtn"), extentTest);
        Thread.sleep(5000);
        //ISLocatorDisplayed(GetLocator("ViewRechargeConfig"), extentTest);
     //   click(GetLocator("ViewRechargeConfig"), extentTest);
       // Thread.sleep(5000);
       // click(GetLocator("CancelViewRechargeConfig"), extentTest);
        ISLocatorDisplayed(GetLocator("AddConfigurationBtn"), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("AddConfigurationBtn"), extentTest);
        click(GetLocator("AddConfigurationBtn"), extentTest);
        Thread.sleep(5000);
        ISLocatorDisplayed(GetLocator("City_dropdown"), extentTest);
        click(GetLocator("City_dropdown"), extentTest);
        click(GetLocator("Select_All_City"), extentTest);
        tabKey(GetLocator("AddConfigSelectCity"));
        ISLocatorDisplayed(GetLocator("AddConfigSelectUserType"), extentTest);
        click(GetLocator("AddConfigSelectUserType"), extentTest);
        click(GetLocator("SelectActiveStatus"), extentTest);
        ISLocatorDisplayed(GetLocator("AddConfigSelectPlaceholderType"), extentTest);
        click(GetLocator("AddConfigSelectPlaceholderType"), extentTest);
        Thread.sleep(2000);
        click(GetLocator("SelectActiveStatus"), extentTest);
        ISLocatorDisplayed(GetLocator("AddConfigSelectDynamicFormula"), extentTest);
        click(GetLocator("AddConfigSelectDynamicFormula"), extentTest);
        click(GetLocator("SelectFranchiseDropdown"), extentTest);
        ISLocatorDisplayed(GetLocator("AddConfigSelectCancelPopup"), extentTest);
        click(GetLocator("AddConfigSelectCancelPopup"), extentTest);
        Thread.sleep(2000);
        click(GetLocator("SelectActiveStatus"), extentTest);
        ISLocatorDisplayed(GetLocator("EnterCancelPopupText"), extentTest);
        click(GetLocator("EnterCancelPopupText"), extentTest);
        EnterValue(GetLocator("EnterCancelPopupText"), accountData.getLastName(), extentTest);
        ISLocatorDisplayed(GetLocator("AddConfigSelectRechargeTileType"), extentTest);
        click(GetLocator("AddConfigSelectRechargeTileType"), extentTest);
        click(GetLocator("SelectActiveStatus"), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("SelectRechargeTileDynamicFormula"), extentTest);
        click(GetLocator("SelectRechargeTileDynamicFormula"), extentTest);
        click(GetLocator("SelectFranchiseDropdown"), extentTest);
        ISLocatorDisplayed(GetLocator("SaveButton"), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("SaveButton"), extentTest);
        click(GetLocator("SaveButton"), extentTest);
        Thread.sleep(6000);
        return true;
    }

}


