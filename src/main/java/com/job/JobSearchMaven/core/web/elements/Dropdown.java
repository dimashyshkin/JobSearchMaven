package com.job.JobSearchMaven.core.web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.job.JobSearchMaven.core.web.WebComponent;

public class Dropdown extends WebComponent<Dropdown>{

	public Dropdown(WebDriver driver, By findByMethod) {
		super(driver, findByMethod);
	}
	
	public Dropdown selectByValue(String value){
		Select dropdown = new Select(getWebElement());
		dropdown.selectByValue(value);
		return this;
	}
}
