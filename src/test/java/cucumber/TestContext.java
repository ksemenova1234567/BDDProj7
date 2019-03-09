package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {
	
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	
	public TestContext() {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}

}
