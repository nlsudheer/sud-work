package LinkedIn;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import au.com.bytecode.opencsv.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.*;

public class Test {

	public static Browser browser = new Browser();
	public static LinkedinPageElements element = new LinkedinPageElements();

	public void printMethodAndClass() {
		// http://www.kodejava.org/examples/482.html
		System.out.println("All contacts list: " + this.getClass().getName());
		System.out.println("Called " + Thread.currentThread().getStackTrace()[1].getMethodName());

	}

	public static void main(String[] args) {
		Test test = new Test();

		// System.out.println( "All contacts list: true");
		// Assert.assertTrue(true);
		//
		// System.out.println( "All contacts list: false");
		// Assert.assertTrue(false);

String val = "hi,dude,there";
val = val.replaceAll(",", "#");
System.out.println( "All contacts list: false"+ val);

		// WebDriver driver = new FirefoxDriver();
		// System.out.println( "All contacts list: " + driver.getClass());
		// Method[] aListOfMethods=driver.getClass().getMethods();
		// Method method=null;
		// int iNoOfParameters=0;
		//
		// for(int i=0;i<aListOfMethods.length;i++)
		//
		// {
		// System.out.println( "All contacts list: "
		// +aListOfMethods[i].getName());
		//
		//
		// Type[] methodParameters=aListOfMethods[i].getGenericParameterTypes();
		// iNoOfParameters=methodParameters.length;
		// method=aListOfMethods[i];
		// }
		//
		//

	}

}