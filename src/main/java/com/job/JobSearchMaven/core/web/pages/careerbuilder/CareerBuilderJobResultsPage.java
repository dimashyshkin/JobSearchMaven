package com.job.JobSearchMaven.core.web.pages.careerbuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Link;
import com.job.JobSearchMaven.core.web.elements.Text;

public class CareerBuilderJobResultsPage extends WebPage<CareerBuilderJobResultsPage>{
	
	private static final String PAGE_URL = "http://www.careerbuilder.com/jobs/advancedResult.html";

	public CareerBuilderJobResultsPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public CareerBuilderJobResultsPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return 	getCreateJobAlertLink().isAvailable() &&
				getJobsPageHeader().isAvailable();
	}
	
	public String getJobsPageHeaderText() {
		return getJobsPageHeader().getText();
	}
	
	
	private Link getCreateJobAlertLink(){
		return new Link(driver, By.xpath("//a[@class='btn dice-btn-secondary job-alert pull-right']"));
	}
	
	private Text getJobsPageHeader(){
		return new Text(driver, By.xpath("//h1[@class='pull-left h1']"));
	}
	
}
