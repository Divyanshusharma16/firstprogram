/**
 * 
 */
package com.rms.service;

import java.util.List;

import com.rms.model.AnswerVo;
import com.rms.model.MstQuestionsVO;


/**
 * @author shiva.theja
 *
 */
public interface ImstQuestionsService {

	public MstQuestionsVO createMstQuestions(MstQuestionsVO mstQuestionsVO);
	List<MstQuestionsVO> getmstQuestionsVO(int surveyid);	
	public AnswerVo createMstAnswers(AnswerVo AnswerVo);
}
