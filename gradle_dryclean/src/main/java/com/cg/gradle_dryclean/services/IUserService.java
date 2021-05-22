package com.cg.gradle_dryclean.services;

import com.cg.gradle_dryclean.exception.*;
import com.cg.gradle_dryclean.models.*;

public interface IUserService {
	User signIn(User user) throws NotFoundException;
	User signOut(User user);
	User changePassword(long id, User user)throws NotFoundException;
}
