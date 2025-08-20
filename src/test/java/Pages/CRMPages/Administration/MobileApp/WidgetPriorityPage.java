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
public class WidgetPriorityPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();

    public WidgetPriorityPage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Administration validation || Widget Priority validation")
    public boolean WidgetPriorityData(ExtentTest extentTest, AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
       // IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
     //   ISLocatorDisplayed(GetLocator("WidgetPriorityLink"), extentTest);
     //   ISLocatorDisplayed(GetLocator("WidgetPriorityLink"), extentTest);
      //  click(GetLocator("WidgetPriorityLink"), extentTest);
        ISLocatorDisplayed(GetLocator("EnterScreenName"), extentTest);
        click(GetLocator("EnterScreenName"), extentTest);
        EnterValue(GetLocator("EnterScreenName"), accountData.getEnterScreenName(), extentTest);
        ISLocatorDisplayed(GetLocator("FilterBtn_OldPage"), extentTest);
        click(GetLocator("FilterBtn_OldPage"), extentTest);
        Thread.sleep(4000);
        return true;
    }

}
