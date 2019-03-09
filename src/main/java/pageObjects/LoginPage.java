package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import testDataTypes.Login;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	WebElement tbUsername;
	
	@FindBy(name = "password")
	WebElement tbPassword;
	
	@FindBy(xpath = "//input[@class='btn btn-small']")
	WebElement btnLogin;

	public void getUrl() {
		driver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
	}

	public void enterUnameAndPwd(String username) {
		Login lg = FileReaderManager.getInstance().getJsonDataReader().getLoginByUsername(username);
		tbUsername.sendKeys(username);
		tbPassword.sendKeys(lg.password);
	}

	public void clickLogin() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click()", btnLogin);
	}

	public HomePage getHomePage() {
		return new HomePage();
	}

}
