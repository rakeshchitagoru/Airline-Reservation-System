package com.cg.ars.service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ars.dao.IFlightDao;
import com.cg.ars.entity.Flight;
import com.cg.ars.exception.AIRSException;

/*****************************************************************************************************************************
 *@author       : Team 1
 * File Name    : FlightServiceImpl
 * Package Name : com.cg.ars.service
 * Description  : Implementation class of service layer which interacts with the data access layer and performs the appropriate operations.
 ********************************************************************************************************************************/

@Service("iFlightService")
@Transactional(rollbackFor=AIRSException.class)
public class FlightServiceImpl implements IFlightService{

	@Autowired
	IFlightDao iFlightDao;
	
	/****************************************************************************************************************************
	 * Method Name : showSource
	 * Description : Calls the getAirportList method of the data access layer and returns the result to the ARSController.
	 * Return Type : Hashset<String>
	 ****************************************************************************************************************************/

	@Override
	public HashSet<String> showSource() throws AIRSException
	{
		List<Flight> flightList=iFlightDao.getAirportList();
		HashSet<String> sources=new HashSet<String>();
		for(Flight flight:flightList)
		{
			sources.add(flight.getSource());
		}
		return sources;
	}
	
	/****************************************************************************************************************************
	 * Method Name : showDestination
	 * Description : Calls the getAirportList method of the data access layer and returns the result to the ARSController.
	 * Return Type : Hashset<String>
	 ****************************************************************************************************************************/

	@Override
	public HashSet<String> showDestination() throws AIRSException
	{
		List<Flight> flightList=iFlightDao.getAirportList();
		HashSet<String> destination=new HashSet<String>();
		for(Flight flight:flightList)
		{
			destination.add(flight.getDestination());
		}
		return destination;
	}

	/****************************************************************************************************************************
	 * Method Name : showFlight
	 * Description : Calls the showFlight method of the data access layer and returns the result to the ARSController.
	 * Return Type : List<Flight>
	 * @param      : String source
	 * @param      : String destination
	 * @param      : Date dep
	 ****************************************************************************************************************************/

	@Override
	public List<Flight> showFlight(String source, String destination,
			Date dep) throws AIRSException {
		
		return iFlightDao.showFlight(source, destination, dep);
	}

	/****************************************************************************************************************************
	 * Method Name : update
	 * Description : Calls the updateFlight method of the data access layer and returns the result to the ARSController.
	 * Return Type : void
	 * @param      : Flight flight
	 ****************************************************************************************************************************/

	@Override
	public void updateFlight(Flight flight) throws AIRSException {
		iFlightDao.updateFlight(flight);
	}

	/****************************************************************************************************************************
	 * Method Name : showFlight
	 * Description : Calls the showFlight method of the data access layer and returns the result to the ARSController. 
	 * Return Type : Flight
	 * @param      : int flightNo
	 ****************************************************************************************************************************/

	@Override
	public Flight showFlight(int flightNo) throws AIRSException {
		return iFlightDao.showFlight(flightNo);
	}


}
