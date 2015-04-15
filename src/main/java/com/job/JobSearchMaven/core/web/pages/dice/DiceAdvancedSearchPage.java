package com.job.JobSearchMaven.core.web.pages.dice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Button;
import com.job.JobSearchMaven.core.web.elements.TextInput;

public class DiceAdvancedSearchPage extends WebPage<DiceAdvancedSearchPage>{
	
	//private static final String PAGE_URL = BASE_URL + "/jobs/advancedSearch.html";
	private static final String PAGE_URL = "http://dice.com/jobs/advancedSearch.html";

	public DiceAdvancedSearchPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public DiceAdvancedSearchPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return 	getKeywordsInput().isAvailable() &&
				getExcludedKeywordsInput().isAvailable() &&
				getLocationInput().isAvailable() &&
				getFindTechJobsButton().isAvailable();
	}
	
	public DiceAdvancedSearchPage fillInForm(String keywords, String excludedKeywords, String location) {
		getKeywordsInput().inputText(keywords);
		getExcludedKeywordsInput().inputText(excludedKeywords);
		getLocationInput().clearInputField().inputText(location);
		return this;
	}
	
	public DiceAdvancedSearchResultsPage submitSearch() {
		getFindTechJobsButton().click();
		return new DiceAdvancedSearchResultsPage(driver).waitUntilAvailable();
	}
	
	private TextInput getKeywordsInput(){
		return new TextInput(driver, By.xpath("//input[@id='for_one']"));
	}
	
	private TextInput getExcludedKeywordsInput(){
		return new TextInput(driver, By.xpath("//input[@id='for_none']"));
	}
	
	private TextInput getLocationInput(){
		return new TextInput(driver, By.xpath("//input[@id='for_loc']"));
	}
	
	private Button getFindTechJobsButton(){
		return new Button(driver, By.xpath("//input[@class='btn btn-lg btn-primary btn-block dice-btn']"));
	}
	
}
