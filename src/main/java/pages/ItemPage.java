package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage extends BasePage
{

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public String addItemToCart()
    {
        driver.findElement(By.id("btn-add-to-cart")).click();
        String role =  driver.findElement(By.xpath("//div[@aria-label='Product added to shopping cart.']")).getAriaRole();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//a[@data-test='nav-cart']")).click();
        return role;
    }
}
