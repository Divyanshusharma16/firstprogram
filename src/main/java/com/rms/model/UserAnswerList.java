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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author shiva.theja
 *
 */


@Component
@Entity
@Table(name= "userquestionfeedback")//Child
public class UserAnswerList implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="QUESTIONID")
	private int questionId;
	
	
	
	
	@OneToOne
	@JoinColumn(name = "QUESTIONID",insertable=false,updatable=false)
	private MstQuestionsVO mstQuestionsVO;	
	
	
	
	
	
	
	
	
	@Column(name="SELECTEDOPTION")
	private String selectedOption;

	@Column(name="SCORE")
	private String score;
		
	@Column(name="SURVEYID")
	private int surveyId;
	

	
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="SEQNO")
	private UserServeyDetailsModel userServeyDetailsModel;

	
	
	
	
	
	
	
	
	
	
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	

	

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public UserServeyDetailsModel getUserServeyDetailsModel() {
		return userServeyDetailsModel;
	}

	public void setUserServeyDetailsModel(UserServeyDetailsModel userServeyDetailsModel) {
		this.userServeyDetailsModel = userServeyDetailsModel;
	}

	public MstQuestionsVO getMstQuestionsVO() {
		return mstQuestionsVO;
	}

	public void setMstQuestionsVO(MstQuestionsVO mstQuestionsVO) {
		this.mstQuestionsVO = mstQuestionsVO;
	}




}
