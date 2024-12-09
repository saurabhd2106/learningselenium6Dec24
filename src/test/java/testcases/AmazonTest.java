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

public class AmazonTest extends BaseTest {

    @Test
    public void searchProducts() throws Exception {

        cmnDriver.navigateToUrl("https://amazon.com");
      
        String productName = "Apple Watch";

        String category = "Electronics";

        amazonpage.searchProduct(productName, category);

        int numberOfProducts = amazonpage.getProductCount();

        System.out.println("Number of products are " + numberOfProducts);

        Assert.assertTrue(numberOfProducts > 10);

        // Get the first product

        String firstProductDetail = amazonpage.getFirstProductDetails();

        Assert.assertTrue(firstProductDetail.toLowerCase().contains("apple"));

        // Get the 10th product

        String nthproductDetails = amazonpage.getNthProduct(9);

        Assert.assertTrue(nthproductDetails.toLowerCase().contains("watch"));

        List<String> allProductDetails = amazonpage.getAllProducts();

        for(String productDetail : allProductDetails) {
            Assert.assertTrue(productDetail.toLowerCase().contains("watch"));
        }

    }

}
