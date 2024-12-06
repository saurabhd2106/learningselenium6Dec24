package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropExample {

    @Test
    public void DragAndDrop(){


        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://jqueryui.com/droppable/");

        WebElement frameElement = driver.findElement(By.className("demo-frame"));

        driver.switchTo().frame(frameElement);

        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);

        action.dragAndDrop(source, target).build().perform();

    }
    
}
