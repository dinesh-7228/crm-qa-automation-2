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
public class WidgetScreenPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();

    public WidgetScreenPage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Administration validation || Widget Screen validation")
    public boolean WidgetScreenData(ExtentTest extentTest, AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
        ISLocatorDisplayed(GetLocator("FilterBtn_OldPage"), extentTest);
        click(GetLocator("FilterBtn_OldPage"), extentTest);
        click(GetLocator("EditProductCategory"), extentTest);
        Thread.sleep(1000);
        ISLocatorDisplayed(GetLocator("Update_Button"), extentTest);
        click(GetLocator("Update_Button"), extentTest);
        Thread.sleep(5000);
        return true;
    }

}

