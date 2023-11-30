
package com.rms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rms.controller.EMRPatientDataController;
import com.rms.controller.RmsUserController;
import com.rms.dao.AdminCronJobRepository;
import com.rms.model.AdminCronJobModel;
import com.rms.serviceImpl.EMRServiceImpl;



@Component
 
public class ScheduledClass {
	
	@Autowired
	EMRPatientDataController eMRPatientDataController;
	@Autowired
	RmsUserController rmsUserController;
	@Autowired
	EMRServiceImpl eMRServiceImpl;
	@Autowired
	AdminCronJobRepository adminCronJobRepository;
	/*@Scheduled(fixedDelay = 1000000000)
	 public void work() throws Exception {
		 Date date = new Date();  
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");  
		  String strDate= formatter.format(date);  
		  System.out.println("Method executed at every 10 seconds. Current time is :: "+ strDate);
		  
		  String provider="TR";
		  String clientId="970";
		  String flag="E"; 
		  String transferType="Bulk";
		//  eMRPatientDataController.getPatHistory(provider,clientId,strDate,flag ) ;
		  String apptDate="2019-05-02 14:16:38";
	    	rmsUserController.sendSmsAndEmailToUser(apptDate);
		  
	    }
	*/

	//@Scheduled(fixedDelay = 1000000000)
	
	//@Scheduled(cron = "${scheduling.job.cron}")
	 public void work() throws Exception {
		 String provider="TR";
		  String clientId="970";
		 
		 Date date = new Date();  
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");  
		  String strDate= formatter.format(date);  
		  System.out.println("Method executed at every 10 seconds. Current time is :: "+ strDate);
		  String apptDate="2019-05-02 14:16:38";
		  List<AdminCronJobModel> list=getCronJobStatus();
		  for(AdminCronJobModel list1:list) {
			  if("D".equalsIgnoreCase(list1.getCronJobStatus())){
			//  eMRPatientDataController.getPatHistory(provider,clientId,"2015-08-06 05:49:34",list1.getCronJobStatus()) ;
				  rmsUserController.sendSmsAndEmailToUser(apptDate);
			  }
			  if("W".equalsIgnoreCase(list1.getCronJobStatus())){
			  // eMRPatientDataController.getPatHistory(provider,clientId,"2015-08-06 05:49:34",list1.getCronJobStatus() ) ;
				  rmsUserController.sendSmsAndEmailToUser(apptDate);
				  
			  }
	
	   
		  
	    }
		  }
	
	
	
	
	
	public List<AdminCronJobModel> getCronJobStatus() {		
		List<AdminCronJobModel> list =adminCronJobRepository.findAll();	
		return list;
	}
	
	
	
	@Scheduled(cron = "${reminder.job.cron}")
	 public void reminderCronJob() throws Exception {
		 Date date = new Date();  
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");  
		  String strDate= formatter.format(date);  
		  System.out.println("Method executed at every 10 seconds. Current time is :: "+ strDate);		  
		  String apptDate="2019-05-25 00:00:00";
		  
		  eMRServiceImpl.sendReminderSmsAndEmailToUser(apptDate);
		  
	    }
	
}
