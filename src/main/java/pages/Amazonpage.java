package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazonpage extends BasePage{

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

        super(driver);

        PageFactory.initElements(driver, this);

        

    }

    // 3. Write logic

    public void searchProduct(String productName, String productCategory) {

        elementControl.selectViaVisibleText(categoryDropwdown, productCategory);

        elementControl.writetext(searchTextbox, productName);

        elementControl.click(searchButton);

    }

    public int getProductCount(){
        return allProducts.size();
    }

    public String getFirstProductDetails() {

    return elementControl.getElementText(allProducts.get(0));        

    }

    public String getNthProduct(int index){

        return elementControl.getElementText(allProducts.get(index)); 

    }


    public List<String> getAllProducts(){

        List<String> allProductDetails = new ArrayList<>();
        
        for(WebElement product: allProducts) {

            elementControl.moveToElement(product);

            allProductDetails.add(product.getText());
        }

        return allProductDetails;

    }


    
}
