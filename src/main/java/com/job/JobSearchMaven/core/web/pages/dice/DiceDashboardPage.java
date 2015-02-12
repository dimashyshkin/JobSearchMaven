package com.job.JobSearchMaven.core.web.pages.dice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Link;

public class DiceDashboardPage extends WebPage<DiceDashboardPage>{
	
	private static final String PAGE_URL = BASE_URL + "/dashboard";

	public DiceDashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public DiceDashboardPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getAdvancedJobSearchLink().isAvailable();
	}
	
	public DiceLoginPage loadAsAnonymousUser(){
		load();
		return new DiceLoginPage(driver).waitUntilAvailable();
	}
	
	public DiceAdvancedSearchPage goToDiceAdvancedSearchPage() {
		getAdvancedJobSearchLink().click();
		return new DiceAdvancedSearchPage(driver).waitUntilAvailable();
	}
	
	private Link getAdvancedJobSearchLink(){
		return new Link(driver, By.xpath("//a[@class='dice-btn-link']"));
	}
	
}
