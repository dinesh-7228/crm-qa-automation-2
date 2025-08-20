package TestSuite;

import Data.*;
import FrameWork.*;
//import Pages.Cart;

import Pages.CRMPages.Administration.MobileApp.*;
import Pages.CRMPages.Administration.RouteManagement.*;
import Pages.CRMPages.Administration.*;
import Pages.CRMPages.Campaign.*;
import Pages.CRMPages.Communication.AddTemplatePage;
import Pages.CRMPages.Communication.CommunicationDetailsPage;
import Pages.CRMPages.Communication.SendCommunicationNewPage;
import Pages.CRMPages.Customers.*;
import Pages.CRMPages.Daily.DeliveryWeb;
import Pages.CRMPages.Offers.*;
import Pages.CRMPages.Orders.*;
import Pages.CRMPages.Delivery.*;
import Pages.CRMPages.Funds.*;
import Pages.CRMPages.GameManagement.*;
import Pages.CRMPages.PushNotification.*;
import Pages.CRMPages.Rapid.RapidWeb;
import Pages.CRMPages.Referral.*;
import Pages.CRMPages.Complaints.*;
import Pages.CRMPages.HomePage;
import Pages.CRMPages.Analytics.*;

//import Pages.ListingPage;
import Pages.WebApplication.OurStory;
import Pages.WebApplication.Products;
import Pages.WebApplication.WebHomePage;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.*;
import io.qameta.allure.*;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import Data.EnvironmentParameterData;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class WebSuite_Trigger {
    String baseUrl = null;
    int count = 0;
    TestListner testListener = new TestListner();
    Framework framework = new Framework();
    static String Token = "";
    String Lang = "en";
    String Country = "kw";

    public static String Packer_MobileNo = null;
    public static String Box_id = "";

    public static String Delivery_MobileNo = null;

    EnvironmentParameterData environmentData = null;
    Map<String, String> keyValuePairMap = new HashMap<>();
    String pathMaster = System.getProperty("user.dir") + "\\src\\test\\java\\Api\\Response\\Master";
    String pathPreProd = System.getProperty("user.dir") + "\\src\\test\\java\\Api\\Response\\PreProd";

    @BeforeMethod(alwaysRun = true)
    public void preSetup() {
        // environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        // baseUrl = environmentData.getBaseurl();
        Awaitility.reset();
        Awaitility.setDefaultPollDelay(100, TimeUnit.MILLISECONDS);
        Awaitility.setDefaultPollInterval(3, TimeUnit.SECONDS);
        Awaitility.setDefaultTimeout(7, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void flushExtent() {
        Framework.extentReports.flush();
    }

    @DataProvider(name = "Data Provide for Independent API", parallel = true)
    public Iterator<Object[]> dataListForSearch() {
        Framework framework = new Framework();
        List<Object[]> apiDataList = framework.getIndependentAPIdata(APIData.class, "TRUE");
        return apiDataList.listIterator();

    }

    //  ***********************************************
    //	*   			ADMINISTRATION A		      *
    //	***********************************************

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production", "CRM"}, description = "Verifying the Administration Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify pages under the Administration section")
    @Story("Story Name: To check Administration Pages")
    public void Administration_Config() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");
            HomePage homePage = new HomePage(browser);
            AddTimeslotPage addTimeslotPage = new AddTimeslotPage(browser);
            SelfReportedBugsPage selfReportedBugs = new SelfReportedBugsPage(browser);
            BugReportsPage bugReports = new BugReportsPage(browser);
            StaticListPage staticList = new StaticListPage(browser);
            ChatbotMessagePage chatbotMessagePage = new ChatbotMessagePage(browser);
            DeliveryChargeConfigPage deliveryChargeConfig = new DeliveryChargeConfigPage(browser);
            ManualBugReporting manualBugReporting = new ManualBugReporting(browser);
            CommunicationPage communication = new CommunicationPage(browser);
            AccountDeletionPage accountDeletion = new AccountDeletionPage(browser);
            RapidEligibilityPage rapidEligibility = new RapidEligibilityPage(browser);
            NotificationsPage notifications = new NotificationsPage(browser);
            CCFeedbackPage ccFeedback = new CCFeedbackPage(browser);
            GenericTagsPage genericTags = new GenericTagsPage(browser);

            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("Add Timeslot Page validation", "This test verifies that user is able to Add Timeslot");
            TestListner.extentMap.get().put("child2", childTest2);
            addTimeslotPage.TimeslotData(childTest2, testdata);

            ExtentTest childTest3 = parentTest1.createNode("Self Reported Bugs Page validation", "This test verifies that user is able to validate Self Reported Bugs Page");
            TestListner.extentMap.get().put("child3", childTest3);
            selfReportedBugs.SelfReportedBugsData(childTest3, testdata);

            ExtentTest childTest4 = parentTest1.createNode("Bug Reports Page validation", "This test verifies that user is able to validate Bug Reports Page");
            TestListner.extentMap.get().put("child4", childTest4);
            bugReports.BugReportsData(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("Static List Page validation", "This test verifies that user is able to validate Static List Page");
            TestListner.extentMap.get().put("child9", childTest5);
            staticList.StaticListData(childTest5, testdata);

            ExtentTest childTest6 = parentTest1.createNode("ChatbotMessage Page validation", "This test verifies that user is able to Add ChatbotMessage");
            TestListner.extentMap.get().put("child6", childTest6);
            chatbotMessagePage.ChatbotMessageData(childTest6, testdata);

            ExtentTest childTest7 = parentTest1.createNode("Delivery Charge Config Page validation", "This test verifies that user is able to validate Delivery Charge Config Page");
            TestListner.extentMap.get().put("child7", childTest7);
            deliveryChargeConfig.DeliveryChargeConfigData(childTest7, testdata);

            ExtentTest childTest8 = parentTest1.createNode("Manual Bug Reporting validation", "This test verifies that user is able to Search Manual Bug Reporting");
            TestListner.extentMap.get().put("child8", childTest8);
            manualBugReporting.ManualReportingData(childTest8, testdata);

            ExtentTest childTest9 = parentTest1.createNode("Communication Page validation", "This test verifies that user is able to validate Communication Page");
            TestListner.extentMap.get().put("child9", childTest9);
            communication.CommunicationData(childTest9, testdata);

            ExtentTest childTest10 = parentTest1.createNode("Account Deletion Page validation", "This test verifies that user is able to validate Account Deletion Page");
            TestListner.extentMap.get().put("child10", childTest10);
            accountDeletion.AccountDeletionData(childTest10, testdata);

            ExtentTest childTest11 = parentTest1.createNode("Rapid Eligibility Page validation", "This test verifies that user is able to validate Rapid Eligibility Page");
            TestListner.extentMap.get().put("child11", childTest11);
            rapidEligibility.RapidEligibilityData(childTest11, testdata);

            ExtentTest childTest12 = parentTest1.createNode("Notifications Page validation", "This test verifies that user is able to validate Notifications Page");
            TestListner.extentMap.get().put("child12", childTest12);
            notifications.NotificationsData(childTest12, testdata);

            ExtentTest childTest13 = parentTest1.createNode("CC Feedback Page validation", "This test verifies that user is able to validate CC Feedback Page");
            TestListner.extentMap.get().put("child13", childTest13);
            ccFeedback.CCFeedbackData(childTest13, testdata);

            ExtentTest childTest14 = parentTest1.createNode("Generic Tags Page validation", "This test verifies that user is able to validate Generic Tags Page");
            TestListner.extentMap.get().put("child14", childTest14);
            genericTags.GenericTagsData(childTest14, testdata);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            browser.close();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production", "CRM"}, description = "Verifying the Administration Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify pages under the Administration section")
    @Story("Story Name: To check Administration Pages")
    public void Administration_Route_management() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");
            HomePage homePage = new HomePage(browser);
            AddCityPage addCityPage = new AddCityPage(browser);
            AddAreaPage addAreaPage = new AddAreaPage(browser);
            AddRoutePage addRoutePage = new AddRoutePage(browser);
            AddFranchisePage addFranchisePage = new AddFranchisePage(browser);
            AddLocalityPage addLocalityPage = new AddLocalityPage(browser);
            CityBoundaryPage cityBoundary = new CityBoundaryPage(browser);
            LocalityBoundaryPage localityBoundary = new LocalityBoundaryPage(browser);
            AddRegionPage addRegionPage = new AddRegionPage(browser);
            SetDeliveryTimePage setDeliveryTimePage = new SetDeliveryTimePage(browser);
            CustomerFundsPage customerFundsPage = new CustomerFundsPage(browser);
            FranchiseZonesPage franchiseZonesPage = new FranchiseZonesPage(browser);

            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("AddCity Page validation", "This test verifies that user is able to Add City");
            TestListner.extentMap.get().put("child2", childTest2);
            addCityPage.AddCityData(childTest2, testdata);
          //  browser.get(baseUrl+"/admin/funds/addFunds");
        //    customerFundsPage.fileUpload(childTest2);

            ExtentTest childTest21 = parentTest1.createNode("AddArea Page validation", "This test verifies that user is able to Add Area");
            TestListner.extentMap.get().put("child21", childTest21);
            addAreaPage.AreaData(childTest21, testdata);

            ExtentTest childTest22 = parentTest1.createNode("AddFranchise Page validation", "This test verifies that user is able to Search AddFranchise  Page");
            TestListner.extentMap.get().put("child22", childTest22);
            addFranchisePage.AddFranchiseData(childTest22, testdata);

            ExtentTest childTest23 = parentTest1.createNode("AddRoute Page validation", "This test verifies that user is able to Add Route");
            TestListner.extentMap.get().put("child23", childTest23);
            addRoutePage.RouteData(childTest23, testdata);

            ExtentTest childTest6 = parentTest1.createNode("Add Locality Page validation", "This test verifies that user is able to add Locality");
            TestListner.extentMap.get().put("child6", childTest6);
            addLocalityPage.AddLocalityData(childTest6, testdata);

            ExtentTest childTest7 = parentTest1.createNode("SetDeliveryTime Page validation", "This test verifies that user is able to add data on SetDeliveryTime");
            TestListner.extentMap.get().put("child7", childTest7);
            setDeliveryTimePage.SetDeliveryTimeData(childTest7, testdata);

            ExtentTest childTest8 = parentTest1.createNode("AddRegion Page validation", "This test verifies that user is able to Add Region");
            TestListner.extentMap.get().put("child8", childTest8);
            addRegionPage.RegionData(childTest8, testdata);

            ExtentTest childTest10 = parentTest1.createNode("City Boundary Page validation", "This test verifies that user is able to validate City Boundary Page");
            TestListner.extentMap.get().put("child10", childTest10);
            cityBoundary.CityBoundaryData(childTest10, testdata);

            ExtentTest childTest11 = parentTest1.createNode("Locality Boundary Page validation", "This test verifies that user is able to validate Locality Boundary Page");
            TestListner.extentMap.get().put("child11", childTest11);
            localityBoundary.LocalityBoundaryData(childTest11, testdata);

            ExtentTest childTest12 = parentTest1.createNode("Franchise Zone Page validation", "This test verifies that user is able to validate Franchise Page");
            TestListner.extentMap.get().put("child12", childTest12);
            franchiseZonesPage.FranchiseZoneData(childTest12, testdata);

         //   ExtentTest childTest2 = parentTest1.createNode("Product Prices Page validation", "This test verifies that user is able to validate Product Prices Page");
            //childTest9.setDescription("This test verifies that user is able to validate Product Prices Page");
         //   TestListner.extentMap.get().put("child2", childTest2);
         //   Boolean IsProductPricesVerified = productPrices.ProductPricesData(childTest2, testdata);


//			ExtentTest childTest10 = testListener.startChild("Test Reports Page validation");
//			childTest10.setDescription("This test verifies that user is able to validate Test Reports Page");
//			TestListner.extentMap.get().put("child10", childTest10);
//			Boolean IsTestReportsPageVerified = testReports.TestReportsData(childTest10, testdata); 


        } catch (Exception e) {
            System.out.println(e);
            //framework.logErrorWithSnapshot(browser, e);
        } finally {
            browser.close();
        }
    }


    //*******************************************************************
    //*   			ADMINISTRATION --> MOBILE APP					    *
    //*******************************************************************

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production", "CRM"}, description = "Verifying the Mobile App Pages in the Administration Section")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify the Pages in the Mobile App under the Administration Section")
    @Story("Story Name: To check the Mobile App Pages in the Administration Section")
    public void Administration_Mobile_config() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");
            HomePage homePage = new HomePage(browser);
            ListAppVersion listAppVersion = new ListAppVersion(browser);
            CustomerRatingPage customerRatingPage = new CustomerRatingPage(browser);
            PromotionsPage promotions = new PromotionsPage(browser);
            AppBannerPage appBanner = new AppBannerPage(browser);
            GetAppLinkPage getAppLink = new GetAppLinkPage(browser);
            PaymentScreenPage paymentScreen = new PaymentScreenPage(browser);
            WidgetPriorityPage widgetPriorityPage = new WidgetPriorityPage(browser);
            WalletRechargePage walletRecharge = new WalletRechargePage(browser);
            WidgetScreenPage widgetScreenPage = new WidgetScreenPage(browser);
            WidgetFeaturePage widgetFeaturePage = new WidgetFeaturePage(browser);
            HomeScreenConfigPage homeScreenConfig = new HomeScreenConfigPage(browser);
            AppPushUpdatePage appPushUpdate = new AppPushUpdatePage(browser);
            AppStoriesPage appStories = new AppStoriesPage(browser);
            RateReviewConfigPage rateReviewConfigPage = new RateReviewConfigPage(browser);
            AutoPayConfigPage autoPayConfigPage = new AutoPayConfigPage(browser);

            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("ListAppVersion Page validation", "This test verifies that user is able to Add ListAppVersion");
            TestListner.extentMap.get().put("child2", childTest2);
            listAppVersion.ListAppVersionData(childTest2, testdata);

            ExtentTest childTest3 = parentTest1.createNode("Customer Rating Page validation", "This test verifies that user is able to validate Customer Rating Page");
            TestListner.extentMap.get().put("child3", childTest3);
            customerRatingPage.CustomerRatingData(childTest3, testdata);

            ExtentTest childTest4 = parentTest1.createNode("Promotions Page validation", "This test verifies that user is able to validate Promotions Page");
            TestListner.extentMap.get().put("child4", childTest4);
            promotions.PromotionsData(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("App Banner Page validation", "This test verifies that user is able to validate App Banner Page");
            TestListner.extentMap.get().put("child5", childTest5);
            appBanner.AppBannerData(childTest5, testdata);

            ExtentTest childTest6 = parentTest1.createNode("Get App Link Page validation", "This test verifies that user is able to validate Get App Link Page");
            TestListner.extentMap.get().put("child6", childTest6);
            browser.get(baseUrl+"/admin/mobileAppManagement/getAppLink");
            getAppLink.GetAppLinkData(childTest6, testdata);

            ExtentTest childTest8 = parentTest1.createNode("Payment Screen Page validation", "This test verifies that user is able to validate Payment Screen Page");
            TestListner.extentMap.get().put("child8", childTest8);
            browser.get(baseUrl+"/admin/administration/juspayPayments");
            paymentScreen.PaymentScreenData(childTest8, testdata);

            ExtentTest childTest9 = parentTest1.createNode("Wallet Recharge Page validation", "This test verifies that user is able to validate Wallet Recharge Page");
            TestListner.extentMap.get().put("child9", childTest9);
            browser.get(baseUrl+"/admin/funds/rechargeConfiguration");
            walletRecharge.WalletRechargeData(childTest9, testdata);

            ExtentTest childTest10 = parentTest1.createNode("App Stories Page validation", "This test verifies that user is able to validate App Stories Page");
            TestListner.extentMap.get().put("child10", childTest10);
            browser.get(baseUrl+"/admin/customer/appStories");
            appStories.AppStoriesData(childTest10, testdata);

            ExtentTest childTest12 = parentTest1.createNode("Widget Priority Page validation", "This test verifies that user is able to validate Widget Priority Page");
            TestListner.extentMap.get().put("child12", childTest12);
            browser.get(baseUrl+"/admin/mobileAppManagement/widgetPriorityConfig");
            widgetPriorityPage.WidgetPriorityData(childTest12, testdata);

            ExtentTest childTest13 = parentTest1.createNode("Widget Feature Page validation", "This test verifies that user is able to validate Widget Feature Page");
            TestListner.extentMap.get().put("child13", childTest13);
            browser.get(baseUrl+"/admin/mobileAppManagement/widgetConfigFeature");
            widgetFeaturePage.WidgetFeatureData(childTest13, testdata);

            ExtentTest childTest14 = parentTest1.createNode("Widget Screen Page validation", "This test verifies that user is able to validate Widget Screen Page");
            TestListner.extentMap.get().put("child14", childTest14);
            browser.get(baseUrl+"/admin/mobileAppManagement/widgetConfigScreen");
            widgetScreenPage.WidgetScreenData(childTest14, testdata);

            ExtentTest childTest15 = parentTest1.createNode("Home Screen Config Page validation", "This test verifies that user is able to validate Home Screen Config Page");
            TestListner.extentMap.get().put("child15", childTest15);
            browser.get(baseUrl+"/admin/mobileAppManagement/homeScreenConfiguration");
            homeScreenConfig.HomeScreenConfigData(childTest15, testdata);

            ExtentTest childTest16 = parentTest1.createNode("App Push Update Page validation", "This test verifies that user is able to validate App Push Update Page");
            TestListner.extentMap.get().put("child16", childTest16);
            browser.get(baseUrl+"/admin/mobileAppManagement/appUpdate");
            appPushUpdate.AppPushUpdateData(childTest16, testdata);

            ExtentTest childTest17 = parentTest1.createNode("Rate Review Config Page validation", "This test verifies that user is able to validate App Push Update Page");
            TestListner.extentMap.get().put("child17", childTest17);
            browser.get(baseUrl+"/admin/mobileAppManagement/rateReviewConfig");
            rateReviewConfigPage.RateReviewConfigData(childTest17, testdata);

            ExtentTest childTest18 = parentTest1.createNode("Auto Pay config Page validation", "This test verifies that user is able to validate App Push Update Page");
            TestListner.extentMap.get().put("child18", childTest18);
            browser.get(baseUrl+"/admin/funds/autoPayConfigs");
            autoPayConfigPage.AutoPayConfigData(childTest18, testdata);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            browser.close();
        }
    }

    //	***************************************
    //	*   		GAME MANAGEMENT		      *
    //	***************************************

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production"}, description = "Verifying the Game Management Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify pages under the Game Management section")
    @Story("Story Name: To check Game Management Pages")
    public void GameManagement() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        baseUrl = environmentData.getBaseurl();
        //     	AccountData Login = Loginsync.getInstance().getLogin();
        WebDriver browser = framework.getWebBrowser("demosite");
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");

            HomePage homePage = new HomePage(browser);
            GameConfigurationPage gameConfiguration = new GameConfigurationPage(browser);
            GameTaskPage gameTask = new GameTaskPage(browser);
            GameMediaPage gameMedia = new GameMediaPage(browser);

            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            //childTest1.setDescription("This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            Boolean Ishomedataverified = homePage.HomePageData(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("Game Task Validation", "This test verifies that user is able to Search Game Management- Game Task Page");
            //childTest2.setDescription("This test verifies that user is able to Search Game Management- Game Task Page");
            TestListner.extentMap.get().put("child2", childTest2);
            Boolean IsGameTaskPageVerified = gameTask.GameTaskData(childTest2, testdata);

            ExtentTest childTest3 = parentTest1.createNode("Game Configuration Validation", "This test verifies that user is able to Search Game Management- Game Configuration Page");
            //childTest3.setDescription("This test verifies that user is able to Search Game Management- Game Configuration Page");
            TestListner.extentMap.get().put("child3", childTest3);
            Boolean IsGameConfigurationPageVerified = gameConfiguration.GameConfigurationData(childTest3, testdata);

            ExtentTest childTest4 = parentTest1.createNode("Game Media Validation", "This test verifies that user is able to Search Game Management- Game Media Page");
            //childTest4.setDescription("This test verifies that user is able to Search Game Management- Game Media Page");
            TestListner.extentMap.get().put("child4", childTest4);
            Boolean IsGameMediaPageVerified = gameMedia.GameMediaData(childTest4, testdata);

        } catch (Exception e) {
            System.out.println(e);
            //framework.logErrorWithSnapshot(browser, e);
        } finally {
            browser.close();
        }
    }

    //***************************************
    // *     PUSH NOTIFICATIONS              *
    // ***************************************
    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production", "CRM1"}, description = "Verifying the Push Notification Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify pages under the Push Notification section")
    @Story("Story Name: To check Push Notification Pages")
    public void PushNotifications() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        //AccountData Login = Loginsync.getInstance().getLogin();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");
            HomePage homePage = new HomePage(browser);
            //UserManagementPage userManagement =new UserManagementPage(browser);
            PushStatisticsPage pushStatistics = new PushStatisticsPage(browser);
            DefaultPushConfigurationPage defaultPushConfiguration = new DefaultPushConfigurationPage(browser);
            OfferPushNotificationPage offerPushNotificarion = new OfferPushNotificationPage(browser);

            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("Push Notification Link validation", "This test verifies that user is able to Search Push Notification- Push Page");
            TestListner.extentMap.get().put("child2", childTest2);
            pushStatistics.PushStatisticsData(childTest2, testdata);

            ExtentTest childTest3 = parentTest1.createNode("Default Push Configuration Link validation", "This test verifies that user is able to Search Push Notification- Default Push Configuration Page");
            TestListner.extentMap.get().put("child3", childTest3);
            browser.get(baseUrl+"/admin/notification/addDefaultPush");
            defaultPushConfiguration.DefaultPushConfigurationData(childTest3, testdata);

            ExtentTest childTest4 = parentTest1.createNode("Offer Push Notification Link validation", "This test verifies that user is able to Search Push Notification - Offer Push Notification Page");
            TestListner.extentMap.get().put("child4", childTest4);
            browser.get(baseUrl+"/admin/notification/defaultPushNotification");
            offerPushNotificarion.OfferPushNotificationData(childTest4, testdata);


        } catch (Exception e) {
            System.out.println(e);
            //framework.logErrorWithSnapshot(browser, e);
        } finally {
            browser.close();
        }
    }

    //  ***************************************
    //     	*   			REFERRAL   			  *
    //     	***************************************
    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production", "CRM"}, description = "Verifying the Referral Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify pages under the Referral section")
    @Story("Story Name: To check Referral Pages")
    public void Referral() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        //AccountData Login = Loginsync.getInstance().getLogin();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");
            HomePage homePage = new HomePage(browser);
            CustomerReferralsPage customerReferralsPage = new CustomerReferralsPage(browser);
            RejectedReferrerListPage rejectedReferrerListPage = new RejectedReferrerListPage(browser);
            ViewCustomerReferralsPage viewCustomerReferralPage = new ViewCustomerReferralsPage(browser);
            ReferralDashboardPage referralDashboardPage = new ReferralDashboardPage(browser);

            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            //childTest1.setDescription("This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            Boolean Ishomedataverified = homePage.HomePageData(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("CustomerReferrals Page validation", "This test verifies that user is able to Search data on CustomerReferrals");
            //childTest2.setDescription("This test verifies that user is able to Search data on CustomerReferrals");
            TestListner.extentMap.get().put("child2", childTest2);
            Boolean IsViewCustomerReferralsverified = viewCustomerReferralPage.ViewCustomerReferralsData(childTest2, testdata);

            ExtentTest childTest3 = parentTest1.createNode("Customer Referral Page validation", "This test verifies that user is able to validate Customer Referral Page");
            //childTest4.setDescription("This test verifies that user is able to validate Customer Referral Page");
            TestListner.extentMap.get().put("child3", childTest3);
            Boolean IsCustomerReferralsverified = customerReferralsPage.CustomerReferralsData(childTest3, testdata);

            ExtentTest childTest4 = parentTest1.createNode("Referral Dashboard Page validation", "This test verifies that user is able to Validate Referral Dashboard Page");
            //childTest5.setDescription("This test verifies that user is able to Validate Referral Dashboard Page");
            TestListner.extentMap.get().put("child4", childTest4);
            Boolean IsReferralDashboardverified = referralDashboardPage.ReferralDashboardData(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("Rejected Referrer List Page validation", "This test verifies that user is able to validate Rejected Referrer List Page");
            //childTest6.setDescription("This test verifies that user is able to validate Rejected Referrer List Page");
            TestListner.extentMap.get().put("child5", childTest5);
            Boolean IsRejectedReferrerListverified = rejectedReferrerListPage.RejectedReferrerListData(childTest5, testdata);

        } catch (Exception e) {
            System.out.println(e);
            //framework.logErrorWithSnapshot(browser, e);
        } finally {
            browser.close();
        }
    }

    //  ***************************************
    //       	*   			DELIVERY  			  *
    //       	***************************************
    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production", "CRM"}, description = "Verifying the Delivery Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify pages under the Delivery section")
    @Story("Story Name: To check Delivery Pages")
    public void Delivery() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        //AccountData Login = Loginsync.getInstance().getLogin();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");
            HomePage homePage = new HomePage(browser);
            FranchiseZonesPage franchiseZonesPage = new FranchiseZonesPage(browser);
            RapidBlackSpotPage rapidBlackSpotPage = new RapidBlackSpotPage(browser);

            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            //childTest1.setDescription("This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            Boolean Ishomedataverified = homePage.HomePageData(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("Franchise Zone Page validation", "This test verifies that user is able to Search FranchiseZoneData Page");
            //childTest2.setDescription("This test verifies that user is able to Search FranchiseZoneData Page");
            TestListner.extentMap.get().put("child2", childTest2);
            Boolean IsFranchiseZoneDataverified = franchiseZonesPage.FranchiseZoneData(childTest2, testdata);

            ExtentTest childTest3 = parentTest1.createNode("Rapid Black Spots Page validation", "This test verifies that user is able to Search Rapid Black Spots Page");
            //childTest3.setDescription("This test verifies that user is able to Search Rapid Black Spots Page");
            TestListner.extentMap.get().put("child3", childTest3);
            Boolean IsRapidBlackSpotPageDataverified = rapidBlackSpotPage.RapidBlackSpotData(childTest3, testdata);
        } catch (Exception e) {
            System.out.println(e);
            framework.logErrorWithSnapshot(browser, e);
        } finally {
            browser.close();
        }
    }


    //          ***************************************
    //       	*   			CAMPAIGN A 			  *
    //       	***************************************

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production", "CRM"}, description = "Verifying the Campaign Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify pages under the Campaign section")
    @Story("Story Name: To check Campaign Pages")
    public void Campaign() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        //AccountData Login = Loginsync.getInstance().getLogin();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");
            HomePage homePage = new HomePage(browser);
            AddCampaignerPage addCampaigner = new AddCampaignerPage(browser);
            ListCampaignerPage listCampaignerPage = new ListCampaignerPage(browser);
            ListCampaignDetailsPage listCampaignDetailsPage = new ListCampaignDetailsPage(browser);
            CampaignOrderTrackerPage campaignOrderTrackerPage = new CampaignOrderTrackerPage(browser);
            CampaignerCollectionDetailPage campaignerCollectionDetailPage = new CampaignerCollectionDetailPage(browser);
            LocationMarkerPage locationMarker = new LocationMarkerPage(browser);
            ManageCampaignPage manageCampaignPage = new ManageCampaignPage(browser);
            BrandPartnerPage brandPartner = new BrandPartnerPage(browser);
            BPIncentivesPage bpIncentives = new BPIncentivesPage(browser);
            RetailStorePage retailStore = new RetailStorePage(browser);
            RetailAttendancePage retailAttendance = new RetailAttendancePage(browser);
            BrandPartnerFeeds bpFeeds = new BrandPartnerFeeds(browser);


            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("List Campaign Page validation", "This test verifies that user is able to validate List Campaign Page");
            TestListner.extentMap.get().put("child2", childTest2);
            listCampaignDetailsPage.ListCampaignData(childTest2, testdata);

            ExtentTest childTest3 = parentTest1.createNode("Campaign Order Tracker Page validation", "This test verifies that user is able to validate Campaign Order Tracker Page");
            TestListner.extentMap.get().put("child3", childTest3);
            browser.get(baseUrl+"admin/campaign/orderTracker");
            campaignOrderTrackerPage.CampaignOrderTrackerData(childTest3, testdata);

            ExtentTest childTest4 = parentTest1.createNode("List Campaigner Page validation", "This test verifies that user is able to validate List Campaigner Page");
            TestListner.extentMap.get().put("child4", childTest4);
            browser.get(baseUrl+"admin/campaign/listCampaigner");
            listCampaignerPage.ListCampaignerData(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("Add Campaigner Page validation", "This test verifies that user is able to validate Add Campaigner Page");
            TestListner.extentMap.get().put("child5", childTest5);
            browser.get(baseUrl+"admin/campaign/newAddCampaigner");
            addCampaigner.AddCampaignerData(childTest5, testdata);

            ExtentTest childTest6 = parentTest1.createNode("Campaign Collection Detail Page validation", "This test verifies that user is able to validate Campaign Collection Detail Page");
            TestListner.extentMap.get().put("child6", childTest6);
            browser.get(baseUrl+"admin/campaign/campaignerCollection");
            campaignerCollectionDetailPage.CampaignerCollectionDetailData(childTest6, testdata);

            ExtentTest childTest7 = parentTest1.createNode("Location Marker Page validation", "This test verifies that user is able to validate Location Marker Page");
            TestListner.extentMap.get().put("child7", childTest7);
            browser.get(baseUrl+"admin/campaign/locationMarking");
            locationMarker.LocationMarkerData(childTest7, testdata);

            ExtentTest childTest8 = parentTest1.createNode("Manage Campaign Page validation", "This test verifies that user is able to validate Manage Campaign Page");
            TestListner.extentMap.get().put("child8", childTest8);
            browser.get(baseUrl+"admin/campaign/manageCampaign");
            manageCampaignPage.ManageCampaignData(childTest8,testdata);

            ExtentTest childTest9 = parentTest1.createNode("Brand Partner Page validation", "This test verifies that user is able to validate Brand Partner Page");
            TestListner.extentMap.get().put("child9", childTest9);
            browser.get(baseUrl+"admin/campaign/campaignerRemarks");
            brandPartner.BrandPartnerData(childTest9, testdata);

            ExtentTest childTest10 = parentTest1.createNode("Brand Partner Feeds Page validation", "This test verifies that user is able to validate Brand Partner Feeds");
            TestListner.extentMap.get().put("child10", childTest10);
            browser.get(baseUrl+"admin/campaign/feeds");
            bpFeeds.BPFeedsData(childTest10, testdata);

            ExtentTest childTest11 = parentTest1.createNode("BP Incentives Page validation", "This test verifies that user is able to validate BP Incentives Page");
            TestListner.extentMap.get().put("child11", childTest11);
            browser.get(baseUrl+"admin/campaign/bpIncentives");
            bpIncentives.BPIncentivesData(childTest11, testdata);
/*
            ExtentTest childTest12 = parentTest1.createNode("Retail Store Page validation", "This test verifies that user is able to validate Retail Store Page");
            TestListner.extentMap.get().put("child12", childTest12);
            retailStore.RetailStoreData(childTest12, testdata);

            ExtentTest childTest13 = parentTest1.createNode("Retail Attendance Page validation", "This test verifies that user is able to validate Retail Attendance Page");
            TestListner.extentMap.get().put("child13", childTest13);
            retailAttendance.RetailAttendanceData(childTest13, testdata);


 */

        } catch (Exception e) {
            System.out.println(e);
            framework.logErrorWithSnapshot(browser, e);
        } finally {
            browser.close();
        }
    }

    //  ***************************************
    //	*   			CAMPAIGN B 			  *
    //	***************************************


    //  ***************************************
    //	*   			ORDER A  			  *
    //	***************************************
    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production", "CRM"}, description = "Verifying the Order Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify pages under the Order section")
    @Story("Story Name: To check Order Pages")
    public void Order() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        //AccountData Login = Loginsync.getInstance().getLogin();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");
            HomePage homePage = new HomePage(browser);
            OrderTrackerPage orderTrackerPage = new OrderTrackerPage(browser);
            DeliverySummaryPage deliverySummaryPage = new DeliverySummaryPage(browser);
            ListOrderPage listOrderPage = new ListOrderPage(browser);
            GenerateRouteSheetPage generateRouteSheetPage = new GenerateRouteSheetPage(browser);
            ViewIndentPage viewIndentPage = new ViewIndentPage(browser);
            OrderReportPage orderReportPage = new OrderReportPage(browser);
            POsWalletPage pOsWalletPage = new POsWalletPage(browser);
            PlaceFreeOrderPage placeFreeOrderPage = new PlaceFreeOrderPage(browser);
            DigiOrderTrackerPage digiOrderTrackerPage = new DigiOrderTrackerPage(browser);
            AreaDeliveryPage areaDeliveryPage = new AreaDeliveryPage(browser);
            ConfirmedDeliveriesPage confirmedDeliveriesPage = new ConfirmedDeliveriesPage(browser);
            AllocateOrdersPage allocateOrders = new AllocateOrdersPage(browser);

            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("List Order Page validation", "This test verifies that user is able to Search List Order Page");
            TestListner.extentMap.get().put("child2", childTest2);
            listOrderPage.ListOrderData(childTest2, testdata);

            ExtentTest childTest3 = parentTest1.createNode("Generate Routesheet Page validation", "This test verifies that user is able to Search Generate Routesheet Page");
            TestListner.extentMap.get().put("child3", childTest3);
            generateRouteSheetPage.GenerateRouteSheetData(childTest3, testdata);

            ExtentTest childTest4 = parentTest1.createNode("OrderReport Page validation", "This test verifies that user is able to Search data on Order Report");
            TestListner.extentMap.get().put("child4", childTest4);
            orderReportPage.OrderReportData(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("View Indent Page validation", "This test verifies that user is able to Search View Indent Page");
            TestListner.extentMap.get().put("child5", childTest5);
            viewIndentPage.ViewIndentData(childTest5, testdata);

            ExtentTest childTest6 = parentTest1.createNode("Delivery Summary Page validation", "This test verifies that user is able to Search Delivery Summary Page");
            TestListner.extentMap.get().put("child6", childTest6);
            deliverySummaryPage.DeliverySummaryData(childTest6, testdata);

            ExtentTest childTest7 = parentTest1.createNode("Order Tracker Page validation", "This test verifies that user is able to Search Order Tracker Page");
            TestListner.extentMap.get().put("child7", childTest7);
            orderTrackerPage.OrderTrackerData(childTest7, testdata);

            ExtentTest childTest8 = parentTest1.createNode("POs Wallet On Hold Page validation", "This test verifies that user is able to Search POs Wallet On Hold Page");
            TestListner.extentMap.get().put("child8", childTest8);
            pOsWalletPage.POsWalletData(childTest8, testdata);

            ExtentTest childTest9 = parentTest1.createNode("PlaceFreeOrder Page validation", "This test verifies that user is able to Search PlaceFreeOrder  Page");
            TestListner.extentMap.get().put("child9", childTest9);
            placeFreeOrderPage.PlaceFreeOrderData(childTest9, testdata);

            ExtentTest childTest10 = parentTest1.createNode("Digi Order Tracker Page validation", "This test verifies that user is able to Search Digi Order Tracker Page");
            TestListner.extentMap.get().put("child10", childTest10);
            digiOrderTrackerPage.DigiOrderTrackerData(childTest10, testdata);

            ExtentTest childTest11 = parentTest1.createNode("Area Delivery Page validation", "This test verifies that user is able to Search Area Delivery Page");
            TestListner.extentMap.get().put("child11", childTest11);
            areaDeliveryPage.AreaDeliveryData(childTest11, testdata);

            ExtentTest childTest12 = parentTest1.createNode("Confirmed Deliveries Page validation", "This test verifies that user is able to Search Confirmed Deliveries Page");
            TestListner.extentMap.get().put("child12", childTest12);
            confirmedDeliveriesPage.ConfirmedDeliveriesData(childTest12, testdata);

            ExtentTest childTest13 = parentTest1.createNode("Allocate Order Validation", "This test verifies that user is able to Search Order- Allocate Order Page");
            TestListner.extentMap.get().put("child13", childTest13);
            allocateOrders.AllocateOrdersData(childTest13, testdata);

        } catch (Exception e) {
            System.out.println(e);
            //framework.logErrorWithSnapshot(browser, e);
        } finally {
            browser.close();
        }
    }

    //  ***************************************
    //	*   			ORDER B  			  *
    //	***************************************
    //  ***************************************
    //	*   			CUSTOMER A 			  *
    //	***************************************

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production"}, description = "Verifying the Customer Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Pages under the Customer section")
    @Story("Story Name: To check the Customer Pages")
    public void Customer() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        //AccountData Login = Loginsync.getInstance().getLogin();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");

            HomePage homePage = new HomePage(browser);
            SetPriorityPage setPriorityPage = new SetPriorityPage(browser);
            AttritionTrackerPage attritionTrackerPage = new AttritionTrackerPage(browser);
            StopCustomerPage stopCustomerPage = new StopCustomerPage(browser);
            HoldCustomerPage holdCustomerPage = new HoldCustomerPage(browser);
            SendCommunicationPage sendCommunication = new SendCommunicationPage(browser);
            CustomerProfilePage customerProfile = new CustomerProfilePage(browser);
            CashHPPage cashHPPage = new CashHPPage(browser);
            DeliveryHP deliveryHPPage = new DeliveryHP(browser);
            SetCustomerPenalty setCustomerPenalty = new SetCustomerPenalty(browser);
            CreditLimitCheckPage creditLimitCheckPage = new CreditLimitCheckPage(browser);
            AskExactLocationPage askExactLocation = new AskExactLocationPage(browser);
            SMSLogViewPage smsLogViewPage = new SMSLogViewPage(browser);
            WhatsAppChatHistoryPage whatsAppChatHistory = new WhatsAppChatHistoryPage(browser);

            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);

