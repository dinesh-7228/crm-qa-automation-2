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
public class AnalyticsComplaintStatisticsPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AnalyticsComplaintStatisticsPage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Analytics validation || Analytics-Complaint Statistics validation")
public boolean AnalyticComplaintStatisticsData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
    IsNavigationOpen(GetLocator("AnalyticsLink"), extentTest);
    Thread.sleep(2000);
    IsNavigationOpen(GetLocator("AnalyticComplaintStatisticsLink"), extentTest);
    Thread.sleep(10000);
    dateselector_Past_date(GetLocator("AnalyticComplaintStatisticsFromDate"), extentTest);
    click(GetLocator("Complain_category"), extentTest);
    DropdownSelectfromListextent(GetLocator("Dropdown_value"),"Quality" ,extentTest);
    click(GetLocator("EnterCityRegion"), extentTest);
    DropdownSelectfromListextent(GetLocator("Dropdown_value"),"Delhi - NCR" ,extentTest);
    click(GetLocator("EnterAreaCity"), extentTest);
    DropdownSelectfromListextent(GetLocator("Dropdown_value"),"Gurgaon" ,extentTest);
    click(GetLocator("SelectFranchise"), extentTest);
    DropdownSelectfromListextent(GetLocator("Dropdown_value"),"Gurgaon Ardee City" ,extentTest);
    ISLocatorDisplayed(GetLocator("Search_Btn"), extentTest);
    click(GetLocator("Search_Btn"), extentTest);
    Thread.sleep(10000);
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
        return true;
    }

}