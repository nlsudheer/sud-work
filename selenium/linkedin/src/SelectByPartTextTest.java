//package de.itkosmopolit.testandforum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByPartTextTest {

    @Test
    public void test() {
        WebDriver driver = new FirefoxDriver();
        String fixTextPart = "Michael";
        driver.get("http://de.selfhtml.org/html/formulare/anzeige/select.htm");
        
        
        Select select = new Select(driver.findElement(By.name("top5")));
        List<WebElement> list = select.getOptions();
        for (WebElement option : list) {
            String fullText = option.getText();
            if (fullText.contains(fixTextPart)) {
                select.selectByVisibleText(fullText);
            }
        }
    }
}
