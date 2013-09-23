package utils_temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
//import java.io.InputStream;
import java.net.URL;

//import com.cmates.selenium.framework.page.WebObj;
//import com.cmates.selenium.framework.utils.Logger;

public class XmlParser {
	
	static boolean flag =false;
	
	public static void createXmlFile(String SourceURL){
		
	try {	
	 URL url = new URL(SourceURL);	
	 BufferedReader input =  new BufferedReader(new InputStreamReader(url.openStream()));
		
	 String str=new String();
	 BufferedWriter out = new BufferedWriter(new FileWriter("f://temp//case1.xml")); 
	 	while((str=input.readLine())!=null)
	 	{
		out.write(str);
	 	}
	 	out.close();
	}catch (Exception e){
		e.printStackTrace();}
	
	}
		
}

