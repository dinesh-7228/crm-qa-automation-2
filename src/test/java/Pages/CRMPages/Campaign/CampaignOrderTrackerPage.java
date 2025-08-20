package Pages.CRMPages.Campaign;

import Data.AccountData;
import FrameWork.BrowserAction;
import FrameWork.Locator;
import FrameWork.TestListner;
import FrameWork.TestRunner;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
@Listeners(TestListner.class)
public class CampaignOrderTrackerPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public CampaignOrderTrackerPage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Campaign validation || Campaign-Campaign Order Tracker validation")
public boolean CampaignOrderTrackerData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
//	 ISLocatorDisplayed(GetLocator("CampaignOrderTrackerLink"), extentTest);
//   Thread.sleep(3000);
//    click(GetLocator("CampaignOrderTrackerLink"), extentTest);
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("CampaignOrderTrackerFromDate"), extentTest);
    click(GetLocator("CampaignOrderTrackerFromDate"), extentTest);
    click(GetLocator("PreviousMonth"), extentTest);
    click(GetLocator("DateSelect"), extentTest);
    Thread.sleep(1000);
    ISLocatorDisplayed(GetLocator("SearchButton"), extentTest);
  click(GetLocator("SearchButton"), extentTest);
    Thread.sleep(10000);

    click(GetLocator("ViewCampaignOrderTracker"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("CancelViewCampaignOrderTracker"), extentTest);
    Thread.sleep(1000);
    
        return true;
    }

}