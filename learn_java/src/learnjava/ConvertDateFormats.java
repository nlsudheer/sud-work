package learnjava;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/*
  Convert date string from one format to another format using SimpleDateFormat
  This example shows how to convert format of a string containing date
  and time to other formats using Java SimpleDateFormat class.
*/

public class ConvertDateFormats{

	public static void main(String[]args){

		//string containing date in one format

		String strDate="12/12/07";
		try

		{
			//createSimpleDateFormatobjectwithsourcestringdateformat
			SimpleDateFormat sdfSource=new SimpleDateFormat("dd/MM/yy");

			//parsethestringintoDateobject
			Date date =sdfSource.parse(strDate);

			//createSimpleDateFormatobjectwithdesireddateformat

			SimpleDateFormat sdfDestination=new SimpleDateFormat("yyyyMMdd_hhmmss");

			//parsethedateintoanotherformat
			strDate=sdfDestination.format(date);

			System.out.println("Date is converted from dd/MM/yy format to MM-dd-yyyyhh:mm:ss");
			System.out.println("Converted  date is:"+strDate);
		}

		catch(ParseException pe)
		{
			System.out.println("ParseException:"+pe);
		}

	}
}


/*

Typical output would be
Date is converted from dd/MM/yy format to MM-dd-yyyy hh:mm:ss
Converted date is : 12-12-2007 12:00:00

*/