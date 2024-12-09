package testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import commonLibs.CommonDriver;

import pages.Amazonpage;
import pages.Loginpage;
import utils.ConfigUtil;

public class BaseTest {

    CommonDriver cmnDriver;

    Loginpage loginpage;

    Amazonpage amazonpage;

    WebDriver driver;

    Properties configProperties;

    String currentWorkingDirectory;

    @BeforeClass
    public void preSetup() throws Exception{

        currentWorkingDirectory = System.getProperty("user.dir");

        String filename = String.format("%s/config/config.properties", currentWorkingDirectory);

        configProperties = ConfigUtil.readConfigFile(filename);

    }

    @BeforeMethod
    public void setup() throws Exception {

        cmnDriver = new CommonDriver(configProperties.getProperty("amazonurl"));

        driver = cmnDriver.getDriver();

        loginpage = new Loginpage(driver);

        amazonpage = new Amazonpage(driver);

    }

    @AfterMethod
    public void cleanup() {

        cmnDriver.closeAllBrowser();

    }

}
