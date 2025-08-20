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
public class AppPushUpdatePage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();

    public AppPushUpdatePage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Administration validation || App Push Update validation")
    public boolean AppPushUpdateData(ExtentTest extentTest, AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
      //  IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
      //  ISLocatorDisplayed(GetLocator("AppPushUpdateLink"), extentTest);
      //  ISLocatorDisplayed(GetLocator("AppPushUpdateLink"), extentTest);
      //  click(GetLocator("AppPushUpdateLink"), extentTest);
        Thread.sleep(5000);
        ISLocatorDisplayed(GetLocator("PushUpdateBtn"), extentTest);
        ISLocatorDisplayed(GetLocator("PushUpdateBtn"), extentTest);
        click(GetLocator("PushUpdateBtn"), extentTest);
        Thread.sleep(4000);
        return true;
    }

}



