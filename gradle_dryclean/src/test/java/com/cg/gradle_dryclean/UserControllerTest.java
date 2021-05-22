package com.cg.gradle_dryclean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.cg.gradle_dryclean.controller.UserController;
import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.models.User;
import com.cg.gradle_dryclean.services.IUserService;

@SpringBootTest
public class UserControllerTest {
	static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);
	@Autowired
	private UserController userController;
	
	User user=null;
	
	
	@Test
	public void signInTest01() throws NotFoundException{
		LOGGER.info("signInTest01 method executed");
		user=new User("7","xyz");
		assertEquals(userController.signIn(user).getStatusCode(),HttpStatus.ACCEPTED);
	}
	
	@Test
	public void signOutTest01() {
		LOGGER.info("signOutTest01 method executed");
		user=new User("7","xyz");
		assertEquals(userController.signOut(user).getStatusCode(),HttpStatus.OK);
	}
	
	@Test
	public void changePasswordTest01() throws NotFoundException{
		LOGGER.info("signOutTest01 method executed");
		user=new User("7","xyz");
		assertEquals(userController.changePassword(7, user).getStatusCode(),HttpStatus.ACCEPTED);
		
	}
}
