package Pages.CRMPages.Administration.RouteManagement;

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
public class AddAreaPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();

    public AddAreaPage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Administration validation || Area validation")
    public boolean AreaData(ExtentTest extentTest, AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
        IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
        IsNavigationOpen(GetLocator("RouteManagementLink"), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("AreaLink"), extentTest);
        click(GetLocator("AreaLink"), extentTest);
        Thread.sleep(5000);

        //    <********* Export sheet ***********>

        ISLocatorDisplayed(GetLocator("FilterBtn"), extentTest);
        click(GetLocator("FilterBtn"), extentTest);
        Thread.sleep(5000);

        ISLocatorDisplayed(GetLocator("SelectAreaCity"), extentTest);
        click(GetLocator("SelectAreaCity"), extentTest);
        Thread.sleep(3000);
        DropdownSelectfromList(GetLocator("dropdown_Selection"), "Gurgaon");
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Export_Btn"), extentTest);
        click(GetLocator("Export_Btn"), extentTest);
        Thread.sleep(3000);

        ISLocatorDisplayed(GetLocator("Get_export_sheet"), extentTest);
        click(GetLocator("Get_export_sheet"), extentTest);
        Thread.sleep(3000);

        ISLocatorDisplayed(GetLocator("Filter_btn_new"), extentTest);
        click(GetLocator("Filter_btn_new"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Download_export_sheet"), extentTest);
        click(GetLocator("Download_export_sheet"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Cancel_export_page"), extentTest);
        click(GetLocator("Cancel_export_page"), extentTest);
        Thread.sleep(2000);

        //    <********* Filter sheet ***********>

//        ISLocatorDisplayed(GetLocator("FilterBtn"), extentTest);
//        click(GetLocator("FilterBtn"), extentTest);
//        Thread.sleep(5000);
//
//        ISLocatorDisplayed(GetLocator("SelectAreaCity"), extentTest);
//        click(GetLocator("SelectAreaCity"), extentTest);
//        DropdownSelectfromList(GetLocator("dropdown_Selection"), "Gurgaon");
//        Thread.sleep(2000);
//
//        click(GetLocator("Search_button"), extentTest);
//        Thread.sleep(2000);

        //    <********* Add page ***********>

        ISLocatorDisplayed(GetLocator("AddTagBtn"), extentTest);
        click(GetLocator("AddTagBtn"), extentTest);
        Thread.sleep(1000);

        ISLocatorDisplayed(GetLocator("EnterAreaName"), extentTest);
        click(GetLocator("EnterAreaName"), extentTest);
        Thread.sleep(2000);
        EnterValue(GetLocator("EnterAreaName"), accountData.getAreaName(), extentTest);
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("SelectAreaCity"), extentTest);
        click(GetLocator("SelectAreaCity"), extentTest);
        Thread.sleep(2000);
        DropdownSelectfromList(GetLocator("dropdown_Selection"), "Gurgaon");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("SelectAreaLocality"), extentTest);
        click(GetLocator("SelectAreaLocality"), extentTest);
        DropdownSelectfromList(GetLocator("dropdown_Selection"), "1688 Barracks");

        ISLocatorDisplayed(GetLocator("EnterCityDescription"), extentTest);
        click(GetLocator("EnterCityDescription"), extentTest);
        ClearandEnterValue_New(GetLocator("EnterCityDescription"), "Abc123", extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Status_Toggle"), extentTest);
        click(GetLocator("Status_Toggle"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Cancel_Button_New_UI"), extentTest);
        click(GetLocator("Cancel_Button_New_UI"), extentTest);
        Thread.sleep(2000);

        //    <********* Edit page ***********>

        ISLocatorDisplayed(GetLocator("FilterBtn"), extentTest);
        click(GetLocator("FilterBtn"), extentTest);
        Thread.sleep(5000);

        ISLocatorDisplayed(GetLocator("Name_field"), extentTest);
        click(GetLocator("Name_field"), extentTest);
        Thread.sleep(2000);

        EnterValue(GetLocator("Name_field"), accountData.getAreaName(), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("SelectAreaCity"), extentTest);
        click(GetLocator("SelectAreaCity"), extentTest);
        Thread.sleep(2000);

        DropdownSelectfromList(GetLocator("dropdown_Selection"), "Gurgaon");
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Search_button"), extentTest);
        click(GetLocator("Search_button"), extentTest);
        Thread.sleep(4000);

        ISLocatorDisplayed(GetLocator("Action_Button"), extentTest);
        click(GetLocator("Action_Button"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Update_Button"), extentTest);
        click(GetLocator("Update_Button"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("EnterAreaDescription"), extentTest);
        click(GetLocator("EnterAreaDescription"), extentTest);

        ClearandEnterValue_New(GetLocator("EnterAreaDescription"), "Abc123", extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("SelectAreaLocality"), extentTest);
        click(GetLocator("SelectAreaLocality"), extentTest);
        Thread.sleep(3000);

        ISLocatorDisplayed(GetLocator("Select_locality"), extentTest);
        click(GetLocator("Select_locality"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Update_record_button"), extentTest);
        click(GetLocator("Update_record_button"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Yes_Button"), extentTest);
        click(GetLocator("Yes_Button"), extentTest);
        Thread.sleep(2000);

        return true;
    }

}