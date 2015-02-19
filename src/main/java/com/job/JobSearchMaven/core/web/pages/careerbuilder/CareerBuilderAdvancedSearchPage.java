package com.job.JobSearchMaven.core.web.pages.careerbuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Button;
import com.job.JobSearchMaven.core.web.elements.Dropdown;
import com.job.JobSearchMaven.core.web.elements.TextInput;

public class CareerBuilderAdvancedSearchPage extends WebPage<CareerBuilderAdvancedSearchPage>{
	
	private static final String PAGE_URL = "http://www.careerbuilder.com/jobseeker/jobs/advancedsearch.aspx";

	public CareerBuilderAdvancedSearchPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public CareerBuilderAdvancedSearchPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return 	getKeywordsInput().isAvailable() &&
				getExcludeTitleInput().isAvailable() &&
				getLocation1Input().isAvailable() &&
				getLocation2Input().isAvailable() &&
				getLocation3Input().isAvailable() &&
				getFindJobsButton().isAvailable() &&
				getUseDropdown().isAvailable();
	}
	
	public CareerBuilderAdvancedSearchPage selectUseByValue(String value) {
			getUseDropdown().selectByValue(value);
		return new CareerBuilderAdvancedSearchPage(driver).waitUntilAvailable();
	}
	
	public CareerBuilderAdvancedSearchPage fillInForm(String keywords, String excludedKeywords, String location1, String location2, String location3) {
		getKeywordsInput().inputText(keywords);
		getExcludeTitleInput().inputText(excludedKeywords);
		getLocation1Input().clearInputField().inputText(location1);
		getLocation2Input().clearInputField().inputText(location2);
		getLocation3Input().clearInputField().inputText(location3);
		return this;
	}
	
	public CareerBuilderJobResultsPage submitSearch() {
		getFindJobsButton().click();
		return new CareerBuilderJobResultsPage(driver).waitUntilAvailable();
	}
	
	private TextInput getKeywordsInput(){
		return new TextInput(driver, By.xpath("//input[@id='advancedSearch_s_rawwords']"));
	}
	
	private TextInput getExcludeTitleInput(){
		return new TextInput(driver, By.xpath("//input[@id='advancedSearch_exjl']"));
	}
	
	private TextInput getLocation1Input(){
		return new TextInput(driver, By.xpath("//input[@class='advancedSearch_s_freeloc_1_clean']"));
	}
	
	private TextInput getLocation2Input(){
		return new TextInput(driver, By.xpath("//input[@class='advancedSearch_s_freeloc_2_clean']"));
	}
	
	private TextInput getLocation3Input(){
		return new TextInput(driver, By.xpath("//input[@class='advancedSearch_s_freeloc_3_clean']"));
	}
	
	private Button getFindJobsButton(){
		return new Button(driver, By.xpath("//input[@id='SearchBtn']"));
	}
	
	private Dropdown getUseDropdown(){
		return new Dropdown(driver, By.xpath("//select[@id='advancedSearch_s_use']"));
	}
	
}
