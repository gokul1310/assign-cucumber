package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import pageObjects.WelcomePage;

public class PageObjectManager {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private WelcomePage welcomePage;
	
	public PageObjectManager(WebDriver driver) {		 
		 this.driver = driver;
	}
	
	public LoginPage getLoginPage(){
		 return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
		  
	public WelcomePage getWelcomePage() {
		 return (welcomePage == null) ? welcomePage = new WelcomePage(driver) : welcomePage;
	}

}
