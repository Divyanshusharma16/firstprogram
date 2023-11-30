package com.rms.controller;



import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rms.comman.CommonConstants;
import com.rms.dao.AdminCronJobRepository;
import com.rms.dao.EMRDataRepository;
import com.rms.dao.MstQuestionDataRepository;
import com.rms.dao.SurveyDataRepository;
import com.rms.dao.UserServeyDetailsRepository;
import com.rms.model.AdminCronJobModel;
import com.rms.model.AnswerVo;
import com.rms.model.DecriptingURLModel;
import com.rms.model.MstPatientDetails;
import com.rms.model.MstQuestionsVO;
import com.rms.model.MstSurveyVO;
import com.rms.model.PublishSurveyModel;
import com.rms.model.ReminderAndFrequencyModel;
import com.rms.model.RequestVO;
import com.rms.model.RequestWrapperQuestions;
import com.rms.model.SurveyDiscardModel;
import com.rms.model.UrlAgainstThreshHoldModel;
import com.rms.model.UserAnswerList;
import com.rms.model.UserLogin;
import com.rms.model.UserServeyDetailsModel;
import com.rms.service.IDecriptingURL;
import com.rms.service.IPatientEMRData;
import com.rms.service.IReminderAndFrequency;
import com.rms.service.IUserServeyDetalis;
import com.rms.service.IUserService;
import com.rms.service.ImstQuestionsService;


/**
 * @author Susheel.Kumar
 *
 */
@RestController

@RequestMapping(CommonConstants.MASTER_URL)
@CrossOrigin(origins = "*")
public class RmsUserController {

	@Autowired
	IUserService service;
	
	
	
	@Autowired
	IPatientEMRData PatientEMRData;
	@Autowired
	IUserServeyDetalis iUserServeyDetalis;
	
	@Autowired
	ImstQuestionsService imstQuestionsService;
	@Autowired
	MstQuestionDataRepository MstQuestionDataRepository;
	
	@Autowired
	SurveyDataRepository surveyDataRepository;
	
	@Autowired
	IReminderAndFrequency iReminderAndFrequency;
	
	@Autowired
	UserServeyDetailsRepository userServeyDetailsRepository;
	
	
	@Autowired
	EMRDataRepository eMRDataRepository;
	
	@Autowired
	AdminCronJobRepository adminCronJobRepository;
	@Autowired
	IDecriptingURL iDecriptingURL;
	
	
	@RequestMapping(value=CommonConstants.LOGIN_REGISTRATION, method= RequestMethod.POST)
	public UserLogin createUserLogin(@RequestBody UserLogin userLogin) {
		return service.createUserLogin(userLogin);
	}
		
	/*@RequestMapping(value=CommonConstants.GET_FACILITY, method= RequestMethod.GET)
	public List<FacilityVO> getFacility() {
		return iFacilityService.getFacility();
	}*/

	
	@RequestMapping(value=CommonConstants.GET_LOGIN, method= RequestMethod.POST)
	public List<UserLogin> findByusernameAnduserpassword(@RequestBody UserLogin userLogin) throws Exception{
		return service.findByusernameAnduserpassword(userLogin);
	}
	

	/*@RequestMapping(value= CommonConstants.SEND_SMS, method= RequestMethod.POST)
	public boolean sendSmsToUser( @RequestBody SendSmsAndSendEmailVO sendSmsAndSendEmailVO) {
		return service.sendSmsToUser(sendSmsAndSendEmailVO);
	}*/
	//@RequestBody MstPatientDetails mstPatientDetails
	@RequestMapping(value= CommonConstants.SEND_SMS_AND_EMAIL, method= RequestMethod.POST)
	public List<MstPatientDetails> sendSmsAndEmailToUser(@PathVariable("checkOutTime") String checkOutTime )throws Exception {
		MstPatientDetails mstPatientDetails=new MstPatientDetails();
		mstPatientDetails.setCheckOutTime(checkOutTime);
		return PatientEMRData.sendSmsAndEmailToUser(mstPatientDetails);
	}
	
	