//			ExtentTest childTest2 = testListener.startChild("List Customer Page Validation");
//			childTest2.setDescription("This test verifies that user is able to validate Customer - List Customer Page");
//			TestListner.extentMap.get().put("child2", childTest2);
//			Boolean IslistCustomerPagePageVerified = listCusomerPage.ListCustomerData(childTest2, testdata);

            ExtentTest childTest3 = parentTest1.createNode("Customer Profile validation", "This test verifies that user is able to Search Customer- Customer Profile Page");
            TestListner.extentMap.get().put("child3", childTest3);
            customerProfile.CustomerProfileData(childTest3, testdata);

            ExtentTest childTest4 = parentTest1.createNode("StopCustomer Page validation", "This test verifies that user is able to Search StopCustomer Page");
            TestListner.extentMap.get().put("child4", childTest4);
            stopCustomerPage.StopCustomerData(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("Send Communication validation", "This test verifies that user is able to Search Customer- Send Communication Page");
            TestListner.extentMap.get().put("child5", childTest5);
            sendCommunication.SendCommunicationData(childTest5, testdata);

            ExtentTest childTest6 = parentTest1.createNode("Attrition Tracker Page validation", "This test verifies that user is able to Search Attrition Tracker Page");
            TestListner.extentMap.get().put("child6", childTest6);
            attritionTrackerPage.AttritionTrackerData(childTest6, testdata);

            ExtentTest childTest7 = parentTest1.createNode("SetPriority Page validation", "This test verifies that user is able to Search  Set Pri0rity");
            TestListner.extentMap.get().put("child7", childTest7);
            setPriorityPage.SetPriorityData(childTest7, testdata);

            ExtentTest childTest8 = parentTest1.createNode("HoldCustomer Page validation", "This test verifies that user is able to Search HoldCustomer Page");
            TestListner.extentMap.get().put("child8", childTest8);
            holdCustomerPage.HoldCustomerData(childTest8, testdata);

//			ExtentTest childTest7 = testListener.startChild("Allocate Area To Customer validation");
//			childTest7.setDescription("This test verifies that user is able to Search Customer- Allocate Area To Customer Page");
//			TestListner.extentMap.get().put("child7", childTest7);
//			Boolean IsAllocateAreaToCustomerPageVerified = allocateAreaToCustomer.AllocateAreaToCustomerData(childTest7, testdata);
//
            ExtentTest childTest9 = parentTest1.createNode("Cash HP Page validation", "This test verifies that user is able to Search Cash HP");
            TestListner.extentMap.get().put("child9", childTest9);
            cashHPPage.CashHPData(childTest9, testdata);

            ExtentTest childTest10 = parentTest1.createNode("Delivery HP Page validation", "This test verifies that user is able to Search Delivery HP");
            TestListner.extentMap.get().put("child10", childTest10);
            deliveryHPPage.DeliveryHPData(childTest10, testdata);

            ExtentTest childTest11 = parentTest1.createNode("SetCustomerPenalty Page validation", "This test verifies that user is able to Search CustomerPenalty ");
            TestListner.extentMap.get().put("child11", childTest11);
            setCustomerPenalty.CustomerPenaltyData(childTest11, testdata);

            ExtentTest childTest12 = parentTest1.createNode("AskExact Location validation", "This test verifies that user is able to Search Customer- Ask Exact Location Page");
            TestListner.extentMap.get().put("child12", childTest12);
            askExactLocation.AskExactLocationData(childTest12, testdata);

//			ExtentTest childTest6 = testListener.startChild("Send Refund Mode Details Page validation");
//			childTest6.setDescription("This test verifies that user is able to Search Send Refund Mode Data");
//			TestListner.extentMap.get().put("child6", childTest6);
//			Boolean IsSendRefundModeDataverified = sendRefundModeDetailsPage.RefundModeData(childTest6, testdata);

            ExtentTest childTest13 = parentTest1.createNode("Credit Limit Check Page validation", "This test verifies that user is able to Search Credit Limit Check Page");
            TestListner.extentMap.get().put("child13", childTest13);
            creditLimitCheckPage.CreditLimitCheckData(childTest13, testdata);

            ExtentTest childTest14 = parentTest1.createNode("Whatsapp Chat History Page validation", "This test verifies that user is able to validate Whats App Chat History Page");
            TestListner.extentMap.get().put("child14", childTest14);
            whatsAppChatHistory.WhatsAppChatHistoryData(childTest14, testdata);

            ExtentTest childTest15 = parentTest1.createNode("SMS Log View Page validation", "This test verifies that user is able to validate SMS Log View Page");
            TestListner.extentMap.get().put("child15", childTest15);
            smsLogViewPage.SMSLogViewData(childTest15, testdata);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            browser.close();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production"}, description = "Verifying the Complaint Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify pages under the Complaint section")
    @Story("Story Name: To check Complaint Pages")
    public void Offers() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");
            HomePage homePage = new HomePage(browser);
            ProductOffer productOffer = new ProductOffer(browser);
            RechargeOffer rechargeOffer = new RechargeOffer(browser);
            MembershipOffer membershipOffer = new MembershipOffer(browser);
            MemebershipPlan memebershipPlan = new MemebershipPlan(browser);
            InterstitialOffers interstitialOffers = new InterstitialOffers(browser);
            ThirdParty_offer thirdPartyOffer = new ThirdParty_offer(browser);
            RechargeOfferPromoCode rechargeOfferPromoCode = new RechargeOfferPromoCode(browser);
            FOMO_Offer fomoOffer = new FOMO_Offer(browser);

            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("Product Offer page validation", "This test verifies that user is able add New Product Offer");
            TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl+"admin/offers/productOffer");
            productOffer.product_offer_sanity(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Recharge Offer page validation", "This test verifies that user is able add New Recharge Offer");
            TestListner.extentMap.get().put("child3", childTest3);
            browser.get(baseUrl+"/admin/offers/rechargeOffers");
            rechargeOffer.Rechargeoffer_Sanity(childTest3);

            ExtentTest childTest4 = parentTest1.createNode("Third Party Offer page validation", "This test verifies that user is able add New Third Party Offer");
            TestListner.extentMap.get().put("child4", childTest4);
            browser.get(baseUrl+"/admin/offers/thirdPartyOffers");
            thirdPartyOffer.Third_party_offers_sanity(childTest4);

            ExtentTest childTest5 = parentTest1.createNode("Membership Plan page validation", "This test verifies that user is able add Membership Plan");
            TestListner.extentMap.get().put("child5", childTest5);
            browser.get(baseUrl+"/admin/offers/membershipPlan");
            memebershipPlan.MembershipPLanSanity(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Membership Plan page validation", "This test verifies that user is able add Membership Plan");
            TestListner.extentMap.get().put("child6", childTest6);
            browser.get(baseUrl+"/admin/offers/memberOffers");
            membershipOffer.Membership_offer_sanity(childTest6);

        //    ExtentTest childTest7 = parentTest1.createNode("Recharge offer Promo Code page validation", "This test verifies that user is able add Recharge offer Promo code");
        //    TestListner.extentMap.get().put("child7", childTest7);
        //    browser.get(baseUrl+"/admin/offers/rechargeOfferPromoCode");
        //    rechargeOfferPromoCode.Recharge_offer_PromoCode_sanity(childTest7);

            ExtentTest childTest8 = parentTest1.createNode("FOMO offer page validation", "This test verifies that user is able add FOMO offer");
            TestListner.extentMap.get().put("child8", childTest8);
            browser.get(baseUrl+"/admin/offers/fomoOffers");
            fomoOffer.FOMO_Offer_Sanity(childTest8);

        } catch (Exception e) {
            System.out.println(e);
            //framework.logErrorWithSnapshot(browser, e);
        } finally {
            browser.close();
        }

    }

    //  ***************************************
    //	*   			CUSTOMER B 			  *
    //	***************************************
    // 		***************************************
    //		*   			CUSTOMER C 			  *
    //		***************************************
    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production", "CRM1"}, description = "Verifying the Customer Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Pages under the Customer section")
    @Story("Story Name: To check the Customer Pages")
    public void Customer_Action_On_Pages() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        //AccountData Login = Loginsync.getInstance().getLogin();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");

            HomePage homePage = new HomePage(browser);
            BlackListedCustomer blackListedCustomer = new BlackListedCustomer(browser);
            WhatsAppCommunicationPage whatsAppCommunication = new WhatsAppCommunicationPage(browser);
            SupportChatHistoryPage supportChatHistory = new SupportChatHistoryPage(browser);
            NonServiceablePage nonServiceable = new NonServiceablePage(browser);
            CriteriaCustomerPage criteriaCustomer = new CriteriaCustomerPage(browser);
            VoiceNotePage voiceNote = new VoiceNotePage(browser);
            MembershipPlanPage membershipPlanPage = new MembershipPlanPage(browser);
            SetFreebieCriteriaPage setFreebieCriteria = new SetFreebieCriteriaPage(browser);

            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            //childTest1.setDescription("This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            Boolean Ishomedataverified = homePage.HomePageData(childTest1, testdata);


            ExtentTest childTest2 = parentTest1.createNode("Black Listed Customers Page validation", "This test verifies that user is able to Search Black Listed Customers ");
            //childTest2.setDescription("This test verifies that user is able to Search Black Listed Customers ");
            TestListner.extentMap.get().put("child2", childTest2);
            Boolean IsBlackListedCustomerDataverified = blackListedCustomer.BlackListedCustomerData(childTest2, testdata);

            ExtentTest childTest3 = parentTest1.createNode("WhatsApp Communication Validation", "This test verifies that user is able to Search Customer- WhatsApp Communication Page");
            //childTest3.setDescription("This test verifies that user is able to Search Customer- WhatsApp Communication Page");
            TestListner.extentMap.get().put("child3", childTest3);
            Boolean IsWhatsAppCommunicationPageVerified = whatsAppCommunication.WhatsAppCommunicationData(childTest3, testdata);

