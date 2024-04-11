package org.example;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicTest {
    public static WebDriver driver;

    @BeforeClass
    public static void initDriver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        driver.get("https://toolsqa.com/");
        //WebElement input = driver.findElement(By.cssSelector("input[name=keyword]"));
    }

    @Test
    public void checkButtonFunctionality(){  //checks if the "Selenium Training" button performs proper navigation
        driver.get("https://toolsqa.com/");
        WebElement trainingBtn = driver.findElement(By.xpath("/html[1]/body[1]/header[1]/nav[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[2]/a[1]"));
        trainingBtn.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://toolsqa.com/selenium-training?q=headers" );
    }

    @Test
    public void checkEnrollButton(){
        driver.get("https://toolsqa.com/");
        WebElement enrollBtn = driver.findElement(By.cssSelector("a.btn.btn-primary-shadow.btn-block"));
        enrollBtn.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals( currentUrl, "https://toolsqa.com/selenium-training?q=banner#enroll-form");

    }
    //

    @Test
    public void istqbBtn(){
        driver.get("https://toolsqa.com/");
        WebElement enrollBtn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[3]"));
        enrollBtn.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals( currentUrl, "https://toolsqa.com/software-testing/istqb-foundation-level/");

    }



}
