package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage loginUser()
    {
        driver.findElement(By.id("email")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.id("password")).sendKeys("welcome01");
        driver.findElement(By.xpath("//input[@data-test='login-submit']")).click();
        return new HomePage(driver);
    }
}
