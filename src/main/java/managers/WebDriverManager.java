package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.TestContext;
import enums.DriverType;

public class WebDriverManager {
	
	DriverType driverType;
	TestContext context;
	WebDriver driver;
	String CHROME_PROPERTY = "webdriver.chrome.driver";
	String FIREFOX_PROPERTY = "webdriver.gecko.driver";
	
	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
	}
	
	public WebDriver getDriver() {
		if(driver==null) driver = CreateDriver();
		return driver;
		}

	private WebDriver CreateDriver() {
		switch(driverType) {
		case CHROME:
			System.setProperty(CHROME_PROPERTY, FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty(FIREFOX_PROPERTY, FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
			driver = new FirefoxDriver();
			break;
	}
		return driver;
	}
	
	public void quitDriver() {
		driver.close();
		driver.quit();
	}

}
