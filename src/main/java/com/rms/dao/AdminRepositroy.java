package com.rms.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rms.model.ReminderAndFrequencyModel;

/**
 * @author Susheel.Kumar
 *
 */

@Repository
public interface AdminRepositroy extends JpaRepository <ReminderAndFrequencyModel, Integer> {
	@Modifying
	 @Transactional
	 @Query(value = "UPDATE rms.mstadmin set REMINDER=?,FREQUNCY =?",
	 nativeQuery = true)
	public void  updateUserReminder(int reminder,int frequncy);
	
	
    

}

	

	





	
	

