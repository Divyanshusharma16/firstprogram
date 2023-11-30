package com.rms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author Susheel.Kumar
 *
 */
@Component
@Entity
@Table(name= "mstadmincronjobsetting")
public class AdminCronJobModel {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="CRONJOBSTATUS")
	private String cronJobStatus;
	
	
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCronJobStatus() {
		return cronJobStatus;
	}

	public void setCronJobStatus(String cronJobStatus) {
		this.cronJobStatus = cronJobStatus;
	}
	
	
	
	
	



}
	 