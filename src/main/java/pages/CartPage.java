package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage
{
    LoginPage loginPage;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public BillingAddressPage proceedToCheckout()
    {
        loginPage = new LoginPage(driver);
        driver.findElement(By.xpath("//button[@data-test='proceed-1']")).click();
        //loginPage.loginUser();
        driver.findElement(By.xpath("//button[@data-test='proceed-2']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new BillingAddressPage(driver);
    }
}
