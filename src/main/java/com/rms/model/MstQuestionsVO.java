/**
 * 
 */
package com.rms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author shiva.theja
 *
 */
@Component
@Entity
@Table(name= "MSTQUESTIONS")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MstQuestionsVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionid;
	@Column(name="QUESTION")
	private String question;

	@Column(name="QUESFLAG")
	private String questionTypeFlag;

	
	@Column(name="ADDEDBY")
	private String addedBy;
	@Column(name="MODIFIEDBY")
	private String modifiedBy;

	@Column(name = "ADDEDONDATETIME", columnDefinition = "DATETIME")
	private String attendodtime;

	@Column(name = "MODIFIEDONDATETIME", columnDefinition = "DATETIME")
	private String modifiedTime;
	
	@Column(name="ANSWERTYPE")
	private String answerType;
	


	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne
	@JoinColumn(name="surveyid")
	@JsonIgnore
	public MstSurveyVO survey;

	@OneToMany(mappedBy="mstQuestionsVO",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<AnswerVo> answer ;
	








	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MstQuestionsVO [questionid=" + questionid + ", question=" + question + ", questionTypeFlag="
				+ questionTypeFlag +  ", addedBy=" + addedBy + ", modifiedBy=" + modifiedBy
				+ ", attendodtime=" + attendodtime + ", modifiedTime=" + modifiedTime + ", survey=" + survey
				+ ", answer=" + answer + "]";
	}










	/**
	 * @return the questionid
	 */
	public int getQuestionid() {
		return questionid;
	}










	/**
	 * @param questionid the questionid to set
	 */
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}



	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}



	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}


	/**
	 * @return the questionTypeFlag
	 */
	public String getQuestionTypeFlag() {
		return questionTypeFlag;
	}

	/**
	 * @param questionTypeFlag the questionTypeFlag to set
	 */
	public void setQuestionTypeFlag(String questionTypeFlag) {
		this.questionTypeFlag = questionTypeFlag;
	}




	/**
	 * @return the clientId
	 */
	


	/**
	 * @return the addedBy
	 */
	public String getAddedBy() {
		return addedBy;
	}




	/**
	 * @param addedBy the addedBy to set
	 */
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}


	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}


	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


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



	public String getAnswerType() {
		return answerType;
	}










	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}










	/**
	 * @return the answer
	 */
	public List<AnswerVo> getAnswer() {
		return answer;
	}










	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(List<AnswerVo> answer) {
		this.answer = answer;
	}











































	public MstSurveyVO getSurvey() {
		return survey;
	}










	public void setSurvey(MstSurveyVO survey) {
		this.survey = survey;
	}










	public MstQuestionsVO() {

	}










	public MstQuestionsVO(String question, String questionTypeFlag, String answerType, MstSurveyVO survey,
			List<AnswerVo> answer,int questionid) {
		super();
		this.question = question;
		this.questionTypeFlag = questionTypeFlag;
		this.answerType = answerType;
		this.survey = survey;
		this.answer = answer;
		this.questionid=questionid;
	}
















}
