package org.selenium.framework.baseModules;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.framework.utils.TestUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Browser extends BaseLib {
    TestUtils util = new TestUtils();

    public  WebDriver getDriver(String browserType) {
        WebDriver driver = new FirefoxDriver();
//      Implicit Waits
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getConfig("browser_timeout")), TimeUnit.SECONDS);
        return driver;
    }

    public final WebDriver driver = getDriver("ff");



    public void maximize() {
        driver.manage().window().maximize();
    }


    public List<String> getAllLinks() {
        List<String> hrefs = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        for(WebElement element: elements){
            hrefs.add(element.getAttribute("href"));
        }
        return hrefs;
    }

    // Removes duplicate link elements
    public HashMap<String, String> getAllLinksAndText() {
        HashMap<String, String> links = new HashMap<>();
        List<WebElement> elements =  driver.findElements(By.tagName("a"));

        for(WebElement ele: elements ){
            links.put(ele.getAttribute("href"), ele.getText());
        }
        return links;
    }

    public String getText(By locator) {
        WebElement elem = driver.findElement(locator);
        return elem.getText();
    }

    public String getText(By locator, boolean waitForElement) {
        if (waitForElement){waitForElement(locator);}
        return driver.findElement(locator).getText();

    }

    // Pending imple
    // http://stackoverflow.com/questions/6430462/how-to-select-get-drop-down-option-in-selenium-2
    // can use list also
    public void multipleSelect(By locator, String[] aValues) {
        waitForElement(locator);
        Select select = new Select(driver.findElement(locator));
        for(String val: aValues){
            select.selectByValue(val);
        }
    }

    // LinkedinPageElements element = new LinkedinPageElements();

    public void open(String url) {
        maximize();
        driver.get(url);
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.focus();");
    }

    public void openInNewWindow(String url) {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.open();");
        jsx.executeScript("window.focus();");
        driver.get(url);
        maximize();
    }

    public void windowHandler(String url) {

        String currentWindowHandle = driver.getWindowHandle();

    }

    public void focus(){
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.focus();");
    }

    public void click(By locator) {
//		if(isElementPresent(locator)){
        WebElement ele = driver.findElement(locator);
        highlightElement(ele);
        ele.click();
//		}
    }

    public void waitForElement(By locator) {
        if (!isElementPresent(locator)) {
            WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(getConfig("wait_timeout")), 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        System.out.println("Called " + "\t" +  Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void waitTillElementPresent(By locator) {
        if (isElementPresent(locator)) {
            WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(getConfig("wait_timeout")), 10);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }
        System.out.println("Called " + "\t" +  Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void clickAndWait(By locator) {
        driver.findElement(locator).click();
        waitForElement(locator);
        System.out.println("Called " + "\t" +  Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void type(By locator, String text) {
        WebElement elem = driver.findElement(locator);
        elem.click();
        elem.clear();
        elem.sendKeys(text);
    }

    /*
     *
     * isElementPresent(By.xpath, element) isElementPresent(By.cssSelector,
     * element) Pending the imple for otherthan xpath
     */
    public void isElementPresent(By locatorType, String element) {
        // Pending the imple for otherthan xpath
    }

    @Deprecated
//    public boolean isElementPresent(String element) {
//        return isElementPresent(By.xpath(element));
//    }

    public String foundElement(String[] elements) {
        for (String elm : elements) {
            // Assert.assertTrue(driver.findElement(By.xpath(elm)).isDisplayed(),
            // "elm found in foundElement ");
            try {
                if (driver.findElement(By.xpath(elm)).isDisplayed()) {
                    System.out.println("elm found in foundElement " + elm);
                    return elm;
                }
            } catch (Exception e) {

                System.out.println("elm not found in foundElement " + elm);
                continue;
            }
        }
        return null;
    }

    public boolean isElementPresent(By locator) {
        System.out.println("In isElementPresent");
        try {
            return driver.findElement((locator)).isDisplayed();

        } catch (NoSuchElementException e) {
            System.out.println("Page element not found "+ locator + "\n"+ e );
            return false;
        }
    }

    public void mouseHover(By locator){
        System.out.println("In" + "\t" +  Thread.currentThread().getStackTrace()[1].getMethodName());
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(locator)).perform();
        System.out.println("Called " + "\t" +  Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void mouseHoverByJS(By locator){
        System.out.println("In" + "\t" +  Thread.currentThread().getStackTrace()[1].getMethodName());
        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent( 'mouseover', true, true );"
                + "fireOnThis.dispatchEvent(evObj);";
        ((JavascriptExecutor) driver).executeScript(code, driver.findElement(locator));
        System.out.println("Called " + "\t" +  Thread.currentThread().getStackTrace()[1].getMethodName());
    }
    // Actions actions = new Actions(driver);
    // //
    // action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();

    /**
     * Not for remote webdriver
     * @param
     */
    public void captureScreenshot(String screenshotName) {
        String location = getBaseDir() + getConfig("screenshots") + screenshotName + ".png";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        try {
            FileUtils.copyFile(scrFile, new File(location), true);
        } catch (IOException e) {
            e.getStackTrace();

        }
    }

    //http://selenium.polteq.com/en/highlight-elements-with-selenium-webdriver/
    protected void highlightElement(WebElement element) {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "color: red; border: 4px solid red;");
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
        }

    }

//        randomStringGenerator

//        http://docs.seleniumhq.org/docs/04_webdriver_advanced.jsp

//        // RemoteWebDriver does not implement the TakesScreenshot class
//        // if the driver does have the Capabilities to take a screenshot
//        // then Augmenter will add the TakesScreenshot methods to the instance
//        WebDriver augmentedDriver = new Augmenter().augment(driver);
//        File screenshot = ((TakesScreenshot)augmentedDriver).
//                getScreenshotAs(OutputType.FILE);



    public void captureScreenshot(){
        captureScreenshot(util.randomStringGenerator());
    }
}
