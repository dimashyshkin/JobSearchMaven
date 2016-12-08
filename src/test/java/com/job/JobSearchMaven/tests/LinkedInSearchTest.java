package com.job.JobSearchMaven.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.*;

import com.job.JobSearchMaven.core.BaseTest;
import com.job.JobSearchMaven.core.CsvDataProvider;
import com.job.JobSearchMaven.core.web.pages.linkedin.LinkedInHomePage;
import com.job.JobSearchMaven.core.web.pages.linkedin.LinkedInJobResultsPage;

public class LinkedInSearchTest extends BaseTest{

	@Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
	public void doLinkedInSearchTest(Map<String, String> testData) {
		System.out.println("LinkedIn search started");
		LinkedInJobResultsPage resultsPage = new LinkedInHomePage(driver)
			.loadAsAnonymousUser()
			.loginAs(testData.get("Username"), testData.get("Password"))
			.goToLinkedInJobsPage()
			//.openAdvancedSearch()
			.fillInForm(
					testData.get("Keywords"),
					testData.get("Zipcode"))
			.submitSearch();
		assertThat("JobsPage loaded with results", resultsPage.getJobsPageHeaderText(), containsString(" jobs in "));
		//try{Thread.sleep(50000);}catch(Exception e){};
		System.out.println("LinkedIn search finished");	
	}	
}
