package com.cg.gradle_dryclean.repository;

import com.cg.gradle_dryclean.exception.NotFoundException;
import com.cg.gradle_dryclean.models.User;

public interface IUserRepository {
	User signIn(User user)throws NotFoundException;
	User signOut(User user);
	User changePassword(long id, User user)throws NotFoundException;
}
