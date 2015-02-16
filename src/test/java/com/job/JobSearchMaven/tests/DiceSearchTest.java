package com.job.JobSearchMaven.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.*;

import com.job.JobSearchMaven.core.BaseTest;
import com.job.JobSearchMaven.core.web.pages.dice.DiceAdvancedSearchResultsPage;
import com.job.JobSearchMaven.core.web.pages.dice.DiceDashboardPage;

public class DiceSearchTest extends BaseTest{

	@Test
	public void testDiceSearch() {
		DiceAdvancedSearchResultsPage resultsPage = new DiceDashboardPage(driver)
			.loadAsAnonymousUser()
			.loginAs("dimashyshkin@hotmail.com", "dima8439")
			.goToDiceAdvancedSearchPage()
			.fillInForm(
					"qa OR Sqa OR Test",
					"manager OR lead",
					"75093")
			.submitSearch();
		assertThat("JobsPage loaded with results", resultsPage.getJobsPageHeaderText(), containsString("jobs in " + "75093"));
		try{Thread.sleep(50000);}catch(Exception e){};
			
	}	
}
