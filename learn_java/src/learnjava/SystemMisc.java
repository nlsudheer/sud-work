package learnjava;

// Opens a notepad

public class SystemMisc {
	
	public ProcessBuilder process = null;
		
	public static void main(String[] args) {
		
		System.out.println("Open the file");
		//Process p = Runtime.getRuntime().exec("notepad");
		//ProcessBuilder = new ProcessBuilder("notepad","a.txt").start();
	
		
		
			try {
		      //String line;
		      Process p = Runtime.getRuntime().exec("notepad.exe");
		      p.waitFor();
		      
		      //System.out.println(p.exitValue());
		    }
		    catch (Exception err) {
		      err.printStackTrace();
		    } 
			
	}
}
