package ge.tbc.itacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static ge.tbc.itacademy.data.Constants.*;
import static ge.tbc.itacademy.util.Helper.universalSelector;

public class FormsTest {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void customDropDownTest(){
        driver.navigate().to(TUTORIALS);
        WebElement demo = driver.findElement(By.linkText(DEMO_2));
        demo.click();
        WebElement dropDown = driver.findElement(By.className("dropdown"));
        Assert.assertFalse(dropDown.isDisplayed());
        WebElement signIn = driver.findElement(By.id("dd"));
        signIn.click();
        Assert.assertTrue(dropDown.isDisplayed());
        universalSelector(dropDown, Github);
    }

    @Test
    public void nativeDropDownTest(){
        driver.navigate().to(TECH_CANVAS);
        WebElement r =driver.findElement(By.xpath("//input[@value='female']"));
        r.click();
        WebElement element = driver.findElement(By.xpath("//select[@name='model']"));
        Select selectObj = new Select(element);
        universalSelector(selectObj, MEDIUM_SCREEN);
        List<WebElement> formElements = driver.findElements(By.xpath("//input[@type='text']"));
        for(WebElement e : formElements){
            String requiredValue = e.getAttribute("value");
            e.click();
            switch(requiredValue){
                case "First Name":
                    e.sendKeys(FIRST_NAME);
                    break;
                case "Last Name":
                    e.sendKeys(LAST_NAME);
                    break;
                case "Address1", "City", "Address2":
                    e.sendKeys(CITY);
                    break;
                default:
                    e.sendKeys(Empty);
            }
        }
        WebElement check = driver.findElement(By.xpath("//input[@type='checkbox']"));
        check.click();
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();
    }
}
