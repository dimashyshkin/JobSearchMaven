package com.job.JobSearchMaven.core;

import static com.job.JobSearchMaven.core.DriverMaster.getDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
	protected WebDriver driver;
	
	@BeforeTest(alwaysRun = true)
	@Parameters({"browser"})
	public void setUp(@Optional("firefox") String browser) {
		driver = getDriver(browser);
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
