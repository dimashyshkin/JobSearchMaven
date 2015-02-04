package com.job.JobSearchMaven.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

public class YamlParser {
	
	private static final String CONGIG_FILE_ROOT_PATH = "config/";
	private final String fileName;

	public YamlParser(String fileName) {
		this.fileName = fileName;
	}
	
	public <T> T parseAs(Class<T> type) {
		T object;
		try {
			InputStream input = new FileInputStream(new File(CONGIG_FILE_ROOT_PATH + fileName));
			Yaml yaml = new Yaml();
			object = yaml.loadAs(input, type);
		} catch (IOException e) {
			throw new RuntimeException("Could not load " + CONGIG_FILE_ROOT_PATH + fileName + " file.");
		}
		return object;
	}
	
}
