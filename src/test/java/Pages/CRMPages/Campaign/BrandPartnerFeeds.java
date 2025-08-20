package Pages.CRMPages.Campaign;
import Data.AccountData;
import FrameWork.BrowserAction;
import FrameWork.Locator;
import FrameWork.TestListner;
import FrameWork.TestRunner;
import android.provider.Browser;

//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Step;

import org.junit.runners.model.FrameworkMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Listeners(TestListner.class)
public class BrandPartnerFeeds extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public BrandPartnerFeeds(WebDriver driver) {

        this.driver = driver;
    }

@Step("Campaign validation || AddBPFeeds validation")
    public boolean BPFeedsData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {
    Thread.sleep(5000);
    ISLocatorDisplayed(GetLocator("EnterNameOfBPFeeds"), extentTest);
    click(GetLocator("EnterNameOfBPFeeds"), extentTest);
    EnterValue(GetLocator("EnterNameOfBPFeeds"),accountData.getLastName(), extentTest);
    ISLocatorDisplayed(GetLocator("FilterButton"),extentTest);
    click(GetLocator("FilterButton"), extentTest);
    Thread.sleep(4000);
    if(IsDisplayed(GetLocator("EditSearchResult"))) {
     click(GetLocator("EditSearchResult"), extentTest);
     Thread.sleep(2000);
     ISLocatorDisplayed(GetLocator("UpdateButton"), extentTest);
     Thread.sleep(2000);
     ISLocatorDisplayed(GetLocator("UpdateButton"), extentTest);
     click(GetLocator("UpdateButton"), extentTest);
     Thread.sleep(5000);
    }
    ISLocatorDisplayed(GetLocator("AddBPFeedsBtn"), extentTest);
    ISLocatorDisplayed(GetLocator("AddBPFeedsBtn"), extentTest);
    click(GetLocator("AddBPFeedsBtn"), extentTest);
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("EnterBPFeedsName"), extentTest);
    click(GetLocator("EnterBPFeedsName"), extentTest);
    EnterValue(GetLocator("EnterBPFeedsName"),accountData.getMessageName(), extentTest);
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("EnterBPFeedsDescription"), extentTest);
    click(GetLocator("EnterBPFeedsDescription"), extentTest);
    EnterValue(GetLocator("EnterBPFeedsDescription"),accountData.getMessageName(), extentTest);
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("EnterBPFeedsSequence"), extentTest);
    click(GetLocator("EnterBPFeedsSequence"), extentTest);
    EnterValue(GetLocator("EnterBPFeedsSequence"),accountData.getListRoleSequence(), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("EnterBPFeedsSlideName"), extentTest);
    click(GetLocator("EnterBPFeedsSlideName"), extentTest);
    EnterValue(GetLocator("EnterBPFeedsSlideName"),accountData.getLastName(), extentTest);
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("EnterBPFeedsSlidesDescription"), extentTest);
    click(GetLocator("EnterBPFeedsSlidesDescription"), extentTest);
    EnterValue(GetLocator("EnterBPFeedsSlidesDescription"),accountData.getMessageName(), extentTest);
    Thread.sleep(2000);
    ISLocatorDisplayed(GetLocator("EnterBPFeedsSlideSequence"), extentTest);
    click(GetLocator("EnterBPFeedsSlideSequence"), extentTest);
    EnterValue(GetLocator("EnterBPFeedsSlideSequence"),accountData.getListRoleSequence(), extentTest);
    Thread.sleep(2000);

    ISLocatorDisplayed(GetLocator("SelectBPFeedsCardType"), extentTest);
    click(GetLocator("SelectBPFeedsCardType"), extentTest);
    Thread.sleep(1000);
    click(GetLocator("SelectFranchiseDropdown"), extentTest);
    Thread.sleep(2000);

   ISLocatorDisplayed(GetLocator("ChooseFileBtnBPFeeds"), extentTest);
    //click(GetLocator("File_Upload_Btn"), extentTest);
    Thread.sleep(10000);

//uploadFile("/home/bellamkondu/TestCity1.png");
    File file = new File("src/test/Images/1.jpeg");
   // uploadFile(file.getCanonicalPath());
    SendKeys(GetLocator("File_upload_newew"), extentTest, file.getCanonicalPath());
    Thread.sleep(5000);
    click(GetLocator("Label_Upload"), extentTest);
System.out.println("Image clicked");
Thread.sleep(20000);
ISLocatorDisplayed(GetLocator("SaveButton"), extentTest);
click(GetLocator("SaveButton"), extentTest);
Thread.sleep(10000);

        return true;
   

}
}