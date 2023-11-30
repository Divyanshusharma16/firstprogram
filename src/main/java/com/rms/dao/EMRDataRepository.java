package com.rms.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rms.model.MstPatientDetails;

/**
 * @author Susheel.Kumar
 *
 */

@Repository
public interface EMRDataRepository extends JpaRepository<MstPatientDetails, Integer> {
List<MstPatientDetails> findByCheckOutTime(String checkOutTime) throws IOException; 

 @Modifying
 @Transactional
  @Query(value = "UPDATE rms.mstpatientdetails set SMSSTATUS =? where PATIENTCELLNO = ?",
	            nativeQuery = true)
     public   void updateSMSStatus(String status,String toNumber);
 
 
 @Modifying
 @Transactional
  @Query(value = "UPDATE rms.mstpatientdetails set EMAIL_STATUS =? where PATIENTEMAIL = ?",
	           nativeQuery = true)
     public   void updateEmailStatus(String status,String emailTo);
 
 
 
 @Modifying
 @Transactional
  @Query(value = "UPDATE rms.mstpatientdetails set SURVEYURL =? where PATIENTNAME = ?",
	           nativeQuery = true)
   public  void updateSurveyURL(String link, String patientName);
 

 
 
 @Modifying
 @Transactional
  @Query(value = "UPDATE rms.mstpatientdetails set REMINDMESTATUS =?,REMINDERDATE=current_date() where PATIENTID = ?",
	           nativeQuery = true)
  void updateRemindMeAndNotInterstedStatus(String remindMeflag,String userId );

 @Modifying
 @Transactional
  @Query(value = "UPDATE rms.mstpatientdetails set REMINDMESTATUS =?,REMINDERDATE=current_date() where PATIENTID = ?",
	           nativeQuery = true)
     void updateNotInterstedStatus(String remindMeflag,String userId);
 
 
 
 
 @Modifying
 @Transactional
  @Query(value = "UPDATE rms.mstpatientdetails set REMINDMESTATUS =?,REMINDERDATE=current_date() where PATIENTID = ?",
	           nativeQuery = true)
 void updateSurveyStatus(String remindMeflag, String userId);

 public  List<MstPatientDetails> findByRemindmeStatus(String R);
 

 
 @Modifying
 @Transactional
  @Query(value = "UPDATE rms.mstpatientdetails set COUNT =?,REMINDERDATE=? where PATIENTID = ?",
	           nativeQuery = true)
void updatedCountAndDate(int patientCount,String frequencyDate,String userId);
 
 
 
 
 @Modifying
 @Transactional
  @Query(value = "UPDATE rms.mstpatientdetails set COUNT =?,FREQUENCY=? where PATIENTID = ?",
	           nativeQuery = true)
void updateReminderAndFrequencyCount(int reminder, int frequncy,String userID);


          
}       

	

	





	
	

