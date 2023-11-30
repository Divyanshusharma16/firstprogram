/**
 * 
 */
package com.rms.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rms.model.MstQuestionsVO;

/**
 * @author shiva.theja
 *
 */
@Repository
public interface MstQuestionDataRepository extends JpaRepository<MstQuestionsVO, Integer> {
	
	
	
	
	@Modifying
	 @Transactional
	 @Query(value = "Delete from rms.answers  where questionid =?",
	 nativeQuery = true)
    public void deleteAnswerForParticularQuestion(int questionid);

//	public List<MstQuestionsVO> findById(MstQuestionsVO MstQuestionsVO);
//	public List<MstQuestionsVO> findById(MstSurveyVO MstQuestionsVO);
	
//	 @Query("FROM MSTQUESTIONS g where g.questionid.id = :surveyid")
//	 List<MstQuestionsVO> findAllByCurrentUser(@Param("questionid") int surveyid);
//	MstSurveyVO mstSurveyVO= su

//	 List<AnswerVo> findAnswers(@Param("questionid") int questionid);
//	
}
