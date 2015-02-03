package com.job.JobSearchMaven.core.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Link;

public class DiceDashboardPage extends WebPage<DiceDashboardPage>{
	
	private static final String PAGE_URL = "https://www.dice.com/dashboard";

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
		return getAdvancedJobSearch().isAvailable();
	}
	
	public DiceLoginPage loadAsAnonymousUser(){
		load();
		return new DiceLoginPage(driver).waitUntilAvailable();
	}
	
	private Link getAdvancedJobSearch(){
		return new Link(driver, By.xpath("//a[@class='dice-btn-link']"));
	}
	
}
