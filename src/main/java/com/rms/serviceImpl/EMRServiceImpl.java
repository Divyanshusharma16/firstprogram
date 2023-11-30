package com.rms.serviceImpl;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rms.comman.CommonConstants;
import com.rms.dao.AdminRepositroy;
import com.rms.dao.EMRDataRepository;
import com.rms.dao.SurveyDataRepository;
import com.rms.model.MstPatientDetails;
import com.rms.model.MstSurveyVO;
import com.rms.model.ReminderAndFrequencyModel;
import com.rms.model.RequestVO;
import com.rms.service.IPatientEMRData;
import com.rms.util.DecriptionEncription;
import com.rms.util.EmailAndSMSService;
import com.rms.util.UtilityService;
import org.apache.commons.codec.binary.Base64;

/**
 * @author Susheel.Kumar
 *
 */


@Component
@Service
public class EMRServiceImpl implements IPatientEMRData {
@Autowired
EMRDataRepository eMRDataRepository;	
	
@Autowired
EmailAndSMSService emailAndSMSService;
	
@Autowired
DecriptionEncription decriptionEncription;
 
@Autowired
UtilityService utilityService;

@Autowired
SurveyDataRepository surveyDataRepository;

@Autowired
AdminRepositroy adminRepositroy;

/*@Override
	public   List<MstPatientDetails> getPatHistory(List<MstPatientDetails> historyList) {
		// TODO Auto-generated method stub
		return eMRDataRepository.saveAll(historyList);
	}*/

	@Override
	public List<MstPatientDetails> sendSmsAndEmailToUser(MstPatientDetails mstPatientDetails) throws Exception {
		// TODO Auto-generated method stub
		
		  List<MstPatientDetails> patientDetail=eMRDataRepository.findByCheckOutTime("2019-05-02 14:16:38");
		  sendBulkSmsToUser( patientDetail );
		return patientDetail;
		
	}
	
