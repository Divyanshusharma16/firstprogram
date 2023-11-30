package com.rms.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.model.UserLogin;

/**
 * @author Susheel.Kumar
 *
 */

@Repository
public interface UserRepository extends JpaRepository<UserLogin, Integer> {
	public List<UserLogin> findByUsernameAndUserpassword(String username,String userpassword);
    

}

	

	





	
	

