package learnjava;

import java.util.Scanner;  
import java.util.regex.Pattern;  
import java.util.regex.Matcher;  
import java.util.regex.PatternSyntaxException;  

public class Search {  

	public static void main(String[] args) {  

		Pattern pattern = null;  
		Matcher matcher = null;  

		Scanner scanner = new Scanner(System.in);  

		while (true) {  

			try{  

				System.out.print("\nEnter your regex: ");  
				pattern = Pattern.compile(scanner.nextLine());  

				System.out.print("Enter input string to search: ");  
				matcher = pattern.matcher(scanner.nextLine());  

			} catch (PatternSyntaxException pse) {  

				System.out.format(  
				"There is a problem with the regular expression!%n");  
				System.out.format(  
						"The pattern in question is: %s%n",pse.getPattern());  
				System.out.format(  
						"The description is: %s%n",pse.getDescription());  
				System.out.format(  
						"The message is: %s%n",pse.getMessage());  
				System.out.format(  
						"The index is: %s%n",pse.getIndex());  
				System.exit(0);  
			}  

			boolean found = false;  
			while (matcher.find()) {  

				System.out.format("I found the text \"%s\" starting at " +  
						"index %d and ending at index %d.%n",  
						matcher.group(), matcher.start(), matcher.end());  
				found = true;  
			}  
			if(!found){  
				System.out.format("No match found.%n");  
			}  
		}  
	}  
}  