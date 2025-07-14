package pages;

import org.openqa.selenium.WebDriver;

public class BasePage
{
    WebDriver driver;
    public BasePage (WebDriver driver)
    {
        this.driver = driver;
    }

    //can keep methods which are common to all pages

    public void loadApplicationURL()
    {
        driver.get("https://practicesoftwaretesting.com/auth/login");
    }
}
