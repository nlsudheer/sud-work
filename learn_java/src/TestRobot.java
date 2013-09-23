import java.awt.Robot;
 
import java.awt.event.KeyEvent;

public class TestRobot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try{
		Runtime rt = Runtime.getRuntime() ;
		String filename = "D:\\temp\\a1.csv";
		Process p = rt.exec("notepad.exe");
		Robot r=new Robot();
		
		r.keyPress(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_O);
		r.keyPress(KeyEvent.VK_N);
		r.keyPress(KeyEvent.VK_E);
		
		r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_S);
        System.out.print(filename);
        r.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(100000);
        p.destroy() ;
	}catch(Exception e){}
	
	}

}