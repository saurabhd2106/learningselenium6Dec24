package testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import commonLibs.CommonDriver;

import pages.Amazonpage;
import pages.Loginpage;
import utils.ConfigUtil;
import utils.DateTimeUtils;
import utils.ReportUtils;

public class BaseTest {

    CommonDriver cmnDriver;

    Loginpage loginpage;

    Amazonpage amazonpage;

    WebDriver driver;

    Properties configProperties;

    String currentWorkingDirectory;

    String reportFilname;

    ReportUtils reportUtils;

    String currentExecutionTime;

    @BeforeClass
    public void preSetup() throws Exception{

        currentWorkingDirectory = System.getProperty("user.dir");

        String filename = String.format("%s/config/config.properties", currentWorkingDirectory);

        configProperties = ConfigUtil.readConfigFile(filename);

        currentExecutionTime = DateTimeUtils.getCurrentDateAndTime();

        reportFilname = String.format("%s/reports/report-%s.html", currentWorkingDirectory, currentExecutionTime);
        
        reportUtils = new ReportUtils(reportFilname);

    }

    @AfterClass
    public void postCleanup(){
        reportUtils.flushReport();
    }

    @BeforeMethod
    public void setup() throws Exception {

        cmnDriver = new CommonDriver(configProperties.getProperty("browserType"));

        driver = cmnDriver.getDriver();

        loginpage = new Loginpage(driver);

        amazonpage = new Amazonpage(driver);

    }

    @AfterMethod
    public void cleanup() {

        cmnDriver.closeAllBrowser();

    }

}
