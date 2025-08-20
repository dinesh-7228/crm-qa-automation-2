package Pages.CRMPages.Orders;

import Data.AccountData;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

//import com.relevantcodes.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTest;
import FrameWork.BrowserAction;
import FrameWork.TestListner;
import io.qameta.allure.Step;

import java.io.IOException;

@Listeners(TestListner.class)
public class AllocateOrdersPage extends BrowserAction {
    SoftAssert Assert = new SoftAssert();
    public AllocateOrdersPage (WebDriver driver) {

        this.driver = driver;
        
    }
    @Step("Allocate Orders Validation || Allocate Orders Page validation")
public boolean AllocateOrdersData(ExtentTest extentTest,AccountData accountData) throws InstantiationException, IllegalAccessException, InterruptedException, IOException {

    	
//    	Boolean OrdersLinkPresent = driver.findElement(GetLocator("OrdersLink").getBy()).isDisplayed();
//        BooleanAsseration(OrdersLinkPresent, extentTest, "Orders Link Present", "Orders Link Not Present");
//        System.out.println("Orders Link Present validation success");
//        Thread.sleep(3000);
//
//        Boolean OrdersLinkClick = driver.findElement(GetLocator("OrdersLink").getBy()).isDisplayed();
//        click(GetLocator("OrdersLink"));
//        BooleanAsseration(OrdersLinkClick, extentTest, "Orders Link is clickable", "Customer Link Not clickable");
//        System.out.println("Orders Link Click validation success");
//        Thread.sleep(2000);
    	ISLocatorDisplayed(GetLocator("AllocateOrdersLink"), extentTest);
      //  Boolean AllocateOrdersLinkPresent = driver.findElement(GetLocator("AllocateOrdersLink").getBy()).isDisplayed();
      //  BooleanAsseration(AllocateOrdersLinkPresent, extentTest, "Allocate Orders Link Present", "Allocate Orders Link Not Present");
      //  System.out.println("Allocate Orders Link Present validation success");
        Thread.sleep(10000);
        ISLocatorDisplayed(GetLocator("AllocateOrdersLink"), extentTest);
     //   Boolean AllocateOrdersLinkClick = driver.findElement(GetLocator("AllocateOrdersLink").getBy()).isDisplayed();
        click(GetLocator("AllocateOrdersLink"), extentTest);
       // BooleanAsseration(AllocateOrdersLinkClick, extentTest, "Allocate Orders Link is clickable", "Allocate Orders Link Not clickable");
       // System.out.println("Allocate Orders Link Click validation success");
        Thread.sleep(10000);
        ISLocatorDisplayed(GetLocator("SelectCity"), extentTest);
       // Boolean SelectCity = driver.findElement(GetLocator("SelectCity").getBy()).isDisplayed();
        click(GetLocator("SelectCity"), extentTest);
        EnterValue(GetLocator("SelectCity"),accountData.getCityName(), extentTest);
        Thread.sleep(4000);
        click(GetLocator("SelectActiveStatus"), extentTest);
        Thread.sleep(2000);
       // BooleanAsseration(SelectCity, extentTest, "User able to Select City", "User not able to SelectCity");
       // System.out.println("Select City validation success");
        Thread.sleep(20000);
        ISLocatorDisplayed(GetLocator("GetCustomersBtn_Order"), extentTest);
       // Boolean GetCustomersBtnPresent = driver.findElement(GetLocator("GetCustomersBtn_Order").getBy()).isDisplayed();
       // BooleanAsseration(GetCustomersBtnPresent, extentTest, "Get Customers Button Present", "Get Customers Button Not Present");
       // System.out.println("Get Customers Button validation success");
        Thread.sleep(20000);
        ISLocatorDisplayed(GetLocator("GetCustomersBtn_Order"), extentTest);
     //   Boolean GetCustomersBtnClick = driver.findElement(GetLocator("GetCustomersBtn_Order").getBy()).isDisplayed();
        click(GetLocator("GetCustomersBtn_Order"), extentTest);
     //   BooleanAsseration(GetCustomersBtnClick, extentTest, "Get Customers Button Clickable", "Get Customers Button Not Clickable");
     //   System.out.println("Get Customers Button validation success");
        Thread.sleep(2000);
        
        return true;
        
        
    }}


        
        
        
        
        