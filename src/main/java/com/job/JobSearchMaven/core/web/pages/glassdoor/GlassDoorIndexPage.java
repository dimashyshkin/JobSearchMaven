package com.job.JobSearchMaven.core.web.pages.glassdoor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Button;

public class GlassDoorIndexPage extends WebPage<GlassDoorIndexPage> {

	private static final String PAGE_URL = "http://www.glassdoor.com/index.htm";

	public GlassDoorIndexPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public GlassDoorIndexPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getSignInButton().isAvailable();
	}

	public GlassDoorSignInPage openSignInPopUp() {
		load();
		getSignInButton().click();
		return new GlassDoorSignInPage(driver).waitUntilAvailable();
	}

	public GlassDoorJobSearchPage goToGlassDoorJobSearchPage() {
		getJobSearchButton().click();
		return new GlassDoorJobSearchPage(driver).waitUntilAvailable();
	}

	private Button getSignInButton() {
		return new Button(driver,
				By.xpath("//span[@class='signin menuLink hiliting']"));
	}

	private Button getJobSearchButton() {
		return new Button(driver, By.xpath("//span[contains(text(),'Jobs')]"));
	}

}
