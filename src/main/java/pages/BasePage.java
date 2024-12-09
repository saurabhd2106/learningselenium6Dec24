package pages;

import org.openqa.selenium.WebDriver;

import commonLibs.ElementControl;

public class BasePage {

    ElementControl elementControl;

    public BasePage(WebDriver driver) {

        elementControl = new ElementControl(driver);
        
    }
    
}
