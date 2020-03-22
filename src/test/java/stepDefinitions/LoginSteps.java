package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.WelcomePage;

public class LoginSteps {
	WebDriver driver;
	LoginPage login;
	WelcomePage welcome;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;
	WebDriverManager webDriverManager;
	
	@Given("^user is in login page$")
	public void user_is_in_login_page() {
		configFileReader= new ConfigFileReader();
		webDriverManager= new WebDriverManager();
		driver = webDriverManager.getDriver();
		driver.get(configFileReader.getApplicationUrl());
		pageObjectManager = new PageObjectManager(driver);
		login = pageObjectManager.getLoginPage();
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
		welcome = pageObjectManager.getWelcomePage();
		boolean isdisplayed = welcome.verify_welcome();
		if(isdisplayed)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		driver.quit();
	}
	
	@Then("^he remains in login screen$")
	public void he_remains_in_login_screen() {
		boolean isdisplayed = login.verify_login();
		if(isdisplayed)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		driver.quit();
	}

}
