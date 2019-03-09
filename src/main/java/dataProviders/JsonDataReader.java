package dataProviders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import managers.FileReaderManager;
import testDataTypes.Login;

public class JsonDataReader {
	
	String jsonFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath() + "\\Login.json";
	private List<Login> loginList;
	
	public JsonDataReader() {
		BufferedReader reader = null;
		Gson gson = new Gson();
		try {
			reader = new BufferedReader(new FileReader(jsonFilePath));
			Login[] login = gson.fromJson(reader, Login[].class);
			loginList = Arrays.asList(login);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public final Login getLoginByUsername(String username) {
		for(Login login : loginList)
			if(login.username.equalsIgnoreCase(username))
				return login;
		throw new RuntimeException("Username not found in the json file");
	}

}
