package com.cg.ars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ars.dao.IBookingInformationDao;
import com.cg.ars.dao.IFlightDao;
import com.cg.ars.entity.BookingInformation;
import com.cg.ars.entity.Flight;
import com.cg.ars.exception.AIRSException;

/*****************************************************************************************************************************
 *@author       : Team 1
 * File Name    : BookingInformationSeviceImpl
 * Package Name : com.cg.ars.service
 * Description  : Implementation class of service layer which interacts with the data access layer and performs the appropriate operations.
 ********************************************************************************************************************************/

@Service("iBookingService")
@Transactional(rollbackFor=AIRSException.class)
public class BookingInformationSeviceImpl implements IBookingInformationService{

	@Autowired
	IBookingInformationDao iBookingInformationDao;
	
	@Autowired
	IFlightDao iFlightDao;
	
	BookingInformation bookingInformation = new BookingInformation();
	
	/****************************************************************************************************************************
	 * Method Name : addBooking
	 * Description : Calls addBooking method in data access layer and returns result to ARSController
	 * Return Type : boolean
	 * @param      : BookingInformation bookingInformation
	 ****************************************************************************************************************************/

	@Override
	public boolean addBooking(BookingInformation bookingInformation) throws AIRSException {
		
		return iBookingInformationDao.addBooking(bookingInformation);
	}
	/****************************************************************************************************************************
	 * Method Name : showBookings
	 * Description : Calls showBookings method in data access layer and returns result to ARSController 
	 * Return Type : List<BookingInformation>
	 ****************************************************************************************************************************/

	@Override
	public List<BookingInformation> showBookings() throws AIRSException {
		
		return iBookingInformationDao.showBookings();
	}

	/****************************************************************************************************************************
	 * Method Name : showBooking
	 * Description : Calls showBooking method in data access layer and returns result to ARSController 
	 * Return Type : BookingInformation
	 * @param      : int bookingId
	 ****************************************************************************************************************************/

	@Override
	public BookingInformation showBooking(int bookingId) throws AIRSException {
		
		return iBookingInformationDao.showBooking(bookingId);
	}

	/****************************************************************************************************************************
	 * Method Name : updateBooking
	 * Description : calls updatBooking method in data access layer. 
	 * Return Type : void
	 * @param      : BookingInformation bookingInformation
	 ****************************************************************************************************************************/

	@Override
	public void updateBooking(BookingInformation bookingInformation)
			throws AIRSException {
		iBookingInformationDao.updateBooking(bookingInformation);
		
	}

	/****************************************************************************************************************************
	 * Method Name : showBookings
	 * Description : Calls showBookings method in data access layer and returns result to ARSController. 
	 * Return Type : List<BookingInformation>
	 * @param      : String username
	 ****************************************************************************************************************************/

	@Override
	public List<BookingInformation> showBookings(String username)
			throws AIRSException {
		
		return iBookingInformationDao.showBookings(username);
	}

	/****************************************************************************************************************************
	 * Method Name : cancelBooking
	 * Description : calls cancelBooking method in data access layer. 
	 * Return Type : boolean
	 * @param      : int bookingId
	 ****************************************************************************************************************************/

	@Override
	public boolean cancelBooking(int bookingId,String noOfPassengers) throws AIRSException {
		
		BookingInformation bookingInformation = iBookingInformationDao.showBooking(bookingId);
		int flightNum = bookingInformation.getFlightno();
		String type = bookingInformation.getClassType();
		Flight flight = iFlightDao.showFlight(flightNum);
		if(type.equals("First Class"))
		{
			int seatsUpdate = flight.getFirstSeatLeft()+Integer.parseInt(noOfPassengers);
			flight.setFirstSeatLeft(seatsUpdate);
		}
		else
		{
			int seatsUpdate = flight.getBussSeatLeft()+Integer.parseInt(noOfPassengers);
			flight.setBussSeatLeft(seatsUpdate);
		}
		iFlightDao.updateFlight(flight);
		boolean cancelled = iBookingInformationDao.cancelBooking(bookingId);
		return cancelled;
	}
	
	/****************************************************************************************************************************
	 * Method Name : addBooking
	 * Description : sets the bookingInformation
	 * Return Type : BookingInformation
	 * @param      : Flight flight
	 * @param      : int seats
	 * @param      : String type
	 * @param      : String username
	 ****************************************************************************************************************************/

	@Override
	public BookingInformation addBooking(Flight flight,int seats,String type,String username) throws AIRSException {
		
		int seatFlight=0;
		long totalFare=0;
		
		if(type.equals("First Class"))
		{
			int seatNumber=flight.getFirstSeats()-flight.getFirstSeatLeft();
			bookingInformation.setFlightno(flight.getFlightno());
			bookingInformation.setUsername(username);
			bookingInformation.setSrcCity(flight.getSource());
			bookingInformation.setDestCity(flight.getDestination());
			bookingInformation.setNoOfPassengers(String.valueOf(seats));
			bookingInformation.setClassType("First Class");
			bookingInformation.setSeatNumberStart(seatNumber+1);
			bookingInformation.setSeatNumberEnd(seatNumber+seats);
			totalFare=seats*flight.getFirstSeatFare();
			seatFlight=flight.getFirstSeatLeft()-seats;
			flight.setFirstSeatLeft(seatFlight);
			bookingInformation.setTotalFare(totalFare);

		}
		else{
			int seatNumber=flight.getBussSeats()-flight.getBussSeatLeft();
			bookingInformation.setFlightno(flight.getFlightno());
			bookingInformation.setUsername(username);
			bookingInformation.setSrcCity(flight.getSource());
			bookingInformation.setDestCity(flight.getDestination());
			bookingInformation.setNoOfPassengers(String.valueOf(seats));
			bookingInformation.setClassType("Business Class");
			bookingInformation.setSeatNumberStart(seatNumber+1);
			bookingInformation.setSeatNumberEnd(seatNumber+seats);
			totalFare=seats*flight.getBussSeatFare();
			seatFlight=flight.getBussSeatLeft()-seats;
			flight.setBussSeatLeft(seatFlight);
			bookingInformation.setTotalFare(totalFare);
		}
	
			
			iFlightDao.updateFlight(flight);
			
		return bookingInformation;
	}

}
