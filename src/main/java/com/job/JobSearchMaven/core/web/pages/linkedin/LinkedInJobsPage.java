package com.job.JobSearchMaven.core.web.pages.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Button;
import com.job.JobSearchMaven.core.web.elements.TextInput;

public class LinkedInJobsPage extends WebPage<LinkedInJobsPage>{
	
	private static final String PAGE_URL = "https://www.linkedin.com/job/home";

	public LinkedInJobsPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public LinkedInJobsPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return 	getSearchBoxInput().isAvailable() &&
				getSearchButton().isAvailable() &&
				getAdvancedSearchButton().isAvailable();
	}
	
	public LinkedInJobsPage openAdvancedSearch() {
		getAdvancedSearchButton().click();
		return this.waitUntilAvailable();
	}
	
	public LinkedInJobsPage fillInForm(String keywords, String zipcode) {
		getSearchBoxInput().inputText(keywords);
		getZipCodeInput().clearInputField().inputText(zipcode);
		return this;
	}

	public LinkedInJobResultsPage submitSearch() {
		getSearchButton().click();
		return new LinkedInJobResultsPage(driver).waitUntilAvailable();
	}
	
	private TextInput getSearchBoxInput(){
		return new TextInput(driver, By.xpath("//input[@id='field-keyword-name']"));
	}

	private TextInput getZipCodeInput(){
		return new TextInput(driver, By.xpath("//input[@id='field-location-name']"));
	}

	private Button getSearchButton(){
		return new Button(driver, By.xpath("//input[@class='search-button']"));
	}
	
	private Button getAdvancedSearchButton(){
		return new Button(driver, By.xpath("//button[@id='toggle-advanced']"));
	}
	
}
