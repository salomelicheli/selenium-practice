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

import static ge.tbc.itacademy.data.Constants.*;

public class CommandTests {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DYNAMIC_CONTROLS);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test
    public void buttonTest() throws InterruptedException {
        WebElement input = driver.findElement(By.xpath("//form[@id='input-example']/input"));
        WebElement button = driver.findElement(By.xpath("//form[@id='input-example']/button"));
        Assert.assertFalse(input.isEnabled());
        button.click();
        Thread.sleep(3000);
        Assert.assertTrue(input.isEnabled());
        input.sendKeys("TBC IT Academy");
        Thread.sleep(1000);
        input.clear();
    }
    @Test
    public void labelTest(){
        String heading = driver.findElement(By.xpath("//div[@id='content']//h4[1]")).getText();
        Assert.assertEquals(heading,  EXPECTED_HEADING);
        String description = driver.findElement(By.xpath(("//div[@id='content']//p"))).getText();
        Assert.assertEquals(description, EXPECTED_TEXT);
    }
}
