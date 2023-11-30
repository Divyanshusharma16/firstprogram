package com.rms.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;



/**
 * @author Susheel.Kumar
 *
 */

@Component
@Entity
@Table(name= "usersurveydetails")//Parient
@DynamicInsert
@DynamicUpdate

public class UserServeyDetailsModel {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="SEQNO")	
  private int seqNo;
 
  @Column(name="USERID")
  private String userId;
  
  @Column(name="TOTALSCORE")
  private String totalScore;
  
  @Column(name="SURVEYID")
  private int surveyId;
  
  @Column(name = "DATE", columnDefinition = "DATETIME")
  private String date ;
  
  
  @Transient
  private MstPatientDetails pDetails;
  
  @Transient
  private int threshHold;
    @Transient
  private String surveyName;
  
 
  @OneToMany(mappedBy="userServeyDetailsModel",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
  private List<UserAnswerList> answerList;
  
  
  
  



public int getSeqNo() {
	return seqNo;
}
public void setSeqNo(int seqNo) {
	this.seqNo = seqNo;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getTotalScore() {
	return totalScore;
}
public void setTotalScore(String totalScore) {
	this.totalScore = totalScore;
}

public int getSurveyId() {
	return surveyId;
}
public void setSurveyId(int surveyId) {
	this.surveyId = surveyId;
}
public List<UserAnswerList> getAnswerList() {
	return answerList;
}
public void setAnswerList(List<UserAnswerList> answerList) {
	this.answerList = answerList;
}




public MstPatientDetails getpDetails() {
	return pDetails;
}
public void setpDetails(MstPatientDetails pDetails) {
	this.pDetails = pDetails;
}


public int getThreshHold() {
	return threshHold;
}
public void setThreshHold(int threshHold) {
	this.threshHold = threshHold;
}
public String getSurveyName() {
	return surveyName;
}
public void setSurveyName(String surveyName) {
	this.surveyName = surveyName;
}


public void  setDetails(int threshHold, String surveyName )
{
	
	this.threshHold=threshHold;
	this.surveyName=surveyName;
}







  
  
  

}
	 