package com.job.JobSearchMaven.core.web.pages.careerbuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Link;

public class CareerBuilderMyCareerBuilderPage extends WebPage<CareerBuilderMyCareerBuilderPage>{
	
	private static final String PAGE_URL = "http://www.careerbuilder.com/jobseeker/mycb.aspx";

	public CareerBuilderMyCareerBuilderPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public CareerBuilderMyCareerBuilderPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getHomeLink().isAvailable();
	}
	
	public CareerBuilderLoginPage loadAsAnonymousUser(){
		load();
		return new CareerBuilderLoginPage(driver).waitUntilAvailable();
	}
	
	public CareerBuilderHomePage goToCareerBuilderHomePage() {
		getHomeLink().click();
		return new CareerBuilderHomePage(driver).waitUntilAvailable();
	}
	
	private Link getHomeLink(){
		return new Link(driver, By.xpath("//a[contains(@href,'JS_Nav_Home')]"));
	}
	
}
