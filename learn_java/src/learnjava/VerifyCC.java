package learnjava;

public abstract class VerifyCC {

	
	//---------------------------------------------------------
	// Checks for valid credit card number using Luhn algorithm
	//---------------------------------------------------------

	

	  //--------------------------------
	  // Filter out non-digit characters
	  //--------------------------------

	  private static String getDigitsOnly (String s) {
	    StringBuffer digitsOnly = new StringBuffer ();
	    char c;
	    for (int i = 0; i < s.length (); i++) {
	      c = s.charAt (i);
	      if (Character.isDigit (c)) {
	        digitsOnly.append (c);
	      }
	    }
	    return digitsOnly.toString ();
	  }

	  //-------------------
	  // Perform Luhn check
	  //-------------------

	  public static boolean isValid (String cardNumber) {
	    String digitsOnly = getDigitsOnly (cardNumber);
	    int sum = 0;
	    int digit = 0;
	    int addend = 0;
	    boolean timesTwo = false;

	    for (int i = digitsOnly.length () - 1; i >= 0; i--) {
	      digit = Integer.parseInt (digitsOnly.substring (i, i + 1));
	      if (timesTwo) {
	        addend = digit * 2;
	        if (addend > 9) {
	          addend -= 9;
	        }
	      }
	      else {
	        addend = digit;
	      }
	      sum += addend;
	      timesTwo = !timesTwo;
	    }

	    int modulus = sum % 10;
	    return modulus == 0;

	  }

	  //-----
	  // Test
	  //-----

	  public static void main (String[] args) {
		  
		  //3523265223457080
	    String cardNumber = "7345658736068028";
	    boolean valid = VerifyCC.isValid (cardNumber);
	    System.out.println (cardNumber + ": " + valid);
	    cardNumber = "3531861493678525";
	    valid = VerifyCC.isValid (cardNumber);
	    System.out.println (cardNumber + ": " + valid);
	    cardNumber = "3576008969200279";
	    valid = VerifyCC.isValid (cardNumber);
	    System.out.println (cardNumber + ": " + valid);
	    cardNumber = "3544810894834539";
	    valid = VerifyCC.isValid (cardNumber);
	    System.out.println (cardNumber + ": " + valid);
	    
	    cardNumber = "3544137544887310";
	    valid = VerifyCC.isValid (cardNumber);
	    System.out.println (cardNumber + ": " + valid);
	  }

}


