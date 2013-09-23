package learnjava;

import java.util.Calendar;
import java.text.SimpleDateFormat;


public class GetDateAndTime {



	public static String now(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());

	}

	public static void  main(String arg[]) {
		System.out.println(GetDateAndTime.now("yyyy'-'MMMMM'-'dd'-'hh:mm:ss"));
		System.out.println(GetDateAndTime.now("dd MMMMM yyyy"));
		System.out.println(GetDateAndTime.now("yyyy'-'MM'-'dd'-'hh:mm:ss"));
		System.out.println(GetDateAndTime.now("dd.MM.yy"));
		System.out.println(GetDateAndTime.now("MM/dd/yy"));
		System.out.println(GetDateAndTime.now("yyyy.MM.dd G 'at' hh:mm:ss z"));
		System.out.println(GetDateAndTime.now("EEE, MMM d, ''yy"));
		System.out.println(GetDateAndTime.now("h:mm a"));
		System.out.println(GetDateAndTime.now("H:mm:ss:SSS"));
		System.out.println(GetDateAndTime.now("K:mm a,z"));
		System.out.println(GetDateAndTime.now("yyyy.MMMMM.dd GGG hh:mm aaa"));
	}
}



