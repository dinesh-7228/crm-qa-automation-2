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
public class AddFranchisePage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AddFranchisePage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Administration validation || Add Franchise validation")
public boolean AddFranchiseData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
    IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
    IsNavigationOpen(GetLocator("RouteManagementLink"), extentTest);
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("AddFranchiseLink"), extentTest);

    ISLocatorDisplayed(GetLocator("AddFranchiseLink"), extentTest);
    click(GetLocator("AddFranchiseLink"), extentTest);
    Thread.sleep(4000);

    //    <********* Export sheet***********>

    ISLocatorDisplayed(GetLocator("Filter_btn"), extentTest);
    click(GetLocator("Filter_btn"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("EnterRouteFranchise"), extentTest);
    click(GetLocator("EnterRouteFranchise"), extentTest);
    Thread.sleep(3000);

    ISLocatorDisplayed(GetLocator("Select_Franchise"), extentTest);
    click(GetLocator("Select_Franchise"), extentTest);

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

    //    <********* Filter sheet***********>

    ISLocatorDisplayed(GetLocator("Filter_btn"), extentTest);
    click(GetLocator("Filter_btn"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("EnterRouteFranchise"), extentTest);
    clearText(GetLocator("EnterRouteFranchise"));

//    ISLocatorDisplayed(GetLocator("Select_null_option"), extentTest);
//    click(GetLocator("Select_null_option"), extentTest);
//    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Franchise_status"), extentTest);
    click(GetLocator("Franchise_status"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Franchise_Inactive"), extentTest);
    click(GetLocator("Franchise_Inactive"), extentTest);
    Thread.sleep(2000);


    ISLocatorDisplayed(GetLocator("Search_button"), extentTest);
    click(GetLocator("Search_button"), extentTest);
    Thread.sleep(2000);

    //    <********* Edit page ***********>


    ISLocatorDisplayed(GetLocator("Action_Button"), extentTest);
    click(GetLocator("Action_Button"), extentTest);
    Thread.sleep(1000);

    ISLocatorDisplayed(GetLocator("Update_Button"), extentTest);
    click(GetLocator("Update_Button"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Address_line_2"), extentTest);
    click(GetLocator("Address_line_2"), extentTest);
    ClearandEnterValue_New(GetLocator("Address_line_2"), accountData.getListRoleSequence(), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Next_button"), extentTest);
    click(GetLocator("Next_button"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Next_button"), extentTest);
    click(GetLocator("Next_button"), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("Update_record_button"), extentTest);
    click(GetLocator("Update_record_button"), extentTest);
    Thread.sleep(2000);

    System.out.println("Franchise page is verified");
    return true;
    }

}