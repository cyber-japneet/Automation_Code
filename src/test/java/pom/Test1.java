package pom;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.StorePage;

import java.time.Duration;


public class Test1 extends BaseTest
{
    LoginPage loginPage;
    HomePage homePage;
    StorePage storePage;
    @Test
    public void e2eTest() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        loginPage.loadApplicationURL();
        System.out.println(driver.getCurrentUrl());
        homePage = loginPage.loginUser();
        System.out.println(driver.getCurrentUrl());
        storePage = homePage.clickItem();
        System.out.println(driver.getCurrentUrl());
        storePage.selectItem();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
    }
}
