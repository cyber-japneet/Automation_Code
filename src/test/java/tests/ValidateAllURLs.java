package tests;

import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ValidateAllURLs
{
    @Test
    public void validateURL() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practicesoftwaretesting.com/");
        List<WebElement> webElementList = driver.findElements(By.tagName("a"));
        List<String> urls = new ArrayList<>();
        for(WebElement link:webElementList)
        {
            String href = link.getDomAttribute("href");
            if(href!=null && !href.isEmpty())
            {
                if(href.startsWith("http") || href.startsWith("https"))
                {
                    urls.add(href);
                }
            }
        }

        System.out.println(urls.size());
        List<String> brokenLinks = new ArrayList<>();

        for(String url: urls)
        {
            try{
                int status_code = RestAssured.given().redirects().follow(true).get(url).getStatusCode();
                if(status_code>=400)
                {
                    System.err.println("Broken Link Found "+ url + " Status Code: "+status_code);
                    brokenLinks.add(url);
                }
            }
            catch(Exception e)
            {
                System.err.println("Link Check Failed for: "+url);
                brokenLinks.add(url);
            }
        }

        if(!brokenLinks.isEmpty())
        {
            System.err.println("Check Broken Links List");
        }

        System.out.println(brokenLinks);
        Thread.sleep(5000);
        driver.quit();
    }
}
