/**
 * 
 */
package com.rms.model;

import java.io.Serializable;

/**
 * @author Susheel.Kumar
 *
 */
public class RequestVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String provider;	
	
	private String clientId;
	private String apptDate;
	private String startDate;
	private String remindMeflag;
	private String userName;
	private String flag;
	private String noteInerstedflag;
	private MstSurveyVO survey;
	
	private String statusFlag;
	private String surveyId;
	private String userId;
	private String cronJobStatus;
	private String endDate;
	
	private int surveyID;
	private String sId;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public int getSurveyID() {
		return surveyID;
	}
	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCronJobStatus() {
		return cronJobStatus;
	}
	public void setCronJobStatus(String cronJobStatus) {
		this.cronJobStatus = cronJobStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}
	public String getStatusFlag() {
		return statusFlag;
	}
	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}
	public MstSurveyVO getSurvey() {
		return survey;
	}
	public void setSurvey(MstSurveyVO survey) {
		this.survey = survey;
	}
	public String getNoteInerstedflag() {
		return noteInerstedflag;
	}
	public void setNoteInerstedflag(String noteInerstedflag) {
		this.noteInerstedflag = noteInerstedflag;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getRemindMeflag() {
		return remindMeflag;
	}
	public void setRemindMeflag(String remindMeflag) {
		this.remindMeflag = remindMeflag;
	}
	public String getProvider() {
		return provider;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getApptDate() {
		return apptDate;
	}
	public void setApptDate(String apptDate) {
		this.apptDate = apptDate;
	}
	
	
	
	
	
	
}
