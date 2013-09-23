// http://www.tutorialspoint.com/java/java_string_split.htm
package practice;

public class LearnSubstring {
	   public static void main(String args[]){
	      String Str = new String("Welcome-to-Tutorials-point.com");

	      System.out.println("Return Value :" );
	      for (String retval: Str.split("-", 2)){
	         System.out.println(retval);
	      }
	      System.out.println("");
	      System.out.println("Return Value :" );
	      for (String retval: Str.split("-", 3)){
	         System.out.println(retval);
	      }
	      System.out.println("");
	      System.out.println("Return Value :" );
	      for (String retval: Str.split("-", 0)){
	         System.out.println(retval);
	      }
	      System.out.println("");
	      System.out.println("Return Value :" );
	      for (String retval: Str.split("-")){
	         System.out.println(retval);
	      }
	   }
	}


/* output

Return Value :
Welcome
to-Tutorials-point.com

Return Value :
Welcome
to
Tutorials-point.com

Return Value :
Welcome
to
Tutorials
point.com

Return Value :
Welcome
to
Tutorials
point.com

*/