//			ExtentTest childTest4 = testListener.startChild("Voice Note Validation");
//			childTest4.setDescription("This test verifies that user is able to Search Customer- Voice Note Page");
//			TestListner.extentMap.get().put("child4", childTest4);
//			Boolean IsVoiceNotePageVerified = voiceNote.VoiceNoteData(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("Support Chat History Validation", "This test verifies that user is able to Search Customer- Support Chat History Page");
            //childTest5.setDescription("This test verifies that user is able to Search Customer- Support Chat History Page");
            TestListner.extentMap.get().put("child5", childTest5);
            Boolean IsSupportChatHistoryPageVerified = supportChatHistory.SupportChatHistoryData(childTest5, testdata);


            ExtentTest childTest6 = parentTest1.createNode("Criteria Customer Validation", "This test verifies that user is able to Search Customer- Criteria Customer Page");
            //childTest6.setDescription("This test verifies that user is able to Search Customer- Criteria Customer Page");
            TestListner.extentMap.get().put("child6", childTest6);
            Boolean IsCriteriaCustomerPageVerified = criteriaCustomer.CriteriaCustomerData(childTest6, testdata);

            ExtentTest childTest7 = parentTest1.createNode("Set Freebie Criteria Page Validation", "This test verifies that user is able to validate Customer - Set Freebie Criteria Page");
            //childTest7.setDescription("This test verifies that user is able to validate Customer - Set Freebie Criteria Page");
            TestListner.extentMap.get().put("child7", childTest7);
            Boolean IsSetFreebieCriteriaVerified = setFreebieCriteria.SetFreebieCriteriaPageData(childTest7, testdata);

            ExtentTest childTest8 = parentTest1.createNode("Non Serviceable Validation", "This test verifies that user is able to Search Customer- Non Serviceable Page");
            //childTest8.setDescription("This test verifies that user is able to Search Customer- Non Serviceable Page");
            TestListner.extentMap.get().put("child8", childTest8);
            Boolean IsNonServiceablePageVerified = nonServiceable.NonServiceableData(childTest8, testdata);

            ExtentTest childTest9 = parentTest1.createNode("Membership Plan Validation", "This test verifies that user is able to validate Customer - Membership Plan Page");
            //childTest9.setDescription("This test verifies that user is able to validate Customer - Membership Plan Page");
            TestListner.extentMap.get().put("child9", childTest9);
            Boolean IsMembershipPlanPageVerified = membershipPlanPage.MembershipPlanData(childTest9, testdata);

        } catch (Exception e) {
            System.out.println(e);
            //framework.logErrorWithSnapshot(browser, e);
        } finally {
            browser.close();
        }
    }

    //  ***************************************
    //	*   			Complaints   			  *
    //	***************************************
    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production", "CRM1"}, description = "Verifying the Complaint Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify pages under the Complaint section")
    @Story("Story Name: To check Complaint Pages")
    public void Complaint() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        AccountData Login = Loginsync.getInstance().getLogin();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");

            HomePage homePage = new HomePage(browser);
            ListComplaintPage listComplaint = new ListComplaintPage(browser);
            NonDeliverySetPriorityPage nonDeliverySetPriority = new NonDeliverySetPriorityPage(browser);
            LateDeliverySetPriorityPage lateDeliverySetPriority = new LateDeliverySetPriorityPage(browser);
            AddComplaintPage addComplaint = new AddComplaintPage(browser);
            AssignedComplaint assignedComplaint = new AssignedComplaint(browser);
            CallLog calllog = new CallLog(browser);
            DeliveryLiveComplaint deliveryLiveComplaint = new DeliveryLiveComplaint(browser);
            HPDelivery hPDelivery = new HPDelivery(browser);
            ReviewDeliveryTime reviewDeliveryTime = new ReviewDeliveryTime(browser);
            ConcernReasonLevel2Page concernReasonLevel2 = new ConcernReasonLevel2Page(browser);
            ConcernDescriptionLevel3Page concernDescriptionLevel3 = new ConcernDescriptionLevel3Page(browser);
            ConcernAreaPage ConcernArea = new ConcernAreaPage(browser);
            ConcernLevel1Page ConcernLevel1 = new ConcernLevel1Page(browser);
            RootCauseLevel1Page rootCauseLevel1Page = new RootCauseLevel1Page(browser);
            ComplaintPriorityPage complaintPriority = new ComplaintPriorityPage(browser);
            ConcernTypePage ConcernType = new ConcernTypePage(browser);
            RootCauseLevel2Page rootCauseLevel2Page = new RootCauseLevel2Page(browser);
            ComplaintTagPage complaintTagPage = new ComplaintTagPage(browser);

            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            //childTest1.setDescription("This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            Boolean Ishomedataverified = homePage.HomePageData(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("List Complaint Validation", "This test verifies that user is able to Search Complaint- List Complaint Page");
            //childTest78.setDescription("This test verifies that user is able to Search Complaint- List Complaint Page");
            TestListner.extentMap.get().put("child2", childTest2);
            Boolean IsListComplaintPageVerified = listComplaint.ListComplaintData(childTest2, testdata);

            ExtentTest childTest3 = parentTest1.createNode("Non Delivery Set Priority Validation", "This test verifies that user is able to Search Complaint- Non Delivery Set Priority Page");
            //childTest79.setDescription("This test verifies that user is able to Search Complaint- Non Delivery Set Priority Page");
            TestListner.extentMap.get().put("child3", childTest3);
            Boolean IsNonDeliverySetPriorityPageVerified = nonDeliverySetPriority.NonDeliverySetPriorityData(childTest3, testdata);

            ExtentTest childTest4 = parentTest1.createNode("Late Delivery Set Priority Validation", "This test verifies that user is able to Search Complaint- Late Delivery Set Priority Page");
            //childTest4.setDescription("This test verifies that user is able to Search Complaint- Late Delivery Set Priority Page");
            TestListner.extentMap.get().put("child4", childTest4);
            Boolean IsLateDeliverySetPriorityPageVerified = lateDeliverySetPriority.LateDeliverySetPriorityData(childTest4, testdata);

            //			ExtentTest childTest81 = testListener.startChild("Add Complaint Validation");
            //			childTest81.setDescription("This test verifies that user is able to Search Complaint- Add Complaint");
            //			TestListner.extentMap.get().put("child81", childTest81);
            //			Boolean IsAddComplaintPageVerified = addComplaint.AddComplaintData(childTest81, testdata);

            ExtentTest childTest5 = parentTest1.createNode("AssignedComplaint Page Validation", "This test verifies that user is able to Search Complaint- Add Complaint");
            //childTest82.setDescription("This test verifies that user is able to Search Complaint- Add Complaint");
            TestListner.extentMap.get().put("child5", childTest5);
            Boolean IsAssignedomplaintPageVerified = assignedComplaint.AssignedComplaintData(childTest5, testdata);

