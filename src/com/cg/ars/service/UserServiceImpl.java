package com.cg.ars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ars.dao.IUserDao;
import com.cg.ars.dao.UserDaoImpl;
import com.cg.ars.entity.User;
import com.cg.ars.exception.AIRSException;

/*****************************************************************************************************************************
 *@author       : Team 1
 * File Name    : UserSeviceImpl
 * Package Name : com.cg.ars.service
 * Description  : Implementation class of service layer which interacts with the data access layer and performs the appropriate operations.
 ********************************************************************************************************************************/

@Service("iUserService")
@Transactional(rollbackFor=AIRSException.class)
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao iUserDao=new UserDaoImpl();
	
	/****************************************************************************************************************************
	 * Method Name : addUser
	 * Description : Calls addUSer method in data access layer and returns data to ARSController
	 * Return Type : int
	 * @param      : User user
	 ****************************************************************************************************************************/

	@Override
	public boolean addUser(User user) throws AIRSException {
		
		return iUserDao.addUser(user);
	}

	/****************************************************************************************************************************
	 * Method Name : showUsers
	 * Description : Calls showUsers method in data access layer and returns data to ARSController 
	 * Return Type : List<User> 
	 ****************************************************************************************************************************/

	@Override
	public List<User> showUsers() throws AIRSException {
	
		return iUserDao.showUsers();
	}

	/****************************************************************************************************************************
	 * Method Name : validateLogin
	 * Description : Calls validateLogin method in data access layer and returns data to ARSController.
	 * Return Type : boolean 
	 * @param      : String username
	 * @param      : String password
	 ****************************************************************************************************************************/

	@Override
	public boolean validateLogin(String username, String password)
			throws AIRSException {
		
		return iUserDao.validateLogin(username, password);
	}

	/****************************************************************************************************************************
	 * Method Name : userExisting
	 * Description : Calls userExisting method in data access layer and returns data to ARSController.
	 * Return Type : boolean 
	 * @param      : String username
	 ****************************************************************************************************************************/

	@Override
	public boolean userExisting(String username) throws AIRSException {
		
		return iUserDao.userExisting(username);
	}

}
