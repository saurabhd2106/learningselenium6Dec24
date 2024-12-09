package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazonpage {

    // 1. Define (or declare) all web elements

    @FindBy(id = "searchDropdownBox")
    WebElement categoryDropwdown;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchTextbox;

    @FindBy(xpath = "//input[@value='Go']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@data-component-type=\"s-search-result\"]")
    List<WebElement> allProducts;



    // 2. Initialise the web elements

    public Amazonpage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    // 3. Write logic

    public void searchProduct(String productName, String productCategory) {

    }

    public String getFirstProductDetails() {

    return "";        

    }

    public String getNthProduct(){

        return ""; 

    }


    public List<String> getAllProducts(){

        return null; 

    }


    
}
