package TestSuite;

import AppPages.CDApp.MLoginScreen;
import Data.*;
import FrameWork.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.awaitility.Awaitility;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.File;

public class API_Test_Suite {

    Framework framework = new Framework();
    TestListner testListener = new TestListner();
    EnvironmentParameterData environmentData = null;
    Map<String, String> keyValuePairMap = new HashMap<>();
    String pathMaster = System.getProperty("user.dir") + "\\src\\test\\java\\Api\\Response\\Master";
    String pathPreProd = System.getProperty("user.dir") + "\\src\\test\\java\\Api\\Response\\PreProd";
    String baseUrl = null;
    int count = 1;
    static String Token = "";

    @BeforeMethod(alwaysRun = true)
    public void preSetup() {
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
            environmentData = framework.getData(EnvironmentParameterData.class, "api-qa");
        }else {
            environmentData = framework.getData(EnvironmentParameterData.class, "api-uat");
        }
        baseUrl = environmentData.getBaseurl();
        Awaitility.reset();
        Awaitility.setDefaultPollDelay(100, TimeUnit.MILLISECONDS);
        Awaitility.setDefaultPollInterval(3, TimeUnit.SECONDS);
        Awaitility.setDefaultTimeout(7, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void flushExtent() {
        //Framework.extentReports.flush();
        count++;
        keyValuePairMap.clear();
    }

    @DataProvider(name = "Data Provide for Pre Requisite API" ,parallel = false)
    public Iterator<Object[]>  dataListForSearch() {
        Framework framework = new Framework();
        List<Object[]> apiDataList = framework.getSelectedData(APIData.class, "TRUE");
        if(apiDataList.size()==0){
            apiDataList = framework.getAllData(APIData.class);
        }
        return apiDataList.listIterator();

    }
    @DataProvider(name = "Data Provide for Independent API" ,parallel = false)
    public Iterator<Object[]>  dataListForSearch1() {
        Framework framework = new Framework();
        List<Object[]> apiDataList = framework.getindependentData(APIData.class, "TRUE");
        if(apiDataList.size()==0){
            apiDataList = framework.getAllData(APIData.class);
        }
        return apiDataList.listIterator();

    }

    @Test(groups = {"Transfer"})
    public void Pre_requisite_API_Transfer() throws SQLException, ClassNotFoundException {
        Framework framework = new Framework();
       // DataBaseActivity dataBaseActivity = new DataBaseActivity();
   /*     if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
            environmentData = framework.getData(EnvironmentParameterData.class, "api-qa");
        }else {
            environmentData = framework.getData(EnvironmentParameterData.class, "api-uat");
        }
     */
        List<APIData> apiData1 = framework.getSelectedData(APIData.class, "TRUE");
        environmentData = framework.getData(EnvironmentParameterData.class, "Delivery");
        baseUrl = environmentData.getBaseurl();
        for(APIData apiData : apiData1) {
            String parent = apiData.getName();
            System.out.println(parent);
            String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
            AccountData accountData = framework.getData(AccountData.class, "loginset26");
            String apiDetaildataId = apiData.getTestcaseid();
            // dataBaseActivity.OTP_Limit(accountData);
            ExtentTest parentTest1 = testListener.startParent(nameofCurrMethod, "This test verifies that user is able to verify " + apiData.getName());
            // parentTest1.setDescription("This test verifies that user is able to verify " + apiData.getName());
            TestRunner.parentExtentMap.put("parentTest1", parentTest1);
            List<APIDetailData> apiDetailDataList = framework.getDataList(APIDetailData.class, apiDetaildataId);
            for (APIDetailData apiDetailData : apiDetailDataList) {
                if (apiData.getParameter().contains("$mobile_number")) {
                    keyValuePairMap.put("$mobile_number", accountData.getMobile());
                }
                String envJsonFilePath = pathPreProd + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                ExtentTest childTest1 = parentTest1.createNode(apiDetailData.getTestDataId() + " : " + apiData.getName() + " API test with " + apiDetailData.getScenario(), "This test verifies that user is able to verify " + apiData.getName() + apiDetailData.getScenario());
                // childTest1.setDescription("This test verifies that user is able to verify " + apiData.getName() + apiDetailData.getScenario());
                TestListner.extentMap.get().put(apiDetailData.getTestDataId() + apiData.getName(), childTest1);
                try {
                    String basePath = apiDetailData.getPath();
                    apiDetailData.setPath(basePath);
                    //CustomSoftAssert CS = new CustomSoftAssert(APIAssertData);
                    childTest1.log(Status.INFO, "BaseURL: " + baseUrl);
                    childTest1.log(Status.INFO, "BasePath: " + apiDetailData.getPath());
                    childTest1.log(Status.INFO, "API Parameters: " + apiDetailData.getParameter());
                    Method method = new Method();
                    String MethodName = apiDetailData.getMethod();
                    String Header = apiDetailData.getHeader();
                    String Setfield = apiData.getSetThisField();
                    Response respEnv;
                    String Pareameter = apiDetailData.getParameter();

                    long currentTimestamp = System.currentTimeMillis();

                    // Convert the timestamp to LocalDateTime
                    LocalDateTime timestampDateTime = LocalDateTime.ofInstant(
                            java.time.Instant.ofEpochMilli(currentTimestamp),
                            java.time.ZoneId.systemDefault()
                    );
                    // String formattedTimestamp = timestampDateTime.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));

                    // Put the 13-digit timestamp in the map with the correct key "timestamp"
                    keyValuePairMap.put("$timestamp", String.valueOf(currentTimestamp));

                    // Print the formatted timestamp from the map using the correct key
                    //  System.out.println("Timestamp from Map: " + keyValuePairMap.get("timestamp"));


                    // Timestamp sqlTimestamp = new Timestamp(currentTimestamp);

                    // Print the SQL Timestamp
                    //  System.out.println("SQL Timestamp: " + sqlTimestamp);
                    String parameter = apiDetailData.getParameter();
                    apiDetailData.setParameter(parameter);
                    if (keyValuePairMap.containsKey(Setfield)) {
                        String value = keyValuePairMap.get(Setfield);
                        if (Pareameter.contains(Setfield)) {
                            Pareameter = Pareameter.replace(Setfield, value);
                            System.out.println(Pareameter);
                            apiDetailData.setParameter(Pareameter);
                        }

                    }
                    if (MethodName.contains("GET")) {
                        respEnv = method.GetMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("PUT")) {
                        respEnv = method.PutMethod(apiDetailData, environmentData, basePath);
                    } else {
                        respEnv = method.NewPostmethod(apiDetailData, environmentData, basePath);
                    }
                    if (respEnv.getStatusCode() == 200) {
                        childTest1.log(Status.PASS, "Status Code is " + respEnv.getStatusCode());
                        if ((!apiData.getUseThisField().isEmpty()) && (!(apiData.getUseThisField().contains("null"))) && (keyValuePairMap.get(apiData.getGetThisField())) == null) {
                            String temp = apiData.getUseThisField();
                            String Test = apiData.getGetThisField();
                            String[] test1 = Test.split(",", 5);
                            String[] temp1 = temp.split(",", 5);
                            for (int i = 0; i < temp1.length; i++) {
                                String value = method.GetField(respEnv, temp1[i]);
                                String key = test1[i];
                                keyValuePairMap.put(key, value);
                            }
                            System.out.println(Arrays.asList(keyValuePairMap));
                        }

                    } else if (respEnv.getStatusCode() == 500) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!! server error !!");
                    } else if (respEnv.getStatusCode() == 501) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!! Not Implemented !!");
                    } else if (respEnv.getStatusCode() == 502) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Bad GateWay  !!");
                    } else if (respEnv.getStatusCode() == 503) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Service Unavailable  !!");
                    } else if (respEnv.getStatusCode() == 504) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Gateway Timeout !!");
                    } else if (respEnv.getStatusCode() == 400) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Bad Request !!");
                    } else if (respEnv.getStatusCode() == 401) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  user is Unauthorized !!");
                    } else if (respEnv.getStatusCode() == 403) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Forbidden !!");
                    } else if (respEnv.getStatusCode() == 404) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Page Not Foound !!");
                    }
                    if (keyValuePairMap.containsKey("$access_token")){
                        Token = keyValuePairMap.get("$access_token");
                    }
                    String responseStringEnv = respEnv.asString();
                    System.out.println("Request Sent:" + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, apiData.getMethod());
                    childTest1.log(Status.INFO, "Request Sent: " + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, "Response Received: " + respEnv.asString());
                    childTest1.log(Status.INFO, "Response Time :" + respEnv.getTime());
                    String gender = System.getProperty("Gender");
                    if (gender != null) {
                        if ((apiDetailData.getExpected().contains("null"))) {
                            if ((respEnv.asString().contains(apiDetailData.getExpected()) || (apiDetailData.getExpected().equalsIgnoreCase("null")))) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + "Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + "Not Match with Current Response");
                            }
                        }
                    } else {
                        if (apiDetailData.getExpected().contains("")) {
                            if (respEnv.asString().contains(apiDetailData.getExpected())) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + "Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + "Not Match with Current Response");
                            }
                        }
                    }

                    //CS.assertTrue(respEnv.asString().contains(apiDetailData.getExpected()), apiDetailData.getExpected());
                    File PreprodJsonFile = new File(envJsonFilePath);
                    FileUtils.writeStringToFile(PreprodJsonFile, responseStringEnv);

                } catch (Exception e) {
                    childTest1.log(Status.FAIL, "Exception or Assert Error " + e.getMessage());
                    Assert.fail("Failed Testcase Please check log");
                }
                System.out.println(apiDetailData.getTestDataId() + " Child Test Finished");
            }
            // TestListner testListner = new TestListner();
            // testListner.childParentLink(parent);
            // Framework.extentReports.removeTest(parentTest1);
        }
        Framework.extentReports.flush();
    }

    @Test(groups = {"production", "APIDemo", "API"}, dataProvider = "Data Provide for Independent API")
    public void Indepenet_API(APIData apiData) throws SQLException, ClassNotFoundException {
        Framework framework = new Framework();
        DataBaseActivity dataBaseActivity = new DataBaseActivity();
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
            environmentData = framework.getData(EnvironmentParameterData.class, "api-qa");
        }else {
            environmentData = framework.getData(EnvironmentParameterData.class, "api-uat");
        }
        baseUrl = environmentData.getBaseurl();
        String parent = apiData.getName();
        AccountData accountData = framework.getData(AccountData.class, "loginset26");
        dataBaseActivity.OTP_Limit(accountData);
        ExtentTest parentTest1 = testListener.startParent(apiData.getName() + " API Test on " + baseUrl, "This test verifies that user is able to verify " + apiData.getName());
       // parentTest1.setDescription("This test verifies that user is able to verify " + apiData.getName());
        TestRunner.parentExtentMap.put("parentTest1", parentTest1);
        String apiDetaildataId = apiData.getTestcaseid();
        List<APIDetailData> apiDetailDataList = framework.getDataList(APIDetailData.class, apiDetaildataId);
        for (APIDetailData apiDetailData : apiDetailDataList) {
            if (apiData.getParameter().contains("$mobile_number")){
                keyValuePairMap.put("$mobile_number", accountData.getMobile());
            }
            String envJsonFilePath = pathPreProd + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
            ExtentTest childTest1 = parentTest1.createNode(apiDetailData.getTestDataId() + " : " + apiData.getName() + " API test with " + apiDetailData.getScenario(), "This test verifies that user is able to verify " + apiData.getName() + apiDetailData.getScenario());
           // childTest1.setDescription("This test verifies that user is able to verify " + apiData.getName() + apiDetailData.getScenario());
            TestListner.extentMap.get().put(apiDetailData.getTestDataId() + apiData.getName(), childTest1);
            try {
                String basePath = apiDetailData.getPath();

                apiDetailData.setPath(basePath);
                //CustomSoftAssert CS = new CustomSoftAssert(APIAssertData);
                childTest1.log(Status.INFO, "BaseURL: " + baseUrl);
                childTest1.log(Status.INFO, "BasePath: " + apiDetailData.getPath());
                childTest1.log(Status.INFO, "API Parameters: " + apiDetailData.getParameter());
                Method method = new Method();
                String MethodName = apiDetailData.getMethod();
                String Header = apiDetailData.getHeader();
                String Setfield = apiData.getSetThisField();
                Response respEnv;
                String Pareameter = apiDetailData.getParameter();


                String parameter = apiDetailData.getParameter();
                apiDetailData.setParameter(parameter);
                if (keyValuePairMap.containsKey(Setfield)) {
                    String value = keyValuePairMap.get(Setfield);
                    if (Pareameter.contains(Setfield)) {
                        Pareameter = Pareameter.replace(Setfield, value);
                        System.out.println(Pareameter);
                        apiDetailData.setParameter(Pareameter);
                    }

                }
                if (MethodName.contains("GET")) {
                    respEnv = method.GetMethod(apiDetailData, environmentData, basePath);
                } else if (MethodName.contains("PUT")) {
                    respEnv = method.PutMethod(apiDetailData, environmentData, basePath);
                } else {
                    respEnv = method.NewPostmethod(apiDetailData, environmentData, basePath);
                }
                if (respEnv.getStatusCode() == 200) {
                    childTest1.log(Status.PASS, "Status Code is " + respEnv.getStatusCode());
//                    if (respEnv.getHeader("X-Magento-Cache-Debug") != null) {
//                        String CacheResult = respEnv.getHeader("X-Magento-Cache-Debug");
//                        childTest1.log(Status.INFO, "Cache Result " + CacheResult);
//                    }
                    if ((apiData.getUseThisField().contains(""))) {
                        if (Token == "") {
                            String temp = apiData.getUseThisField();
                            String Test = apiData.getGetThisField();
                            String[] test1 = Test.split(",", 5);
                            String[] temp1 = temp.split(",", 5);
                            for (int i = 0; i < temp1.length; i++) {
                                Token = method.GetField(respEnv, temp1[i]);
                                String key = test1[i];
                                keyValuePairMap.put(key, Token);
                            }
                            System.out.println(Arrays.asList(keyValuePairMap));
                        }

                    }
                } else if (respEnv.getStatusCode() == 500) {
                    childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                    System.out.println("!! server error !!");
                } else if (respEnv.getStatusCode() == 501) {
                    childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                    System.out.println("!! Not Implemented !!");
                } else if (respEnv.getStatusCode() == 502) {
                    childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                    System.out.println("!!  Bad GateWay  !!");
                } else if (respEnv.getStatusCode() == 503) {
                    childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                    System.out.println("!!  Service Unavailable  !!");
                } else if (respEnv.getStatusCode() == 504) {
                    childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                    System.out.println("!!  Gateway Timeout !!");
                } else if (respEnv.getStatusCode() == 400) {
                    childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                    System.out.println("!!  Bad Request !!");
                } else if (respEnv.getStatusCode() == 401) {
                    childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                    System.out.println("!!  user is Unauthorized !!");
                } else if (respEnv.getStatusCode() == 403) {
                    childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                    System.out.println("!!  Forbidden !!");
                } else if (respEnv.getStatusCode() == 404) {
                    childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                    System.out.println("!!  Page Not Foound !!");
                }
                String responseStringEnv = respEnv.asString();
                System.out.println("Request Sent:" + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                childTest1.log(Status.INFO, apiData.getMethod());
                childTest1.log(Status.INFO, "Request Sent: " + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                childTest1.log(Status.INFO, "Response Received: " + respEnv.asString());
                childTest1.log(Status.INFO, "Response Time :" + respEnv.getTime());
                String gender = System.getProperty("Gender");
                if (gender != null) {
                    if ((apiDetailData.getExpected().contains("null"))) {
                        if ((respEnv.asString().contains(apiDetailData.getExpected()) || (apiDetailData.getExpected().equalsIgnoreCase("null")))) {
                            childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + "Match with Current Response");
                        } else {
                            childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + "Not Match with Current Response");
                        }
                    }
                } else {
                    if (apiDetailData.getExpected().contains("")) {
                        if (respEnv.asString().contains(apiDetailData.getExpected())) {
                            childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + "Match with Current Response");
                        } else {
                            childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + "Not Match with Current Response");
                        }
                    }
                }

                //CS.assertTrue(respEnv.asString().contains(apiDetailData.getExpected()), apiDetailData.getExpected());
                File PreprodJsonFile = new File(envJsonFilePath);
                FileUtils.writeStringToFile(PreprodJsonFile, responseStringEnv);

            } catch (Exception e) {
                childTest1.log(Status.FAIL, "Exception or Assert Error " + e.getMessage());
                //Assert.fail("Failed Testcase Please check log");
            }
            System.out.println(apiDetailData.getTestDataId() + " Child Test Finished");
        }
       // TestListner testListner = new TestListner();
       // testListner.childParentLink(parent);
       // Framework.extentReports.removeTest(parentTest1);
        //Framework.extentReports.flush();
    }

    @Test(groups = {"production", "APIDemo1", "API"}, priority = 1, invocationCount = 2, threadPoolSize = 1)
    public void Dependent_APIData() {
        Framework frameWork = new Framework();
        List<APIData> apiData1 = frameWork.getdependentAPIdata(APIData.class, "TRUE");
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
            environmentData = framework.getData(EnvironmentParameterData.class, "api-qa");
        }else {
            environmentData = framework.getData(EnvironmentParameterData.class, "api-uat");
        }
        //environmentData = framework.getData(EnvironmentParameterData.class, "api");
        String flowtype = "";
        AccountData accountData = null;
        for (APIData apiData : apiData1) {
            if (apiData.getParameter().contains("$mobile_number")) {
                if (count == 1) {
                    accountData = frameWork.getData(AccountData.class, "loginset26");
                    flowtype = "Existing User";
                } else if (count == 2) {
                    accountData = frameWork.getData(AccountData.class, "loginset2");
                    flowtype = "New User";
                }
                keyValuePairMap.put("$mobile_number", accountData.getMobile());
            }
            String parent = apiData.getName();
            // ExtentTest parentTest1 = testListener.startParent(apiData.getName() + " API Test "+flowtype);
            ExtentTest parentTest1 = testListener.startParent(flowtype + " Flow", "This test verifies that user is able to verify " + flowtype);
          //  parentTest1.setDescription("This test verifies that user is able to verify " + apiData.getName());
            TestRunner.parentExtentMap.put("parentTest1", parentTest1);
            String apiDetaildataId = apiData.getTestcaseid();
            List<APIDetailData> apiDetailDataList = frameWork.getDataList(APIDetailData.class, apiDetaildataId);
            for (APIDetailData apiDetailData : apiDetailDataList) {
                String envJsonFilePath = pathPreProd + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                String pathMasterFilePath = pathMaster + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                ExtentTest childTest1 = parentTest1.createNode(apiDetailData.getTestDataId() + " : This test verifies that user is able to verify " +  apiDetailData.getScenario());
               // childTest1.setDescription("This test verifies that user is able to verify " + apiData.getName() + apiDetailData.getScenario());
             //   TestListner.extentMap.get().put(apiDetailData.getTestDataId() + apiData.getName(), childTest1);
                TestListner.extentMap.get().put(apiDetailData.getTestDataId() + " : " + apiData.getName() + " API test with " + apiDetailData.getScenario(), childTest1);
                try {
                    String basePath = apiDetailData.getPath();

                    String parameter = apiDetailData.getParameter();

                    // CustomSoftAssert CS = new CustomSoftAssert(APIAssertData);
                    Method method = new Method();
                    String Header = apiDetailData.getHeader();
                    String MethodName = apiDetailData.getMethod();
                    String Setfield = apiData.getSetThisField();
                    Response respEnv;
                    String Pareameter = apiDetailData.getParameter();
                    if (!(Setfield == "null" || Setfield.equalsIgnoreCase(""))) {
                        String[] setfield = Setfield.split(",");
                        for (int i = 0; i < setfield.length; i++) {
                            String value = keyValuePairMap.get(setfield[i]);
                            if (basePath.contains(setfield[i])) {
                                basePath = basePath.replace(setfield[i], value);
                                apiDetailData.setPath(basePath);
                                System.out.println(apiDetailData.getPath());
                            } else if (Pareameter.contains(setfield[i])) {
                                Pareameter = Pareameter.replace(setfield[i], value);
                                System.out.println(Pareameter);
                                apiDetailData.setParameter(Pareameter);
                            } else if (Header.contains(setfield[i])) {
                                Header = Header.replace(setfield[i], value);
                                apiDetailData.setHeader(Header);
                                System.out.println(apiDetailData.getHeader());
                            }
                        }
                    }
                    if (keyValuePairMap.containsKey(Setfield)) {
                        String value = keyValuePairMap.get(Setfield);
                        if (basePath.contains(Setfield)) {
                            basePath = basePath.replace(Setfield, value);
                            apiDetailData.setPath(basePath);
                            System.out.println(apiDetailData.getPath());
                        } else if (Pareameter.contains(Setfield)) {
                            Pareameter = Pareameter.replace(Setfield, value);
                            System.out.println(Pareameter);
                        }

                    }
                    if (MethodName.contains("GET")) {
                        respEnv = method.GetMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("PUT")) {
                        respEnv = method.PutMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("DELETE")) {
                        respEnv = method.DeleteMethod(apiDetailData, environmentData, basePath);
                    } else {
                        respEnv = method.NewPostmethod(apiDetailData, environmentData, basePath);
                    }

                    String responseStringEnv = respEnv.asString();
                    if (respEnv.getStatusCode() == 200 || respEnv.getStatusCode() == Integer.parseInt(apiDetailData.getStatus())) {
                        childTest1.log(Status.PASS, "Status Code is " + respEnv.getStatusCode());
                        if ((!apiData.getUseThisField().isEmpty()) && (!(apiData.getUseThisField().contains("null"))) && (keyValuePairMap.get(apiData.getGetThisField())) == null) {
                            String temp = apiData.getUseThisField();
                            String Test = apiData.getGetThisField();
                            String[] test1 = Test.split(",", 5);
                            String[] temp1 = temp.split(",", 5);
                            for (int i = 0; i < temp1.length; i++) {
                                String value = method.GetField(respEnv, temp1[i]);
                                String key = test1[i];
                                keyValuePairMap.put(key, value);
                            }
                            System.out.println(Arrays.asList(keyValuePairMap));
                        }

                    } else if (respEnv.getStatusCode() == 500) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!! server error !!");
                    } else if (respEnv.getStatusCode() == 501) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!! Not Implemented !!");
                    } else if (respEnv.getStatusCode() == 502) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Bad GateWay  !!");
                    } else if (respEnv.getStatusCode() == 503) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Service Unavailable  !!");
                    } else if (respEnv.getStatusCode() == 504) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Gateway Timeout !!");
                    } else if (respEnv.getStatusCode() == 400) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Bad Request !!");
                    } else if (respEnv.getStatusCode() == 401) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  user is Unauthorized !!");
                    } else if (respEnv.getStatusCode() == 403) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Forbidden !!");
                    } else if (respEnv.getStatusCode() == 404) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Page Not Found !!");
                    }
                    else if (respEnv.getStatusCode() == 405) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Method Not Allowed !!");
                    }

                    childTest1.log(Status.INFO, "BaseURL: " + baseUrl);
                    childTest1.log(Status.INFO, "BasePath: " + apiDetailData.getPath());
                    childTest1.log(Status.INFO, "API Parameters: " + apiDetailData.getParameter());
                    childTest1.log(Status.INFO, "API Header" + apiDetailData.getHeader());
                    System.out.println("Request Sent:" + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, apiData.getMethod());
                    childTest1.log(Status.INFO, "Request Sent: " + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, "Response Received: " + respEnv.asString());
                    childTest1.log(Status.INFO, "Response Time :" + respEnv.getTime());
                    String gender = System.getProperty("Gender");
                    if (gender != null) {
                        if ((apiDetailData.getExpected().contains("null"))) {
                            if ((respEnv.asString().contains(apiDetailData.getExpected()) || (apiDetailData.getExpected().equalsIgnoreCase("null")))) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + "Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + "Not Match with Current Response");
                            }
                        }
                    } else {
                        if (apiDetailData.getExpected().contains("")) {
                            if (respEnv.asString().contains(apiDetailData.getExpected())) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + "Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + "Not Match with Current Response");
                            }
                        }
                    }

                    //CS.assertTrue(respEnv.asString().contains(apiDetailData.getExpected()), apiDetailData.getExpected());
                    File PreprodJsonFile = new File(envJsonFilePath);
                    FileUtils.writeStringToFile(PreprodJsonFile, responseStringEnv);

                } catch (Exception e) {
                    childTest1.log(Status.FAIL, "Exception or Assert Error " + e.getMessage());
                    Assert.fail("Failed Testcase Please check log");
                }
                System.out.println(apiDetailData.getTestDataId() + " Child Test Finished");
            }
           // TestListner testListner = new TestListner();
           // testListner.childParentLink(parent);
           // Framework.extentReports.removeTest(parentTest1);
        }
           Framework.extentReports.flush();
    }

    @Test(groups = {"production", "APIDemo1", "API_R"}, priority = 1, invocationCount = 1, threadPoolSize = 1)
    public void Dependent_API_Regression() throws SQLException, ClassNotFoundException {
        Framework frameWork = new Framework();
        DataBaseActivity dataBaseActivity = new DataBaseActivity();
        List<APIData> apiData1 = frameWork.getdependentAPIdata(APIData.class, "TRUE");
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
            environmentData = framework.getData(EnvironmentParameterData.class, "api-qa");
        }else {
            environmentData = framework.getData(EnvironmentParameterData.class, "api-uat");
        }
       AccountData accountData = frameWork.getData(AccountData.class, "loginset26");
        dataBaseActivity.OTP_Limit(accountData);
        //environmentData = framework.getData(EnvironmentParameterData.class, "api");
       // AccountData accountData = null;
        String flowtype = "";
        for (APIData apiData : apiData1) {
            if (apiData.getParameter().contains("$mobile_number")){
               keyValuePairMap.put("$mobile_number", accountData.getMobile());
            }
            ExtentTest parentTest1 = testListener.startParent(apiData.getName() + " API Test ","This test verifies that user is able to verify " + apiData.getName());
            //ExtentTest parentTest1 = testListener.startParent(flowtype + " Flow", "This test verifies that user is able to verify " + flowtype);
           // parentTest1.setDescription("This test verifies that user is able to verify " + apiData.getName());
            TestRunner.parentExtentMap.put("parentTest1", parentTest1);
            String apiDetaildataId = apiData.getTestcaseid();
            List<APIDetailData> apiDetailDataList = frameWork.getDataList(APIDetailData.class, apiDetaildataId);
            for (APIDetailData apiDetailData : apiDetailDataList) {
                String envJsonFilePath = pathPreProd + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                String pathMasterFilePath = pathMaster + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                ExtentTest childTest1 = parentTest1.createNode(apiDetailData.getTestDataId()+ " : "  + apiDetailData.getScenario());
                // childTest1.setDescription("This test verifies that user is able to verify " + apiData.getName() + apiDetailData.getScenario());
                //   TestListner.extentMap.get().put(apiDetailData.getTestDataId() + apiData.getName(), childTest1);
                TestListner.extentMap.get().put(apiDetailData.getTestDataId() + " : " + apiData.getName() + " API test with " + apiDetailData.getScenario(), childTest1);
                try {
                    String basePath = apiDetailData.getPath();

                    String parameter = apiDetailData.getParameter();

                    // CustomSoftAssert CS = new CustomSoftAssert(APIAssertData);
                    Method method = new Method();
                    String Header = apiDetailData.getHeader();
                    String MethodName = apiDetailData.getMethod();
                    String Setfield = apiData.getSetThisField();
                    Response respEnv;
                    String Pareameter = apiDetailData.getParameter();
                    if (!(Setfield == "null" || Setfield.equalsIgnoreCase(""))) {
                        String[] setfield = Setfield.split(",");
                        for (int i = 0; i < setfield.length; i++) {
                            String value = keyValuePairMap.get(setfield[i]);
                            if (basePath.contains(setfield[i])) {
                                basePath = basePath.replace(setfield[i], value);
                                apiDetailData.setPath(basePath);
                                System.out.println(apiDetailData.getPath());
                            } else if (Pareameter.contains(setfield[i])) {
                                Pareameter = Pareameter.replace(setfield[i], value);
                                System.out.println(Pareameter);
                                apiDetailData.setParameter(Pareameter);
                            } else if (Header.contains(setfield[i])) {
                                Header = Header.replace(setfield[i], value);
                                apiDetailData.setHeader(Header);
                                System.out.println(apiDetailData.getHeader());
                            }
                        }
                    }
                    if (keyValuePairMap.containsKey(Setfield)) {
                        String value = keyValuePairMap.get(Setfield);
                        if (basePath.contains(Setfield)) {
                            basePath = basePath.replace(Setfield, value);
                            apiDetailData.setPath(basePath);
                            System.out.println(apiDetailData.getPath());
                        } else if (Pareameter.contains(Setfield)) {
                            Pareameter = Pareameter.replace(Setfield, value);
                            System.out.println(Pareameter);
                        }

                    }
                    if (MethodName.contains("GET")) {
                        respEnv = method.GetMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("PUT")) {
                        respEnv = method.PutMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("DELETE")) {
                        respEnv = method.DeleteMethod(apiDetailData, environmentData, basePath);
                    } else {
                        respEnv = method.NewPostmethod(apiDetailData, environmentData, basePath);
                    }

                    String responseStringEnv = respEnv.asString();
                    if(Integer.toString(respEnv.getStatusCode()).equalsIgnoreCase(apiDetailData.getStatus()) && !(respEnv.getStatusCode() == 200))
                    {childTest1.log(Status.PASS, "status code is " + respEnv.getStatusCode());}
                    else{
                        if (respEnv.getStatusCode() == 200 ) {
                            childTest1.log(Status.PASS, "Status Code is " + respEnv.getStatusCode());
                            if ((!apiData.getUseThisField().isEmpty()) && (!(apiData.getUseThisField().contains("null"))) && (keyValuePairMap.get(apiData.getGetThisField())) == null && responseStringEnv.contains("\"error\":false")) {
                                String temp = apiData.getUseThisField();
                                String Test = apiData.getGetThisField();
                                String[] test1 = Test.split(",", 5);
                                String[] temp1 = temp.split(",", 5);
                                for (int i = 0; i < temp1.length; i++) {
                                    String value = method.GetField(respEnv, temp1[i]);
                                    String key = test1[i];
                                    keyValuePairMap.put(key, value);
                                }
                                System.out.println(Arrays.asList(keyValuePairMap));
                            }

                        } else if (respEnv.getStatusCode() == 500) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!! server error !!");
                        } else if (respEnv.getStatusCode() == 501) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!! Not Implemented !!");
                        } else if (respEnv.getStatusCode() == 502) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  Bad GateWay  !!");
                        } else if (respEnv.getStatusCode() == 503) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  Service Unavailable  !!");
                        } else if (respEnv.getStatusCode() == 504) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  Gateway Timeout !!");
                        } else if (respEnv.getStatusCode() == 400) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  Bad Request !!");
                        } else if (respEnv.getStatusCode() == 401) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  user is Unauthorized !!");
                        } else if (respEnv.getStatusCode() == 403) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  Forbidden !!");
                        } else if (respEnv.getStatusCode() == 404) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  Page Not Found !!");
                        } else if (respEnv.getStatusCode() == 405) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  Method Not Allowed !!");
                        }
                    }

                    childTest1.log(Status.INFO, "BaseURL: " + baseUrl);
                    childTest1.log(Status.INFO, "BasePath: " + apiDetailData.getPath());
                    childTest1.log(Status.INFO, "API Parameters: " + apiDetailData.getParameter());
                    childTest1.log(Status.INFO, "API Header: " + apiDetailData.getHeader());
                    System.out.println("Request Sent: " + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, apiData.getMethod());
                    childTest1.log(Status.INFO, "Request Sent: " + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, "Response Received: " + respEnv.asString());
                    childTest1.log(Status.INFO, "Response Time :" + respEnv.getTime());
                    String gender = System.getProperty("Gender");
                    if (gender != null) {
                        if ((apiDetailData.getExpected().contains("null"))) {
                            if ((respEnv.asString().contains(apiDetailData.getExpected()) || (apiDetailData.getExpected().equalsIgnoreCase("null")))) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + " Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + " Not Match with Current Response");
                            }
                        }
                    } else {
                        if (apiDetailData.getExpected().contains("")) {
                            if (respEnv.asString().contains(apiDetailData.getExpected())) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + " Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + " Not Match with Current Response");
                            }
                        }
                    }

                    //CS.assertTrue(respEnv.asString().contains(apiDetailData.getExpected()), apiDetailData.getExpected());
                    File PreprodJsonFile = new File(envJsonFilePath);
                    FileUtils.writeStringToFile(PreprodJsonFile, responseStringEnv);

                } catch (Exception e) {
                    childTest1.log(Status.FAIL, "Exception or Assert Error " + e.getMessage());
                    Assert.fail("Failed Testcase Please check log");
                }
                System.out.println(apiDetailData.getTestDataId() + " Child Test Finished");
            }
            // TestListner testListner = new TestListner();
            // testListner.childParentLink(parent);
            // Framework.extentReports.removeTest(parentTest1);
        }
        Framework.extentReports.flush();
    }


    @Test(groups = {"Transfer"}, priority = 1, invocationCount = 1, threadPoolSize = 1)
    public void Dependent_APIData_Transfer() {
        Framework frameWork = new Framework();
        List<APIData> apiData1 = frameWork.getdependentAPIdata(APIData.class, "TRUE");
    /*    if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
            environmentData = framework.getData(EnvironmentParameterData.class, "api-qa");
        }else {
            environmentData = framework.getData(EnvironmentParameterData.class, "api-uat");
        }
      */
        environmentData = framework.getData(EnvironmentParameterData.class, "Stock_Transafer");
        String flowtype = "";
        AccountData accountData = null;
        for (APIData apiData : apiData1) {
            if (apiData.getParameter().contains("$mobile_number")) {
                if (count == 1) {
                    accountData = frameWork.getData(AccountData.class, "loginset26");
                    flowtype = "Existing User";
                } else if (count == 2) {
                    accountData = frameWork.getData(AccountData.class, "loginset2");
                    flowtype = "New User";
                }
                keyValuePairMap.put("$mobile_number", accountData.getMobile());
            }
            String parent = apiData.getName();
            // ExtentTest parentTest1 = testListener.startParent(apiData.getName() + " API Test "+flowtype);
            ExtentTest parentTest1 = testListener.startParent(flowtype + " Flow", "This test verifies that user is able to verify " + flowtype);
            //  parentTest1.setDescription("This test verifies that user is able to verify " + apiData.getName());
            TestRunner.parentExtentMap.put("parentTest1", parentTest1);
            String apiDetaildataId = apiData.getTestcaseid();
            List<APIDetailData> apiDetailDataList = frameWork.getDataList(APIDetailData.class, apiDetaildataId);
            for (APIDetailData apiDetailData : apiDetailDataList) {
                String envJsonFilePath = pathPreProd + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                String pathMasterFilePath = pathMaster + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                ExtentTest childTest1 = parentTest1.createNode(apiDetailData.getTestDataId() + " : This test verifies that user is able to verify " +  apiDetailData.getScenario());
                // childTest1.setDescription("This test verifies that user is able to verify " + apiData.getName() + apiDetailData.getScenario());
                //   TestListner.extentMap.get().put(apiDetailData.getTestDataId() + apiData.getName(), childTest1);
                TestListner.extentMap.get().put(apiDetailData.getTestDataId() + " : " + apiData.getName() + " API test with " + apiDetailData.getScenario(), childTest1);
                try {
                    String basePath = apiDetailData.getPath();

                    String parameter = apiDetailData.getParameter();

                    // CustomSoftAssert CS = new CustomSoftAssert(APIAssertData);
                    Method method = new Method();
                    String Header = apiDetailData.getHeader();
                    String MethodName = apiDetailData.getMethod();
                    String Setfield = apiData.getSetThisField();
                    Response respEnv;
                    System.out.println(Token);
                    String Pareameter = apiDetailData.getParameter();
                    if (!(Setfield == "null" || Setfield.equalsIgnoreCase(""))) {
                        String[] setfield = Setfield.split(",");
                        for (int i = 0; i < setfield.length; i++) {
                            String value = keyValuePairMap.get(setfield[i]);
                            if (basePath.contains(setfield[i])) {
                                basePath = basePath.replace(setfield[i], value);
                                apiDetailData.setPath(basePath);
                                System.out.println(apiDetailData.getPath());
                            } else if (Pareameter.contains(setfield[i])) {
                                Pareameter = Pareameter.replace(setfield[i], value);
                                System.out.println(Pareameter);
                                apiDetailData.setParameter(Pareameter);
                            } else if (Header.contains(setfield[i])) {
                                if (setfield[i].equalsIgnoreCase("$access_token")){
                                    Header = Header.replace(setfield[i], Token);
                                }else{
                                    Header = Header.replace(setfield[i], value);
                                }
                               // Header = Header.replace(setfield[i], value);
                                apiDetailData.setHeader(Header);
                                System.out.println(apiDetailData.getHeader());
                            }
                        }
                    }
                    if (keyValuePairMap.containsKey(Setfield)) {
                        String value = keyValuePairMap.get(Setfield);
                        if (basePath.contains(Setfield)) {
                            basePath = basePath.replace(Setfield, value);
                            apiDetailData.setPath(basePath);
                            System.out.println(apiDetailData.getPath());
                        } else if (Pareameter.contains(Setfield)) {
                            Pareameter = Pareameter.replace(Setfield, value);
                            System.out.println(Pareameter);
                        }

                    }
                    if (MethodName.contains("GET")) {
                        respEnv = method.GetMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("PUT")) {
                        respEnv = method.PutMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("DELETE")) {
                        respEnv = method.DeleteMethod(apiDetailData, environmentData, basePath);
                    } else {
                        respEnv = method.NewPostmethod(apiDetailData, environmentData, basePath);
                    }

                    String responseStringEnv = respEnv.asString();
                    if (respEnv.getStatusCode() == 200) {
                        childTest1.log(Status.PASS, "Status Code is " + respEnv.getStatusCode());
                        if ((!apiData.getUseThisField().isEmpty()) && (!(apiData.getUseThisField().contains("null"))) && (keyValuePairMap.get(apiData.getGetThisField())) == null) {
                            String temp = apiData.getUseThisField();
                            String Test = apiData.getGetThisField();
                            String[] test1 = Test.split(",", 5);
                            String[] temp1 = temp.split(",", 5);
                            for (int i = 0; i < temp1.length; i++) {
                                String value = method.GetField(respEnv, temp1[i]);
                                String key = test1[i];
                                keyValuePairMap.put(key, value);
                            }
                            System.out.println(Arrays.asList(keyValuePairMap));
                        }

                    } else if (respEnv.getStatusCode() == 500) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!! server error !!");
                    } else if (respEnv.getStatusCode() == 501) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!! Not Implemented !!");
                    } else if (respEnv.getStatusCode() == 502) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Bad GateWay  !!");
                    } else if (respEnv.getStatusCode() == 503) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Service Unavailable  !!");
                    } else if (respEnv.getStatusCode() == 504) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Gateway Timeout !!");
                    } else if (respEnv.getStatusCode() == 400) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Bad Request !!");
                    } else if (respEnv.getStatusCode() == 401) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  user is Unauthorized !!");
                    } else if (respEnv.getStatusCode() == 403) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Forbidden !!");
                    } else if (respEnv.getStatusCode() == 404) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Page Not Found !!");
                    }
                    else if (respEnv.getStatusCode() == 405) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Method Not Allowed !!");
                    }

                    childTest1.log(Status.INFO, "BaseURL: " + baseUrl);
                    childTest1.log(Status.INFO, "BasePath: " + apiDetailData.getPath());
                    childTest1.log(Status.INFO, "API Parameters: " + apiDetailData.getParameter());
                    childTest1.log(Status.INFO, "API Header" + apiDetailData.getHeader());
                    System.out.println("Request Sent:" + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, apiData.getMethod());
                    childTest1.log(Status.INFO, "Request Sent: " + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, "Response Received: " + respEnv.asString());
                    childTest1.log(Status.INFO, "Response Time :" + respEnv.getTime());
                    String gender = System.getProperty("Gender");
                    if (gender != null) {
                        if ((apiDetailData.getExpected().contains("null"))) {
                            if ((respEnv.asString().contains(apiDetailData.getExpected()) || (apiDetailData.getExpected().equalsIgnoreCase("null")))) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + "Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + "Not Match with Current Response");
                            }
                        }
                    } else {
                        if (apiDetailData.getExpected().contains("")) {
                            if (respEnv.asString().contains(apiDetailData.getExpected())) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + "Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + "Not Match with Current Response");
                            }
                        }
                    }

                    //CS.assertTrue(respEnv.asString().contains(apiDetailData.getExpected()), apiDetailData.getExpected());
                    File PreprodJsonFile = new File(envJsonFilePath);
                    FileUtils.writeStringToFile(PreprodJsonFile, responseStringEnv);

                } catch (Exception e) {
                    childTest1.log(Status.FAIL, "Exception or Assert Error " + e.getMessage());
                    Assert.fail("Failed Testcase Please check log");
                }
                System.out.println(apiDetailData.getTestDataId() + " Child Test Finished");
            }
            // TestListner testListner = new TestListner();
            // testListner.childParentLink(parent);
            // Framework.extentReports.removeTest(parentTest1);
        }
        Framework.extentReports.flush();
    }

    @Test(groups = {"Daily_Dairy","Regression","Product_Offer"}, priority = 6, invocationCount = 1, threadPoolSize = 1)
    public void Dependent_APIData_delivery() {
        Framework frameWork = new Framework();
        List<APIData> apiData1 = frameWork.getDistributionAPI(APIData.class, "TRUE");
    /*    if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
            environmentData = framework.getData(EnvironmentParameterData.class, "api-qa");
        }else {
            environmentData = framework.getData(EnvironmentParameterData.class, "api-uat");
        }
      */
        environmentData = framework.getData(EnvironmentParameterData.class, "Delivery Server");
        baseUrl = environmentData.getBaseurl();
        String flowtype = "";
        AccountData accountData = null;
        for (APIData apiData : apiData1) {
            if (apiData.getParameter().contains("$mobile_number")) {
                if (count == 1) {
                    accountData = frameWork.getData(AccountData.class, "loginset26");
                    flowtype = "Existing User";
                } else if (count == 2) {
                    accountData = frameWork.getData(AccountData.class, "loginset2");
                    flowtype = "New User";
                }
                keyValuePairMap.put("$mobile_number", accountData.getMobile());
            }
            String parent = apiData.getName();
            // ExtentTest parentTest1 = testListener.startParent(apiData.getName() + " API Test "+flowtype);
            ExtentTest parentTest1 = testListener.startParent(flowtype + "Inventory Assign for Daily Dairy Product", "This test verifies that user is able to verify " + flowtype);
            //  parentTest1.setDescription("This test verifies that user is able to verify " + apiData.getName());
            TestRunner.parentExtentMap.put("parentTest1", parentTest1);
            String apiDetaildataId = apiData.getTestcaseid();
            List<APIDetailData> apiDetailDataList = frameWork.getDataList(APIDetailData.class, apiDetaildataId);
            for (APIDetailData apiDetailData : apiDetailDataList) {
                String envJsonFilePath = pathPreProd + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                String pathMasterFilePath = pathMaster + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                ExtentTest childTest1 = parentTest1.createNode(apiDetailData.getTestDataId() + " : This test verifies that user is able to verify " +  apiDetailData.getScenario());
                // childTest1.setDescription("This test verifies that user is able to verify " + apiData.getName() + apiDetailData.getScenario());
                //   TestListner.extentMap.get().put(apiDetailData.getTestDataId() + apiData.getName(), childTest1);
                TestListner.extentMap.get().put(apiDetailData.getTestDataId() + " : " + apiData.getName() + " API test with " + apiDetailData.getScenario(), childTest1);
                try {
                    String basePath = apiDetailData.getPath();

                    String parameter = apiDetailData.getParameter();

                    // CustomSoftAssert CS = new CustomSoftAssert(APIAssertData);
                    Method method = new Method();
                    String Header = apiDetailData.getHeader();
                    String MethodName = apiDetailData.getMethod();
                    String Setfield = apiData.getSetThisField();
                    Response respEnv;
                    System.out.println(Token);
                    String Pareameter = apiDetailData.getParameter();
                    long currentTimestamp = System.currentTimeMillis();
                    LocalDateTime timestampDateTime = LocalDateTime.ofInstant(
                            java.time.Instant.ofEpochMilli(currentTimestamp),
                            java.time.ZoneId.systemDefault()
                    );
                    keyValuePairMap.put("$timestamp", String.valueOf(currentTimestamp));
                    if (!(Setfield == "null" || Setfield.equalsIgnoreCase(""))) {
                        String[] setfield = Setfield.split(",");
                        for (int i = 0; i < setfield.length; i++) {
                            String value = keyValuePairMap.get(setfield[i]);
                            if (basePath.contains(setfield[i])) {
                                basePath = basePath.replace(setfield[i], value);
                                apiDetailData.setPath(basePath);
                                System.out.println(apiDetailData.getPath());
                            } else if (Pareameter.contains(setfield[i])) {
                                if(Pareameter.contains("$Box_id")){
                                    value= WebSuite_Trigger.Box_id;
                                }
                                Pareameter = Pareameter.replace(setfield[i], value);
                                System.out.println(Pareameter);
                                apiDetailData.setParameter(Pareameter);
                            } else if (Header.contains(setfield[i])) {
                                if (setfield[i].equalsIgnoreCase("$access_token")){
                                    Header = Header.replace(setfield[i], Token);
                                }else{
                                    Header = Header.replace(setfield[i], value);
                                }
                                // Header = Header.replace(setfield[i], value);
                                apiDetailData.setHeader(Header);
                                System.out.println(apiDetailData.getHeader());
                            }
                        }
                    }
                    if (keyValuePairMap.containsKey(Setfield)) {
                        String value = keyValuePairMap.get(Setfield);
                        if (basePath.contains(Setfield)) {
                            basePath = basePath.replace(Setfield, value);
                            apiDetailData.setPath(basePath);
                            System.out.println(apiDetailData.getPath());
                        } else if (Pareameter.contains(Setfield)) {
                            Pareameter = Pareameter.replace(Setfield, value);
                            System.out.println(Pareameter);
                        }

                    }
                    if (MethodName.contains("GET")) {
                        respEnv = method.GetMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("PUT")) {
                        respEnv = method.PutMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("DELETE")) {
                        respEnv = method.DeleteMethod(apiDetailData, environmentData, basePath);
                    } else {
                        respEnv = method.NewPostmethod(apiDetailData, environmentData, basePath);
                    }

                    String responseStringEnv = respEnv.asString();
                    if (respEnv.getStatusCode() == 200) {
                        childTest1.log(Status.PASS, "Status Code is " + respEnv.getStatusCode());
                        if ((!apiData.getUseThisField().isEmpty()) && (!(apiData.getUseThisField().contains("null"))) && (keyValuePairMap.get(apiData.getGetThisField())) == null) {
                            String temp = apiData.getUseThisField();
                            String Test = apiData.getGetThisField();
                            String[] test1 = Test.split(",", 5);
                            String[] temp1 = temp.split(",", 5);
                            for (int i = 0; i < temp1.length; i++) {
                                String value = method.GetField(respEnv, temp1[i]);
                                String key = test1[i];
                                keyValuePairMap.put(key, value);
                            }
                            System.out.println(Arrays.asList(keyValuePairMap));
                        }

                    } else if (respEnv.getStatusCode() == 500) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!! server error !!");
                    } else if (respEnv.getStatusCode() == 501) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!! Not Implemented !!");
                    } else if (respEnv.getStatusCode() == 502) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Bad GateWay  !!");
                    } else if (respEnv.getStatusCode() == 503) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Service Unavailable  !!");
                    } else if (respEnv.getStatusCode() == 504) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Gateway Timeout !!");
                    } else if (respEnv.getStatusCode() == 400) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Bad Request !!");
                    } else if (respEnv.getStatusCode() == 401) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  user is Unauthorized !!");
                    } else if (respEnv.getStatusCode() == 403) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Forbidden !!");
                    } else if (respEnv.getStatusCode() == 404) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Page Not Found !!");
                    }
                    else if (respEnv.getStatusCode() == 405) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Method Not Allowed !!");
                    }

                    childTest1.log(Status.INFO, "BaseURL: " + baseUrl);
                    childTest1.log(Status.INFO, "BasePath: " + apiDetailData.getPath());
                    childTest1.log(Status.INFO, "API Parameters: " + apiDetailData.getParameter());
                    childTest1.log(Status.INFO, "API Header" + apiDetailData.getHeader());
                    System.out.println("Request Sent:" + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, apiData.getMethod());
                    childTest1.log(Status.INFO, "Request Sent: " + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, "Response Received: " + respEnv.asString());
                    childTest1.log(Status.INFO, "Response Time :" + respEnv.getTime());
                    String gender = System.getProperty("Gender");
                    if (gender != null) {
                        if ((apiDetailData.getExpected().contains("null"))) {
                            if ((respEnv.asString().contains(apiDetailData.getExpected()) || (apiDetailData.getExpected().equalsIgnoreCase("null")))) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + "Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + "Not Match with Current Response");
                            }
                        }
                    } else {
                        if (apiDetailData.getExpected().contains("")) {
                            if (respEnv.asString().contains(apiDetailData.getExpected())) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + "Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + "Not Match with Current Response");
                            }
                        }
                    }

                    //CS.assertTrue(respEnv.asString().contains(apiDetailData.getExpected()), apiDetailData.getExpected());
                    File PreprodJsonFile = new File(envJsonFilePath);
                    FileUtils.writeStringToFile(PreprodJsonFile, responseStringEnv);

                } catch (Exception e) {
                    childTest1.log(Status.FAIL, "Exception or Assert Error " + e.getMessage());
                    Assert.fail("Failed Testcase Please check log");
                }
                System.out.println(apiDetailData.getTestDataId() + " Child Test Finished");
            }
            // TestListner testListner = new TestListner();
            // testListner.childParentLink(parent);
            // Framework.extentReports.removeTest(parentTest1);
        }
        Framework.extentReports.flush();
    }

    @Test(groups = {"Daily_FNV","Regression","Subscription_Offer"}, priority = 11, invocationCount = 1, threadPoolSize = 1)
    public void Dependent_APIData_delivery_FNV() {
        Framework frameWork = new Framework();
        List<APIData> apiData1 = frameWork.getDistributionAPI(APIData.class, "TRUE");
    /*    if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
            environmentData = framework.getData(EnvironmentParameterData.class, "api-qa");
        }else {
            environmentData = framework.getData(EnvironmentParameterData.class, "api-uat");
        }
      */
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")) {
            environmentData = framework.getData(EnvironmentParameterData.class, "Delivery Server");
        }else {
            environmentData = framework.getData(EnvironmentParameterData.class, "Delivery Server_UAT");
        }
        baseUrl = environmentData.getBaseurl();
        String flowtype = "";
        AccountData accountData = null;
        for (APIData apiData : apiData1) {
            if (apiData.getParameter().contains("$mobile_number")) {
                if (count == 1) {
                    accountData = frameWork.getData(AccountData.class, "loginset26");
                    flowtype = "Existing User";
                } else if (count == 2) {
                    accountData = frameWork.getData(AccountData.class, "loginset2");
                    flowtype = "New User";
                }
                keyValuePairMap.put("$mobile_number", accountData.getMobile());
            }
            String parent = apiData.getName();
            // ExtentTest parentTest1 = testListener.startParent(apiData.getName() + " API Test "+flowtype);
            ExtentTest parentTest1 = testListener.startParent(flowtype + "Inventory Assign for Daily FNV Product", "This test verifies that user is able to verify " + flowtype);
            //  parentTest1.setDescription("This test verifies that user is able to verify " + apiData.getName());
            TestRunner.parentExtentMap.put("parentTest1", parentTest1);
            String apiDetaildataId = apiData.getTestcaseid();
            List<APIDetailData> apiDetailDataList = frameWork.getDataList(APIDetailData.class, apiDetaildataId);
            for (APIDetailData apiDetailData : apiDetailDataList) {
                String envJsonFilePath = pathPreProd + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                String pathMasterFilePath = pathMaster + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                ExtentTest childTest1 = parentTest1.createNode(apiDetailData.getTestDataId() + " : This test verifies that user is able to verify " +  apiDetailData.getScenario());
                // childTest1.setDescription("This test verifies that user is able to verify " + apiData.getName() + apiDetailData.getScenario());
                //   TestListner.extentMap.get().put(apiDetailData.getTestDataId() + apiData.getName(), childTest1);
                TestListner.extentMap.get().put(apiDetailData.getTestDataId() + " : " + apiData.getName() + " API test with " + apiDetailData.getScenario(), childTest1);
                try {
                    String basePath = apiDetailData.getPath();

                    String parameter = apiDetailData.getParameter();

                    // CustomSoftAssert CS = new CustomSoftAssert(APIAssertData);
                    Method method = new Method();
                    String Header = apiDetailData.getHeader();
                    String MethodName = apiDetailData.getMethod();
                    String Setfield = apiData.getSetThisField();
                    Response respEnv;
                    System.out.println(Token);
                    String Pareameter = apiDetailData.getParameter();
                    long currentTimestamp = System.currentTimeMillis();
                    LocalDateTime timestampDateTime = LocalDateTime.ofInstant(
                            java.time.Instant.ofEpochMilli(currentTimestamp),
                            java.time.ZoneId.systemDefault()
                    );
                    keyValuePairMap.put("$timestamp", String.valueOf(currentTimestamp));
                    if (!(Setfield == "null" || Setfield.equalsIgnoreCase(""))) {
                        String[] setfield = Setfield.split(",");
                        for (int i = 0; i < setfield.length; i++) {
                            String value = keyValuePairMap.get(setfield[i]);
                            if (basePath.contains(setfield[i])) {
                                basePath = basePath.replace(setfield[i], value);
                                apiDetailData.setPath(basePath);
                                System.out.println(apiDetailData.getPath());
                            } else if (Pareameter.contains(setfield[i])) {
                                if(Pareameter.contains("$Box_id")){
                                    value= WebSuite_Trigger.Box_id;
                                }
                                Pareameter = Pareameter.replace(setfield[i], value);
                                System.out.println(Pareameter);
                                apiDetailData.setParameter(Pareameter);
                            }
                            else if (Header.contains(setfield[i]))
                            {
                                if (setfield[i].equalsIgnoreCase("$access_token")){
                                    Header = Header.replace(setfield[i], Token);
                                }else{
                                    Header = Header.replace(setfield[i], value);
                                }
                                // Header = Header.replace(setfield[i], value);
                                apiDetailData.setHeader(Header);
                                System.out.println(apiDetailData.getHeader());
                            }
                            else if (Pareameter.contains("$Box_id")){
                                Pareameter = Pareameter.replace("$Box_id", WebSuite_Trigger.Box_id);
                            }
                        }
                    }
                    if (keyValuePairMap.containsKey(Setfield)) {
                        String value = keyValuePairMap.get(Setfield);
                        if (basePath.contains(Setfield)) {
                            basePath = basePath.replace(Setfield, value);
                            apiDetailData.setPath(basePath);
                            System.out.println(apiDetailData.getPath());
                        } else if (Pareameter.contains(Setfield)) {
                            Pareameter = Pareameter.replace(Setfield, value);
                            System.out.println(Pareameter);
                        }

                    }
                    if (MethodName.contains("GET")) {
                        respEnv = method.GetMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("PUT")) {
                        respEnv = method.PutMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("DELETE")) {
                        respEnv = method.DeleteMethod(apiDetailData, environmentData, basePath);
                    } else {
                        respEnv = method.NewPostmethod(apiDetailData, environmentData, basePath);
                    }

                    String responseStringEnv = respEnv.asString();
                    if (respEnv.getStatusCode() == 200) {
                        childTest1.log(Status.PASS, "Status Code is " + respEnv.getStatusCode());
                        if ((!apiData.getUseThisField().isEmpty()) && (!(apiData.getUseThisField().contains("null"))) && (keyValuePairMap.get(apiData.getGetThisField())) == null) {
                            String temp = apiData.getUseThisField();
                            String Test = apiData.getGetThisField();
                            String[] test1 = Test.split(",", 5);
                            String[] temp1 = temp.split(",", 5);
                            for (int i = 0; i < temp1.length; i++) {
                                String value = method.GetField(respEnv, temp1[i]);
                                String key = test1[i];
                                keyValuePairMap.put(key, value);
                            }
                            System.out.println(Arrays.asList(keyValuePairMap));
                        }

                    } else if (respEnv.getStatusCode() == 500) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!! server error !!");
                    } else if (respEnv.getStatusCode() == 501) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!! Not Implemented !!");
                    } else if (respEnv.getStatusCode() == 502) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Bad GateWay  !!");
                    } else if (respEnv.getStatusCode() == 503) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Service Unavailable  !!");
                    } else if (respEnv.getStatusCode() == 504) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Gateway Timeout !!");
                    } else if (respEnv.getStatusCode() == 400) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Bad Request !!");
                    } else if (respEnv.getStatusCode() == 401) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  user is Unauthorized !!");
                    } else if (respEnv.getStatusCode() == 403) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Forbidden !!");
                    } else if (respEnv.getStatusCode() == 404) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Page Not Found !!");
                    }
                    else if (respEnv.getStatusCode() == 405) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Method Not Allowed !!");
                    }

                    childTest1.log(Status.INFO, "BaseURL: " + baseUrl);
                    childTest1.log(Status.INFO, "BasePath: " + apiDetailData.getPath());
                    childTest1.log(Status.INFO, "API Parameters: " + apiDetailData.getParameter());
                    childTest1.log(Status.INFO, "API Header" + apiDetailData.getHeader());
                    System.out.println("Request Sent:" + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, apiData.getMethod());
                    childTest1.log(Status.INFO, "Request Sent: " + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, "Response Received: " + respEnv.asString());
                    childTest1.log(Status.INFO, "Response Time :" + respEnv.getTime());
                    String gender = System.getProperty("Gender");
                    if (gender != null) {
                        if ((apiDetailData.getExpected().contains("null"))) {
                            if ((respEnv.asString().contains(apiDetailData.getExpected()) || (apiDetailData.getExpected().equalsIgnoreCase("null")))) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + "Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + "Not Match with Current Response");
                            }
                        }
                    } else {
                        if (apiDetailData.getExpected().contains("")) {
                            if (respEnv.asString().contains(apiDetailData.getExpected())) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + "Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + "Not Match with Current Response");
                            }
                        }
                    }

                    //CS.assertTrue(respEnv.asString().contains(apiDetailData.getExpected()), apiDetailData.getExpected());
                    File PreprodJsonFile = new File(envJsonFilePath);
                    FileUtils.writeStringToFile(PreprodJsonFile, responseStringEnv);

                } catch (Exception e) {
                    childTest1.log(Status.FAIL, "Exception or Assert Error " + e.getMessage());
                    Assert.fail("Failed Testcase Please check log");
                }
                System.out.println(apiDetailData.getTestDataId() + " Child Test Finished");
            }
            // TestListner testListner = new TestListner();
            // testListner.childParentLink(parent);
            // Framework.extentReports.removeTest(parentTest1);
        }
        Framework.extentReports.flush();
    }

    @Test(groups = {"Newsd"}, priority = 1, invocationCount = 1, threadPoolSize = 1)
    public void Dependent_API_Inventory() throws SQLException, ClassNotFoundException {
        Framework frameWork = new Framework();
        DataBaseActivity dataBaseActivity = new DataBaseActivity();
        List<APIData> apiData1 = frameWork.getdependentAPIdata(APIData.class, "TRUE");
        environmentData = framework.getData(EnvironmentParameterData.class, "inventory");
        AccountData accountData = frameWork.getData(AccountData.class, "loginset26");
        String flowtype = "";
        for (APIData apiData : apiData1) {
            if (apiData.getParameter().contains("$mobile_number")){
                keyValuePairMap.put("$mobile_number", accountData.getMobile());
            }
            ExtentTest parentTest1 = testListener.startParent(apiData.getName() + " API Test ","This test verifies that user is able to verify " + apiData.getName());
            //ExtentTest parentTest1 = testListener.startParent(flowtype + " Flow", "This test verifies that user is able to verify " + flowtype);
            // parentTest1.setDescription("This test verifies that user is able to verify " + apiData.getName());
            TestRunner.parentExtentMap.put("parentTest1", parentTest1);
            String apiDetaildataId = apiData.getTestcaseid();
            List<APIDetailData> apiDetailDataList = frameWork.getDataList(APIDetailData.class, apiDetaildataId);
            for (APIDetailData apiDetailData : apiDetailDataList) {
                String envJsonFilePath = pathPreProd + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                String pathMasterFilePath = pathMaster + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                ExtentTest childTest1 = parentTest1.createNode(apiDetailData.getTestDataId()+ " : "  + apiDetailData.getScenario());
                // childTest1.setDescription("This test verifies that user is able to verify " + apiData.getName() + apiDetailData.getScenario());
                //   TestListner.extentMap.get().put(apiDetailData.getTestDataId() + apiData.getName(), childTest1);
                TestListner.extentMap.get().put(apiDetailData.getTestDataId() + " : " + apiData.getName() + " API test with " + apiDetailData.getScenario(), childTest1);
                try {
                    String basePath = apiDetailData.getPath();

                    String parameter = apiDetailData.getParameter();

                    // CustomSoftAssert CS = new CustomSoftAssert(APIAssertData);
                    Method method = new Method();
                    String Header = apiDetailData.getHeader();
                    String MethodName = apiDetailData.getMethod();
                    String Setfield = apiData.getSetThisField();
                    Response respEnv;
                    String Pareameter = apiDetailData.getParameter();
                    if (!(Setfield == "null" || Setfield.equalsIgnoreCase(""))) {
                        String[] setfield = Setfield.split(",");
                        for (int i = 0; i < setfield.length; i++) {
                            String value = keyValuePairMap.get(setfield[i]);
                            if (basePath.contains(setfield[i])) {
                                basePath = basePath.replace(setfield[i], value);
                                apiDetailData.setPath(basePath);
                                System.out.println(apiDetailData.getPath());
                            } else if (Pareameter.contains(setfield[i])) {
                                Pareameter = Pareameter.replace(setfield[i], value);
                                System.out.println(Pareameter);
                                apiDetailData.setParameter(Pareameter);
                            } else if (Header.contains(setfield[i])) {
                                Header = Header.replace(setfield[i], value);
                                apiDetailData.setHeader(Header);
                                System.out.println(apiDetailData.getHeader());
                            }
                        }
                    }
                    if (keyValuePairMap.containsKey(Setfield)) {
                        String value = keyValuePairMap.get(Setfield);
                        if (basePath.contains(Setfield)) {
                            basePath = basePath.replace(Setfield, value);
                            apiDetailData.setPath(basePath);
                            System.out.println(apiDetailData.getPath());
                        } else if (Pareameter.contains(Setfield)) {
                            Pareameter = Pareameter.replace(Setfield, value);
                            System.out.println(Pareameter);
                        }

                    }
                    if (MethodName.contains("GET")) {
                        respEnv = method.GetMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("PUT")) {
                        respEnv = method.PutMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("DELETE")) {
                        respEnv = method.DeleteMethod(apiDetailData, environmentData, basePath);
                    } else {
                        respEnv = method.NewPostmethod(apiDetailData, environmentData, basePath);
                    }

                    String responseStringEnv = respEnv.asString();
                    if(Integer.toString(respEnv.getStatusCode()).equalsIgnoreCase(apiDetailData.getStatus()) && !(respEnv.getStatusCode() == 200))
                    {childTest1.log(Status.PASS, "status code is " + respEnv.getStatusCode());}
                    else{
                        if (respEnv.getStatusCode() == 200 ) {
                            childTest1.log(Status.PASS, "Status Code is " + respEnv.getStatusCode());
                            if ((!apiData.getUseThisField().isEmpty()) && (!(apiData.getUseThisField().contains("null"))) && (keyValuePairMap.get(apiData.getGetThisField())) == null && responseStringEnv.contains("\"error\":false")) {
                                String temp = apiData.getUseThisField();
                                String Test = apiData.getGetThisField();
                                String[] test1 = Test.split(",", 5);
                                String[] temp1 = temp.split(",", 5);
                                for (int i = 0; i < temp1.length; i++) {
                                    String value = method.GetField(respEnv, temp1[i]);
                                    String key = test1[i];
                                    keyValuePairMap.put(key, value);
                                }
                                System.out.println(Arrays.asList(keyValuePairMap));
                            }

                        } else if (respEnv.getStatusCode() == 500) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!! server error !!");
                        } else if (respEnv.getStatusCode() == 501) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!! Not Implemented !!");
                        } else if (respEnv.getStatusCode() == 502) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  Bad GateWay  !!");
                        } else if (respEnv.getStatusCode() == 503) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  Service Unavailable  !!");
                        } else if (respEnv.getStatusCode() == 504) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  Gateway Timeout !!");
                        } else if (respEnv.getStatusCode() == 400) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  Bad Request !!");
                        } else if (respEnv.getStatusCode() == 401) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  user is Unauthorized !!");
                        } else if (respEnv.getStatusCode() == 403) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  Forbidden !!");
                        } else if (respEnv.getStatusCode() == 404) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  Page Not Found !!");
                        } else if (respEnv.getStatusCode() == 405) {
                            childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                            System.out.println("!!  Method Not Allowed !!");
                        }
                    }

                    childTest1.log(Status.INFO, "BaseURL: " + baseUrl);
                    childTest1.log(Status.INFO, "BasePath: " + apiDetailData.getPath());
                    childTest1.log(Status.INFO, "API Parameters: " + apiDetailData.getParameter());
                    childTest1.log(Status.INFO, "API Header: " + apiDetailData.getHeader());
                    System.out.println("Request Sent: " + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, apiData.getMethod());
                    childTest1.log(Status.INFO, "Request Sent: " + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, "Response Received: " + respEnv.asString());
                    childTest1.log(Status.INFO, "Response Time :" + respEnv.getTime());
                    String gender = System.getProperty("Gender");
                    if (gender != null) {
                        if ((apiDetailData.getExpected().contains("null"))) {
                            if ((respEnv.asString().contains(apiDetailData.getExpected()) || (apiDetailData.getExpected().equalsIgnoreCase("null")))) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + " Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + " Not Match with Current Response");
                            }
                        }
                    } else {
                        if (apiDetailData.getExpected().contains("")) {
                            if (respEnv.asString().contains(apiDetailData.getExpected())) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + " Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + " Not Match with Current Response");
                            }
                        }
                    }

                    //CS.assertTrue(respEnv.asString().contains(apiDetailData.getExpected()), apiDetailData.getExpected());
                    File PreprodJsonFile = new File(envJsonFilePath);
                    FileUtils.writeStringToFile(PreprodJsonFile, responseStringEnv);

                } catch (Exception e) {
                    childTest1.log(Status.FAIL, "Exception or Assert Error " + e.getMessage());
                    Assert.fail("Failed Testcase Please check log");
                }
                System.out.println(apiDetailData.getTestDataId() + " Child Test Finished");
            }
            // TestListner testListner = new TestListner();
            // testListner.childParentLink(parent);
            // Framework.extentReports.removeTest(parentTest1);
        }
        Framework.extentReports.flush();
    }

    @Test(groups = {"Order_Create_API"}, priority = 1)
    public void Create_order_and_Delivery() throws SQLException, ClassNotFoundException {
        Framework frameWork = new Framework();
        Method method = new Method();
        List<APIData> apiData1 = frameWork.getOrderCreateAPIdata(APIData.class, "TRUE");
        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
            environmentData = framework.getData(EnvironmentParameterData.class, "api-qa");
        }else {
            environmentData = framework.getData(EnvironmentParameterData.class, "api-uat");
        }
        //environmentData = framework.getData(EnvironmentParameterData.class, "api");
        String flowtype = "";
        AccountData accountData = null;
        String $Product_id="101";
        String $Qty="1";
        String $mobile_number = "4444445586";
       Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, +1);
        String $current_date= new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
      //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
      //  String $current_date=LocalDate.now().format(formatter).toString();
        for (APIData apiData : apiData1) {
            if(System.getProperty("Product_id")!=null){
                $Product_id= System.getProperty("Product_id");
                $Qty = System.getProperty("Qty");
                $mobile_number = System.getProperty("mobile_Number");
            }
            long currentTimestamp = System.currentTimeMillis();
             keyValuePairMap.put("$Product_id", $Product_id);
            keyValuePairMap.put("$Qty", $Qty);
            keyValuePairMap.put("$mobile_number", $mobile_number);
            keyValuePairMap.put("$current_date", $current_date);
            keyValuePairMap.put("$timestamp", String.valueOf(currentTimestamp));
            String parent = apiData.getName();
          //  method.Delete_Login_Data(keyValuePairMap.get("$mobile_number"));
            // ExtentTest parentTest1 = testListener.startParent(apiData.getName() + " API Test "+flowtype);
            ExtentTest parentTest1 = testListener.startParent("Create_order_and_Delivery", "This test verifies that user is able to verify " + flowtype);
            //  parentTest1.setDescription("This test verifies that user is able to verify " + apiData.getName());
            TestRunner.parentExtentMap.put("parentTest1", parentTest1);
            String apiDetaildataId = apiData.getTestcaseid();
            DB_Connection dbconnection = new DB_Connection();
            List<APIDetailData> apiDetailDataList = frameWork.getDataList(APIDetailData.class, apiDetaildataId);
            for (APIDetailData apiDetailData : apiDetailDataList) {
                String envJsonFilePath = pathPreProd + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                String pathMasterFilePath = pathMaster + "\\" + apiData.getName() + "_" + apiData.getTestcaseid() + "\\" + apiData.getName() + "Response" + apiDetailData.getTestDataId();
                ExtentTest childTest1 = parentTest1.createNode(apiDetailData.getTestDataId() + " : This test verifies that user is able to verify " +  apiDetailData.getScenario());
                // childTest1.setDescription("This test verifies that user is able to verify " + apiData.getName() + apiDetailData.getScenario());
                //   TestListner.extentMap.get().put(apiDetailData.getTestDataId() + apiData.getName(), childTest1);
                TestListner.extentMap.get().put(apiDetailData.getTestDataId() + " : " + apiData.getName() + " API test with " + apiDetailData.getScenario(), childTest1);
                try {
                    if(apiData.getTestcaseid().equals("TC80")){
                        AppSuite_Trigger appSuiteTrigger = new AppSuite_Trigger();
                        String $DB_Id= appSuiteTrigger.Order_Sync_Regular_Order_API();
                        keyValuePairMap.put("$DB_Id",$DB_Id);
                    }
                    String basePath = apiDetailData.getPath();
                    if(apiData.getName().contains("Delivery")){
                        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
                            environmentData = framework.getData(EnvironmentParameterData.class, "Delivery");
                        }else {
                            environmentData = framework.getData(EnvironmentParameterData.class, "Delivery Server_UAT");
                        }
                    }else {
                        if (CommonConstant.Environment().equalsIgnoreCase("QA Server")){
                            environmentData = framework.getData(EnvironmentParameterData.class, "api-qa");
                        }else {
                            environmentData = framework.getData(EnvironmentParameterData.class, "api-uat");
                        }
                    }
                    if(apiDetailData.getTestDataId().equals("TC70_TD1")){
                        CommonConstant.GetCustomerId_Dairy = CommonConstant.GetCustomerId_Dairy.replace("$mobilenumber", $mobile_number);
                        System.out.println(CommonConstant.GetCustomerId_Dairy);
                       String  CUSTOMER_ID = dbconnection.DBConnectionMem(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, CommonConstant.GetCustomerId_Dairy).get("ID");
                        childTest1.log(Status.INFO,"Customer Id - "+CUSTOMER_ID);
                        String update_Address = CommonConstant.Update_DC.replace("$CUSTOMER", CUSTOMER_ID);
                        dbconnection.DBConnectionMemUpdate(CommonConstant.DBURL, CommonConstant.username, CommonConstant.Password, update_Address);
                        keyValuePairMap.put("$customer_id",CUSTOMER_ID);
                    }

                    String parameter = apiDetailData.getParameter();

                    // CustomSoftAssert CS = new CustomSoftAssert(APIAssertData);
                //    Method method = new Method();
                    String Header = apiDetailData.getHeader();
                    String MethodName = apiDetailData.getMethod();
                    String Setfield = apiData.getSetThisField();
                    Response respEnv;
                    String Pareameter = apiDetailData.getParameter();
                    if (!(Setfield == "null" || Setfield.equalsIgnoreCase(""))) {
                        String[] setfield = Setfield.split(",");
                        for (int i = 0; i < setfield.length; i++) {
                            String value = keyValuePairMap.get(setfield[i]);
                            if (basePath.contains(setfield[i])) {
                                basePath = basePath.replace(setfield[i], value);
                                apiDetailData.setPath(basePath);
                                System.out.println(apiDetailData.getPath());
                            }
                            if (Pareameter.contains(setfield[i])) {
                                Pareameter = Pareameter.replace(setfield[i], value);
                                System.out.println(Pareameter);
                                apiDetailData.setParameter(Pareameter);
                            }
                            if (Header.contains(setfield[i])) {
                                Header = Header.replace(setfield[i], value);
                                apiDetailData.setHeader(Header);
                                System.out.println(apiDetailData.getHeader());
                            }
                        }
                    }
                    if (keyValuePairMap.containsKey(Setfield)) {
                        String value = keyValuePairMap.get(Setfield);
                        if (basePath.contains(Setfield)) {
                            basePath = basePath.replace(Setfield, value);
                            apiDetailData.setPath(basePath);
                            System.out.println(apiDetailData.getPath());
                        } else if (Pareameter.contains(Setfield)) {
                            Pareameter = Pareameter.replace(Setfield, value);
                            System.out.println(Pareameter);
                        }

                    }
                    if (MethodName.contains("GET")) {
                        respEnv = method.GetMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("PUT")) {
                        respEnv = method.PutMethod(apiDetailData, environmentData, basePath);
                    } else if (MethodName.contains("DELETE")) {
                        respEnv = method.DeleteMethod(apiDetailData, environmentData, basePath);
                    } else {
                        respEnv = method.NewPostmethod(apiDetailData, environmentData, basePath);
                    }

                    String responseStringEnv = respEnv.asString();
                    if (respEnv.getStatusCode() == 200 || respEnv.getStatusCode() == Integer.parseInt(apiDetailData.getStatus())) {
                        childTest1.log(Status.PASS, "Status Code is " + respEnv.getStatusCode());
                        if ((!apiData.getUseThisField().isEmpty()) && (!(apiData.getUseThisField().contains("null"))) && (keyValuePairMap.get(apiData.getGetThisField())) == null) {
                            String temp = apiData.getUseThisField();
                            String Test = apiData.getGetThisField();
                            String[] test1 = Test.split(",", 5);
                            String[] temp1 = temp.split(",", 5);
                            for (int i = 0; i < temp1.length; i++) {
                                String value = method.GetField(respEnv, temp1[i]);
                                String key = test1[i];
                                keyValuePairMap.put(key, value);
                            }
                            System.out.println(Arrays.asList(keyValuePairMap));
                        }

                    } else if (respEnv.getStatusCode() == 500) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!! server error !!");
                    } else if (respEnv.getStatusCode() == 501) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!! Not Implemented !!");
                    } else if (respEnv.getStatusCode() == 502) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Bad GateWay  !!");
                    } else if (respEnv.getStatusCode() == 503) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Service Unavailable  !!");
                    } else if (respEnv.getStatusCode() == 504) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Gateway Timeout !!");
                    } else if (respEnv.getStatusCode() == 400) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Bad Request !!");
                    } else if (respEnv.getStatusCode() == 401) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  user is Unauthorized !!");
                    } else if (respEnv.getStatusCode() == 403) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Forbidden !!");
                    } else if (respEnv.getStatusCode() == 404) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Page Not Found !!");
                    }
                    else if (respEnv.getStatusCode() == 405) {
                        childTest1.log(Status.FAIL, "status code is " + respEnv.getStatusCode());
                        System.out.println("!!  Method Not Allowed !!");
                    }

                    childTest1.log(Status.INFO, "BaseURL: " + environmentData.getBaseurl());
                    childTest1.log(Status.INFO, "BasePath: " + apiDetailData.getPath());
                    childTest1.log(Status.INFO, "API Parameters: " + apiDetailData.getParameter());
                    childTest1.log(Status.INFO, "API Header" + apiDetailData.getHeader());
                    System.out.println("Request Sent:" + baseUrl + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, apiData.getMethod());
                    childTest1.log(Status.INFO, "Request Sent: " + environmentData.getBaseurl() + "/" + apiDetailData.getPath() + "?" + Pareameter);
                    childTest1.log(Status.INFO, "Response Received: " + respEnv.asString());
                    childTest1.log(Status.INFO, "Response Time :" + respEnv.getTime());
                    String gender = System.getProperty("Gender");
                    if (gender != null) {
                        if ((apiDetailData.getExpected().contains("null"))) {
                            if ((respEnv.asString().contains(apiDetailData.getExpected()) || (apiDetailData.getExpected().equalsIgnoreCase("null")))) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + "Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + "Not Match with Current Response");
                            }
                        }
                    } else {
                        if (apiDetailData.getExpected().contains("")) {
                            if (respEnv.asString().contains(apiDetailData.getExpected())) {
                                childTest1.log(Status.PASS, "Expected Condition " + apiDetailData.getExpected() + "Match with Current Response");
                            } else {
                                childTest1.log(Status.FAIL, "Excepted Condition " + apiDetailData.getExpected() + "Not Match with Current Response");
                            }
                        }
                    }

                    //CS.assertTrue(respEnv.asString().contains(apiDetailData.getExpected()), apiDetailData.getExpected());
                    File PreprodJsonFile = new File(envJsonFilePath);
                    FileUtils.writeStringToFile(PreprodJsonFile, responseStringEnv);

                } catch (Exception e) {
                    childTest1.log(Status.FAIL, "Exception or Assert Error " + e.getMessage());
                    Assert.fail("Failed Testcase Please check log");
                }
                System.out.println(apiDetailData.getTestDataId() + " Child Test Finished");
            }
            // TestListner testListner = new TestListner();
            // testListner.childParentLink(parent);
            // Framework.extentReports.removeTest(parentTest1);
        }
        Framework.extentReports.flush();
    }
}
