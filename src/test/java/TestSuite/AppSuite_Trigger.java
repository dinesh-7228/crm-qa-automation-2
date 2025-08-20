package TestSuite;

import AppPages.CDApp.*;
import AppPages.CDPackagingApp.HomeScreen;
import AppPages.CDPartnerApp.*;
import AppPages.Others.PlayStore;
import Data.APIData;
import Data.AccountData;
import Data.EnvironmentParameterData;
import FrameWork.*;
import com.aventstack.extentreports.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.awaitility.Awaitility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class AppSuite_Trigger extends AppAction {
    String baseUrl = null;
    int count = 0;
    TestListner testListener = new TestListner();
    Framework framework = new Framework();
    EnvironmentParameterData environmentData = null;
    Map<String, String> keyValuePairMap = new HashMap<>();

    SoftAssert softassert = new SoftAssert();
    //Framework Mframework = new Framework();
    AdbDevice adb_device = new AdbDevice();
    TestListner MtestListener = new TestListner();
    AppiumDriver driver;
    public Connection con;

    // DB_Connection dbConnectionconect = new DB_Connection();
    public void preSetup() throws SQLException, ClassNotFoundException {
        environmentData = framework.getData(EnvironmentParameterData.class, "demosite2");
        //baseUrl = environmentData.getBaseurl();
        Awaitility.reset();
        Awaitility.setDefaultPollDelay(100, TimeUnit.MILLISECONDS);
        Awaitility.setDefaultPollInterval(3, TimeUnit.SECONDS);
        Awaitility.setDefaultTimeout(7, TimeUnit.SECONDS);
        // con = dbConnectionconect.dbConnection(CommonConstant.DBURL,CommonConstant.username,CommonConstant.Password);
    }

    @AfterMethod(alwaysRun = true)
    public void aftermethod() throws InterruptedException {
//        System.out.println("***********closing the driver*************");
//        adb_device.clearDeviceLock();
//        System.out.println("***********Release the device*************");
        Framework.extentReports.flush();
        // driver.quit();


    }

    @DataProvider(name = "Data Provide for Independent API", parallel = true)
    public Iterator<Object[]> dataListForSearch() {
        Framework framework = new Framework();
        List<Object[]> apiDataList = framework.getIndependentAPIdata(APIData.class, "TRUE");
        return apiDataList.listIterator();

    }



    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"ConsumerApp", "Sanity", "Regression","Trial_Membership"}, description = "verifying CD New User Flow")
    public void App_new_User_Login_FLow() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mHomePageData(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            mhomePage.mWalletVerificationWithPayment_Netbanking(childTest7,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Existing User FLow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"ConsumerApp","Regression"}, description = "verifying CD Existing User flow")
    public void App_existing_User_FLow() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset14");
            Framework framework = new Framework();
//            AssertData assertData = null;
//            CustomSoftAssert assertcheck = new CustomSoftAssert(assertData,  driver);
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationMemEdge(childTest2);


            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mhomePage.mHomePageDataExistinguser(childTest5);

            ExtentTest childTest7 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            mhomePage.mWalletVerificationWithPayment_Netbanking(childTest7, testdata);

            ExtentTest childTest8 = parentTest1.createNode("MHomePage Footer validation page ", "This test verifies that user is able to verify Footer section  Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            mhomePage.mfooterVerfication(childTest8, testdata);

            ExtentTest childTest9 = parentTest1.createNode("MproductPage validation page ", "This test verifies that user is able to verify Products  Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            mProductPage.navigateToL1CategoryList(childTest9);
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify User Payment Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"ConsumerApp",  "Regression"}, description = "verifying CD Payment  flow  element")
    public void App_Payment_Flow_Validation() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset1");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MPaymentScreen mPaymentScreen = new MPaymentScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            // childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            // childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidation(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            //childTest4.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            boolean IsHomememberVeried = mhomePage.trailMembershipVerification(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            // childTest1.setDescription("This test verifies that user is able validate payment flow Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IsHomeVeried = mhomePage.mHomePageDataExistinguser(childTest4);
            //   boolean IsPaymentFLow = mPaymentScreen.paymentScreenVerification(childTest3);

            ExtentTest childTest5 = parentTest1.createNode("RechargeScreen flow validation page ", "This test verifies that user is able validate RechargeScreen  flow Successfully");
            //childTest1.setDescription("This test verifies that user is able validate RechargeScreen  flow Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean IsRechargeScreenFLow =  mhomePage.mWalletVerificationWithPayment_Netbanking(childTest5, testdata);
            // boolean IsRechargeScreenFLow = mPaymentScreen.rechargeScreenVerification(childTest4);
            if(IsRechargeScreenFLow) {
                ExtentTest childTest6 = parentTest1.createNode("Payment flow validation page ", "This test verifies that user is able validate Recharge Success flow Successfully");
                //childTest1.setDescription("This test verifies that user is able validate Recharge Success flow Successfully");
                TestListner.extentMap.get().put("childTest6", childTest6);
                boolean IsRechargeSuccessFLow = mPaymentScreen.rechargeSuccessScreenVerification(childTest6);
            }


        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify The Dairy Product Verification | Subscription | Order Confirmation")
    @Story("Story Name: To check login page title")
    @Test(groups = {"ConsumerApp", "Sanity","Regression","Subscription"}, description = "verifying CD airy Product Verification | Subscription | Order Confirmation", priority = 1)
    public void App_Dairy_Product_Subscription_Verification() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset18");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MPaymentScreen mPaymentScreen = new MPaymentScreen(driver);
            MySubscription mSubscriptionAndOrder = new MySubscription(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);
            MOrderConfrimationScreen mOrderConfrimationScreen = new MOrderConfrimationScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidation(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            //childTest4.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            boolean IsHomememberVeried = mhomePage.trailMembershipVerification(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("Mini HomePage New page instadelivery validation ", "This test verifies that user is able to verify instadelivery  Successfully");
            //childTest8.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest3);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest5);

//            ExtentTest childTest9 = testListener.startChild("MHomePage New page instadelivery validation ");
//            childTest8.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
//            TestListner.extentMap.get().put("childTest9", childTest9);
//            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
//            boolean Isinstapage2= mhomePage.instaPagelaunch(childTest9);

            ExtentTest childTest6 = parentTest1.createNode("Dairy Product list validation page ", "This test verifies that user is able verify product list Successfully");
            //childTest1.setDescription("This test verifies that user is able verify product list Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsdairyProductlistverified = mProductPage.dairyProductListVerification(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("Dairy Product validation page ", "This test verifies that user is able verify product Successfully");
            // childTest6.setDescription("This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean IsdairyProductverified = mProductPage.dairyProductsSubscription(childTest7);

            ExtentTest childTest8 = parentTest1.createNode("Dairy Product Subscription page ", "This test verifies that user is able Subscribe Product Successfully");
            // childTest1.setDescription("This test verifies that user is able Subscribe Product Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsdairySubscriptionandOrder = mSubscriptionAndOrder.dairyProductOneTimeSubscription(childTest8);

//            ExtentTest childTest6 = testListener.startChild("Dairy Order Confirmation page ");
//            childTest6.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
//            TestListner.extentMap.get().put("childTest6", childTest6);
//            boolean IsdairyOrderreviewSuccessfully = mOrderReviewScreen.SingleorderReviewScreenVerification(childTest6);

           // ExtentTest childTest8 = parentTest1.createNode("Dairy Order Confirmation page ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest7.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
          //  TestListner.extentMap.get().put("childTest8", childTest8);
          //  boolean IsdairyOrderSuccessfully = mOrderConfrimationScreen.SubscriptionConfirmationScreenVerification(childTest8);

        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify The Dairy Product Verification | Subscription | Order Confirmation")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Order_flow", "Sanity", "Daily", "Daily_Dairy","Regression", "Product_Offer"}, description = "verifying CD airy Product Verification | Subscription | Order Confirmation", priority = 4)
    public void App_Dairy_Product_One_Time_Order_Verification_And_Product_Offer_check() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset11");
            if(System.getProperty("Mobile_Number")!=null){
                testdata.setMobile(System.getProperty("Mobile_Number"));
                testdata.setFirstName(System.getProperty("Product_Name"));
            }
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MPaymentScreen mPaymentScreen = new MPaymentScreen(driver);
            MySubscription mSubscriptionAndOrder = new MySubscription(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);
            MOrderConfrimationScreen mOrderConfrimationScreen = new MOrderConfrimationScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidation(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            //childTest4.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            boolean IsHomememberVeried = mhomePage.trailMembershipVerification(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Mini HomePage New page instadelivery validation ", "This test verifies that user is able to verify instadelivery  Successfully");
            // childTest8.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest4);

            ExtentTest childTest5 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest5, testdata);

            ExtentTest childTest6 = parentTest1.createNode("Dairy Product list validation page ", "This test verifies that user is able verify product list Successfully");
            //childTest1.setDescription("This test verifies that user is able verify product list Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            if(IswalletVeried) {
                mhomePage.instaPagelaunch(childTest6);
            }
            boolean IsdairyProductlistverified = mProductPage.dairyProductListVerification(childTest5);

            ExtentTest childTest7 = parentTest1.createNode("Dairy Product validation page ", "This test verifies that user is able verify product Successfully");
            // childTest1.setDescription("This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            mProductPage.DairyProductsVerificationwithSearch(childTest7, testdata);
            //boolean IsdairyProductverified = mProductPage.dairyProductsVerification(childTest6);

