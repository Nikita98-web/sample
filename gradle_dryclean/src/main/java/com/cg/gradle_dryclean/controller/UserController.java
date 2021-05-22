package com.cg.gradle_dryclean.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.models.User;
import com.cg.gradle_dryclean.services.IUserService;

import org.springframework.http.*;




@RestController
@RequestMapping("/user")
public class UserController {
	static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private IUserService userService;
	
	//Get sign in
	@GetMapping("/getsignin")
	public ResponseEntity<Object> signIn(@RequestBody User user) throws NotFoundException {
		LOGGER.info("/User/getsignin URL is opened");
		LOGGER.info("SignIn method executed");
		ResponseEntity <Object>response=null;
		User u=userService.signIn(user);
		response=new ResponseEntity<>(u, HttpStatus.ACCEPTED);
		return response;
	}
	
	//Get sign out
	@GetMapping("/getsignout")
	public User signOut(@RequestBody User user) {
		LOGGER.info("/User/getsignOut URL is opened");
		LOGGER.info("SignOut method executed");
		return userService.signOut(user);
	}
	
	//Update Password by id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> changePassword(@PathVariable long id,@RequestBody User user) throws NotFoundException{
		LOGGER.info("/User/update/{id} URL is opened");
		LOGGER.info("ChangePassword method executed");
		ResponseEntity <Object>response=null;
			User u= userService.changePassword(id, user);
			response=new ResponseEntity<>(u, HttpStatus.ACCEPTED);
		return response;
	}
	
}
