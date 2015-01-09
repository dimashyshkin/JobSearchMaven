package com.job.JobSearchMaven.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverMaster {

	private DriverMaster(){};
	
	public static WebDriver getDriver(String driverKey){
		BrowserType browser = BrowserType.get(driverKey);
		WebDriver driver;
		
		//Dont know better way to get path
		String classpath = DriverMaster.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		classpath = classpath.replaceAll("/target/classes/", "");
		classpath = classpath.substring(1);
		System.out.println(classpath);
		
		switch (browser) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				System.setProperty("webdriver.chrome.driver",classpath + "/src/main/resources/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case IE:
				System.setProperty("webdriver.ie.driver",classpath + "/src/main/resources/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			default:
				driver = new FirefoxDriver();
				break;
		}
		return driver;
	}
}
