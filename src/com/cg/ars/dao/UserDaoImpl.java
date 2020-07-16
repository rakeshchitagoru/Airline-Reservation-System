package com.cg.ars.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.cg.ars.entity.User;
import com.cg.ars.exception.AIRSException;

/*****************************************************************************************************************************
 *@author       : Team 1
 * File Name	: UserDaoImpl.java
 * Package Name : com.cg.ars.dao
 * Description  : Implementation class of data access layer which interacts with the database and performs the appropriate operations.
 *****************************************************************************************************************************/


@Repository("iUserDao")
public class UserDaoImpl implements IUserDao{

	@PersistenceContext
	EntityManager entityManager;
	
	static Logger mylogger = null;
	
	public UserDaoImpl() {
		mylogger = Logger.getLogger("LoggingInterceptor.class");
	}
	/****************************************************************************************************************************
	 * Method Name : addUser
	 * Description : Inserts user into Database and returns result to service layer. 
	 * Return Type : int
	 * @param      : User user
	 ****************************************************************************************************************************/

	@Override
	public boolean addUser(User user) throws AIRSException {
		try{
		entityManager.persist(user);
		entityManager.flush();
		mylogger.info("User registered.");
		return true;
		}catch(Exception e)
		{
			throw new AIRSException(e.getMessage());
		}
	}

	/****************************************************************************************************************************
	 * Method Name : showUsers
	 * Description : Retrieves details of the users from the database and returns the data to the service layer. 
	 * Return Type : List<User> 
	 ****************************************************************************************************************************/

	@Override
	public List<User> showUsers() throws AIRSException {
		try{
			List<User> users;
		String showUser="SELECT user FROM User user";
		TypedQuery<User> query=entityManager.createQuery(showUser, User.class);
		users=query.getResultList();
		return users;
		}
		catch(Exception e)
		{
			throw new AIRSException(e.getMessage());
		}
		
		
	}

	/****************************************************************************************************************************
	 * Method Name : validateLogin
	 * Description : Retrieves details of the user for given condition from the database and returns the data to the service layer. 
	 * Return Type : boolean 
	 * @param      : String username
	 * @param      : String password
	 ****************************************************************************************************************************/

	@Override
	public boolean validateLogin(String username, String password) throws AIRSException {
		try{
		boolean userExist=false;
		String showUser="SELECT user FROM User user WHERE user.username=:username AND user.password=:password";
		TypedQuery<User> query=entityManager.createQuery(showUser, User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		if(query.getResultList().isEmpty())
			return userExist;
		else 
			return true;
		}
		catch(Exception e)
		{
			throw new AIRSException(e.getMessage());
		}
	}

	/****************************************************************************************************************************
	 * Method Name : userExisting
	 * Description : Retrieves details of the user for given condition from the database and returns the data to the service layer. 
	 * Return Type : boolean 
	 * @param      : String username
	 ****************************************************************************************************************************/

	@Override
	public boolean userExisting(String username) throws AIRSException {
		try{
		boolean userExist=false;
		String showUser="SELECT user FROM User user WHERE user.username=:username";
		TypedQuery<User> query=entityManager.createQuery(showUser, User.class);
		query.setParameter("username", username);
		if(query.getResultList().isEmpty())
			return userExist;
		else 
			return true;
		}catch(Exception e)
		{
			throw new AIRSException(e.getMessage());
		}
		
	}

}
