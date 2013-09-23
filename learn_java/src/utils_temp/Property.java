package utils_temp;

import java.io.*;
import java.util.*;

//import com.cmates.selenium.framework.utils.Logger;

public class Property {
	
	public static Properties prop=null;
	
	public Property(String s){
    prop = new Properties();
	try{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/"+s+"/src/main/resources/config/runconfig.properties");
	
	prop.load(fis);
	}catch(Exception e){}
	
	}
	
	public String getProperty(String query){
		return prop.getProperty(query);	
	}
}

/*
public class GetProperties {
	public String sRunConfigFile;

	public GetProperties()
	{
		String runConfigPath = System.getProperty("runConfig");
		if(runConfigPath != null && !runConfigPath.equals("${runConfig}")) {
			sRunConfigFile = System.getProperty ("user.dir")+"/"+runConfigPath;
		}
		else
		{
			//checking if runconfig file is present or not
			sRunConfigFile = System.getProperty("user.dir")+"/"+s+"/src/main/resources/config/runconfig.properties";
		}
		if(!(new File(sRunConfigFile).exists())){
			Logger.warning("File "+sRunConfigFile+" not exists");
			sRunConfigFile = "";
		}
		Logger.info("Run Config Path (GetProperties) "+sRunConfigFile);
	}
}*/
