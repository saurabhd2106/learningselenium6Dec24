package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonLibs.CommonDriver;
import pages.Loginpage;

public class ConduitTest {

    CommonDriver cmnDriver;

    Loginpage loginpage;

    @BeforeMethod
    public void setup() throws Exception{


        cmnDriver = new CommonDriver("chrome");

        cmnDriver.navigateToUrl("http://localhost:3000");

        WebDriver driver = cmnDriver.getDriver();

        loginpage = new Loginpage(driver);

    }


    @AfterMethod
    public void cleanup(){

        cmnDriver.closeAllBrowser();


    }

    @Test
    public void verifyLoginToApplication() throws Exception {

        
       

        loginpage.navigateToLoginpage();

        loginpage.loginToApplication("test@abc.com", "testpassword");

        String username = loginpage.getUserprofilename();

        Assert.assertEquals(username, "saurabh");

       
    }

    @Test
    public void verifyAddArticle() throws Exception{

      

        loginpage.navigateToLoginpage();

        loginpage.loginToApplication("test@abc.com", "testpassword");


        // Add the logic to add article


     

    }

}
