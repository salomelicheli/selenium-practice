package ge.tbc.itacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.itacademy.data.Constants.*;

public class SwitchTest {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor)driver;
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void switchTest(){
        driver.get(IFRAME_LINK);
        driver.switchTo().frame(MCE_ID);
        WebElement tab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='tinymce']/p")));
        tab.clear();
        tab.sendKeys(HERE_GOES_TEXT);
        driver.switchTo().parentFrame();
        WebElement button = driver.findElement(By.xpath("//button[@title='Align center']"));
        button.click();
    }
    @Test
    public void alertTest(){
        driver.navigate().to(ALERTS_LINK);
        js.executeScript("window.scrollBy(0, 200)");
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
