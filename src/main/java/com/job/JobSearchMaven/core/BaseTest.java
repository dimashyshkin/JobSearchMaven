package com.job.JobSearchMaven.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
	protected WebDriver driver;
	
	@BeforeTest(alwaysRun = true)
	@Parameters({"browser"})
	public void setUp(String browser) {
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			driver = new InternetExplorerDriver();
		} else if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else {driver = new FirefoxDriver();} 
		
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
