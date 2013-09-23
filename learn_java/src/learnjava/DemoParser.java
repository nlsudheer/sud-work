package learnjava;

import java.io.*;
import jxl.*;

public class DemoParser {
	public static void main(String args[])
	   {
		
		//File f= new File("F:\\workspace\\learning\\src\\excel\\employee_xls.xls");
		//if(f.exists())
		//{
			System.out.println("Running Excel");
		
		try
		{
	     Workbook workbook=Workbook.getWorkbook(new File("f:\\temp\\example.xls"));
	     Sheet sheet=workbook.getSheet("Sheet2");
	     Cell a1=sheet.getCell(2,2);
	     //Cell b1=sheet.getCell(1,2);
	     //Cell c1=sheet.getCell(2,1);
	     String sa1=a1.getContents();
	     //String sb1=b1.getContents();
	     //String sc1=c1.getContents();
	     System.out.println(sa1);
		}
		/*catch(BiffException e)
		{
			System.err.println( e );
		}*/
		catch(Exception e)
		{
		   System.err.println( e );
		}
	   }
	}

