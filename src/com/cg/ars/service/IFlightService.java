package com.cg.ars.service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;

import com.cg.ars.entity.Flight;
import com.cg.ars.exception.AIRSException;

/*******************************************************************************************************
 * @author      : Team 1
 * File Name    : IFlightService.java
 * Package Name : com.cg.ars.service
 * Description  : Consists of all the Method Declarations of those methods present in FlightServiceImpl		
 ******************************************************************************************************/

public interface IFlightService {
	
	public Flight showFlight(int flightNo) throws AIRSException;
	public List<Flight> showFlight(String source,String destination,Date dep) throws AIRSException;
	public void updateFlight(Flight flight) throws AIRSException;
	public HashSet<String> showSource() throws AIRSException;
	public HashSet<String> showDestination() throws AIRSException;
	

}
