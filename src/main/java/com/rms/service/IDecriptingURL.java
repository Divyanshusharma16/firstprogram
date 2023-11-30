package com.rms.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.rms.model.DecriptingURLModel;
import com.rms.model.MstPatientDetails;
import com.rms.model.RequestVO;
import com.rms.model.UserServeyDetailsModel;

/**
 * @author Susheel.Kumar
 *
 */
@Service
public interface IDecriptingURL {

	List<DecriptingURLModel> decriptingUrl(RequestVO requestVO) throws Exception;

	
	
	
	

	
}
	
	

