package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import pageObjects.WelcomePage;
import utils.Utilities;

public class PageObjectManager {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private WelcomePage welcomePage;
	private Utilities utilities;
	
	public PageObjectManager(WebDriver driver) {		 
		 this.driver = driver;
	}
	
	public LoginPage getLoginPage(){
		 return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
		  
	public WelcomePage getWelcomePage() {
		 return (welcomePage == null) ? welcomePage = new WelcomePage(driver) : welcomePage;
	}

	public Utilities getUtilities() {
		 return (utilities == null) ? utilities = new Utilities(driver) : utilities;
	}

}
