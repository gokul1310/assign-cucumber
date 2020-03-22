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

public class LogoutSteps {
	WebDriver driver;
	LoginPage login;
	WelcomePage welcome;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;
	WebDriverManager webDriverManager;
	
	@Given("^user is in welcome page$")
	public void user_is_in_welcome_page() {
		configFileReader= new ConfigFileReader();
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		driver.get(configFileReader.getApplicationUrl());
		pageObjectManager = new PageObjectManager(driver);
		login = pageObjectManager.getLoginPage();
		login.clickOn_Login();
		login.clear_User();
		login.enter_User("admin");
		login.enter_Pass("admin");
		login.clickOn_LoginButton();
	}
	
	@When("^he clicks on logout button$")
	public void he_clicks_on_logout_button() {
		welcome = pageObjectManager.getWelcomePage();
		welcome.clickOn_Logout();
	}

	@Then("^login page is displayed$")
	public void login_page_is_displayed() {
		boolean isdisplayed = login.verify_login();
		if(isdisplayed)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		driver.quit();
	}

}
