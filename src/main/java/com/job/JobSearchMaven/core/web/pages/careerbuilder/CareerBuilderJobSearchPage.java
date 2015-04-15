package com.job.JobSearchMaven.core.web.pages.careerbuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Link;

public class CareerBuilderJobSearchPage extends WebPage<CareerBuilderJobSearchPage>{
	
	private static final String PAGE_URL = "http://www.careerbuilder.com/browse/?sc_cmp2=JS_Nav_FindJobs";

	public CareerBuilderJobSearchPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public CareerBuilderJobSearchPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getAdvancedSearchLink().isAvailable();
	}
	
	public CareerBuilderAdvancedSearchPage goToCareerBuilderAdvancedSearchPage() {
		getAdvancedSearchLink().click();
		return new CareerBuilderAdvancedSearchPage(driver).waitUntilAvailable();
	}
	
	private Link getAdvancedSearchLink(){
		return new Link(driver, By.xpath("//a[@id='AdvancedSearch']"));
	}
	
}
