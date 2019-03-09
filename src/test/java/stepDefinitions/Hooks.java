package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;

public class Hooks {
	
	TestContext testContext;
	
	public Hooks(TestContext testContext) {
		this.testContext = testContext;
	}
	
	@After
	public void tearDown() {
		testContext.getWebDriverManager().quitDriver();
	}

}
