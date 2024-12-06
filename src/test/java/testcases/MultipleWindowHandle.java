package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleWindowHandle {

    @Test
    public void multipleWindoHandleTest(){
        
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://playwright.dev/");

        // 1. Get the unique id ( Window Handle ) that represent the parent window

        String primaryWindowHandle = driver.getWindowHandle();

    
        driver.findElement(By.xpath("//img[@alt='VS Code']//parent::a")).click();

        // 2. Get the unique id ( Window Handle ) that represent the child window

        String secondaryWindowHandle = driver.getWindowHandles().toArray()[1].toString();

        // 3. Switch to the child window

        driver.switchTo().window(secondaryWindowHandle);

        // 4. Perform some actions on child window

        String secondaryWindowTitle = driver.getTitle();

        Assert.assertEquals(secondaryWindowTitle, "Visual Studio Code - Code Editing. Redefined");

        // 5. close the child window

        driver.close();

        // 6. Switch back to parent window

        driver.switchTo().window(primaryWindowHandle);



    }
    
}
