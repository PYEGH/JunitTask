package com.epam.junit;

import org.apache.log4j.Logger;

public class LoggerWrapper {
	private final Logger log;
	private String testMessage;
	
	public LoggerWrapper(final String testMessage){
		this.testMessage = testMessage;
		this.log = Logger.getLogger(LoggerWrapper.class);
		log.info(testMessage);
	}

	public Logger getLog() {
		log.info(testMessage);
		return log;
	}
	
	
}
