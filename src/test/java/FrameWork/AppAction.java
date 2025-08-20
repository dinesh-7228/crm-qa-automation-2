package FrameWork;

import Data.AppObjectRepo;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;
import io.appium.java_client.*;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppAction {
    public boolean runStatus;
    public String errorMessage;
    public String ResultMessage;
    public String exceptionBuffer = "";
    public String errorBuffer = "";
    public String failureSeverity;

    Framework framework = new Framework();
SoftAssert Assert = new SoftAssert();
    protected  AppiumDriver<MobileElement> driver;

     //public Connection con;

    static int DefaultTime = 5;
    protected boolean click1(Locator locator) {
        try {
            WebDriverWait webdriverWait = new WebDriverWait(driver, DefaultTime);
            if (locator.getElement() == null) {
                webdriverWait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
                driver.findElement(locator.getBy()).click();
            } else {
                System.out.println(locator.getBy());
                System.out.println(locator.getElement());
                WebElement element = locator.getElement().findElement(locator.getBy());
                webdriverWait.until(ExpectedConditions.elementToBeClickable(element));
                driver.manage().timeouts().implicitlyWait(DefaultTime, TimeUnit.SECONDS);
                element.click();
            }
            TestListner.testing.get().log(Status.INFO, "Clicked On " + locator.getName());
            return true;
        }catch (Exception e){
            TestListner.testing.get().log(Status.INFO, "Not able to click on " + locator.getName());
            return false;
        }
    }

    protected boolean click(Locator locator, ExtentTest extentTest) throws IOException {
        try {
            WebDriverWait webdriverWait = new WebDriverWait(driver, DefaultTime);
            if (locator.getElement() == null) {
                webdriverWait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
                driver.findElement(locator.getBy()).click();
                System.out.println("Clicked On " + locator.getName());
            } else {
                System.out.println(locator.getBy());
                System.out.println(locator.getElement());
                WebElement element = locator.getElement().findElement(locator.getBy());
                webdriverWait.until(ExpectedConditions.elementToBeClickable(element));
                driver.manage().timeouts().implicitlyWait(DefaultTime, TimeUnit.SECONDS);
                element.click();
            }
            extentTest.log(Status.INFO, "Clicked On " + locator.getName());
            return true;
        }catch (Exception e){
            extentTest.log(Status.INFO, "Not able to click on " + locator.getName());
            framework.logErrorWithSnapshotApp_New(driver, e, extentTest);
            return false;
        }
    }

    protected boolean If_display_click(Locator locator, ExtentTest extentTest) throws IOException {
       if(isDisplayed(locator)) {
           try {
               WebDriverWait webdriverWait = new WebDriverWait(driver, DefaultTime);
               if (locator.getElement() == null) {
                   webdriverWait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
                   driver.findElement(locator.getBy()).click();
                   System.out.println("Clicked On " + locator.getName());
               } else {
                   System.out.println(locator.getBy());
                   System.out.println(locator.getElement());
                   WebElement element = locator.getElement().findElement(locator.getBy());
                   webdriverWait.until(ExpectedConditions.elementToBeClickable(element));
                   driver.manage().timeouts().implicitlyWait(DefaultTime, TimeUnit.SECONDS);
                   element.click();
               }
               extentTest.log(Status.INFO, "Clicked On " + locator.getName());
               return true;
           } catch (Exception e) {
               extentTest.log(Status.INFO, "Not able to click on " + locator.getName());
               framework.logErrorWithSnapshotApp_New(driver, e, extentTest);
               return false;
           }
       }
       return false;
    }
    protected boolean click_Prod(Locator locator, ExtentTest extentTest) throws IOException {
            WebDriverWait webdriverWait = new WebDriverWait(driver, DefaultTime);
            if (locator.getElement() == null) {
                webdriverWait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
                driver.findElement(locator.getBy()).click();
                System.out.println("Clicked On " + locator.getName());
            } else {
                System.out.println(locator.getBy());
                System.out.println(locator.getElement());
                WebElement element = locator.getElement().findElement(locator.getBy());
                webdriverWait.until(ExpectedConditions.elementToBeClickable(element));
                driver.manage().timeouts().implicitlyWait(DefaultTime, TimeUnit.SECONDS);
                element.click();
            }
            extentTest.log(Status.INFO, "Clicked On " + locator.getName());
            return true;
    }

    protected boolean waitUntilDisplayed(Locator locator, int Timeout) {
        WebDriverWait webdriverWait = new WebDriverWait(driver, Timeout);
        driver.manage().timeouts().implicitlyWait(Timeout,TimeUnit.SECONDS);
        try {
            if (locator.getElement() == null) {
                webdriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator.getBy()));
            } else {
                System.out.println(locator.getBy());
                System.out.println(locator.getElement());
                WebElement element = locator.getElement().findElement(locator.getBy());
                webdriverWait.until(ExpectedConditions.visibilityOf(element));
            }
            return true;

        }catch(Exception e){
            return false;
        }

        finally {
            driver.manage().timeouts().implicitlyWait(DefaultTime, TimeUnit.SECONDS);
        }
    }
    //   WebElement TVprod = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='BUY NOW']"));
