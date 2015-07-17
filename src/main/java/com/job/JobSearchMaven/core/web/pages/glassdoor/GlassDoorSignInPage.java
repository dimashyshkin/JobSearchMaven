package com.job.JobSearchMaven.core.web.pages.glassdoor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebPage;
import com.job.JobSearchMaven.core.web.elements.Button;
import com.job.JobSearchMaven.core.web.elements.TextInput;

public class GlassDoorSignInPage extends WebPage<GlassDoorSignInPage> {

	public GlassDoorSignInPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isAvailable() {
		return getEmailInput().isAvailable()
				&& getPasswordInput().isAvailable()
				&& getSignInButton().isAvailable();
	}

	public GlassDoorIndexPage loginAs(String username, String password) {
		getEmailInput().inputText(username);
		getPasswordInput().inputText(password);
		getSignInButton().click();
		return new GlassDoorIndexPage(driver).waitUntilAvailable();
	}

	private TextInput getEmailInput() {
		return new TextInput(driver,
				By.xpath("//div[@id='LoginModulePopup']//input[@class='signin-email std med']"));
	}

	private TextInput getPasswordInput() {
		return new TextInput(driver,
				By.xpath("//div[@id='LoginModulePopup']//input[@class='signin-password std med']"));
	}

	private Button getSignInButton() {
		return new Button(driver, By.xpath("//div[@id='LoginModulePopup']//button[@id='signInBtn']"));
	}

	@Override
	public GlassDoorSignInPage load() {
		return null;
	}

}
