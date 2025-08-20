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
public class CampaignerCollectionDetailPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public CampaignerCollectionDetailPage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Campaign validation || Campaign-CampaignerCollectionDetail validation")
public boolean CampaignerCollectionDetailData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
	Thread.sleep(20000);
    ISLocatorDisplayed(GetLocator("EnterCampaignerCollectionDetailCity"), extentTest);
    click(GetLocator("EnterCampaignerCollectionDetailCity"), extentTest);
    EnterValue(GetLocator("EnterCampaignerCollectionDetailCity"),accountData.getAddRegionEnterName(), extentTest);
    ISLocatorDisplayed(GetLocator("SearchButton"), extentTest);
    click(GetLocator("SearchButton"), extentTest);
    Thread.sleep(5000);
    ISLocatorDisplayed(GetLocator("CampainerCollectionExportButton"), extentTest);
    click(GetLocator("CampainerCollectionExportButton"), extentTest);
    Thread.sleep(3000);
        return true;
    }

}