//                Thread.sleep(15000);
//                Actions TVaction = new Actions(driver);
//                TVaction.moveToElement(TVprod).build().perform();
    protected void Action(Locator locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator.getBy())).build().perform();

    }

    protected void Javascript(Locator locator){

        JavascriptExecutor js = driver;
        js.executeScript("arguments[0].click();", driver.findElement(locator.getBy()));
    }



    protected void EnterValue1(Locator locator, String value) {
        try {
            WebDriverWait webdriverWait = new WebDriverWait(driver, 60);
            //webdriverWait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
            driver.findElement(locator.getBy()).sendKeys(value);
            Reporter.log("Entered value  '" + value + "' in '" + locator.getName() + "'", true);
            TestListner.testing.get().log(Status.INFO, "Entered value  '" + value + "' in '" + locator.getName() + "'");
        }catch (Exception e){
            TestListner.testing.get().log(Status.INFO, "Not able to Entered value in" + locator.getName() + "'");
        }
    }

    protected void EnterValue(Locator locator, String value, ExtentTest extentTest) throws IOException {
        try {
            WebDriverWait webdriverWait = new WebDriverWait(driver, 60);
            //webdriverWait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
            driver.findElement(locator.getBy()).sendKeys(value);
            Reporter.log("Entered value  '" + value + "' in '" + locator.getName() + "'", true);
            extentTest.log(Status.INFO, "Entered value  '" + value + "' in '" + locator.getName() + "'");
        }catch (Exception e){
            extentTest.log(Status.INFO, "Not able to Entered value in" + locator.getName() + "'");
            framework.logErrorWithSnapshotApp_New(driver, e, extentTest);
        }
    }

    protected void EnterValueAndClick(Locator locator,String value, ExtentTest extentTest) throws IOException {
        try {
            WebDriverWait webdriverWait = new WebDriverWait(driver, 60);

            webdriverWait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
            if (locator.getElement() == null) {
                driver.findElement(locator.getBy()).sendKeys(value);
            } else {
                locator.getElement().findElement(locator.getBy()).sendKeys(value);
            }
            EnterKey(locator);
          //  driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
           // driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
            Reporter.log("Entered value  '" + value + "' in '" + locator.getName() + "'", true);
            extentTest.log(Status.INFO, "Entered value  '" + value + "' in '" + locator.getName() + "'");
           // TestListner.testing.get().log(Status.INFO, "Entered value  '" + value + "' in '" + locator.getName() + "'");
        }catch (Exception e){
            extentTest.log(Status.INFO, "Not able to Entered value in" + locator.getName() + "'");
            framework.logErrorWithSnapshotApp_New(driver, e, extentTest);
        }
    }

    protected void EnterValuewithAction(Locator locator, String value, ExtentTest extentTest) {
        WebDriverWait webdriverWait = new WebDriverWait(driver, 60);
        Actions s = new Actions(driver);
        s.sendKeys(value);
        s.sendKeys(Keys.ENTER);
        s.perform();

        Reporter.log("Entered value  '" + value + "' in '" + locator.getName() + "'", true);
        extentTest.log(Status.INFO, "Entered value  '" + value + "' in '" + locator.getName() + "'");
    }

    protected void ClearValue(Locator locator) {

        WebDriverWait webdriverWait = new WebDriverWait(driver, 60);

        webdriverWait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
        if(locator.getElement()==null) {
            driver.findElement(locator.getBy()).clear();
            // driver.findElement(locator.getBy()).sendKeys(Keys.DELETE);
        }else{
            locator.getElement().findElement(locator.getBy()).clear();
        }
    }

    protected void DeleteText(Locator locator) {

        WebDriverWait webdriverWait = new WebDriverWait(driver, 60);

        webdriverWait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
        if(locator.getElement()==null) {

            driver.findElement(locator.getBy()).sendKeys(Keys.DELETE);

        }else{
            driver.findElement(locator.getBy()).sendKeys(Keys.DELETE);
        }
    }

    protected String getText(Locator locator){
        String Text = "No data";
        try {
            WebDriverWait wait = new WebDriverWait(driver, DefaultTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator.getBy()));
            if(locator.getElement()==null) {
                WebElement webElement = driver.findElement(locator.getBy());
                Text = webElement.getText();
                System.out.println("*** Data is ** == >> " + Text);
            }else{
                WebElement webElement = locator.getElement().findElement(locator.getBy());
                Text = webElement.getText();
                System.out.println("*** Data is ** == >> " + Text);
            }
            return Text;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Text is Not present in " + locator.getName());
          //  e.printStackTrace();
        }
        return Text;
    }
    public boolean VerifyTextPresent(ExtentTest extentTest, Locator locator, String text) {
        System.out.println("String Passed: "+text);
        String strText = text.toLowerCase();
        String presentText;
        try {
            // System.out.println(driver.findElement(By.xpath(xpathKey)).getText().toLowerCase());
            if (locator != null) {
                 presentText = driver.findElement(locator.getBy()).getText().toLowerCase();
                System.out.println("String from locator: "+presentText);
              //  Assert.assertTrue(presentText.contains(strText));
            } else {
                 presentText = driver.findElement(By.xpath("//body")).getText().toLowerCase();
               // Assert.assertTrue(presentText.contains(strText));
            }
            BooleanAsseration(presentText.contains(strText),extentTest, "Text is present", "Text is not Present");
        } catch (Exception e) { e.printStackTrace();
        } catch (AssertionError e) {
            e.printStackTrace();
        }return true;
    }