//			ExtentTest childTest83 = testListener.startChild("CallLog Page Validation");
//			childTest83.setDescription("This test verifies that user is able to Search Call Log Page");
//			TestListner.extentMap.get().put("child83", childTest83);
//			Boolean IscalllogPageVerified = calllog.CallLogData(childTest83, testdata);

            ExtentTest childTest6 = parentTest1.createNode("DeliveryLiveComplaint Page Validation", "This test verifies that user is able to Search DeliveryLiveComplaint");
            //childTest6.setDescription("This test verifies that user is able to Search DeliveryLiveComplaint");
            TestListner.extentMap.get().put("child6", childTest6);
            Boolean IsDeliveryLiveComplaintPageVerified = deliveryLiveComplaint.DeliveryLiveComplaintData(childTest6, testdata);

            ExtentTest childTest7 = parentTest1.createNode("HPDelivery Page Validation", "This test verifies that user is able to Search DeliveryLiveComplaint");
            //childTest7.setDescription("This test verifies that user is able to Search DeliveryLiveComplaint");
            TestListner.extentMap.get().put("child7", childTest7);
            Boolean IsHPDeliveryPageVerified = hPDelivery.HPDeliveryData(childTest7, testdata);

//			ExtentTest childTest86 = testListener.startChild("ReviewDeliveryTime Page Validation");
//			childTest86.setDescription("This test verifies that user is able to Search ReviewDeliveryTime");
//			TestListner.extentMap.get().put("child86", childTest86);
//			Boolean IsReviewDeliveryTimePageVerified = reviewDeliveryTime.ReviewDeliveryTimeData(childTest86, testdata);
            ExtentTest child8 = parentTest1.createNode("ConcernAreaPage  validation", "This test verifies that user is able to validate Concern area page ");
            //child8.setDescription("This test verifies that user is able to validate Concern area page ");
            TestListner.extentMap.get().put("child8", child8);
            Boolean IsConcernAreaPageVerified = ConcernArea.ConcernAreaPageData(child8, testdata);

            ExtentTest child9 = parentTest1.createNode("ConcernTypePage  validation", "This test verifies that user is able to validate Concern Type page ");
            //child102.setDescription("This test verifies that user is able to validate Concern Type page ");
            TestListner.extentMap.get().put("child9", child9);
            Boolean IsConcernTypePageVerified = ConcernType.ConcernTypePageData(child9, testdata);

            ExtentTest child10 = parentTest1.createNode("Concern Level 1 page   validation", "This test verifies that user is able to validate Concern level 1  page ");
            //child1020.setDescription("This test verifies that user is able to validate Concern level 1  page ");
            TestListner.extentMap.get().put("child10", child10);
            Boolean IsConcernLevel1PageVerified = ConcernLevel1.ConcernLevel1PageData(child10, testdata);

            ExtentTest childTest11 = parentTest1.createNode("Concern Reason Level 2 Validation", "This test verifies that user is able to Search Complaint-Concern Reason Level 2");
            //childTest840.setDescription("This test verifies that user is able to Search Complaint-Concern Reason Level 2");
            TestListner.extentMap.get().put("child11", childTest11);
            Boolean IsConcernReasonLevel2PageVerified = concernReasonLevel2.ConcernReasonLevel2Data(childTest11, testdata);

            ExtentTest childTest12 = parentTest1.createNode("Concern Description Level 3 Validation", "This test verifies that user is able to Search Complaint-Concern Description Level 3");
            //childTest12.setDescription("This test verifies that user is able to Search Complaint-Concern Description Level 3");
            TestListner.extentMap.get().put("child12", childTest12);
            Boolean IsConcernDescriptionLevel3PageVerified = concernDescriptionLevel3.ConcernDescriptionLevel3Data(childTest12, testdata);

            ExtentTest childTest13 = parentTest1.createNode("Root Cause Level 1 Validation", "This test verifies that user is able to Search Complaint-Root Cause Level 1");
            //childTest851.setDescription("This test verifies that user is able to Search Complaint-Root Cause Level 1");
            TestListner.extentMap.get().put("child13", childTest13);
            Boolean IsRootCauseLevel1PageVerified = rootCauseLevel1Page.RootCauseLevel1Data(childTest13, testdata);

            ExtentTest childTest14 = parentTest1.createNode("Root Cause Level 2 Validation", "This test verifies that user is able to Search Complaint-Root Cause Level 2");
            //childTest8511.setDescription("This test verifies that user is able to Search Complaint-Root Cause Level 2");
            TestListner.extentMap.get().put("child14", childTest14);
            Boolean IsRootCauseLevel2PageVerified = rootCauseLevel2Page.RootCauseLevel2Data(childTest14, testdata);

            //			ExtentTest child1021 = testListener.startChild("ComplaintTagPage  validation");
            //			child1021.setDescription("This test verifies that user is able to validate Complaint Tag page ");
            //			TestListner.extentMap.get().put("child1021", child1021);
            //			Boolean IsComplaintTagPageVerified  = complaintTagPage.ComplaintTagPageData(child1021, testdata);

            ExtentTest childTest15 = parentTest1.createNode("Complaint Priority Validation", "This test verifies that user is able to Search Complaint-Complaint Priority");
            //childTest87.setDescription("This test verifies that user is able to Search Complaint-Complaint Priority");
            TestListner.extentMap.get().put("child15", childTest15);
            Boolean IsComplaintPriorityPageVerified = complaintPriority.ComplaintPriorityData(childTest15, testdata);


        } catch (Exception e) {
            System.out.println(e);
            //framework.logErrorWithSnapshot(browser, e);
        } finally {
            browser.close();
        }

    }


    //  ***************************************
    //	*   			FUNDS A  			  *
    //	***************************************

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production", "CRM"}, description = "Verifying the Funds Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify pages under the Funds section")
    @Story("Story Name: To check Funds Pages")
    public void Funds() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        //AccountData Login = Loginsync.getInstance().getLogin();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");

            HomePage homePage = new HomePage(browser);
            FundsReceivedPage fundsReceivedPage = new FundsReceivedPage(browser);
            AddPenaltyPage addPenaltyPage = new AddPenaltyPage(browser);
            FundsCollectionTrackerPage fundsCollectionTracker = new FundsCollectionTrackerPage(browser);
            SetCustomerTopUpLimitPage setCustomerTopUpLimit = new SetCustomerTopUpLimitPage(browser);
            ListDeductions listDeductions = new ListDeductions(browser);
            CustomerFundsPage customerFunds = new CustomerFundsPage(browser);
            BenefitAmtTrackerPage benefitAmtTrackerPage = new BenefitAmtTrackerPage(browser);
            RechargeBenefitTrackerPage rechargeBenefitTrackerPage = new RechargeBenefitTrackerPage(browser);
            BillingReportPage billingReportPage = new BillingReportPage(browser);
            BillingInvoiceRecordPage billingInvoiceRecordPage = new BillingInvoiceRecordPage(browser);
            FundsTransactionHistoryPage fundsTransactionHistory = new FundsTransactionHistoryPage(browser);
            HoldCustomerCashbackPage holdCustomerCashback = new HoldCustomerCashbackPage(browser);
            AutoRefundConfigPage autoRefundConfig = new AutoRefundConfigPage(browser);
            ChatbotQualityPage chatbotQuality = new ChatbotQualityPage(browser);


            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);
/*
            ExtentTest childTest2 = parentTest1.createNode("Customer Funds Link validation", "This test verifies that user is able to Search Funds- Customer Funds Page");
            TestListner.extentMap.get().put("child2", childTest2);
            customerFunds.CustomerFundsData(childTest2, testdata);
*/
            ExtentTest childTest3 = parentTest1.createNode("Funds Received Page validation", "This test verifies that user is able to Search Funds Received Page");
            TestListner.extentMap.get().put("child3", childTest3);
            fundsReceivedPage.FundsReceivedData(childTest3, testdata);
