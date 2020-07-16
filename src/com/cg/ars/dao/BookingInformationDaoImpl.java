package com.cg.ars.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.cg.ars.entity.BookingInformation;
import com.cg.ars.exception.AIRSException;

/*****************************************************************************************************************************
 *@author       : Team 1
 * File Name	: BookingInformationDaoImpl.java
 * Package Name : com.cg.ars.dao
 * Description  : Implementation class of data access layer which interacts with the database and performs the appropriate operations.
 *****************************************************************************************************************************/

@Repository("iBookingDao")
public class BookingInformationDaoImpl implements IBookingInformationDao{

	@PersistenceContext
	EntityManager entityManager;
	
	
	static Logger mylogger = null;
	
	public BookingInformationDaoImpl() {
		mylogger = Logger.getLogger("LoggingInterceptor.class");
	}
	
	/****************************************************************************************************************************
	 * Method Name : addBooking
	 * Description : Inserts bookingInformation into database and returns the boolean to the service layer. 
	 * Return Type : boolean
	 * @param      : BookingInformation bookingInformation
	 ****************************************************************************************************************************/

	@Override
	public boolean addBooking(BookingInformation bookingInformation) throws AIRSException{
		try{
		entityManager.persist(bookingInformation);
		entityManager.flush();
		mylogger.info("User booked a ticket");
		}catch(Exception e)
		{
			throw new AIRSException(e.getMessage());
		}
		
		return true;
	}

	/****************************************************************************************************************************
	 * Method Name : showBookings
	 * Description : Retrieves bookingInformation from database and returns the data to the service layer. 
	 * Return Type : List<BookingInformation>
	 ****************************************************************************************************************************/

	@Override
	public List<BookingInformation> showBookings() throws AIRSException {
		
		List<BookingInformation> bookings;
		try{
		String showBookings="* FROM BookingInformation";
		TypedQuery<BookingInformation> bookingInfo=entityManager.createQuery(showBookings, BookingInformation.class);
		bookings=bookingInfo.getResultList();
		}catch(Exception e)
		{
			throw new AIRSException(e.getMessage());
		}
		return bookings;
	}

	/****************************************************************************************************************************
	 * Method Name : showBooking
	 * Description : Retrieves bookingInformation of given bookingId from database and returns the data to the service layer. 
	 * Return Type : BookingInformation
	 * @param      : int bookingId
	 ****************************************************************************************************************************/

	@Override
	public BookingInformation showBooking(int bookingId) throws AIRSException {
		try{
		String showBookingsBId = "SELECT bookingInformation FROM BookingInformation bookingInformation WHERE bookingInformation.bookingId=:bookingId";
		TypedQuery<BookingInformation> query = entityManager.createQuery(showBookingsBId, BookingInformation.class);
		query.setParameter("bookingId",bookingId);
		return query.getSingleResult();
		}catch(Exception e)
		{
			throw new AIRSException(e.getMessage());
		}
	}

	/****************************************************************************************************************************
	 * Method Name : updateBooking
	 * Description : updates bookingInformation in database. 
	 * Return Type : void
	 * @param      : BookingInformation bookingInformation
	 ****************************************************************************************************************************/

	@Override
	public void updateBooking(BookingInformation bookingInformation) throws AIRSException {
		try{
		entityManager.merge(bookingInformation);
		entityManager.flush();
		mylogger.info("User updated a ticket");
		}catch(Exception e)
		{
			throw new AIRSException(e.getMessage());
		}
		
	}

	/****************************************************************************************************************************
	 * Method Name : showBookings
	 * Description : Retrieves bookingInformation for given username from database and returns data to service layer. 
	 * Return Type : List<BookingInformation>
	 * @param      : String username
	 ****************************************************************************************************************************/

	@Override
	public List<BookingInformation> showBookings(String username) throws AIRSException {
		try{
		String showBookingsUsername = "SELECT bookingInformation FROM BookingInformation bookingInformation WHERE bookingInformation.username=:pusername";
		TypedQuery<BookingInformation> query = entityManager.createQuery(showBookingsUsername, BookingInformation.class);
		query.setParameter("pusername",username);
		mylogger.info("User viewed Bookings");
		return query.getResultList();
		}catch(Exception e)
		{
			throw new AIRSException(e.getMessage());
		}
	}

	/****************************************************************************************************************************
	 * Method Name : cancelBooking
	 * Description : deletes bookingInformation in database for given bookingId. 
	 * Return Type : boolean
	 * @param      : int bookingId
	 ****************************************************************************************************************************/

	@Override
	public boolean cancelBooking(int bookingId) throws AIRSException {
		try{
		
		BookingInformation bookingInformation = entityManager.find(BookingInformation.class, bookingId);
		
		entityManager.remove(bookingInformation);
		entityManager.flush();
		mylogger.info("User cancelled Ticket");
		}catch(Exception e)
		{
			throw new AIRSException(e.getMessage());
		}
		return true;
	}

}
