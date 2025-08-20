package Pages.CRMPages.Customers;

import Data.AccountData;




import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

//import com.relevantcodes.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTest;
import FrameWork.BrowserAction;
import FrameWork.TestListner;
import io.qameta.allure.Step;

import java.io.IOException;

@Listeners(TestListner.class)
public class WhatsAppCommunicationPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public WhatsAppCommunicationPage (WebDriver driver) {

        this.driver = driver;
        
    }

    
    @Step("WhatsApp Communication Validation || WhatsApp Communication Page validation")
public boolean WhatsAppCommunicationData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {

    /*	Boolean CustomerLinkPresent = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
        BooleanAsseration(CustomerLinkPresent, extentTest, "Customer Link Present", "Customer Link Not Present");
        System.out.println("Customer Link Present validation success");
        Thread.sleep(3000);

        Boolean CustomerLinkClick = driver.findElement(GetLocator("CustomerLink").getBy()).isDisplayed();
        click(GetLocator("CustomerLink"));
        BooleanAsseration(CustomerLinkClick, extentTest, "Customer Link is clickable", "Customer Link Not clickable");
        System.out.println("Customer Link Click validation success");
        Thread.sleep(5000);
       */
            ISLocatorDisplayed(GetLocator("WhatsAppCommunicationLink"), extentTest);
       // Boolean WhatsAppCommunicationLinkPresent = driver.findElement(GetLocator("WhatsAppCommunicationLink").getBy()).isDisplayed();
       // BooleanAsseration(WhatsAppCommunicationLinkPresent, extentTest, "WhatsApp Communication Link Present", "Whatsapp Communication Link Not Present");
       // System.out.println("WhatsApp Communication Link Present validation success");
        //Thread.sleep(5000);
        //ISLocatorDisplayed(GetLocator("WhatsAppCommunicationLink"), extentTest);
      //  Boolean WhatsAppCommunicationLinkClick = driver.findElement(GetLocator("WhatsAppCommunicationLink").getBy()).isDisplayed();
        click(GetLocator("WhatsAppCommunicationLink"), extentTest);
     //   BooleanAsseration(WhatsAppCommunicationLinkClick, extentTest, "WhatsApp Communication Link is clickable", "WhatsApp Communication Link Not clickable");
      //  System.out.println("WhatsApp Communication Link Click validation success");
        Thread.sleep(20000);
        ISLocatorDisplayed(GetLocator("AskExactLocationPhoneInput"), extentTest);
      //  Boolean AskExactLocationPhoneInput = driver.findElement(GetLocator("AskExactLocationPhoneInput").getBy()).isDisplayed();
        click(GetLocator("AskExactLocationPhoneInput"), extentTest);
        EnterValue(GetLocator("AskExactLocationPhoneInput"),accountData.getMobile(), extentTest);
      //  BooleanAsseration(AskExactLocationPhoneInput, extentTest, "User able to enter phone number", "User not able to enter phone number");
      //  System.out.println("Phone number Validation Success");
        Thread.sleep(2000);
        
        ISLocatorDisplayed(GetLocator("AskExactLocationSearchBtn"), extentTest);
       // Boolean AskExactLocationSearchBtnPresent = driver.findElement(GetLocator("AskExactLocationSearchBtn").getBy()).isDisplayed();
       // BooleanAsseration(AskExactLocationSearchBtnPresent, extentTest, "Search Button Present", "Search Button Not Present");
       // System.out.println("Search Button validation success");
      //  Thread.sleep(2000);
      //  ISLocatorDisplayed(GetLocator("AskExactLocationSearchBtn"), extentTest);
      //  Boolean AskExactLocationSearchBtnClick = driver.findElement(GetLocator("AskExactLocationSearchBtn").getBy()).isDisplayed();
        click(GetLocator("AskExactLocationSearchBtn"), extentTest);
      //  BooleanAsseration(AskExactLocationSearchBtnClick, extentTest, "Search Button Clickable", "Search Button Not Clickable");
      //  System.out.println("Search Button validation success");
        Thread.sleep(2000);
        
        
        
        return true;
        
        
        
    }}

        
        