/*
            ExtentTest childTest4 = parentTest1.createNode("Set Customer Top Up Limit Link validation", "This test verifies that user is able to Search Funds- Set Customer Top Up Limit Page");
            TestListner.extentMap.get().put("child4", childTest4);
            setCustomerTopUpLimit.SetCustomerTopUpLimitData(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("Add Penalty Page validation", "This test verifies that user is able to Search Add Penalty Page");
            TestListner.extentMap.get().put("child5", childTest5);
            addPenaltyPage.AddPenaltyData(childTest5, testdata);

            ExtentTest childTest6 = parentTest1.createNode("Funds Collection Tracker Link validation", "This test verifies that user is able to Search Funds- Collection Tracker Page");
            TestListner.extentMap.get().put("child6", childTest6);
            fundsCollectionTracker.FundsCollectionTrackerData(childTest6, testdata);

            ExtentTest childTest7 = parentTest1.createNode("Benefit Amt Tracker Page validation", "This test verifies that user is able to Search Benefit Amt Tracker Page");
            TestListner.extentMap.get().put("child7", childTest7);
            benefitAmtTrackerPage.BenefitAmtTrackerData(childTest7, testdata);

            ExtentTest childTest8 = parentTest1.createNode("ListDeductions Page validation", "This test verifies that user is able to Search ListDeductions Page");
            TestListner.extentMap.get().put("child8", childTest8);
            listDeductions.ListDeductionsData(childTest8, testdata);

            ExtentTest childTest9 = parentTest1.createNode("RechargeBenefitTracker Page validation", "This test verifies that user is able to Search Recharge Benefit Tracker Page");
            TestListner.extentMap.get().put("child9", childTest9);
            rechargeBenefitTrackerPage.RechargeBenefitTrackerData(childTest9, testdata);

            ExtentTest childTest10 = parentTest1.createNode("Billing Report Page validation", "This test verifies that user is able to Search Billing Report Page");
            TestListner.extentMap.get().put("child10", childTest10);
            billingReportPage.BillingReportData(childTest10, testdata);

            ExtentTest childTest11 = parentTest1.createNode("Funds Transaction History Link validation", "This test verifies that user is able to Search Funds- Transaction History Page");
            TestListner.extentMap.get().put("child11", childTest11);
            fundsTransactionHistory.FundsTransactionHistoryData(childTest11, testdata);

            ExtentTest childTest12 = parentTest1.createNode("Billing Invoice Record Page validation", "This test verifies that user is able to Search Billing Invoice Record Page");
            TestListner.extentMap.get().put("child12", childTest12);
            billingInvoiceRecordPage.BillingInvoiceRecordData(childTest12, testdata);

            ExtentTest childTest13 = parentTest1.createNode("Hold Customer Cashback Link validation", "This test verifies that user is able to Search Funds- Hold Customer Cashback Page");
            TestListner.extentMap.get().put("child13", childTest13);
            holdCustomerCashback.HoldCustomerCashbackData(childTest13, testdata);

            ExtentTest childTest14 = parentTest1.createNode("Auto Refund Config Link validation", "This test verifies that user is able to Search Funds- Auto Refund Config Page");
            TestListner.extentMap.get().put("child14", childTest14);
            autoRefundConfig.AutoRefundConfigData(childTest14, testdata);

            ExtentTest childTest15 = parentTest1.createNode("Chatbot Quality Link validation", "This test verifies that user is able to Search Funds - Chatbot Quality Page");
            TestListner.extentMap.get().put("child15", childTest15);
            chatbotQuality.ChatbotQualityData(childTest15, testdata);


 */
        } catch (Exception e) {
            System.out.println(e);
            //framework.logErrorWithSnapshot(browser, e);
        } finally {
            browser.close();
        }
    }
    //  ***************************************
    //	*   			FUNDS  B			  *
    //	***************************************

    //          ***************************************
