package ge.tbc.itacademy.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Helper {
    public static void universalSelector(Object element, String visibleText) {
        if (element instanceof Select elementSelect) {
            elementSelect.selectByVisibleText(visibleText);
        } else if (element instanceof WebElement webelement) {
            WebElement elementToClick = webelement
                    .findElement(By.xpath("//*[contains(text(), " + visibleText + ")]"));
            elementToClick.click();
        }
    }
}
