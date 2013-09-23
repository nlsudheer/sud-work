package learnjava;

public class ShowProperties {
	//: object/ShowProperties.java

	 
	  public static void main(String[] args) {

	    System.getProperties().list(System.out);

	    System.out.println(System.getProperty("user.name"));

	    System.out.println(System.getProperty("java.library.path"));

	  }

	} 


