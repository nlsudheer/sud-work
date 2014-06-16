package LinkedIn;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.*;

public class Browser {

	public  WebDriver getDriver(String browserType) {
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	public final WebDriver driver = getDriver("ff");

	public void maximize() {
		driver.manage().window().maximize();
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
		driver.get(url);
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.focus();");
		maximize();
		
	}
	
	public void focus(){
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.focus();");
	}

	public void click(By locator) {
//		if(isElementPresent(locator)){
			driver.findElement(locator).click();
//		}
	}

	public void waitForElement(By locator) {
		if (!isElementPresent(locator)) {
			WebDriverWait wait = new WebDriverWait(driver, 30, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		System.out.println("Called " + "\t" +  Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	public void waitTillElementPresent(By locator) {
		if (isElementPresent(locator)) {
			WebDriverWait wait = new WebDriverWait(driver, 30, 10);
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

	public boolean isElementPresent(String element) {
		return isElementPresent(By.xpath(element));
	}

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
//		Actions builder = new Actions(driver);
//		builder.moveToElement(driver.findElement(locator)).perform();
		
		    String code = "var fireOnThis = arguments[0];"
		                + "var evObj = document.createEvent('MouseEvents');"
		                + "evObj.initEvent( 'mouseover', true, true );"
		                + "fireOnThis.dispatchEvent(evObj);";
		    ((JavascriptExecutor) driver).executeScript(code, driver.findElement(locator));
		System.out.println("Called " + "\t" +  Thread.currentThread().getStackTrace()[1].getMethodName());
		click(By.xpath("//a[@class='account-submenu-split-link']"));
		
	}
	// Actions actions = new Actions(driver);
	// //
	// action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();

}
