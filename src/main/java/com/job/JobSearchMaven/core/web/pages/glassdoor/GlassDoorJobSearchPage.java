package com.job.JobSearchMaven.core.web.pages.glassdoor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Button;
import com.job.JobSearchMaven.core.web.elements.TextInput;

public class GlassDoorJobSearchPage extends WebPage<GlassDoorJobSearchPage> {

	private static final String PAGE_URL = "http://www.careerbuilder.com/browse/?sc_cmp2=JS_Nav_FindJobs";

	public GlassDoorJobSearchPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public GlassDoorJobSearchPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getKeywordsInput().isAvailable()
				&& getLocationInput().isAvailable()
				&& getSearchButton().isAvailable();
	}

	public GlassDoorJobSearchPage fillInForm(String keywords, String location) {
		getKeywordsInput().inputText(keywords);
		getLocationInput().inputText(location);
		return this;
	}

	public GlassDoorJobResultsPage submitSearch() {
		getSearchButton().click();
		return new GlassDoorJobResultsPage(driver).waitUntilAvailable();
	}

	private TextInput getKeywordsInput() {
		return new TextInput(
				driver,
				By.xpath("//input[@class='std keyword lg gradient notranslate ui-autocomplete-input glassdoorAC']"));
	}

	private TextInput getLocationInput() {
		return new TextInput(
				driver,
				By.xpath("//input[@class='std loc med gradient lg ui-autocomplete-input glassdoorAC']"));
	}

	private Button getSearchButton() {
		return new Button(
				driver,
				By.xpath("//button[@class=' gd-btn gd-btn-submit gd-btn-1 gd-btn-lg gd-btn-icon gradient']"));
	}

}
