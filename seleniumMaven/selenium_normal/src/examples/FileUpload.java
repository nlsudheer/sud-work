package examples;

import java.awt.AWTException;
import java.awt.Robot;
//import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

//import org.databene.benerator.anno.Source;
//import org.databene.feed4testng.FeedTest;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import org.testng.Reporter;

//import org.apache.commons.io.FileUtils;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;


/**
 *
 * http://www.linkedin.com/groups/How-upload-file-using-Selenium-961927.S.202114867
 *
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 9/10/13
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileUpload {



        WebDriver driver = null;

        @BeforeTest
        public void init(){

            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @Test
        public void show() throws IOException, AWTException, InterruptedException{
            driver.get("file:///C:/Documents%20and%20Settings/ee/Desktop/test.html");
            driver.findElement(By.name("datasize"));
            Actions ac = new Actions(driver);
            WebElement element = driver.findElement(By.name("datasize"));
            Robot r = new Robot();
            ac.click(element).perform();
            Thread.sleep(1000);
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            r.keyPress(KeyEvent.VK_C);
            r.keyRelease(KeyEvent.VK_C);
            r.keyPress(KeyEvent.VK_PERIOD);
            r.keyRelease(KeyEvent.VK_PERIOD);
            r.keyPress(KeyEvent.VK_J);
            r.keyRelease(KeyEvent.VK_J);
            r.keyPress(KeyEvent.VK_P);
            r.keyRelease(KeyEvent.VK_P);
            r.keyPress(KeyEvent.VK_G);
            r.keyRelease(KeyEvent.VK_G);
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
        }
    }
