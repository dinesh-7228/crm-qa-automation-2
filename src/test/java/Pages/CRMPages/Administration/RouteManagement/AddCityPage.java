package Pages.CRMPages.Administration.RouteManagement;

import Data.AccountData;
import FrameWork.BrowserAction;
import FrameWork.TestListner;

//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;
import io.qameta.allure.Step;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

@Listeners(TestListner.class)
public class AddCityPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();

    public AddCityPage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Administration validation || AddCity validation")
    public boolean AddCityData(ExtentTest extentTest, AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
        IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
        IsNavigationOpen(GetLocator("RouteManagementLink"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("AddCityLink"), extentTest);
        click(GetLocator("AddCityLink"), extentTest);
        Thread.sleep(3000);

        //    <********* Export sheet ***********>

        ISLocatorDisplayed(GetLocator("FilterBtn"), extentTest);
        click(GetLocator("FilterBtn"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("EnterNameOfCity"), extentTest);
        click(GetLocator("EnterNameOfCity"), extentTest);
        Thread.sleep(2000);
        EnterValue(GetLocator("EnterNameOfCity"), accountData.getCityName(), extentTest);

        ISLocatorDisplayed(GetLocator("Export_Btn"), extentTest);
        click(GetLocator("Export_Btn"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Get_export_sheet"), extentTest);
        click(GetLocator("Get_export_sheet"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Filter_btn_new"), extentTest);
        click(GetLocator("Filter_btn_new"), extentTest);
        Thread.sleep(5000);

        ISLocatorDisplayed(GetLocator("Download_export_sheet"), extentTest);
        click(GetLocator("Download_export_sheet"), extentTest);
        Thread.sleep(1000);

        ISLocatorDisplayed(GetLocator("Cancel_export_page"), extentTest);
        click(GetLocator("Cancel_export_page"), extentTest);
        Thread.sleep(2000);

        //    <********* Edit and Filter page ***********>

        ISLocatorDisplayed(GetLocator("FilterBtn"), extentTest);
        click(GetLocator("FilterBtn"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Name_field"), extentTest);
        click(GetLocator("Name_field"), extentTest);
        EnterValue(GetLocator("Name_field"), accountData.getAddplanname(), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Search_button"), extentTest);
        click(GetLocator("Search_button"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Action_Button"), extentTest);
        click(GetLocator("Action_Button"), extentTest);
        Thread.sleep(1000);

        ISLocatorDisplayed(GetLocator("Update_Button"), extentTest);
        click(GetLocator("Update_Button"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("EnterCityDescription"), extentTest);
        click(GetLocator("EnterCityDescription"), extentTest);
        Thread.sleep(2000);
        ClearandEnterValue_New(GetLocator("EnterCityDescription"), accountData.getListRoleSequence(), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Update_record_button"), extentTest);
        click(GetLocator("Update_record_button"), extentTest);

        //    <********* Add page ***********>

        ISLocatorDisplayed(GetLocator("AddTagBtn"), extentTest);
        click(GetLocator("AddTagBtn"), extentTest);
        Thread.sleep(1000);

        ISLocatorDisplayed(GetLocator("Cancel_Button_New_UI"), extentTest);
        click(GetLocator("Cancel_Button_New_UI"), extentTest);

        return true;
    }

}
