package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	WebDriver driver;
	
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
	     PageFactory.initElements(driver, this);
	 }
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Welcome')]") 
	 private WebElement txt_welocme;
	
	@FindBy(how = How.XPATH, using = "//a[@class='nav-link']") 
	 private WebElement webLink_logout;
	
	public void clickOn_Logout() {
		webLink_logout.click();
	}
	
	public boolean verify_welcome() {
		boolean isdisplayed = txt_welocme.isDisplayed();
		if(isdisplayed)
			return true;
		else
			return false;
	}


}
