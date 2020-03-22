package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfigFileReader;

public class LoginPage {
	
	WebDriver driver;
	ConfigFileReader configFileReader;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	     PageFactory.initElements(driver, this);
	     configFileReader= new ConfigFileReader();
	     
	 }
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Login')]") 
	 private WebElement webLink_Login;
	
	@FindBy(how = How.NAME, using = "username") 
	 private WebElement txtbx_username;
	
	@FindBy(how = How.NAME, using = "password") 
	 private WebElement txtbx_password;
	
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-success']") 
	 private WebElement button_Login;
	
	public void enter_User(String name) {
		txtbx_username.sendKeys(name);
	}
	
	public void clear_User() {
		txtbx_username.clear();
	}
	
	public void enter_Pass(String name) {
		txtbx_password.sendKeys(name);
	}
	
	public void clickOn_LoginButton() {
		button_Login.click();
	}
	
	public void clickOn_Login() {
		webLink_Login.click();
	}
	
	public void navigateTo_LoginPage() {
		driver.get(configFileReader.getApplicationUrl());
	}
	
	public boolean verify_login() {
		boolean isdisplayed = webLink_Login.isDisplayed();
		if(isdisplayed)
			return true;
		else
			return false;
	}


}
