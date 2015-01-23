package com.job.JobSearchMaven.core.web;

import org.openqa.selenium.TimeoutException;

public class Wait<T extends Component<T>> {

	private static final int DEFAULT_TIMEOUT = 30000;
	private static final int DEFAULT_RETRY_DELAY = 500;
	private T component;
	
	public Wait(){}
	
	public Wait<T> forComponent(T component){
		this.component = component;
		return this;
	}
	
	public T toBeAvailable(){
		int timePassed = 0;
		while (timePassed < DEFAULT_TIMEOUT) {
			if (this.component.isAvailable()) {
				return this.component;
			}
			timePassed = timePassed + delay();
		}
		if (!this.component.isAvailable()) {
			throw new TimeoutException("Timed out after " + DEFAULT_TIMEOUT + "ms. waiting for component to be available.");
		}
		return this.component;
	}
	
	private int delay(){
		try {
			Thread.sleep(DEFAULT_RETRY_DELAY);
			return DEFAULT_RETRY_DELAY;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
