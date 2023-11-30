package com.rms.serviceImpl;




import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.comman.CommonConstants;
import com.rms.dao.EMRDataRepository;
import com.rms.dao.SurveyDataRepository;
import com.rms.dao.UserAnswerListRepository;
import com.rms.dao.UserServeyDetailsRepository;
import com.rms.model.MstSurveyVO;
import com.rms.model.UrlAgainstThreshHoldModel;
import com.rms.model.UserAnswerList;
import com.rms.model.UserServeyDetailsModel;
import com.rms.service.IUserServeyDetalis;
/*
 * @author Susheel.Kumar
 *
 */

@Service
public class UserServeyDetailsImpl implements IUserServeyDetalis{

	@Autowired
	UserServeyDetailsRepository userServeyDetailsRepository;
	@Autowired
	EMRDataRepository eMRDataRepository;
	@Autowired
	UserAnswerListRepository userAnswerListRepository;
	
	@Autowired
	SurveyDataRepository surveyDataRepository;
	
	@Override
	public UrlAgainstThreshHoldModel userServeyDetail(UserServeyDetailsModel userServeyDetailsModel) {
		// TODO Auto-generated method stub
		   
		String URL="";		
		List<UserAnswerList> answer = userServeyDetailsModel.getAnswerList();
		Consumer<UserAnswerList> consumer=(UserAnswerList ans)->ans.setUserServeyDetailsModel(userServeyDetailsModel);
		answer.forEach(consumer);
		userServeyDetailsRepository.save(userServeyDetailsModel);	
		userServeyDetailsRepository.updateUserDate(userServeyDetailsModel.getUserId());
		
     //save finshed		
		
		Optional<MstSurveyVO> survey = surveyDataRepository.findBySurveyid(userServeyDetailsModel.getSurveyId());
		
		int  numberGotByUser=Integer.parseInt(userServeyDetailsModel.getTotalScore().trim());
		boolean status=false;
		UrlAgainstThreshHoldModel urlAgainstThreshHoldModel=new UrlAgainstThreshHoldModel();
          Predicate<MstSurveyVO> predicate = (MstSurveyVO srv) ->numberGotByUser>=srv.getThreshold();
				Optional<MstSurveyVO> filter = survey.filter(predicate);
	  
								
				
				if(filter.isPresent()) {
					status=true;// else than threshold
				urlAgainstThreshHoldModel.setUrlStatus(CommonConstants.KMG_URL);
				}
		        else {
		        	urlAgainstThreshHoldModel.setStatus("ThankYou");//more than threshold
	 
	
		        }
		
			return urlAgainstThreshHoldModel;
		 }
}