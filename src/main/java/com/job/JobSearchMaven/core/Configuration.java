package com.job.JobSearchMaven.core;

public class Configuration {
	
	private static final Environments ALL_ENVIRONMENTS;
	static {
		YamlParser parser = new YamlParser("environment.yml");
		ALL_ENVIRONMENTS = parser.parseAs(Environments.class);
	}
	private static Environment GLOBAL_ENVIRONMENT;
	private static Configuration config;
	
	private Configuration(){}
	
	public static Configuration getConfig(){
		if (config == null) {
			config = new Configuration();
			return config;
		}
		return config;
	}
	
	public static void setGlobalEnvironment(String environmentKey) {
		//GLOBAL_ENVIRONMENT = ALL_ENVIRONMENTS.environments.get(environmentKey);
		GLOBAL_ENVIRONMENT = ALL_ENVIRONMENTS.environments.get(environmentKey);
	}
	
	public Environment getEnvironmentSettings() {
		return GLOBAL_ENVIRONMENT;
	}
	
	
	
}
