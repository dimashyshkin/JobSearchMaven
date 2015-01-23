package com.job.JobSearchMaven.core.web;

public abstract class Component<T extends Component<T>> {

	public abstract boolean isAvailable();
	
	public T waitUntilAvailable(){
		return new Wait<T>().forComponent((T) this).toBeAvailable();
	}
	
	
}
