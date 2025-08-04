package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //functional page object model
    public void loginUser()
    {
        driver.findElement(By.id("email")).sendKeys("customer3@practicesoftwaretesting.com");
        driver.findElement(By.id("password")).sendKeys("pass123");
        driver.findElement(By.xpath("//input[@data-test='login-submit']")).click();
        new HomePage(driver);
    }
}
