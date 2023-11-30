package com.rms.model;


import java.io.Serializable;

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
@Table(name= "mstadmin")

public class ReminderAndFrequencyModel implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="ADMINID")
	private int adminId;
	@Column(name="REMINDER")
	private int reminder;
	@Column(name="FREQUNCY")
	private int frequncy;
	
	
	
	
	
	
	
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getReminder() {
		return reminder;
	}
	public void setReminder(int reminder) {
		this.reminder = reminder;
	}
	public int getFrequncy() {
		return frequncy;
	}
	public void setFrequncy(int frequncy) {
		this.frequncy = frequncy;
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	



}
	 