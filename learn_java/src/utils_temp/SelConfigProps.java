package utils_temp;

import java.io.InputStream;
import java.util.Properties;
import com.cmates.selenium.framework.utils.Logger;

public class SelConfigProps {
	
	public int serverPort = 4444;
	public String selConfigFolderPath = "";
	public String baseURL = "";
	public String browserStartCommand = "";
	public String serverHost = "";
	public String timeOut = "";
	public String logLevel = "";
	
	public boolean isValidIni = true;

	public Properties selProperties = new Properties();

	/*
	 * User defined values in seleniumconfig.properties will be assigned in the constructor.
	 */
	public SelConfigProps(String selConfigFile, ClassLoader classLoader) {
		
		Logger.debug("Selenium Config File: "+ selConfigFile);
		
		InputStream inputStream = classLoader.getResourceAsStream(selConfigFile); // user specific information based on environment parameter
		
		try
		{
			selProperties.load(inputStream);
		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
		}
		selConfigFolderPath = (new java.io.File(selConfigFile)).getParent();
		loadConfig(selProperties, classLoader);

	}

	public SelConfigProps(String selConfigFile)
	{
		Logger.debug("Selenium Config File: "+ selConfigFile);
		try {
			InputStream inputStream = new java.io.FileInputStream(selConfigFile);
			selProperties.load(inputStream);

			selConfigFolderPath = (new java.io.File(selConfigFile)).getParent();
			loadConfig(selProperties, null);
		} catch(Exception e) {
			Logger.error(e.getMessage());
		}
	}

	public void loadConfig(Properties selProperties, ClassLoader classLoader)
	{
		Logger.info("/*** Initilizing the variables with user defined values ***/");

		// reading selenium host information

		serverHost = System.getProperty("seleniumHost");
		if(serverHost != null && !serverHost.equals("${seleniumHost}")){
			Logger.info("MachineName taken from argument as: "+serverHost);
		}
		else if((serverHost = selProperties.getProperty("MachineIP")) != null && serverHost.length() != 0){
			//serverHost = selConfigIni.getValue("Common", "MachineIP");
			Logger.info("MachineIP taken from selconfig.properties as: "+serverHost);
		}
		else{
			Logger.error("MachineIP must be initialized in selconfig.properties or passed as argument.");
			isValidIni = false;
		}

		String seleniumPort = System.getProperty("seleniumPort");
		if(seleniumPort!=null && !seleniumPort.equals("${seleniumPort}")){
			Logger.info("Port number taken from argument as: "+serverPort);
		}
		else if((seleniumPort = selProperties.getProperty( "PortNumber")) != null && seleniumPort.length() != 0){
			//serverPort = Integer.parseInt(runConfigIni.getValue("Common", "PortNumber"));
			Logger.info("Port number taken from selconfig.properties as: "+serverPort);
		}
		else{
			Logger.warning("Port number is initialized to 4444 (default).");
			serverPort = 4444;
		}
			
		// reading browser information
		
		browserStartCommand = System.getProperty("browserType");
		if(browserStartCommand!=null && !browserStartCommand.equals("${browserType}")){
			Logger.info("BrowserType taken from argument as: "+browserStartCommand);
		}
		else if((browserStartCommand = selProperties.getProperty( "BrowserType")) != null && browserStartCommand.length() != 0){
			//browserStartCommand = selConfigIni.getValue("Common", "BrowserType");
			Logger.info("BrowserType taken from selconfig.properties as: "+browserStartCommand);
		}
		else{
			Logger.error("BrowserType must be initialized in selconfig.properties or passed as argument.");
			isValidIni = false;
		}
		// reading baseURL
		
		baseURL = System.getProperty("baseURL");
		if(baseURL!=null && !baseURL.equals("${baseURL}")){
			Logger.info("Base URL taken from argument as: "+baseURL);
		}
		else if((baseURL = selProperties.getProperty( "baseURL")) != null && baseURL.length() != 0){
			//browserStartCommand = selConfigIni.getValue("Common", "BrowserType");
			Logger.info("Base URL taken from selconfig.properties as: "+baseURL);
		}
		else{
			Logger.error("Base URL must be initialized in selconfig.properties or passed as argument.");
			isValidIni = false;
		}
		
	} 

}
