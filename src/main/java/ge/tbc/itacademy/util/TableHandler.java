package ge.tbc.itacademy.util;

import ge.tbc.itacademy.exceptions.NotSupportedFullyException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableHandler {
    public static String tableHandler(WebDriver driver, String tablexPath, String rowSpecifier, String elementHead){
        String misteryElement = "";
        StringBuilder columnXPath = new StringBuilder(tablexPath).append("//th");
        StringBuilder rowXPath = new StringBuilder(tablexPath)
                .append("//tr[contains(., '").append(rowSpecifier).append("')]//th | ")
                .append("//tr[contains(., '").append(rowSpecifier).append("')]//td");
        List<WebElement> columns = driver.findElements(By.xpath(columnXPath.toString()));
        List<WebElement> row = driver.findElements(By.xpath(rowXPath.toString()));
        int minSize = Math.min(columns.size(), row.size());
        for (int i = 0; i < minSize; i++) {
            if (columns.get(i).getText().equalsIgnoreCase(elementHead)) {
                misteryElement = row.get(i).getText();
                break;
            }
        }
        if (misteryElement.isEmpty()) {
            throw new NotSupportedFullyException("table element cannot be supported");
        }
        return misteryElement;
    }
}
