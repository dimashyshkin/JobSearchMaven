package com.job.JobSearchMaven.core.web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.job.JobSearchMaven.core.web.WebComponent;

public class Dropdown extends WebComponent<Dropdown>{

	public Dropdown(WebDriver driver, By findByMethod) {
		super(driver, findByMethod);
	}
	
	public Dropdown open(String text){
		getWebElement().sendKeys(text);
		return this;
	}
	
	public Dropdown select(){
		getWebElement().clear();
		return this;
	}
}
