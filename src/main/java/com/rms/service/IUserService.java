package com.rms.service;


import java.util.List;
import org.springframework.stereotype.Service;

import com.rms.model.SendSmsAndSendEmailVO;
import com.rms.model.UserLogin;


/**
 * @author Susheel.Kumar
 *
 */
@Service
public interface IUserService {

	public UserLogin createUserLogin(UserLogin userLogin);
	
	//public boolean sendSmsToUser(SendSmsAndSendEmailVO sendSmsAndSendEmailVO);
	

	public List<UserLogin> findByusernameAnduserpassword(UserLogin userLogin) throws Exception;

	

	

	
	





	
	
	
	


	
	

}