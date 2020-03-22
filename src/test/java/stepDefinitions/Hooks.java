package stepDefinitions;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.WebDriverManager;

public class Hooks {
	
	WebDriverManager webDriverManager;

	@Before
	public void beforeScenario(Scenario scenario) {
		Reporter.assignAuthor("Cucumber Test - Gokul Raj");
	}
/*
	@After
	public void AfterSteps() {
		driver.quit();
	}
*/
}