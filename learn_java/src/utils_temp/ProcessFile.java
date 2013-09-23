package utils_temp;

import java.io.*;

public class ProcessFile {
	
	
	private String fname = null; 
	public ProcessFile(String fname){this.fname=fname;} 
	
	public static void main(String[] args){
		
		
		 try{
				System.out.println("Calling process File script to remove coloumns from W to Z and AI and to Encrypt the CC number");
				String Dialog = "perl f:\\sudheerScript\\crmFileProcess f:\\sudheerScript\\test1.csv f:\\sudheerScript\\outDir d13R24s261I f:\\sudheerScript\\cryptfiles\\crypt_data\n";
				
				
				//temp2
				/*Runtime rt = Runtime.getRuntime();
				
				Process p = rt.exec(Dialog);
				InputStream in = p.getInputStream();
				byte b[] =new byte[1000];
					in.read(b);
					String str=new String(b);
					System.out.println(str);*/
				//temp2
				
				//temp1
				/*OutputStream os = p.getOutputStream();
				byte b[] = Dialog.getBytes();
				os.write(b);*/
				//System.out.println("Input command"+ Dialog[2]);
				//temp1
				
				Runtime.getRuntime().exec(Dialog);
	            }catch(Exception e)
	            {}
	            System.out.println("Finished processing");
	}
	

}






/*
public class ProcessFile {
	
	
	private String fname = null; 
	public ProcessFile(String fname){this.fname=fname;} 
	
	public void run() {
		
		
		 try{
				System.out.println("Calling process File script to remove coloumns from W to Z and AI and to Encrypt the CC number");
				String[] Dialog =  new String[]{ "perl ","Z:\\scripts\\sudheerScript\\crmFileProcess ", "Z:\\scripts\\sudheerScript\\test.csv ",  "Z:\\scripts\\sudheerScript\\outDir ","d13R24s261I ", "Z:\\scripts\\sudheerScript\\cryptfiles\\crypt_data",};
	            Runtime.getRuntime().exec(Dialog);
	            }catch(Exception e)
	            {}

	}
	

}
*/