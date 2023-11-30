package com.rms.service;

import java.util.List;

import com.rms.model.FacilityVO;
import com.rms.model.ReminderAndFrequencyModel;
/**
 * @author Susheel.Kumar
 *
 */

public interface IReminderAndFrequency {

	public void	 saveReminderAndFrequency(ReminderAndFrequencyModel reminderAndFrequencyModel);
	public  List<ReminderAndFrequencyModel>  getReminderAndFrequency();
	
	


	
	

}