	public void sendBulkSmsToUser(List<MstPatientDetails> patientDetail) throws Exception {
	  for(MstPatientDetails patientDetails:patientDetail){  
		String toNumber=  patientDetails.getPatientCellNo().trim();
		//String fromNumber="+16122236639";
		String fromNumber=CommonConstants.COMMAN_PHONE_NO;

		String	emailTo=patientDetails.getPatientEmail().trim();
		String emailFrom=CommonConstants.COMMAN_EMAIL;
		String appDate=patientDetails.getApptDate();
	    String dateFormate=	utilityService.dateFormate(appDate);
		String userN=patientDetails.getPatientName();
		String userId=patientDetails.getPatientId();
		
		
		  byte[] uName = Base64.encodeBase64(userN.getBytes());
		  byte[] uID = Base64.encodeBase64(userId.getBytes());
		  String userName=decriptionEncription.encryptToSendOverURL(new String(uName));
		  String userID=decriptionEncription.encryptToSendOverURL(new String(uID));
		
		  MstSurveyVO mstSurveyVO=new MstSurveyVO();
		  String surveyID1 = String.valueOf(getSurveyId(mstSurveyVO));
		   byte[] surveyid = Base64.encodeBase64(surveyID1.getBytes());
		 
		  String surveyID =decriptionEncription.encryptToSendOverURL(new String(surveyid));
		
		/*MstSurveyVO mstSurveyVO=new MstSurveyVO();
		String surveyID = String.valueOf(getSurveyId(mstSurveyVO));*/

		
		//String surveyID=decriptionEncription.encryptToSendOverURL(String.valueOf(getSurveyId(mstSurveyVO)));		
		//String link ="http://125.63.66.123:9020/test-design/Urgentcareuser?userName="+userName+"&userID="+userID+"&surveyID="+surveyID;
	//	String link ="http://125.63.66.123:9020/loading/id?username="+userName+"&userid="+userID+"&surveyID="+surveyID;
		
		String remindmeFlag="R";
		//String link1 ="http://125.63.66.123:9020/test-design/Urgentcareuser?userName="+userName+"&userID="+userID+"&remindmeFlag="+remindmeFlag;
		String link =CommonConstants.URL_FOR_USER+userName+"&userid="+userID+"&surveyID="+surveyID;
		//String remindmeFlag="R";
		String link1 =CommonConstants.URL_FOR_USER+userName+"&userid="+userID+"&remindmeFlag="+remindmeFlag;
		String noteInerstedflag="N";
		String link2=CommonConstants.URL_FOR_USER+userName+"&userid="+userID+"&remindmeFlag="+noteInerstedflag;
		
		eMRDataRepository.updateSurveyURL(link,patientDetails.getPatientName());
		String contentToSendEmail=utilityService.readMsgEmail();
				
		/*contentToSendEmail = contentToSendEmail.replace("@LinkLable@", "TakeSurvey");
		contentToSendEmail = contentToSendEmail.replace("@LinkLable1@", "RemindMeLater");
		contentToSendEmail = contentToSendEmail.replace("@LinkLable2@", "Note Interseted");
		contentToSendEmail = contentToSendEmail.replace("@Link@",link);
		emailAndSMSService.sendEmailToUser(emailTo, emailFrom, contentToSendEmail);
		*/
		
		contentToSendEmail = contentToSendEmail.replace("@LinkDate@", dateFormate);
		contentToSendEmail = contentToSendEmail.replace("@LinkName@", userN);
		contentToSendEmail = contentToSendEmail.replace("@LinkLable@", " Take Survey");
		contentToSendEmail = contentToSendEmail.replace("@LinkLable1@", "Remind Me Later");
		contentToSendEmail = contentToSendEmail.replace("@LinkLable2@", "Not Interested");
		contentToSendEmail = contentToSendEmail.replace("@Link@",link);
		contentToSendEmail = contentToSendEmail.replace("@Link1@",link1);
		contentToSendEmail = contentToSendEmail.replace("@Link2@",link2);
		emailAndSMSService.sendEmailToUser(emailTo, emailFrom, contentToSendEmail);
		
	     String contentToSend=utilityService.readSMSMsg();
	     contentToSend = contentToSend.replace("@LinkSMS@",link);
		//String contentToSend ="hi this is twilio tetsting";
	    // emailAndSMSService.sendSmsToUser(toNumber,fromNumber,contentToSend);
	//			
	    }  
		
	}
	@Override
	public List<MstPatientDetails> getPatHistory(List<MstPatientDetails> historyList) {
		// TODO Auto-generated method stub
		return  eMRDataRepository.saveAll(historyList);
	}
	
	
	/*public void getPatHistory(String provider,String clientId,String startDate) {
		RequestVO requestVO =new RequestVO();
		requestVO.setApptDate(startDate);
		requestVO.setProvider(provider);
		requestVO.setClientId(clientId);
		final String URL_PatientData =CommonConstants.URL;
		HttpEntity<RequestVO> httpEntity = new HttpEntity<RequestVO>(requestVO); 
		 RestTemplate restTemplate = new RestTemplate();
		 ResponseEntity<List<MstPatientDetails>> response = restTemplate.exchange( URL_PatientData, HttpMethod.POST, httpEntity,
		 new ParameterizedTypeReference<List<MstPatientDetails>>(){});
		 List<MstPatientDetails> historyList = response.getBody();
		 eMRDataRepository.saveAll(historyList);	*/
	
	
	
private int getSurveyId(MstSurveyVO mstSurveyVO) {
		
		MstSurveyVO survey = new MstSurveyVO();
		  survey.setSurveyStatus("published");
		
		
		 Example<MstSurveyVO> employeeExample = Example.of(survey, ExampleMatcher.matchingAny());
		
		   int surveyid =0;
		   Optional<MstSurveyVO> findOneSurveyOptional = surveyDataRepository.findOne(employeeExample);
		   if(findOneSurveyOptional.isPresent())
		   {
			    surveyid = findOneSurveyOptional.get().getSurveyid();
		   }
		  return surveyid ;				
	}
		  

@Override
public void updateRemindMeAndNotInterstedStatus(RequestVO requestVO) {
	
	if("R".equalsIgnoreCase(requestVO.getRemindMeflag())){
		
		eMRDataRepository.updateRemindMeAndNotInterstedStatus(requestVO.getRemindMeflag(),requestVO.getUserId());
		
		List<ReminderAndFrequencyModel>list=	getReminderCountAndFrequency( );
		  for(ReminderAndFrequencyModel list1:list){
		eMRDataRepository.updateReminderAndFrequencyCount(list1.getReminder(),list1.getFrequncy(),requestVO.getUserId());
		  }
	}
	
	if("N".equalsIgnoreCase(requestVO.getRemindMeflag())){
		
		eMRDataRepository.updateNotInterstedStatus(requestVO.getRemindMeflag(),requestVO.getUserId());
		
	}
	
  if("S".equalsIgnoreCase(requestVO.getRemindMeflag())){
		
		eMRDataRepository.updateSurveyStatus(requestVO.getRemindMeflag(),requestVO.getUserId());
	}
	
}



public void sendReminderSmsAndEmailToUser(String date) throws IOException {
	  
	List<MstPatientDetails> mstPatientDetails=eMRDataRepository.findByRemindmeStatus("R");
	 for(MstPatientDetails patientDetails:mstPatientDetails){
	 if(patientDetails.getRemindmeStatus().equals("R") && patientDetails.getPatientCount()>=1 
			 && patientDetails.getRemindMeDate().equals(date)) {

				String toNumber=  patientDetails.getPatientCellNo().trim();
				String fromNumber="+16122236639"; 
				String	emailTo=patientDetails.getPatientEmail().trim();
				String userName=patientDetails.getPatientName();
				String userID=patientDetails.getPatientId();
				String emailFrom=CommonConstants.COMMAN_EMAIL;
				String surveyUrl1=patientDetails.getSurveyURL();
				
				
				String datef=patientDetails.getApptDate();
			    String dformate =utilityService.dateFormate(datef);
				String remindmeFlag="R";
				String link1 =CommonConstants.URL_FOR_USER+new String(userName)+"&userid="+new String(userID)+"&remindmeFlag="+remindmeFlag;
				String noteInerstedflag="N";
				String link2=CommonConstants.URL_FOR_USER+new String(userName)+"&userID="+new String(userID)+"&remindmeFlag="+noteInerstedflag;
					
				String contentToSendEmail=utilityService.readMsgEmail();
				contentToSendEmail = contentToSendEmail.replace("@LinkName@", userName);
				contentToSendEmail = contentToSendEmail.replace("@LinkDate@",dformate);
				contentToSendEmail = contentToSendEmail.replace("@LinkLable@", "Take Survey");
				contentToSendEmail = contentToSendEmail.replace("@LinkLable1@", "Remind Me Later");
				contentToSendEmail = contentToSendEmail.replace("@LinkLable2@", " Not Interested");
				contentToSendEmail = contentToSendEmail.replace("@Link@",surveyUrl1);
				contentToSendEmail = contentToSendEmail.replace("@Link1@",link1);
				contentToSendEmail = contentToSendEmail.replace("@Link2@",link2);
				
				
				
				
			//	emailAndSMSService.sendSmsToUser(toNumber,fromNumber,surveyUrl1);	
		        emailAndSMSService.sendEmailToUser(emailTo, emailFrom, contentToSendEmail);
		      //update count  
		        
	
		      patientDetails.setPatientCount(patientDetails.getPatientCount()-1);
		    //  ReminderAndFrequencyModel reminderAndFrequencyModel =new ReminderAndFrequencyModel() ;
		 List< ReminderAndFrequencyModel>  list=getReminderCountAndFrequency( );
		             for(ReminderAndFrequencyModel list1:list){
		        int  frequncyCount=list1.getFrequncy();
		         String frequencyDate=UtilityService.getNextDay(frequncyCount);
		             
		        eMRDataRepository. updatedCountAndDate(patientDetails.getPatientCount()
		        		,frequencyDate,patientDetails.getPatientId()) ;
		 
	 }
	 
	
	
	 }
}


	}




public List<ReminderAndFrequencyModel> getReminderCountAndFrequency() {
	
	List<ReminderAndFrequencyModel> list= adminRepositroy.findAll();
	
	return list;
	
}




	
}
	
	

	
	

	
	

	

		
