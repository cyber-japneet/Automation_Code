package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager
{
    private static final String SELENIUM_HUB_URL = "http://localhost:4441/wd/hub";
    WebDriver driver;

    public WebDriver initializeDriver()
    {
        if(Configuration.executionMode.equalsIgnoreCase("docker"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            //options.addArguments("--headless");
            // --disable-dev-shm-usage: Overcomes limited shared memory in containers
            options.addArguments("--disable-dev-shm-usage");
            try {
               driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        else if(Configuration.executionMode.equalsIgnoreCase("local"))
        {
            if(Configuration.browserName.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
            }
            else if(Configuration.browserName.equalsIgnoreCase("firefox"))
            {
//                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                firefoxOptions.addArguments("--start-maximized");
                driver = new FirefoxDriver();
            }
        }

        else if(Configuration.executionMode.equalsIgnoreCase("git")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--no-first-run");
            options.addArguments("--disable-default-apps");
            driver = new ChromeDriver(options);
        }

        else{System.out.println("Invalid execution mode!!!");}

        return driver;
    }

    public WebDriver initializeDriver(String browserName)
    {
        if(browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
            driver = new FirefoxDriver();
        }

        return driver;
    }
}
