package com.cg.gradle_dryclean.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cg.gradle_dryclean.exception.*;

import com.cg.gradle_dryclean.jpa.IUserJpa;
import com.cg.gradle_dryclean.models.User;
@Repository
public class UserRepository implements IUserRepository{
	@Autowired
	private IUserJpa userjpa;
	

	public User signIn(User user) throws NotFoundException{
		User u = userjpa.findByUserIdAndPassword(user.getUserId(), user.getPassword());
		
		if(u==null) {
			throw new NotFoundException("UserId or Password is not correct");
		}
		return u;
		
	}
	
	public User signOut(User user) {
		return user;
	}
	
	public User changePassword(long id, User user)  throws NotFoundException {
		Optional<User> ou=userjpa.findById(Long.toString(id));
		if(ou.isPresent()) {
			User u=ou.get();
			u.setPassword(user.getPassword());
			userjpa.save(u);
			return u;
		}
		else
			throw new NotFoundException("User Id is not valid");
		
	}
}
