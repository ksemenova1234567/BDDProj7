package stepDefinitions;

import org.junit.Assert;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;

public class LoginSteps {
	
	TestContext textContext;
	LoginPage login;
	
	public LoginSteps(TestContext context) {
		textContext = context;
		login = textContext.getPageObjectManager().getLoginPage();
	}

	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() throws Throwable {
		login.getUrl();
	}

	@When("^user enters valid \"([^\"]*)\" and password$")
	public void user_enters_valid_and_password(String username) throws Throwable {
		login.enterUnameAndPwd(username);
	}

	@When("^user clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		login.clickLogin();
	}

	@Then("^user should be logged in$")
	public void user_should_be_logged_in() throws Throwable {
		Assert.assertEquals("Page Title is incorrect", "CRMPR", login.getHomePage());
	}

}
