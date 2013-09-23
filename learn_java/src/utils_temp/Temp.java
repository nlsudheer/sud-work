package utils_temp;

public class Temp {

	/*public static void test () {
		int j=0;

		while (j>3) {

			String sXpath = "//div[@id='contentContainer']/div/div[2]/table[2]/tbody/tr[1]/td/table/tbody/tr[2]/td[1]";

			System.out.println("sXpath	"+sXpath);

			String sXpath1 = "//div[@id='contentContainer']/div/div[2]/table['"+j+"']/tbody/tr[1]/td/table/tbody/tr[2]/td[1]";

			System.out.println("sXpath1	"+sXpath1);

			j++;
		}

	}*/


	public static void main(String args[]) {


	//	for  (int j=0;j>3;j++) {

			String sXpath = "//div[@id='contentContainer']/div/div[2]/table[2]/tbody/tr[1]/td/table/tbody/tr[2]/td[1]";

			System.out.println("sXpath	"+sXpath);

			int j =1;
			String sXpath1 = "//div[@id='contentContainer']/div/div[2]/table["+j+"]/tbody/tr[1]/td/table/tbody/tr[2]/td[1]";

			System.out.println("sXpath1	"+sXpath1);

		//	j++;
		}

	

}



