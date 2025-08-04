package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage
{
    public StorePage(WebDriver driver) {
        super(driver);
    }

    //structural page object model
    public ItemPage selectItem()
    {
        driver.findElement(By.xpath("//img[@alt='Combination Pliers']")).click();
        return new ItemPage(driver);
    }
}
