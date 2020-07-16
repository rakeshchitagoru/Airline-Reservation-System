package com.cg.ars.service;

import java.util.List;

import com.cg.ars.entity.BookingInformation;
import com.cg.ars.entity.Flight;
import com.cg.ars.exception.AIRSException;

/*******************************************************************************************************
 * @author      : Team 1
 * File Name    : IBookingInformationService.java
 * Package Name : com.cg.ars.service
 * Description  : Consists of all the Method Declarations of those methods present in BookingInformationServiceImpl		
 ******************************************************************************************************/

public interface IBookingInformationService {
	public boolean addBooking(BookingInformation bookingInformation) throws AIRSException;
	public List<BookingInformation> showBookings() throws AIRSException;
	public BookingInformation showBooking(int bookingId) throws AIRSException;
	public void updateBooking(BookingInformation bookingInformation) throws AIRSException;
	public List<BookingInformation> showBookings(String username)throws AIRSException;
	public boolean cancelBooking(int bookingId,String noOfPassengers) throws AIRSException;
	public BookingInformation addBooking(Flight flight,int seats,String type,String username) throws AIRSException;

	
}
