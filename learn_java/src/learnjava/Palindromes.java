package learnjava;

import java.io.*;

// Palindrome for both Numerical and Strings by removing junk characters

public class Palindromes{

	public static boolean  isPalindrome(String sInput) {

		String workingCopy = removeJunk(sInput);
		String reversedCopy = reverse(workingCopy);
		
			return workingCopy.equalsIgnoreCase(reversedCopy);
				
	}
	public static String reverse(String sInput) {
		StringBuffer sb = new StringBuffer(sInput);
		
		return sb.reverse().toString();
		
	}

	public static String removeJunk(String sInput) {
		int i, len = sInput.length();
		StringBuffer dest = new StringBuffer(len);
		char c;

		for(i =(len-1);i>=0;i--) {
			c = sInput.charAt(i);
		//	c = Character.toLowerCase(c); not required can handle this at String level
			
			if(Character.isLetterOrDigit(c)) {
				dest.append(c);

			}

		}
		return dest.toString();

	}

	public static void main (String []args) {

		String str = null;
		try {
			BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
			str = bfr.readLine();
		} catch(Exception e) {
			System.out.println("Exception in reading the data.");
		}

		if(isPalindrome(str)) {

			System.out.println("It's a Palindrome");
		}else {
			System.out.println("It's not a Palindrome");			
		}
	}
}


/*
// FAIL
public class Palindromes {

	public static boolean verifyPalindrome(String sPal) {



		if(sPal.length() == 0 || sPal.length()==1) {
			System.out.println("Please enter a valid string");
			return true;
		} 

		if(sPal.charAt(0) == sPal.length()-1) {
		return verifyPalindrome(sPal.substring(1,sPal.length()-1));	
		}

		return false;
	}

	public static void main (String []args) {


		try {
		BufferedReader bfd = new BufferedReader(new InputStreamReader (System.in));
		String str = bfd.readLine();
		boolean result = verifyPalindrome(str);

		if (result) {
			System.out.println("Is a Palindrome");
		}else {
			System.out.println("Is not a Palindrome");
		}

		} catch (Exception e) {
			System.out.println("Excption in reading the data.");
		}



	}

}
 */