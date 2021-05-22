package com.cg.gradle_dryclean.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.gradle_dryclean.exception.*;
import com.cg.gradle_dryclean.models.User;
import com.cg.gradle_dryclean.repository.IUserRepository;
@Service
public class UserService implements IUserService{
	static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private IUserRepository userRepository;
	
	//sign in for user
	public User signIn(User user) throws NotFoundException {
		LOGGER.info("User service - SignIn method executed");
		return userRepository.signIn(user) ;
	}
	
	//Sign out for user
	public User signOut(User user) {
		LOGGER.info("User service - SignOut method executed");
		return userRepository.signOut(user);
	}
	
	//Change password for user
	public User changePassword(long id, User user) throws NotFoundException{
		LOGGER.info("User service - ChangePassword method executed");
		return userRepository.changePassword(id, user);
	}
	
	
}
