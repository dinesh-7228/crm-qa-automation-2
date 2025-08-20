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
public class AppBannerPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();

    public AppBannerPage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Administration validation || AppBanner Page validation")
    public boolean AppBannerData(ExtentTest extentTest, AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
        IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
        ISLocatorDisplayed(GetLocator("AppBannerLink"), extentTest);
        ISLocatorDisplayed(GetLocator("AppBannerLink"), extentTest);
        click(GetLocator("AppBannerLink"), extentTest);
        Thread.sleep(10000);
        ISLocatorDisplayed(GetLocator("SelectScreenName"), extentTest);
        click(GetLocator("SelectScreenName"), extentTest);
        click(GetLocator("SelectActiveStatus"), extentTest);
        System.out.println("Select App Banner Screen Name validation success");
        ISLocatorDisplayed(GetLocator("SelectAppBannerActive"), extentTest);
        DropdownSelectfromList(GetLocator("SelectAppBannerActive"), "Yes");
        ISLocatorDisplayed(GetLocator("FilterBtn_OldPage"), extentTest);
        click(GetLocator("FilterBtn_OldPage"), extentTest);
        Thread.sleep(5000);
        ISLocatorDisplayed(GetLocator("EditProductCategory"), extentTest);
        click(GetLocator("EditProductCategory"), extentTest);
        Thread.sleep(5000);
        ISLocatorDisplayed(GetLocator("Update_Button"), extentTest);
        click(GetLocator("Update_Button"), extentTest);
        Thread.sleep(7000);
        return true;
    }

}

