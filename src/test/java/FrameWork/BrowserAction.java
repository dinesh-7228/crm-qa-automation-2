package FrameWork;

import Data.ObjectRepo;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.Status;
import net.sf.cglib.core.Local;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import com.aventstack.extentreports.ExtentTest;

public class BrowserAction {
    SoftAssert Assert = new SoftAssert();
    protected WebDriver driver;
    static int DefaultTime = 60;
    public boolean runStatus;
    public String errorMessage;
    public String ResultMessage;
    public String exceptionBuffer = "";
    public String errorBuffer = "";
    public String failureSeverity;
    public String parentWindow;
    public Integer inputUniqueCount = 1;
    public Integer inputDynamicCount = 1;
    public boolean softAssertIndicator;
    public boolean captureScreenshot;
    public HashMap<Integer, String> mapUniqueInput;
    public HashMap<Integer, String> mapDynamicData;

    Framework framework = new Framework();
    protected void EnterValue1(Locator locator, String value) {
        WebDriverWait webdriverWait = new WebDriverWait(driver, 60);
        //webdriverWait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
        driver.findElement(locator.getBy()).sendKeys(value);
        Reporter.log("Entered value  '" + value + "' in '" + locator.getName() + "'", true);
        TestListner.testing.get().log(Status.INFO, "Entered value  '" + value + "' in '" + locator.getName() + "'");
    }

    protected void EnterValue(Locator locator, String value, ExtentTest extentTest) throws IOException {
        try {
            WebDriverWait webdriverWait = new WebDriverWait(driver, 60);
            ISLocatorDisplayed(locator, extentTest);
            //webdriverWait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
            driver.findElement(locator.getBy()).sendKeys(value);
            Reporter.log("Entered value  '" + value + "' in '" + locator.getName() + "'", true);
            extentTest.log(Status.PASS, "Entered value  '" + value + "' in '" + locator.getName() + "'");
        }catch (Exception e){
            extentTest.log(Status.FAIL, "Not able to Enter value  '" + value + "' in '" + locator.getName() + "'");
            framework.logErrorWithSnapshot_New(driver, e, extentTest);
        }
    }
    protected void ClearandEnterValue(Locator locator, String value) {
        WebDriverWait webdriverWait = new WebDriverWait(driver, 60);
        //webdriverWait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
        clearText(locator);
        driver.findElement(locator.getBy()).sendKeys(value);
        Reporter.log("Entered value  '" + value + "' in '" + locator.getName() + "'", true);
        TestListner.testing.get().log(Status.INFO, "Entered value  '" + value + "' in '" + locator.getName() + "'");
    }

    protected void dateselector_future_date(Locator locator,ExtentTest extentTest) throws IOException, InstantiationException, IllegalAccessException {
        click(locator, extentTest);
        click(GetLocator("Date_Next_month"), extentTest);
        click(GetLocator("Date_Mid"), extentTest);
    }
    protected void dateselector_Past_date(Locator locator,ExtentTest extentTest) throws IOException, InstantiationException, IllegalAccessException {
        click(locator, extentTest);
        click(GetLocator("PreviousMonth"), extentTest);
        click(GetLocator("Date_Mid"), extentTest);
    }
    protected void ClearandEnterValue_New(Locator locator, String value, ExtentTest extentTest) throws IOException {
       try {
           WebDriverWait webdriverWait = new WebDriverWait(driver, 60);
           //webdriverWait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
           clearText(locator);
           driver.findElement(locator.getBy()).sendKeys(value);
           Reporter.log("Entered value  '" + value + "' in '" + locator.getName() + "'", true);
           extentTest.log(Status.INFO, "Entered value  '" + value + "' in '" + locator.getName() + "'");
       }catch (Exception e){
           extentTest.log(Status.FAIL, "Not able to Enter value  '" + value + "' in '" + locator.getName() + "'");
           framework.logErrorWithSnapshot_New(driver, e, extentTest);
       }
    }
    protected boolean waitUntilDisplayed(Locator locator, int Timeout) {
        driver.manage().timeouts().implicitlyWait(Timeout, TimeUnit.SECONDS);
        WebDriverWait ww = new WebDriverWait(driver, Timeout);
        try {
            //   ww.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
            return true;
        } catch (Exception e) {

            return false;
        } finally {
           // driver.manage().timeouts().implicitlyWait(DefaultTime, TimeUnit.SECONDS);
        }
    }

