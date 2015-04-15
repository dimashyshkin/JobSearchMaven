package com.job.JobSearchMaven.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.*;

import com.job.JobSearchMaven.core.BaseTest;
import com.job.JobSearchMaven.core.CsvDataProvider;
import com.job.JobSearchMaven.core.web.pages.dice.DiceAdvancedSearchResultsPage;
import com.job.JobSearchMaven.core.web.pages.dice.DiceDashboardPage;

public class DiceSearchTest extends BaseTest{

	@Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
	public void doDiceSearchTest(Map<String, String> testData) {
		System.out.println("Dice search started");
		DiceAdvancedSearchResultsPage resultsPage = new DiceDashboardPage(driver)
			.loadAsAnonymousUser()
			.loginAs(testData.get("Username"), testData.get("Password"))
			.goToDiceAdvancedSearchPage()
			.fillInForm(
					testData.get("Keywords"),
					testData.get("ExcludedKeywords"),
					testData.get("Location"))
			.submitSearch();
		assertThat("JobsPage loaded with results", resultsPage.getJobsPageHeaderText(), containsString("jobs in " + testData.get("Location")));
		//try{Thread.sleep(50000);}catch(Exception e){};
		System.out.println("Dice search finished");	
	}	
}