	@RequestMapping(value=CommonConstants.USER_SURVEY_DETAILS, method= RequestMethod.POST)
	public  UrlAgainstThreshHoldModel userServeyDetail(@RequestBody UserServeyDetailsModel userServeyDetailsModel) {
		return  iUserServeyDetalis.userServeyDetail(userServeyDetailsModel);
	}
	
	
	
	
	/*@RequestMapping(value=CommonConstants.USER_SURVEY_REPORT, method= RequestMethod.POST)
	public UserServeyDetailsModel userServeyReport(@RequestBody UserServeyDetailsModel userServeyDetailsModel) {
		return iUserServeyDetalis.userServeyReport(userServeyDetailsModel);
	}*/
	
	

	@RequestMapping(value=CommonConstants.SAVE_REMINDER_AND_FREQUENCY, method= RequestMethod.POST)
	public void  saveReminderAndFrequency(@RequestBody ReminderAndFrequencyModel reminderAndFrequencyModel) {
		 iReminderAndFrequency.saveReminderAndFrequency(reminderAndFrequencyModel);
		  
				
	}
	
	
	
	@RequestMapping(value=CommonConstants.GET_REMINDER_AND_FREQUENCY, method= RequestMethod.GET)
	public  List<ReminderAndFrequencyModel>  getReminderAndFrequency() {
		return iReminderAndFrequency.getReminderAndFrequency();
	}
	
	
	
	@RequestMapping(value=CommonConstants.CREATE_QUESTION, method= RequestMethod.POST, produces="application/json", consumes="application/json")
	public MstQuestionsVO createMSTQuestions(@RequestBody RequestWrapperQuestions requestWrapperQuestions) {
	
		MstQuestionsVO mstQuestionsVO = new MstQuestionsVO(requestWrapperQuestions.getQuestion(), requestWrapperQuestions.getQuestionTypeFlag()
				,requestWrapperQuestions.getAnswerType(),  requestWrapperQuestions.getSurvey(), requestWrapperQuestions.getAnswer(),requestWrapperQuestions.getQuestionid());
		
		return imstQuestionsService.createMstQuestions(mstQuestionsVO);
	}

	
	
