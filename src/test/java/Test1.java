import factory.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pom.BaseTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class Test1 extends BaseTest
{
    @Test
    public void e2eTest() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practicesoftwaretesting.com/auth/login");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        //loginpage
        driver.findElement(By.id("email")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.id("password")).sendKeys("welcome01");
        driver.findElement(By.xpath("//input[@data-test='login-submit']")).click();
        //homepage
        driver.findElement(By.xpath("//a[@data-test='nav-home']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");
        WebElement webElement = driver.findElement(By.xpath("//input[@value='01K012FCSN97C5FQX6SREKP5EQ']"));
        webElement.click();
        Thread.sleep(2000);
    }
}
