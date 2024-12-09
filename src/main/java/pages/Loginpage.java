package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {


    // 1. Declare all web elements using @FindBy annotation

    // 2. Initialise the element using Page Factory

    // 3. Call logic using methods 

    @FindBy(linkText = "Sign in")
    WebElement signinLink;

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;


    @FindBy(xpath = "//button[@type='submit']")
    WebElement signinButton;

    @FindBy(xpath = "//a[contains(@href , 'profile')]")
    WebElement userProfile;

    //Logic

    public Loginpage(WebDriver driver) {
        
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginpage(){

        signinLink.click();

    }

    public void loginToApplication(String useremail, String password) {

        emailField.sendKeys(useremail);

        passwordField.sendKeys(password);

        signinButton.click();

    }
    

    public String getUserprofilename(){
        return userProfile.getText();
    }
}
