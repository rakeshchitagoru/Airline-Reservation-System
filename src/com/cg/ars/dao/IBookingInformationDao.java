package com.cg.ars.dao;

import java.util.List;

import com.cg.ars.entity.BookingInformation;
import com.cg.ars.exception.AIRSException;

/*******************************************************************************************************
 * @author      : Team 1
 * File Name    : IBookingInformation.java
 * Package Name : com.cg.ars.dao
 * Description  : Consists of all the Method Declarations of those methods present in BookingInformationDaoImpl.java 		
******************************************************************************************************/

public interface IBookingInformationDao {
	
	public boolean addBooking(BookingInformation bookingInformation) throws AIRSException;
	public List<BookingInformation> showBookings() throws AIRSException;
	public BookingInformation showBooking(int bookingId) throws AIRSException;
	public void updateBooking(BookingInformation bookingInformation) throws AIRSException;
	public List<BookingInformation> showBookings(String username)throws AIRSException;
	public boolean cancelBooking(int bookingId) throws AIRSException;
	

	

}
