package commonLibs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementControl {

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
    
}
