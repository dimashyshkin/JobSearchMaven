package com.job.JobSearchMaven.core.web.pages.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Link;

public class LinkedInHomePage extends WebPage<LinkedInHomePage> {

	private static final String PAGE_URL = "https://www.linkedin.com/";

	public LinkedInHomePage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public LinkedInHomePage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getJobsLink().isAvailable();
	}
	
	public LinkedInLoginPage loadAsAnonymousUser(){
		load();
		return new LinkedInLoginPage(driver).waitUntilAvailable();
	}
	
	public LinkedInJobsPage goToLinkedInJobsPage() {
		getJobsLink().click();
		return new LinkedInJobsPage(driver).waitUntilAvailable();
	}
	
	private Link getJobsLink(){
		return new Link(driver, By.xpath("//a[contains(text(),'Jobs')]"));
	}
}