    protected void waitforPageReady() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver browser) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

    }

    protected void click(Locator locator, ExtentTest extentTest) throws InstantiationException, IllegalAccessException, IOException {

       try {
           WebDriverWait webdriverWait = new WebDriverWait(driver, DefaultTime);
           // webdriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator.getBy()));
           driver.findElement(locator.getBy()).click();
           Reporter.log("Clicked On " + locator.getName() + "", true);
           extentTest.log(Status.PASS, "Clicked On " + locator.getName());
       }
       catch(Exception e){
           extentTest.log(Status.FAIL,  locator.getName() + " is Not clicable");
           framework.logErrorWithSnapshot_New(driver, e, extentTest);
       }
    }

    protected void DropdownSelection(Locator locator, String dropdownvalue){
        WebElement testDropdown = driver.findElement(locator.getBy());
        Select dropdown = new Select(testDropdown);
        dropdown.selectByValue(dropdownvalue);
    }

    protected void DropdownSelectfromList(Locator locator, String dropdownvalue){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> testDropdown = driver.findElements(locator.getBy());
        for (WebElement option : testDropdown)
        {
            if (option.getText().contains(dropdownvalue))
            {
                option.click(); // click the desired option
                break;
            }
        }
    }
    protected void DropdownSelectfromMulticheckbox(Locator locator, String dropdownvalue){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> testDropdown = driver.findElements(locator.getBy());
        for (WebElement option : testDropdown)
        {
            if (option.getText().contains(dropdownvalue)){
                String xpath = ((By.ByXPath) locator.getBy()).toString();
                xpath = xpath + "/ancestor::mat-option/mat-pseudo-checkbox";
                xpath = xpath.replace("By.xpath: ", "");
                if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
                    driver.findElement(By.xpath(xpath)).click();
                }
            }
        }
    }

    protected void DropdownSelectfromListextent(Locator locator, String dropdownvalue, ExtentTest extentTest) throws IOException {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            List<WebElement> testDropdown = driver.findElements(locator.getBy());
            for (WebElement option : testDropdown) {
                if (option.getText().contains(dropdownvalue)) {
                    option.click(); // click the desired option
                    break;
                }
            }
            Reporter.log("Select value '" + dropdownvalue + "' from '" + locator.getName() + "'", true);
            extentTest.log(Status.PASS, "Select value  '" + dropdownvalue + "' from '" + locator.getName() + "'");
        }catch (Exception e){
            extentTest.log(Status.FAIL, "Not able to Select value  '" + dropdownvalue + "' from '" + locator.getName() + "'");
            framework.logErrorWithSnapshot_New(driver, e, extentTest);
        }
    }

    protected void DropdownSelectfromList_ByIndex(Locator locator, int i){
        Select drp = new Select(locator.getElement());
        drp.selectByIndex(i);
    }

    public Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
        Map<String, Object> retConvertedMap = new HashMap<String, Object>();

        if (json != JSONObject.NULL) {
            retConvertedMap = toMap(json);
        }
        return retConvertedMap;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while (keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            } else if (JSONObject.NULL.equals(value)){
                value = null;
            }
            map.put(key, value);
        }
        return map;
    }

    public List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            } else if (JSONObject.NULL.equals(value)){
                value = null;
            }
            list.add(value);
        }
        return list;
    }
    public void closePopUp(By byLocator) {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(byLocator).click();

        } catch (Exception e) {
            runStatus = true;
            errorMessage = errorMessage + "\n\n" + ("Not an Error:: Pop up not available to close - " + byLocator
                    + ", Page URL -" + driver.getCurrentUrl());
        }
    }
    protected void mouseHover(Locator locator) throws InstantiationException, IllegalAccessException {
        try {
            Actions actObj = new Actions(driver);

            WebElement element = driver.findElement(locator.getBy());
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            if (driver.findElement(locator.getBy()).isEnabled())
                ;
            WebElement mouseHoverElement = driver.findElement(locator.getBy());
            actObj.moveToElement(mouseHoverElement).perform();

        } catch (Exception e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n" + ("Object not found to perform mouse hover, - " + locator
                    + ", Page URL -" + driver.getCurrentUrl());
            failureSeverity = "P1";
            exceptionBuffer = e.getMessage();
            e.printStackTrace();
        }

    }
    public void GetTextAndWriteToResults(Locator locator) throws InstantiationException, IllegalAccessException {
        WebDriverWait webdriverWait = new WebDriverWait(driver, DefaultTime);
        // webdriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator.getBy()));
        driver.findElement(locator.getBy()).getText();
        Reporter.log("GetText " + locator.getName() + "", true);
        TestListner.testing.get().log(Status.INFO, "GetText " + locator.getName());


    }
    public void VerifyTextPresent(ExtentTest extentTest,Locator locator, String text) {
        System.out.println("String Passed: "+text);
        String strText = text.toLowerCase();
        String presentText;
        try {
            // System.out.println(driver.findElement(By.xpath(xpathKey)).getText().toLowerCase());
            if (locator != null) {
                presentText = driver.findElement(locator.getBy()).getText().toLowerCase();
                System.out.println("String from locator: "+presentText);
                //Assert.assertTrue(presentText.contains(strText));
            } else {
                presentText = driver.findElement(By.xpath("//body")).getText().toLowerCase();
                //Assert.assertTrue(presentText.contains(strText));
            }
            BooleanAsseration(presentText.contains(strText),extentTest, "Text is present", "Text is not Present");

        } catch (Exception e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n" + "Object not found to perform VerifyText operation, - " + locator
                    + ", Page URL -" + driver.getCurrentUrl();
            failureSeverity = "P1";
            exceptionBuffer = e.getMessage();
            e.printStackTrace();
        } catch (AssertionError e) {
            runStatus = true;
            softAssertIndicator = true;
            captureScreenshot = true;
            errorMessage = errorMessage + "\n\n" + "VerifyText failed, Text to verify - " + text + ", - " + locator
                    + ", Page URL -" + driver.getCurrentUrl();
            failureSeverity = "P2";
            errorBuffer = e.getMessage();
            e.printStackTrace();
        }
    }

    public void contextMenu(Locator locator) {
        try {
            List<WebElement> drop = driver.findElement(locator.getBy()).findElements(By.tagName("li"));

            for (WebElement opt : drop) {
                //if (opt.getText().contains(text)) {
                System.out.println( opt.findElement(By.tagName("a")).getTagName());
                break;
            }
            //}
        } catch (Exception e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n" + "Object not found to select menu item, " + locator + ", Page URL -"
                    + driver.getCurrentUrl();
            failureSeverity = "P1";
            System.out.println("Object not found for input");
            exceptionBuffer = e.getMessage();
            e.printStackTrace();
        }
    }
