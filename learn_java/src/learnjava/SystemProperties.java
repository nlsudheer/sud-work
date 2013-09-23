package learnjava;

public class SystemProperties {
	//: object/ShowProperties.java


	public static void main(String[] args) {

		
		System.out.println("Prints all properties ");
		System.getProperties().list(System.out);

		System.out.println("Prints user name ");
		System.out.println(System.getProperty("user.name"));

		System.out.println("Prints Java Library path ");
		System.out.println(System.getProperty("java.library.path"));
		
		System.out.println("Prints Temp folder path ");
		System.out.println(System.getProperty("java.io.tmpdir"));
		
		//System.out.println("Prints System Env variables ");
		//System.out.println(System.getenv());
		
		
		System.out.println(System.getenv("TEMP"));
		
		String sTemp=System.getenv("TEMP");
		System.out.println(sTemp);
		
	}

} 


