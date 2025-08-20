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
public class AddCampaignerPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AddCampaignerPage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Campaign validation || Retail Attendance Page validation")
public boolean AddCampaignerData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
ISLocatorDisplayed(GetLocator("AddCampaignerLink"), extentTest);
    Thread.sleep(3000);
    ISLocatorDisplayed(GetLocator("AddCampaignerLink"), extentTest);
    click(GetLocator("AddCampaignerLink"), extentTest);
    Thread.sleep(15000);
    ISLocatorDisplayed(GetLocator("EnterAddCampaignerName"), extentTest);
    click(GetLocator("EnterAddCampaignerName"), extentTest);
    EnterValue(GetLocator("EnterAddCampaignerName"),accountData.getLastName(), extentTest);
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("FilterBtn"), extentTest);
    click(GetLocator("FilterBtn"), extentTest);
    Thread.sleep(5000);
    if(IsDisplayed(GetLocator("EditProductCategory"))) {
        click(GetLocator("EditProductCategory"), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("UpdateBtn"), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("UpdateBtn"), extentTest);
        click(GetLocator("UpdateBtn"), extentTest);
        Thread.sleep(8000);
    }
        return true;
    }

}