//    public void storeDynamicData(String inputData) {
//        mapDynamicData.put(inputDynamicCount, inputData);
//        inputDynamicCount++;
//    }

    public void StoreDynamicDataOrderId(Locator locator) throws InstantiationException, IllegalAccessException {
        WebDriverWait webdriverWait = new WebDriverWait(driver, DefaultTime);
        // webdriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator.getBy()));
        String text =driver.findElement(locator.getBy()).getText();
        System.out.println(text);
        Reporter.log("OrderId " + locator.getName() + "", true);
        TestListner.testing.get().log(Status.INFO, "OrderId " + locator.getName());



    }
    public void scrollIntoView(Locator locator) throws Exception {
        WebElement element;
        try {
            element = driver.findElement(locator.getBy());
            if (element != null) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            runStatus = true;
            errorMessage = errorMessage + "\n\n" + "Object not found to perform scrollIntoView operation, " + locator
                    + ", Page URL -" + driver.getCurrentUrl();
            exceptionBuffer = e.getMessage();
            e.printStackTrace();
        }
    }

    public List<WebElement> getElementList(Locator locator) throws Exception {
        List<WebElement> SizeDropDownOptions = driver.findElements(locator.getBy());
        System.out.println(SizeDropDownOptions.size());
        for (WebElement webElement : SizeDropDownOptions) {
            String name = webElement.getText();
            System.out.println(name);
           
        }
        return SizeDropDownOptions;
    }


    public void SwitchBrowserWindow(String text) {
        try {

            Set<String> handles = driver.getWindowHandles();
            Iterator<String> it = handles.iterator();
            // iterate through your windows
            while (it.hasNext()) {
                String winhndl = it.next();
                if (!winhndl.equals(parentWindow)) {
                    driver.switchTo().window(winhndl);
                }
            }

        } catch (Exception e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n" + "SwitchBrowserWindow operation failed";
            failureSeverity = "P3";
            exceptionBuffer = e.getMessage();
            e.printStackTrace();
        }
    }

    // function  navigate to new window
    public void CloseChildBrowser(String text) {
        try {

            Set<String> handles = driver.getWindowHandles();

            Iterator<String> it = handles.iterator();
            // iterate through your windows
            while (it.hasNext()) {
                String winhndl = it.next();
                if (!winhndl.equals(parentWindow)) {
                    driver.switchTo().window(winhndl);
                    driver.close();
                }

            }

            driver.switchTo().window(parentWindow);

        } catch (Exception e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n" + "CloseChildBrowser operation failed";
            failureSeverity = "P3";
            exceptionBuffer = e.getMessage();
            e.printStackTrace();
        }
    }