//    public boolean SearchItemandCLick(ExtentTest extentTest,Locator locator, String text) {
//        System.out.println("String Passed: "+text);
//        String strText = text.toLowerCase();
//        String presentText;
//        try {
//            // System.out.println(driver.findElement(By.xpath(xpathKey)).getText().toLowerCase());
//            if (locator != null) {
//                presentText = driver.findElement(locator.getBy()).getText().toLowerCase();
//                System.out.println("String from locator: "+presentText);
//                EnterValue(GetLocator("locator"));
//                //  Assert.assertTrue(presentText.contains(strText));
//            } else {
//                presentText = driver.findElement(By.xpath("//body")).getText().toLowerCase();
//                // Assert.assertTrue(presentText.contains(strText));
//            }
//            BooleanAsseration(presentText.contains(strText),extentTest, "Text is present", "Text is not Present");
//        } catch (Exception e) { e.printStackTrace();
//        } catch (AssertionError e) {
//            e.printStackTrace();
//        }return true;
//    }

    protected List<String> getMultipleText(Locator locator){
        List<String> Text= new ArrayList<String>();
        try {
            WebDriverWait wait = new WebDriverWait(driver, DefaultTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator.getBy()));
            if(locator.getElement()==null) {
                List<MobileElement> webElement = driver.findElements(locator.getBy());
                for (MobileElement element:webElement) {
                   System.out.println("Item list === >> " + Text.add(element.getText()));
                }

            }else{
              //  List<MobileElement> webElement = locator.getElement().findElements(locator.getBy());
//                List<MobileElement> webElement = locator.getElement().findElements(locator.getBy());
//                for (MobileElement element: webElement) {
//                    Text.add(element.getText());
//                }
            }
            return Text;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Text;
    }


    public boolean getElementList(Locator locator) throws Exception {
        List<MobileElement> SizeDropDownOptions = driver.findElements(locator.getBy());
        System.out.println(SizeDropDownOptions.size());
        for (MobileElement mElement : SizeDropDownOptions) {
            System.out.println("**** Available List **** "+ mElement.getText());

                    }return true;
    }

    public boolean SelectALL(Locator locator) throws Exception {
        List<MobileElement> SizeDropDownOptions = driver.findElements(locator.getBy());
        System.out.println(SizeDropDownOptions.size());
        for (MobileElement mElement : SizeDropDownOptions) {
            mElement.click();

        }return true;
    }

    //List<MobileElement> allCheckBoxes=driver.findElementsByXPath("//*[@class='android.widget.CheckBox']");
    public void VerifyAlert(String text) {
        try {

            if (text != "") {
                WebDriverWait wait = new WebDriverWait(driver, 2);
                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                String presentText = alert.getText();
                alert.accept();
                Assert.assertTrue(presentText.contains(text));

            } else {
                runStatus = false;
                errorMessage = errorMessage + "\n\n" + "Object xpath or id not found in excel";
            }
        } catch (Exception e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n" + "Object not found to perform Verify Alert operation, " + text
                    + ", Page URL -" + driver.getCurrentUrl();
            failureSeverity = "P1";
            exceptionBuffer = e.getMessage();
            e.printStackTrace();
        } catch (AssertionError e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n" + "Verify Alert failed, Text to verify - " + text + ", Xpath - " + text
                    + ", Page URL -" + driver.getCurrentUrl();
            failureSeverity = "P3";
            errorBuffer = e.getMessage();
            e.printStackTrace();
        }
    }


    protected boolean isDisplayed(Locator locator){

        WebDriverWait webdriverWait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        try {
            if (locator.getElement() == null) {
                webdriverWait.until(ExpectedConditions.presenceOfElementLocated(locator.getBy()));
                driver.findElement(locator.getBy()).isDisplayed();
            } else {
                System.out.println(locator.getBy());
                System.out.println(locator.getElement());
                WebElement element = locator.getElement().findElement(locator.getBy());
                webdriverWait.until(ExpectedConditions.elementToBeClickable(element));
            }
            return true;

        }catch(Exception e){
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(DefaultTime, TimeUnit.SECONDS);
        }
    }



    public void bringElementIntoViewUp(Locator locator, int ScrollCount){
        Dimension dimensions = driver.manage().window().getSize();

//    System.out.println(dimensions);

        Double screenHeightStart = dimensions.getHeight() * 0.9;

        int scrollStart = screenHeightStart.intValue();

        Double screenHeightEnd = dimensions.getHeight() * 0.4;

        int scrollEnd = screenHeightEnd.intValue();
        int i = 1;
        while (!waitUntilDisplayed(locator, 3)) {
            TouchAction ta = new TouchAction(driver);
            ta.moveTo(PointOption.point(scrollStart, scrollEnd)).perform().release();
            /*driver.swipe(0, scrollEnd, 0, scrollStart, 1000);
             /i++;
            if (i >= ScrollCount) {
                if(!locator.getName().contains("XYZZZ")) {
                    //TestListner.testing.get().log(Status.WARNING, "Not Able To Find " + locator.getName() + ".");
                    Reporter.log("Not Able To Find " + locator.getName() + ".", true);
                }
            }
        }

        if(i>=2) {
            TestListner.testing.get().log(Status.INFO, "Scrolled " + locator.getName() + " into view.");
            Reporter.log("Scrolled " + locator.getName() + " into view.", true);
        }*/
        }
    }



    public boolean bringElementIntoViewDown(Locator locator, int ScrollCount, ExtentTest extentTest) throws InterruptedException, IllegalAccessException, InstantiationException {
        Dimension dimensions = driver.manage().window().getSize();
        int size = dimensions.width/2;
        int scrollStartt = (int) (dimensions.getHeight() * 0.9);
        int scrollEnd = (int)(dimensions.getHeight() * 0.25);
        int i = 1;
        while (!waitUntilDisplayed(locator, 3)) {
            TouchAction ta = new TouchAction(driver);
            ta.press(PointOption.point(size, scrollStartt)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(size, scrollEnd)).release().perform();
            if (i >= ScrollCount) {
                if(!locator.getName().contains("XYZZ")) {
                    Reporter.log("Not Able To Find " + locator.getName() + ".", true);
                }
                return false;
            }
            i++;
        }
        if(i>=1) {
            extentTest.log(Status.INFO, "Scrolled " + locator.getName() + " into view.");
            Reporter.log("Scrolled " + locator.getName() + " into view.", true);

        }
        return true;
    }

    public void ScrollDown(int ScrollCount) {
        Dimension dimensions = driver.manage().window().getSize();
        int size = dimensions.width/4;
        int scrollStartt = (int) (dimensions.getHeight() * 0.9);
        int scrollEnd = (int)(dimensions.getHeight() * 0.25);
        for (int x = 1; x <= ScrollCount; x++) {
            TouchAction ta = new TouchAction(driver);
            ta.press(PointOption.point(size, scrollStartt)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(size, scrollEnd)).release().perform();
        }
    }
    public void ScrollUp(int ScrollCount) {
        Dimension dimensions = driver.manage().window().getSize();
        int size = dimensions.width/4;
        int scrollStartt = (int) (dimensions.getHeight() * 0.25);
        int scrollEnd = (int)(dimensions.getHeight() * 0.9);
        for (int x = 1; x <= ScrollCount; x++) {
            TouchAction ta = new TouchAction(driver);
            ta.press(PointOption.point(size, scrollStartt)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(size, scrollEnd)).release().perform();
        }
    }


    public void HorizontalScroll(Locator locator, Locator TillLocator){
       List<MobileElement> options = driver.findElements(locator.getBy());
       MobileElement firstelement = options.get(0);
       MobileElement thirdElement = options.get(1);
        int midOfY =thirdElement.getLocation().y +(thirdElement.getSize().height/2);
        int fromXLocation=thirdElement.getLocation().x;
        int toXLocation=firstelement.getLocation().x;
        TouchAction  action =new TouchAction(driver);
        do{
            action.press(PointOption.point(fromXLocation, midOfY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(PointOption.point(toXLocation, midOfY)).release().perform();
        }while (!(waitUntilDisplayed(TillLocator,3)));
    }

    public Locator GetLocator(String object_Name) {
        Framework framework = new Framework();
        try {
            AppObjectRepo locatordata = framework.getOR(AppObjectRepo.class, object_Name);
           if (locatordata.getlocator_type().equals("id")) {
               return new Locator(By.id(locatordata.getlocator_value()), locatordata.getlocator_name_for_reporting());
           } else {
               return new Locator(By.xpath(locatordata.getlocator_value()), locatordata.getlocator_name_for_reporting());
           }
       }catch (Exception e){
            TestListner.testing.get().log(Status.INFO, object_Name + " Not display  in the UI" );
            return null;
       }
    }
    public void BooleanAsseration(Boolean condition, ExtentTest extentTest, String pass, String fail){
        if(condition){
            extentTest.log(Status.PASS, pass);
        }else {
            extentTest.log(Status.FAIL, fail);
        }
    }

    public String  getCustomerId(String customernameId1) {
        Integer start = 0;
        for (int i = 0; i < customernameId1.length(); i++) {
            if (customernameId1.charAt(i) == '(') {
                start = i + 1;
            }
        }
        String customerId = customernameId1.substring(start, customernameId1.length() - 1);
        return customerId;
    }
    public void completePackaging(Locator locator1, Locator locator2, Locator locator3, Locator locator4, Locator locator5, Locator locator6) {

        // Click on the edit icon
        driver.findElement(locator1.getBy()).click();

        // Flag to indicate if there are more dropdown options
        boolean moreOptions = true;

        while (moreOptions) {

            // Click on the select product field to display the dropdown
            driver.findElement(locator2.getBy()).click();

            // Retrieve the size of the product dropdown list
            List<MobileElement> productOptions = driver.findElements(locator3.getBy());

            System.out.println("Total List Count: " + productOptions.size());

            int productDropdownSize = productOptions.size() - 1;

            // Check if there are more dropdown options
            if (productDropdownSize > 0) {

                // Select the first option from the product dropdown
                MobileElement productOption = productOptions.get(1);

                productOption.click();

                // Enter the weight value
String fullText = driver.findElement(locator6.getBy()).getText();

                if(!(fullText.contains("pkt"))){
                    //  Extract the numerical value from the text
                    String numericalValue = fullText.replaceAll("[^0-9]", "");  // Remove non-digit characters

                    driver.findElement(locator4.getBy()).sendKeys(numericalValue);
                }

          //   driver.findElement(locator4.getBy()).sendKeys("200");

                // Click on the submit button
                driver.findElement(locator5.getBy()).click();

            } else {

                // No more dropdown options, exit the loop
                moreOptions = false;
            }

            // Break the loop if there is only one dropdown option
            if (productDropdownSize == 0) {
                break;
            }

            // Click on the edit icon again for the next iteration
            driver.findElement(locator1.getBy()).click();

        }
    }

    public void completePackaging_New(Locator locator1, Locator locator2, Locator locator3, Locator locator5) {

        // Click on the edit icon
        driver.findElement(locator1.getBy()).click();

        // Flag to indicate if there are more dropdown options
        boolean moreOptions = true;

        while (moreOptions) {

            // Click on the select product field to display the dropdown
            driver.findElement(locator2.getBy()).click();

            // Retrieve the size of the product dropdown list
            List<MobileElement> productOptions = driver.findElements(locator3.getBy());

            System.out.println("Total List Count: " + productOptions.size());

            int productDropdownSize = productOptions.size() - 1;

            // Check if there are more dropdown options
            if (productDropdownSize > 0) {

                // Select the first option from the product dropdown
                MobileElement productOption = productOptions.get(1);

                productOption.click();

                // Enter the weight value

                // Click on the submit button
                driver.findElement(locator5.getBy()).click();

            } else {

                // No more dropdown options, exit the loop
                moreOptions = false;
            }

            // Break the loop if there is only one dropdown option
            if (productDropdownSize == 0) {
                break;
            }

            // Click on the edit icon again for the next iteration
            driver.findElement(locator1.getBy()).click();

        }
    }

    public void PartialPackaging(Locator locator1, Locator locator2, Locator locator3, Locator locator4, Locator locator5, Locator locator6) {

        // Click on the edit icon
        driver.findElement(locator1.getBy()).click();

        // Flag to indicate if there are more dropdown options
        boolean moreOptions = true;

        while (moreOptions) {

            // Click on the select product field to display the dropdown
            driver.findElement(locator2.getBy()).click();

            // Retrieve the size of the product dropdown list
            List<MobileElement> productOptions = driver.findElements(locator3.getBy());

            System.out.println("Total List Count: " + productOptions.size());

            int productDropdownSize = productOptions.size() - 1;

            // Check if there are more dropdown options
            if (productDropdownSize > 0) {

                // Select the first option from the product dropdown
                MobileElement productOption = productOptions.get(1);

                productOption.click();

                // Enter the weight value
                String fullText = driver.findElement(locator6.getBy()).getText();

                //  Extract the numerical value from the text
                String numericalValue = fullText.replaceAll("[^0-9]", "");  // Remove non-digit characters

                // Convert the numerical value to an integer
                int value = Integer.parseInt(numericalValue);

                // Subtract the desired value (e.g., 5 or 10)
                int subtractedValue = value - 5; // or value - 10

                // Convert the subtracted value back to a string
                String subtractedValueString = Integer.toString(subtractedValue);

                // Enter the subtracted value into the input field
                driver.findElement(locator4.getBy()).sendKeys(subtractedValueString);

                // Click on the submit button
                driver.findElement(locator5.getBy()).click();

            } else {

                // No more dropdown options, exit the loop
                moreOptions = false;
            }

            // Break the loop if there is only one dropdown option
            if (productDropdownSize == 0) {
                break;
            }

            // Click on the edit icon again for the next iteration
            driver.findElement(locator1.getBy()).click();

        }
    }
    public void FullyOutOfStockPackaging(Locator locator1, Locator locator2, Locator locator3, Locator locator4, Locator locator5) {

        // Click on the edit icon
        driver.findElement(locator1.getBy()).click();

        // Flag to indicate if there are more dropdown options
        boolean moreOptions = true;

        while (moreOptions) {

            // Click on the select product field to display the dropdown
            driver.findElement(locator2.getBy()).click();

            // Retrieve the size of the product dropdown list
            List<MobileElement> productOptions = driver.findElements(locator3.getBy());

            System.out.println("Total List Count: " + productOptions.size());

            int productDropdownSize = productOptions.size() - 1;

            // Check if there are more dropdown options
            if (productDropdownSize > 0) {

                // Select the first option from the product dropdown
                MobileElement productOption = productOptions.get(1);

                productOption.click();

                // Click on the out-of-stock checkbox button
                driver.findElement(locator4.getBy()).click();

                // Click on the submit button
                driver.findElement(locator5.getBy()).click();

            } else {

                // No more dropdown options, exit the loop
                moreOptions = false;
            }

            // Break the loop if there is only one dropdown option
            if (productDropdownSize == 0) {
                break;
            }

            // Click on the edit icon again for the next iteration
            driver.findElement(locator1.getBy()).click();

        }
    }


    protected void AutoScanManually(Locator editIcon, Locator submitBtn, String value) {
        WebDriverWait webdriverWait = new WebDriverWait(driver, DefaultTime);
        int counter = 0;
        int intValue = Integer.parseInt(value);

        while (counter < intValue ) {
            WebElement currentEditIcon = driver.findElement(editIcon.getBy());

            if (currentEditIcon.isDisplayed()) {
                webdriverWait.until(ExpectedConditions.elementToBeClickable(currentEditIcon));
                currentEditIcon.click();

                driver.findElement(submitBtn.getBy()).click();

                // Print debug information to verify if the edit icon and submit button are clicked
                System.out.println("Clicked edit icon and submit button");

                counter++;
            } else {
                break; // Exit the loop if the edit icon is not displayed
            }
        }
    }

    public boolean getElementListandClicked(Locator locator) throws Exception {
        List<MobileElement> SizeDropDownOptions = driver.findElements(locator.getBy());

        System.out.println(SizeDropDownOptions.size());
        if (!SizeDropDownOptions.isEmpty()) {
            // Get the first element from the list
            MobileElement firstDataElement = SizeDropDownOptions.get(0);

            // Click on the last index data
            int lastIndex = SizeDropDownOptions.size() - 1;
            MobileElement lastDataElement = SizeDropDownOptions.get(lastIndex);
            lastDataElement.click();

        }
        return true;
    }

    protected void DropdownSelection(Locator locator, String dropdownvalue){
        MobileElement testDropdown = driver.findElement(locator.getBy());
        Select dropdown = new Select(testDropdown);
        dropdown.selectByValue(dropdownvalue);
    }

    protected void DropdownSelectfromList(Locator ServerList, String dropdownvalue){
        List<MobileElement> testDropdown = driver.findElements(ServerList.getBy());
        for (MobileElement option : testDropdown)
        {
            if (option.getText().equals(dropdownvalue))
            {
                option.click(); // click the desired option
                break;
            }
        }
    }

    public boolean ServerSelection(Locator locator, Locator OKButton, ExtentTest extentTest){
        try {
            String servername;
            if(CommonConstant.Environment()==null){
                servername = "QA Server";
            }else {
                servername = CommonConstant.Environment();
            }
            DropdownSelectfromList(locator, servername);
            ScrollDown(1);
            click(OKButton, extentTest);
            System.out.println(servername + " Selected");
            Thread.sleep(5000);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean ISLocatorDisplayed(Locator locator, ExtentTest extentTest) throws IOException {
        try{
            waitUntilDisplayed(locator, 2);
            driver.findElement(locator.getBy()).isDisplayed();
            extentTest.log(Status.PASS, locator.getName()+" display in UI");
            System.out.println(locator.getName()+" validation success");
            return true;
        }catch (Exception e){
            extentTest.log(Status.WARNING, locator.getName()+" Not display in UI");
           // framework.logErrorWithSnapshotApp_New(driver, e, extentTest);
            System.out.println(locator.getName() + " Not display in UI");
            return false;
        }

    }

    public boolean IsDisplayed(Locator locator){
        try{
            waitUntilDisplayed(locator, 8);
            driver.findElement(locator.getBy()).isDisplayed();
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public void EnterKey(Locator xpath)
    {
        try {
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ENTER).build().perform();
        }
        catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void swipeLeftToRight(int startX, int startY, int endX, int endY) {
        TouchAction  action =new TouchAction(driver);
        action.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(endX, endY)).release().perform();
    }
}