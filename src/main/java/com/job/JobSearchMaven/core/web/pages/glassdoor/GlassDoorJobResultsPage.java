package com.job.JobSearchMaven.core.web.pages.glassdoor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Button;
import com.job.JobSearchMaven.core.web.elements.Text;

public class GlassDoorJobResultsPage extends WebPage<GlassDoorJobResultsPage>{

	public GlassDoorJobResultsPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isAvailable() {
		return 	getCreateJobAlertButton().isAvailable() &&
				getJobsPageHeader().isAvailable();
	}
	
	public String getJobsPageHeaderText() {
		return getJobsPageHeader().getText();
	}
	
	
	private Button getCreateJobAlertButton(){
		return new Button(driver, By.xpath("//button[@id='JobAlertButtonACol']"));
	}
	
	private Text getJobsPageHeader(){
		return new Text(driver, By.xpath("//h1[@class='noMargTop notranslate']"));
	}

	@Override
	public GlassDoorJobResultsPage load() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
