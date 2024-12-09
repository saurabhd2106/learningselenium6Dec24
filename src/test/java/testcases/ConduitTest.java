package testcases;

import org.testng.Assert;

import org.testng.annotations.Test;



public class ConduitTest extends BaseTest{

    @Test
    public void verifyLoginToApplication() throws Exception {

        loginpage.navigateToLoginpage();

        loginpage.loginToApplication("test@abc.com", "testpassword");

        String username = loginpage.getUserprofilename();

        Assert.assertEquals(username, "saurabh");

    }

    @Test
    public void verifyAddArticle() throws Exception {

        loginpage.navigateToLoginpage();

        loginpage.loginToApplication("test@abc.com", "testpassword");

        // Add the logic to add article

    }

}
