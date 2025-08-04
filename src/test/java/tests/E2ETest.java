package tests;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import objects.BillingPojo;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

import static api.actions.LoginApi.bearerToken;
import static api.actions.LoginApi.loginUserApi;
import static utils.RetrieveJsonData.getEmailId;
import static utils.RetrieveJsonData.getFirstAndLastName;


public class E2ETest extends BaseTest
{
    //LoginPage loginPage;
    HomePage homePage;
    StorePage storePage;
    ItemPage itemPage;
    CartPage cartPage;
    BillingAddressPage billingAddressPage;
    //BillingPojo billingPojo;
    PaymentPage paymentPage;
    Faker faker = new Faker();
    String token;
    @Test (priority = 1)
    public void e2eTest() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        loginPage = new LoginPage(driver);
//        loginPage.loadApplicationURL();
//        homePage = loginPage.loginUser();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Response response = loginUserApi(getEmailId(), "Qwe#31cv@w");
        token = response.body().path("access_token");
        homePage = new HomePage(driver);
        homePage.routeToHomePage();
        js.executeScript("localStorage.setItem('auth-token', arguments[0]);", token);
        storePage = homePage.clickItem();
        itemPage = storePage.selectItem();
        //loginUserApi(getEmailId(), "Qwe#31cv@w");
        Thread.sleep(2000);

        
        String role = itemPage.addItemToCart();
        Assert.assertEquals(role, "alert");
        cartPage = new CartPage(driver);
        billingAddressPage = cartPage.proceedToCheckout();
        //billingAddressPage.fillBillingInfo(generateBillingAddressData());
        Thread.sleep(2000);
        paymentPage = billingAddressPage.clickOnProceedToCheckout();
        paymentPage.selectPaymentMode("cash-on-delivery");
        paymentPage.clickOnConfirmButton();
        Assert.assertEquals(paymentPage.paymentConfirmationMsg(), "Payment was successful");
    }

    @Test (priority = -1, invocationCount = 2, threadPoolSize = 2)
    public void e2eTest2() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        loginPage = new LoginPage(driver);
//        loginPage.loadApplicationURL();
//        homePage = loginPage.loginUser();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Response response = loginUserApi(getEmailId(), "Qwe#31cv@w");
        token = response.body().path("access_token");
        homePage = new HomePage(driver);
        homePage.routeToHomePage();
        js.executeScript("localStorage.setItem('auth-token', arguments[0]);", token);
        storePage = homePage.clickItem();
        itemPage = storePage.selectItem();
        //loginUserApi(getEmailId(), "Qwe#31cv@w");
        Thread.sleep(2000);

        String role = itemPage.addItemToCart();
        Assert.assertEquals(role, "alert");
        cartPage = new CartPage(driver);
        billingAddressPage = cartPage.proceedToCheckout();
        //billingAddressPage.fillBillingInfo(generateBillingAddressData());
        Thread.sleep(2000);
        paymentPage = billingAddressPage.clickOnProceedToCheckout();
        paymentPage.selectPaymentMode("cash-on-delivery");
        paymentPage.clickOnConfirmButton();
        Assert.assertEquals(paymentPage.paymentConfirmationMsg(), "Payment was successful");
    }

//    public BillingPojo generateBillingAddressData()
//    {
//        BillingPojo billingPojo = new BillingPojo();
//            //generate test data
//            billingPojo.setStreet_name(faker.address().streetName());
//            billingPojo.setCity_name(faker.address().cityName());
//            billingPojo.setState_name(faker.address().state());
//            billingPojo.setCountry_name(faker.address().country());
//            billingPojo.setPostal_code(faker.address().zipCode());
//
//        return billingPojo;
//    }

}
