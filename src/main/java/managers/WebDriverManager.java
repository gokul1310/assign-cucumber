package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;

public class WebDriverManager {

	ConfigFileReader configFileReader = new ConfigFileReader();

	private WebDriver driver;
	private static String driverType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static String path = System.getProperty("user.dir") + "\\chromedriver.exe";

	public WebDriverManager() {
		driverType = configFileReader.getBrowser();
	}
	
	public WebDriver getDriver() {
		if(driver == null) driver = createLocalDriver();
		return driver;
	}

	private WebDriver createLocalDriver() {
		if(driverType.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_DRIVER_PROPERTY, path);
			driver = new ChromeDriver();
		}else {
			System.out.println("Driver initialization failed");
		}
		if (configFileReader.getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(),	TimeUnit.SECONDS);
		return driver;
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}
