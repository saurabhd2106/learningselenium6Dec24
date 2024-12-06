package commonLibs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonDriver {

    private WebDriver driver;

    public CommonDriver(String browserType) throws Exception {

        if (browserType.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browserType.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else if (browserType.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else {
            throw new Exception("Invalid Browser type.. " + browserType);
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));



    }

    public void navigateToUrl(String url) {

        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void closeBrowser(){

        driver.close();

    }

    public void closeAllBrowser(){

        driver.quit();

    }
    

}
