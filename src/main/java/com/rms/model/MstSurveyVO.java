/**
 * 
 */
package com.rms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author shiva.theja
 *
 */
@Component
@Entity
@Table(name= "mstsurvey")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MstSurveyVO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int surveyid;	
	
	@Column(name="SURVEYNAME")	
	private String surveyname;
	@Column(name="threshold")
	private int threshold;
	@Column(name="totalnoofquestion")
	private int totalnoofquestion;
	@Column(name="ADDEDBY")
	private String addedby;
	
	@Column(name = "ADDEDONDATETIME", columnDefinition = "DATETIME")
	private String attendodtime;

	@Column(name = "MODIFIEDONDATETIME", columnDefinition = "DATETIME")
	private String modifiedTime;
	
	@Column(name="SURVEYSTATUS")
	private String surveyStatus;
	

	//	 @OneToMany(fetch = FetchType.EAGER,mappedBy="employee",cascade = CascadeType.ALL)
	//	@OneToMany(cascade = CascadeType.ALL,   orphanRemoval = true    )
	//	@JoinColumn(name = "post_id")
//	@JoinColumn(name="surveyid")
	
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@OneToMany(mappedBy="survey",fetch=FetchType.EAGER)
	//@Fetch(FetchMode.SELECT)
 	private List<MstQuestionsVO> question;

	





	


	public List<MstQuestionsVO> getQuestion() {
		return question;
	}
	public void setQuestion(List<MstQuestionsVO> question) {
		this.question = question;
	}
	public MstSurveyVO() {

	}
	/**
	 * @return the surveyid
	 */
	public int getSurveyid() {
		return surveyid;
	}
	/**
	 * @param surveyid the surveyid to set
	 */
	public void setSurveyid(int surveyid) {
		this.surveyid = surveyid;
	}

	/**
	 * @return the surveyname
	 */
	public String getSurveyname() {
		return surveyname;
	}
	/**
	 * @param surveyname the surveyname to set
	 */
	public void setSurveyname(String surveyname) {
		this.surveyname = surveyname;
	}
	/**
	 * @return the threshold
	 */
	public int getThreshold() {
		return threshold;
	}
	/**
	 * @param threshold the threshold to set
	 */
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	/**
	 * @return the totalnoofquestion
	 */
	public int getTotalnoofquestion() {
		return totalnoofquestion;
	}
	/**
	 * @param totalnoofquestion the totalnoofquestion to set
	 */
	public void setTotalnoofquestion(int totalnoofquestion) {
		this.totalnoofquestion = totalnoofquestion;
	}
	/**
	 * @return the addedby
	 */
	public String getAddedby() {
		return addedby;
	}
	/**
	 * @param addedby the addedby to set
	 */
	public void setAddedby(String addedby) {
		this.addedby = addedby;
	}
	/**
	 * @return the modifiedby
	 */
	
	/**
	 * @return the attendodtime
	 */
	public String getAttendodtime() {
		return attendodtime;
	}
	/**
	 * @param attendodtime the attendodtime to set
	 */
	public void setAttendodtime(String attendodtime) {
		this.attendodtime = attendodtime;
	}
	/**
	 * @return the modifiedTime
	 */
	public String getModifiedTime() {
		return modifiedTime;
	}
	/**
	 * @param modifiedTime the modifiedTime to set
	 */
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getSurveyStatus() {
		return surveyStatus;
	}
	public void setSurveyStatus(String surveyStatus) {
		this.surveyStatus = surveyStatus;
	}















}
