package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest {

    @Test
    public void searchProducts() {
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://amazon.com");

        String productName = "Apple Watch";

        String category = "Electronics";

        WebElement categoryDropdown = driver.findElement(By.id("searchDropdownBox"));

        Select dropdown = new Select(categoryDropdown);

        dropdown.selectByVisibleText(category);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productName);

        driver.findElement(By.xpath("//input[@value='Go']")).click();

        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@data-component-type=\"s-search-result\"]"));

        int numberOfProducts = allProducts.size();

        System.out.println("Number of products are " + numberOfProducts);

        Assert.assertTrue(numberOfProducts > 10);

        // Get the first product

        String firstProductDetail = allProducts.get(0).getText();

        Assert.assertTrue(firstProductDetail.toLowerCase().contains("apple"));

        // Get the 10th product

        String nthproductDetails = allProducts.get(9).getText();

        Assert.assertTrue(nthproductDetails.toLowerCase().contains("watch"));

        Actions action = new Actions(driver);

        // Assert all product info!

        for (WebElement product : allProducts) {

            action.moveToElement(product).build().perform();

            String productInfo = product.getText();

            Assert.assertTrue(productInfo.toLowerCase().contains("watch"));

        }

    }

}
