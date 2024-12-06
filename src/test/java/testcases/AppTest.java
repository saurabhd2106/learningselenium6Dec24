package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void verifyTitleOfThePage() {

        // 1. Prepare the test data and the prerequisites

        // 1. Initialise the browser instance and opens the browser
        ChromeDriver driver = new ChromeDriver();

        // 2. Maximise the screen
        driver.manage().window().maximize();

        // 3. Navigate to the URL
        driver.get("http://localhost:3000");

        String title = driver.getTitle();

        Assert.assertEquals(title, "Conduit");

        driver.quit();

    }

    @Test
    public void loginToApplication() {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("http://localhost:3000");

        driver.findElement(By.linkText("Sign in")).click();

        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("test@abc.com");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("testpassword");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String username = driver.findElement(By.xpath("//a[contains(@href , 'profile')]")).getText();


        Assert.assertEquals(username, "saurabh");

    }

}
