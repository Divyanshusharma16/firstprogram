package com.rms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.dao.AdminRepositroy;
import com.rms.model.ReminderAndFrequencyModel;
import com.rms.service.IReminderAndFrequency;

/**
 * @author Susheel.Kumar
 *
 */

@Service
public class ReminderAndFrequencyImpl implements IReminderAndFrequency {
	
	@Autowired
	AdminRepositroy adminRepositroy;

	@Override
	public void saveReminderAndFrequency(ReminderAndFrequencyModel reminderAndFrequencyModel) {
		
		//String name=checkUserNameExistWithDataBase(reminderAndFrequencyModel);
				adminRepositroy.updateUserReminder(reminderAndFrequencyModel.getReminder(),reminderAndFrequencyModel.getFrequncy());
			
			
	}
	@Override
	public List<ReminderAndFrequencyModel> getReminderAndFrequency() {
		// TODO Auto-generated method stub
		return adminRepositroy.findAll();
	}
	
	
	}

	

		
