package com.job.JobSearchMaven.core.web.pages.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Button;
import com.job.JobSearchMaven.core.web.elements.TextInput;

public class LinkedInLoginPage extends WebPage<LinkedInLoginPage>{
	
	private static final String PAGE_URL = "https://www.linkedin.com/";

	public LinkedInLoginPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public LinkedInLoginPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getEmailInput().isAvailable() &&
				getPasswordInput().isAvailable();
	}

	public LinkedInHomePage loginAs(String username, String password){
		getEmailInput().inputText(username);
		getPasswordInput().inputText(password);
		getSignInButton().waitUntilAvailable().click();
		return new LinkedInHomePage(driver).waitUntilAvailable();
	}
	
	private TextInput getEmailInput(){
		return new TextInput(driver, By.xpath("//input[@id='session_key-login']"));
	}
	
	private TextInput getPasswordInput(){
		return new TextInput(driver, By.xpath("//input[@id='session_password-login']"));
	}
	
	private Button getSignInButton(){
		return new Button(driver, By.xpath("//input[@id='signin']"));
	}
	

}