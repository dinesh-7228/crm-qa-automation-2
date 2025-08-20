package Pages.CRMPages.Administration.MobileApp;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

//import com.relevantcodes.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTest;
import Data.AccountData;
import FrameWork.BrowserAction;
import FrameWork.TestListner;
import io.qameta.allure.Step;

import java.io.IOException;

@Listeners(TestListner.class)
public class AppStoriesPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();

    public AppStoriesPage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Administration validation || App Stories Page validation")
    public boolean AppStoriesData(ExtentTest extentTest, AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
       // IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
       // ISLocatorDisplayed(GetLocator("AppStoriesLink"), extentTest);
        // ISLocatorDisplayed(GetLocator("AppStoriesLink"), extentTest);
       // click(GetLocator("AppStoriesLink"), extentTest);
        Thread.sleep(20000);
        ISLocatorDisplayed(GetLocator("EnterAppStoryName"), extentTest);
        click(GetLocator("EnterAppStoryName"), extentTest);
        Thread.sleep(1000);
        EnterValue(GetLocator("EnterAppStoryName"), accountData.getLastName(), extentTest);
        Thread.sleep(1000);
        ISLocatorDisplayed(GetLocator("FilterBtn_OldPage"), extentTest);
        click(GetLocator("FilterBtn_OldPage"), extentTest);
        Thread.sleep(15000);
        ISLocatorDisplayed(GetLocator("EditProductCategory"), extentTest);
        click(GetLocator("EditProductCategory"), extentTest);
        Thread.sleep(5000);
        ISLocatorDisplayed(GetLocator("TagSaveBtn"), extentTest);
        ISLocatorDisplayed(GetLocator("TagSaveBtn"), extentTest);
        click(GetLocator("TagSaveBtn"), extentTest);
        Thread.sleep(15000);
        ISLocatorDisplayed(GetLocator("AddStoriesBtn"), extentTest);
        click(GetLocator("AddStoriesBtn"), extentTest);
        ISLocatorDisplayed(GetLocator("NewAppStoryName"), extentTest);
        click(GetLocator("NewAppStoryName"), extentTest);
        EnterValue(GetLocator("NewAppStoryName"), accountData.getLastName(), extentTest);
        ISLocatorDisplayed(GetLocator("AppStoryScreen"), extentTest);
        click(GetLocator("AppStoryScreen"), extentTest);
        ISLocatorDisplayed(GetLocator("GenericTagsActiveStatus"),extentTest);
        click(GetLocator("GenericTagsActiveStatus"), extentTest);
        Thread.sleep(2000);
        DropdownSelectfromListextent(GetLocator("Is_Active_Option"), "Yes", extentTest);
        ISLocatorDisplayed(GetLocator("AppStorySequence"), extentTest);
        click(GetLocator("AppStorySequence"), extentTest);
        EnterValue(GetLocator("AppStorySequence"), accountData.getListRoleSequence(), extentTest);
        ISLocatorDisplayed(GetLocator("City_dropdown"), extentTest);
        click(GetLocator("City_dropdown"), extentTest);
        click(GetLocator("Select_All_City"), extentTest);
        tabKey(GetLocator("SelectActiveStatus"));
        ISLocatorDisplayed(GetLocator("AppStoryMediaType"), extentTest);
        click(GetLocator("AppStoryMediaType"), extentTest);
        click(GetLocator("SelectActiveStatus"), extentTest);
        return true;
    }

}



