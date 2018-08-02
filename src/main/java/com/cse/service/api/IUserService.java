package com.cse.service.api;

import java.util.List;

import com.cse.domain.User;
import com.cse.service.exception.NotFoundException;

public interface IUserService {
	
	User addUser(User user);

	User findUser(long id) throws NotFoundException;

	List<User> findAllUsers();

	void deleteUser(long id) throws NotFoundException;

	List<User> searchUsers(User userDto) throws NotFoundException;

	User updateUser(User user) throws NotFoundException;
	
	User findUserByUsername(String username) throws NotFoundException;
	
}
