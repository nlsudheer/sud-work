package learnjava;

import com.cmates.selenium.framework.page.*;
import org.testng.annotations.*;
//import com.cmates.selenium.framework.SeleniumDriver;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;


//import static org.testng.Assert.*;


public class SaveDataToFile { 
	
	
		public static WebObj webobj;
	    //public static Logger logger;
				
//		@BeforeClass
		public void setup()
		{
		webobj = new WebObj("10.103.15.20",4444,"*chrome","http://www.moneycontrol.com/");
		//localhost 10.103.15.18
		webobj.start();
		webobj.windowMaximize();
		webobj.setTimeout(webobj.globalProps.timeOut);
		webobj.open("/");	
        }
	

		
			
//			@Test
            public void testMoneyControl() throws Exception {
				webobj.open("/");
				webobj.click("menu2");
				webobj.waitForPageToLoad("30000");
				/*if (verifyTrue(webobj.isTextPresent("SENSEX")));
				boolean  = webobj.isTextPresent("sensex_val_top");
				String  = webobj.getEval("sensex_val_top");
				*/}
				
		
}


/*
 * import com.thoughtworks.webobj.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class moneyControl extends SeleneseTestNgHelper {
	@Test public void testMoneyControl() throws Exception {
		webobj.open("/");
		webobj.click("menu2");
		webobj.waitForPageToLoad("30000");
		verifyTrue(webobj.isTextPresent("SENSEX"));
		boolean  = webobj.isTextPresent("sensex_val_top");
		String  = webobj.getEval("sensex_val_top");
	}
}

 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
