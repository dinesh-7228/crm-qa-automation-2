package Pages.WebApplication;

import Data.AccountData;
import FrameWork.BrowserAction;
//import com.relevantcodes.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class WebHomePage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public WebHomePage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Administration validation || HomePage validation")
    public boolean VerifyHomePage(ExtentTest extentTest, AccountData accountData) throws Exception {
       //Thread.sleep(5000);

        waitUntilDisplayed(GetLocator("LocationSelection"),5);
        //Boolean selectLocation = driver.findElement(GetLocator("LocationSelection").getBy()).isDisplayed();
        click(GetLocator("LocationSelection"), extentTest);
        Thread.sleep(2000);
        //waitUntilDisplayed(GetLocator("Websitelogo"), 15);
        ISLocatorDisplayed(GetLocator("Websitelogo"), extentTest);
       // BooleanAsseration(verifywebLogo, extentTest, "Web Logo is Present", "Web Logo Not Present");
       // System.out.println("web logo validation success");
        Thread.sleep(2000);
        waitUntilDisplayed(GetLocator("ProductsLabel"), 15);
        mouseHover(GetLocator("ProductsLabel"));
        ISLocatorDisplayed(GetLocator("OurStoryLabel"), extentTest);
      //  Boolean verifyourstory = driver.findElement(GetLocator("OurStoryLabel").getBy()).isDisplayed();
       // BooleanAsseration(verifyourstory, extentTest, "Our Story Label is Present", "Our Story Label Not Present");
       // System.out.println("Our Story Label validation success");
       // Thread.sleep(2000);

       // Boolean verifyourstoryclickable = driver.findElement(GetLocator("OurStoryLabel").getBy()).isDisplayed();
       ISLocatorDisplayed(GetLocator("OurStoryLabel"), extentTest);
       click(GetLocator("OurStoryLabel"), extentTest);
        //BooleanAsseration(verifyourstoryclickable, extentTest, "Our Story label is Clickable", "Our STory label is Not Clickable");
        //System.out.println("Our story Click validation success");
       // Thread.sleep(2000);

       ISLocatorDisplayed(GetLocator("ProductsLabel"), extentTest);
        //Boolean verifyproductslabel = driver.findElement(GetLocator("ProductsLabel").getBy()).isDisplayed();
        //BooleanAsseration(verifyproductslabel, extentTest, "Products Label is Present", "Products Label Not Present");
        //System.out.println("Products Label validation success");
        //Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("ProductsLabel"), extentTest);
        //Boolean verifyproductsclickable = driver.findElement(GetLocator("ProductsLabel").getBy()).isDisplayed();
        click(GetLocator("ProductsLabel"), extentTest);
        //BooleanAsseration(verifyourstoryclickable, extentTest, "Products label is Clickable", "Products label is Not Clickable");
        //System.out.println("Products Click validation success");
        //Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("Websitelogo"), extentTest);
       // Boolean verifylogoclickable = driver.findElement(GetLocator("Websitelogo").getBy()).isDisplayed();
        click(GetLocator("Websitelogo"), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("DownloadButton"), extentTest);
       // Boolean verifdownloadbutton = driver.findElement(GetLocator("DownloadButton").getBy()).isDisplayed();
        //BooleanAsseration(verifdownloadbutton, extentTest, "Download button is Present", "Download button Not Present");
        //System.out.println("Download button validation success");
        //Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("DownloadButton"), extentTest);
       // Boolean verifdownloadbuttonhover = driver.findElement(GetLocator("DownloadButton").getBy()).isDisplayed();
        mouseHover(GetLocator("DownloadButton"));
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("CashbackText"), extentTest);
       // Boolean verifycashbacktext = driver.findElement(GetLocator("CashbackText").getBy()).isDisplayed();
       // BooleanAsseration(verifycashbacktext, extentTest, "Cashback Text is Present", "Cashback Text Not Present");
       // System.out.println("Cashback Text validation success");
       // Thread.sleep(2000);

       ISLocatorDisplayed(GetLocator( "FirstOrderText"), extentTest);
       // Boolean verifytext1 = driver.findElement(GetLocator( "FirstOrderText").getBy()).isDisplayed();
       // BooleanAsseration(verifytext1, extentTest, "First Order Text is Present", "First Order Text Not Present");
       // System.out.println("First Order Text validation success");
       // Thread.sleep(2000);

       ISLocatorDisplayed(GetLocator( "ViaText"), extentTest);
       // Boolean verifytext2 = driver.findElement(GetLocator( "ViaText").getBy()).isDisplayed();
       // BooleanAsseration(verifytext2, extentTest, "Via Text is Present", "Via Text Not Present");
       // System.out.println("Via Text validation success");
       // Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator( "DownloadViaScanner"), extentTest);
        //Boolean verifyscanner = driver.findElement(GetLocator( "DownloadViaScanner").getBy()).isDisplayed();
        //BooleanAsseration(verifyscanner, extentTest, "Scanner is Present", "Scanner Not Present");
        //System.out.println("Scanner validation success");
        //Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("TextBox"), extentTest);
      //  Boolean verifytextbox = driver.findElement(GetLocator("TextBox").getBy()).isDisplayed();
        click(GetLocator("TextBox"), extentTest);
        EnterValue(GetLocator("TextBox"),accountData.getMobile(), extentTest);
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("SendButton"), extentTest);
       // Boolean sendbutton = driver.findElement(GetLocator("SendButton").getBy()).isDisplayed();
       // BooleanAsseration(sendbutton, extentTest, "Send button is Present", "Send button Not Present");
       // System.out.println("Send Button validation success");
        Thread.sleep(2000);

        click(GetLocator("Websitelogo"), extentTest);
        Thread.sleep(2000);


        scrollIntoView(GetLocator("WhyCountryDelight"));
        Thread.sleep(2000);

        waitUntilDisplayed(GetLocator("VideoWCD"), 15);
        mouseHover(GetLocator("VideoWCD"));
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("VideoWCD"), extentTest);
       // Boolean verifyvideplay = driver.findElement(GetLocator("VideoWCD").getBy()).isDisplayed();
       // BooleanAsseration(verifyvideplay, extentTest, "Video is playable", "Video is not playable");
       // System.out.println("Video playable success");
       // Thread.sleep(2000);

        scrollIntoView(GetLocator("WeDeliverIn"));
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("CashbackText2"), extentTest);
      //  Boolean verifycashback2 = driver.findElement(GetLocator("CashbackText2").getBy()).isDisplayed();
       // BooleanAsseration(verifycashback2, extentTest, "Cashback Text is Present", "Cashback Text is not Present");
       // System.out.println("Cashback Text Validation Success");
       // Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("FirstOrderText2"), extentTest);
        //Boolean verifyFirstOrderText2 = driver.findElement(GetLocator("FirstOrderText2").getBy()).isDisplayed();
        //BooleanAsseration(verifyFirstOrderText2, extentTest, "First Order Text2 is Present", "First Order Text2 is not Present");
        //System.out.println("First Order Text2 Validation Success");
        //Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("ViaText2"), extentTest);
       // Boolean verifyViaText2 = driver.findElement(GetLocator("ViaText2").getBy()).isDisplayed();
       // BooleanAsseration(verifyViaText2, extentTest, "Via Text2 is Present", "Via Text2 is not Present");
       // System.out.println("Via Text2 Validation Success");
       // Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("DownloadViaScanner2"), extentTest);
       // Boolean verifyScanner2 = driver.findElement(GetLocator("DownloadViaScanner2").getBy()).isDisplayed();
       // BooleanAsseration(verifyScanner2, extentTest, "Via Text2 is Present", "Via Text2 is not Present");
       // System.out.println("Scanner2 Validation Success");
       // Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("OR"), extentTest);
       // Boolean verifyOR = driver.findElement(GetLocator("OR").getBy()).isDisplayed();
       // BooleanAsseration(verifyOR, extentTest, "OR is Present", "OR is not Present");
       // System.out.println("OR Validation Success");
        Thread.sleep(5000);
         ISLocatorDisplayed(GetLocator("TextBox2"), extentTest);
        // Boolean verifyText2 = driver.findElement(GetLocator("TextBox2").getBy()).isDisplayed();
         click(GetLocator("TextBox2"), extentTest);
         EnterValue(GetLocator("TextBox2"), accountData.getMobile(), extentTest);
         Thread.sleep(5000);

        scrollIntoView(GetLocator("OurSuccessStories"));
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("NoOfHappyCustomers"), extentTest);
       // Boolean verifyhappycustomer= driver.findElement(GetLocator("NoOfHappyCustomers").getBy()).isDisplayed();
       // BooleanAsseration(verifyhappycustomer, extentTest, "No. of Happy Cx is Present", "No. of Happy Cx is not Present");
       // System.out.println("Happy Customers Validation Success");
        Thread.sleep(2000);

        ISLocatorDisplayed(GetLocator("HappyCxText"), extentTest);
      //  Boolean verifyhappycustomertext= driver.findElement(GetLocator("HappyCxText").getBy()).isDisplayed();
      //  BooleanAsseration(verifyhappycustomertext, extentTest, "Happy Cx Text is Present", "Happy Cx Text is not Present");
      //  System.out.println("Happy Customers Text Validation Success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("NoOfFarmersSupported"), extentTest);
        //Boolean verifyfarmersupported= driver.findElement(GetLocator("NoOfFarmersSupported").getBy()).isDisplayed();
        //BooleanAsseration(verifyfarmersupported, extentTest, "Farmer Supported Number is Present", "Farmer Supported Number is not Present");
        //System.out.println("Farmer Supported No. Validation Success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("FarmerSupportedText"), extentTest);
       // Boolean verifyfarmersupportedtext= driver.findElement(GetLocator("FarmerSupportedText").getBy()).isDisplayed();
       // BooleanAsseration(verifyfarmersupportedtext, extentTest, "FarmerSupported Text is Present", "FarmerSupported Text is not Present");
       // System.out.println("Farmer Supported Text Validation Success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("OrderMilestoneAchieved"), extentTest);
        //Boolean verifyOrderMilestoneAchieved= driver.findElement(GetLocator("OrderMilestoneAchieved").getBy()).isDisplayed();
        //BooleanAsseration(verifyOrderMilestoneAchieved, extentTest, "Order Mile Stone Number is Present", "Order Mile Stone Number is not Present");
       // System.out.println("Order Mile Stone No. Validation Success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("OrderMilestoneAchievedText"), extentTest);
       // Boolean verifyOrderMilestoneAchievedText= driver.findElement(GetLocator("OrderMilestoneAchievedText").getBy()).isDisplayed();
       // BooleanAsseration(verifyOrderMilestoneAchievedText, extentTest, "Order Mile Stone Text is Present", "Order Mile Stone Text is not Present");
       // System.out.println("Order Mile Stone Text Validation Success");
        Thread.sleep(2000);

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(2000);

        click(GetLocator("ViewAllProducts"), extentTest);
        Thread.sleep(5000);


        backPage();

        Thread.sleep(2000);

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(4000);

        click(GetLocator("CountrySpecials"), extentTest);
        Thread.sleep(5000);

        backPage();
        Thread.sleep(2000);

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(2000);

        click(GetLocator("Milk"), extentTest);
        Thread.sleep(5000);

        backPage();
        Thread.sleep(2000);

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(2000);

        click(GetLocator("Milk Products"), extentTest);
        Thread.sleep(5000);

        backPage();
        Thread.sleep(2000);

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(2000);

        click(GetLocator("Bread Eggs"), extentTest);
        Thread.sleep(5000);

        backPage();
        Thread.sleep(2000);

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("DownloadAppTextFooter"), extentTest);
       // Boolean verifyDownloadTextfooter = driver.findElement(GetLocator("DownloadAppTextFooter").getBy()).isDisplayed();
       // BooleanAsseration(verifyDownloadTextfooter, extentTest, "Text is visible", "Text is not visible");
       // System.out.println("Text validation Success");
        ISLocatorDisplayed(GetLocator("GooglePlayFooter"), extentTest);
       // Boolean verifyGooglePlayfooter = driver.findElement(GetLocator("GooglePlayFooter").getBy()).isDisplayed();
       // BooleanAsseration(verifyGooglePlayfooter, extentTest, "GooglePlay icon is visible", "GooglePlay icon is not visible");
       // System.out.println("GooglePlay validation Success");
        ISLocatorDisplayed(GetLocator("AppStoreFooter"), extentTest);
       // Boolean verifyAppStorefooter = driver.findElement(GetLocator("AppStoreFooter").getBy()).isDisplayed();
       // BooleanAsseration(verifyAppStorefooter, extentTest, "AppStore icon is visible", "AppStore icon is not visible");
       // System.out.println("AppStore Icon validation Success");
        Thread.sleep(2000);

        click(GetLocator("AboutUs"), extentTest);
        Thread.sleep(3000);

        scrollIntoView(GetLocator("Career"));
        Thread.sleep(2000);

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(2000);

        backPage();

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(2000);

        click(GetLocator("Privacy"), extentTest);
        Thread.sleep(3000);

        scrollIntoView(GetLocator("ReturnAndRefundsText"));
        Thread.sleep(3000);

        backPage();

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(2000);

        click(GetLocator("TnCFooter"), extentTest);
        Thread.sleep(2000);

        backPage();

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(2000);

        click(GetLocator("Help"), extentTest);
        Thread.sleep(2000);

        backPage();

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(2000);

        click(GetLocator("Redressals"), extentTest);
        Thread.sleep(2000);

        backPage();

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(2000);

        click(GetLocator("FAQs"), extentTest);
        Thread.sleep(2000);

        backPage();

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(2000);

        click(GetLocator("Tree"), extentTest);
        Thread.sleep(2000);

        backPage();

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(2000);

        click(GetLocator("ConnectWithUs"), extentTest);
        Thread.sleep(2000);

        backPage();

        scrollIntoView(GetLocator("ViewAllProducts"));
        Thread.sleep(2000);


        ISLocatorDisplayed(GetLocator("TwitterIcon"), extentTest);
       // Boolean verifyTwitterIcon = driver.findElement(GetLocator("TwitterIcon").getBy()).isDisplayed();
       // BooleanAsseration(verifyTwitterIcon, extentTest, "Twitter icon is visible", "Twitter icon is not visible");
       // System.out.println("Twitter validation Success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("FbIcon"), extentTest);
       // Boolean verifyFbIcon = driver.findElement(GetLocator("FbIcon").getBy()).isDisplayed();
       // BooleanAsseration(verifyFbIcon, extentTest, "Fb icon is visible", "Fb icon is not visible");
       // System.out.println("Fb validation Success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("InstaIcon"), extentTest);
       // Boolean verifyInstaIcon = driver.findElement(GetLocator("InstaIcon").getBy()).isDisplayed();
       // BooleanAsseration(verifyInstaIcon, extentTest, "Insta icon is visible", "Insta icon is not visible");
       // System.out.println("Insta validation Success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("LinkedinIcon"), extentTest);
       // Boolean verifyLinkdeinIcon = driver.findElement(GetLocator("LinkedinIcon").getBy()).isDisplayed();
       // BooleanAsseration(verifyLinkdeinIcon, extentTest, "Linkedin icon is visible", "Linkedin icon is not visible");
       // System.out.println("Linkedin validation Success");
        Thread.sleep(2000);
        ISLocatorDisplayed(GetLocator("YouTubeIcon"), extentTest);
       // Boolean verifyYoutubeIcon = driver.findElement(GetLocator("YouTubeIcon").getBy()).isDisplayed();
       // BooleanAsseration(verifyYoutubeIcon, extentTest, "Youtube icon is visible", "Youtube icon is not visible");
       // System.out.println("Youtube validation Success");
        Thread.sleep(2000);

        return true;
    }
}
