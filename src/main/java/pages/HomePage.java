package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage
{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void routeToHomePage()
    {
        driver.get("https://practicesoftwaretesting.com/account");
    }

    //functional page object model
    public StorePage clickItem()
    {
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@data-test='nav-home']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100);");
        return new StorePage(driver);
    }
}
