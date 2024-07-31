package ge.tbc.itacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.itacademy.data.Constants.*;

public class WebElementsTests {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LINK);
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test
    public void dimensionsTest(){
        WebElement squareA = driver.findElement(By.id("column-a"));
        WebElement squareB = driver.findElement(By.id("column-b"));
        Point pointA = squareA.getLocation();
        Point pointB = squareB.getLocation();
        Assert.assertEquals(pointA.y, pointB.y);
        Assert.assertEquals(squareA.getAttribute("draggable"), "true");
        Assert.assertEquals(squareB.getAttribute("draggable"), "true");
    }

    @Test
    public void linkTest(){
        WebElement elemSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        String checkAttribute = elemSelenium.getAttribute("href");
        Assert.assertEquals(checkAttribute, CHECK_URL);
    }
}
