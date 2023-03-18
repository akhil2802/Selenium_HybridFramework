package com.crm.crm_hybridframework.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeywordsImpl implements Keywords {

	static WebDriver driver;

	static FileInputStream inputStream = null;

	static Properties prop = null;

	public void open() {

		prop = new Properties();

		try {
			inputStream = new FileInputStream(
					"F:\\Work_Spaces\\eclipse_workspace\\crm_hybridframework\\src\\main\\java\\com\\crm\\crm_hybridframework\\base\\objectrepository.properties");
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}

		driver = new FirefoxDriver();
	}

	public void url(String url) {

		driver.get(url);
	}

	public void input(String inputData, String objectName) {

		driver.findElement(By.xpath(prop.getProperty(objectName))).sendKeys(inputData);
	}

	public void click(String objectName) {
		
		driver.findElement(By.xpath(prop.getProperty(objectName))).click();
	}

	public void quit() {
		
		driver.close();
	}

}
