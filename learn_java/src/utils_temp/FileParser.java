package utils_temp;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		 	BufferedReader input =  new BufferedReader(new FileReader("F:\\temp\\myfile9.csv"));
			
		 	String str=new String();
		 	String tag =",";
		 	String s[]=new String[10];
			int i=0;
			while((str=input.readLine())!=null)
			{	
			/*	if(str.contains(tag))
			   {*/
					//s[i]=str.substring(str.indexOf(">")+1, str.indexOf("</"));
					s[i]=str.substring(str.indexOf(tag)+1);
					System.out.println(s[i]);
			  // }
			}
		}
		   catch(Exception e)
	    	{
			e.printStackTrace();
		    }

	}

}
