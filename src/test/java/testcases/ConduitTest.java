package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonLibs.CommonDriver;
import pages.Loginpage;

public class ConduitTest {

    @Test
    public void verifyLoginToApplication() throws Exception {

        CommonDriver cmnDriver = new CommonDriver("chrome");

        cmnDriver.navigateToUrl("http://localhost:3000");

        WebDriver driver = cmnDriver.getDriver();

        Loginpage loginpage = new Loginpage(driver);

        loginpage.navigateToLoginpage();

        loginpage.loginToApplication("test@abc.com", "testpassword");

        String username = loginpage.getUserprofilename();

        Assert.assertEquals(username, "saurabh");

        cmnDriver.closeAllBrowser();

    }

    @Test
    public void verifyAddArticle() throws Exception{

        CommonDriver cmnDriver = new CommonDriver("chrome");

        cmnDriver.navigateToUrl("http://localhost:3000");

        WebDriver driver = cmnDriver.getDriver();

        Loginpage loginpage = new Loginpage(driver);

        loginpage.navigateToLoginpage();

        loginpage.loginToApplication("test@abc.com", "testpassword");


        // Add the logic to add article


        cmnDriver.closeAllBrowser();

    }

}
