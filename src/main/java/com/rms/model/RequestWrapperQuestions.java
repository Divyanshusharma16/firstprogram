package com.rms.model;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class RequestWrapperQuestions {

	
	
	
	public int getQuestionid() {
		return questionid;
	}


	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getQuestionTypeFlag() {
		return questionTypeFlag;
	}


	public void setQuestionTypeFlag(String questionTypeFlag) {
		this.questionTypeFlag = questionTypeFlag;
	}


	public String getAddedBy() {
		return addedBy;
	}


	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public String getAttendodtime() {
		return attendodtime;
	}


	public void setAttendodtime(String attendodtime) {
		this.attendodtime = attendodtime;
	}


	public String getModifiedTime() {
		return modifiedTime;
	}


	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}


	public String getAnswerType() {
		return answerType;
	}


	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}


	public MstSurveyVO getSurvey() {
		return survey;
	}


	public void setSurvey(MstSurveyVO survey) {
		this.survey = survey;
	}


	public List<AnswerVo> getAnswer() {
		return answer;
	}


	public void setAnswer(List<AnswerVo> answer) {
		this.answer = answer;
	}


	private int questionid;
	
	private String question;

	
	private String questionTypeFlag;

	
	
	private String addedBy;
	
	private String modifiedBy;

	
	private String attendodtime;

	
	private String modifiedTime;
	
	
	private String answerType;
	


	public MstSurveyVO survey;

	
	private List<AnswerVo> answer ;
	

	
	
	
}
