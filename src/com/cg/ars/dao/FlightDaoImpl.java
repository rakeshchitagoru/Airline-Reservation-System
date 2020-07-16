package com.cg.ars.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.cg.ars.entity.Flight;
import com.cg.ars.exception.AIRSException;

/*****************************************************************************************************************************
 *@author       : Team 1
 * File Name	: FlightDaoImpl.java
 * Package Name : com.cg.ars.dao
 * Description  : Implementation class of data access layer which interacts with the database and performs the appropriate operations.
 *****************************************************************************************************************************/

@Repository("iFlightDao")
public class FlightDaoImpl implements IFlightDao{

	@PersistenceContext
	EntityManager entityManager;
	
	static Logger mylogger = null;
	
	public FlightDaoImpl() {
		mylogger = Logger.getLogger("LoggingInterceptor.class");
	}

	/****************************************************************************************************************************
	 * Method Name : showFlight
	 * Description : Retrieves details of the flight for given conditions from the database and returns the data to the service layer. 
	 * Return Type : List<Flight>
	 * @param      : String source
	 * @param      : String destination
	 * @param      : Date dep
	 ****************************************************************************************************************************/

	@Override
	public List<Flight> showFlight(String source, String destination,Date dep) throws AIRSException {
		try{
		String showDestFlight = "SELECT flight FROM Flight flight WHERE flight.source=:source AND flight.destination=:destination AND flight.depDate=:depDate";
		TypedQuery<Flight> query = entityManager.createQuery(showDestFlight, Flight.class);
		query.setParameter("source", source);
		query.setParameter("destination", destination);
		query.setParameter("depDate", dep);
		mylogger.info("User viewed Flights");
		return query.getResultList();
		}
		catch(Exception e)
		{
			throw new AIRSException(e.getMessage());
		}
	}
	
	/****************************************************************************************************************************
	 * Method Name : getAirportList
	 * Description : Retrieves details of the flight from the database and returns the data to the service layer. 
	 * Return Type : List<Flight>
	 ****************************************************************************************************************************/

	@Override
	public List<Flight> getAirportList() throws AIRSException
	{
		try{
		String showAirports="SELECT flight FROM Flight flight";
		TypedQuery<Flight> query =entityManager.createQuery(showAirports,Flight.class);
		return query.getResultList();
		}catch(Exception e)
		{
			throw new AIRSException(e.getMessage());
		}
	}

	/****************************************************************************************************************************
	 * Method Name : update
	 * Description : updates the details of flight in Database. 
	 * Return Type : void
	 * @param      : Flight flight
	 ****************************************************************************************************************************/

	@Override
	public void updateFlight(Flight flight) throws AIRSException {
		try{
		entityManager.merge(flight);
		entityManager.flush();
		}catch(Exception e)
		{
			throw new AIRSException(e.getMessage());
		}
	}
	
	/****************************************************************************************************************************
	 * Method Name : showFlight
	 * Description : Retrieves flight details of given flight number from Database and pass the data to service layer. 
	 * Return Type : Flight
	 * @param      : int flightNo
	 ****************************************************************************************************************************/

	@Override
	public Flight showFlight(int flightNo) throws AIRSException {
		try{
		Flight flight = entityManager.find(Flight.class,flightNo);
		return flight;
		}catch(Exception e)
		{
			throw new AIRSException(e.getMessage());
		}
	}

}
