package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends BasePage
{

    //structural page object model
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void selectPaymentMode(String payment_mode)
    {
        Select select = new Select(driver.findElement(By.id("payment-method")));
        select.selectByValue(payment_mode);
    }

    public void clickOnConfirmButton()
    {
        driver.findElement(By.xpath("//button[@data-test='finish']")).click();
    }

    public String paymentConfirmationMsg()
    {
        return driver.findElement(By.xpath("//div[@data-test='payment-success-message']")).getText();
    }
}
