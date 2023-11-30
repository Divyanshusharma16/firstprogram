package com.rms.serviceImpl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.dao.UserRepository;
import com.rms.model.UserLogin;
import com.rms.service.IUserService;
import com.rms.util.Base64;
import com.rms.util.DecriptionEncription;
import com.rms.util.EmailAndSMSService;

/**
 * @author Susheel.Kumar
 *
 */

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository dao;	
	
	@Autowired
	EmailAndSMSService emailAndSMSService;
	
	@Autowired
	DecriptionEncription decriptionEncription;
	
	@Autowired 
	Base64 base64;
	
	@Override
	public UserLogin createUserLogin(UserLogin userLogin) {
			return dao.save(userLogin);
			
	}

	@Override
	public List<UserLogin> findByusernameAnduserpassword(UserLogin userLogin) throws Exception {
		//return dao.findByUsernameAndUserpassword(userLogin.getUsername(),userLogin.getUserpassword());
		//String userName=decriptionEncription.decryptFromURL(userLogin.getUsername().trim());
		//String userPass=decriptionEncription.decryptFromURL(userLogin.getUserpassword().trim());
		//String facility=decriptionEncription.decryptFromURL(userLogin.getFacility().trim());
		//Base64 base64 = new Base64();
	//	String decodedString = new String(base64.decode(userName.getBytes()));
		
		return dao.findByUsernameAndUserpassword(userLogin.getUsername(),userLogin.getUserpassword());
	}

	

	
	
	/*@Override
	public  boolean sendSmsToUser(SendSmsAndSendEmailVO sendSmsAndSendEmailVO) {
		return emailAndSMSService.sendSmsToUser(sendSmsAndSendEmailVO.getPatientCellNo(),"+16122236639","Text Message");
	}
*/
	
	}

	

		
