package learnjava;

public class Temp {

	public static void main(String[] args) {  
		String runConfigPath =System.getProperty("runConfig") ;
		String sRunConfigFile=System.getProperty ("user.dir")+"/src/main/resources/config/runconfig.properties";
		
		System.out.println("runConfigPath "+ runConfigPath );
		System.out.println( "sRunConfigFile " + sRunConfigFile );
		
		//String[] names = getCryptoImpls("Cipher"); 
	}  
}  