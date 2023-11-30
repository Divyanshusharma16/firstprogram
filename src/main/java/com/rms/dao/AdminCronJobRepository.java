package com.rms.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rms.model.AdminCronJobModel;
import com.rms.model.ReminderAndFrequencyModel;

/**
 * @author Susheel.Kumar
 *
 */

@Repository
public interface AdminCronJobRepository extends JpaRepository <AdminCronJobModel, Integer> {

	
	 @Modifying
	 @Transactional
	  @Query(value = "update  rms.mstadmincronjobsetting set CRONJOBSTATUS=?",
		           nativeQuery = true)
	
public	void cronJobStatus(String cronJobStatus);
	
	
	
	
	
    

}

	

	





	
	

