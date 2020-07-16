package com.cg.ars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/*****************************************************************
 *@author      : Team 1
 *Package      : com.cg.ars.entity
 *Class Name   : BookingInformation
 *Description  : This is a POJO class which provides getters and setters for BookingInformation
 ******************************************************************/

@Entity
@Table(name="bookinginformation")
public class BookingInformation {

	@Id
	@SequenceGenerator(name="seq",sequenceName="seq_book_ticket",initialValue=101,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	@Column(name="booking_id")
	private int bookingId;
	
	@Column(name="flight_number")
	private int flightno;
	
	private String username;
	
	@Column(name="cust_email")
	@NotEmpty(message="Email Id cannot be empty")
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message="Not a valid email eg: abc@g.in")
	private String custEmail;
	
	@Column(name="no_of_passengers")
	private String noOfPassengers;
	
	@Column(name="class_type")
	private String classType;
	
	@Column(name="total_fare")
	private double totalFare;
	
	@Column(name="seat_number_start")
	private int seatNumberStart;
	
	@Column(name="seat_number_end")
	private int seatNumberEnd;
	
	@Column(name="creditcard_info")
	@NotEmpty(message="Credit card number cannot be empty")
	@Pattern(regexp="[1-9][0-9]{15}",message="Credit card number should not start with 0 and must be of 16 digits eg:9898656598986565")
	private String creditCardNumber;
	
	@Column(name="src_city")
	private String srcCity;
	
	@Column(name="dest_city")
	private String destCity;
	
	/****************************************************************** 
	 * Getter and Setter Methods for BookingInformation
	 ******************************************************************/
	
	public String getSrcCity() {
		return srcCity;
	}
	public void setSrcCity(String srcCity) {
		this.srcCity = srcCity;
	}
	public String getDestCity() {
		return destCity;
	}
	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}
	
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(String noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public int getSeatNumberStart() {
		return seatNumberStart;
	}
	public void setSeatNumberStart(int seatNumberStart) {
		this.seatNumberStart = seatNumberStart;
	}
	public int getSeatNumberEnd() {
		return seatNumberEnd;
	}
	public void setSeatNumberEnd(int seatNumberEnd) {
		this.seatNumberEnd = seatNumberEnd;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public int getFlightno() {
		return flightno;
	}
	public void setFlightno(int flightno) {
		this.flightno = flightno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}

