package ge.tbc.itacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.itacademy.data.Constants.ULTIM_AUTOMATION;
import static ge.tbc.itacademy.data.Constants.ULTIM_TESTIMONIALS;

public class NavigationTests {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ULTIM_AUTOMATION);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test
    public void goToSuccessStoriesAndBack(){
        WebElement successStoriesPath = driver.findElement(By.id("menu-item-217938"));
        successStoriesPath.click();
        Assert.assertEquals(driver.getCurrentUrl(), ULTIM_TESTIMONIALS);
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), ULTIM_AUTOMATION);
    }
}