//	*   			ANALYTICS  			  *
//	*************************************** 

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production", "CRM","Local"}, description = "Verifying the Analytics Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify pages under the Analytics section")
    @Story("Story Name: To check Analytics Pages")
    public void CRM_Analytics() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");
            HomePage homePage = new HomePage(browser);
            AnalyticsNewCustomer analyticsNewCustomer = new AnalyticsNewCustomer(browser);
            AnalyticsComplaintStatisticsPage analyticsComplaintStatisticsPage = new AnalyticsComplaintStatisticsPage(browser);
            AnalyticsNotOrderedProduct analyticsNotOrderedProduct = new AnalyticsNotOrderedProduct(browser);
            AnalyticsCustomerSourceTrack analyticsCustomerSourceTrack = new AnalyticsCustomerSourceTrack(browser);
            AnalyticsDailyComplaint analyticsDailyComplaint = new AnalyticsDailyComplaint(browser);
            AnalyticsCustomerOrderCount analyticsCustomerOrderCount = new AnalyticsCustomerOrderCount(browser);
            //ListCampaignerPage listCampaignerPage=new ListCampaignerPage(browser);
            AnalyticsCollectionSummary analyticsCollectionSummary = new AnalyticsCollectionSummary(browser);
            AnalyticsWhatsAppAnalyitics analyticsWhatsAppAnalyitics = new AnalyticsWhatsAppAnalyitics(browser);
            AnalyticsCustomersOrderTrack analyticsCustomersOrderTrack = new AnalyticsCustomersOrderTrack(browser);
            AnalyticsCustomersMonthlyOrderTrack analyticsCustomersMonthlyOrderTrack = new AnalyticsCustomersMonthlyOrderTrack(browser);
            AnalyticsSaleAnalysis analyticsSaleAnalysis = new AnalyticsSaleAnalysis(browser);
            AnalyticsCustomerCashback analyticsCustomerCashback = new AnalyticsCustomerCashback(browser);
            AnalyticsChatbotAnalysis analyticsChatbotAnalysis = new AnalyticsChatbotAnalysis(browser);
            AnalyticsOrderDetailAnalysis analyticsOrderDetailAnalysis = new AnalyticsOrderDetailAnalysis(browser);
            AnalyticsNewCustomerOrders analyticsNewCustomerOrders = new AnalyticsNewCustomerOrders(browser);
            AnalyticsComplaintAnalysis analyticsComplaintAnalysis = new AnalyticsComplaintAnalysis(browser);
            AnalyticsSpinWheel analyticsSpinWheel = new AnalyticsSpinWheel(browser);
            AnalyticsNewLeadCustomer analyticsNewLeadCustomer = new AnalyticsNewLeadCustomer(browser);
            AnalyticsProductOffer analyticsProductOffer = new AnalyticsProductOffer(browser);
            AnalyticsCustomerTrack analyticsCustomerTrack = new AnalyticsCustomerTrack(browser);
            ReviewRatingAnalyticsPage reviewRatingAnalytics = new ReviewRatingAnalyticsPage(browser);
            MembershipLedgerAnalyticsPage membershipLedgerAnalytics = new MembershipLedgerAnalyticsPage(browser);

            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("Analytics NewCustomer Page validation", "This test verifies that user is able to Search Analytics-NewCustomer Page");
            TestListner.extentMap.get().put("child2", childTest2);
            analyticsNewCustomer.AnalyticsNewCustomerData(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Analytics ComplaintStatistics Page validation", "This test verifies that user is able to Search Analytics-ComplaintStatistics Page");
            TestListner.extentMap.get().put("child3", childTest3);
            analyticsComplaintStatisticsPage.AnalyticComplaintStatisticsData(childTest3, testdata);

            ExtentTest childTest44 = parentTest1.createNode("Analytics Collection Summary Page validation", "This test verifies that user is able to Search Analytics-Complain Summary Page");
            TestListner.extentMap.get().put("child44", childTest44);
            analyticsCollectionSummary.AnalyticCollectionSummaryData(childTest44, testdata);


            ExtentTest childTest4 = parentTest1.createNode("Analytics NotOrderedProduct Page validation", "This test verifies that user is able to Search Analytics-NotOrderedProduct Page");
            //childTest4.setDescription("This test verifies that user is able to Search Analytics-NotOrderedProduct Page");
            TestListner.extentMap.get().put("child4", childTest4);
            analyticsNotOrderedProduct.AnalyticsNotOrderedProductData(childTest4, testdata);
/*
            ExtentTest childTest5 = parentTest1.createNode("Analytics Customer order Track Page validation", "This test verifies that user is able to Search Analytics-Customer order Track Page");
            //childTest46.setDescription("This test verifies that user is able to Search Analytics-Customer order Track Page");
            TestListner.extentMap.get().put("child5", childTest5);
            Boolean IsCustomerOrderTracksDataVerified = analyticsCustomersOrderTrack.AnalyticCustomerOrderTrackData(childTest5, testdata);

            ExtentTest childTest6 = parentTest1.createNode("Analytics Customer Monthly order Track Page validation", "This test verifies that user is able to Search Analytics-Customer Monthly order Track Page");
            // childTest6.setDescription("This test verifies that user is able to Search Analytics-Customer Monthly order Track Page");
            TestListner.extentMap.get().put("child6", childTest6);
            Boolean IsCustomerMonthlyOrderTrackDataVerified = analyticsCustomersMonthlyOrderTrack.AnalyticCustomerMonthlyOrderTrackData(childTest6, testdata);

            ExtentTest childTest7 = parentTest1.createNode("Analytics New Customer Orders  Analysis validation", "This test verifies that user is able to Search Analytics- New Customer Orders Page");
            //childTest48.setDescription("This test verifies that user is able to Search Analytics- New Customer Orders Page");
            TestListner.extentMap.get().put("child7", childTest7);
            Boolean IsNewCustomerOrdersDataVerified = analyticsNewCustomerOrders.AnalyticNewCustomerOrdersData(childTest7, testdata);

//     ExtentTest childTest49 = testListener.startChild("Analytics WhatsApp Analytics Page validation");
//     childTest49.setDescription("This test verifies that user is able to Search Analytics-WhatsApp Analytics Page");
//     TestListner.extentMap.get().put("child49", childTest49);
//     Boolean IsWhatsAppAnalyticsDataVerified =analyticsWhatsAppAnalyitics.AnalyticWhatsAppAnalyticsData(childTest49, testdata);

            ExtentTest childTest8 = parentTest1.createNode("Analytics Customer Count Page validation", "This test verifies that user is able to Search Analytics-Customer Count Page");
            // childTest8.setDescription("This test verifies that user is able to Search Analytics-Customer Count Page");
            TestListner.extentMap.get().put("child8", childTest8);
            Boolean IsAnalyticsCustomerCountDataverified = analyticsCustomerOrderCount.AnalyticsCustomerOrderCountData(childTest8, testdata);

            ExtentTest childTest9 = parentTest1.createNode("Analytics  Sale Recharge Analysis validation", "This test verifies that user is able to Search Analytics-Sale Recharge Analysis Page");
            //childTest51.setDescription("This test verifies that user is able to Search Analytics-Sale Recharge Analysis Page");
            TestListner.extentMap.get().put("child9", childTest9);
            Boolean IsSaleRechargeAnalysisDataVerified = analyticsSaleAnalysis.AnalyticSaleAnalysisData(childTest9, testdata);


//     ExtentTest childTest53 = testListener.startChild("Analytics Chatbot Analysis validation");
//     childTest53.setDescription("This test verifies that user is able to Search Analytics- Chatbot Analysis Page");
//     TestListner.extentMap.get().put("child53", childTest53);
//     Boolean IsAnalyticsChatbotAnalysisDataVerified =analyticsChatbotAnalysis.AnalyticChatbotAnalyticsData(childTest53, testdata); 

            ExtentTest childTest10 = parentTest1.createNode("Analytics NewLeadCustomer validation", "This test verifies that user is able to Search Analytics- NewLeadCustomer Page");
            //childTest10.setDescription("This test verifies that user is able to Search Analytics- NewLeadCustomer Page");
            TestListner.extentMap.get().put("child10", childTest10);
            Boolean IsNewLeadCustomerDataVerified = analyticsNewLeadCustomer.AnalyticNewLeadCustomerData(childTest10, testdata);

            ExtentTest childTest11 = parentTest1.createNode("Analytics Order Details Analysis validation", "This test verifies that user is able to Search Analytics- Order Details Analysis Page");
            //childTest57.setDescription("This test verifies that user is able to Search Analytics- Order Details Analysis Page");
            TestListner.extentMap.get().put("child11", childTest11);
            Boolean IsOrderDetailsAnalysisDataVerified = analyticsOrderDetailAnalysis.AnalyticOrderDetailAnalyticsData(childTest11, testdata);

            ExtentTest childTest12 = parentTest1.createNode("Analytics CustomerSourceTrack Page validation", "This test verifies that user is able to Search Analytics-CustomerSourceTrack Page");
            //childTest58.setDescription("This test verifies that user is able to Search Analytics-CustomerSourceTrack Page");
            TestListner.extentMap.get().put("child12", childTest12);
            Boolean IsAnalyticsCustomerSourceTrackDataverified = analyticsCustomerSourceTrack.AnalyticsCustomerSourceTrackData(childTest12, testdata);

            ExtentTest childTest13 = parentTest1.createNode("Analytics DailyComplaint Page validation", "This test verifies that user is able to Search Analytics-DailyComplaint Page");
            //  childTest13.setDescription("This test verifies that user is able to Search Analytics-DailyComplaint Page");
            TestListner.extentMap.get().put("child13", childTest13);
            Boolean IsAnalyticsDailyComplaintDataverified = analyticsDailyComplaint.AnalyticsDailyComplaintData(childTest13, testdata);

            ExtentTest childTest14 = parentTest1.createNode("Analytics Complaint Analytics validation", "This test verifies that user is able to Search Analytics- Complaint Analytics Page");
            //childTest60.setDescription("This test verifies that user is able to Search Analytics- Complaint Analytics Page");
            TestListner.extentMap.get().put("child14", childTest14);
            Boolean IsComplaintAnalyticsDataVerified = analyticsComplaintAnalysis.AnalyticComplaintAnalysisData(childTest14, testdata);

//     ExtentTest childTest61 = testListener.startChild("Autopay Customer Analytics validation");
//     childTest61.setDescription("This test verifies that user is able to validate Autopay Customer Analytics Page");
//     TestListner.extentMap.get().put("child61", childTest61);
//     Boolean IsAutopayCustomerAnalyticsDataVerified =autopayCustomerAnalytics.AutopayCustomerAnalyticsData(childTest61, testdata);

            ExtentTest childTest15 = parentTest1.createNode("Review Rating Analytics validation", "This test verifies that user is able to Validate Review Rating Analytics Page");
            //childTest62.setDescription("This test verifies that user is able to Validate Review Rating Analytics Page");
            TestListner.extentMap.get().put("child62", childTest15);
            Boolean IsReviewRatingAnalyticsDataVerified = reviewRatingAnalytics.ReviewRatingAnalyticsData(childTest15, testdata);

            ExtentTest childTest16 = parentTest1.createNode("Analytics Membership Ledger validation", "This test verifies that user is able to Search Membership Ledger Analytics Page");
            // childTest63.setDescription("This test verifies that user is able to Search Membership Ledger Analytics Page");
            TestListner.extentMap.get().put("child16", childTest16);
            Boolean IsMembershipLedgerAnalyticsVerified = membershipLedgerAnalytics.MembershipLedgerAnalyticsData(childTest16, testdata);

//     ExtentTest childTest66 = testListener.startChild("Analytics Product Offer validation");
//     childTest66.setDescription("This test verifies that user is able to Search Analytics- Product Offer Page");
//     TestListner.extentMap.get().put("child66", childTest66);
//     Boolean IsProductOfferDataVerified =analyticsProductOffer.AnalyticProductOfferData(childTest66, testdata);

            ExtentTest childTest17 = parentTest1.createNode("Analytics Customer Cashback Analysis validation", "This test verifies that user is able to Search Analytics- Customer Cashback Analysis Page");
            //childTest17.setDescription("This test verifies that user is able to Search Analytics- Customer Cashback Analysis Page");
            TestListner.extentMap.get().put("child17", childTest17);
            Boolean IsCustomerCashbackAnalysisDataVerified = analyticsCustomerCashback.AnalyticCustomerCashbackData(childTest17, testdata);

            ExtentTest childTest18 = parentTest1.createNode("Analytics App CustomerTrackData validation", "This test verifies that user is able to Search Analytics- App CustomerTrackData Page");
            // childTest18.setDescription("This test verifies that user is able to Search Analytics- App CustomerTrackData Page");
            TestListner.extentMap.get().put("child18", childTest18);
            Boolean IsAnalyticCustomerTrackDataataVerified = analyticsCustomerTrack.AnalyticCustomerTrackData(childTest18, testdata);

            ExtentTest childTest19 = parentTest1.createNode("Analytics Spin Wheel validation", "This test verifies that user is able to Search Analytics- Spin Wheel Page");
            //childTest55.setDescription("This test verifies that user is able to Search Analytics- Spin Wheel Page");
            TestListner.extentMap.get().put("child19", childTest19);
            Boolean IsSpinWheelDataVerified = analyticsSpinWheel.AnalyticSpinWheelData(childTest19, testdata);

*/
        } catch (Exception e) {
            System.out.println(e);
            // framework.logErrorWithSnapshot(browser, e);
        } finally {
            browser.close();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"production", "CRM", "CommunicationsTest"}, description = "Verifying the Communication Pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify pages under the Communication section")
    @Story("Story Name: To check Communication Pages")
    public void Communications() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
        baseUrl = environmentData.getBaseurl();
        //AccountData Login = Loginsync.getInstance().getLogin();
        WebDriver browser = framework.getWebBrowser("demosite");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset4");

            HomePage homePage = new HomePage(browser);
            SendCommunicationNewPage sendCommunicationPage = new SendCommunicationNewPage(browser);
            AddTemplatePage addTemplatePage = new AddTemplatePage(browser);
            CommunicationDetailsPage communicationDetailsPage = new CommunicationDetailsPage(browser);

            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("Send Communication New Page validation", "This test verifies that user is able to Search Send Communication New Page");
            TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl+"/admin/communication/sendCommunications");
            sendCommunicationPage.SendCommunicationNewData(childTest2, testdata);

            ExtentTest childTest3 = parentTest1.createNode("Add Template Page validation", "This test verifies that user is able to Search Add Template Page");
            TestListner.extentMap.get().put("child3", childTest3);
            browser.get(baseUrl+"/admin/communication/addTemplate");
            addTemplatePage.AddTemplateData(childTest3, testdata);

            ExtentTest childTest4 = parentTest1.createNode("Communication Details Page validation", "This test verifies that user is able to Search Communication Details Page");
            TestListner.extentMap.get().put("child4", childTest4);
            browser.get(baseUrl+"/admin/communication/communicationDetails");
            communicationDetailsPage.CommunicationDetailsData(childTest4, testdata);


        } catch (Exception e) {
            System.out.println(e);
            //framework.logErrorWithSnapshot(browser, e);
        } finally {
            browser.close();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Rapid", "FNV", "Regression"}, description = "Verifying Rapid Order Test", priority = 14)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying Order Created Order Assignee for Delivery")
    @Story("Story Name: To check Administration Page")
    public void Packaging_Assignee_FNV_Rapid() throws Throwable {
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")) {
            browser = framework.getWebBrowser("rapid");
            environmentData = framework.getData(EnvironmentParameterData.class, "rapid");
        } else {
            browser = framework.getWebBrowser("rapid_UAT");
            environmentData = framework.getData(EnvironmentParameterData.class, "rapid_UAT");
        }
        baseUrl = environmentData.getBaseurl();
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            ExtentTest childTest1 = parentTest1.createNode("Login In Rapid", "This test verifies that user able to Login in Rapid");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child1", childTest1);
            RapidWeb rapidWeb = new RapidWeb(browser);
            rapidWeb.RapidWebLogin(childTest1);
            ExtentTest childTest2 = parentTest1.createNode("Registered all Packers", "This test verifies that user able to register all packers");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl + "/cd_authR/instantpackager");
            rapidWeb.Registered_All_Packers(childTest2, "register");
            browser.get(baseUrl + "/dailyR/order/?&franchise_id__in=16");
            //	ExtentTest childTest3 = parentTest1.createNode("Applicable Filter", "This test verifies that user able to Apply filter");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            //		TestListner.extentMap.get().put("child3", childTest3);
            //rapidWeb.FilterSelection("?franchise_id__in=191", childTest3);
            ExtentTest childTest4 = parentTest1.createNode("Allocate Order", "This test verifies that user able to allocate Order");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child4", childTest4);
            //browser.get(baseUrl+"/dailyR/order/?&franchise_id__in=16");
            Packer_MobileNo = rapidWeb.OrderAction("auto_allocate_packer", childTest4);
            rapidWeb.OrderAction_New("change_packager", childTest4);
            Packer_MobileNo = rapidWeb.PackerAllocation_New(childTest4);
            Packer_MobileNo = Packer_MobileNo.replaceAll("[^0-9]", "");
            System.out.println(Packer_MobileNo);
            System.out.println("Pacakging is done");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Rapid", "FNV", "Regression"}, description = "Verifying Rapid Order Test", priority = 16)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying Order Created Order Assignee for Delivery")
    @Story("Story Name: To check Administration Page")
    public void Delivry_Boy_Allocation_FNV_Rapid() throws Throwable {
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")) {
            browser = framework.getWebBrowser("rapid");
            environmentData = framework.getData(EnvironmentParameterData.class, "rapid");
        } else {
            browser = framework.getWebBrowser("rapid_UAT");
            environmentData = framework.getData(EnvironmentParameterData.class, "rapid_UAT");
        }
        baseUrl = environmentData.getBaseurl();
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            ExtentTest childTest1 = parentTest1.createNode("Login In Rapid", "This test verifies that user able to Login in Rapid");
            //	childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child1", childTest1);
            RapidWeb rapidWeb = new RapidWeb(browser);
            rapidWeb.RapidWebLogin(childTest1);
            ExtentTest childTest2 = parentTest1.createNode("Registered all Delivery Boy", "This test verifies that user able to register all Delivery Boy");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl + "/cd_partnerR/instantdeliveryboy/");
            rapidWeb.Registered_All_Packers(childTest2, "mark_allocable");
            browser.get(baseUrl + "/dailyR/orderdballocation/");
            ExtentTest childTest3 = parentTest1.createNode("Applicable Filter", "This test verifies that user able to Apply filter");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            //TestListner.extentMap.get().put("child2", childTest2);
            rapidWeb.FilterSelection("?order__franchise_id__in=16", childTest3);
            ExtentTest childTest4 = parentTest1.createNode("Allocate Order", "This test verifies that user able to allocate Order");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child4", childTest4);
            rapidWeb.OrderAction_New("change_del_boy", childTest4);
            // rapidWeb.OrderAction("auto_allocate_packer", childTest4);


            ExtentTest childTest5 = parentTest1.createNode("Delivery Boy allocation", "This test verifies that user able to allocate Delivery boy");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child5", childTest5);
            System.out.println("Delivery Boy Assigned");
            rapidWeb.DeliveryBoyAllocation(childTest5);
            ExtentTest childTest6 = parentTest1.createNode("Fetching Assigned Delivery boy Number", "This test verifies that user able to fetch assigned delivery boy number");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child6", childTest6);
            browser.get(baseUrl + "/dailyR/orderdballocation/?&order__franchise_id__in=16");
            String DeliveryBoy_id = rapidWeb.Fetch_DeliveryBoy_Id(childTest6);
            DeliveryBoy_id = DeliveryBoy_id.substring(DeliveryBoy_id.indexOf("(") + 1, DeliveryBoy_id.indexOf(")"));
            browser.get(baseUrl + "/cd_partnerR/instantdeliveryboy/");
            Delivery_MobileNo = rapidWeb.Fetch_DeliveryBoy_Number(childTest6, DeliveryBoy_id);
            System.out.println("Delivery Boy No. - " + Delivery_MobileNo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Rapid", "Mix", "Regression1"}, description = "Verifying Rapid Order Test", priority = 24)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying Order Created Order Assignee for Delivery")
    @Story("Story Name: To check Administration Page")
    public void Packaging_Assignee_Mix() throws Throwable {
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")) {
            browser = framework.getWebBrowser("rapid");
            environmentData = framework.getData(EnvironmentParameterData.class, "rapid");
        } else {
            browser = framework.getWebBrowser("rapid_UAT");
            environmentData = framework.getData(EnvironmentParameterData.class, "rapid_UAT");
        }
        baseUrl = environmentData.getBaseurl();
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            ExtentTest childTest1 = testListener.startChild("Login In Rapid", "This test verifies that user able to Login in Rapid");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child1", childTest1);
            RapidWeb rapidWeb = new RapidWeb(browser);
            rapidWeb.RapidWebLogin(childTest1);
            ExtentTest childTest2 = parentTest1.createNode("Registered all Packers", "This test verifies that user able to register all packers");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child2", childTest2);
            //ExtentTest childTest2 = parentTest1.createNode("Applicable Filter", "This test verifies that user able to Apply filter");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            //TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl + "/cd_authR/instantpackager");
            rapidWeb.Registered_All_Packers(childTest2, "register");
            browser.get(baseUrl + "/admin/dailyR/order/");
            //rapidWeb.FilterSelection("?franchise_id__in=71", childTest2);
            ExtentTest childTest3 = parentTest1.createNode("Allocate Order", "This test verifies that user able to allocate Order");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child3", childTest3);
            Packer_MobileNo = rapidWeb.OrderAction("auto_allocate_packer", childTest3);
            Packer_MobileNo = Packer_MobileNo.replaceAll("[^0-9]", "");
            System.out.println(Packer_MobileNo);
            System.out.println("Pacakging is done");
        } catch (Exception e) {

        } finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Rapid", "Dairy", "Regression"}, description = "Verifying Rapid Order Test", priority = 21)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying Order Created Order Assignee for Delivery")
    @Story("Story Name: To check Administration Page")
    public void Delivry_Boy_Allocation_Dairy_Rapid() throws Throwable {
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")) {
            browser = framework.getWebBrowser("Daily");
            environmentData = framework.getData(EnvironmentParameterData.class, "rapid");
        } else {
            browser = framework.getWebBrowser("Daily_uat");
            environmentData = framework.getData(EnvironmentParameterData.class, "rapid_uat");
        }
        baseUrl = environmentData.getBaseurl();
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            ExtentTest childTest1 = parentTest1.createNode("Login In Rapid", "This test verifies that user able to Login in Rapid");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child1", childTest1);
            RapidWeb rapidWeb = new RapidWeb(browser);
            rapidWeb.RapidWebLogin(childTest1);
            ExtentTest childTest2 = parentTest1.createNode("Registered all Delivery Boy", "This test verifies that user able to register all Delivery Boy");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl + "/cd_partnerR/instantdeliveryboy/");
            rapidWeb.Registered_All_Packers(childTest2, "mark_allocable");
            browser.get(baseUrl + "/dailyR/orderdballocation/");
            //browser.get("https://qa-rapidds.countrydelight.in/admin/dailyR/orderdballocation/");
            ExtentTest childTest3 = parentTest1.createNode("Applicable Filter", "This test verifies that user able to Apply filter");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child3", childTest3);
            browser.get(baseUrl + "/dailyR/orderdballocation/");
            rapidWeb.FilterSelection("?order__franchise_id__in=16", childTest3);
            ExtentTest childTest4 = parentTest1.createNode("Allocate Order", "This test verifies that user able to allocate Order");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child4", childTest4);
            rapidWeb.OrderAction_New("change_del_boy", childTest4);
            ExtentTest childTest5 = parentTest1.createNode("Delivery Boy allocation", "This test verifies that user able to allocate Delivery boy");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child5", childTest5);
            rapidWeb.DeliveryBoyAllocation(childTest5);
            System.out.println("Delivery Boy Assigned");
            ExtentTest childTest6 = parentTest1.createNode("Fetching Assigned Delivery boy Number", "This test verifies that user able to fetch assigned delivery boy number");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child6", childTest6);
            browser.get(baseUrl + "/dailyR/orderdballocation/?&order__franchise_id__in=16");
            String DeliveryBoy_id = rapidWeb.Fetch_DeliveryBoy_Id(childTest6);
            DeliveryBoy_id = DeliveryBoy_id.substring(DeliveryBoy_id.indexOf("(") + 1, DeliveryBoy_id.indexOf(")"));
            //DeliveryBoy_id=DeliveryBoy_id.replaceAll("[^0-9]", "");
            browser.get(baseUrl + "/cd_partnerR/instantdeliveryboy/");
            Delivery_MobileNo = rapidWeb.Fetch_DeliveryBoy_Number(childTest6, DeliveryBoy_id);
            System.out.println("Delivery Boy No. - " + Delivery_MobileNo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Rapid", "Dairy", "Regression"}, description = "Verifying Rapid Order Test", priority = 19)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying Order Created Order Assignee for Delivery")
    @Story("Story Name: To check Administration Page")
    public void Packaging_Assignee_Dairy_Rapid() throws Throwable {
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")) {
            browser = framework.getWebBrowser("rapid");
            environmentData = framework.getData(EnvironmentParameterData.class, "rapid");
        } else {
            browser = framework.getWebBrowser("rapid_UAT");
            environmentData = framework.getData(EnvironmentParameterData.class, "rapid_UAT");
        }
        baseUrl = environmentData.getBaseurl();
        //WebDriver browser = framework.getWebBrowser("rapid");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            ExtentTest childTest1 = parentTest1.createNode("Login In Rapid", "This test verifies that user able to Login in Rapid");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child1", childTest1);
            RapidWeb rapidWeb = new RapidWeb(browser);
            rapidWeb.RapidWebLogin(childTest1);
            ExtentTest childTest2 = parentTest1.createNode("Registered all Packers", "This test verifies that user able to register all packers");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl + "/cd_authR/instantpackager");
            rapidWeb.Registered_All_Packers(childTest2, "register");
            browser.get(baseUrl + "/dailyR/order/");
            rapidWeb.FilterSelection("?franchise_id__in=16", childTest2);
            //	ExtentTest childTest2 = parentTest1.createNode("Applicable Filter", "This test verifies that user able to Apply filter");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            //	TestListner.extentMap.get().put("child2", childTest2);
            //	rapidWeb.FilterSelection("?franchise_id__in=71", childTest2);
            ExtentTest childTest3 = parentTest1.createNode("Allocate Order", "This test verifies that user able to allocate Order");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child3", childTest3);
            Packer_MobileNo = rapidWeb.OrderAction("auto_allocate_packer", childTest3);
            rapidWeb.OrderAction_New("change_packager", childTest3);
            Packer_MobileNo = rapidWeb.PackerAllocation_New(childTest3);
            Packer_MobileNo = Packer_MobileNo.replaceAll("[^0-9]", "");
            System.out.println(Packer_MobileNo);
            System.out.println("Pacakging is done");
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Rapid", "Mix", "Regression1"}, description = "Verifying Rapid Order Test", priority = 26)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying Order Created Order Assignee for Delivery")
    @Story("Story Name: To check Administration Page")
    public void Delivry_Boy_Allocation_Mix() throws Throwable {
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")) {
            browser = framework.getWebBrowser("rapid");
            environmentData = framework.getData(EnvironmentParameterData.class, "rapid");
        } else {
            browser = framework.getWebBrowser("rapid_UAT");
            environmentData = framework.getData(EnvironmentParameterData.class, "rapid_UAT");
        }
        baseUrl = environmentData.getBaseurl();
        RapidWeb rapidWeb = new RapidWeb(browser);
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            ExtentTest childTest1 = parentTest1.createNode("Login In Rapid", "This test verifies that user able to Login in Rapid");
            //	ExtentTest childTest1 = testListener.startChild("Login In Rapid", "This test verifies that user able to Login in Rapid");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("Login In Rapid" + " API test with ", childTest1);
            rapidWeb.RapidWebLogin(childTest1);
			/*browser.get("https://qa-rapidds.countrydelight.in/admin/dailyR/orderdballocation/?&order__franchise_id__in=71");
			//ExtentTest childTest2 = parentTest1.createNode("Filter Selection", "This test verifies that user able to Select Filter");
			rapidWeb.FilterSelection_New("?order__franchise_id__in=71", childTest2);
			ExtentTest childTest3 = parentTest1.createNode("Change Delivery Boy");
			rapidWeb.OrderAction_New("change_del_boy", childTest3);
			ExtentTest childTest4 = parentTest1.createNode("Delivery Boy Alocation");
			rapidWeb.DeliveryBoyAllocation_New(childTest4);
			System.out.println("Delivery Boy Assigned");
			*/
            ExtentTest childTest2 = parentTest1.createNode("Registered all Delivery Boy", "This test verifies that user able to register all Delivery Boy");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl + "/cd_partnerR/instantdeliveryboy/");
            rapidWeb.Registered_All_Packers(childTest2, "mark_allocable");
            browser.get(baseUrl + "/dailyR/orderdballocation/?q=1226782425");
            ExtentTest childTest3 = parentTest1.createNode("Applicable Filter", "This test verifies that user able to Apply filter");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            //TestListner.extentMap.get().put("child2", childTest2);
            rapidWeb.FilterSelection("?order__franchise_id__in=16&q=1226782425", childTest3);
            ExtentTest childTest4 = parentTest1.createNode("Allocate Order", "This test verifies that user able to allocate Order");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child4", childTest4);
            rapidWeb.OrderAction_New("change_del_boy", childTest4);
            // rapidWeb.OrderAction("auto_allocate_packer", childTest4);


            ExtentTest childTest5 = parentTest1.createNode("Delivery Boy allocation", "This test verifies that user able to allocate Delivery boy");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child5", childTest5);
            System.out.println("Delivery Boy Assigned");
            rapidWeb.DeliveryBoyAllocation(childTest5);
            ExtentTest childTest6 = parentTest1.createNode("Fetching Assigned Delivery boy Number", "This test verifies that user able to fetch assigned delivery boy number");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child6", childTest6);
            browser.get(baseUrl + "/dailyR/orderdballocation/?q=1226782425&order__franchise_id__in=16");
            String DeliveryBoy_id = rapidWeb.Fetch_DeliveryBoy_Id(childTest6);
            DeliveryBoy_id = DeliveryBoy_id.substring(DeliveryBoy_id.indexOf("(") + 1, DeliveryBoy_id.indexOf(")"));
            browser.get(baseUrl + "/cd_partnerR/instantdeliveryboy/");
            Delivery_MobileNo = rapidWeb.Fetch_DeliveryBoy_Number(childTest6, DeliveryBoy_id);
            System.out.println("Delivery Boy No. - " + Delivery_MobileNo);
        } catch (Exception e) {
            //System.out.println(e);
            //framework.logErrorWithSnapshot(browser,e);
        } finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }
        //Framework.extentReports.flush();
    }

    @JiraPolicy(logTicketReady = true)
    @Test(groups = {"production", "Website"}, description = "verifying with register checkout  user flow")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login page title test on Login Page")
    @Story("Story Name: To check login page title")
    public void WebSiteHomePageValidation() throws Throwable {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite7");
        baseUrl = environmentData.getBaseurl();
        //AccountData Login = Loginsync.getInstance().getLogin();
        WebDriver browser1 = framework.getWebBrowser("demosite7");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser1.get(baseUrl);
            AccountData testdata = framework.getData(AccountData.class, "loginset1");
            //  AccountData testdata1 = framework.getData(AccountData.class, "loginset1");
            WebHomePage webHomePage = new WebHomePage(browser1);
            OurStory ourStory = new OurStory(browser1);
            Products products = new Products(browser1);


            ExtentTest childTest1 = parentTest1.createNode("Home Page validation", "This test verifies that user is able see logo and promo text.");
            //childTest1.setDescription("This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("child1", childTest1);
            Boolean Ishomedataverified = webHomePage.VerifyHomePage(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("OUr Story validation ", "This test verifies that user is able see logo and promo text.");
            //childTest2.setDescription("This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("childTest2", childTest2);
            Boolean Isourtorydataverified = ourStory.VerifyOurSToryPage(childTest2, testdata);

            ExtentTest childTest3 = parentTest1.createNode("Products Page validation ", "This test verifies that user is able see logo and promo text.");
            //childTest2.setDescription("This test verifies that user is able see logo and promo text.");
            TestListner.extentMap.get().put("childTest3", childTest3);
            Boolean IsProductspagedataverified = products.VerifyProductsPage(childTest3, testdata);


        } catch (Exception e) {
            System.out.println(e);
            framework.logErrorWithSnapshot(browser1, e);
        } finally {
            browser1.close();
        }


    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Daily_Dairy_Old", "Daily", "Regression_Old"}, description = "Verifying Rapid Order Test", priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying Order Created Order Assignee for Delivery")
    @Story("Story Name: To check Administration Page")
    public void Delivry_Boy_Inventory_Assign_Dairy() throws Throwable {
        //	environmentData = framework.getData(EnvironmentParameterData.class, "Daily");
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")) {
            browser = framework.getWebBrowser("Daily");
            environmentData = framework.getData(EnvironmentParameterData.class, "Daily");
        } else {
            browser = framework.getWebBrowser("Daily_uat");
            environmentData = framework.getData(EnvironmentParameterData.class, "Daily_uat");
        }
        baseUrl = environmentData.getBaseurl();
        //WebDriver browser = framework.getWebBrowser("Daily");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        AccountData testdataDairy = framework.getData(AccountData.class, "loginset11");
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            DeliveryWeb deliveryweb = new DeliveryWeb(browser);
            ExtentTest childTest1 = parentTest1.createNode("Login In Rapid", "This test verifies that user able to Login in Rapid");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("childTest1", childTest1);
            deliveryweb.DeliveryWebLogin(childTest1);
            ExtentTest childTest2 = parentTest1.createNode("Navigate to Delivery Boy Page", "This test verifies that Delivery Boy Page is working");
            //childTest2.setDescription("This test verifies that Delivery Boy Page is working");
            TestListner.extentMap.get().put("childTest2", childTest2);
            browser.get(baseUrl + "/cd_auth/appversion/");
            //browser.get("https://qa-delivery.countrydelight.in/admin/cd_auth/appversion/");
            deliveryweb.CacheClear(childTest2);
            browser.get(baseUrl + "/inventory/deliveryboyinventory/");
            //browser.get("https://qa-delivery.countrydelight.in/admin/inventory/deliveryboyinventory/");
            ExtentTest childTest3 = parentTest1.createNode("Applied Filter For Delivery boy", "This test verifies that Filter is working in Delivery boy");
            //childTest3.setDescription("This test verifies that Filter is working in Delivery boy");
            TestListner.extentMap.get().put("childTest3", childTest3);
            deliveryweb.FilterSearch(childTest3);
            //browser.get("https://qa-delivery.countrydelight.in/admin/inventory/boyinventory/5839307/change/");
            ExtentTest childTest4 = parentTest1.createNode("Assigned Product Inventory to Delivery Boy", "This test verifies that Inventory can be assign to Delivery Boy");
            //childTest4.setDescription("This test verifies that Inventory can be assign to Delivery Boy");
            TestListner.extentMap.get().put("childTest4", childTest4);
            deliveryweb.InventoryAssign(childTest4, testdataDairy);
            System.out.println("Delivery Boy Inventory Assigned");
        } catch (Exception e) {
            System.out.println(e);
            framework.logErrorWithSnapshot(browser, e);
        } finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Daily_FNV", "Daily", "Regression", "Subscription_Offer"}, description = "Verifying Rapid Order Test", priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying Order Created Order Assignee for Delivery")
    @Story("Story Name: To check Administration Page")
    public void Delivry_Boy_Inventory_Assign_FNV() throws Throwable {
        //environmentData = framework.getData(EnvironmentParameterData.class, "Daily");
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")) {
            browser = framework.getWebBrowser("Daily");
            environmentData = framework.getData(EnvironmentParameterData.class, "Daily");
        } else {
            browser = framework.getWebBrowser("Daily_uat");
            environmentData = framework.getData(EnvironmentParameterData.class, "Daily_uat");
        }
        baseUrl = environmentData.getBaseurl();
        //WebDriver browser = framework.getWebBrowser("Daily");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        AccountData testdataFNV = framework.getData(AccountData.class, "loginset42");
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            DeliveryWeb deliveryweb = new DeliveryWeb(browser);
            ExtentTest childTest1 = parentTest1.createNode("Login In Rapid", "This test verifies that user able to Login in Rapid");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child1", childTest1);
            deliveryweb.DeliveryWebLogin(childTest1);
            ExtentTest childTest2 = parentTest1.createNode("Navigate to Delivery Boy Page", "This test verifies that Delivery Boy Page is working");
            //childTest2.setDescription("This test verifies that Delivery Boy Page is working");
            TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl + "/cd_auth/appversion/");
            //browser.get("https://qa-delivery.countrydelight.in/admin/cd_auth/appversion/");
            deliveryweb.CacheClear(childTest2);
            ExtentTest childTest3 = parentTest1.createNode("Applied Filter For Delivery boy", "This test verifies that Filter is working in Delivery boy");
            //childTest3.setDescription("This test verifies that Filter is working in Delivery boy");
            TestListner.extentMap.get().put("child3", childTest3);
            //browser.get(baseUrl+"/inventory/deliveryboyinventory/");
            browser.get(baseUrl + "/daily/delivery/?q=7836016806&search_by=deliveryBoy__mobile__exact");
            Box_id = deliveryweb.packing(childTest3);
        } catch (Exception e) {
            System.out.println(e);
            framework.logErrorWithSnapshot(browser, e);
        } finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Daily_Mix", "Daily", "Regression"}, description = "Verifying Rapid Order Test", priority = 14)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying Order Created Order Assignee for Delivery")
    @Story("Story Name: To check Administration Page")
    public void Delivry_Boy_Inventory_Assign_Mix() throws Throwable {
        //environmentData = framework.getData(EnvironmentParameterData.class, "Daily");
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")) {
            browser = framework.getWebBrowser("Daily");
            environmentData = framework.getData(EnvironmentParameterData.class, "Daily");
        } else {
            browser = framework.getWebBrowser("Daily_uat");
            environmentData = framework.getData(EnvironmentParameterData.class, "Daily_uat");
        }
        baseUrl = environmentData.getBaseurl();
        //WebDriver browser = framework.getWebBrowser("Daily");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        AccountData testdataFNV = framework.getData(AccountData.class, "loginset1");
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            DeliveryWeb deliveryweb = new DeliveryWeb(browser);
            ExtentTest childTest1 = parentTest1.createNode("Login In Rapid", "This test verifies that user able to Login in Rapid");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child1", childTest1);
            deliveryweb.DeliveryWebLogin(childTest1);
            ExtentTest childTest2 = parentTest1.createNode("Navigate to Delivery Boy Page", "This test verifies that Delivery Boy Page is working");
            //childTest2.setDescription("This test verifies that Delivery Boy Page is working");
            TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl + "/cd_auth/appversion/");
            //browser.get("https://qa-delivery.countrydelight.in/admin/cd_auth/appversion/");
            deliveryweb.CacheClear(childTest2);
            ExtentTest childTest3 = parentTest1.createNode("Applied Filter For Delivery boy", "This test verifies that Filter is working in Delivery boy");
            //childTest3.setDescription("This test verifies that Filter is working in Delivery boy");
            TestListner.extentMap.get().put("child3", childTest3);
            //browser.get(baseUrl+"/inventory/deliveryboyinventory/");
            browser.get(baseUrl + "/daily/delivery/?q=7836016806&search_by=deliveryBoy__mobile__exact");
            Box_id = deliveryweb.packing(childTest3);
        } catch (Exception e) {
            System.out.println(e);
            framework.logErrorWithSnapshot(browser, e);
        } finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Pre"}, description = "Verifying Rapid Order Test", priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying Order Created Order Assignee for Delivery")
    @Story("Story Name: To check Administration Page")
    public void Product_Sync_Rapid() throws IOException {
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")) {
            browser = framework.getWebBrowser("rapid");
            environmentData = framework.getData(EnvironmentParameterData.class, "rapid");
        } else {
            browser = framework.getWebBrowser("rapid_UAT");
            environmentData = framework.getData(EnvironmentParameterData.class, "rapid_UAT");
        }
        baseUrl = environmentData.getBaseurl();
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            ExtentTest childTest1 = parentTest1.createNode("Login In Rapid", "This test verifies that user able to Login in Rapid");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child1", childTest1);
            RapidWeb rapidWeb = new RapidWeb(browser);
            rapidWeb.RapidWebLogin(childTest1);
            ExtentTest childTest2 = parentTest1.createNode("Registered all Packers", "This test verifies that user able to register all packers");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl + "/instant_inventory/productfranchiseavailability/");
            rapidWeb.Sync_Data(childTest2);
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
            framework.logErrorWithSnapshot(browser, e);
        } finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Test"}, description = "Verifying New Build to download", priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying New Build is download on File Folder")
    @Story("Story Name: To check Administration Page")
    public void Build_Download() throws IOException {
        environmentData = framework.getData(EnvironmentParameterData.class, "rapid");
        baseUrl = environmentData.getBaseurl();
        WebDriver browser = framework.getWebBrowser("rapid");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            ExtentTest childTest1 = parentTest1.createNode("Login In Rapid", "This test verifies that user able to Download the latest apk");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child1", childTest1);
            String Build_URL = System.getProperty("Build_URL");
            System.out.println("Build_URL : " + Build_URL);
            Build_URL = "https://nonprod-androidapps-artifacts.s3.ap-south-1.amazonaws.com/transfer_app/transfer_app_dev_33_71.apk";
            browser.get(Build_URL);
            String[] str = Build_URL.split("transfer_app/");
            System.out.println(str[1]);
            Thread.sleep(40000);
            File appD = new File("File");
            File app = new File(appD, str[1]);
            app.renameTo(new File(appD, "CDTransfer.apk"));
        } catch (Exception e) {
            System.out.println(e);
            framework.logErrorWithSnapshot(browser, e);
        } finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login page title test on Login Page")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "BrokenLink"})
    public void brokenLinks() throws MalformedURLException, IOException {
        //   WebDriverManager driver = new ChromeDriverManager();
        //WebDriver browser = framework.getWebBrowser("demosite");
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite8");
        WebDriver browser = framework.getWebBrowser("demosite8");
        baseUrl = environmentData.getBaseurl();
        browser.get(baseUrl);
        //WebDriverManager.chromedriver().setup();
        //   driver.manage().window().maximize();
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://ctdemob2c.anthive.tech/");
        List<WebElement> links = browser.findElements(By.tagName("a"));
        links.addAll(browser.findElements(By.tagName("img")));
        List<WebElement> activelinks = new ArrayList<WebElement>();
        System.out.println("Total links are " + links.size());
        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getAttribute("href"));
            if (links.get(i).getAttribute("href") != null && (!links.get(i).getAttribute("href").contains(" "))) {
                activelinks.add(links.get(i));
            }
