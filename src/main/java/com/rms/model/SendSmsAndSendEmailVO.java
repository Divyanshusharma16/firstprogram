package com.rms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;


/**
 * @author Susheel.Kumar
 *
 */


@Component
@Entity
@Table(name= "mstpatientdetails")
@DynamicInsert
@DynamicUpdate
public class SendSmsAndSendEmailVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="PATIENTCELLNO")	
   private String patientCellNo;
	
	
	public SendSmsAndSendEmailVO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getPatientCellNo() {
		return patientCellNo;
	}

	public void setPatientCellNo(String patientCellNo) {
		this.patientCellNo = patientCellNo;
	}




	
	
	
	public SendSmsAndSendEmailVO(String patientCellNo) {
		super();
		this.patientCellNo = patientCellNo;
	}

	
	


	
	
	
	
	
	

	
	
	
	
	
	



}
	 