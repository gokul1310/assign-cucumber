package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Utilities {
	
	WebDriver driver;
	
	public Utilities(WebDriver driver) {
		this.driver = driver;
	 }
	
	private final String propertyFilePath= "configs//Application.properties";
	
	public String appPropertyReader(String property){
		String value = "";
		Properties properties;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
				value =  properties.getProperty(property);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
		return value;
	}

}
