package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager
{
    private static final String SELENIUM_HUB_URL = "http://localhost:4444/wd/hub";
    WebDriver driver;
    public WebDriver initializeDriver(String driverName)
    {
        if(driverName.trim().equalsIgnoreCase("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            // --disable-dev-shm-usage: Overcomes limited shared memory in containers
            options.addArguments("--disable-dev-shm-usage");
            try {
               driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            //driver = new ChromeDriver(options);
        }

        return driver;
    }
}
