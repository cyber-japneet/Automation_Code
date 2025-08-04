package tests;

import factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest
{
    protected WebDriver driver;

    //before/after and any other common methods for tests


    @BeforeMethod
    @Parameters({"browserName"})
    public void setup(@Optional String browserName)
    {
        if(browserName != null)
        {
            driver = new DriverManager().initializeDriver(browserName);
        }
        else {

            driver = new DriverManager().initializeDriver();
        }
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
