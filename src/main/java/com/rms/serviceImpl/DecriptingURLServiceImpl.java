package com.rms.serviceImpl;




import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rms.model.DecriptingURLModel;
import com.rms.model.RequestVO;
import com.rms.service.IDecriptingURL;
import com.rms.util.DecriptionEncription;

/**
 * @author Susheel.Kumar
 *
 */



@Service
public class DecriptingURLServiceImpl implements IDecriptingURL {
	
	@Autowired
	DecriptionEncription decriptionEncription;

	@Override
	public List<DecriptingURLModel> decriptingUrl(RequestVO requestVO) throws Exception {
		
		List<DecriptingURLModel> loginvoList = new ArrayList<>();
		  DecriptingURLModel  loginvo = new DecriptingURLModel(); 
		
		
		 String uName=decriptionEncription.decryptFromURL(requestVO.getUserName());
		 String uId=decriptionEncription.decryptFromURL(requestVO.getUserId());
		 String surveyid=decriptionEncription.decryptFromURL(requestVO.getsId());
		
	
   	
			byte[] userName = Base64.decodeBase64(uName);
			byte[] userID = Base64.decodeBase64(uId);
			byte[] SurveyID = Base64.decodeBase64(surveyid);
			
	
			loginvo.setUserName(new String(userName));
			loginvo.setUserid(new String(userID));
			loginvo.setSurveyID(new String(SurveyID));
			loginvoList.add(loginvo);
			
			
		
		
		
			return loginvoList;
		
	}
	}

	

		
