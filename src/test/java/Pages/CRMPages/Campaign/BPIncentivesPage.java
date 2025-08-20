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
public class BPIncentivesPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public BPIncentivesPage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Campaign validation || Retail Attendance Page validation")
public boolean BPIncentivesData(ExtentTest extentTest, AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
  ISLocatorDisplayed(GetLocator("BPIncentivesLink"), extentTest);
    Thread.sleep(3000);
    ISLocatorDisplayed(GetLocator("BPIncentivesLink"), extentTest);
    click(GetLocator("BPIncentivesLink"), extentTest);
    Thread.sleep(30000);
    ISLocatorDisplayed(GetLocator("SelectBPIncentivesDate"), extentTest);
    click(GetLocator("SelectBPIncentivesDate"), extentTest);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("PreviousMonth"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("DateSelect"), extentTest);
    Thread.sleep(1000);
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("SearchButton"), extentTest);
    click(GetLocator("SearchButton"), extentTest);
    Thread.sleep(10000);
    if(IsDisplayed(GetLocator("SelectBPIncentivesResult"))) {
      ISLocatorDisplayed(GetLocator("SelectBPIncentivesResult"), extentTest);
      click(GetLocator("SelectBPIncentivesResult"), extentTest);
      Thread.sleep(2000);
      click(GetLocator("SelectBPIncentivesResult"), extentTest);
      Thread.sleep(2000);
      ISLocatorDisplayed(GetLocator("ExportButton"), extentTest);
      click(GetLocator("ExportButton"), extentTest);
      Thread.sleep(6000);
    }
    ISLocatorDisplayed(GetLocator("MapCustomerToBPLink"), extentTest);
    ISLocatorDisplayed(GetLocator("MapCustomerToBPLink"), extentTest);
    click(GetLocator("MapCustomerToBPLink"), extentTest);
    Thread.sleep(3000);
    ISLocatorDisplayed(GetLocator("MapCustomerSelectBP"), extentTest);
    click(GetLocator("MapCustomerSelectBP"), extentTest);
    EnterValue(GetLocator("MapCustomerSelectBP"),accountData.getLastName(), extentTest);
    Thread.sleep(1000);
    click(GetLocator("SelectFranchiseDropdown"), extentTest);
    Thread.sleep(1000);
    Thread.sleep(3000);
    ISLocatorDisplayed(GetLocator("MapCustomerEnterMobile"),extentTest);
    click(GetLocator("MapCustomerEnterMobile"), extentTest);
    EnterValue(GetLocator("MapCustomerEnterMobile"),accountData.getEnterPhoneNumber(), extentTest);
    Thread.sleep(1000);
    Thread.sleep(3000);
    ISLocatorDisplayed(GetLocator("SaveButton"), extentTest);
    click(GetLocator("SaveButton"), extentTest);
    Thread.sleep(5000);
    
        return true;
    }

}


