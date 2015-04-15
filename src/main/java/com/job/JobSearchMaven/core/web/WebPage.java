package com.job.JobSearchMaven.core.web;

import org.openqa.selenium.WebDriver;
/*
import com.job.JobSearchMaven.core.Configuration;
import com.job.JobSearchMaven.core.Environment;
*/
public abstract class WebPage<T extends WebPage<T>> extends Component<T>{
	/*
	private static final Configuration CONFIG = Configuration.getConfig();
	private static final Environment ENVIRONMENT = CONFIG.getEnvironmentSettings();
	protected static final String BASE_URL = ENVIRONMENT.scheme + "://" + ENVIRONMENT.host;
	*/

	public WebPage(WebDriver driver) {
		super(driver);
	}
	
	public abstract T load();
	
	public T loadAndWaitUntilAvailable(){
		load();
		return waitUntilAvailable();
	}
	
}
