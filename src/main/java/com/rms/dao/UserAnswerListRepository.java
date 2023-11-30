package com.rms.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rms.model.UserAnswerList;

/**
 * @author Susheel.Kumar
 *
 */

@Repository
public interface UserAnswerListRepository extends JpaRepository <UserAnswerList, Integer> {
	
	@Modifying
    @Query(value = "insert into rms.usersurveydetails (QUESTIONID,SELECTEDOPTION,SCORE,SURVEYID) VALUES (?,?,?,?)", nativeQuery = true)
    @Transactional
	public void  insertuserAnswerList(String qId,String sOption,String userScore,String sId);

	//public ReminderAndFrequencyModel findByUserName();
	
	
    

}

	

	





	
	