	@RequestMapping(value=CommonConstants.GET_QUESTION_ANSWERS, method= RequestMethod.GET)
	public MstQuestionsVO getQuestionById(@PathVariable int id) {
		Optional<MstQuestionsVO> questions = MstQuestionDataRepository.findById(id);
		MstQuestionsVO mstQuestionsVO = null;
		if(questions.isPresent())
		{
			 mstQuestionsVO = questions.get();
			List<AnswerVo> answer = mstQuestionsVO.getAnswer();
			if(answer!=null) {
			System.out.println(answer.get(0).getMessage());
			}
		}
		 return mstQuestionsVO;
	}
	
	
	
	
	@RequestMapping(value=CommonConstants.GET_SURVEY, method= RequestMethod.POST)
	//public Optional<MstSurveyVO> getmstSurvey(@PathVariable int surveyid,@PathVariable String userId) {
	public Optional<MstSurveyVO> getmstSurvey(@RequestBody RequestVO requestVO) {
		String userId=requestVO.getUserId();
		int surveyid=requestVO.getSurveyID();
		//Optional<UserServeyDetailsModel> findByUserId  =userServeyDetailsRepository.findByUserId( userId);
		Optional<UserServeyDetailsModel> findByUserIdAndSurveyId  =userServeyDetailsRepository.findByUserIdAndSurveyId(userId,surveyid);
		
	//	if(findByUserId.isPresent())
		if(findByUserIdAndSurveyId.isPresent())
		
		{
			System.out.println("All ready Survey has taken ");
			MstSurveyVO mstSurveyVO = new MstSurveyVO();
			mstSurveyVO.setSurveyid(0);
			Optional<MstSurveyVO> of = Optional.of(mstSurveyVO);
			return of;
		
		}
		Optional<MstSurveyVO> findById = surveyDataRepository.findById(surveyid);
		if(findById.isPresent())
		{
		MstSurveyVO mstSurveyVO = findById.get();
			List<MstQuestionsVO> collect = mstSurveyVO.getQuestion().stream().distinct().collect(Collectors.toList());
			mstSurveyVO.setQuestion(collect);
			
			System.out.println("Simple Message");
		}
		
		return findById;
		
	        
	}
	
	
	
	
	/*
	@RequestMapping(value=CommonConstants.GET_SURVEY, method= RequestMethod.GET)
	public Optional<MstSurveyVO> getmstSurvey(@PathVariable int surveyid) {
		Optional<MstSurveyVO> findById = surveyDataRepository.findById(surveyid);
		if(findById.isPresent())
		{
			MstSurveyVO mstSurveyVO = findById.get();
			List<MstQuestionsVO> collect = mstSurveyVO.getQuestion().stream().distinct().collect(Collectors.toList());
			mstSurveyVO.setQuestion(collect);
			
		}
		 return findById;
	}
	*/
	/*
	@RequestMapping(value=CommonConstants.GET_SURVEY, method= RequestMethod.GET)
	public Optional<MstSurveyVO> getmstSurvey(@PathVariable int surveyid) {
		Optional<MstSurveyVO> findById = surveyDataRepository.findById(surveyid);
		if(findById.isPresent())
		{
			MstSurveyVO mstSurveyVO = findById.get();
			List<MstQuestionsVO> question = (List<MstQuestionsVO>) mstSurveyVO.getQuestion();
			if(question!=null) {
				MstQuestionsVO mstQuestionsVO = question.get(0);
				List<AnswerVo> answer = mstQuestionsVO.getAnswer();
				System.out.println(answer);
				
				}
		}
		 return surveyDataRepository.findById(surveyid);
	}*/
	
	
	/*@RequestMapping(value=CommonConstants.GET_SURVEY, method= RequestMethod.GET)
	public List<MstSurveyVO> getmstSurvey() {
		System.out.println("HELLLLLLLLLLLLLLLLLLLLLLL");
		//Optional<MstSurveyVO> findById = surveyDataRepository.findById(id);
		List<MstSurveyVO> findById = surveyDataRepository.findTop1ByOrderBySurveyidDesc();
		if(findById.isPresent())
		{
			MstSurveyVO mstSurveyVO = new MstSurveyVO();
			List<MstQuestionsVO> question = mstSurveyVO.getQuestion();
			if(question!=null) {
				MstQuestionsVO mstQuestionsVO = question.get(0);
				List<AnswerVo> answer = mstQuestionsVO.getAnswer();
				System.out.println(answer);
				
				}
		
		 return surveyDataRepository.findTop1ByOrderBySurveyidDesc();
	}
	*/
	
	
	@RequestMapping(value=CommonConstants.CREATE_SURVEY, method= RequestMethod.POST)
	public MstSurveyVO createSurvey(@RequestBody MstSurveyVO mstSurveyVO) {
		  if(mstSurveyVO.getSurveyid()!=0) {
			  mstSurveyVO.setSurveyStatus("unpublished");
			  surveyDataRepository.save(mstSurveyVO);	    
		  }
		  mstSurveyVO.setSurveyStatus("unpublished");
		return surveyDataRepository.save(mstSurveyVO);
		
	} 
	
	
	
	
	 /*@RequestMapping(value=CommonConstants.GET_ALLSURVEYDESC, method= RequestMethod.GET)
		public MstSurveyVO getAllSurveyInDescenderOrder() {
		  MstSurveyVO surveyVO = new MstSurveyVO();
		  MstSurveyVO survey = new MstSurveyVO();
		  SurveyResponseVO surveyResponseVO =new SurveyResponseVO("No Unplished Survey !!");
		  survey.setSurveyStatus("unpublished");
		  System.out.println("Example entity: "+survey);
		  ExampleMatcher example = ExampleMatcher.matchingAll()
               .withIgnorePaths("id")
               .withIncludeNullValues();
		  Example<MstSurveyVO> example = Example.of(survey, ExampleMatcher.matching());
		
		  Optional<MstSurveyVO> empty = Optional.empty();
		  
		
		  List<MstSurveyVO> surveyList = surveyDataRepository.findAll( example,Sort.by("surveyid").descending());	
			return surveyList.isEmpty()==true ?surveyVO:surveyList.get(0);
		
		}*/
	
