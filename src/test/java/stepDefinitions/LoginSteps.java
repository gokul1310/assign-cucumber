package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;
import pageObjects.WelcomePage;
import utils.Utilities;

public class LoginSteps {
	
	TestContext testContext;
	LoginPage login;
	WelcomePage welcome;
	Utilities utilities;
	
	public LoginSteps(TestContext context) {
		 testContext = context;
		 login = testContext.getPageObjectManager().getLoginPage();
		 welcome = testContext.getPageObjectManager().getWelcomePage();
		 utilities = testContext.getPageObjectManager().getUtilities();
	}
	
	@Given("^user is in login page$")
	public void user_is_in_login_page() {
		login.navigateTo_LoginPage();
		login.clickOn_Login();
	}

	@When("^he enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void he_enters_username_as_and_password_as(String user, String pass) {
		login.clear_User();
		login.enter_User(user);
		login.enter_Pass(pass);
	}

	@When("^he enters invalid username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void he_enters_invalid_username_as_and_password_as(String user, String pass) {
		login.clear_User();
		login.enter_User(user);
		login.enter_Pass(pass);
	}

	@When("^clicks on login button$")
	public void clicks_on_login_button() {
		login.clickOn_LoginButton();
	}

	@Then("^emp welcome page is displayed$")
	public void emp_welcome_page_is_displayed() {
		boolean isdisplayed = welcome.verify_welcome();
		if(isdisplayed)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
	}
	
	@Then("^he remains in login screen$")
	public void he_remains_in_login_screen() {
		boolean isdisplayed = login.verify_login();
		if(isdisplayed)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
	}
	
	@When("he enters username and password")
	public void he_enters_user_and_pass() {
		login.clear_User();
		login.enter_User(utilities.appPropertyReader("application.username"));
		login.enter_Pass(utilities.appPropertyReader("application.password"));
	}

}
