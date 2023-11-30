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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author shiva.theja
 *
 */


@Component
//Spring jpa jars.
@Entity
@Table(name= "answers")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerVo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int answerid;
	
	@Column(name="options")
	private String options;
	
	@Column(name="value")
	private int value;

	@Column(name="message")
	private String message;




	/*@OneToOne
    @JoinColumn(name="questionid")
  @JsonIgnore
private MstQuestionsVO question;*/


	//	@JoinColumn(name = "questionid", referencedColumnName = "QUESTIONID")
	//	@ManyToOne(optional=false)

	/* @ManyToOne (fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "questionid", nullable = false,updatable = false, insertable = false)*/

	//@ManyToOne (fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne
	@JoinColumn(name = "questionid", nullable = false)
	@JsonIgnore
	private MstQuestionsVO mstQuestionsVO;















	/**
	 * @return the mstQuestionsVO
	 */
	public MstQuestionsVO getMstQuestionsVO() {
		return mstQuestionsVO;
	}




	/**
	 * @param mstQuestionsVO the mstQuestionsVO to set
	 */
	public void setMstQuestionsVO(MstQuestionsVO mstQuestionsVO) {
		this.mstQuestionsVO = mstQuestionsVO;
	}














	/**
	 * @return the answerid
	 */
	public int getAnswerid() {
		return answerid;
	}




	/**
	 * @param answerid the answerid to set
	 */
	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}




	/**
	 * @return the options
	 */
	public String getOptions() {
		return options;
	}




	/**
	 * @param options the options to set
	 */
	public void setOptions(String options) {
		this.options = options;
	}








	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}




	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}




	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}




	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}




	public AnswerVo() {


	}

}
