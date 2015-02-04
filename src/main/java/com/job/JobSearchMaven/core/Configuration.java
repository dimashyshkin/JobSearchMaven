package com.job.JobSearchMaven.core;

public class Configuration {
	
	private static final Environments ALL_ENVIRONMENTS;
	static {
		YamlParser parser = new YamlParser("environment.yml");
		ALL_ENVIRONMENTS = parser.parseAs(Environments.class);
	}
	private static Environment GLOBAL_ENVIRONMENT;
	
	private Configuration(){}
	
	public static void setGlobalEnvironment(String environmentKey) {
		GLOBAL_ENVIRONMENT = ALL_ENVIRONMENTS.environments.get(environmentKey);
	}
	
	public Environment getEnvironmentSettings() {
		return GLOBAL_ENVIRONMENT;
	}
	
	
	
}
