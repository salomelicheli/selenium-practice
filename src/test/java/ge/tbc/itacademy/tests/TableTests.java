package ge.tbc.itacademy.tests;

import ge.tbc.itacademy.exceptions.NotSupportedFullyException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.itacademy.data.Constants.*;
import static ge.tbc.itacademy.util.TableHandler.tableHandler;

public class TableTests {
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
    public void techCanvasTest(){
        driver.navigate().to(TECH_CANVAS_TABLE);
        String expectedCompanyName = "Suzuki";
        String companyNameBalenoMake = tableHandler(driver, "//table[@id='t01']", Baleno, companyNameHeader);
        System.out.println(companyNameBalenoMake);
        Assert.assertEquals(companyNameBalenoMake, expectedCompanyName, assertMessage);


        String hondaPrice = tableHandler(driver, "//table[@id='t01']", Honda, INR);
        System.out.println(hondaPrice);
        Assert.assertEquals(hondaPrice, expectedPrice, assertMessage);
    }
    @Test
    public void techListTest(){
        try {
            driver.navigate().to(TECH_LIST);
            String googleCountry = tableHandler(driver, "//table[@id='customers']", Google, Country);
            System.out.println(googleCountry);

            String clockTowerHotelCity = tableHandler(driver, "//table[@class='tsc_table_s13']", clockTowerHotel, City);
            System.out.println(clockTowerHotelCity);

            String total= tableHandler(driver, "//table[@class='tsc_table_s13']", "Total", City);
            System.out.println(total);
        }catch(NotSupportedFullyException ex){
            System.out.println(Message + ex.getMessage());
        }
    }
    @Test
    public void domTest(){
        driver.navigate().to(DOM);
        String expectedValue = "Iuvaret9";
        String element = tableHandler(driver, "//div[@class='large-10 columns']//table",
                Apeirian9, Lorem);
        System.out.println(element);
        Assert.assertEquals(expectedValue, element, assertMessage);
    }
    @Test
    public void test(){
        driver.navigate().to(BLOGSPOT);
        String name = tableHandler(driver, "//table[@id='table1']", Delhi, nameHeader);
        System.out.println(name);
        Assert.assertEquals("Kishore", name, assertMessage);

        driver.navigate().to(LINK);
        String nameOfPersonWithFollowingID =
                tableHandler(driver, "//table[@border='1']", ID, nameHeader);
        System.out.println(nameOfPersonWithFollowingID);
    }
}
