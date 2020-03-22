package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;
import pageObjects.WelcomePage;

public class LogoutSteps {
	
	TestContext testContext;
	LoginPage login;
	WelcomePage welcome;
	
	public LogoutSteps(TestContext context) {
		 testContext = context;
		 login = testContext.getPageObjectManager().getLoginPage();
		 welcome = testContext.getPageObjectManager().getWelcomePage();
	}
	
	@Given("^user is in welcome page$")
	public void user_is_in_welcome_page() {
		login.navigateTo_LoginPage();
		login.clickOn_Login();
		login.clear_User();
		login.enter_User("admin");
		login.enter_Pass("admin");
		login.clickOn_LoginButton();
	}
	
	@When("^he clicks on logout button$")
	public void he_clicks_on_logout_button() {
		welcome.clickOn_Logout();
	}

	@Then("^login page is displayed$")
	public void login_page_is_displayed() {
		boolean isdisplayed = login.verify_login();
		if(isdisplayed)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
	}

}
