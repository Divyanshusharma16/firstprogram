package com.rms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



/**
 * @author Susheel.Kumar
 *
 */
@SpringBootApplication
@EnableScheduling

public class RmsApplication {

	 
	
	private static final Logger logger = LoggerFactory.getLogger(RmsApplication.class);
	public static void main(String args[]) {
		 logger.info("this is a info message");
	     logger.warn("this is a warn message");
	     logger.error("this is a error message");
	     logger.trace("this is a trace message");
	     logger.debug("this is debug message");
		SpringApplication.run(RmsApplication.class, args);
	}
	
	
}