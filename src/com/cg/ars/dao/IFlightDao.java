package com.cg.ars.dao;

import java.sql.Date;
import java.util.List;

import com.cg.ars.entity.Flight;
import com.cg.ars.exception.AIRSException;

/*******************************************************************************************************
 * @author      : Team 1
 * File Name    : IFlightDao.java
 * Package Name : com.cg.ars.dao
 * Description  : Consists of all the Method Declarations of those methods present in FlightDaoImpl.java 		
******************************************************************************************************/

public interface IFlightDao {
	
	public Flight showFlight(int flightNo) throws AIRSException;
	public List<Flight> showFlight(String source,String destination,Date dep) throws AIRSException;
	public void updateFlight(Flight flight) throws AIRSException;
	public List<Flight> getAirportList() throws AIRSException;
}
