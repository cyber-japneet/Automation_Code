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
        homePage = loginPage.loginUser();
        storePage = homePage.clickItem();
        storePage.selectItem();
        Thread.sleep(2000);
    }
}