//    public void VerifyCartCountAfterAdd(Locator locator, int count)   {
//        try {
//
//            System.out.println("Count before add " + count);
//            //int intcount = Integer.parseInt(count);
//            int CountafterAdd = Integer.parseInt(driver.findElement(locator.getBy()).getAttribute("value"));
//            System.out.println("Count after add " + CountafterAdd );
//            Assert.assertEquals(CountafterAdd, count + 1);
//            System.out.println("Count after add " + CountafterAdd );
//
//        }
//        catch (NumberFormatException e){
//
//        };
//        //return true;
//
//    }



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
    public void SwitchToFrameById(String text) {
        try {
            driver.switchTo().frame(text);
        } catch (Exception e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n" + "No Frame present, Page URL -" + driver.getCurrentUrl();
            failureSeverity = "P1";
            exceptionBuffer = e.getMessage();
            e.printStackTrace();
        }
    }

    public void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n" + "Couldn't switch to Default Frame, Page URL -"
                    + driver.getCurrentUrl();
            failureSeverity = "P1";
            exceptionBuffer = e.getMessage();
            e.printStackTrace();
        }
    }


    public void SwitchToFrameByIndex(String text) {
        try {
            driver.switchTo().frame(Integer.parseInt(text));

        } catch (Exception e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n" + "No Frame present, Page URL -" + driver.getCurrentUrl();
            failureSeverity = "P1";
            exceptionBuffer = e.getMessage();
            e.printStackTrace();
        }
    }
    public void backPage() {
        driver.navigate().back();
    }

    public void clearCookies() {
        try {
            driver.manage().deleteAllCookies();
        } catch (Exception e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n" + ("Clear cookies operation failed");
            failureSeverity = "P3";
            exceptionBuffer = e.getMessage();
            e.printStackTrace();
        }
    }
    public void VerifyPageTitle(String text) {
        try {

            String presentText = driver.getTitle();
            System.out.println("presentTitle ==>> " + presentText);

            Assert.assertTrue(presentText.contains(text));

        } catch (Exception e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n"
                    + "Object not found to perform VerifyPageTitle operation, Page Title - " + text + ", Page URL -"
                    + driver.getCurrentUrl();
            failureSeverity = "P1";
            exceptionBuffer = e.getMessage();
            e.printStackTrace();
        } catch (AssertionError e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n" + "VerifyPageTitle failed, Page Title to verify - " + text
                    + ", Page URL -" + driver.getCurrentUrl();
            failureSeverity = "P3";
            errorBuffer = e.getMessage();
            e.printStackTrace();
        }
    }

    // added by  verifying page title
    public void VerifyPageUrl(String text) {
        try {
            String presentText = driver.getCurrentUrl();
            System.out.println("presentText ==>> " + presentText);
            Assert.assertTrue(presentText.contains(text));

        } catch (Exception e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n" + "Object not found to perform VerifyPageUrl operation, Page Title - "
                    + text + ", Page URL -" + driver.getCurrentUrl();
            failureSeverity = "P1";
            exceptionBuffer = e.getMessage();
            e.printStackTrace();
        } catch (AssertionError e) {
            runStatus = false;
            errorMessage = errorMessage + "\n\n" + "VerifyPageUrl failed, Page Url to verify - " + text + ", Page URL -"
                    + driver.getCurrentUrl();
            failureSeverity = "P2";
            errorBuffer = e.getMessage();
            e.printStackTrace();
        }
    }

    public void scrollUp()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-350)", "");
    }

    public void scrollDrown()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0,500);" );
    }


    public Locator GetLocator(String object_Name) {
        Framework framework = new Framework();
        ObjectRepo locatordata = framework.getOR(ObjectRepo.class, object_Name);
        if (locatordata.getlocator_type().equals("id") ) {
            return new Locator(By.id(locatordata.getlocator_value()), locatordata.getlocator_name_for_reporting());
        } else {
            return new Locator(By.xpath(locatordata.getlocator_value()), locatordata.getlocator_name_for_reporting());
        }
    }

    public void BooleanAsseration(Boolean condition, ExtentTest extentTest, String pass, String fail) throws IOException {
        if(condition){
            extentTest.log(Status.PASS, pass);
        }else {
            extentTest.log(Status.FAIL, fail);
            framework.logErrorWithSnapshot_New1(driver,  extentTest);
        }
    }
    public void BooleanAsseration_API(Boolean condition, ExtentTest extentTest, String pass, String fail) throws IOException {
        if(condition){
            extentTest.log(Status.PASS, pass);
        }else {
            extentTest.log(Status.FAIL, fail);
        }
    }

    public void IsNavigationOpen(Locator locator, ExtentTest extentTest) throws IOException, InstantiationException, IllegalAccessException {
        try {
            String xpath = ((By.ByXPath) locator.getBy()).toString();
            xpath = xpath + "/ancestor::div[@class=\"sidemenu-menu-item ng-star-inserted has-submenu has-submenu-open\"]//i";
            xpath = xpath.replace("By.xpath: ", "");
            if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
                System.out.println(locator.getName() + " already open");
            }
        }catch (Exception e){
            click(locator, extentTest);
            System.out.println("Navigation Bar Not opened or already opened");
        }
    }
    public void tabKey(Locator xpath)
    {
        try {
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
        }
        catch (Exception exp) {
            exp.printStackTrace();
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
    /** This function is used to clear text using xpath **/
    public void clearText(Locator locator) {
        WebElement toClear = driver.findElement(locator.getBy());
        toClear.sendKeys(Keys.CONTROL + "a");
        toClear.sendKeys(Keys.DELETE);
    }

    public void verifyFileDOwnloadedOrNot(String ExpectedfileName) {
        String downloadPath="/home/countrydelight/Downloads";
        File getLatestFile = getLatestFilefromDir(downloadPath);
        String fileName = getLatestFile.getName();
        Assert.assertTrue(fileName.contains(ExpectedfileName), "Downloaded file name is not matching with expected file name");
    }
    private File getLatestFilefromDir(String dirPath){
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }
        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    /** Method use to upload File */
    public static void uploadFile(String fileLocation) {
        try {
            // Setting clipboard with file location
            setClipboardData(fileLocation);
            // native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
    private static void setClipboardData(String fileLocation) {
        // TODO Auto-generated method stub
    }
    /** Method use to Download File */
    public static void DownloadFileToLocation(String fileLocation) {
        try {
            setClipboardData(fileLocation);
            FirefoxProfile profile = new FirefoxProfile();
            // profile.setPreference("browser.download.folderlist", 2);
            profile.setPreference("browser.helperapps.neverAsk.saveToDisk","xlsx");
            profile.setPreference("browser.download.dir", "C:\\Users\\Admin\\Desktop\\Exports\\");
            //  Actions action = new Actions(driver);
            //  action.contextClick().perform();
            Robot robo = new Robot();
            robo.keyPress(KeyEvent.VK_V);
            robo.keyRelease(KeyEvent.VK_V);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
    public boolean ISLocatorDisplayed(Locator locator, ExtentTest extentTest){
        try{
            waitUntilDisplayed(locator, 10);
            driver.findElement(locator.getBy()).isDisplayed();
            extentTest.log(Status.PASS, locator.getName()+" display in UI");
            System.out.println(locator.getName()+" validation success");
            return true;
        }catch (Exception e){
            extentTest.log(Status.WARNING, locator.getName()+" Not display in UI");
            System.out.println(locator.getName() + " Not display in UI");
            return false;
        }

    }

    public boolean IsDisplayed(Locator locator){
        try{
            waitUntilDisplayed(locator, 10);
            driver.findElement(locator.getBy()).isDisplayed();
            return true;
        }catch (Exception e){
            return false;
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
            e.printStackTrace();
        }
        return Text;
    }

    protected void SendKeys(Locator locator, ExtentTest extentTest, String value) throws InstantiationException, IllegalAccessException, IOException {

        try {
            WebDriverWait webdriverWait = new WebDriverWait(driver, DefaultTime);
            driver.findElement(locator.getBy()).sendKeys(value);
            // webdriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator.getBy()));
            Reporter.log("Sent Value on " + locator.getName() + "", true);
            extentTest.log(Status.PASS, "Sent Value on " + locator.getName());
        }
        catch(Exception e){
            extentTest.log(Status.FAIL,  "Not able to Sent Value on "+locator.getName());
            framework.logErrorWithSnapshot_New(driver, e, extentTest);
        }
    }

    protected void GenerateRandomValue(Locator locator, String value, ExtentTest extentTest) throws IOException {
        try {
            WebDriverWait webdriverWait = new WebDriverWait(driver, 60);
            //webdriverWait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
            Random random = new Random();
            int randomint = random.nextInt(10000);
            driver.findElement(locator.getBy()).sendKeys(value+randomint);
            Reporter.log("Entered value  '" + value+randomint + "' in '" + locator.getName() + "'", true);
            extentTest.log(Status.PASS, "Entered value  '" + value+randomint + "' in '" + locator.getName() + "'");
        }catch (Exception e){
            extentTest.log(Status.FAIL, "Not able to Enter value  '" + value + "' in '" + locator.getName() + "'");
            framework.logErrorWithSnapshot_New(driver, e, extentTest);
        }
    }

}