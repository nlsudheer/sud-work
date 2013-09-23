package utils_temp;


import java.io.*;
import java.util.*;
public class DirectoryList {

	/**
	 * @param args
	 */
	
	static void scanDir(File dir)
	{String[] subFiles = dir.list();
	
	for(int i=0;i<subFiles.length;i++)
	{
		File temp=new File(dir,subFiles[i]);
		if(temp.isFile()){
			// getting error here
			Date date=new Date(temp.lastModified());
			System.out.println("File   :"+subFiles[i]+"\t last modifed   :"+date);
			System.out.println("File1   :"+subFiles[i]+"\t last modifed   :"+date.toString());
			
		}
		
		else if(temp.isDirectory()){
			if(subFiles[i].equalsIgnoreCase("RECYCLER")||subFiles[i].equalsIgnoreCase("System Volume Information")||subFiles[i].startsWith("."))
			{}else{
				scanDir(temp);
				System.out.println("Directory   :"+subFiles[i]);
				
			}
			
		}
		
		
		else
			System.out.println("other       :"+subFiles[i]);
		
	}
		

		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File dir=new File("F:/temp");
		scanDir(dir);			
	}

}
