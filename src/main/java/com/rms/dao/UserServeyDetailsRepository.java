package com.rms.dao;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rms.model.UserServeyDetailsModel;

/**
 * @author Susheel.Kumar
 *
 */

@Repository
public interface UserServeyDetailsRepository extends JpaRepository<UserServeyDetailsModel, Integer> {
	
	public 	List<UserServeyDetailsModel> findByDateBetween(String startDate, String endDate); 
	
	
	
	 @Modifying
	 @Transactional
	  @Query(value = "UPDATE rms.usersurveydetails set DATE =current_date() where USERID = ?",
		           nativeQuery = true)
	   public void updateUserDate(String userId);
	 
	 
	 
	// public Optional<UserServeyDetailsModel> findByUserId(String userId);

	public Optional<UserServeyDetailsModel> findByUserIdAndSurveyId(
			String userId, int surveyid);

}

	

	





	
	

