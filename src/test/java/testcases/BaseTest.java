package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import commonLibs.CommonDriver;
import pages.Amazonpage;
import pages.Loginpage;

public class BaseTest {

    CommonDriver cmnDriver;

    Loginpage loginpage;

    Amazonpage amazonpage;

    WebDriver driver;

    @BeforeMethod
    public void setup() throws Exception {

        cmnDriver = new CommonDriver("chrome");

       

        driver = cmnDriver.getDriver();

        loginpage = new Loginpage(driver);

        amazonpage = new Amazonpage(driver);

    }

    @AfterMethod
    public void cleanup() {

        cmnDriver.closeAllBrowser();

    }

}
