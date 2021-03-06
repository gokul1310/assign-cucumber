package runners;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dataProvider.ConfigFileReader;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/stories",
		//tags="@Functional",
		glue= {"stepDefinitions"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome = true
		)
public class TestRunner {
	static ConfigFileReader configFileReader = new ConfigFileReader();
	@AfterClass
	 public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(configFileReader.getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	 }
}