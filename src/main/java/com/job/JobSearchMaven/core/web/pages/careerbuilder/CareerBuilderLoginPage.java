package com.job.JobSearchMaven.core.web.pages.careerbuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Button;
import com.job.JobSearchMaven.core.web.elements.TextInput;

public class CareerBuilderLoginPage extends WebPage<CareerBuilderLoginPage>{
	
	private static final String PAGE_URL = "http://www.careerbuilder.com/share/login.aspx";

	public CareerBuilderLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public CareerBuilderLoginPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getEmailInput().isAvailable() &&
				getPasswordInput().isAvailable() &&
				getSignInButton().isAvailable();
	}

	public CareerBuilderMyCareerBuilderPage loginAs(String username, String password){
		getEmailInput().inputText(username);
		getPasswordInput().inputText(password);
		getSignInButton().click();
		return new CareerBuilderMyCareerBuilderPage(driver).waitUntilAvailable();
	}
	
	private TextInput getEmailInput(){
		return new TextInput(driver, By.xpath("//input[@id='JobSeekerLoginV3_cbsys_login_email']"));
	}
	
	private TextInput getPasswordInput(){
		return new TextInput(driver, By.xpath("//input[@id='JobSeekerLoginV3_cbsys_login_password']"));
	}
	
	private Button getSignInButton(){
		return new Button(driver, By.xpath("//input[@id='btnsignin']"));
	}
	

}
