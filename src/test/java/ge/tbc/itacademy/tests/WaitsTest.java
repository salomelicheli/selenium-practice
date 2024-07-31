package ge.tbc.itacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.itacademy.data.Constants.*;

public class WaitsTest {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void waitForDisappearance(){
        driver.navigate().to(THE_INTERNET);
        WebElement input = driver.findElement(By.xpath("//form[@id='input-example']/input"));
        WebElement button = driver.findElement(By.xpath("//form[@id='input-example']/button"));
        button.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_ID)));
        Assert.assertEquals(button.getText(), DISABLE);
        input.sendKeys(ACCESS_GRANTED);
    }
    @Test
    public void waitForText(){
        driver.navigate().to(DEMOQA);
        js.executeScript(SCROLL_BY);
        WebElement button = driver.findElement(By.id(START_ID));
        button.click();
        WebElement bar = driver.findElement(By.xpath("//div[@id='progressBar']//child::div"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.attributeToBe(bar,  "aria-valuenow", "100"));
        System.out.println(bar.getText());
    }
}
