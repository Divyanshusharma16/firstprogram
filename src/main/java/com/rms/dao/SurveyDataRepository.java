/**
 * 
 */
package com.rms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rms.model.MstSurveyVO;



/**
 * @author shiva.theja
 *
 */
@Repository
public interface SurveyDataRepository extends JpaRepository<MstSurveyVO, Integer>{

	Optional<MstSurveyVO> findBySurveyid(@Param("surveyid") int surveyid);
	//List<MstSurveyVO> findAll();
	Optional<MstSurveyVO> findBysurveyid(int surveyId);
	Optional<MstSurveyVO> findTop1BySurveyStatusOrderBySurveyidDesc(@Param("surveyStatus") String surveyStatus);
	
	
	
	
	
	 @Modifying
	 @Transactional
	  @Query(value = "delete from rms.mstsurvey where surveyId=?",
		           nativeQuery = true)
public	 int discardSurvey( String surveyId);
	 
	 
	 
}
