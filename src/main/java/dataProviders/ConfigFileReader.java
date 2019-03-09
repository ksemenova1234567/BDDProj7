package dataProviders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

import enums.DriverType;

public class ConfigFileReader {
	
	Properties prop;
	private String configFilePath = "C:\\Users\\simir\\eclipse-workspace\\BDDProj7\\configure\\Configuration.properties";
	
	public ConfigFileReader() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(configFilePath));
			prop = new Properties();
			prop.load(reader);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public DriverType getBrowser() {
		String browser = prop.getProperty("browser");
		if((browser==null) || browser.equalsIgnoreCase("chrome")) return DriverType.CHROME;
		else if(browser.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else throw new RuntimeException("Browser is not set in the config file");
	}
	
	public String getUrl() {
		String url = prop.getProperty("url");
		if(url!=null) return url;
		else throw new RuntimeException("Url is not set in the config file");
	}
	
	public String getDriverPath() {
		String driverPath = prop.getProperty("driverPath");
		if(driverPath!=null) return driverPath;
		else throw new RuntimeException("DriverPath is not set in the config file");
	}
	
	public String getTestDataResourcePath() {
		String testDataReource = prop.getProperty("testDataReource");
		if(testDataReource!=null) return testDataReource;
		else throw new RuntimeException("TestDataReource is not set in the config file");
	}
	
	public String getextentConfigXMLFilePath() {
		String extentConfigXMLFilePath = prop.getProperty("extentConfigXMLFilePath");
		if(extentConfigXMLFilePath!=null) return extentConfigXMLFilePath;
		else throw new RuntimeException("ExtentConfigXMLFilePath is not set in the config file");
	}

}
