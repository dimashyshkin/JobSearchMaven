package com.job.JobSearchMaven.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.*;

import com.job.JobSearchMaven.core.BaseTest;
import com.job.JobSearchMaven.core.CsvDataProvider;
import com.job.JobSearchMaven.core.web.pages.careerbuilder.CareerBuilderJobResultsPage;
import com.job.JobSearchMaven.core.web.pages.careerbuilder.CareerBuilderMyCareerBuilderPage;

public class CareerBuilderSearchTest extends BaseTest{

	@Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
	public void doCareerBuilderSearchTest(Map<String, String> testData) {
		System.out.println("CareerBuilder search started");
		CareerBuilderJobResultsPage resultsPage = new CareerBuilderMyCareerBuilderPage(driver)
			.loadAsAnonymousUser()
			.loginAs(testData.get("Username"), testData.get("Password"))
			.goToCareerBuilderJobSearchPage()
			.goToCareerBuilderAdvancedSearchPage()
			.selectUseByValue("ANY")
			.fillInForm(
					testData.get("Keywords"),
					testData.get("ExcludedKeywords"),
					testData.get("Location1"),
					testData.get("Location2"),
					testData.get("Location3"))
			.submitSearch();
		assertThat("JobsPage loaded with results", resultsPage.getJobsPageHeaderText().toLowerCase(), containsString(testData.get("Keywords").toLowerCase() + " jobs in "));
		System.out.println("CareerBuilder search finished");
	}	
}
