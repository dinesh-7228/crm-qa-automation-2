package Pages.CRMPages.Administration;

import Data.AccountData;
import FrameWork.BrowserAction;
import FrameWork.TestListner;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

@Listeners(TestListner.class)
public class AddTimeslotPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();

    public AddTimeslotPage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Administration validation || Timeslot validation")
    public boolean TimeslotData(ExtentTest extentTest, AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
        IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
        ISLocatorDisplayed(GetLocator("TimeslotLink"), extentTest);
        ISLocatorDisplayed(GetLocator("TimeslotLink"), extentTest);
        click(GetLocator("TimeslotLink"), extentTest);
        Thread.sleep(4000);
        ISLocatorDisplayed(GetLocator("AddTagBtn"), extentTest);
        click(GetLocator("AddTagBtn"), extentTest);
        ISLocatorDisplayed(GetLocator("EnterTimeslotName"), extentTest);
        click(GetLocator("EnterTimeslotName"), extentTest);
        EnterValue(GetLocator("EnterTimeslotName"), accountData.getMessageName(), extentTest);
        Thread.sleep(10000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
        ISLocatorDisplayed(GetLocator("EnterTimeslotStartTime"), extentTest);
        EnterValue(GetLocator("EnterTimeslotStartTime"), accountData.getTimeslotStartTime(), extentTest);
        ISLocatorDisplayed(GetLocator("EnterTimeslotEndTime"), extentTest);
        EnterValue(GetLocator("EnterTimeslotEndTime"), accountData.getTimeslotEndTime(), extentTest);
        Thread.sleep(3000);
        ISLocatorDisplayed(GetLocator("TimeslotSaveBtn"), extentTest);
        click(GetLocator("TimeslotSaveBtn"), extentTest);
        Thread.sleep(5000);
        return true;
    }

}