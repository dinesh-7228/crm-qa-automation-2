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
public class BrandPartnerPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public BrandPartnerPage(WebDriver driver) {
        this.driver = driver;
    }
@Step("Campaign validation || Retail Attendance Page validation")
public boolean BrandPartnerData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
    Thread.sleep(8000);
    ISLocatorDisplayed(GetLocator("SelectBrandPartnerDate"), extentTest);
    click(GetLocator("SelectBrandPartnerDate"), extentTest);
    click(GetLocator("PreviousMonth"), extentTest);
    click(GetLocator("DateSelect"), extentTest);
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("SearchButton"), extentTest);
    click(GetLocator("SearchButton"), extentTest);
    Thread.sleep(4000);
    ISLocatorDisplayed(GetLocator("ExportButton"), extentTest);
    click(GetLocator("ExportButton"), extentTest);
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("StartNewChat"), extentTest);
    click(GetLocator("StartNewChat"), extentTest);
    System.out.println("StartNewChat Button validation success");
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("BrandPartnerSelect"), extentTest);
    click(GetLocator("BrandPartnerSelect"), extentTest);
    EnterValue(GetLocator("BrandPartnerSelect"),accountData.getLastName(), extentTest);
    Thread.sleep(2000);
   // click(GetLocator("SelectActiveStatus"), extentTest);
   // Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("NewChatEnterRemarks"), extentTest);
    click(GetLocator("NewChatEnterRemarks"), extentTest);
    EnterValue(GetLocator("NewChatEnterRemarks"),accountData.getMessageName(), extentTest);
    Thread.sleep(2000);
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("SaveButton"), extentTest);
    click(GetLocator("SaveButton"), extentTest);
    Thread.sleep(4000);
        return true;
    }
}












