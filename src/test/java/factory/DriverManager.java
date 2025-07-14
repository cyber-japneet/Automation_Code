package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        if(Configuration.executionMode.equalsIgnoreCase("docker"))
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
        }
        else if(Configuration.executionMode.equalsIgnoreCase("local")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }

        else if(Configuration.executionMode.equalsIgnoreCase("git")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }

        else{System.out.println("Invalid execution mode!!!");}

        return driver;
    }
}
