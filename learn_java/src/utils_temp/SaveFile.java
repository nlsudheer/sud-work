package utils_temp;


import java.awt.Robot;
import java.awt.event.KeyEvent;
//import java.awt.*;

public class SaveFile {



public static void typeKeysRobot(Robot robot,String sName)
{
	char array[]=sName.toCharArray();
	for(int i=0;i<array.length;i++)
	{
		//System.out.println(array[i]);
	if(Character.isLetterOrDigit(array[i]))
	{
		if(Character.isUpperCase(array[i]))
		{
		robot.keyPress(KeyEvent.VK_SHIFT);
		int j=(int)array[i];
		robot.keyPress(j);
		//System.out.println("upper case"+j);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		
	    }
		else if(Character.isLowerCase(array[i]))
	    {char s=Character.toUpperCase(array[i]);
		int j=(int)s;
		//System.out.println("lower case"+j);
		robot.keyPress(j);
		
	    }
	   else if(Character.isDigit(array[i])){
		int j=(int)array[i];
		
		robot.keyPress(j);
		}
	}
	 else if(array[i]==':'){
		 robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_SEMICOLON);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			}
	 else if(array[i]=='\\'){
		 robot.keyPress(KeyEvent.VK_BACK_SLASH); 
	 }
	 else if(array[i]=='/'){
		 robot.keyPress(KeyEvent.VK_SLASH); 
	 }else if(array[i]=='.'){
		 robot.keyPress(KeyEvent.VK_PERIOD); 
	 }
	 else if(array[i]=='$'){
		 robot.keyPress(KeyEvent.VK_DOLLAR); 
	 }else{
		 int j=(int)array[i];
		robot.keyPress(j);
	 }
	}
}	

}



/*
try {
Robot r = new Robot();
Thread.sleep(3000);
r.keyPress(KeyEvent.VK_DOWN);
r.keyPress(KeyEvent.VK_ENTER);
r.keyPress(KeyEvent.VK_ALT);
r.keyPress(KeyEvent.VK_TAB);
r.keyRelease(KeyEvent.VK_ALT);
Thread.sleep(3000);
SaveFile.typeKeysRobot(r, "D:\\temp\\first.csv");
//Thread.sleep(1000);
r.keyPress(KeyEvent.VK_ALT);
r.keyPress(KeyEvent.VK_TAB);
r.keyRelease(KeyEvent.VK_ALT);

r.keyPress(KeyEvent.VK_ENTER);
Thread.sleep(1000);
//webobj.stop();

}
catch( Exception e ){
}
*/