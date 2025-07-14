package pom;

import factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest
{
    protected WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver = new DriverManager().initializeDriver("chrome");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