	 @RequestMapping(value=CommonConstants.GET_ALLSURVEYDESC, method= RequestMethod.GET)
		public  Optional<MstSurveyVO> getAllSurveyInDescenderOrder() {
	 /* MstSurveyVO survey = new MstSurveyVO();
	  survey.setSurveyStatus("unpublished");
	  System.out.println("Example entity: "+survey);
	  ExampleMatcher example = ExampleMatcher.matchingAll()
              .withIgnorePaths("id")
              .withIncludeNullValues();
	  Example<MstSurveyVO> example = Example.of(survey, ExampleMatcher.matchingAny());
	  List<MstSurveyVO> surveyList = surveyDataRepository.findAll( example,Sort.by("surveyid").descending());
            return surveyList.get(0);*/
		
		 Optional<MstSurveyVO> findTop1BySurveyStatusOrderBySurveyidDesc = surveyDataRepository.findTop1BySurveyStatusOrderBySurveyidDesc("unpublished");
		  
			return findTop1BySurveyStatusOrderBySurveyidDesc;
	}
	
	/*@RequestMapping(value=CommonConstants.GET_ALLSURVEYDESC, method= RequestMethod.GET)
	public MstSurveyVO getAllSurveyInDescenderOrder() {
		
		
		List<MstSurveyVO> surveyList = surveyDataRepository.findAll(Sort.by("surveyid").descending());
		//
		 return surveyList.get(0);
	}
	*/
	
	@RequestMapping(value=CommonConstants.GET_SURVEY_QUESTIONS, method= RequestMethod.GET)
	public Optional<MstSurveyVO>  getmstSurveyquestions(@PathVariable int id) {
		
		 return surveyDataRepository.findById(id);
	}
	
	
	
	 @RequestMapping(value=CommonConstants.PUBLISHED_SURVEY, method= RequestMethod.GET)
		public PublishSurveyModel publishSurvey(@PathVariable int surveyid) {
		 
		    PublishSurveyModel publishSurveyModel =new PublishSurveyModel();
		     boolean status=false;
			MstSurveyVO survey = new MstSurveyVO();
			  survey.setSurveyStatus("published");
			
			
			 Example<MstSurveyVO> employeeExample = Example.of(survey, ExampleMatcher.matchingAny());
			
			  // int surveyid =0;
			   Optional<MstSurveyVO> findOneSurveyOptional = surveyDataRepository.findOne(employeeExample);
			   if(findOneSurveyOptional.isPresent())
			   {
				   MstSurveyVO mstSurveyVO = findOneSurveyOptional.get();
				   mstSurveyVO.setSurveyStatus("unpublishedOld");
				    surveyDataRepository.save(mstSurveyVO);
				    status=true;	
				    publishSurveyModel.setUnpblishStatus("unpublishedSurvey");
			   }
			 	
			   
			  // survey1.setSurveyStatus("published");
			   
			   Optional<MstSurveyVO> findById = surveyDataRepository.findById(Integer.valueOf(surveyid));
			      
			      if(findById.isPresent())
			      {
			    	  MstSurveyVO mstSurveyVO = findById.get();
			    	  mstSurveyVO.setSurveyStatus("published");
			    	  surveyDataRepository.save(mstSurveyVO);
			    	  publishSurveyModel.setPublishStatus("publishSurvey");
			      }
				
				
				     return publishSurveyModel;
		}
	
	
	 @RequestMapping(value=CommonConstants.DISCARD_SURVEY, method= RequestMethod.POST)
		public SurveyDiscardModel discardSurvey(@RequestBody RequestVO requestVO) {
		  int  update_flag=0;
		 SurveyDiscardModel surveyDiscardModel=new SurveyDiscardModel();
		 update_flag= surveyDataRepository.discardSurvey(requestVO.getSurveyId());
		  boolean status=true;
		 surveyDiscardModel.setDiscardSurvey(true); 
		 return surveyDiscardModel;
		}
	 
