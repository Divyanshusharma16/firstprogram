/**
 * 
 */
package com.rms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Susheel.Kumar
 *
 */


@Entity
@Table(name= "mstpatientdetails")
public class MstPatientDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="PATIENTNAME")
	private String patientName;
	@Column(name="CLIENTID")
	private String clientId;
	@Column(name="ACCOUNTNO")
	private String accountNo ;
	@Column(name="PATID")
	private String patId;
	@Column(name="PATIENTHOMENO")
	private String patientHomeNo;
	@Column(name="PATIENTCELLNO")
	private String patientCellNo;
	@Column(name="PATIENTGEN")
	private String patientGen;
	@Column(name="PATIENTEMAIL")
	private String patientEmail ;
	
	
	 @Column(name = "CHECKOUTTIME", columnDefinition = "DATETIME")
	 private String checkOutTime;
	
	
	 @Column(name = "APPTDATE", columnDefinition = "DATETIME")
	private String apptDate ;
	
	@Column(name="PATIENTID")
	private String patientId ;
	
	
	
	
	
	@Column(name="REMINDMESTATUS")
	private String remindmeStatus ;
	
	@Column(name="COUNT")
	private int patientCount ;
	
	@Column(name = "REMINDERDATE", columnDefinition = "DATETIME")
	private String remindMeDate ;
	
	@Column(name="SURVEYURL")
	private String surveyURL ;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getPatId() {
		return patId;
	}
	public void setPatId(String patId) {
		this.patId = patId;
	}
	public String getPatientHomeNo() {
		return patientHomeNo;
	}
	public void setPatientHomeNo(String patientHomeNo) {
		this.patientHomeNo = patientHomeNo;
	}
	public String getPatientCellNo() {
		return patientCellNo;
	}
	public void setPatientCellNo(String patientCellNo) {
		this.patientCellNo = patientCellNo;
	}
	public String getPatientGen() {
		return patientGen;
	}
	public void setPatientGen(String patientGen) {
		this.patientGen = patientGen;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	
	public String getApptDate() {
		return apptDate;
	}
	public void setApptDate(String apptDate) {
		this.apptDate = apptDate;
	}
	
	
	public String getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getRemindmeStatus() {
		return remindmeStatus;
	}
	public void setRemindmeStatus(String remindmeStatus) {
		this.remindmeStatus = remindmeStatus;
	}
	public int getPatientCount() {
		return patientCount;
	}
	public void setPatientCount(int patientCount) {
		this.patientCount = patientCount;
	}
	public String getRemindMeDate() {
		return remindMeDate;
	}
	public void setRemindMeDate(String remindMeDate) {
		this.remindMeDate = remindMeDate;
	}
	public String getSurveyURL() {
		return surveyURL;
	}
	public void setSurveyURL(String surveyURL) {
		this.surveyURL = surveyURL;
	}
	
	
	
	
	
	
	
	
	
	
}
