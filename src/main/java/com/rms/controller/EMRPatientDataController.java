package com.rms.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rms.ScheduledClass;
import com.rms.comman.CommonConstants;
import com.rms.model.MstPatientDetails;
import com.rms.model.RequestVO;
import com.rms.model.SmsAndEmailResponseModel;
import com.rms.model.UserLogin;
import com.rms.service.IPatientEMRData;
/**
 * @author Susheel.Kumar
 *
 */

@RestController
@RequestMapping(CommonConstants.MASTER_URL)
@CrossOrigin(origins = "*")
public class EMRPatientDataController {
	@Autowired
	IPatientEMRData PatientEMRData;
	 
	@RequestMapping(value=CommonConstants.GET_PATIENT_DATA_FROM_EMR, method= RequestMethod.POST)
	//public List<MstPatientDetails> getPatHistory(@PathVariable("provider") String provider,@PathVariable("clientId") String clientId,@PathVariable("apptDate") String apptDate
		//	,@PathVariable("flag") String flag	) {
		//@PathVariable("transferType") String transferType
		public List<MstPatientDetails> getPatHistory(@RequestBody RequestVO requestVO){
	    // RequestVO requestVO=new RequestVO();
	     requestVO.setClientId("970");
	     requestVO.setProvider("TR");
	     requestVO.setApptDate("2019-04-30 14:16:38");
	     requestVO.setFlag("E");
	     
		final String URL_PatientData =CommonConstants.URL;
		 
		HttpEntity<RequestVO> httpEntity = new HttpEntity<RequestVO>(requestVO);
		 
		 RestTemplate restTemplate = new RestTemplate();
		 ResponseEntity<List<MstPatientDetails>> response = restTemplate.exchange( URL_PatientData, HttpMethod.POST, httpEntity,
		   new ParameterizedTypeReference<List<MstPatientDetails>>(){});
		 List<MstPatientDetails> historyList = response.getBody();
		  SmsAndEmailResponseModel smsAndEmailResponseModel=new SmsAndEmailResponseModel();		
		return PatientEMRData.getPatHistory(historyList);
		 //https://www.baeldung.com/spring-rest-template-list
        
	}	  	  	
	
     }