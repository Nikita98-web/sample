package com.cg.gradle_dryclean;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.models.Address;
import com.cg.gradle_dryclean.models.Booking;
import com.cg.gradle_dryclean.models.Customer;
import com.cg.gradle_dryclean.models.User;
import com.cg.gradle_dryclean.services.IUserService;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
public class UserServiceTest {
	static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceTest.class);
	@Autowired
	private IUserService userService;
	
	User user=null;
	
	
	@Test
	public void signInTest01() throws NotFoundException{
		LOGGER.info("signInTest01 method executed");
		user=new User("386","jsdeus");
		try {
		userService.signIn(user);
		}
		catch(NotFoundException ex) {
		assertEquals("UserId or Password is not correct",ex.getMessage());
		}
	}
	@Test
	public void signInTest02() throws NotFoundException{
		LOGGER.info("signInTest02 method executed");
		user=new User("7","xyz");
		try {
		assertNotNull(userService.signIn(user));
		}
		catch(NotFoundException ex) {
		assertEquals("UserId or Password is not correct",ex.getMessage());
		}
	}
	
	@Test
	public void signOutTest01() {
		LOGGER.info("signOutTest01 method executed");
		user=new User("386","jsdeus");
		assertEquals(userService.signOut(user),user);
	}
	@Test
	public void signOutTest02() {
		LOGGER.info("signOutTest02 method executed");
		user=new User("7","xyz");
		assertEquals(userService.signOut(user),user);
	}
	
	@Test
	public void changePasswordTest01() throws NotFoundException{
		LOGGER.info("changePasswordtTest01 method executed");
		user=new User("386","jsdeus");
		try {
			userService.changePassword(639, user);
		}
		catch(NotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
	}
	@Test
	public void changePasswordgTest02() throws NotFoundException{
		LOGGER.info("changePasswordTest01 method executed");
		user=new User("7","xyz");
		try {
		assertNotNull(userService.changePassword(639, user));
		}
		catch(NotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
	}
}
