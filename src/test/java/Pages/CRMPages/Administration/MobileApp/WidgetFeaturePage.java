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
public class WidgetFeaturePage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();

    public WidgetFeaturePage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Administration validation || Widget Feature validation")
    public boolean WidgetFeatureData(ExtentTest extentTest, AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
      //  IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
     //   ISLocatorDisplayed(GetLocator("WidgetFeatureLink"), extentTest);
     //   ISLocatorDisplayed(GetLocator("WidgetFeatureLink"), extentTest);
     //   click(GetLocator("WidgetFeatureLink"), extentTest);
        Thread.sleep(10000);
        ISLocatorDisplayed(GetLocator("EnterFeatureName"), extentTest);
        click(GetLocator("EnterFeatureName"), extentTest);
        EnterValue(GetLocator("EnterFeatureName"), accountData.getEnterFeatureName(), extentTest);
        ISLocatorDisplayed(GetLocator("FilterBtn_OldPage"), extentTest);
        click(GetLocator("FilterBtn_OldPage"), extentTest);
        Thread.sleep(2000);
        click(GetLocator("EditProductCategory"), extentTest);
        ISLocatorDisplayed(GetLocator("WidgetFeatureUpdateBtn"), extentTest);
        ISLocatorDisplayed(GetLocator("WidgetFeatureUpdateBtn"), extentTest);
        click(GetLocator("WidgetFeatureUpdateBtn"), extentTest);
        Thread.sleep(5000);
        return true;
    }

}

