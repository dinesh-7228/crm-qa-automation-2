package Pages.CRMPages.Funds;

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
public class AddPenaltyPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AddPenaltyPage(WebDriver driver) {

        this.driver = driver;
    }

@Step("Funds validation || Funds-Funds Received validation")
public boolean AddPenaltyData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {

//    Boolean FundsLinkClick = driver.findElement(GetLocator("FundsLink").getBy()).isDisplayed();
//    click(GetLocator("FundsLink"));
//    BooleanAsseration(FundsLinkClick, extentTest, "Funds Link is clickable", "Funds Link Not clickable");
//    System.out.println("Funds Link  Click validation success");
//    Thread.sleep(10000);
    IsNavigationOpen(GetLocator("AdministrationLink"), extentTest);
	ISLocatorDisplayed(GetLocator("AddPenaltyLink"), extentTest);
//	Boolean AddPenaltyLinkPresent = driver.findElement(GetLocator("AddPenaltyLink").getBy()).isDisplayed();
//    BooleanAsseration(AddPenaltyLinkPresent, extentTest, "AddPenaltyLinkPresent Present", "AddPenaltyLinkPresent Not Present");
//    System.out.println("AddPenaltyLinkPresent validation success");
    Thread.sleep(3000);
    ISLocatorDisplayed(GetLocator("AddPenaltyLink"), extentTest);
   // Boolean AddPenaltyLinkClick = driver.findElement(GetLocator("AddPenaltyLink").getBy()).isDisplayed();
    click(GetLocator("AddPenaltyLink"), extentTest);
  //  BooleanAsseration(AddPenaltyLinkClick, extentTest, "AddPenalty Link is clickable", "AddPenalty Link Not clickable");
  //  System.out.println("AddPenalty Link  Click validation success");
    Thread.sleep(10000);
    ISLocatorDisplayed(GetLocator("EnterAddPenaltyFranchise"), extentTest);
  //  Boolean AddPenaltyFranchise = driver.findElement(GetLocator("EnterAddPenaltyFranchise").getBy()).isDisplayed();
    click(GetLocator("EnterAddPenaltyFranchise"), extentTest);
    contextMenu(GetLocator("EnterAddPenaltyFranchise"));
    EnterValue(GetLocator("EnterAddPenaltyFranchise"),accountData.getCityName(), extentTest);
    Thread.sleep(4000);
    click(GetLocator("SelectActiveStatus"), extentTest);
    Thread.sleep(5000);
 //   BooleanAsseration(AddPenaltyFranchise, extentTest, "User able to enter Add Penalty Franchise", "User not able to enter Add Penalty Franchise");
 //   System.out.println("AddPenalty Franchise validation success");
    Thread.sleep(10000);
   
    ISLocatorDisplayed(GetLocator("AddPenaltySearchBtn"), extentTest);
 //   Boolean AddPenaltySearchBtn = driver.findElement(GetLocator("AddPenaltySearchBtn").getBy()).isDisplayed();
    click(GetLocator("AddPenaltySearchBtn"), extentTest);
 //   BooleanAsseration(AddPenaltySearchBtn, extentTest, "User able to click AddPenalty Search Button", "User not able to click AddPenalty Search Button");
 //   System.out.println("AddPenalty Search Button validation success");
    
   
        return true;
    }

}