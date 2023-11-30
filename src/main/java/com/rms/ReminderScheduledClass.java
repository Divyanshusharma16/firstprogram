package com.rms;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rms.controller.EMRPatientDataController;
import com.rms.controller.RmsUserController;
import com.rms.serviceImpl.EMRServiceImpl;



@Component
 
public class ReminderScheduledClass {
	
	@Autowired
	EMRPatientDataController eMRPatientDataController;
	@Autowired
	RmsUserController rmsUserController;
	@Autowired
	EMRServiceImpl eMRServiceImpl;

	@Scheduled(fixedDelay = 100000000)
	 public void reminderCronJob() throws Exception {
		 Date date = new Date();  
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");  
		  String strDate= formatter.format(date);  
		  System.out.println("Method executed at every 10 seconds. Current time is :: "+ strDate);		  
		  String apptDate="2019-05-13 00:00:00";
		  
		  eMRServiceImpl.sendReminderSmsAndEmailToUser(apptDate);
		  
	    }
	
	
	
	
	
}