//            ExtentTest childTest5 = testListener.startChild("Dairy Product Subscription page ");
//            childTest1.setDescription("This test verifies that user is able Subscribe Product Successfully");
//            TestListner.extentMap.get().put("childTest5", childTest5);
//            boolean IsdairySubscriptionandOrder = mSubscriptionAndOrder.dairyProductOneTimeSubscription(childTest5);
            ExtentTest childTest8= parentTest1.createNode("Placing Order ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            //childTest5.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsproceedButtonClick = mProductPage.PlaceOrder_Button_Click(childTest8);

       /*     ExtentTest childTest8 = parentTest1.createNode("Dairy Order Confirmation Review page  ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest8.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsdairyOrderreviewSuccessfully = mOrderReviewScreen.orderReviewScreenVerification(childTest8);


        */
            //------Commenting this code because Now After Order redirection is set to Listing Page again.
           // ExtentTest childTest9 = parentTest1.createNode("Dairy Order Confirmation Verification page ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest9.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
           // TestListner.extentMap.get().put("childTest9", childTest9);
           // boolean IsdairyOrderSuccessfully = mOrderConfrimationScreen.OrderConfirmationScreenVerification(childTest9);

        } catch (Exception e) {
            e.printStackTrace();
            //   framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify The Dairy Product Verification | Subscription | Order Confirmation")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Order_flow", "Daily_Dairy_New","Product_Offer1"}, description = "verifying CD airy Product Verification | Subscription | Order Confirmation", priority = 16)
    public void App_Dairy_Product_One_Time_Order_Verification_and_Product_Offer_check_New_User() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset46");
            if(System.getProperty("Mobile_Number")!=null){
                testdata.setMobile(System.getProperty("Mobile_Number"));
                testdata.setFirstName(System.getProperty("Product_Name"));
            }
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MPaymentScreen mPaymentScreen = new MPaymentScreen(driver);
            MySubscription mSubscriptionAndOrder = new MySubscription(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);
            MOrderConfrimationScreen mOrderConfrimationScreen = new MOrderConfrimationScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidation(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            //   childTest3.setDescription("This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            boolean IsAddressVeried= mloginscreen.enterAddress(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            //childTest4.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IsHomememberVeried = mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            // childTest4.setDescription("This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean IsSkipVeried= mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage New page instadelivery validation ", "This test verifies that user is able to verify instadelivery  Successfully");
            // childTest8.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest7, testdata);

            ExtentTest childTest8 = parentTest1.createNode("Dairy Product list validation page ", "This test verifies that user is able verify product list Successfully");
            //childTest1.setDescription("This test verifies that user is able verify product list Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            if(IswalletVeried) {
                mhomePage.instaPagelaunch(childTest8);
            }
            boolean IsdairyProductlistverified = mProductPage.dairyProductListVerification(childTest7);

            ExtentTest childTest9 = parentTest1.createNode("Dairy Product validation page ", "This test verifies that user is able verify product Successfully");
            // childTest1.setDescription("This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            mProductPage.DairyProductsVerificationwithSearch(childTest9, testdata);
            //boolean IsdairyProductverified = mProductPage.dairyProductsVerification(childTest6);

//            ExtentTest childTest5 = testListener.startChild("Dairy Product Subscription page ");
//            childTest1.setDescription("This test verifies that user is able Subscribe Product Successfully");
//            TestListner.extentMap.get().put("childTest5", childTest5);
//            boolean IsdairySubscriptionandOrder = mSubscriptionAndOrder.dairyProductOneTimeSubscription(childTest5);
            ExtentTest childTest10= parentTest1.createNode("Placing Order ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            //childTest5.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
            boolean IsproceedButtonClick = mProductPage.PlaceOrder_Button_Click(childTest10);

       /*     ExtentTest childTest8 = parentTest1.createNode("Dairy Order Confirmation Review page  ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest8.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsdairyOrderreviewSuccessfully = mOrderReviewScreen.orderReviewScreenVerification(childTest8);


        */
            //------Commenting this code because Now After Order redirection is set to Listing Page again.
            // ExtentTest childTest9 = parentTest1.createNode("Dairy Order Confirmation Verification page ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest9.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            // TestListner.extentMap.get().put("childTest9", childTest9);
            // boolean IsdairyOrderSuccessfully = mOrderConfrimationScreen.OrderConfirmationScreenVerification(childTest9);

        } catch (Exception e) {
            e.printStackTrace();
            //   framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify The Dairy Product Verification | Subscription | Order Confirmation")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Order_flow","Daily","Daily_FNV","Regression","Subscription_Offer"}, description = "verifying CD airy Product Verification | Subscription | Order Confirmation", priority = 8)
    public void App_FNV_Product_One_Time_Order_Verification_Also_Subscription_offer_check() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset42");
            System.out.println("Mobile Number:-"+System.getProperty("Mobile_Number"));
            if(System.getProperty("Mobile_Number")!=null){
                System.out.println("Using User Provided Mobile Number");
                testdata.setMobile(System.getProperty("Mobile_Number"));
                testdata.setFirstName(System.getProperty("Product_Name"));
            }
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MPaymentScreen mPaymentScreen = new MPaymentScreen(driver);
            MySubscription mSubscriptionAndOrder = new MySubscription(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);
            MOrderConfrimationScreen mOrderConfrimationScreen = new MOrderConfrimationScreen(driver);
            Order_Update orderUpdate = new Order_Update(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            // childTest2.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidation(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("MHomePage New page instadelivery validation ", "This test verifies that user is able to verify instadelivery  Successfully");
            // childTest3.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest3);

            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            //childTest4.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IsHomememberVeried = mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            //childTest4.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest5, testdata);

            ExtentTest childTest6 = parentTest1.createNode("FNV Product list validation page ", "This test verifies that user is able verify product list Successfully");
            //childTest5.setDescription("This test verifies that user is able verify product list Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsdairyProductlistverified = mProductPage.dairyProductListVerification(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("Dairy Product validation page ", "This test verifies that user is able verify product Successfully");
            //childTest6.setDescription("This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean IsdairyProductverified = mProductPage.FNVProductsVerification_Increase(childTest7, testdata);

//            ExtentTest childTest5 = testListener.startChild("Dairy Product Subscription page ");
//            childTest1.setDescription("This test verifies that user is able Subscribe Product Successfully");
//            TestListner.extentMap.get().put("childTest5", childTest5);
//            boolean IsdairySubscriptionandOrder = mSubscriptionAndOrder.dairyProductOneTimeSubscription(childTest5);
            ExtentTest childTest8= parentTest1.createNode("MHomePage Rapid validation page ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsproceedButtonClick = mProductPage.Morning_Button_Click(childTest8);

            ExtentTest childTest9 = parentTest1.createNode("Dairy Order Confirmation page ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest8.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            boolean IsdairyOrderreviewSuccessfully = mOrderReviewScreen.orderReviewScreenVerification(childTest9);

      //      ExtentTest childTest9 = parentTest1.createNode("Dairy Order Confirmation page ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            // childTest9.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
      //      TestListner.extentMap.get().put("childTest9", childTest9);
      //      boolean IsdairyOrderSuccessfully = mOrderConfrimationScreen.OrderConfirmationScreenVerification(childTest9);

           //    ExtentTest childTest10 = parentTest1.createNode("Order Update page ", "This test verifies that user is able Verify Update the Product Qty ");
            // childTest10.setDescription("This test verifies that user is able Verify Update the Product Qty ");
           //     TestListner.extentMap.get().put("childTest10", childTest10);
           //       boolean IsOrderUpdated = orderUpdate.Qty_Update(childTest10);


        } catch (Exception e) {
            e.printStackTrace();
            //  framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify The Dairy Product Verification | Subscription | Order Confirmation")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Order_flow","Daily_Mix"}, description = "verifying CD airy Product Verification | Subscription | Order Confirmation", priority = 12)
    public void App_Mixed_Product_One_Time_Order_Verification() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset1");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MPaymentScreen mPaymentScreen = new MPaymentScreen(driver);
            MySubscription mSubscriptionAndOrder = new MySubscription(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);
            MOrderConfrimationScreen mOrderConfrimationScreen = new MOrderConfrimationScreen(driver);
            Order_Update orderUpdate = new Order_Update(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            // childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //childTest2.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidation(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("MHomePage New page instadelivery validation ", "This test verifies that user is able to verify instadelivery  Successfully");
            //childTest3.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest3);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            //childTest4.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("FNV Product list validation page ", "This test verifies that user is able verify product list Successfully");
            //childTest5.setDescription("This test verifies that user is able verify product list Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean IsdairyProductlistverified = mProductPage.dairyProductListVerification(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("FNV Product validation page ", "This test verifies that user is able verify product Successfully");
            //childTest6.setDescription("This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsdairyProductverified = mProductPage.FNVProductsVerification(childTest6, testdata);

//            ExtentTest childTest5 = testListener.startChild("Dairy Product Subscription page ");
//            childTest1.setDescription("This test verifies that user is able Subscribe Product Successfully");
//            TestListner.extentMap.get().put("childTest5", childTest5);
//            boolean IsdairySubscriptionandOrder = mSubscriptionAndOrder.dairyProductOneTimeSubscription(childTest5);
            ExtentTest childTest7= parentTest1.createNode("MHomePage Rapid validation page ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            //childTest7.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean IsproceedButtonClick = mProductPage.Morning_Button_Click(childTest7);

            ExtentTest childTest8 = parentTest1.createNode("Dairy Order Review page ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest8.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsdairyOrderreviewSuccessfully = mOrderReviewScreen.orderReviewScreenVerification(childTest8);

            ExtentTest childTest9 = parentTest1.createNode("Dairy Order Confirmation page ","This test verifies that user is able Verify Order Confirmation Page Successfully");
           // childTest9.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            boolean IsdairyOrderSuccessfully = mOrderConfrimationScreen.OrderConfirmationScreenVerification(childTest9);

            //Creating New Order From Calendar

            ExtentTest childTest10 = parentTest1.createNode("Order Update page from Calendar ","This test verifies that user is able add new product in Cart After Order confirm");
            //childTest10.setDescription("This test verifies that user is able add new product in Cart After Order confirm");
            TestListner.extentMap.get().put("childTest10", childTest10);
            boolean IsOrderUpdated = orderUpdate.Add_Product(childTest10);

            ExtentTest childTest11= parentTest1.createNode("MHomePage Rapid validation page ","This test verifies that user is able to verify Rapid HomePage Successfully");
            //childTest11.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest11", childTest11);
            boolean IsUpdateOrderButtonClick = mProductPage.Morning_Button_Click(childTest11);


            ExtentTest childTest12 = parentTest1.createNode("Dairy Order Review page ","This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest12.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest12", childTest12);
            boolean IsdairyOrderUpdatedSuccessfully = mOrderReviewScreen.orderReviewScreenVerification(childTest12);
/*
            ExtentTest childTest13 = parentTest1.createNode("Dairy Order Confirmation page ","This test verifies that user is able Verify Order Confirmation Page Successfully");
            // childTest13.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest13", childTest13);
            boolean IsMixedOrderSuccessfully = mOrderConfrimationScreen.OrderConfirmationScreenVerification(childTest13);


 */
        } catch (Exception e) {
            e.printStackTrace();
            //  framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    //Need to Update Empty cart after discuss with pradeep
    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify The Dairy Product Verification | Subscription | Order Confirmation")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Order_flow"}, description = "verifying CD airy Product Verification | Subscription | Order Confirmation", priority = 3)
    public void App_Empty_Cart_After_Order_Verification() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset21");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            Order_Update orderUpdate = new Order_Update(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);
            MOrderConfrimationScreen mOrderConfrimationScreen = new MOrderConfrimationScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            // childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            // childTest2.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidation(childTest2);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage wallet validation page ","This test verifies that user is able to verify wallet  Successfully");
            //childTest4.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest4, testdata);

            ExtentTest childTest3 = parentTest1.createNode("MHomePage New page instadelivery validation ","This test verifies that user is able to verify instadelivery  Successfully");
            // childTest3.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest3);


            ExtentTest childTest5 = parentTest1.createNode("Dairy Product list validation page ","This test verifies that user is able verify product list Successfully");
            //childTest5.setDescription("This test verifies that user is able verify product list Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean IsdairyProductlistverified = mProductPage.dairyProductListVerification(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Dairy Product validation page ","This test verifies that user is able verify product Successfully");
            //childTest6.setDescription("This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsdairyProductverified = mProductPage.dairyProductsVerification(childTest6);

//            ExtentTest childTest5 = testListener.startChild("Dairy Product Subscription page ");
//            childTest1.setDescription("This test verifies that user is able Subscribe Product Successfully");
//            TestListner.extentMap.get().put("childTest5", childTest5);
//            boolean IsdairySubscriptionandOrder = mSubscriptionAndOrder.dairyProductOneTimeSubscription(childTest5);
            ExtentTest childTest7= parentTest1.createNode("MHomePage Rapid validation page ","This test verifies that user is able to verify Rapid HomePage Successfully");
            //childTest7.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean IsproceedButtonClick = mProductPage.Morning_Button_Click(childTest7);

            ExtentTest childTest8 = parentTest1.createNode("Dairy Order Confirmation page ","This test verifies that user is able Verify Order Confirmation Page Successfully");
            // childTest8.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsdairyOrderreviewSuccessfully = mOrderReviewScreen.orderReviewScreenVerification(childTest8);

            ExtentTest childTest9 = parentTest1.createNode("Dairy Order Confirmation page ","This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest9.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            boolean IsdairyOrderSuccessfully = mOrderConfrimationScreen.OrderConfirmationScreenVerification(childTest9);

            ExtentTest childTest10 = parentTest1.createNode("Empty Cart","This test verifies that user is able Cancel the Created Order");
            //childTest10.setDescription("This test verifies that user is able Cancel the Created Order");
            TestListner.extentMap.get().put("childTest10", childTest10);
            boolean Empty_cart = orderUpdate.Empty_Cart(childTest10);
            orderUpdate.NextDayDeliveryMsg_Emptycart(childTest10);

        } catch (Exception e) {
            e.printStackTrace();
            //   framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify The Dairy  | Subscription Cancel Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "Order_Flow", "Sanity", "ConsumerApp","Regression","Subscription"}, description = "verifying CD Subscription Cancel Flow", priority = 3)
    public void App_Subscription_Cancel_Flow() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset18");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MPaymentScreen mPaymentScreen = new MPaymentScreen(driver);
            MySubscription mSubscriptionAndOrder = new MySubscription(driver);
            MOrderConfrimationScreen mOrderConfrimationScreen = new MOrderConfrimationScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            //  childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            //childTest4.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            boolean IsHomememberVeried = mhomePage.trailMembershipVerification(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Mini HomePage New page instadelivery validation ","This test verifies that user is able to verify instadelivery  Successfully");
            // childTest9.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest4);

            ExtentTest childTest5 = parentTest1.createNode("Dairy Product list validation page ","This test verifies that user is able verify product list Successfully");
            // childTest1.setDescription("This test verifies that user is able verify product list Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean IsdairyProductlistverified = mProductPage.dairyProductListVerification(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Dairy Product validation page ","This test verifies that user is able verify product Successfully");
            //childTest1.setDescription("This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsdairyProductverified = mProductPage.dairySubscribedProductCancelFlow(childTest6, testdata);

            ExtentTest childTest7 = parentTest1.createNode("Dairy Product Subscription page ","This test verifies that user is able Subscribe Product Successfully");
            //childTest1.setDescription("This test verifies that user is able Subscribe Product Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean IsdairySubscriptionandOrder = mSubscriptionAndOrder.dairyProductsCancelSubscription(childTest7);

            ExtentTest childTest8 = parentTest1.createNode("Dairy Product Subscriptioncancel Prompt Validation page ","This test verifies that user is able Subscribe Product Successfully");
            // childTest1.setDescription("This test verifies that user is able Subscribe Product Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsproductsCancelSubscriptionPrompt = mSubscriptionAndOrder.productsCancelSubscriptionPrompt(childTest8);

            ExtentTest childTest9 = parentTest1.createNode("Dairy Product Cancel Subscription page ", "This test verifies that user is able Subscribe Product Successfully");
            //childTest1.setDescription("This test verifies that user is able Subscribe Product Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            boolean IscancelSubscriptionScreen = mSubscriptionAndOrder.cancelSubscriptionScreen(childTest9);

            ExtentTest childTest10 = parentTest1.createNode("Dairy Order cancel Confirmation page ","This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest1.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
            boolean IsdairyOrderSuccessfully = mOrderConfrimationScreen.SubscriptionCancelScreenVerification(childTest10);

        } catch (Exception e) {
            e.printStackTrace();
            //  framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify MOre Screen")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "ConsumerApp","Sanity","Regression"}, description = "verifying  MOre Screen")
    public void App_More_Screen_Verification() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MoreScreen moreScreen = new MoreScreen(driver);


            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            // childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ","This test verifies that user is able to enter Address  Successfully");
            //childTest3.setDescription("This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);
          //  driver.navigate().back();


            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            //childTest4.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IsHomememberVeried = mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Drawer validation page ","This test verifies that user is able to Skip Refrell Address  Successfully");
            // childTest5.setDescription("This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean IsSkipVeried= mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ","This test verifies that user is able to verify HomePage Successfully");
            //childTest10.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsHomeVeried = mhomePage.instaPagelaunch(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("More Screen validation page ","This test verifies that user is able verify Membership Page Successfully");
            //childTest6.setDescription("This test verifies that user is able verify Membership Page Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean IsMorescreenverified = moreScreen.moreScreenValidation(childTest7);
//
            ExtentTest childTest8 = parentTest1.createNode("More Screen Redirection validation page ","This test verifies that user is able verify Membership Page Successfully");
            //childTest7.setDescription("This test verifies that user is able verify Membership Page Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsMoreLinksverified = moreScreen.moreScreenLinkRedirection(childTest8);

            ExtentTest childTest9 = parentTest1.createNode("Account and Preference validation  on More page ","This test verifies that user is able verify Account and Preference validation  Page Successfully");
            // childTest8.setDescription("This test verifies that user is able verify Account and Preference validation  Page Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            boolean Isaccountpreference = moreScreen.accountAndPreferneceValidation(childTest9, testdata);

            ExtentTest childTest10 = parentTest1.createNode("Wallet & Payment Modes validation  on More page ","This test verifies that user is able Wallet & Payment Modes validation  Page Successfully");
            // childTest9.setDescription("This test verifies that user is able Wallet & Payment Modes validation  Page Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);

            boolean IsWalletAccount = moreScreen.walletAndPaymentValidation(childTest10, testdata);
            moreScreen.rating(childTest10);

            ExtentTest childTest11 = parentTest1.createNode("Need Help? validation  on More page ","This test verifies that user is able Need Help? validation  Page Successfully");
            // childTest9.setDescription("This test verifies that user is able Wallet & Payment Modes validation  Page Successfully");
            TestListner.extentMap.get().put("childTest11", childTest11);
            boolean IsNeedHelp = moreScreen.NeedHelp(childTest11);

            ExtentTest childTest12 = parentTest1.createNode("Test Reports validation  on More page ","This test verifies that user is able Test reports validation  Page Successfully");
            TestListner.extentMap.get().put("childTest12", childTest12);
            boolean IsTestReports = moreScreen.TestReports(childTest12);

            ExtentTest childTest13 = parentTest1.createNode("Legal Page validation  on More page ","This test verifies that user is able Legal Page validation  Page Successfully");
            // childTest9.setDescription("This test verifies that user is able Wallet & Payment Modes validation  Page Successfully");
            TestListner.extentMap.get().put("childTest13", childTest13);
            boolean IsLegal = moreScreen.Legal(childTest13);


        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify VIPMembersip | With new User")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "VIP_Purchase_Coupon","VIP","Sanity", "ConsumerApp","Regression_Update"}, description = "verifying  VIP Membersip", priority = 28)
    public void App_Vip_Membership_Verification() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset3");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MyVipMembership myVipMembership = new MyVipMembership(driver);


            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            // childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            //childTest4.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            boolean IsHomememberVeried = mhomePage.trailMembershipVerification(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage wallet validation page ","This test verifies that user is able to verify wallet  Successfully");
            //childTest4.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("Mini HomePage New page instadelivery validation ","This test verifies that user is able to verify instadelivery  Successfully");
            //childTest9.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest5);
         //     myVipMembership.closeMembership(childTest3, testdata);

            ExtentTest childTest6 = parentTest1.createNode("Membership validation page ","This test verifies that user is able verify Membership Page Successfully");
            // childTest1.setDescription("This test verifies that user is able verify Membership Page Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean Ismembership = myVipMembership.newUserVipMembership(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("Membership Plans page ","This test verifies that user is able verify membership plans Successfully");
            // childTest1.setDescription("This test verifies that user is able verify membership plans Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean Ismembershipplan = myVipMembership.newUserVipMembershipPlanPage(childTest7);

            ExtentTest childTest8 = parentTest1.createNode("Membership coupon code page ","This test verifies that user is able verify membership coupon code plans Successfully");
            //childTest7.setDescription("This test verifies that user is able verify membership coupon code plans Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean Ismembershipcouonplan = myVipMembership.vipMemebershipPlanHavecouponcode(childTest8);

            ExtentTest childTest9 = parentTest1.createNode("Apply Membership page ","This test verifies that user is able buy membership  plans Successfully");
            //childTest8.setDescription("This test verifies that user is able buy membership  plans Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            boolean Ismembershipbuylan = myVipMembership.applyMembership(childTest9);

            ExtentTest childTest10 = parentTest1.createNode("Cancel Membership page ","This test verifies that user is able Cancel membership  plans Successfully");
            //childTest1.setDescription("This test verifies that user is able Cancel membership  plans Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
            boolean Ismembershipcancelplan = myVipMembership.closeMembership(childTest10, testdata);

        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify VIPMembersip | Edge Case Error Scenario")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "VIP", "ConsumerApp","Unlimited_VIP"}, description = "Since you have insufficient benefit amount, you may be charged on Regular price after delivery.", priority = 29)
    public void Unlimited_VIP() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MyVipMembership myVipMembership = new MyVipMembership(driver);
            Method method = new Method();

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            //TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);


            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification_Skip(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("MHomePage wallet validation page ","This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mWalletVerification_Recharge_Amount(childTest6,"800");
           // mhomePage.mHomePageData(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("Purchase Unlimited VIP ","This test verifies that user is able to Purchase Unlimited VIP");
            TestListner.extentMap.get().put("childTest7", childTest7);
            myVipMembership.Purchase_New_Unlimited_Membership(childTest7);

            for(int i=1; i<=16; i++){
                ExtentTest childTest8 = parentTest1.createNode("Update Unlimited VIP ","This test verifies that user is able to Update Unlimited VIP");
                TestListner.extentMap.get().put("childTest8", childTest8);
                myVipMembership.Update_Unlimited_Plan(childTest8, testdata);
                Thread.sleep(10000);
                System.out.println(i);
                method.MembershipAutoRenewCron(childTest8);
            }
            myVipMembership.Get_Membership_details(childTest7, testdata);

        } catch (Exception e) {
            e.printStackTrace();
            //  framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }


    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify VIPMembersip | Edge Case Error Scenario")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "VIP2","Regression_Update"}, description = "As your membership benefit is insufficient, the remaining amount will be deducted from the wallet..", priority = 30)
    public void App_Vip_Membership_EdgeCase2_Verification() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset5");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MyVipMembership myVipMembership = new MyVipMembership(driver);


            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidationMemEdge2(childTest2);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            //childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest4, testdata);

            ExtentTest childTest3 = parentTest1.createNode("MHomePage New page instadelivery validation ","This test verifies that user is able to verify instadelivery  Successfully");
            //childTest3.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest3);

////
            ExtentTest childTest5 = parentTest1.createNode("Cancel Membership page ","This test verifies that user is able Cancel membership  plans Successfully");
            //childTest5.setDescription("This test verifies that user is able Cancel membership  plans Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean Ismembershipcancelplan = myVipMembership.getMembershipDetails(childTest5, testdata);

        } catch (Exception e) {
            e.printStackTrace();
            //  framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }


    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify VIPMembersip | Edge Case Error Scenario")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "VIP3","ConsumerApp","Regression_Update"}, description = "Since you have insufficient benefit amount, you may be charged on Regular price after delivery.", priority = 31)
    public void App_Vip_Membership_EdgeCase3_Verification() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset5");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MyVipMembership myVipMembership = new MyVipMembership(driver);


            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            // childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidationMemEdge2(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("MHomePage New page instadelivery validation ","This test verifies that user is able to verify instadelivery  Successfully");
            //childTest9.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest3);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage wallet validation page ","This test verifies that user is able to verify wallet  Successfully");
            //childTest4.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = myVipMembership.edgecase2VipMembership(childTest4, testdata);
////
//            ExtentTest childTest8 = testListener.startChild("Cancel Membership page ");
//            childTest8.setDescription("This test verifies that user is able Cancel membership  plans Successfully");
//            TestListner.extentMap.get().put("childTest8", childTest8);
//            boolean Ismembershipcancelplan= myVipMembership.getMembershipDetails(childTest8);

        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }


    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Add Vacation|Edit Vacation|Delete Vacation Screen")
    @Story("Story Name: To check Vacation Functionality")
    @Test(groups = {"production","Sanity","ConsumerApp","Regression","Vacation"}, description = "verifying  Vacation Functionality")
    public void App_Vacation_Verification() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MoreScreen moreScreen = new MoreScreen(driver);


            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ","This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);

           // driver.navigate().back();


            ExtentTest childTest4 = parentTest1.createNode("Trial Membership Skip validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification_Skip(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Drawer validation page ","This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ","This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mHomePageData(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("Add Vacation validation page ","This test verifies that user is able to Start Vacation Page Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            moreScreen.addVacation(childTest7);

            ExtentTest childTest8 = parentTest1.createNode("Edit Vacation validation page ","This test verifies that user is able Edit Vacations Page Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            moreScreen.editVacation(childTest8);

          //  ExtentTest childTest9 = parentTest1.createNode("Remove Vacation validation page ","This test verifies that user is able End Vacations Page Successfully");
         //   TestListner.extentMap.get().put("childTest9", childTest9);
        //    moreScreen.deleteVacation(childTest9);
//


        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {""}, description = "verifying CD Delivery App login Flow", priority = 0)
    public void DBApp_Existing_User_Login_FLow() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset7");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite4");
            }

            DBLoginScreen dbloginscreen = new DBLoginScreen(driver);
            DBHomePage dbhomepage = new DBHomePage(driver);
            DrawerScreen drawerscreen = new DrawerScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("DB App login Screen page ","This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = dbloginscreen.DBLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            //childTest2.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = dbloginscreen.otpValidationExistngUser(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("DB App HomePage Header validation page ","This test verifies that user is able to verify header section  Successfully");
            // childTest3.setDescription("This test verifies that user is able to verify header section  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            boolean IsHeaderVeried = dbhomepage.mHeaderVerfication(childTest3, testdata);

            ExtentTest childTest4 = parentTest1.createNode("DB App drawer linked redirection","This test verifies that user is able to verify drawer linked redirection Successfully");
            // childTest4.setDescription("This test verifies that user is able to verify drawer linked redirection Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IsDrawerVerified = drawerscreen.drawerScreenLinkRedirection(childTest4);


        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }




    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Rapid","FNV", "Sanity","Regression"}, description = "verifying CD New User Flow", priority = 13)
    public void Order_FLow_FNV_Rapid() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset39");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);
            DB_Connection dbconnection = new DB_Connection();

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            // childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Cancel previous Orders");
            //childTest3.setDescription("This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            String CUSTOMER_ID;
            String mobile_number = testdata.getMobile();
            String GetCustomerId = CommonConstant.GetCustomerId_Dairy.replace("$mobilenumber", mobile_number);
            System.out.println(GetCustomerId);
            CUSTOMER_ID = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, GetCustomerId).get("ID");
            String CancelOrder_Id = CommonConstant.CancelRapidOrder.replace("$ID", CUSTOMER_ID);
            System.out.println(CancelOrder_Id);
            dbconnection.DBConnectionMemUpdate(CommonConstant.Rapid_DBURL, CommonConstant.Rapid_username, CommonConstant.Rapid_Password, CancelOrder_Id);
            dbconnection.CloseDB();

            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            //childTest4.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IsHomememberVeried = mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean IswalletVeried= mhomePage.mWalletVerificationWithPayment_Netbanking(childTest5,testdata);

//            ExtentTest childTest3 = testListener.startChild("Address validation page ");
//            childTest3.setDescription("This test verifies that user is able to enter Address  Successfully");
//            TestListner.extentMap.get().put("childTest3", childTest3);
//            boolean IsAddressVeried= mloginscreen.enterAddress(childTest3,testdata);

//            driver.navigate().back();
//            ExtentTest childTest4 = testListener.startChild("Skipbutotn validation page ");
//            childTest4.setDescription("This test verifies that user is able to Skip Refrell Address  Successfully");
//            TestListner.extentMap.get().put("childTest4", childTest4);
//            boolean IsSkipVeried= mloginscreen.skipButtonFunctional(childTest4);

            ExtentTest childTest6 = parentTest1.createNode("MHomePage Rapid validation page ","This test verifies that user is able to verify Rapid HomePage Successfully");
            //  childTest5.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsHomeVeried = mhomePage.mHomePageRapidSelection(childTest6);

            ExtentTest childTest7= parentTest1.createNode("Track Order Button Display","This test verifies that user is able to verify Track Order Button Display or Not");
            //childTest6.setDescription("This test verifies that user is able to verify Track Order Button Display or Not");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean trackorderbuttonvisble = mProductPage.TrackOrder_Visible(childTest7);

            ExtentTest childTest8 = parentTest1.createNode("MHomePage Rapid Product Add","This test verifies that user is able to verify Rapid HomePage Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            if(trackorderbuttonvisble){
                boolean IsrapidprodcutVeried = mProductPage.rapidProductList_Search_OT(childTest8, testdata);
            }else {
                boolean IsrapidprodcutVeried = mProductPage.rapidProductList_Search_OT(childTest7, testdata);
            }

            ExtentTest childTest9= parentTest1.createNode("MHomePage Rapid Placed Order ","This test verifies that user is able to verify Rapid HomePage Successfully");
            // childTest8.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            boolean IsproceedButtonClick = mProductPage.Proceed_Button_Click(childTest9);

            ExtentTest childTest10= parentTest1.createNode("MHomePage Rapid validation page ","This test verifies that user is able to verify Rapid HomePage Successfully");
            // childTest9.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
            boolean IsrapidorderreivweVeried = mOrderReviewScreen.rapidCartReview(childTest10);


        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production","Rapid","FNV","Regression"}, description = "verifying CD Packaging App Fully Packaging Flow", priority = 15)
    public void Packaging_App_FNV_Rapid() throws IOException, InterruptedException {
        Thread.sleep(30000);
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset12");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite6");
            }
            HomeScreen homescreen = new HomeScreen(driver);
            //HomeScreen homescreen = new HomeScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("Home Screen page  >> Fully Packaging Flow","This test verifies that user able to do fully packaging for FNV product");
            // childTest1.setDescription("This test verifies that user able to do fully packaging for FNV product");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean LoginPackaging = homescreen.LoginPackagingApp_New(childTest1, WebSuite_Trigger.Packer_MobileNo);
            Thread.sleep(20000);
            ExtentTest childTest2 = parentTest1.createNode("Home Screen page  >> Fully Packaging Flow","This test verifies that user able to do fully packaging for FNV product");
            //childTest2.setDescription("This test verifies that user able to do fully packaging for FNV product");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean FullyPackagingDataVerified = homescreen.FullyPackagingData(childTest2,testdata);


/*
            ExtentTest childTest4 = testListener.startChild("Home Screen page  >> Verifying Packaging data Flow");
            childTest4.setDescription("This test verifies that user able verify Packaging data ");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean PackagingDataVerified = homescreen.PackagingdataVerification(childTest4,testdata);
*/



        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = { "Rapid","Dairy","Regression"}, description = "verifying CD New User Flow", priority = 18)
    public void Order_FLow_Dairy_Rapid() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset10");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);
            DB_Connection dbconnection = new DB_Connection();

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            // childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            // childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Cancel previous Orders");
            //childTest3.setDescription("This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            String CUSTOMER_ID;
            String mobile_number = testdata.getMobile();
            String GetCustomerId = CommonConstant.GetCustomerId_Dairy.replace("$mobilenumber", mobile_number);
            System.out.println(GetCustomerId);
            CUSTOMER_ID = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, GetCustomerId).get("ID");
            String CancelOrder_Id = CommonConstant.CancelRapidOrder.replace("$ID", CUSTOMER_ID);
            System.out.println(CancelOrder_Id);
            dbconnection.DBConnectionMemUpdate(CommonConstant.Rapid_DBURL, CommonConstant.Rapid_username, CommonConstant.Rapid_Password, CancelOrder_Id);
            dbconnection.CloseDB();
//            driver.navigate().back();
//            ExtentTest childTest4 = testListener.startChild("Skipbutotn validation page ");
//            childTest4.setDescription("This test verifies that user is able to Skip Refrell Address  Successfully");
//            TestListner.extentMap.get().put("childTest4", childTest4);
//            boolean IsSkipVeried= mloginscreen.skipButtonFunctional(childTest4);
            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mhomePage.mWalletVerificationWithPayment_Netbanking(childTest5,testdata);

            ExtentTest childTest6 = parentTest1.createNode("MHomePage Rapid validation page ","This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mHomePageRapidSelection(childTest6);

            //Below Is Not required - Need to remove
            ExtentTest childTest7= parentTest1.createNode("Track Order Button Display","This test verifies that user is able to verify Track Order Button Display or Not");
            TestListner.extentMap.get().put("childTest7", childTest7);
            mProductPage.TrackOrder_Visible(childTest7);

            ExtentTest childTest8 = parentTest1.createNode("MHomePage Rapid Product Add from Search ","This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            mProductPage.rapidProductList_Search_OT(childTest8, testdata);

            ExtentTest childTest9= parentTest1.createNode("MHomePage Rapid Placing Order ","This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            mProductPage.Proceed_Button_Click(childTest9);

            ExtentTest childTest10= parentTest1.createNode("MHomePage Rapid Cart review ","This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
            mOrderReviewScreen.rapidCartReview(childTest10);


        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "Rapid", "Dairy","Regression"}, description = "verifying CD Packaging App Fully Packaging Flow", priority = 20)
    public void Packaging_App_Dairy_Rapid() throws IOException, InterruptedException {
        Thread.sleep(20000);
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset7");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite6");
            }
            HomeScreen homescreen = new HomeScreen(driver);
            //HomeScreen homescreen = new HomeScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("Home Screen page  >> Fully Packaging Flow","This test verifies that user able to do fully packaging for FNV product");
            //childTest1.setDescription("This test verifies that user able to do fully packaging for FNV product");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean LoginPackaging = homescreen.LoginPackagingApp_New(childTest1, WebSuite_Trigger.Packer_MobileNo);
            Thread.sleep(20000);
            //boolean LoginPackaging = homescreen.LoginPackagingApp_New(childTest1, "1309631700");
            ExtentTest childTest2 = parentTest1.createNode("Home Screen page  >> Fully Packaging Flow","This test verifies that user able to do fully packaging for FNV product");
            //childTest2.setDescription("This test verifies that user able to do fully packaging for FNV product");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean FullyPackagingDataVerified = homescreen.FullyPackagingData(childTest2,testdata);


/*
            ExtentTest childTest4 = testListener.startChild("Home Screen page  >> Verifying Packaging data Flow");
            childTest4.setDescription("This test verifies that user able verify Packaging data ");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean PackagingDataVerified = homescreen.PackagingdataVerification(childTest4,testdata);
*/



        } catch (Exception e) {
            e.printStackTrace();
            //  framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Rapid","Mix","Regression1"}, description = "verifying CD New User Flow", priority = 23)
    public void Order_FLow_Mix_Product() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset10");
            AccountData testdata1 = framework.getData(AccountData.class, "loginset9");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            // childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidationNew(childTest2);

//            ExtentTest childTest3 = testListener.startChild("Address validation page ");
//            childTest3.setDescription("This test verifies that user is able to enter Address  Successfully");
//            TestListner.extentMap.get().put("childTest3", childTest3);
//            boolean IsAddressVeried= mloginscreen.enterAddress(childTest3,testdata);

//            driver.navigate().back();
//            ExtentTest childTest4 = testListener.startChild("Skipbutotn validation page ");
//            childTest4.setDescription("This test verifies that user is able to Skip Refrell Address  Successfully");
//            TestListner.extentMap.get().put("childTest4", childTest4);
//            boolean IsSkipVeried= mloginscreen.skipButtonFunctional(childTest4);

            ExtentTest childTest5 = parentTest1.createNode("MHomePage Rapid validation page ","This test verifies that user is able to verify Rapid HomePage Successfully");
            //childTest5.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean IsHomeVeried = mhomePage.mHomePageRapidSelection(childTest5);

       /*     ExtentTest childTest6= parentTest1.createNode("Track Order Button Display","This test verifies that user is able to verify Track Order Button Display or Not");
            //childTest6.setDescription("This test verifies that user is able to verify Track Order Button Display or Not");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean trackorderbuttonvisble = mProductPage.TrackOrder_Visible(childTest6);
        */
            ExtentTest childTest7 = parentTest1.createNode("MHomePage Rapid validation page ","This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            mProductPage.rapidProductList_Search(childTest7, testdata);
            mProductPage.rapidProductList_Search(childTest7,testdata1);

       /*     ExtentTest childTest6= testListener.startChild("MHomePage Rapid validation page ");
            childTest6.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsrapidprodcutVeried = mProductPage.rapidProductList_Search(childTest6,testdata);

            ExtentTest childTest7= testListener.startChild("MHomePage Rapid validation page ");
            childTest7.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean IsrapidprodcutVeried_Dairy = mProductPage.rapidProductList_Category(childTest7,testdata);
*/
            ExtentTest childTest8= parentTest1.createNode("MHomePage Rapid validation page ","This test verifies that user is able to verify Rapid HomePage Successfully");
            // childTest8.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsproceedButtonClick = mProductPage.Proceed_Button_Click(childTest8);

            ExtentTest childTest9= parentTest1.createNode("MHomePage Rapid validation page ","This test verifies that user is able to verify Rapid HomePage Successfully");
            //childTest9.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            boolean IsrapidorderreivweVeried = mOrderReviewScreen.rapidCartReview(childTest9);


        } catch (Exception e) {
            e.printStackTrace();
            //  framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "DBApp01"}, description = "verifying CD Delivery App login Flow", priority = 17)
    public void Making_Delivery_FNV_Rapid() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset7");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite4");
            }
            DBLoginScreen dbloginscreen = new DBLoginScreen(driver);
            DBHomePage dbhomepage = new DBHomePage(driver);
            AssignedPage assignedpage = new AssignedPage(driver);
            PickedPage pickedpage = new PickedPage(driver);
            DonePage donepage = new DonePage(driver);
            ExtentTest childTest1 = parentTest1.createNode("DB App login Screen page ","This test verifies that user is able to verify login page content");
            // childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = dbloginscreen.DBLoginScreenData_New(childTest1, WebSuite_Trigger.Delivery_MobileNo);
            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            // childTest2.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = dbloginscreen.otpValidationExistngUser(childTest2);
            ExtentTest childTest3 = parentTest1.createNode("Home page ","This test verifies that user is able click the header links");
            // childTest3.setDescription("This test verifies that user is able click the header links");
            TestListner.extentMap.get().put("childTest3", childTest3);
            //   boolean IsHeaderLinkRedirection = dbhomepage.InstantHeaderVerfication(childTest3,testdata);
            ExtentTest childTest4 = parentTest1.createNode("Assigned page ","This test verifies that user is able to Assigned the Box");
            //childTest4.setDescription("This test verifies that user is able to Assigned the Box");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IsAssignedFlow = assignedpage.AssignedFlowData(childTest4,testdata);
            ExtentTest childTest5 = parentTest1.createNode("Picked page ","This test verifies that user is able to delivery the product");
            //childTest5.setDescription("This test verifies that user is able to delivery the product");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean IsPickedFlow = pickedpage.PickedFlowData(childTest5,testdata);
            ExtentTest childTest6 = parentTest1.createNode("Done page ","This test verifies that user is able to verify the data in Done filed");
            // childTest6.setDescription("This test verifies that user is able to verify the data in Done filed");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsDoneFlow = donepage.DoneFlowData(childTest6,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "Rapid","Mix","Regression1"}, description = "verifying CD Packaging App Fully Packaging Flow", priority = 25)
    public void Packaging_App_MIX() throws IOException, InterruptedException {
        Thread.sleep(60000);
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset12");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite6");
            }
            HomeScreen homescreen = new HomeScreen(driver);
            //HomeScreen homescreen = new HomeScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("Home Screen page  >> Fully Packaging Flow","This test verifies that user able to do fully packaging for FNV product");
            //childTest1.setDescription("This test verifies that user able to do fully packaging for FNV product");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean LoginPackaging = homescreen.LoginPackagingApp_New(childTest1, WebSuite_Trigger.Packer_MobileNo);

            ExtentTest childTest2 = parentTest1.createNode("Home Screen page  >> Fully Packaging Flow","This test verifies that user able to do fully packaging for FNV product");
            // childTest2.setDescription("This test verifies that user able to do fully packaging for FNV product");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean FullyPackagingDataVerified = homescreen.FullyPackagingData(childTest2,testdata);


/*
            ExtentTest childTest4 = testListener.startChild("Home Screen page  >> Verifying Packaging data Flow");
            childTest4.setDescription("This test verifies that user able verify Packaging data ");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean PackagingDataVerified = homescreen.PackagingdataVerification(childTest4,testdata);
*/



        } catch (Exception e) {
            e.printStackTrace();
            //  framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production"}, description = "verifying CD Delivery App login Flow", priority = 22)
    public void Making_Delivery_Dairy_Rapid() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset7");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite4");
            }
            DBLoginScreen dbloginscreen = new DBLoginScreen(driver);
            DBHomePage dbhomepage = new DBHomePage(driver);
            AssignedPage assignedpage = new AssignedPage(driver);
            PickedPage pickedpage = new PickedPage(driver);
            DonePage donepage = new DonePage(driver);
            ExtentTest childTest1 = parentTest1.createNode("DB App login Screen page ","This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = dbloginscreen.DBLoginScreenData_New(childTest1, WebSuite_Trigger.Delivery_MobileNo);
            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            //childTest2.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = dbloginscreen.otpValidationExistngUser(childTest2);
            ExtentTest childTest3 = parentTest1.createNode("Home page ","This test verifies that user is able click the header links");
            //childTest3.setDescription("This test verifies that user is able click the header links");
            TestListner.extentMap.get().put("childTest3", childTest3);
            //   boolean IsHeaderLinkRedirection = dbhomepage.InstantHeaderVerfication(childTest3,testdata);
            ExtentTest childTest4 = parentTest1.createNode("Assigned page ","This test verifies that user is able to Assigned the Box");
            // childTest4.setDescription("This test verifies that user is able to Assigned the Box");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IsAssignedFlow = assignedpage.AssignedFlowData(childTest4,testdata);
            ExtentTest childTest5 = parentTest1.createNode("Picked page ","This test verifies that user is able to delivery the product");
            //childTest5.setDescription("This test verifies that user is able to delivery the product");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean IsPickedFlow = pickedpage.PickedFlowData(childTest5,testdata);
            ExtentTest childTest6 = parentTest1.createNode("Done page ","This test verifies that user is able to verify the data in Done filed");
            //childTest6.setDescription("This test verifies that user is able to verify the data in Done filed");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsDoneFlow = donepage.DoneFlowData(childTest6,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "Rapid","Mix","Regression1"}, description = "verifying CD Delivery App login Flow", priority = 27)
    public void Making_Delivery_Mix() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset7");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite4");
            }
            DBLoginScreen dbloginscreen = new DBLoginScreen(driver);
            DBHomePage dbhomepage = new DBHomePage(driver);
            AssignedPage assignedpage = new AssignedPage(driver);
            PickedPage pickedpage = new PickedPage(driver);
            DonePage donepage = new DonePage(driver);
            ExtentTest childTest1 = parentTest1.createNode("DB App login Screen page ","This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = dbloginscreen.DBLoginScreenData_New(childTest1, WebSuite_Trigger.Delivery_MobileNo);
            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            // childTest2.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = dbloginscreen.otpValidationExistngUser(childTest2);
            ExtentTest childTest3 = parentTest1.createNode("Home page ","This test verifies that user is able click the header links");
            //childTest3.setDescription("This test verifies that user is able click the header links");
            TestListner.extentMap.get().put("childTest3", childTest3);
            //   boolean IsHeaderLinkRedirection = dbhomepage.InstantHeaderVerfication(childTest3,testdata);
            ExtentTest childTest4 = parentTest1.createNode("Assigned page ","This test verifies that user is able to Assigned the Box");
            //childTest4.setDescription("This test verifies that user is able to Assigned the Box");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IsAssignedFlow = assignedpage.AssignedFlowData(childTest4,testdata);
            ExtentTest childTest5 = parentTest1.createNode("Picked page ","This test verifies that user is able to delivery the product");
            //childTest5.setDescription("This test verifies that user is able to delivery the product");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean IsPickedFlow = pickedpage.PickedFlowData(childTest5,testdata);
            ExtentTest childTest6 = parentTest1.createNode("Done page ","This test verifies that user is able to verify the data in Done filed");
            // childTest6.setDescription("This test verifies that user is able to verify the data in Done filed");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsDoneFlow = donepage.DoneFlowData(childTest6,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "Daily_Dairy","Regression","Product_Offer"}, description = "verifying Order Sync", priority = 5)
    public void Order_Sync_Dairy_Product_offer() throws SQLException, ClassNotFoundException, IOException {
        AccountData testdata = framework.getData(AccountData.class, "loginset11");
        if(System.getProperty("Mobile_Number")!=null){
            System.out.println("Using User Provided Mobile Number");
            testdata.setMobile(System.getProperty("Mobile_Number"));
            testdata.setFirstName(System.getProperty("Product_Name"));
        }
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        DB_Connection dbconnection = new DB_Connection();
        Method method = new Method();
        ExtentTest childTest1 = parentTest1.createNode("Get Customer Id","This test verifies that to Get Customer Id");
        TestListner.extentMap.get().put("childTest1", childTest1);
        String CUSTOMER_ID;
        String mobile_number = testdata.getMobile();
        CommonConstant.GetCustomerId_Dairy = CommonConstant.GetCustomerId_Dairy.replace("$mobilenumber", mobile_number);
        System.out.println(CommonConstant.GetCustomerId_Dairy);
        CUSTOMER_ID = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetCustomerId_Dairy).get("ID");
        childTest1.log(Status.INFO,"Customer Id - "+CUSTOMER_ID);
        ExtentTest childTest2 = parentTest1.createNode("Generate Route Sheet","This test verifies that Route Sheet Generated Successfully");
        TestListner.extentMap.get().put("childTest2", childTest2);
        method.GenerateRouteSheet(CUSTOMER_ID, childTest2);
        ExtentTest childTest3 = parentTest1.createNode("Update Route Details Table","This test verifies that Update Creation Date and Updated Date");
        TestListner.extentMap.get().put("childTest3", childTest3);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
        String Update_Route_Sheet_Details = CommonConstant.UpdateRouteSheetDetails.replace("$Current_Date", timeStamp).replace("$ID",CUSTOMER_ID);
        System.out.println(Update_Route_Sheet_Details);
        String Routesheet_update = CommonConstant.GetRoutesheetID.replace("$CUSTOMER", CUSTOMER_ID);
        System.out.println(Routesheet_update);
        String Route_Sheet_id;
        Route_Sheet_id =  dbconnection.DesiredValueFromDB(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Routesheet_update, "ROUTE_SHEET").get("ROUTE_SHEET");
        System.out.println(Route_Sheet_id);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Update_Route_Sheet_Details);
        String Update_Sheet = CommonConstant.UpdateRouteSheet.replace("$Current_Date", timeStamp).replace("$ID",Route_Sheet_id);
        System.out.println(Update_Sheet);
        childTest3.log(Status.INFO,"Route Sheet Details - "+Update_Route_Sheet_Details);
        ExtentTest childTest4 = parentTest1.createNode("Update Route Sheet Table","This test verifies that Update Date and Delivery Boy");
        TestListner.extentMap.get().put("childTest4", childTest4);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Update_Sheet);
        childTest4.log(Status.INFO,"Route Sheet - "+Update_Sheet);
        String Order_Details = CommonConstant.OrderDetail.replace("$Current_Date", timeStamp).replace("$ID",CUSTOMER_ID);
        ExtentTest childTest5 = parentTest1.createNode("Update Order Details","This test verifies that Update Order Start Date and Order End Date");
        TestListner.extentMap.get().put("childTest5", childTest5);
        System.out.println(Order_Details);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Order_Details);
        childTest5.log(Status.INFO,"Order Details - "+Order_Details);
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production","Daily_FNV","Regression","Subscription_Offer"}, description = "verifying Order Sync", priority = 9)
    public void Order_Sync_FNV_and_Sub_offer() throws SQLException, ClassNotFoundException, IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        AccountData testdata = framework.getData(AccountData.class, "loginset42");
        if(System.getProperty("Mobile_Number")!=null){
            System.out.println("Using User Provided Mobile Number");
            testdata.setMobile(System.getProperty("Mobile_Number"));
            testdata.setFirstName(System.getProperty("Product_Name"));
        }
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        DB_Connection dbconnection = new DB_Connection();
        Method method = new Method();
        ExtentTest childTest1 = parentTest1.createNode("Get Customer Id","This test verifies that to Get Customer Id");
        // childTest1.setDescription("This test verifies that to Get Customer Id");
        TestListner.extentMap.get().put("childTest1", childTest1);
        String CUSTOMER_ID;
        String mobile_number = testdata.getMobile();
        CommonConstant.GetCustomerId_FNV = CommonConstant.GetCustomerId_FNV.replace("$mobilenumber", mobile_number);
        System.out.println(CommonConstant.GetCustomerId_FNV);
        CUSTOMER_ID = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetCustomerId_FNV).get("ID");
        childTest1.log(Status.INFO,"Customer Id - "+ CUSTOMER_ID);
       ExtentTest childTest2 = parentTest1.createNode("Generate Route Sheet","This test verifies that Route Sheet Generated Successfully");
        TestListner.extentMap.get().put("childTest2", childTest2);
        method.GenerateRouteSheet(CUSTOMER_ID, childTest2);
        ExtentTest childTest3 = parentTest1.createNode("Update Route Details Table","This test verifies that Update Creation Date and Updated Date");
        TestListner.extentMap.get().put("childTest3", childTest3);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
        String Update_Route_Sheet_Details = CommonConstant.UpdateRouteSheetDetails_FNV.replace("$Current_Date", timeStamp).replace("$ID",CUSTOMER_ID);
        System.out.println(Update_Route_Sheet_Details);
        String Routesheet_update = CommonConstant.GetRoutesheetID.replace("$CUSTOMER", CUSTOMER_ID);
        System.out.println(Routesheet_update);
        String Route_Sheet_id;
        Route_Sheet_id =  dbconnection.DesiredValueFromDB(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Routesheet_update, "ROUTE_SHEET").get("ROUTE_SHEET");
        System.out.println(Route_Sheet_id);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Update_Route_Sheet_Details);
        String Update_Sheet = CommonConstant.UpdateRouteSheet.replace("$Current_Date", timeStamp).replace("$ID",Route_Sheet_id);
        System.out.println(Update_Sheet);
        childTest3.log(Status.INFO,"Updated Route Sheet Details- "+Update_Route_Sheet_Details);
        ExtentTest childTest4 = parentTest1.createNode("Update Route Sheet Table","This test verifies that Update Date and Delivery Boy");
        TestListner.extentMap.get().put("childTest4", childTest4);
        childTest4.log(Status.INFO,"Updated Route Sheet - "+Update_Sheet);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Update_Sheet);
        String Order_Details = CommonConstant.OrderDetail.replace("$Current_Date", timeStamp).replace("$ID",CUSTOMER_ID);
        ExtentTest childTest5 = parentTest1.createNode("Update Order Details","This test verifies that Update Order Start Date and Order End Date");
       TestListner.extentMap.get().put("childTest5", childTest5);
        System.out.println(Order_Details);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Order_Details);
        childTest5.log(Status.INFO, "Updated Order Details - "+Order_Details);
    }


    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "Daily_Mix","Regression"}, description = "verifying Order Sync", priority = 13)
    public void Order_Sync_Mix() throws SQLException, ClassNotFoundException, IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        AccountData testdata = framework.getData(AccountData.class, "loginset1");
        if(System.getProperty("Mobile_Number")!=null){
            System.out.println("Using User Provided Mobile Number");
            testdata.setMobile(System.getProperty("Mobile_Number"));
            testdata.setFirstName(System.getProperty("Product_Name"));
        }
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        DB_Connection dbconnection = new DB_Connection();
        Method method = new Method();
        ExtentTest childTest1 = parentTest1.createNode("Get Customer Id","This test verifies that to Get Customer Id");
        // childTest1.setDescription("This test verifies that to Get Customer Id");
        TestListner.extentMap.get().put("childTest1", childTest1);
        String CUSTOMER_ID;
        String mobile_number = testdata.getMobile();
        CommonConstant.GetCustomerId_FNV = CommonConstant.GetCustomerId_FNV.replace("$mobilenumber", mobile_number);
        System.out.println(CommonConstant.GetCustomerId_FNV);
        CUSTOMER_ID = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetCustomerId_FNV).get("ID");
        childTest1.log(Status.INFO,"Customer Id - "+ CUSTOMER_ID);
        ExtentTest childTest2 = parentTest1.createNode("Generate Route Sheet","This test verifies that Route Sheet Generated Successfully");
        TestListner.extentMap.get().put("childTest2", childTest2);
        method.GenerateRouteSheet(CUSTOMER_ID, childTest2);
        ExtentTest childTest3 = parentTest1.createNode("Update Route Details Table","This test verifies that Update Creation Date and Updated Date");
        TestListner.extentMap.get().put("childTest3", childTest3);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
        String Update_Route_Sheet_Details = CommonConstant.UpdateRouteSheetDetails_FNV.replace("$Current_Date", timeStamp).replace("$ID",CUSTOMER_ID);
        System.out.println(Update_Route_Sheet_Details);
        String Routesheet_update = CommonConstant.GetRoutesheetID.replace("$CUSTOMER", CUSTOMER_ID);
        System.out.println(Routesheet_update);
        String Route_Sheet_id;
        Route_Sheet_id =  dbconnection.DesiredValueFromDB(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Routesheet_update, "ROUTE_SHEET").get("ROUTE_SHEET");
        System.out.println(Route_Sheet_id);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Update_Route_Sheet_Details);
        String Update_Sheet = CommonConstant.UpdateRouteSheet.replace("$Current_Date", timeStamp).replace("$ID",Route_Sheet_id);
        System.out.println(Update_Sheet);
        childTest3.log(Status.INFO,"Updated Route Sheet Details- "+Update_Route_Sheet_Details);
        ExtentTest childTest4 = parentTest1.createNode("Update Route Sheet Table","This test verifies that Update Date and Delivery Boy");
        TestListner.extentMap.get().put("childTest4", childTest4);
        childTest4.log(Status.INFO,"Updated Route Sheet - "+Update_Sheet);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Update_Sheet);
        String Order_Details = CommonConstant.OrderDetail.replace("$Current_Date", timeStamp).replace("$ID",CUSTOMER_ID);
        ExtentTest childTest5 = parentTest1.createNode("Update Order Details","This test verifies that Update Order Start Date and Order End Date");
        TestListner.extentMap.get().put("childTest5", childTest5);
        System.out.println(Order_Details);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Order_Details);
        childTest5.log(Status.INFO, "Updated Order Details - "+Order_Details);
    }


    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production" ,"Daily_Dairy_Old"}, description = "verifying Order Sync", priority = 7)
    public void Making_Delivery_Daily_Dairy() throws InterruptedException, IOException {
        Thread.sleep(30000);
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset6");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite4");
            }
            DBLoginScreen dbloginscreen = new DBLoginScreen(driver);
            DBHomePage dbhomepage = new DBHomePage(driver);
            ExtentTest childTest1 = parentTest1.createNode("DB App login Screen page ","This test verifies that user is able to verify login page content");
            // childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = dbloginscreen.DBLoginScreenData(childTest1, testdata);
            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            // childTest2.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = dbloginscreen.otpValidationExistngUser(childTest2);
            ExtentTest childTest3 = parentTest1.createNode("Uncheck Instant Delivery Option","This test verifies that Instant Delivery option is Unchecked");
            //childTest3.setDescription("This test verifies that Instant Delivery option is Unchecked");
            TestListner.extentMap.get().put("childTest3", childTest3);
            dbhomepage.DailyDeliverySelection(childTest3);
            ExtentTest childTest4 = parentTest1.createNode("Marking Delivery for Daily Products","This test verifies that Making Delivery for Dailry products of Daily Products");
            //childTest4.setDescription("This test verifies that Making Delivery for Dailry products of Daily Products");
            TestListner.extentMap.get().put("childTest4", childTest4);
            dbhomepage.Mark_Delivery_Daily(childTest4);
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "Daily_FNV_Old", "Daily_Mix_Old"}, description = "verifying Order Sync", priority = 12)
    public void Making_Delivery_Daily_FNV() throws InterruptedException, IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset6");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite4");
            }
            DBLoginScreen dbloginscreen = new DBLoginScreen(driver);
            DBHomePage dbhomepage = new DBHomePage(driver);
            ExtentTest childTest1 = parentTest1.createNode("DB App login Screen page ","This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = dbloginscreen.DBLoginScreenData(childTest1, testdata);
            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            //childTest2.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = dbloginscreen.otpValidationExistngUser(childTest2);
            ExtentTest childTest3 = parentTest1.createNode("Uncheck Instant Delivery Option","This test verifies that Instant Delivery option is Unchecked");
            // childTest3.setDescription("This test verifies that Instant Delivery option is Unchecked");
            TestListner.extentMap.get().put("childTest3", childTest3);
            dbhomepage.DailyDeliverySelection(childTest3);
            ExtentTest childTest4 = parentTest1.createNode("Marking Delivery for FNV Products","This test verifies that Making Delivery for Dailry products of FNV Products");
            //childTest4.setDescription("This test verifies that Making Delivery for Dailry products of FNV Products");
            TestListner.extentMap.get().put("childTest4", childTest4);
            dbhomepage.Mark_Delivery_FNV(childTest4);
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
            //  framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify The Dairy Product Verification | Subscription | Order Confirmation")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Order_flow", "Sanity","Daily_Dairy_R","Regression","production"}, description = "verifying CD airy Product Verification | Subscription | Order Confirmation", priority = 0)
    public void App_Dairy_Product_One_Time_Order_from_Calendar() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset10");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MPaymentScreen mPaymentScreen = new MPaymentScreen(driver);
            Order_Update orderUpdate = new Order_Update(driver);
            MySubscription mSubscriptionAndOrder = new MySubscription(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);
            MOrderConfrimationScreen mOrderConfrimationScreen = new MOrderConfrimationScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("Cancel Subscription", "This test verifies that user is able Cancel Subscription from DB");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mSubscriptionAndOrder.CancelSubscipriotnfromDB(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.mLoginScreenData(childTest2, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.otpValidation(childTest3);

            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("MHomePage New page instadelivery validation ", "This test verifies that user is able to verify Daily delivery  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mhomePage.instaPagelaunch(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mWalletVerificationWithPayment_Netbanking(childTest6, testdata);

            ExtentTest childTest7 = parentTest1.createNode("Dairy Product list validation page ", "This test verifies that user is able verify product list Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            mhomePage.productaddfromcalendar(childTest7);

            ExtentTest childTest8 = parentTest1.createNode("Dairy Product validation page ", "This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            mProductPage.DairyProductsVerificationwithSearch(childTest8, testdata);
            //boolean IsdairyProductverified = mProductPage.dairyProductsVerification(childTest6);

//            ExtentTest childTest5 = testListener.startChild("Dairy Product Subscription page ");
//            childTest1.setDescription("This test verifies that user is able Subscribe Product Successfully");
//            TestListner.extentMap.get().put("childTest5", childTest5);
//            boolean IsdairySubscriptionandOrder = mSubscriptionAndOrder.dairyProductOneTimeSubscription(childTest5);
            ExtentTest childTest9= parentTest1.createNode("MHomePage Rapid validation page ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            mProductPage.PlaceOrder_Button_Click(childTest9);
/*
            ExtentTest childTest9 = parentTest1.createNode("Dairy Order Confirmation Review page  ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest8.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            boolean IsdairyOrderreviewSuccessfully = mOrderReviewScreen.orderReviewScreenVerification(childTest9);


 */
         /*   ExtentTest childTest9 = parentTest1.createNode("Dairy Order Confirmation Verification page ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest9.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            boolean IsdairyOrderSuccessfully = mOrderConfrimationScreen.OrderConfirmationScreenVerification(childTest9);

            ExtentTest childTest10 = parentTest1.createNode("Order Close Verification page ", "This test verifies that user is able Verify Close Order from Confirmation Page Successfully");
            //childTest9.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
            boolean OrderMessage = orderUpdate.NextDayDeliveryMsg(childTest10);
          */
        } catch (Exception e) {
            e.printStackTrace();
            //   framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }
    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify The Dairy Product Verification | Subscription | Order Confirmation")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Order_flow", "Sanity","Daily_FNV_R","Regression","production"}, description = "verifying CD airy Product Verification | Subscription | Order Confirmation", priority = 0)
    public void App_FNV_Product_One_Time_Order_from_Calendar() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset13");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidation(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mhomePage.trailMembershipVerification(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Mini HomePage New page instadelivery validation ", "This test verifies that user is able to verify Daily delivery  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.instaPagelaunch(childTest4);

            ExtentTest childTest5 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mhomePage.mWalletVerificationWithPayment_Netbanking(childTest5, testdata);

            ExtentTest childTest6 = parentTest1.createNode("FNV Product list validation page ", "This test verifies that user is able verify product list Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.productaddfromcalendar(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("FNV Product validation page ", "This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            mProductPage.DairyProductsVerificationwithSearch(childTest7, testdata);

            ExtentTest childTest8= parentTest1.createNode("MHomePage Rapid validation page ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            mProductPage.PlaceOrder_Button_Click(childTest8);

          //  ExtentTest childTest9 = parentTest1.createNode("FNV Order Confirmation Review page  ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest8.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
          //  TestListner.extentMap.get().put("childTest9", childTest9);
          //  boolean IsdairyOrderreviewSuccessfully = mOrderReviewScreen.orderReviewScreenVerification(childTest9);

         /*   ExtentTest childTest9 = parentTest1.createNode("FNV Order Confirmation Verification page ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest9.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            boolean IsdairyOrderSuccessfully = mOrderConfrimationScreen.OrderConfirmationScreenVerification(childTest9);

            ExtentTest childTest10 = parentTest1.createNode("Order Close Verification page ", "This test verifies that user is able Verify Close Order from Confirmation Page Successfully");
            //childTest9.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
            boolean OrderMessage = orderUpdate.NextDayDeliveryMsg(childTest10);


          */
        } catch (Exception e) {
            e.printStackTrace();
            //   framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify The Dairy Product Verification | Subscription | Order Confirmation")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Sanity", "Regression","production","Subscription"}, description = "verifying CD airy Product Verification | Subscription | Order Confirmation", priority = 2)
    public void App_Dairy_Product_Subscription_Verification_Alternate() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset18");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MPaymentScreen mPaymentScreen = new MPaymentScreen(driver);
            MySubscription mSubscriptionAndOrder = new MySubscription(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);
            MOrderConfrimationScreen mOrderConfrimationScreen = new MOrderConfrimationScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidation(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            //childTest4.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            boolean IsHomememberVeried = mhomePage.trailMembershipVerification(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage New page instadelivery validation ", "This test verifies that user is able to verify instadelivery  Successfully");
            //childTest8.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest4);

            ExtentTest childTest5 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest5, testdata);

            ExtentTest childTest6 = parentTest1.createNode("Dairy Product list validation page ", "This test verifies that user is able verify product list Successfully");
            //childTest1.setDescription("This test verifies that user is able verify product list Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsdairyProductlistverified = mProductPage.dairyProductListVerification(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("Dairy Product validation page ", "This test verifies that user is able verify product Successfully");
            // childTest6.setDescription("This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean IsdairyProductverified = mProductPage.dairyProductsSubscription(childTest7);

            ExtentTest childTest8 = parentTest1.createNode("Dairy Product Subscription page ", "This test verifies that user is able Subscribe Product Successfully");
            // childTest1.setDescription("This test verifies that user is able Subscribe Product Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsdairySubscriptionandOrder = mSubscriptionAndOrder.dairyProductOneTimeSubscription_Type(childTest8, "Alternate");

//            ExtentTest childTest6 = testListener.startChild("Dairy Order Confirmation page ");
//            childTest6.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
//            TestListner.extentMap.get().put("childTest6", childTest6);
//            boolean IsdairyOrderreviewSuccessfully = mOrderReviewScreen.SingleorderReviewScreenVerification(childTest6);
/*
            ExtentTest childTest8 = parentTest1.createNode("Dairy Order Confirmation page ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest7.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsdairyOrderSuccessfully = mOrderConfrimationScreen.SubscriptionConfirmationScreenVerification(childTest8);


 */
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify The Dairy Product Verification | Subscription | Order Confirmation")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Sanity", "Regression", "production","Subscription"}, description = "verifying CD airy Product Verification | Subscription | Order Confirmation", priority = 2)
    public void App_Dairy_Product_Subscription_Verification_Weekly() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset18");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MPaymentScreen mPaymentScreen = new MPaymentScreen(driver);
            MySubscription mSubscriptionAndOrder = new MySubscription(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);
            MOrderConfrimationScreen mOrderConfrimationScreen = new MOrderConfrimationScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidation(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("MHomePage New page instadelivery validation ", "This test verifies that user is able to verify instadelivery  Successfully");
            //childTest8.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest3);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest4, testdata);

//            ExtentTest childTest9 = testListener.startChild("MHomePage New page instadelivery validation ");
//            childTest8.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
//            TestListner.extentMap.get().put("childTest9", childTest9);
//            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
//            boolean Isinstapage2= mhomePage.instaPagelaunch(childTest9);

            ExtentTest childTest5 = parentTest1.createNode("Dairy Product list validation page ", "This test verifies that user is able verify product list Successfully");
            //childTest1.setDescription("This test verifies that user is able verify product list Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean IsdairyProductlistverified = mProductPage.dairyProductListVerification(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Dairy Product validation page ", "This test verifies that user is able verify product Successfully");
            // childTest6.setDescription("This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsdairyProductverified = mProductPage.dairyProductsSubscription(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("Dairy Product Subscription page ", "This test verifies that user is able Subscribe Product Successfully");
            // childTest1.setDescription("This test verifies that user is able Subscribe Product Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean IsdairySubscriptionandOrder = mSubscriptionAndOrder.dairyProductOneTimeSubscription_Type(childTest7, "Weekly");

//            ExtentTest childTest6 = testListener.startChild("Dairy Order Confirmation page ");
//            childTest6.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
//            TestListner.extentMap.get().put("childTest6", childTest6);
//            boolean IsdairyOrderreviewSuccessfully = mOrderReviewScreen.SingleorderReviewScreenVerification(childTest6);
/*
            ExtentTest childTest8 = parentTest1.createNode("Dairy Order Confirmation page ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest7.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsdairyOrderSuccessfully = mOrderConfrimationScreen.SubscriptionConfirmationScreenVerification(childTest8);


 */
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify The Dairy Product Verification | Subscription | Order Confirmation")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Sanity", "Regression", "production", "Subscription"}, description = "verifying CD airy Product Verification | Subscription | Order Confirmation", priority = 2)
    public void App_Dairy_Product_Subscription_Verification_Daily() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset18");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MPaymentScreen mPaymentScreen = new MPaymentScreen(driver);
            MySubscription mSubscriptionAndOrder = new MySubscription(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);
            MOrderConfrimationScreen mOrderConfrimationScreen = new MOrderConfrimationScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidation(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("MHomePage New page instadelivery validation ", "This test verifies that user is able to verify instadelivery  Successfully");
            //childTest8.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest3);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest4, testdata);

//            ExtentTest childTest9 = testListener.startChild("MHomePage New page instadelivery validation ");
//            childTest8.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
//            TestListner.extentMap.get().put("childTest9", childTest9);
//            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
//            boolean Isinstapage2= mhomePage.instaPagelaunch(childTest9);

            ExtentTest childTest5 = parentTest1.createNode("Dairy Product list validation page ", "This test verifies that user is able verify product list Successfully");
            //childTest1.setDescription("This test verifies that user is able verify product list Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean IsdairyProductlistverified = mProductPage.dairyProductListVerification(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Dairy Product validation page ", "This test verifies that user is able verify product Successfully");
            // childTest6.setDescription("This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsdairyProductverified = mProductPage.dairyProductsSubscription(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("Dairy Product Subscription page ", "This test verifies that user is able Subscribe Product Successfully");
            // childTest1.setDescription("This test verifies that user is able Subscribe Product Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean IsdairySubscriptionandOrder = mSubscriptionAndOrder.dairyProductOneTimeSubscription_Type(childTest7, "Daily");

//            ExtentTest childTest6 = testListener.startChild("Dairy Order Confirmation page ");
//            childTest6.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
//            TestListner.extentMap.get().put("childTest6", childTest6);
//            boolean IsdairyOrderreviewSuccessfully = mOrderReviewScreen.SingleorderReviewScreenVerification(childTest6);
/*
            ExtentTest childTest8 = parentTest1.createNode("Dairy Order Confirmation page ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest7.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsdairyOrderSuccessfully = mOrderConfrimationScreen.SubscriptionConfirmationScreenVerification(childTest8);


 */
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }


    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify VIPMembersip | Edge Case Error Scenario")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "VIP", "Regression", "Auto_Renew_On_Warning"}, description = "Since you have insufficient benefit amount, you may be charged on Regular price after delivery.", priority = 28)
    public void App_Vip_Membership_Interstitical_Auto_Renew() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset37");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MyVipMembership myVipMembership = new MyVipMembership(driver);
            MOrderConfrimationScreen mOrderConfrimationScreen = new MOrderConfrimationScreen(driver);
            Method method = new Method();

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Skip Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mhomePage.trailMembershipVerification_Skip(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest7", childTest4);
            boolean IswalletVeried= mhomePage.mWalletVerificationWithPayment_Netbanking(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Daily Delivery Page validation ","This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mhomePage.instaPagelaunch(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Membership Check","This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean Ismembershipcancelplan = myVipMembership.getMembershipDetails(childTest6, testdata);

            if(Ismembershipcancelplan) {
                ExtentTest childTest7 = parentTest1.createNode("Cancel Membership page ", "This test verifies that user is able Cancel membership  plans Successfully");
                TestListner.extentMap.get().put("childTest7", childTest7);
            }else {
                ExtentTest childTest7 = parentTest1.createNode("Membership validation page ","This test verifies that user is able verify Membership Page Successfully");
                TestListner.extentMap.get().put("childTest7", childTest7);
                myVipMembership.newUserVipMembership(childTest7);

                ExtentTest childTest8 = parentTest1.createNode("Purchase Membership", "This test verifies that user is able Purchase membership  plans Successfully");
                TestListner.extentMap.get().put("childTest8", childTest8);
                myVipMembership.applyMembership(childTest8);
                driver.navigate().back();
            }
            ExtentTest childTest9 = parentTest1.createNode("FNV Product validation page ", "This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            mProductPage.DairyProductsVerificationwithSearch_DecreaseQty(childTest9, testdata);

            ExtentTest childTest10 = parentTest1.createNode("Set VIP Benifit and Wallet Balance", "This test verifies that user is able Update VIP Bonus and Wallet Balance");
            TestListner.extentMap.get().put("childTest10", childTest10);
            myVipMembership.UpdateBalance_AutoRenewON(childTest10, testdata);

            ExtentTest childTest11= parentTest1.createNode("Review Cart ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest11", childTest11);
            mProductPage.PlaceOrder_Button_Click(childTest11);

            ExtentTest childTest12= parentTest1.createNode("Interstitial Warning?", "This test verifies that user is able to verify Interstitial cases");
            TestListner.extentMap.get().put("childTest12", childTest12);
            myVipMembership.Interstitual_Case_With_Renew(childTest12);
            mhomePage.mWalletVerification_Recharge_with_default_Amount(childTest12);

            ExtentTest childTest13= parentTest1.createNode("Sale Marking", "This test verifies that VIP case with sale Marking");
            TestListner.extentMap.get().put("childTest13", childTest13);
            String db_id = Order_Sync_Regular_Order_API(testdata);
            method.SaleMarking_Regular(childTest13, db_id);
        } catch (Exception e) {
            e.printStackTrace();
            //  framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify VIPMembersip | Edge Case Error Scenario")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "VIP", "Regression","Auto_Renew_On_Warning"}, description = "Product QTy should One of Danedar Ghee", priority = 28)
    public void App_Vip_Membership_Interstitical_without_Auto_Renew() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset37");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MyVipMembership myVipMembership = new MyVipMembership(driver);
            Method method = new Method();

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Skip Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mhomePage.trailMembershipVerification_Skip(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Daily Delivery Page validation ","This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IswalletVeried= mhomePage.mWalletVerificationWithPayment_Netbanking(childTest4,testdata);
            mhomePage.instaPagelaunch(childTest4);

            ExtentTest childTest5 = parentTest1.createNode("Membership Check","This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean Ismembershipcancelplan = myVipMembership.getMembershipDetails(childTest5, testdata);

            if(Ismembershipcancelplan) {
                ExtentTest childTest6 = parentTest1.createNode("Cancel Membership page ", "This test verifies that user is able Cancel membership  plans Successfully");
                TestListner.extentMap.get().put("childTest6", childTest6);
             }else {
                ExtentTest childTest6 = parentTest1.createNode("Membership validation page ","This test verifies that user is able verify Membership Page Successfully");
                TestListner.extentMap.get().put("childTest6", childTest6);
                myVipMembership.newUserVipMembership(childTest6);

                ExtentTest childTest7 = parentTest1.createNode("Purchase Membership", "This test verifies that user is able Purchase membership  plans Successfully");
                TestListner.extentMap.get().put("childTest7", childTest7);
                myVipMembership.applyMembership(childTest7);
                driver.navigate().back();
            }
            ExtentTest childTest8 = parentTest1.createNode("FNV Product validation page ", "This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            mProductPage.DairyProductsVerificationwithSearch_DecreaseQty(childTest8, testdata);

            ExtentTest childTest9 = parentTest1.createNode("Set VIP Benifit and Wallet Balance", "This test verifies that user is able Update VIP Bonus and Wallet Balance");
            TestListner.extentMap.get().put("childTest9", childTest9);
             myVipMembership.UpdateBalance_AutoRenewON(childTest9, testdata);

            ExtentTest childTest10= parentTest1.createNode("Review Cart ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
            mProductPage.PlaceOrder_Button_Click(childTest10);

            ExtentTest childTest11= parentTest1.createNode("Interstitial Warning", "This test verifies that user is able to verify Interstitial cases");
            TestListner.extentMap.get().put("childTest11", childTest11);
            myVipMembership.Interstitual_Case_Without_Renew(childTest11);

            ExtentTest childTest12= parentTest1.createNode("Sale Marking", "This test verifies that VIP case with sale Marking");
            TestListner.extentMap.get().put("childTest12", childTest12);
            String db_id = Order_Sync_Regular_Order_API(testdata);
            method.SaleMarking_Regular(childTest12, db_id);


        } catch (Exception e) {
            e.printStackTrace();
            //  framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify VIPMembersip | Edge Case Error Scenario")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "VIP", "Regression","VIP_Interstitial"}, description = "Product QTy should One of Danedar Ghee", priority = 28)
    public void App_Interstitical_without_AutoRenew_off_HigherPrice() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset38");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MyVipMembership myVipMembership = new MyVipMembership(driver);
            Method method = new Method();

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            //TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mhomePage.trailMembershipVerification(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.mWalletVerificationWithPayment_Netbanking(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("Daily Delivery Page validation ","This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mhomePage.instaPagelaunch(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Membership Check","This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean Ismembershipcancelplan = myVipMembership.getMembershipDetails(childTest6, testdata);
////
            if(Ismembershipcancelplan) {
                ExtentTest childTest7 = parentTest1.createNode("Cancel Membership page ", "This test verifies that user is able Cancel membership  plans Successfully");
                //childTest8.setDescription("This test verifies that user is able Cancel membership  plans Successfully");
                TestListner.extentMap.get().put("childTest7", childTest7);
                childTest7.log(Status.PASS,"User Already has Membership");
            }else {
                ExtentTest childTest7 = parentTest1.createNode("Membership validation page ","This test verifies that user is able verify Membership Page Successfully");
               TestListner.extentMap.get().put("childTest7", childTest7);
                boolean Ismembership = myVipMembership.newUserVipMembership(childTest7);

                ExtentTest childTest8 = parentTest1.createNode("Purchase Membership", "This test verifies that user is able Purchase membership  plans Successfully");
                TestListner.extentMap.get().put("childTest8", childTest8);
                myVipMembership.applyMembership(childTest8);
                Thread.sleep(3000);
                driver.navigate().back();
            }

            ExtentTest childTest9 = parentTest1.createNode("Set VIP Bonus and Wallet Balance", "This test verifies that user is able Update VIP Bonus and Wallet Balance");
            TestListner.extentMap.get().put("childTest9", childTest9);
            myVipMembership.UpdateBalance(childTest9, testdata);

            ExtentTest childTest10 = parentTest1.createNode("FNV Product validation page ", "This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
            mProductPage.DairyProductsVerificationwithSearch_DecreaseQty(childTest10, testdata);

            ExtentTest childTest11= parentTest1.createNode("MHomePage Place Order page ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest11", childTest11);
            mProductPage.PlaceOrder_Button_Click(childTest11);

            ExtentTest childTest12= parentTest1.createNode("Interstitial Warning", "This test verifies that user is able to verify Interstitial cases");
            TestListner.extentMap.get().put("childTest12", childTest12);
            myVipMembership.Interstitual_Case_Higher_Price(childTest12);
            mProductPage.PlaceOrder_Button_withRecharge(childTest12);

            ExtentTest childTest13= parentTest1.createNode("Sale Marking", "This test verifies that VIP case with sale Marking");
            TestListner.extentMap.get().put("childTest13", childTest13);
            String db_id = Order_Sync_Regular_Order_API(testdata);
            method.SaleMarking_Regular(childTest13, db_id);

        } catch (Exception e) {
            e.printStackTrace();
            //  framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }
    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify VIPMembersip | Edge Case Error Scenario")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "VIP", "Regression","VIP_Interstitial"}, description = "Product QTy should One of Danedar Ghee", priority = 28)
    public void App_Interstitical_without_AutoRenew_off_Benifits() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset38");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MyVipMembership myVipMembership = new MyVipMembership(driver);
            Method method = new Method();

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            //TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mhomePage.trailMembershipVerification(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.mWalletVerificationWithPayment_Netbanking(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("Daily Delivery Page validation ","This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mhomePage.instaPagelaunch(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Membership Check","This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean Ismembershipcancelplan = myVipMembership.getMembershipDetails(childTest6, testdata);
////
            if(Ismembershipcancelplan) {
                ExtentTest childTest7 = parentTest1.createNode("Cancel Membership page ", "This test verifies that user is able Cancel membership  plans Successfully");
                //childTest8.setDescription("This test verifies that user is able Cancel membership  plans Successfully");
                TestListner.extentMap.get().put("childTest7", childTest7);
                childTest7.log(Status.PASS,"User Already has Membership");
            }else {
                ExtentTest childTest7 = parentTest1.createNode("Membership validation page ","This test verifies that user is able verify Membership Page Successfully");
                TestListner.extentMap.get().put("childTest7", childTest7);
                boolean Ismembership = myVipMembership.newUserVipMembership(childTest7);

                ExtentTest childTest8 = parentTest1.createNode("Purchase Membership", "This test verifies that user is able Purchase membership  plans Successfully");
                TestListner.extentMap.get().put("childTest8", childTest8);
                myVipMembership.applyMembership(childTest8);
                Thread.sleep(3000);
                driver.navigate().back();
            }

            ExtentTest childTest9 = parentTest1.createNode("Set VIP Bonus and Wallet Balance", "This test verifies that user is able Update VIP Bonus and Wallet Balance");
            TestListner.extentMap.get().put("childTest9", childTest9);
            myVipMembership.UpdateBalance(childTest9, testdata);

            ExtentTest childTest10 = parentTest1.createNode("FNV Product validation page ", "This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
            mProductPage.DairyProductsVerificationwithSearch_DecreaseQty(childTest10, testdata);

            ExtentTest childTest11= parentTest1.createNode("MHomePage Place Order page ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest11", childTest11);
            mProductPage.PlaceOrder_Button_Click(childTest11);


            ExtentTest childTest12= parentTest1.createNode("Interstitial Warning", "This test verifies that user is able to verify Interstitial cases");
            TestListner.extentMap.get().put("childTest13", childTest12);
            myVipMembership.Interstitual_Case_Benifits(childTest12);
            mProductPage.PlaceOrder_Button_withRecharge(childTest12);

            ExtentTest childTest13= parentTest1.createNode("Sale Marking", "This test verifies that VIP case with sale Marking");
            TestListner.extentMap.get().put("childTest13", childTest13);
            String db_id = Order_Sync_Regular_Order_API(testdata);
            method.SaleMarking_Regular(childTest13, db_id);

        } catch (Exception e) {
            e.printStackTrace();
            //  framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify VIPMembersip | Edge Case Error Scenario")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "VIP", "Regression","VIP_Interstitial"}, description = "Product QTy should One of Danedar Ghee", priority = 28)
    public void App_Interstitical_without_AutoRenew_off_Unlimited() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset38");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MyVipMembership myVipMembership = new MyVipMembership(driver);
            Method method = new Method();

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            //TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mhomePage.trailMembershipVerification(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.mWalletVerificationWithPayment_Netbanking(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("Daily Delivery Page validation ","This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mhomePage.instaPagelaunch(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Membership Check","This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean Ismembershipcancelplan = myVipMembership.getMembershipDetails(childTest6, testdata);
////
            if(Ismembershipcancelplan) {
                ExtentTest childTest7 = parentTest1.createNode("Cancel Membership page ", "This test verifies that user is able Cancel membership  plans Successfully");
                //childTest8.setDescription("This test verifies that user is able Cancel membership  plans Successfully");
                TestListner.extentMap.get().put("childTest7", childTest7);
                childTest7.log(Status.PASS,"User Already has Membership");
            }else {
                ExtentTest childTest7 = parentTest1.createNode("Membership validation page ","This test verifies that user is able verify Membership Page Successfully");
                TestListner.extentMap.get().put("childTest7", childTest7);
                boolean Ismembership = myVipMembership.newUserVipMembership(childTest7);

                ExtentTest childTest8 = parentTest1.createNode("Purchase Membership", "This test verifies that user is able Purchase membership  plans Successfully");
                TestListner.extentMap.get().put("childTest8", childTest8);
                myVipMembership.applyMembership(childTest8);
                Thread.sleep(3000);
                driver.navigate().back();
            }

            ExtentTest childTest9 = parentTest1.createNode("Set VIP Bonus and Wallet Balance", "This test verifies that user is able Update VIP Bonus and Wallet Balance");
            TestListner.extentMap.get().put("childTest9", childTest9);
            myVipMembership.UpdateBalance(childTest9, testdata);

            ExtentTest childTest10 = parentTest1.createNode("FNV Product validation page ", "This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
            mProductPage.DairyProductsVerificationwithSearch_DecreaseQty(childTest10, testdata);

            ExtentTest childTest11= parentTest1.createNode("MHomePage Place Order page ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest11", childTest11);
            mProductPage.PlaceOrder_Button_Click(childTest11);

            ExtentTest childTest12= parentTest1.createNode("Interstitial Unlimited", "This test verifies that user is able to verify Interstitial cases");
            TestListner.extentMap.get().put("childTest12", childTest12);
            myVipMembership.Interstitual_Case_Other_Plan(childTest12);
            Thread.sleep(5000);
            driver.navigate().back();
            myVipMembership.Interstitual_Case_Unlimited(childTest12);

            ExtentTest childTest13= parentTest1.createNode("Sale Marking", "This test verifies that VIP case with sale Marking");
            TestListner.extentMap.get().put("childTest13", childTest13);
            String db_id = Order_Sync_Regular_Order_API(testdata);
            method.SaleMarking_Regular(childTest13, db_id);
        } catch (Exception e) {
            e.printStackTrace();
            //  framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify VIPMembersip | With new User")
    @Story("Story Name: To check login page title")
    @Test(groups = {"production", "VIP","Sanity", "ConsumerApp", "Membership_On_Hold"}, description = "verifying  VIP Membersip", priority = 28)
    public void App_Vip_Membership_HoldCase() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset34");
            Framework framework = new Framework();
            Method method = new Method();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MyVipMembership myVipMembership = new MyVipMembership(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ","This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationCheck(childTest2);
            ExtentTest childTest3 = parentTest1.createNode("MHomePage wallet validation page ","This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mhomePage.mWalletVerificationWithPayment_Netbanking(childTest3, testdata);
//
            ExtentTest childTest4 = parentTest1.createNode("MHomePage New page instadelivery validation ","This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.instaPagelaunch(childTest4);

            ExtentTest childTest5 = parentTest1.createNode("Membership validation page ","This test verifies that user is able verify Membership Page Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            myVipMembership.VipMembershipcheck(childTest5,testdata);

            ExtentTest childTest9 = parentTest1.createNode("Cancel Membership page ","This test verifies that user is able Cancel membership  plans Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            myVipMembership.vipBenifitRedeemed(childTest9, testdata);

            ExtentTest childTest10 = parentTest1.createNode("Membership Autorenew Cron run ","This test verifies that Vip hold cron run successfully ");
            TestListner.extentMap.get().put("childTest10", childTest10);
            method.MembershipAutoRenewCron(childTest10);

            ExtentTest childTest11 = parentTest1.createNode("Verify Auto Renew Case ","This test verifies that Vip Automrenew case");
            TestListner.extentMap.get().put("childTest11", childTest11);
            myVipMembership.VipMembershipOnHOldRenewCase(childTest11);

            ExtentTest childTest12 = parentTest1.createNode("Hold Membership page ","This test verifies that user is able Hold membership  plans Successfully");
            TestListner.extentMap.get().put("childTest12", childTest12);
            myVipMembership.vipDecreaseamountHoldCase(childTest12, testdata);

            ExtentTest childTest13 = parentTest1.createNode("Hold Cron run ","This test verifies that Vip hold cron run successfully ");
            TestListner.extentMap.get().put("childTest13", childTest13);
            method.MembershipAutoRenewCron(childTest13);

          //  ExtentTest childTest14 = parentTest1.createNode("Verify Auto Renew Case ","This test verifies that Vip Automrenew case");
         //   TestListner.extentMap.get().put("childTest14", childTest14);
        //    myVipMembership.VipMembershipOnHOldVerification(childTest14);
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Offer Update in DB")
    @Story("Story Name: Update Date in Offer")
    @Test(groups = {"Regression","Product_Offer"}, description = "verifying Offer Update", priority = 6)
    public void Offer_Update_DB() throws SQLException, ClassNotFoundException, IOException {
        AccountData testdata = framework.getData(AccountData.class, "loginset11");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to Update offer " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        DB_Connection dbconnection = new DB_Connection();
        Method method = new Method();
        ExtentTest childTest1 = parentTest1.createNode("Get Customer Id","This test verifies that to Get Customer Id");
        // childTest1.setDescription("This test verifies that to Get Customer Id");
        TestListner.extentMap.get().put("childTest1", childTest1);
        String CUSTOMER_ID;
        String mobile_number = testdata.getMobile();
        CommonConstant.GetCustomerId_Dairy = CommonConstant.GetCustomerId_Dairy.replace("$mobilenumber", mobile_number);
        System.out.println(CommonConstant.GetCustomerId_Dairy);
        //if (CommonConstant.Environment().equalsIgnoreCase("QA Server"))
        {
            CUSTOMER_ID = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetCustomerId_Dairy).get("ID");
        }
        //else {
        //   CUSTOMER_ID = dbconnection.DBConnectionMem(CommonConstant.UAT_DBURL, CommonConstant.UAT_username, CommonConstant.UAT_Password, CommonConstant.GetCustomerId_Dairy).get("ID");
        // }
        // String CUSTOMER_ID = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetCustomerId_Dairy).get("ID");
        ExtentTest childTest2 = parentTest1.createNode("Get Offer Id","This test verifies that Newly created Offer is showing in DB");
        // childTest2.setDescription("This test verifies that Route Sheet Generated Successfully");
        TestListner.extentMap.get().put("childTest2", childTest2);
        String offerId = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetProductOffer).get("ID");
        ExtentTest childTest3 = parentTest1.createNode("Update Offer Date","This test verifies that Update Creation Date and Updated Date");
        //childTest3.setDescription("This test verifies that Update Creation Date and Updated Date");
        TestListner.extentMap.get().put("childTest3", childTest3);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
        String Current_Date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        String Previous_Date= new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        CommonConstant.UpdateProductOffer = CommonConstant.UpdateProductOffer.replace("$Previous_Date", Previous_Date).replace("$Current_Date", Current_Date).replace("$ID",offerId);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.UpdateProductOffer);
        System.out.println(CommonConstant.UpdateProductOffer);
        ExtentTest childTest4 = parentTest1.createNode("Get Product Customer Offer","This test verifies to get Product Customer Offer");
        TestListner.extentMap.get().put("childTest4", childTest4);
        String ProductCustomerOffer = CommonConstant.GetProductCustomerOffer.replace("$OfferId", offerId).replace("$ID",CUSTOMER_ID);
        System.out.println(ProductCustomerOffer);
        String ProductCustomerOfferId =dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetCustomerId_Dairy).get("ID");
        ExtentTest childTest5 = parentTest1.createNode("Update Product Customer Offer","This test verifies to Update Product Customer Offer");
        TestListner.extentMap.get().put("childTest5", childTest5);
        CommonConstant.UpdateProductCustomerOffer = CommonConstant.UpdateProductCustomerOffer.replace("$Previous_Date", Previous_Date).replace("$ID",ProductCustomerOfferId);
        System.out.println(CommonConstant.UpdateProductCustomerOffer);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.UpdateProductCustomerOffer);
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Offer Update in DB")
    @Story("Story Name: Update Date in Offer")
    @Test(groups = {"Regression","Subscription_Offer"}, description = "verifying Subscription Offer Update", priority = 11)
    public void Subscription_Offer_Update_DB() throws SQLException, ClassNotFoundException, IOException {
        AccountData testdata = framework.getData(AccountData.class, "loginset42");
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to Update offer " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        DB_Connection dbconnection = new DB_Connection();
        Method method = new Method();
        ExtentTest childTest1 = parentTest1.createNode("Get Customer Id","This test verifies that to Get Customer Id");
        // childTest1.setDescription("This test verifies that to Get Customer Id");
        TestListner.extentMap.get().put("childTest1", childTest1);
        String CUSTOMER_ID;
        String mobile_number = testdata.getMobile();
        CommonConstant.GetCustomerId_Dairy = CommonConstant.GetCustomerId_Dairy.replace("$mobilenumber", mobile_number);
        System.out.println(CommonConstant.GetCustomerId_Dairy);
        //if (CommonConstant.Environment().equalsIgnoreCase("QA Server"))
        {
            CUSTOMER_ID = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetCustomerId_Dairy).get("ID");
        }
        //else {
        //   CUSTOMER_ID = dbconnection.DBConnectionMem(CommonConstant.UAT_DBURL, CommonConstant.UAT_username, CommonConstant.UAT_Password, CommonConstant.GetCustomerId_Dairy).get("ID");
        // }
        // String CUSTOMER_ID = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetCustomerId_Dairy).get("ID");
        ExtentTest childTest2 = parentTest1.createNode("Get Offer Id","This test verifies that Newly created Offer is showing in DB");
        // childTest2.setDescription("This test verifies that Route Sheet Generated Successfully");
        TestListner.extentMap.get().put("childTest2", childTest2);
        String offerId = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetProductOffer).get("ID");
        ExtentTest childTest3 = parentTest1.createNode("Update Offer Date","This test verifies that Update Creation Date and Updated Date");
        //childTest3.setDescription("This test verifies that Update Creation Date and Updated Date");
        TestListner.extentMap.get().put("childTest3", childTest3);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
        String Current_Date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        String Previous_Date= new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        CommonConstant.UpdateProductOffer = CommonConstant.UpdateProductOffer.replace("$Previous_Date", Previous_Date).replace("$Current_Date", Current_Date).replace("$ID",offerId);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.UpdateProductOffer);
        System.out.println(CommonConstant.UpdateProductOffer);
        ExtentTest childTest4 = parentTest1.createNode("Get Product Customer Offer","This test verifies to get Product Customer Offer");
        TestListner.extentMap.get().put("childTest4", childTest4);
        String ProductCustomerOffer = CommonConstant.GetProductCustomerOffer.replace("$OfferId", offerId).replace("$ID",CUSTOMER_ID);
        System.out.println(ProductCustomerOffer);
        String ProductCustomerOfferId =dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetCustomerId_Dairy).get("ID");
        ExtentTest childTest5 = parentTest1.createNode("Update Product Customer Offer","This test verifies to Update Product Customer Offer");
        TestListner.extentMap.get().put("childTest5", childTest5);
        CommonConstant.UpdateProductCustomerOffer = CommonConstant.UpdateProductCustomerOffer.replace("$Previous_Date", Previous_Date).replace("$ID",ProductCustomerOfferId);
        System.out.println(CommonConstant.UpdateProductCustomerOffer);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.UpdateProductCustomerOffer);
        ExtentTest childTest6 = parentTest1.createNode("Update Customer Membership Offer","This test verifies to Update Customer Membership Offer");
        TestListner.extentMap.get().put("childTest6", childTest6);
        String Membership_Id = CommonConstant.GetUpdatedMemberId_QA.replace("$CUSTOMERID", CUSTOMER_ID);
        String UpdateMemebership_id = CommonConstant.Customer_membership_update.replace("$ID",Membership_Id).replace("$Previous_Date",Previous_Date);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, UpdateMemebership_id);
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify The Dairy Product Verification | Subscription | Order Confirmation")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Regression","Product_on_Hold"}, description = "verifying CD airy Product Verification | Subscription | Order Confirmation", priority = 32)
    public void App_Dairy_Product_Order_On_Hold() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset43");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);
            Order_Update orderUpdate = new Order_Update(driver);
            Method method = new Method();

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidation(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("MHomePage New page instadelivery validation ", "This test verifies that user is able to verify instadelivery  Successfully");
            // childTest8.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest3);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("Dairy Product list validation page ", "This test verifies that user is able verify product list Successfully");
            //childTest1.setDescription("This test verifies that user is able verify product list Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            if(IswalletVeried) {
                mhomePage.instaPagelaunch(childTest5);
            }
            boolean IsdairyProductlistverified = mProductPage.dairyProductListVerification(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Dairy Product validation page ", "This test verifies that user is able verify product Successfully");
            // childTest1.setDescription("This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mProductPage.DairyProductsVerificationwithSearch(childTest6, testdata);
            //boolean IsdairyProductverified = mProductPage.dairyProductsVerification(childTest6);

//            ExtentTest childTest5 = testListener.startChild("Dairy Product Subscription page ");
//            childTest1.setDescription("This test verifies that user is able Subscribe Product Successfully");
//            TestListner.extentMap.get().put("childTest5", childTest5);
//            boolean IsdairySubscriptionandOrder = mSubscriptionAndOrder.dairyProductOneTimeSubscription(childTest5);
            ExtentTest childTest7= parentTest1.createNode("MHomePage Rapid validation page ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            //childTest5.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean IsproceedButtonClick = mProductPage.PlaceOrder_Button_Click(childTest7);

            ExtentTest childTest8 = parentTest1.createNode("Dairy Order Confirmation Review page  ", "This test verifies that user is able Verify Order Confirmation Page Successfully");
            //childTest8.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean IsdairyOrderreviewSuccessfully = mOrderReviewScreen.orderReviewScreenVerification(childTest8);

            ExtentTest childTest9 = parentTest1.createNode("Order Sync Dairy ", "This test verifies that user is able Generate Route Sheet");
            //childTest8.setDescription("This test verifies that user is able Verify Order Confirmation Page Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            Order_Sync_Dairy_Product_offer();

            ExtentTest childTest10 = parentTest1.createNode("Update User Balance  ", "This test verifies that Update User Balance for Order On Hold");
            TestListner.extentMap.get().put("childTest10", childTest10);
            orderUpdate.UpdateUserBalance(childTest10, testdata);

            ExtentTest childTest11 = parentTest1.createNode("Order On Hold Cron ", "This test verifies that Order On Hold Cron Running");
            TestListner.extentMap.get().put("childTest10", childTest10);
            CommonConstant.GetCustomerId_New = CommonConstant.GetCustomerId_New.replace("$CUSTOMER", testdata.getMobile());
            DB_Connection dbconnection = new DB_Connection();
            String CustomerId = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetCustomerId_New).get("ID");
            method.Order_On_Hold(CustomerId,childTest11);

           // ExtentTest childTest12 = parentTest1.createNode("Delivery in On Hold Case ", "This test verifies that Delivery will not happend in case of Order On Hold");
           // TestListner.extentMap.get().put("childTest10", childTest10);
           // Making_Delivery_Daily_Dairy();

        } catch (Exception e) {
            e.printStackTrace();
            //   framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"API_Test"}, description = "verifying Order Sync", priority = 5)
    public String Order_Sync_Regular_Order_API(AccountData testdata) throws SQLException, ClassNotFoundException, IOException {
      //  AccountData testdata = framework.getData(AccountData.class, "loginset37");
        if(System.getProperty("mobile_Number")!=null){
            System.out.println("Using User Provided Mobile Number");
            testdata.setMobile(System.getProperty("mobile_Number"));
            testdata.setFirstName(System.getProperty("Product_Name"));
        }
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        DB_Connection dbconnection = new DB_Connection();
        Method method = new Method();
        ExtentTest childTest1 = parentTest1.createNode("Get Customer Id","This test verifies that to Get Customer Id");
        TestListner.extentMap.get().put("childTest1", childTest1);
        String CUSTOMER_ID;
        String mobile_number = testdata.getMobile();
        CommonConstant.GetCustomerId_Dairy = CommonConstant.GetCustomerId_Dairy.replace("$mobilenumber", mobile_number);
        System.out.println(CommonConstant.GetCustomerId_Dairy);
        CUSTOMER_ID = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetCustomerId_Dairy).get("ID");
        childTest1.log(Status.INFO,"Customer Id - "+CUSTOMER_ID);
        ExtentTest childTest2 = parentTest1.createNode("Generate Route Sheet","This test verifies that Route Sheet Generated Successfully");
        TestListner.extentMap.get().put("childTest2", childTest2);
        method.GenerateRouteSheet(CUSTOMER_ID, childTest2);
        ExtentTest childTest3 = parentTest1.createNode("Update Route Details Table","This test verifies that Update Creation Date and Updated Date");
        TestListner.extentMap.get().put("childTest3", childTest3);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
        String Update_Route_Sheet_Details = CommonConstant.UpdateRouteSheetDetails.replace("$Current_Date", timeStamp).replace("$ID",CUSTOMER_ID);
        System.out.println(Update_Route_Sheet_Details);
        String Routesheet_update = CommonConstant.GetRoutesheetID.replace("$CUSTOMER", CUSTOMER_ID);
        System.out.println(Routesheet_update);
        String Route_Sheet_id;
        Route_Sheet_id =  dbconnection.DesiredValueFromDB(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Routesheet_update, "ROUTE_SHEET").get("ROUTE_SHEET");
        System.out.println(Route_Sheet_id);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Update_Route_Sheet_Details);
        String Update_Sheet = CommonConstant.UpdateRouteSheet.replace("$Current_Date", timeStamp).replace("$ID",Route_Sheet_id);
        System.out.println(Update_Sheet);
        childTest3.log(Status.INFO,"Route Sheet Details - "+Update_Route_Sheet_Details);
        ExtentTest childTest4 = parentTest1.createNode("Update Route Sheet Table","This test verifies that Update Date and Delivery Boy");
        TestListner.extentMap.get().put("childTest4", childTest4);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Update_Sheet);
        childTest4.log(Status.INFO,"Route Sheet - "+Update_Sheet);
        String Order_Details = CommonConstant.OrderDetail.replace("$Current_Date", timeStamp).replace("$ID",CUSTOMER_ID);
        ExtentTest childTest5 = parentTest1.createNode("Update Order Details","This test verifies that Update Order Start Date and Order End Date");
        TestListner.extentMap.get().put("childTest5", childTest5);
        System.out.println(Order_Details);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Order_Details);
        childTest5.log(Status.INFO,"Order Details - "+Order_Details);
        String Route_Sheet_id_new =  dbconnection.DesiredValueFromDB(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Routesheet_update, "ID").get("ID");
        return Route_Sheet_id_new;

    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"API_Test"}, description = "verifying Order Sync", priority = 5)
    public String Order_Sync_Regular_Order_API() throws SQLException, ClassNotFoundException, IOException {
        AccountData testdata = framework.getData(AccountData.class, "loginset37");
        if(System.getProperty("mobile_Number")!=null){
            System.out.println("Using User Provided Mobile Number");
            testdata.setMobile(System.getProperty("mobile_Number"));
            testdata.setFirstName(System.getProperty("Product_Name"));
        }
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        DB_Connection dbconnection = new DB_Connection();
        Method method = new Method();
        ExtentTest childTest1 = parentTest1.createNode("Get Customer Id","This test verifies that to Get Customer Id");
        TestListner.extentMap.get().put("childTest1", childTest1);
        String CUSTOMER_ID;
        String mobile_number = testdata.getMobile();
        CommonConstant.GetCustomerId_Dairy = CommonConstant.GetCustomerId_Dairy.replace("$mobilenumber", mobile_number);
        System.out.println(CommonConstant.GetCustomerId_Dairy);
        CUSTOMER_ID = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetCustomerId_Dairy).get("ID");
        childTest1.log(Status.INFO,"Customer Id - "+CUSTOMER_ID);
        ExtentTest childTest2 = parentTest1.createNode("Generate Route Sheet","This test verifies that Route Sheet Generated Successfully");
        TestListner.extentMap.get().put("childTest2", childTest2);
        method.GenerateRouteSheet(CUSTOMER_ID, childTest2);
        ExtentTest childTest3 = parentTest1.createNode("Update Route Details Table","This test verifies that Update Creation Date and Updated Date");
        TestListner.extentMap.get().put("childTest3", childTest3);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
        String Update_Route_Sheet_Details = CommonConstant.UpdateRouteSheetDetails.replace("$Current_Date", timeStamp).replace("$ID",CUSTOMER_ID);
        System.out.println(Update_Route_Sheet_Details);
        String Routesheet_update = CommonConstant.GetRoutesheetID.replace("$CUSTOMER", CUSTOMER_ID);
        System.out.println(Routesheet_update);
        String Route_Sheet_id;
        Route_Sheet_id =  dbconnection.DesiredValueFromDB(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Routesheet_update, "ROUTE_SHEET").get("ROUTE_SHEET");
        System.out.println(Route_Sheet_id);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Update_Route_Sheet_Details);
        String Update_Sheet = CommonConstant.UpdateRouteSheet.replace("$Current_Date", timeStamp).replace("$ID",Route_Sheet_id);
        System.out.println(Update_Sheet);
        childTest3.log(Status.INFO,"Route Sheet Details - "+Update_Route_Sheet_Details);
        ExtentTest childTest4 = parentTest1.createNode("Update Route Sheet Table","This test verifies that Update Date and Delivery Boy");
        TestListner.extentMap.get().put("childTest4", childTest4);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Update_Sheet);
        childTest4.log(Status.INFO,"Route Sheet - "+Update_Sheet);
        String Order_Details = CommonConstant.OrderDetail_new.replace("$Current_Date", timeStamp).replace("$ID",CUSTOMER_ID);
        String OrderNumber = dbconnection.DesiredValueFromDB(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Order_Details,"ORDER_NUMBER").get("ORDER_NUMBER");
        ExtentTest childTest5 = parentTest1.createNode("Update Order Details","This test verifies that Update Order Start Date and Order End Date");
        TestListner.extentMap.get().put("childTest5", childTest5);
        System.out.println(Order_Details);
        String Order_Details_OID = CommonConstant.OrderDetail_OID.replace("$Current_Date", timeStamp).replace("$OID",OrderNumber);
        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Order_Details_OID);
        childTest5.log(Status.INFO,"Order Details - "+Order_Details);
        String Route_Sheet_id_new =  dbconnection.DesiredValueFromDB(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, Routesheet_update, "ID").get("ID");
        return Route_Sheet_id_new;

    }
/*
    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify The Dairy Product Verification | Subscription | Order Confirmation")
    @Story("Story Name: To check login page title")
    @Test(groups = {""}, description = "verifying CD airy Product Verification | Subscription | Order Confirmation", priority = 5)
    public void App_Dairy_Product_Offer_Check() throws IOException, InterruptedException {
        if(SellingPrice==0){
            throw new SkipException("Skipping test because condition is not met");
        }
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset11");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            MPaymentScreen mPaymentScreen = new MPaymentScreen(driver);
            MySubscription mSubscriptionAndOrder = new MySubscription(driver);
            MOrderReviewScreen mOrderReviewScreen= new MOrderReviewScreen(driver);
            MOrderConfrimationScreen mOrderConfrimationScreen = new MOrderConfrimationScreen(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            //childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidation(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("MHomePage New page instadelivery validation ", "This test verifies that user is able to verify instadelivery  Successfully");
            // childTest8.setDescription("This test verifies that user is able to verify instadelivery  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean Isinstapage = mhomePage.instaPagelaunch(childTest3);

            ExtentTest childTest4 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest4, testdata);

            ExtentTest childTest5 = parentTest1.createNode("Dairy Product list validation page ", "This test verifies that user is able verify product list Successfully");
            //childTest1.setDescription("This test verifies that user is able verify product list Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            if(IswalletVeried) {
                mhomePage.instaPagelaunch(childTest5);
            }
            boolean IsdairyProductlistverified = mProductPage.dairyProductListVerification(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Check Created Order Price ", "This test verifies that user is able verify product Successfully");
            // childTest1.setDescription("This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);


        } catch (Exception e) {
            e.printStackTrace();
            //   framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }


 */

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"ConsumerApp", "Sanity", "Regression","Recharge"}, description = "verifying CD New User Flow")
    public void Default_Amount_Flow_With_High_recharge_Amount() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //  childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            //   childTest3.setDescription("This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);

            //  driver.navigate().back();


            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mHomePageData(childTest6);

            DB_Connection dbConnection = new DB_Connection();
            String New_User_DA = dbConnection.DesiredValueFromDB(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.Default_Amount_New, "PLACEHOLDER_STATIC_VALUE").get("PLACEHOLDER_STATIC_VALUE");
            String Old_User_DA = dbConnection.DesiredValueFromDB(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.Default_Amount_Old, "PLACEHOLDER_STATIC_VALUE").get("PLACEHOLDER_STATIC_VALUE");

            ExtentTest childTest7 = parentTest1.createNode("Default New User Config Recharge", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            mhomePage.mWalletVerification_Default_Recharge(childTest7,New_User_DA, "2000");

            ExtentTest childTest8 = parentTest1.createNode("Default Existing User Config Recharge with more than Default config", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            mhomePage.mWalletVerification_Default_Recharge(childTest8,"2000", "200");

            ExtentTest childTest9 = parentTest1.createNode("Default Existing User Config Recharge with less than Default config", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            mhomePage.mWalletVerification_Default_Recharge(childTest9,Old_User_DA, "100");
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"ConsumerApp", "Sanity", "Regression","Recharge"}, description = "verifying CD New User Flow")
    public void Payment_Low_New_User_Low_User_Amount() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //  childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            //   childTest3.setDescription("This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);

            //  driver.navigate().back();


            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mHomePageData(childTest6);

            DB_Connection dbConnection = new DB_Connection();
            String New_User_DA = dbConnection.DesiredValueFromDB(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.Default_Amount_New, "PLACEHOLDER_STATIC_VALUE").get("PLACEHOLDER_STATIC_VALUE");
            String Old_User_DA = dbConnection.DesiredValueFromDB(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.Default_Amount_Old, "PLACEHOLDER_STATIC_VALUE").get("PLACEHOLDER_STATIC_VALUE");

            ExtentTest childTest7 = parentTest1.createNode("Default New User Config Recharge", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            mhomePage.mWalletVerification_Default_Recharge(childTest7,New_User_DA, "100");

            ExtentTest childTest8 = parentTest1.createNode("Default Existing User Config Recharge with more than Default config", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            mhomePage.mWalletVerification_Default_Recharge(childTest8,Old_User_DA, "2000");

            ExtentTest childTest9 = parentTest1.createNode("Default Existing User Config Recharge with less than Default config", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            mhomePage.mWalletVerification_Default_Recharge(childTest9,"2000", "100");
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"ConsumerApp", "Sanity", "Regression","Recharge"}, description = "verifying CD New User Flow")
    public void Order_Flow_Payment_Low_New_User_Low_User_Amount() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //  childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            //   childTest3.setDescription("This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);

            //  driver.navigate().back();


            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mHomePageData(childTest6);

            DB_Connection dbConnection = new DB_Connection();
            String New_User_DA = dbConnection.DesiredValueFromDB(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.DefaultRecharge_Order_New, "VALUE").get("VALUE");
            String Old_User_DA = dbConnection.DesiredValueFromDB(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.DefaultRecharge_Order_Old, "VALUE").get("VALUE");

            ExtentTest childTest7 = parentTest1.createNode("Dairy Product validation page ", "This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            mProductPage.DairyProductsVerificationwithSearch(childTest7, testdata);

            ExtentTest childTest8= parentTest1.createNode("Placing Order ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            mProductPage.PlaceOrder_Add_Address_Button(childTest8);

            ExtentTest childTest9 = parentTest1.createNode("Default New User Config Recharge", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            mhomePage.mWalletVerification_Default_Recharge_Order(childTest9,New_User_DA, "100");

         /*   ExtentTest childTest10 = parentTest1.createNode("Dairy Product validation page ", "This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
            mProductPage.DairyProductsVerificationwithSearch(childTest7, testdata);

            ExtentTest childTest11= parentTest1.createNode("Placing Order ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest11", childTest11);
            mProductPage.PlaceOrder_Add_Address_Button(childTest11);

          */
            ExtentTest childTest12 = parentTest1.createNode("Default Existing User Config Recharge with more than Default config", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest12", childTest12);
            mhomePage.mWalletVerification_Default_Recharge_Order(childTest12,Old_User_DA, "2000");

          /*  ExtentTest childTest11 = parentTest1.createNode("Default Existing User Config Recharge with less than Default config", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest11", childTest11);
            mhomePage.mWalletVerification_Default_Recharge_Order(childTest11,"2000", "100");

           */
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"ConsumerApp", "Sanity", "Regression","VIP","Membership_On_Hold","Vacation"}, description = "verifying CD New User Flow")
    public void Membership_Pause() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MoreScreen moreScreen = new MoreScreen(driver);
            MyVipMembership myVipMembership = new MyVipMembership(driver);

            ExtentTest childTest1 = parentTest1.createNode("Update Membership Config For User ", "This test verifies that user is able membership config");
            TestListner.extentMap.get().put("childTest1", childTest1);
            myVipMembership.Update_Customer_Membership_Config(childTest1, testdata);

            ExtentTest childTest2 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest2);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData(childTest2, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //  childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.otpValidationNew(childTest3);

            ExtentTest childTest4 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            //   childTest3.setDescription("This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mloginscreen.enterAddress(childTest4,testdata);

            //  driver.navigate().back();


            ExtentTest childTest5 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mhomePage.trailMembershipVerification(childTest5,testdata);

            ExtentTest childTest6 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mloginscreen.skipButtonFunctional(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            mhomePage.mHomePageData(childTest7);

            ExtentTest childTest8 = parentTest1.createNode("Add Vacation validation page & Not pause VIP membership","This test verifies that user is able to Start Vacation Page Successfully");
            //childTest7.setDescription("This test verifies that user is able to Start Vacation Page Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            moreScreen.addVacation_VIP_Pause(childTest8, false);

            ExtentTest childTest9 = parentTest1.createNode("Value Updated in DB ","This test verifies that user is able End Vacations Page Successfully");
            // childTest9.setDescription("This test verifies that user is able End Vacations Page Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            HashMap<String, Object> hashMap =moreScreen.Result_Pause_Membership(testdata, childTest9);
            moreScreen.Pause_Membership_Status_check(hashMap, childTest9, 0);

            ExtentTest childTest10 = parentTest1.createNode("Delete Vacation validation page ","This test verifies that user is able Edit Vacations Page Successfully");
            //childTest8.setDescription("This test verifies that user is able Edit Vacations Page Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
           // boolean IseditVacation = moreScreen.deleteVacation(childTest10);

            ExtentTest childTest11 = parentTest1.createNode("Add Vacation validation page pause VIP membership","This test verifies that user is able to Start Vacation Page Successfully");
            //childTest7.setDescription("This test verifies that user is able to Start Vacation Page Successfully");
            TestListner.extentMap.get().put("childTest11", childTest11);
            moreScreen.addVacation_VIP_Pause(childTest11, false);

            ExtentTest childTest12 = parentTest1.createNode("Value Updated in DB ","This test verifies that user is able End Vacations Page Successfully");
            // childTest9.setDescription("This test verifies that user is able End Vacations Page Successfully");
            TestListner.extentMap.get().put("childTest12", childTest12);
            HashMap<String, Object> hashMap1 =moreScreen.Result_Pause_Membership(testdata, childTest12);
            moreScreen.Pause_Membership_Status_check(hashMap1, childTest9, 1);

        //    ExtentTest childTest13 = parentTest1.createNode("Delete Vacation validation page ","This test verifies that user is able Edit Vacations Page Successfully");
            //childTest8.setDescription("This test verifies that user is able Edit Vacations Page Successfully");
        //    TestListner.extentMap.get().put("childTest12", childTest12);
        //    moreScreen.deleteVacation(childTest12);

        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Build", "Prod_Sanity_withG+"}, description = "verifying CD New User Flow")
    public void Prod_Build_Download() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite9");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            PlayStore playStore = new PlayStore(driver);

            ExtentTest childTest1 = parentTest1.createNode("Sign In with G+ Account ", "This test verifies that user is able to Login in G+ Account in Playstore");
            TestListner.extentMap.get().put("childTest1", childTest1);
            playStore.SignIn(childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Search Country Delight app ", "This test verifies that user is Download new App from Play store");
            TestListner.extentMap.get().put("childTest2", childTest2);
            playStore.SearchApp(childTest2);


        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Existing User FLow")
    @Story("Story Name: To check Cusnumer App Daily Sanity")
    @Test(groups = {"Prod_Sanity"}, description = "verifying CD Existing User flow")
    public void ConsumerApp_Continue_Check() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset45");
            Framework framework = new Framework();
//            AssertData assertData = null;
//            CustomSoftAssert assertcheck = new CustomSoftAssert(assertData,  driver);
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite8");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);
            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            // childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData_Prod(childTest1, testdata);
            //TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);


            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidationExistngUser(childTest2);

            driver.activateApp("app.mycountrydelight.in.countrydelight");
            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            //childTest4.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IsHomememberVeried = mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Upgrade Membership validation page ", "This test verifies that user is able to verify upgrade Membership");
            //childTest4.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mhomePage.Memberupgrade(childTest5);

//            ExtentTest childTest3 = testListener.startChild("Address validation page ");
//            childTest3.setDescription("This test verifies that user is able to enter Address  Successfully");
//            TestListner.extentMap.get().put("childTest3", childTest3);
//            boolean IsAddressVeried= mloginscreen.EnterAddress(childTest3,testdata);
//
//            ExtentTest childTest4 = testListener.startChild("Skipbutotn validation page ");
//            childTest4.setDescription("This test verifies that user is able to Skip Refrell Address  Successfully");
//            TestListner.extentMap.get().put("childTest4", childTest4);
//            boolean IsSkipVeried= mloginscreen.SkipButtonFunctional(childTest4);
            // driver.navigate().back();
            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
           TestListner.extentMap.get().put("childTest6", childTest6);
           mhomePage.mHomePageDataExistinguser(childTest6);

           // ExtentTest childTest9 = parentTest1.createNode("MproductPage validation page ", "This test verifies that user is able to verify Products  Successfully");
            //childTest9.setDescription("This test verifies that user is able to verify Products  Successfully");
           // TestListner.extentMap.get().put("childTest9", childTest9);
           // boolean IsfProductVeried = mProductPage.navigateToL1CategoryList(childTest9);

            ExtentTest childTest10 = parentTest1.createNode("Dairy Product validation page ", "This test verifies that user is able verify product Successfully");
            // childTest1.setDescription("This test verifies that user is able verify product Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
            mProductPage.DairyProductsVerificationwithSearch_Prod(childTest10, testdata);

            ExtentTest childTest11 = parentTest1.createNode("Morning Cart", "This Test to Verify that Morning Cart is Working Properly in Production");
            TestListner.extentMap.get().put("childTest11", childTest11);
            mProductPage.Morning_Button_Click(childTest11);


        } catch (Exception e) {
            e.printStackTrace();
            org.testng.Assert.fail("Test failed due to exception: " + e.getMessage());
             //  framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Not Required"}, description = "verifying Order Sync", priority = 7)
    public void Making_Delivery_Daily_Dairy_New() throws InterruptedException, IOException {
        Thread.sleep(30000);
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset6");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite4");
            }
            DBLoginScreen dbloginscreen = new DBLoginScreen(driver);
            DBHomePage dbhomepage = new DBHomePage(driver);
            ExtentTest childTest1 = parentTest1.createNode("DB App login Screen page ","This test verifies that user is able to verify login page content");
            // childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = dbloginscreen.DBLoginScreenData(childTest1, testdata);
            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ","This test verifies that user is able enter OTP Successfully");
            // childTest2.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = dbloginscreen.otpValidationExistngUser(childTest2);
            ExtentTest childTest3 = parentTest1.createNode("Uncheck Instant Delivery Option","This test verifies that Instant Delivery option is Unchecked");
            //childTest3.setDescription("This test verifies that Instant Delivery option is Unchecked");
            TestListner.extentMap.get().put("childTest3", childTest3);
            dbhomepage.DailyDeliverySelection(childTest3);
            ExtentTest childTest4 = parentTest1.createNode("Marking Delivery for Daily Products","This test verifies that Making Delivery for Dailry products of Daily Products");
            //childTest4.setDescription("This test verifies that Making Delivery for Dailry products of Daily Products");
            TestListner.extentMap.get().put("childTest4", childTest4);
            dbhomepage.Mark_Delivery_Daily(childTest4);
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }


    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New DB App Flow")
    @Story("Story Name: To check SKUPackaging page ")
    @Test(groups = {"production", "NewDBApp","InstantProfile01","InstantSuite001"}, description = "verifying New DB App Flow", priority = 0)
    public void New_DB_Rapid_Flow_Profile_Screen() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset45");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite10");
            }
            DBLogin_New newdblogin = new DBLogin_New(driver);
            Profile_New newProfilePage = new Profile_New(driver);
            ExtentTest childTest1 = parentTest1.createNode("New DB App >> Login Page validation ", "This test verifies that user is able see Title and MObile No filed text");
            TestListner.extentMap.get().put("child1", childTest1);
            Boolean DBAppLoginScreen = newdblogin.DBLoginScreenData(childTest1,"7836016806");
            ExtentTest childTest2 = parentTest1.createNode("New DB App OTP Screen page ","This test verifies that user is able to Enter OTP and click Verify OTP button");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean NewDbAppOTPScreen= newdblogin.NewDBotpValidationExistngUser(childTest2,testdata);
            ExtentTest childTest3 = parentTest1.createNode("Profile Page >> Delivery Boy Details. ","This test verifies that user is able to see Delivery Boy Details.");
            TestListner.extentMap.get().put("childTest3", childTest3);
            boolean NewDbAppProfileScreen= newProfilePage.NewProfileScreenData(childTest3,testdata);
            ExtentTest childTest4 = parentTest1.createNode("Profile Page >> Checking All Pages ","This test verifies that user is able to open the pages in profile screen");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean NewDbAppCheckingEachPagesScreen= newProfilePage.CheckingAllPage(childTest4,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }
    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New DB App Flow")
    @Story("Story Name: To check SKUPackaging page ")
    @Test(groups = {"production", "NewDBApp001","ScanPickUp01","InstantSuite001"}, description = "verifying New DB App Flow", priority = 1)
    public void ScanPickUp_Manually() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset45");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite10");
            }
            DBLogin_New newdblogin = new DBLogin_New(driver);
            Profile_New newProfilePage = new Profile_New(driver);
            ScanPickUp_New scanpickup = new ScanPickUp_New(driver);
            ExtentTest childTest1 = parentTest1.createNode("New DB App >> Login Page validation","This test verifies that user is able see Title and MObile No filed text");
            TestListner.extentMap.get().put("child1", childTest1);
            Boolean DBAppLoginScreen = newdblogin.DBLoginScreenData(childTest1,"7836016806");
            ExtentTest childTest2 = parentTest1.createNode("New DB App OTP Screen page ","This test verifies that user is able to Enter OTP and click Verify OTP button");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean NewDbAppOTPScreen= newdblogin.NewDBotpValidationExistngUser(childTest2,testdata);
            ExtentTest childTest3 = parentTest1.createNode("Profile Page >> Delivery Boy Details. ","This test verifies that user is able to see Delivery Boy Details.");
            TestListner.extentMap.get().put("childTest3", childTest3);
            boolean NewDbAppProfileScreen= newProfilePage.NewProfileScreenData(childTest3,testdata);
            ExtentTest childTest4 = parentTest1.createNode("Scan Pick Up Manually","This test verifies that user is able to do manually scan Pick Up.");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean ScanPickUpPages= scanpickup.ScanPickUpManually(childTest4,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }
    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New DB App Flow")
    @Story("Story Name: To check SKUPackaging page ")
    @Test(groups = {"production", "NewDBApp001","Assigned001","InstantSuite001"}, description = "verifying New DB App Flow", priority = 2)
    public void AssignedScreen() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset45");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite10");
            }
            DBLogin_New newdblogin = new DBLogin_New(driver);
            DB_Config newassignedpage = new DB_Config(driver);
            ExtentTest childTest1 = parentTest1.createNode("New DB App >> Login Page validation","This test verifies that user is able see Title and MObile No filed text");
            TestListner.extentMap.get().put("child1", childTest1);
            Boolean DBAppLoginScreen = newdblogin.DBLoginScreenData(childTest1,"7836016806");
            ExtentTest childTest2 = parentTest1.createNode("New DB App OTP Screen page ","This test verifies that user is able to Enter OTP and click Verify OTP button");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean NewDbAppOTPScreen= newdblogin.NewDBotpValidationExistngUser(childTest2,testdata);
            ExtentTest childTest3 = parentTest1.createNode("Assigned Screen ","This test verifies that user is able to scan the product manually.");
            TestListner.extentMap.get().put("childTest3", childTest3);
            boolean AssignedScreen= newassignedpage.Generic_Delivery(childTest3);
        } catch (Exception e) {
            e.printStackTrace();
            framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }
    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New DB App Flow")
    @Story("Story Name: To check SKUPackaging page ")
    @Test(groups = {"production", "NewDBApp001","RapidDelivered001","InstantSuite001"}, description = "verifying New DB App Flow", priority = 3)
    public void Rapid_Delivery_Without_GeoFencing_Done() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset45");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite10");
            }
            DBLogin_New newdblogin = new DBLogin_New(driver);
            PickedPage_New newpickedPage = new PickedPage_New(driver);
            Delivered_New newdeliveredpage = new Delivered_New(driver);
            ExtentTest childTest1 = parentTest1.createNode("New DB App >> Login Page validation","This test verifies that user is able see Title and MObile No filed text");
            TestListner.extentMap.get().put("child1", childTest1);
            Boolean DBAppLoginScreen = newdblogin.DBLoginScreenData(childTest1,"7836016806");
            ExtentTest childTest2 = parentTest1.createNode("New DB App OTP Screen page ","This test verifies that user is able to Enter OTP and click Verify OTP button");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean NewDbAppOTPScreen= newdblogin.NewDBotpValidationExistngUser(childTest2,testdata);
            ExtentTest childTest4 = parentTest1.createNode("Picked Page ","This test verifies that user is able to picked the Order and Delivered");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean NewDbAppPickedScreen= newpickedPage.PickedFlowData(childTest4);
            ExtentTest childTest5 = parentTest1.createNode("Delivered Page ","This test verifies that user is able to view Delivered Details.");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean NewDbAppDeliveredScreen= newdeliveredpage.NewDeliveredFlowData(childTest5,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }
    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New DB App Flow")
    @Story("Story Name: To check SKUPackaging page ")
    @Test(groups = {"production", "NewDBApp001","NonDelivered123","InstantSuite001","Not Working","Rapid_Dairy_R"}, description = "verifying New DB App Flow", priority = 4)
    public void Rapid_Delivery_Without_GeoFencing_NotDelivered() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset45");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite10");
            }
            DBLogin_New newdblogin = new DBLogin_New(driver);
            PickedPage_New newpickedPage = new PickedPage_New(driver);
            Delivered_New newdeliveredpage = new Delivered_New(driver);
            ExtentTest childTest1 = parentTest1.createNode("New DB App >> Login Page validation","This test verifies that user is able see Title and MObile No filed text");
            TestListner.extentMap.get().put("child1", childTest1);
            Boolean DBAppLoginScreen = newdblogin.DBLoginScreenData(childTest1,"7836016806");
            ExtentTest childTest2 = parentTest1.createNode("New DB App OTP Screen page ","This test verifies that user is able to Enter OTP and click Verify OTP button");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean NewDbAppOTPScreen= newdblogin.NewDBotpValidationExistngUser(childTest2,testdata);
            ExtentTest childTest4 = parentTest1.createNode("Picked Page >> Not Delivered >> Our Side ","This test verifies that user is able to picked the Order and Mark as Not Delivered Our Side.");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean NewDbAppPickedNotDeliveredOurSideScreen= newpickedPage.NonDeliveredOurSideData(childTest4,testdata);
            ExtentTest childTest6 = parentTest1.createNode("Picked Page >> Not Delivered >> Customer Side >> Stop ","This test verifies that user is able to  to picked the Order and Mark as Not Delivered Customer Reason");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean NewDbAppNOtDeliveredCustomerReasonScreen= newpickedPage.NonDeliveredCustomerSideStopData(childTest6,testdata);
            ExtentTest childTest7 = parentTest1.createNode("Picked Page >> Not Delivered >> Customer Side >> Hold ","This test verifies that user is able to  to picked the Order and Mark as Not Delivered Customer Reason");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean NewDbAppNOtDeliveredCustomerReasonHoldScreen= newpickedPage.NonDeliveredCustomerSideHoldHoldTodayData(childTest7,testdata);
            ExtentTest childTest5 = parentTest1.createNode("Delivered Page ","This test verifies that user is able to view Delivered Details.");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean NewDbAppDeliveredScreen= newdeliveredpage.NewDeliveredFlowData(childTest5,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }
    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New DB App Flow")
    @Story("Story Name: To check SKUPackaging page ")
    @Test(groups = {"production", "RapidSaleMarkDB","Delivered001","SanitySuiteRapid"}, description = "verifying New DB App Flow", priority = 5)
    public void Rapid_Sale_Mark() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset45");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite10");
            }
            DBLogin_New newdblogin = new DBLogin_New(driver);
            DB_Config newassignedpage = new DB_Config(driver);
            PickedPage_New newpickedPage = new PickedPage_New(driver);
            Delivered_New newdeliveredpage = new Delivered_New(driver);
            ExtentTest childTest1 = parentTest1.createNode("New DB App >> Login Page validation","This test verifies that user is able see Title and MObile No filed text");
            TestListner.extentMap.get().put("child1", childTest1);
            newdblogin.DBLoginScreenData(childTest1,WebSuite_Trigger.Delivery_MobileNo);
            ExtentTest childTest2 = parentTest1.createNode("New DB App OTP Screen page ","This test verifies that user is able to Enter OTP and click Verify OTP button");
            TestListner.extentMap.get().put("childTest2", childTest2);
            newdblogin.NewDBotpValidationExistngUser(childTest2,testdata);
            ExtentTest childTest9 = parentTest1.createNode("Assigned Screen ","This test verifies that user is able to scan the product manually.");
            TestListner.extentMap.get().put("childTest3", childTest9);
            newassignedpage.Generic_Delivery(childTest9);
            ExtentTest childTest4 = parentTest1.createNode("Picked Page >> Done","This test verifies that user is able to picked the Order and Delivered");
            TestListner.extentMap.get().put("childTest4", childTest4);
            newpickedPage.PickedFlowData(childTest4);
          //  boolean NewDbAppPickedScreen= newpickedPage.DoneData(childTest4,testdata);
     /*       ExtentTest childTest8 = parentTest1.createNode("Picked Page >> Not Delivered >> Our Side ","This test verifies that user is able to picked the Order and Mark as Not Delivered Our Side.");
            TestListner.extentMap.get().put("childTest8", childTest8);
            boolean NewDbAppPickedNotDeliveredOurSideScreen= newpickedPage.NonDeliveredOurSideData(childTest8,testdata);
            ExtentTest childTest6 = parentTest1.createNode("Picked Page >> Not Delivered >> Customer Side >> Stop ","This test verifies that user is able to  to picked the Order and Mark as Not Delivered Customer Reason");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean NewDbAppNOtDeliveredCustomerReasonScreen= newpickedPage.NonDeliveredCustomerSideStopData(childTest6,testdata);
            ExtentTest childTest7 = parentTest1.createNode("Picked Page >> Not Delivered >> Customer Reason >> Hold ","This test verifies that user is able to  to picked the Order and Mark as Not Delivered Customer Reason");
            TestListner.extentMap.get().put("childTest7", childTest7);
            boolean NewDbAppNOtDeliveredCustomerReasonHoldScreen= newpickedPage.NonDeliveredCustomerSideHoldHoldTodayData(childTest7,testdata);
            ExtentTest childTest5 = parentTest1.createNode("Delivered Page ","This test verifies that user is able to view Delivered Details.");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean NewDbAppDeliveredScreen= newdeliveredpage.NewDeliveredFlowData(childTest5,testdata);

      */
        } catch (Exception e) {
            e.printStackTrace();
            framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }
    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New DB App Flow")
    @Story("Story Name: To check SKUPackaging page ")
    @Test(groups = {"production"}, description = "verifying New DB App Flow")
    public void Regular_Sale_Mark_Done() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset45");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite10");
            }
            DBLogin_New newdblogin = new DBLogin_New(driver);
            Pending_New newpending = new Pending_New(driver);
            DB_Config dbConfig = new DB_Config(driver);
            ExtentTest childTest1 = parentTest1.createNode("New DB App >> Login Page validation","This test verifies that user is able see Title and MObile No filed text");
            TestListner.extentMap.get().put("child1", childTest1);
            newdblogin.DBLoginScreenData(childTest1, "7836016806");
         //   newdblogin.DBLoginScreenData(childTest1, "9515321546");
            ExtentTest childTest2 = parentTest1.createNode("New DB App OTP Screen page ","This test verifies that user is able to Enter OTP and click Verify OTP button");
            TestListner.extentMap.get().put("childTest2", childTest2);
            newdblogin.NewDBotpValidationExistngUser(childTest2,testdata);
            ExtentTest childTest3 = parentTest1.createNode("Pending Page ","This test verifies that user is able sale mark with Done case.");
            TestListner.extentMap.get().put("childTest3", childTest3);
            dbConfig.ChangeRegularDelivery(childTest3);
            newpending.DoneWithComplianceCheckList(childTest3,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }
    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New DB App Flow")
    @Story("Story Name: To check SKUPackaging page ")
    @Test(groups = {"production", "NewDBApp_DWR01","Regular_FlowSuite"}, description = "verifying New DB App Flow", priority = 2)
    public void Regular_Sale_Mark_DonewithRemark() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset51");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite10");
            }
            DBLogin_New newdblogin = new DBLogin_New(driver);
            PickedPage_New newpickedPage = new PickedPage_New(driver);
            Pending_New newpending = new Pending_New(driver);
            ExtentTest childTest1 = parentTest1.createNode("New DB App >> Login Page validation","This test verifies that user is able see Title and MObile No filed text");
            TestListner.extentMap.get().put("child1", childTest1);
            Boolean DBAppLoginScreen = newdblogin.DBLoginScreenData(childTest1,"7836016806");
            ExtentTest childTest2 = parentTest1.createNode("New DB App OTP Screen page ","This test verifies that user is able to Enter OTP and click Verify OTP button");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean NewDbAppOTPScreen= newdblogin.NewDBotpValidationExistngUser(childTest2,testdata);
            ExtentTest childTest3 = parentTest1.createNode("Pending Page ","This test verifies that user is able sale mark with DWR case.");
            TestListner.extentMap.get().put("childTest3", childTest3);
            boolean NewDbAppPending_DoneScreen= newpending.DoneWithRemark_WithComplianceCheckList(childTest3,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            framework.logErrorWithSnapshotApp(driver, e);
        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New DB App Flow")
    @Story("Story Name: To check SKUPackaging page ")
    @Test(groups = {"production", "Daily_Dairy", "Regular_FlowSuite","Regression","Product_Offer"}, description = "verifying New DB App Flow", priority = 7)
    public void Marking_Delivery_For_Regular_Dairy() throws IOException, InterruptedException {
        Regular_Sale_Mark_Done();
    }
    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New DB App Flow")
    @Story("Story Name: To check SKUPackaging page ")
    @Test(groups = {"production","Daily_FNV", "Regression","Subscription_Offer"}, description = "verifying New DB App Flow",priority = 12)
    public void Marking_Delivery_For_Regular_FNV_Sub_offer() throws IOException, InterruptedException {
        Regular_Sale_Mark_Done();
    }


    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New DB App Flow")
    @Story("Story Name: To check SKUPackaging page ")
    @Test(groups = {"production","Daily_Mix", "Regression"}, description = "verifying New DB App Flow",priority = 15)
    public void Marking_Delivery_For_Regular_Mix() throws IOException, InterruptedException {
        Regular_Sale_Mark_Done();
    }

    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New DB App Flow")
    @Story("Story Name: To check SKUPackaging page ")
    @Test(groups = {"production","Rapid","Dairy","Regression"}, description = "verifying New DB App Flow", priority = 22)
    public void Marking_Delivery_For_Dairy_Rapid() throws IOException, InterruptedException {
        Rapid_Sale_Mark();
    }
    @JiraPolicy(logTicketReady = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New DB App Flow")
    @Story("Story Name: To check SKUPackaging page ")
    @Test(groups = {"production","Rapid","FNV","Regression"}, description = "verifying New DB App Flow",priority = 17)
    public void Marking_Delivery_For_FNV_Rapid() throws IOException, InterruptedException {
        Rapid_Sale_Mark();
    }

     @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Regression", "Recharge_Offer_Cashback","Recharge_Offer"}, description = "verifying Recharge Offer Cashback",priority = 1)
    public void Recharge_Offer_Cashback() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mHomePageData(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("Recharge Cashback validation from Payment page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            mhomePage.mWalletVerification_Recharge_Offer_Cashback(childTest7,testdata);

            ExtentTest childTest8 = parentTest1.createNode("Recharge Cashback validation from Regular Order page", "This test verifies that user is able to verify Footer section  Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            mProductPage.DairyProductsVerificationwithSearch(childTest8, testdata);

            ExtentTest childTest9= parentTest1.createNode("MHomePage Rapid validation page ", "This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            mProductPage.PlaceOrder_Button_Click(childTest9);

            ExtentTest childTest10 = parentTest1.createNode("Recharge Cashback validation from Payment page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest10", childTest10);
            mhomePage.Recharge_Offer_from_Wallet_Screen(childTest10,testdata);

            ExtentTest childTest11 = parentTest1.createNode("Recharge Cashback validation from Payment page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest11", childTest11);
            mhomePage.BackButton(childTest11);

            ExtentTest childTest12 = parentTest1.createNode("MHomePage Rapid validation page ","This test verifies that user is able to verify Rapid HomePage Successfully");
            //  childTest5.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest12", childTest12);
            boolean IsHomeVeried = mhomePage.mHomePageRapidSelection(childTest12);

            ExtentTest childTest14 = parentTest1.createNode("MHomePage Rapid Product Add","This test verifies that user is able to verify Rapid HomePage Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest14", childTest14);
                boolean IsrapidprodcutVeried = mProductPage.rapidProductList_Search_OT(childTest14, testdata);

            ExtentTest childTest15= parentTest1.createNode("MHomePage Rapid Placed Order ","This test verifies that user is able to verify Rapid HomePage Successfully");
            // childTest8.setDescription("This test verifies that user is able to verify Rapid HomePage Successfully");
            TestListner.extentMap.get().put("childTest15", childTest15);
            boolean IsproceedButtonClick = mProductPage.Proceed_Button_Click(childTest15);

            ExtentTest childTest16 = parentTest1.createNode("Recharge Cashback validation from Payment page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest16", childTest16);
            mhomePage.Recharge_Offer_from_Wallet_Screen(childTest16,testdata);
/*
            ExtentTest childTest9 = parentTest1.createNode("MproductPage validation page ", "This test verifies that user is able to verify Products  Successfully");
            //childTest9.setDescription("This test verifies that user is able to verify Products  Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
           // boolean IsfProductVeried = mProductPage.navigateToL1CategoryList(childTest9);

*/
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }


    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Regression","Recharge_Offer_Product","Recharge_Offer"}, description = "verifying Recharge Offer Product",priority = 2)
    public void Recharge_Offer_Product() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mHomePageData(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("Recharge Cashback validation from Payment page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            mhomePage.mWalletVerification_Recharge_Offer_Product(childTest7,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Local111"}, description = "verifying Recharge Offer Product")
    public void Recharge_Offer_Product_Combined_Screen() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mHomePageData(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest7, testdata);

            ExtentTest childTest8 = parentTest1.createNode("Recharge Cashback validation from Payment page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            mhomePage.mWalletVerification_Recharge_Offer_Product_Combined_Screen(childTest8,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Local111"}, description = "verifying Recharge Offer Product")
    public void Recharge_Offer_Product_Old_Payment_Screen() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mHomePageData(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest7, testdata);

            ExtentTest childTest8 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            mhomePage.mWalletVerification_Recharge(childTest8);

            ExtentTest childTest9 = parentTest1.createNode("Recharge Cashback validation from Payment page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            mhomePage.mWalletVerification_Recharge_Offer_Product_Combined_Screen(childTest9,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Local111"}, description = "verifying Recharge Offer Membership")
    public void Recharge_Offer_Membership_Separate_Payment_Screen() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification_Skip(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mHomePageData(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("Recharge Cashback validation from Payment page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            mhomePage.mWalletVerification_Recharge_Offer_Membership_Separate_Screen(childTest7,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Local1"}, description = "verifying Recharge Offer Membership")
    public void Recharge_Offer_Membership_Combined_Payment_Screen() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification_Skip(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mHomePageData(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest7, testdata);

            ExtentTest childTest8 = parentTest1.createNode("Recharge Cashback validation from Payment page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest8", childTest7);
            mhomePage.mWalletVerification_Recharge_Offer_Membership(childTest8,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Local1"}, description = "verifying Recharge Offer Membership")
    public void Recharge_Offer_Membership_Old_Payment_Screen() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification_Skip(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mHomePageData(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            boolean IswalletVeried = mhomePage.mWalletVerificationWithPayment_Netbanking(childTest7, testdata);

            ExtentTest childTest8 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            //boolean IswalletVeried= mhomePage.mWalletVerification(childTest6);
            mhomePage.mWalletVerification_Recharge(childTest8);

            ExtentTest childTest9 = parentTest1.createNode("Recharge Cashback validation from Payment page ", "This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            mhomePage.mWalletVerification_Recharge_Offer_Membership(childTest9,testdata);
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Regression","Membership_Offer"}, description = "verifying CD New User Flow")
    public void Membership_offer_check() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MyVipMembership myVipMembership = new MyVipMembership(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            mloginscreen.mLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            mloginscreen.enterAddress(childTest3,testdata);

            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            TestListner.extentMap.get().put("childTest4", childTest4);
            mhomePage.trailMembershipVerification_Skip(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            mhomePage.mHomePageData(childTest6);

            ExtentTest childTest7 = parentTest1.createNode("Membership validation page ","This test verifies that user is able verify Membership Page Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            myVipMembership.newUserVipMembership(childTest7);

            ExtentTest childTest8 = parentTest1.createNode("Membership Plans page ","This test verifies that user is able verify membership plans Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
            myVipMembership.newUserVipMembershipPlanPage(childTest8);

            ExtentTest childTest9 = parentTest1.createNode("Membership coupon code page ","This test verifies that user is able verify membership coupon code plans Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
            myVipMembership.vipMemebershipPlanHavecouponcode(childTest9);

/*
            ExtentTest childTest8 = parentTest1.createNode("MHomePage Footer validation page ", "This test verifies that user is able to verify Footer section  Successfully");
            //childTest8.setDescription("This test verifies that user is able to verify Footer section  Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
         //   boolean IsfooterVeried = mhomePage.mfooterVerfication(childTest8, testdata);

            ExtentTest childTest9 = parentTest1.createNode("MproductPage validation page ", "This test verifies that user is able to verify Products  Successfully");
            //childTest9.setDescription("This test verifies that user is able to verify Products  Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
           // boolean IsfProductVeried = mProductPage.navigateToL1CategoryList(childTest9);

*/
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify New User Flow")
    @Story("Story Name: To check login page title")
    @Test(groups = {"Demo"}, description = "verifying CD New User Flow")
    public void App_new_User_Login_FLow_Demo() throws IOException, InterruptedException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + nameofCurrMethod);
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset2");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite1");
            }
            MLoginScreen mloginscreen = new MLoginScreen(driver);
            MHomePage mhomePage = new MHomePage(driver);
            MCategory_PlpPage mProductPage = new MCategory_PlpPage(driver);

            ExtentTest childTest1 = parentTest1.createNode("mloginscreen page ", "This test verifies that user is able to verify login page content");
            //  childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = mloginscreen.mLoginScreenData_Prod(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = parentTest1.createNode("Otp validation page ", "This test verifies that user is able enter OTP Successfully");
            //  childTest1.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = mloginscreen.otpValidationNew(childTest2);

            ExtentTest childTest3 = parentTest1.createNode("Address validation page ", "This test verifies that user is able to enter Address  Successfully");
            //   childTest3.setDescription("This test verifies that user is able to enter Address  Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            boolean IsAddressVeried= mloginscreen.enterAddress(childTest3,testdata);

            //  driver.navigate().back();


            ExtentTest childTest4 = parentTest1.createNode("Trial Membership validation page ", "This test verifies that user is able to verify Purchase Trial Membership");
            //childTest4.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IsHomememberVeried = mhomePage.trailMembershipVerification(childTest4,testdata);

            ExtentTest childTest5 = parentTest1.createNode("Referral Code Drawer validation page ", "This test verifies that user is able to Skip Refrell Address  Successfully");
            // childTest4.setDescription("This test verifies that user is able to Skip Refrell Address  Successfully");
            TestListner.extentMap.get().put("childTest5", childTest5);
            boolean IsSkipVeried= mloginscreen.skipButtonFunctional(childTest5);

            ExtentTest childTest6 = parentTest1.createNode("Mini HomePage validation page ", "This test verifies that user is able to verify HomePage Successfully");
            //childTest5.setDescription("This test verifies that user is able to verify HomePage Successfully");
            TestListner.extentMap.get().put("childTest6", childTest6);
            boolean IsHomeVeried = mhomePage.mHomePageData_NoValidation(childTest6);



            ExtentTest childTest7 = parentTest1.createNode("MHomePage wallet validation page ", "This test verifies that user is able to verify wallet  Successfully");
            // childTest7.setDescription("This test verifies that user is able to verify wallet  Successfully");
            TestListner.extentMap.get().put("childTest7", childTest7);
            //  boolean IswalletVeried = mhomePage.mWalletVerification(childTest7);
            //   mhomePage.MoreAddress(childTest7);
            boolean IswalletVeried= mhomePage.Wallet_Recharge_No_Validation(childTest7,testdata);

/*
            ExtentTest childTest8 = parentTest1.createNode("MHomePage Footer validation page ", "This test verifies that user is able to verify Footer section  Successfully");
            //childTest8.setDescription("This test verifies that user is able to verify Footer section  Successfully");
            TestListner.extentMap.get().put("childTest8", childTest8);
         //   boolean IsfooterVeried = mhomePage.mfooterVerfication(childTest8, testdata);

            ExtentTest childTest9 = parentTest1.createNode("MproductPage validation page ", "This test verifies that user is able to verify Products  Successfully");
            //childTest9.setDescription("This test verifies that user is able to verify Products  Successfully");
            TestListner.extentMap.get().put("childTest9", childTest9);
           // boolean IsfProductVeried = mProductPage.navigateToL1CategoryList(childTest9);

*/
        } catch (Exception e) {
            e.printStackTrace();
            // framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }
}



/*

    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify sale mark functionality")
    @Story("Story Name: To check sale mark functionality")
    @Test(groups = {"production", "suraj12"}, description = "verifying CD Delivery sale mark with Done and DWR Flow", priority = 0)
    public void DBApp_SaleMarkwithDeliveredFLow() throws IOException, InterruptedException {
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset7");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite4");
            }

            DBLoginScreen dbloginscreen = new DBLoginScreen(driver);
            //    DBHomePage dbhomepage = new DBHomePage(driver);
            //    DrawerScreen drawerscreen = new DrawerScreen(driver);
            Delivered delivered = new Delivered(driver);

            ExtentTest childTest1 = testListener.startChild("DB App login Screen page ");
            childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = dbloginscreen.DBLoginScreenData(childTest1, testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = testListener.startChild("Otp validation page ");
            childTest2.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified = dbloginscreen.otpValidationExistngUser(childTest2);

            ExtentTest childTest3 = testListener.startChild("Sale mark with Done page ");
            childTest3.setDescription("This test verifies that DB user is able to sale mark with Done Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
            boolean IsSalemarkedwithDone = delivered.salemarkwithDone(childTest3);

            ExtentTest childTest4 = testListener.startChild("Sale mark with DWR page ");
            childTest3.setDescription("This test verifies that DB user is able to sale mark with DWR Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IsSalemarkedwithDWR = delivered.salemarkwithDWRFlow(childTest4);


        } catch (Exception e) {
            e.printStackTrace();
            framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }
   }



/*
    @JiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Not delivered  functionality")
    @Story("Story Name: To check Not delivered functionality")
    @Test(groups = {"production", "suraj12"}, description = "verifying CD Delivery Not delivered with Our side and Customer side Flow", priority = 2)
    public void DBApp_SaleMarkwithNonDeliveredFLow() throws IOException, InterruptedException {
        try {
            AccountData testdata = framework.getData(AccountData.class, "loginset7");
            Framework framework = new Framework();
            if (CommonConstant.Platfrom_name == "IOS") {
                driver = framework.getIOSDriver();
            } else {
                driver = framework.getAppDevice("demosite4");
            }

            DBLoginScreen dbloginscreen = new DBLoginScreen(driver);
            //    DBHomePage dbhomepage = new DBHomePage(driver);
            //    DrawerScreen drawerscreen = new DrawerScreen(driver);

                   NotDelivered nondelivered = new   NotDelivered(driver);

            ExtentTest childTest1 = testListener.startChild("DB App login Screen page ");
            childTest1.setDescription("This test verifies that user is able to verify login page content");
            TestListner.extentMap.get().put("childTest1", childTest1);
            boolean Iloginpagedataverified = dbloginscreen.DBLoginScreenData(childTest1,testdata);
            TestListner.extentMap.get().put("Iloginpagedataverified", childTest1);

            ExtentTest childTest2 = testListener.startChild("Otp validation page ");
            childTest2.setDescription("This test verifies that user is able enter OTP Successfully");
            TestListner.extentMap.get().put("childTest2", childTest2);
            boolean IsOtpverified= dbloginscreen.otpValidationExistngUser(childTest2);
            TestListner.extentMap.get().put("IsOtpverified", childTest2);


            ExtentTest childTest3 = testListener.startChild("DB Not delivered our side page ");
            childTest3.setDescription("This test verifies that user is able to mark not delivered Successfully");
            TestListner.extentMap.get().put("childTest3", childTest3);
             boolean IsNotDeliveredourside= nondelivered.NotDeliveredOurSide(childTest3);
            TestListner.extentMap.get().put("IsNotDeliveredourside", childTest3);

            ExtentTest childTest4 = testListener.startChild("DB Not delivered customer side page ");
            childTest4.setDescription("This test verifies that user is able to mark not delivered Successfully");
            TestListner.extentMap.get().put("childTest4", childTest4);
            boolean IsNotDeliveredcustomerside= nondelivered.NotDeliveredCustomerSide(childTest4);
            TestListner.extentMap.get().put("IsNotDeliveredcustomerside", childTest4);



        } catch (Exception e) {
            e.printStackTrace();
            framework.logErrorWithSnapshotApp(driver, e);

        } finally {
            System.out.println("***********closing the driver*************");
            adb_device.clearDeviceLock();
            System.out.println("***********Release the device*************");
            // driver.resetApp();
            driver.quit();
        }
    }

}
*/







