package commonLibs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementControl {

    private WebDriver driver;

    public ElementControl(WebDriver driver) {

        this.driver = driver;
        
    }

    public void click(WebElement element){

        element.click();

    }

    public void writetext(WebElement element, String textToWrite){

        element.sendKeys(textToWrite);

    }

    public void selectViaVisibleText(WebElement element, String text){

        Select select = new Select(element);

        select.selectByVisibleText(text);

    }

    public String getElementText( WebElement element){

        return element.getText();

    }

    public void moveToElement(WebElement element){

        Actions actions = new Actions(driver);

        actions.moveToElement(element).build().perform();


    }
    
}
