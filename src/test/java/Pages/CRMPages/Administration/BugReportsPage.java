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
public class BugReportsPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public BugReportsPage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Administration validation || Bug Reports Page validation")
    public boolean BugReportsData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
    IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
    ISLocatorDisplayed(GetLocator("BugReportsLink"), extentTest);
    click(GetLocator("BugReportsLink"), extentTest);
    Thread.sleep(5000);
    ISLocatorDisplayed(GetLocator("SelectSource"), extentTest);
    click(GetLocator("SelectSource"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("SelectActiveStatus"), extentTest);
    Thread.sleep(1000);
    ISLocatorDisplayed(GetLocator("Search_Btn"), extentTest);
    click(GetLocator("Search_Btn"), extentTest);
    Thread.sleep(5000);
    Thread.sleep(5000);
        return true;
    }

}


