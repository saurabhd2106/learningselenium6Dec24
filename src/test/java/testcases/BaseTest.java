package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import commonLibs.CommonDriver;
import pages.Loginpage;

public class BaseTest {

    CommonDriver cmnDriver;

    Loginpage loginpage;

    @BeforeMethod
    public void setup() throws Exception {

        cmnDriver = new CommonDriver("chrome");

        cmnDriver.navigateToUrl("http://localhost:3000");

        WebDriver driver = cmnDriver.getDriver();

        loginpage = new Loginpage(driver);

    }

    @AfterMethod
    public void cleanup() {

        cmnDriver.closeAllBrowser();

    }

}
