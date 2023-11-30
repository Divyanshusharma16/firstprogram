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



public class SurveyDiscardModel implements Serializable{
	
	private boolean isDiscardSurvey;

	public boolean isDiscardSurvey() {
		return isDiscardSurvey;
	}

	public void setDiscardSurvey(boolean isDiscardSurvey) {
		this.isDiscardSurvey = isDiscardSurvey;
	}

	
	
	
	

}
