package Pages.CRMPages.Analytics;

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
public class AnalyticsCollectionSummary extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsCollectionSummary(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-Collection Summary validation")
public boolean AnalyticCollectionSummaryData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
    IsNavigationOpen(GetLocator("AnalyticsLink"), extentTest);
    Thread.sleep(2000);
    IsNavigationOpen(GetLocator("AnalyticCollectionSummaryLink"), extentTest);
    Thread.sleep(10000);
    dateselector_Past_date(GetLocator("NewCustomerFromDate"),extentTest);
    ISLocatorDisplayed(GetLocator("Search_Btn"), extentTest);
    click(GetLocator("Search_Btn"), extentTest);
    Thread.sleep(6000);
    ISLocatorDisplayed(GetLocator("Generate_Export_sheet"), extentTest);
    click(GetLocator("Generate_Export_sheet"), extentTest);
    Thread.sleep(5000);
    ISLocatorDisplayed(GetLocator("Get_Generate_Export_sheet"), extentTest);
    click(GetLocator("Get_Generate_Export_sheet"), extentTest);
    ISLocatorDisplayed(GetLocator("Filter_btn_new"), extentTest);
    click(GetLocator("Filter_btn_new"), extentTest);
    ISLocatorDisplayed(GetLocator("Download_Export_Sheet"), extentTest);
    click(GetLocator("Download_Export_Sheet"), extentTest);
    ISLocatorDisplayed(GetLocator("Cancel_Button"), extentTest);
    click(GetLocator("Cancel_Button"), extentTest);
    ISLocatorDisplayed(GetLocator("Search_Btn"), extentTest);
    click(GetLocator("Search_Btn"), extentTest);
    Thread.sleep(3000);
    ISLocatorDisplayed(GetLocator("HideShowChartBtn"), extentTest);
    click(GetLocator("HideShowChartBtn"), extentTest);
        return true;
    }

}