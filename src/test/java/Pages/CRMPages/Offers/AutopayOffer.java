package Pages.CRMPages.Offers;

import FrameWork.BrowserAction;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class AutopayOffer extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AutopayOffer(WebDriver driver)
    {
        this.driver = driver;
    }

    public void CreateAutopayOffer(ExtentTest extentTest) throws IOException, InstantiationException, IllegalAccessException {
try {
    Thread.sleep(3000);
    ISLocatorDisplayed(GetLocator("ADD_New"), extentTest);
    click(GetLocator("ADD_New"), extentTest);
    ISLocatorDisplayed(GetLocator("OfferName"), extentTest);
    click(GetLocator("Autopay_OfferName"),extentTest);
    EnterValue(GetLocator("Autopay_OfferName"), "Autopay_Automation Offer", extentTest);
    EnterValue(GetLocator("App_Text"), "Automation", extentTest);
//    click(GetLocator("FromDateIcon"), extentTest);
//    click(GetLocator("Month_Year"),extentTest);
//    click(GetLocator("Year"),extentTest);
//    click(GetLocator("Month"),extentTest);
//    click(GetLocator("Date"),extentTest);
    EnterValue(GetLocator("Priority"),"1",extentTest);
  //  EnterValue(GetLocator("Wallet_Amount"),"500",extentTest);
    EnterValue(GetLocator("Min_Wallet_Amount"),"100",extentTest);
    EnterValue(GetLocator("Max_Wallet_Amount"),"3000",extentTest);
    //EnterValue(GetLocator("Recharge_Amount"),"300",extentTest);
    EnterValue(GetLocator("Min_Recharge_Amount"),"500",extentTest);
    EnterValue(GetLocator("Max_Recharge_Amount"),"3000",extentTest);
    ISLocatorDisplayed(GetLocator("IsActive"),extentTest);
    click(GetLocator("IsActive"), extentTest);
    Thread.sleep(2000);
    DropdownSelectfromListextent(GetLocator("Is_Active_Option"), "Yes", extentTest);
    ISLocatorDisplayed(GetLocator("Customer_Type"),extentTest);
    click(GetLocator("Customer_Type"),extentTest);
    Thread.sleep(2000);
    DropdownSelectfromListextent(GetLocator("Customer_Type_Option"),"NEW",extentTest);
    tabKey(GetLocator("Customer_Type_Option"));
    ISLocatorDisplayed(GetLocator("Select_City"),extentTest);
    click(GetLocator("Select_City"),extentTest);
    click(GetLocator("Select_All_City"),extentTest);
    ISLocatorDisplayed(GetLocator("Cashback"),extentTest);
    click(GetLocator("Cashback"),extentTest);
    EnterValue(GetLocator("Cashback"),"80",extentTest);
    ClearandEnterValue_New(GetLocator("Max_Transaction_Cashback"),"100",extentTest);
    ClearandEnterValue_New(GetLocator("Max_Total_Cashback"),"500",extentTest);
    EnterValue(GetLocator("No_Of_CashbackTransaction"),"5",extentTest);
    ISLocatorDisplayed(GetLocator("A/B_Enabled"),extentTest);
    click(GetLocator("A/B_Enabled"),extentTest);
    Thread.sleep(2000);
    DropdownSelectfromListextent(GetLocator("A/B_Enabled_Option"),"No",extentTest);
    ISLocatorDisplayed(GetLocator("Through_Offers"),extentTest);
    click(GetLocator("Through_Offers"),extentTest);
    Thread.sleep(2000);
    DropdownSelectfromListextent(GetLocator("Through_Offers_Option"),"No",extentTest);
    ISLocatorDisplayed(GetLocator("Autopay_Offer_Label"),extentTest);
    EnterValue(GetLocator("Autopay_Offer_Label"),"Automation Autopay",extentTest);
    ISLocatorDisplayed(GetLocator("Add_Customer_Criteria"),extentTest);
    ISLocatorDisplayed(GetLocator("Add_Criteria"),extentTest);
    scrollIntoView(GetLocator("SaveButton"));
    click(GetLocator("SaveButton"),extentTest);
    Thread.sleep(3000);

}catch (Exception e){

    e.printStackTrace();
}



    }

}
