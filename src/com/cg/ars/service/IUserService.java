package com.cg.ars.service;

import java.util.List;

import com.cg.ars.entity.User;
import com.cg.ars.exception.AIRSException;

/*******************************************************************************************************
 * @author      : Team 1
 * File Name    : IUserService.java
 * Package Name : com.cg.ars.service
 * Description  : Consists of all the Method Declarations of those methods present in UserServiceImpl		
 ******************************************************************************************************/

public interface IUserService {
	public boolean addUser(User user) throws AIRSException;
	public List<User> showUsers() throws AIRSException;
	public boolean validateLogin(String username, String password) throws AIRSException;
	public boolean userExisting(String username) throws AIRSException;
}
