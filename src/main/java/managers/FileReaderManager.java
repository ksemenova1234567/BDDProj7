package managers;

import dataProviders.ConfigFileReader;
import dataProviders.JsonDataReader;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private ConfigFileReader configFileReader;
	private JsonDataReader jsonDataReader;
	
	private FileReaderManager() {
		
	}
	
	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}
	
	public ConfigFileReader getConfigFileReader() {
		return (configFileReader==null) ? new ConfigFileReader() : configFileReader;
	}
	
	public JsonDataReader getJsonDataReader() {
		return (jsonDataReader==null) ? new JsonDataReader() : jsonDataReader;
	}

}