	 @RequestMapping(value=CommonConstants.UPDATE_REMINDEME_AND_NOTINTERSTED_STATUS, method= RequestMethod.POST)
		public void updateRemindMeAndNotInterstedStatus(@RequestBody RequestVO requestVO) {
			    PatientEMRData.updateRemindMeAndNotInterstedStatus(requestVO);
		}
		
	
	
	 
	 
	 
	 
	 
	 /*
	 @RequestMapping(value=CommonConstants.SURVEY_REPORT, method= RequestMethod.POST)
		public List<UserServeyDetailsModel> surveyReport(@RequestBody RequestVO requestVO) {
		  List<UserServeyDetailsModel> findAll = userServeyDetailsRepository.findByDateBetween(requestVO.getStartDate(), requestVO.getEndDate());
		  
		  List<MstPatientDetails> findAll2 = eMRDataRepository.findAll();
	 Map<String, MstPatientDetails> collect = findAll2.stream()
			      .collect(Collectors.toMap(MstPatientDetails::getPatientId, patient -> patient, (oldK, newK) -> oldK));
	Consumer<UserServeyDetailsModel> consumer=(us->us.setpDetails(collect.get(us.getUserId()))); 
	
	 findAll.stream().forEach(consumer);
	 
	 
	 
		  return findAll;
	 //return null;
		}
		*/
	 
	 @RequestMapping(value=CommonConstants.SURVEY_REPORT, method= RequestMethod.POST)
		public List<UserServeyDetailsModel> surveyReport(@RequestBody RequestVO requestVO) {
		  List<UserServeyDetailsModel> findAllSurveyTaken = userServeyDetailsRepository.findByDateBetween(requestVO.getStartDate(), requestVO.getEndDate());
		 // List<MstSurveyVO> findAll1 =surveyDataRepository.findBySurveyId(requestVO.getSurveyID());
		  
		  
		  List<MstPatientDetails> findAllPatients = eMRDataRepository.findAll();
	 Map<String, MstPatientDetails> collectByPatientIdAndDetail = findAllPatients.stream()
			  .collect(Collectors
					   .toMap( MstPatientDetails::getPatientId, 
							   patient -> patient, 
							   (oldK, newK) -> oldK));
	Consumer<UserServeyDetailsModel> consumer=
			(us->us.setpDetails(collectByPatientIdAndDetail.get(us.getUserId()))); 
	
	findAllSurveyTaken.stream().forEach(consumer);
	
for (UserServeyDetailsModel surveyTaken : findAllSurveyTaken) {
	
	List<UserAnswerList> answerList = surveyTaken.getAnswerList();
	if(!answerList.isEmpty())
	{
 int threshHold = answerList.get(0).getMstQuestionsVO().getSurvey().getThreshold();
		String surveyName = answerList.get(0).getMstQuestionsVO().getSurvey().getSurveyname();
		surveyTaken.setDetails(threshHold, surveyName);
	}
	
	
}	
		  return findAllSurveyTaken;
	
		}
		
	 
	 
	 
	 
	 
	 @RequestMapping(value=CommonConstants.CRON_JOB_DAY_WEEK, method= RequestMethod.POST)
		public void cronJobStatus(@RequestBody RequestVO requestVO) {
		 adminCronJobRepository.cronJobStatus(requestVO.getCronJobStatus());
		
		}
	 
	 
	 @RequestMapping(value=CommonConstants.CRON_JOB_DAY_WEEK_STATUS, method= RequestMethod.GET)
		public List<AdminCronJobModel> getCronJobStatus() {
		 List<AdminCronJobModel> list =adminCronJobRepository.findAll();
		return list;
		}
	 
	 @RequestMapping(value=CommonConstants.DECRIPTING_URL, method= RequestMethod.POST)
		public List<DecriptingURLModel> decriptingUrl(@RequestBody RequestVO requestVO) throws Exception{
		 List<DecriptingURLModel> list =iDecriptingURL.decriptingUrl(requestVO);
		return list;
		}
	}
	
	
	
	
	
	
	
