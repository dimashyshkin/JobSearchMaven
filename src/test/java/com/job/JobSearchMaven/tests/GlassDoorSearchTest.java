package com.job.JobSearchMaven.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.util.Map;

import org.testng.annotations.Test;

import com.job.JobSearchMaven.core.BaseTest;
import com.job.JobSearchMaven.core.CsvDataProvider;
import com.job.JobSearchMaven.core.web.pages.glassdoor.GlassDoorIndexPage;
import com.job.JobSearchMaven.core.web.pages.glassdoor.GlassDoorJobResultsPage;

public class GlassDoorSearchTest extends BaseTest {

	@Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
	public void doGlassDoorSearchTest(Map<String, String> testData) {
		System.out.println("GlassDoor search started. Driver "
				+ driver.hashCode());
		GlassDoorJobResultsPage resultsPage = new GlassDoorIndexPage(driver)
				.openSignInPopUp()
				.loginAs(testData.get("Username"), testData.get("Password"))
				.goToGlassDoorJobSearchPage()
				.fillInForm(testData.get("Keywords"), testData.get("Location"))
				.submitSearch();
		assertThat("JobsPage loaded with results", resultsPage
				.getJobsPageHeaderText().toLowerCase(), containsString(" jobs in "));
		System.out.println("GlassDoor search finished");
	}
}
