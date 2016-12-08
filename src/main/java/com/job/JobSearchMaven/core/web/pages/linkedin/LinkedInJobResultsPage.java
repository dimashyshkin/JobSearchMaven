package com.job.JobSearchMaven.core.web.pages.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Text;

public class LinkedInJobResultsPage extends WebPage<LinkedInJobResultsPage>{
	
	private static final String PAGE_URL = "https://www.linkedin.com/vsearch/j";

	public LinkedInJobResultsPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public LinkedInJobResultsPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return 	getJobsPageHeader().isAvailable();
	}
	
	public String getJobsPageHeaderText() {
		return getJobsPageHeader().getText();
	}
	
	private Text getJobsPageHeader(){
		return new Text(driver, By.xpath("//div[@class='jserp-results-header']"));
	}
	
}
