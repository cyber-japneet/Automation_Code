package tests;

import api.pojo.UserPojo;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

import static api.actions.FavoritesApi.addProductToFavorites;
import static api.actions.FavoritesApi.getFavoriteItem;
import static api.actions.LoginApi.loginUserApi;
import static api.actions.RegisterApi.registerNewUserApi;
import static utils.RetrieveJsonData.getAuthToken;
import static utils.RetrieveJsonData.getEmailId;

public class FavoritesTest extends BaseTest
{
    UserPojo userPojo;
    HomePage homePage;
    @Test
    public void addItemToFavorites()
    {
//        int status_code1 = addProductToFavorites();
//        Assert.assertEquals(status_code1, 201);
        int status_code2 = getFavoriteItem();
        Assert.assertEquals(status_code2, 200);
    }

    @Test
    public void UiValidationOfFavorites() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        userPojo = new UserPojo();
        registerNewUserApi(UserPojo.generateFakeUser());
        Response response = loginUserApi(getEmailId(), "Qwe#31cv@w");
        String token = response.body().path("access_token");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        homePage = new HomePage(driver);
        homePage.routeToHomePage();
        js.executeScript("localStorage.setItem('auth-token', arguments[0]);", getAuthToken());
        driver.navigate().refresh();
        // add product to fav
        addProductToFavorites(token);
        driver.findElement(By.xpath("//a[@data-test='nav-favorites']")).click();
        Thread.sleep(10000);
        String attribute = driver.findElement(By.xpath("//div[contains(@data-test, 'favorite-')]")).getDomAttribute("data-test");
        System.out.println(attribute);
    }
}
