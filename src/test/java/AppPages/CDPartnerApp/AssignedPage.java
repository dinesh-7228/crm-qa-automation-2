package AppPages.CDPartnerApp;

import Data.AccountData;
import FrameWork.AppAction;
//import com.relevantcodes.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.asserts.SoftAssert;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import java.sql.Connection;

public class AssignedPage extends AppAction {

    SoftAssert Assert = new SoftAssert();

    public AssignedPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    Connection con;


    public boolean AssignedFlowData(ExtentTest extentTest, AccountData accountData) throws Exception {

        Boolean pendingDataText = driver.findElement(GetLocator("dbpendingname").getBy()).isDisplayed();
        BooleanAsseration(pendingDataText, extentTest, "pendingData Text on Header is Present", "pendingData Text on Header is Not Present");
        System.out.println("pendingData validation success");
        Boolean clickpendinglink = click(GetLocator("dbpendingname"), extentTest);
        BooleanAsseration(clickpendinglink, extentTest, "pendingData Text on Header is Clickable", "pendingData Text on Header is Not clickable");
        System.out.println("pendingData Text clickable success");

        Boolean customerNametext = driver.findElement(GetLocator("dbpendingname").getBy()).isDisplayed();
        String customerNametext1 = driver.findElement(GetLocator("dbpendingname").getBy()).getText();
        System.out.println("Customer Name text  == >> " + customerNametext1);
        BooleanAsseration(customerNametext, extentTest, "Customer Name Text : " + customerNametext1 + " is Present.", "customerName text is Not Present");

        Boolean Addresstext = driver.findElement(GetLocator("dbaddresstext").getBy()).isDisplayed();
        String Addresstext1 = driver.findElement(GetLocator("dbaddresstext").getBy()).getText();
        System.out.println("Address text  == >> " + Addresstext1);
        BooleanAsseration(Addresstext, extentTest, "Address Text : " + Addresstext1 + " is Present.", "Address text is Not Present");

        //Boolean Distancetext = driver.findElement(GetLocator("dbdistancetext").getBy()).isDisplayed();
        //String Distancetext1 = driver.findElement(GetLocator("dbdistancetext").getBy()).getText();
        //System.out.println("Distance text  == >> " + Distancetext1);
        //BooleanAsseration(Distancetext, extentTest, "Distance Text : " + Distancetext1 + " is Present.", "Distance text is Not Present");

        Boolean packageIDtext = driver.findElement(GetLocator("dbpackaginglabeltext").getBy()).isDisplayed();
        String packageIDtext1 = driver.findElement(GetLocator("dbpackaginglabeltext").getBy()).getText();
        System.out.println("packageID text  == >> " + packageIDtext1);
        BooleanAsseration(packageIDtext, extentTest, "packageID Text : " + packageIDtext1 + " is Present.", "packageID text is Not Present");

        Boolean packageCounttext = driver.findElement(GetLocator("dbpackageIDText").getBy()).isDisplayed();
        String packageCounttext1 = driver.findElement(GetLocator("dbpackageIDText").getBy()).getText();
        System.out.println("packageCount text  == >> " + packageCounttext1);
        BooleanAsseration(packageCounttext, extentTest, "Package Count Text : " + packageCounttext1 + " is Present.", "package Count text is Not Present");

        Boolean BoxCounttext = driver.findElement(GetLocator("dbboxtext").getBy()).isDisplayed();
        String BoxCounttext1 = driver.findElement(GetLocator("dbboxtext").getBy()).getText();
        System.out.println("Box text  == >> " + BoxCounttext1);
        BooleanAsseration(BoxCounttext, extentTest, "Box Count Text : " + BoxCounttext1 + " is Present.", "Box Count text is Not Present");

        Boolean BagCounttext = driver.findElement(GetLocator("dbbagtext").getBy()).isDisplayed();
        String BagCounttext1 = driver.findElement(GetLocator("dbbagtext").getBy()).getText();
        System.out.println("Bag text  == >> " + BagCounttext1);
        BooleanAsseration(BagCounttext, extentTest, "Bag Count Text : " + BagCounttext1 + " is Present.", "Bag Count text is Not Present");

        Thread.sleep(5000);

        Boolean clickpendingslink = click(GetLocator("dbpendingname"), extentTest);


        Boolean scannedBoxtext = driver.findElement(GetLocator("dbboxcounttext").getBy()).isDisplayed();
        String scannedBoxtext1 = driver.findElement(GetLocator("dbboxcounttext").getBy()).getText();
        System.out.println("Box text  == >> " + scannedBoxtext1);
        BooleanAsseration(scannedBoxtext, extentTest, "Box Text : " + scannedBoxtext1 + " is Present.", "Box text is Not Present");

        Thread.sleep(5000);

        // Create a regular expression pattern to match the integer within brackets
        Pattern pattern = Pattern.compile("\\[(\\d+)/(\\d+)\\]");
        Matcher matcher = pattern.matcher(scannedBoxtext1);


        String strNumber = null;
        if (matcher.find()) {
            String numberText = matcher.group(2);
            int number = Integer.parseInt(numberText);
            System.out.println("Number of boxes: " + number);
            strNumber = Integer.toString(number);

        }

        AutoScanManually(GetLocator("qamanualIcon"), GetLocator("qasubmitbutton"), strNumber);
        Thread.sleep(5000);

        Boolean sumbitButtonclick = driver.findElement(GetLocator("qaDonebtn").getBy()).isDisplayed();
        click(GetLocator("qaDonebtn"), extentTest);
        BooleanAsseration(sumbitButtonclick, extentTest, "Submit Button is Present", "Submit Button is Not Present");
        System.out.println("Submit Button is clicked ");
        Thread.sleep(2000);


        return true;

    }
}
