package com.job.JobSearchMaven.core.web.pages.dice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Button;
import com.job.JobSearchMaven.core.web.elements.TextInput;

public class DiceLoginPage extends WebPage<DiceLoginPage>{
	
	//private static final String PAGE_URL = BASE_URL + "/dashboard/login";
	private static final String PAGE_URL = "http://dice.com/dashboard/login";

	public DiceLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public DiceLoginPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getUsernameInput().isAvailable() &&
				getPasswordInput().isAvailable() &&
				getLoginButton().isAvailable();
	}

	public DiceDashboardPage loginAs(String username, String password){
		getUsernameInput().inputText(username);
		getPasswordInput().inputText(password);
		getLoginButton().click();
		return new DiceDashboardPage(driver).waitUntilAvailable();
	}
	
	private TextInput getUsernameInput(){
		return new TextInput(driver, By.xpath("//input[@id='email']"));
	}
	
	private TextInput getPasswordInput(){
		return new TextInput(driver, By.xpath("//input[@id='password']"));
	}
	
	private Button getLoginButton(){
		return new Button(driver, By.xpath("//button[@class='btn btn-primary btn-lg']"));
	}
	

}
