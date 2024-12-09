package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.ElementControl;

public class Loginpage extends BasePage {

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

    

    // Logic

    public Loginpage(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);

        
    }

    public void navigateToLoginpage() {

        elementControl.click(signinLink);

    }

    public void loginToApplication(String useremail, String password) {

        elementControl.writetext(emailField, useremail);

        elementControl.writetext(passwordField, password);

        elementControl.click(signinButton);

    }

    public String getUserprofilename() {
        return elementControl.getElementText(userProfile);
    }
}
