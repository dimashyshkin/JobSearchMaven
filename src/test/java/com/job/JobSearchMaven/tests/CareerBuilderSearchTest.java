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
		CareerBuilderJobResultsPage resultsPage = new CareerBuilderMyCareerBuilderPage(driver)
			.loadAsAnonymousUser()
			.loginAs(testData.get("Username"), testData.get("Password"))
			.goToCareerBuilderHomePage()
			.goToCareerBuilderAdvancedSearchPage()
			.fillInForm(
					testData.get("Keywords"),
					testData.get("ExcludedKeywords"),
					testData.get("Location1"),
					testData.get("Location2"),
					testData.get("Location3"))
			.submitSearch();
		assertThat("JobsPage loaded with results", resultsPage.getJobsPageHeaderText(), containsString(testData.get("Keywords") + " Jobs in " + testData.get("Location")));
		//try{Thread.sleep(50000);}catch(Exception e){};
			
	}	
}