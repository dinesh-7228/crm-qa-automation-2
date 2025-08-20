package Pages.CRMPages.Administration.RouteManagement;
import Data.AccountData;
import FrameWork.BrowserAction;
import FrameWork.Locator;
import FrameWork.TestListner;
import FrameWork.TestRunner;
import android.os.DropBoxManager;
import android.provider.Browser;

//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Step;

import org.junit.runners.model.FrameworkMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.util.List;
@Listeners(TestListner.class)
public class AddRoutePage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AddRoutePage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Administration validation || AddRoute validation")
	public boolean RouteData (ExtentTest extentTest,AccountData accountData) throws  Exception {
    IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
    IsNavigationOpen(GetLocator("RouteManagementLink"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("AddRouteLink"), extentTest);
    click(GetLocator("AddRouteLink"), extentTest);
    Thread.sleep(2000);

//    <********* Export sheet***********>

    ISLocatorDisplayed(GetLocator("FilterBtn"), extentTest);
    click(GetLocator("FilterBtn"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Name_field"), extentTest);
    click(GetLocator("Name_field"), extentTest);
    EnterValue(GetLocator("Name_field"), "Abc123", extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("EnterRouteActive"), extentTest);
    click(GetLocator("EnterRouteActive"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Active_status_no"), extentTest);
    click(GetLocator("Active_status_no"), extentTest);
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

    //    <********* Edit the page ***********>

    ISLocatorDisplayed(GetLocator("FilterBtn"), extentTest);
    click(GetLocator("FilterBtn"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Name_field"), extentTest);
    click(GetLocator("Name_field"), extentTest);
    EnterValue(GetLocator("Name_field"), "APP TEST GGN", extentTest);
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
    ClearandEnterValue_New(GetLocator("EnterCityDescription"), "Abc123", extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Edit_route_update"), extentTest);
    click(GetLocator("Edit_route_update"), extentTest);
    Thread.sleep(2000);

    //    <********* Add sheet***********>

    ISLocatorDisplayed(GetLocator("AddTagBtn"), extentTest);
    click(GetLocator("AddTagBtn"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Cancel_Button_New_UI"), extentTest);
    click(GetLocator("Cancel_Button_New_UI"), extentTest);
    Thread.sleep(2000);

    System.out.println("Route page is verified");

    return true;
    }

}
