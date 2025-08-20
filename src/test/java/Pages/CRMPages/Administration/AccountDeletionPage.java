package Pages.CRMPages.Administration;
import Data.AccountData;
import FrameWork.BrowserAction;
import FrameWork.Locator;
import FrameWork.TestListner;
import FrameWork.TestRunner;
import android.provider.Browser;

//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Step;

import org.junit.runners.model.FrameworkMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
@Listeners(TestListner.class)
public class AccountDeletionPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AccountDeletionPage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Administration validation || Account Deletion Page validation")
    public boolean AccountDeletionData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
     IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
     ISLocatorDisplayed(GetLocator("AccountDeletionLink"), extentTest);
     ISLocatorDisplayed(GetLocator("AccountDeletionLink"), extentTest);
     click(GetLocator("AccountDeletionLink"), extentTest);
     ISLocatorDisplayed(GetLocator("AcceptDeletion"), extentTest);
     click(GetLocator("AcceptDeletion"), extentTest);
     click(GetLocator("SelectNo"), extentTest);
     ISLocatorDisplayed(GetLocator("RejectDeletion"), extentTest);
     click(GetLocator("RejectDeletion"), extentTest);
     EnterValue(GetLocator("RejectDeletionReason"),accountData.getMessageName(), extentTest);
     click(GetLocator("SelectReject"), extentTest);
     click(GetLocator("SelectNo"), extentTest);
     click(GetLocator("SelectCancel"), extentTest);
        return true;
    }

}





