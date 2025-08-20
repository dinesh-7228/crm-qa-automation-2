package Pages.CRMPages.Analytics;

import Data.AccountData;
import FrameWork.BrowserAction;
import FrameWork.TestListner;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

@Listeners(TestListner.class)
public class AnalyticsNewCustomer extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsNewCustomer(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-New Customer validation")
public boolean AnalyticsNewCustomerData(ExtentTest extentTest) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
    IsNavigationOpen(GetLocator("AnalyticsLink"), extentTest);
    Thread.sleep(2000);
    IsNavigationOpen(GetLocator("AnalyticsNewCustomerLink"), extentTest);
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