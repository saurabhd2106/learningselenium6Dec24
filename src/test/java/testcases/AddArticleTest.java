package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddArticleTest {

    @Test
    public void addNewArticle(){

        // opens driver
        ChromeDriver driver = new ChromeDriver();
        // maximize driver to full screenn
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // go to url
        driver.get("http://localhost:3000");

        driver.findElement(By.linkText("Sign in")).click();

        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("test@kholo.co.za");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("testpassword");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String username = driver.findElement(By.xpath("//a[contains(@href , 'profile')]")).getText();

        Assert.assertEquals(username, "kholo");

        // open article link
       // driver.get("http://localhost:3000/editor");

       driver.findElement(By.linkText("New Article")).click();

        // input data
        // 1. article title
        driver.findElement(By.xpath("//input[@placeholder='Article Title']"))
        .sendKeys("Hello automated article Title");

        // 2. article description
        driver.findElement(By.xpath("//input[@placeholder=\"What's this article about?\"]"))
                .sendKeys("This is an automated article DESCRIPTION");

        // 3. Article
        driver.findElement(By.xpath("//textarea[@placeholder=\"Write your article (in markdown)\"]"))
                .sendKeys("This is an automated article BODY. I used Selerium to create this article");
        // String enterArticle =
        // driver.findElement(By.xpath("//input[@placeholder='Write your article (in
        // markdown)']")).getText();

        // String enterArticles =
        // driver.findElement(By.xpath("//textarea[contains(@placeholder, 'Write your
        // article')]")).getText();

        // Assert.assertEquals(enterArticles,"This is an automated article BODY. I used
        // Selerium to create this article");

        // 4. tags
        driver.findElement(By.xpath("//input[@placeholder='Enter tags']")).sendKeys("automated article hooray");

        // 5. submit
         driver.findElement(By.xpath("//button[@type='button']")).click();
      
        driver.findElement(By.xpath("//button[text() = 'Publish']")).click();

        String actualTitle =  driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(actualTitle, "Hello automated article Title");
    }
    
}
