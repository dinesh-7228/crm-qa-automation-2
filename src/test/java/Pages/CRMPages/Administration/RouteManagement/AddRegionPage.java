package Pages.CRMPages.Administration.RouteManagement;
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
public class AddRegionPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AddRegionPage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Administration validation || AddRegion validation")
	public boolean RegionData (ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
    IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
    Thread.sleep(2000);
    IsNavigationOpen(GetLocator("RouteManagementLink"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("AddRegionLink"), extentTest);
    click(GetLocator("AddRegionLink"), extentTest);
    Thread.sleep(3000);

//    <**************Export sheet***************>

    ISLocatorDisplayed(GetLocator("Filter_btn"), extentTest);
    click(GetLocator("Filter_btn"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Name_field"), extentTest);
    click(GetLocator("Name_field"), extentTest);
    Thread.sleep(1000);

    EnterValue(GetLocator("Name_field"), accountData.getCityRegion(), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Export_Btn"), extentTest);
    click(GetLocator("Export_Btn"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Get_export_sheet"), extentTest);
    click(GetLocator("Get_export_sheet"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Filter_btn_new"), extentTest);
    click(GetLocator("Filter_btn_new"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Download_export_sheet"), extentTest);
    click(GetLocator("Download_export_sheet"), extentTest);
    Thread.sleep(1000);

    ISLocatorDisplayed(GetLocator("Cancel_export_page"), extentTest);
    click(GetLocator("Cancel_export_page"), extentTest);
    Thread.sleep(2000);

    //    <********* Add sheet***********>

    ISLocatorDisplayed(GetLocator("AddTagBtn"), extentTest);
    click(GetLocator("AddTagBtn"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Cancel_Button_New_UI"), extentTest);
    click(GetLocator("Cancel_Button_New_UI"), extentTest);
    Thread.sleep(2000);

    // <*********** Search and Edit page**************>

    ISLocatorDisplayed(GetLocator("Filter_btn"), extentTest);
    click(GetLocator("Filter_btn"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Name_field"), extentTest);
    click(GetLocator("Name_field"), extentTest);
    Thread.sleep(1000);

    EnterValue(GetLocator("Name_field"), accountData.getAddRegionEnterName(), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Search_button"), extentTest);
    click(GetLocator("Search_button"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Action_Button"), extentTest);
    click(GetLocator("Action_Button"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Update_Button"), extentTest);
    click(GetLocator("Update_Button"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("EnterCityDescription"), extentTest);
    click(GetLocator("EnterCityDescription"), extentTest);
    Thread.sleep(2000);

    ClearandEnterValue_New(GetLocator("EnterCityDescription"), accountData.getAddRegionEnterName(), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Update_record_button"), extentTest);
    click(GetLocator("Update_record_button"), extentTest);
    Thread.sleep(2000);


    return true;
    }

}
