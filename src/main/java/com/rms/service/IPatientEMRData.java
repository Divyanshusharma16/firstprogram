package com.rms.service;


import java.io.IOException;
import java.util.List;



import org.springframework.stereotype.Service;

import com.rms.model.MstPatientDetails;
import com.rms.model.RequestVO;

/**
 * @author Susheel.Kumar
 *
 */
@Service
public interface IPatientEMRData {

	
	public  List<MstPatientDetails> getPatHistory(List<MstPatientDetails> historyList);
    public List<MstPatientDetails> sendSmsAndEmailToUser(MstPatientDetails mstPatientDetails) throws Exception;
	public void updateRemindMeAndNotInterstedStatus(RequestVO requestVO);

	
}
	
	

