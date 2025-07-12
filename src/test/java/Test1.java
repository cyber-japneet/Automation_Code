import factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import pom.BaseTest;

import java.net.MalformedURLException;
import java.net.URL;


public class Test1 extends BaseTest
{
    @Test
    public void e2eTest() throws InterruptedException
    {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
    }
}
