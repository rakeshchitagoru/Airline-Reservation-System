package com.cg.ars.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*****************************************************************
 *@author      : Team 1
 *Package      : com.cg.ars.entity
 *Class Name   : Flight
 *Description  : This is a POJO class which provides getters and setters for Flight
 ******************************************************************/

@Entity
public class Flight {
	
	@Id
	@Column(name="flight_no")
	private int flightno;
	
	private String airline;
	private String source;
	private String destination;
	@Column(name="arr_Date")
	private Date arrDate;
	@Column(name="dep_Date")
	private Date depDate;
	@Column(name="arr_time")
	public Time arrTime;
	@Column(name="dep_time")
	public Time depTime;
	@Column(name="first_seats")
	private int firstSeats;
	@Column(name="first_seats_left")
	private int firstSeatLeft;
	@Column(name="first_seats_fare")
	private long firstSeatFare;
	@Column(name="buss_seats")
	private int bussSeats;
	@Column(name="buss_seats_left")
	private int bussSeatLeft;
	@Column(name="buss_seats_fare")
	private long bussSeatFare;
	
	/****************************************************************** 
	 * Getter and Setter Methods for Flight
	 ******************************************************************/
		
	public Time getArrTime() {
		return arrTime;
	}
	public void setArrTime(Time arrTime) {
		this.arrTime = arrTime;
	}
	public Time getDepTime() {
		return depTime;
	}
	public void setDepTime(Time depTime) {
		this.depTime = depTime;
	}
	
	public int getFirstSeatLeft() {
		return firstSeatLeft;
	}
	public void setFirstSeatLeft(int firstSeatLeft) {
		this.firstSeatLeft = firstSeatLeft;
	}
	public int getBussSeatLeft() {
		return bussSeatLeft;
	}
	public void setBussSeatLeft(int bussSeatLeft) {
		this.bussSeatLeft = bussSeatLeft;
	}
	public int getFlightno() {
		return flightno;
	}
	public void setFlightno(int flightno) {
		this.flightno = flightno;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getArrDate() {
		return arrDate;
	}
	public void setArrDate(Date arrDate) {
		this.arrDate = arrDate;
	}
	public Date getDepDate() {
		return depDate;
	}
	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}
	public int getFirstSeats() {
		return firstSeats;
	}
	public void setFirstSeats(int firstSeats) {
		this.firstSeats = firstSeats;
	}
	public long getFirstSeatFare() {
		return firstSeatFare;
	}
	public void setFirstSeatFare(long firstSeatFare) {
		this.firstSeatFare = firstSeatFare;
	}
	public int getBussSeats() {
		return bussSeats;
	}
	public void setBussSeats(int bussSeats) {
		this.bussSeats = bussSeats;
	}
	public long getBussSeatFare() {
		return bussSeatFare;
	}
	public void setBussSeatFare(long bussSeatFare) {
		this.bussSeatFare = bussSeatFare;
	}
	
	

}