/**
 * 
 */
package com.rms.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.dao.AnswerRepository;
import com.rms.dao.MstQuestionDataRepository;
import com.rms.model.AnswerVo;
import com.rms.model.MstQuestionsVO;
import com.rms.model.MstSurveyVO;
import com.rms.service.ImstQuestionsService;
import java.util.function.Consumer;

/**
 * @author shiva.theja
 * @param <MstQuestionDataRepository>
 *
 */
@Service
public class MstQuestionsServiceImpl implements ImstQuestionsService {

	
	@Autowired
	MstQuestionDataRepository dao;
	
	@Autowired
	AnswerRepository answerdao;
	
	/*@Override
	public MstQuestionsVO createMstQuestions(MstQuestionsVO mstQuestionsVO) {
		if(mstQuestionsVO.getQuestionTypeFlag().equals("binary")) {
			mstQuestionsVO.setQuestionTypeFlag("binary");	
			mstQuestionsVO.setAddedBy("SYS");
			mstQuestionsVO.setModifiedBy("SYS");
			return dao.save(mstQuestionsVO);
			
		}else if (mstQuestionsVO.getQuestionTypeFlag().equals("range")) {
			mstQuestionsVO.setQuestionTypeFlag("range");
			return dao.save(mstQuestionsVO);
			
		}else {
			mstQuestionsVO.setQuestionTypeFlag("custom");
			return dao.save(mstQuestionsVO);
		}
		
		
	}*/

	
 

    @Override
    public MstQuestionsVO createMstQuestions(MstQuestionsVO mstQuestionsVO) {
    	if(mstQuestionsVO.getQuestionTypeFlag().equals("binary")) {
    	
    		//step 1 survey created
    		MstSurveyVO MstSurveyVO = new MstSurveyVO();
            MstSurveyVO.setSurveyid(mstQuestionsVO.getSurvey().getSurveyid());    		
            mstQuestionsVO.setSurvey(MstSurveyVO);	
            
            //questions created
            mstQuestionsVO.setQuestionTypeFlag(mstQuestionsVO.getQuestionTypeFlag());	
			mstQuestionsVO.setAddedBy("SYS");
			mstQuestionsVO.setModifiedBy("SYS");
			
			//create answer list
			
			List<AnswerVo> answer = mstQuestionsVO.getAnswer();
			Consumer<AnswerVo> consumer=(AnswerVo ans)->ans.setMstQuestionsVO(mstQuestionsVO);
			
			answer.forEach(consumer);
			System.out.println("jai shiva");
			
			
			
	        
              if(mstQuestionsVO.getQuestionid()!=0){
            	  dao.deleteAnswerForParticularQuestion(mstQuestionsVO.getQuestionid()) ;
				dao.save(mstQuestionsVO);
			}
			
              else{
         			
 		         dao.save(mstQuestionsVO);
 		 }
         return mstQuestionsVO;
			
			
		}else if (mstQuestionsVO.getQuestionTypeFlag().equals("range")) {
			mstQuestionsVO.setQuestionTypeFlag("range");
	
			MstSurveyVO MstSurveyVO = new MstSurveyVO();
            MstSurveyVO.setSurveyid(mstQuestionsVO.getSurvey().getSurveyid());    		
            mstQuestionsVO.setSurvey(MstSurveyVO);	
            
            //questions created
            mstQuestionsVO.setQuestionTypeFlag(mstQuestionsVO.getQuestionTypeFlag());	
			mstQuestionsVO.setAddedBy("SYS");
			mstQuestionsVO.setModifiedBy("SYS");
			
			//create answer list
			
			List<AnswerVo> answer = mstQuestionsVO.getAnswer();
			Consumer<AnswerVo> consumer=(AnswerVo ans)->ans.setMstQuestionsVO(mstQuestionsVO);
			
			answer.forEach(consumer);
			System.out.println("jai shiva1");
			
			
              if(mstQuestionsVO.getQuestionid()!=0){
            	  dao.deleteAnswerForParticularQuestion(mstQuestionsVO.getQuestionid()) ;
				dao.save(mstQuestionsVO);
			}
              else{
         			
 		         dao.save(mstQuestionsVO);
 		 }
         return mstQuestionsVO;
			
		}else {
			mstQuestionsVO.setQuestionTypeFlag("custom");

			MstSurveyVO MstSurveyVO = new MstSurveyVO();
            MstSurveyVO.setSurveyid(mstQuestionsVO.getSurvey().getSurveyid());    		
            mstQuestionsVO.setSurvey(MstSurveyVO);	
            
            //questions created
            mstQuestionsVO.setQuestionTypeFlag(mstQuestionsVO.getQuestionTypeFlag());	
			mstQuestionsVO.setAddedBy("SYS");
			mstQuestionsVO.setModifiedBy("SYS");
			
			//create answer list
			
			List<AnswerVo> answer = mstQuestionsVO.getAnswer();
			Consumer<AnswerVo> consumer=(AnswerVo ans)->ans.setMstQuestionsVO(mstQuestionsVO);
			
			answer.forEach(consumer);
			System.out.println("jai shiva2");

			}
			
	
    	   if(mstQuestionsVO.getQuestionid()!=0){
    		  dao.deleteAnswerForParticularQuestion(mstQuestionsVO.getQuestionid()) ;
			dao.save(mstQuestionsVO);
			
    	   }
    	   else{
      			
		         dao.save(mstQuestionsVO);
		 }
      return mstQuestionsVO;
		}
 
    @Override
    public List<MstQuestionsVO> getmstQuestionsVO(int surveyid) {
        return dao.findAll();
    }

	@Override
	public AnswerVo createMstAnswers(AnswerVo AnswerVo) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
	
	
/*	@Override
	public List<MstQuestionsVO> findQuestionAndAnswer(MstQuestionsVO mstQuestionsVO) {
Optional<MstQuestionsVO> userList = dao.findById(mstQuestionsVO.getQuestionid());*/
		
		
		/*List<MstQuestionsVO> collectToFacility = userList
													.stream()
													.map((MstQuestionsVO login)-> new MstQuestionsVO())
													.collect(Collectors.toList());*/
//		return (List<MstQuestionsVO>) userList.get();
//		return dao.findQuestionAndAnswer(mstQuestionsVO);
	

}