//                WebElement ele= links.get(i);
//
//                String url=ele.getAttribute("href");
            //  verifyLinkActive(url);
        }
        System.out.println("size of active links and images----->>" + activelinks.size());
        for (int j = 0; j < activelinks.size(); j++) {
            HttpURLConnection connection = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(activelinks.get(j).getAttribute("href") + response);
        }
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login page title test on Login Page")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "BrokenLink"})
    public void brokenLinks1() throws Throwable {
        //   WebDriverManager driver = new ChromeDriverManager();
        //WebDriver browser = framework.getWebBrowser("demosite8");
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite8");
        WebDriver browser = framework.getWebBrowser("demosite8");
        baseUrl = environmentData.getBaseurl();
        browser.get(baseUrl);
        List<WebElement> allLinks = browser.findElements(By.tagName("a"));
        System.out.println("# Links: " + allLinks.size());
        try {
            int i = 1;
            for (WebElement link : allLinks) {
                String url = link.getAttribute("href");
                // System.out.println("# Links: " + url);
                if (url != null && !url.contains("javascript")) {
                    // Establish A Connection To The URL
                    HttpURLConnection connection =
                            (HttpURLConnection) new URL(url).openConnection();
                    connection.connect();
                    // Get The Response Codes & Response Messages
                    int responseCode = connection.getResponseCode();
                    String responseMessage = connection.getResponseMessage();
                    System.out.println(i + ". " + url +
                            "\n \t" + responseCode + "\n \t" + " " + responseMessage);
                    i++;
                    connection.disconnect();
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Daily_FNV", "Daily_Dairy", "Daily_Mix", "Regression","Subscription_Offer","Local2"}, description = "Verifying Rapid Order Test", priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying Order Created Order Assignee for Delivery")
    @Story("Story Name: To check Administration Page")
    public void Delivry_Details_cancel_Previous_Order() throws Throwable {
        //environmentData = framework.getData(EnvironmentParameterData.class, "Daily");
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")) {
            browser = framework.getWebBrowser("Daily");
            environmentData = framework.getData(EnvironmentParameterData.class, "Daily");
        } else {
            browser = framework.getWebBrowser("Daily_uat");
            environmentData = framework.getData(EnvironmentParameterData.class, "Daily_uat");
        }
        baseUrl = environmentData.getBaseurl();
        //WebDriver browser = framework.getWebBrowser("Daily");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        AccountData testdataFNV = framework.getData(AccountData.class, "loginset42");
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            DeliveryWeb deliveryweb = new DeliveryWeb(browser);
            ExtentTest childTest1 = parentTest1.createNode("Login In Rapid", "This test verifies that user able to Login in Rapid");
            //childTest1.setDescription("This test verifies that user able to Login in Rapid");
            TestListner.extentMap.get().put("child1", childTest1);
            deliveryweb.DeliveryWebLogin(childTest1);
            ExtentTest childTest2 = parentTest1.createNode("Navigate to Delivery Boy Page", "This test verifies that Delivery Boy Page is working");
            //childTest2.setDescription("This test verifies that Delivery Boy Page is working");
            TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl + "/cd_auth/appversion/");
            //browser.get("https://qa-delivery.countrydelight.in/admin/cd_auth/appversion/");
            deliveryweb.CacheClear(childTest2);
            ExtentTest childTest3 = parentTest1.createNode("Applied Filter For Delivery boy", "This test verifies that Filter is working in Delivery boy");
            //childTest3.setDescription("This test verifies that Filter is working in Delivery boy");
            TestListner.extentMap.get().put("child3", childTest3);
            //browser.get(baseUrl+"/inventory/deliveryboyinventory/");
            browser.get(baseUrl + "/daily/delivery/?q=7836016806&search_by=deliveryBoy__mobile__exact");
            //	browser.get(baseUrl+"/daily/delivery/?q=7836016806&search_by=deliveryBoy__mobile__exact");
            deliveryweb.Cancel_Order(childTest3);
            //browser.get("https://qa-delivery.countrydelight.in/admin/inventory/deliveryboyinventory/");
		/*	ExtentTest childTest3 = parentTest1.createNode("Applied Filter For Delivery boy", "This test verifies that Filter is working in Delivery boy");
			//childTest3.setDescription("This test verifies that Filter is working in Delivery boy");
			TestListner.extentMap.get().put("child3", childTest3);
			deliveryweb.FilterSearch(childTest3);
			//browser.get("https://qa-delivery.countrydelight.in/admin/inventory/boyinventory/5839307/change/");
			*/
            ExtentTest childTest4 = parentTest1.createNode("Update All Route in Legacy DB", "This test verifies that Legacy DB will Update");
            //childTest4.setDescription("This test verifies that Inventory can be assign to Delivery Boy");
            TestListner.extentMap.get().put("child4", childTest4);
            browser.get(baseUrl + "/legacy_db/route/");
            deliveryweb.LegacyDBClearForRoute(childTest4);


        } catch (Exception e) {
            System.out.println(e);
            framework.logErrorWithSnapshot(browser, e);
        } finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Regression", "Product_Offer"}, description = "Verifying Rapid Order Test", priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying User is able to create offer")
    @Story("Story Name: To check Administration Page")
    public void Product_offer_create() throws Throwable {
        AccountData testdata;
        //environmentData = framework.getData(EnvironmentParameterData.class, "Daily");
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")) {
            browser = framework.getWebBrowser("demosite");
            environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
            testdata = framework.getData(AccountData.class, "loginset4");
        } else {
            browser = framework.getWebBrowser("demosite_uat");
            environmentData = framework.getData(EnvironmentParameterData.class, "demosite_uat");
            testdata = framework.getData(AccountData.class, "loginset14");
        }
        baseUrl = environmentData.getBaseurl();
        //WebDriver browser = framework.getWebBrowser("Daily");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        HomePage homePage = new HomePage(browser);
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            ProductOffer productOffer = new ProductOffer(browser);
            ExtentTest childTest1 = parentTest1.createNode("Login In CRM", "This test verifies that user able to Login in CRM");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);
            ExtentTest childTest2 = parentTest1.createNode("Navigate to offer Page", "This test verifies that Offer Page is Working");
            TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl + "/admin/notification/addOfferPush");
            ExtentTest childTest3 = parentTest1.createNode("Create offer", "This test verifies that User is able to create offer");
            TestListner.extentMap.get().put("child3", childTest3);
            productOffer.Product_Offer_Create(childTest3);
        } catch (Exception e) {
            //	System.out.println(e);
            //	framework.logErrorWithSnapshot(browser,e);
        } finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Daily_Dairy1", "Regression", "Subscription_Offer"}, description = "Subsciption offer Create", priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying User is able to create offer")
    @Story("Story Name: To check Administration Page")
    public void Subsciption_offer_create() throws Throwable {
        AccountData testdata;
        //environmentData = framework.getData(EnvironmentParameterData.class, "Daily");
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")) {
            browser = framework.getWebBrowser("demosite");
            environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
            testdata = framework.getData(AccountData.class, "loginset4");
        } else {
            browser = framework.getWebBrowser("demosite_uat");
            environmentData = framework.getData(EnvironmentParameterData.class, "demosite_uat");
            testdata = framework.getData(AccountData.class, "loginset14");
        }
        baseUrl = environmentData.getBaseurl();
        //WebDriver browser = framework.getWebBrowser("Daily");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        HomePage homePage = new HomePage(browser);
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            browser.get(baseUrl);
            ProductOffer productOffer = new ProductOffer(browser);
            ExtentTest childTest1 = parentTest1.createNode("Login In CRM", "This test verifies that user able to Login in CRM");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);
            ExtentTest childTest2 = parentTest1.createNode("Navigate to offer Page", "This test verifies that Offer Page is Working");
            TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl + "/admin/notification/addOfferPush");
            ExtentTest childTest3 = parentTest1.createNode("Create offer", "This test verifies that User is able to create offer");
            TestListner.extentMap.get().put("child3", childTest3);
            productOffer.Subscription_Offer_Create(childTest3);
        } catch (Exception e) {
            //	System.out.println(e);
            //	framework.logErrorWithSnapshot(browser,e);
        } finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Interstitial_Offer","Regression"}, description = "Verifying Interstitial offer Test", priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying User is able to create Interstitial offer")
    @Story("Story Name: To check Administration Page")
    public void Create_Interstitial_Offer() throws Throwable{
        AccountData testdata;
        //environmentData = framework.getData(EnvironmentParameterData.class, "Daily");
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
            browser = framework.getWebBrowser("demosite");
            environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
            testdata= framework.getData(AccountData.class, "loginset4");
        }else {
            browser = framework.getWebBrowser("demosite_uat");
            environmentData = framework.getData(EnvironmentParameterData.class, "demosite_uat");
            testdata = framework.getData(AccountData.class, "loginset14");
        }
        baseUrl = environmentData.getBaseurl();
        //WebDriver browser = framework.getWebBrowser("Daily");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        HomePage homePage = new HomePage(browser);
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try{
            browser.get(baseUrl);
            String Sub_Reward = CommonConstant.InterstitialSubReward();
            String Action_Type = CommonConstant.InterstitialActionType();
            ProductOffer productOffer = new ProductOffer(browser);
            InterstitialOffers interstitialOffers = new InterstitialOffers(browser);
            ExtentTest childTest1 = parentTest1.createNode("Login In CRM", "This test verifies that user able to Login in CRM");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);
            ExtentTest childTest2 = parentTest1.createNode("Navigate to Interstitial offer Page", "This test verifies that Interstitial Offer Page is Working");
            TestListner.extentMap.get().put("child2", childTest2);
            //interstitialOffers.CreateInterstitialOffer(childTest2, "Free Delivery");
            //interstitialOffers.CreateInterstitialOffer(childTest2, "No Packaging Charges");
            //interstitialOffers.CreateInterstitialOffer(childTest2, "Amount Off");
            //interstitialOffers.CreateInterstitialOffer(childTest2, "Free SKU");
            interstitialOffers.CreateInterstitialOffer(childTest2, Sub_Reward, Action_Type);
            //interstitialOffers.CreateInterstitialOffer(childTest2, "Percentage Off","Recharge");
            ExtentTest childTest3 = parentTest1.createNode("Interstitial offer database changes", "This test verifies that Interstitial Offer database changes");
            TestListner.extentMap.get().put("child3", childTest3);
            interstitialOffers.DB_Update_CartOffer(childTest3);
        }catch (Exception e){
            // System.out.println(e);
            // framework.logErrorWithSnapshot(browser,e);
        }finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Membership_Offer","Regression"}, description = "Verifying Membership offer Test", priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying User is able to create Membership offer")
    @Story("Story Name: To check Administration Page")
    public void Create_Membership_Offer() throws Throwable{
        AccountData testdata;
        //environmentData = framework.getData(EnvironmentParameterData.class, "Daily");
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
            browser = framework.getWebBrowser("demosite");
            environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
            testdata= framework.getData(AccountData.class, "loginset4");
        }else {
            browser = framework.getWebBrowser("demosite_uat");
            environmentData = framework.getData(EnvironmentParameterData.class, "demosite_uat");
            testdata = framework.getData(AccountData.class, "loginset14");
        }
        baseUrl = environmentData.getBaseurl();
        //WebDriver browser = framework.getWebBrowser("Daily");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        HomePage homePage = new HomePage(browser);
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try{
            browser.get(baseUrl);
            String MembOffer_Type = CommonConstant.MembershipOfferType();
            MembershipOffer membershipOffer = new MembershipOffer(browser);
            ExtentTest childTest1 = parentTest1.createNode("Login In CRM", "This test verifies that user able to Login in CRM");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);
            ExtentTest childTest2 = parentTest1.createNode("Navigate to Membership offer Page", "This test verifies that Membership Offer Page is Working");
            TestListner.extentMap.get().put("child2", childTest2);
            membershipOffer.CreateMembershipOffer(childTest2, MembOffer_Type, "Yes","Yes");
            ExtentTest childTest3 = parentTest1.createNode("Membership offer database changes", "This test verifies that Membership Offer database changes");
            TestListner.extentMap.get().put("child3", childTest3);
            membershipOffer.DB_Update(childTest3);
        }catch (Exception e){
            // System.out.println(e);
            // framework.logErrorWithSnapshot(browser,e);
        }finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Regression", "Recharge_Offer_Cashback","Recharge_Offer","Recharge_Offer_Product"}, description = "Verifying Recharge offer Test", priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying User is able to create Recharge offer")
    @Story("Story Name: To check Administration Page")
    public void Create_Recharge_Offer() throws Throwable{
        AccountData testdata;
        //environmentData = framework.getData(EnvironmentParameterData.class, "Daily");
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
            browser = framework.getWebBrowser("demosite");
            environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
            testdata= framework.getData(AccountData.class, "loginset4");
        }else {
            browser = framework.getWebBrowser("demosite_uat");
            environmentData = framework.getData(EnvironmentParameterData.class, "demosite_uat");
            testdata = framework.getData(AccountData.class, "loginset14");
        }
        baseUrl = environmentData.getBaseurl();
        //WebDriver browser = framework.getWebBrowser("Daily");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        HomePage homePage = new HomePage(browser);
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try{
            browser.get(baseUrl);
            //String Rbenefits_Types = CommonConstant.RechargeBenefitsType();
            RechargeOffer rechargeOffer = new RechargeOffer(browser);
            ExtentTest childTest1 = parentTest1.createNode("Login In CRM", "This test verifies that user able to Login in CRM");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);
            ExtentTest childTest2 = parentTest1.createNode("Navigate to Recharge offer Page", "This test verifies that Recharge Offer Page is Working");
            TestListner.extentMap.get().put("child2", childTest2);
            rechargeOffer.CreateRechargeOffer(childTest2);
            rechargeOffer.DBchanges(childTest2);
            rechargeOffer.CreatRechargeProductOffer(childTest2);
            rechargeOffer.CreateMembershipRechargeOffer(childTest2);

        }catch (Exception e){
            // System.out.println(e);
            // framework.logErrorWithSnapshot(browser,e);
        }finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

    @JiraPolicy(logTicketReady = false)
    @Test(groups = {"Autopay_Offer","Regression"}, description = "Verifying Autopay Offer", priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case Description: Verifying User is able to create offer")
    @Story("Story Name: To check Administration Page")
    public void Create_Autopay_Offer() throws Throwable{
        AccountData testdata;
        //environmentData = framework.getData(EnvironmentParameterData.class, "Daily");
        WebDriver browser;
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
            browser = framework.getWebBrowser("demosite");
            environmentData = framework.getData(EnvironmentParameterData.class, "demosite");
            testdata= framework.getData(AccountData.class, "loginset4");
        }else {
            browser = framework.getWebBrowser("demosite_uat");
            environmentData = framework.getData(EnvironmentParameterData.class, "demosite_uat");
            testdata = framework.getData(AccountData.class, "loginset14");
        }
        baseUrl = environmentData.getBaseurl();
        //WebDriver browser = framework.getWebBrowser("Daily");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        HomePage homePage = new HomePage(browser);
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try{
            browser.get(baseUrl);
            AutopayOffer autopayOffer = new AutopayOffer(browser);
            ExtentTest childTest1 = parentTest1.createNode("Login In CRM", "This test verifies that user able to Login in CRM");
            TestListner.extentMap.get().put("child1", childTest1);
            homePage.HomePageData(childTest1, testdata);
            ExtentTest childTest2 = parentTest1.createNode("Navigate to Autopay offer Page", "This test verifies that Autopay Offer Page is Working");
            TestListner.extentMap.get().put("child2", childTest2);
            browser.get(baseUrl+"/admin/funds/autoPayConfigs");
            ExtentTest childTest3 = parentTest1.createNode("Create Autopay offer", "This test verifies that User is able to create Autopay offer");
            TestListner.extentMap.get().put("child3", childTest3);
            autopayOffer.CreateAutopayOffer(childTest3);
        }catch (Exception e){
            // System.out.println(e);
            // framework.logErrorWithSnapshot(browser,e);
        }finally {
            System.out.println("***********Release the device*************");
            browser.quit();
        }

    }

}








