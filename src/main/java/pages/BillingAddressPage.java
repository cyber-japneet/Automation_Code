package pages;

import objects.BillingPojo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillingAddressPage extends BasePage
{
    //POJO class setup for Data-Driven Testing

    private By street_name = By.id("street");
    private  By city_name = By.id("city");
    private  By state_name = By.id("state");
    private  By country_name = By.id("country");
    private  By postal_code = By.id("postal_code");

    public BillingAddressPage(WebDriver driver) {
        super(driver);
    }

    public void fillBillingInfo(BillingPojo billingPojo)
    {
        driver.findElement(street_name).sendKeys(billingPojo.getStreet_name());
        driver.findElement(city_name).sendKeys(billingPojo.getCity_name());
        driver.findElement(state_name).sendKeys(billingPojo.getState_name());
        driver.findElement(country_name).sendKeys(billingPojo.getCountry_name());
        driver.findElement(postal_code).sendKeys(billingPojo.getPostal_code());
    }

    public PaymentPage clickOnProceedToCheckout()
    {
        driver.findElement(By.xpath("//button[@data-test='proceed-3']")).click();
        return new PaymentPage(driver);
    }
}
