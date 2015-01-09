package com.job.JobSearchMaven.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
	protected WebDriver driver;
	
	@BeforeTest(alwaysRun = true)
	public void setUp() {
		driver = new FirefoxDriver();
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
