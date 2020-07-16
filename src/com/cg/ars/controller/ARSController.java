package com.cg.ars.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.ars.entity.BookingInformation;
import com.cg.ars.entity.Flight;
import com.cg.ars.entity.User;
import com.cg.ars.exception.AIRSException;
import com.cg.ars.service.IBookingInformationService;
import com.cg.ars.service.IFlightService;
import com.cg.ars.service.IUserService;

/*****************************************************************************************************************************
 * @author       : Team1
 * File Name     : ARSController.java
 * Package       : com.cg.ars.controller
 * Description   : Controller which handles the user request and navigate to respective jsp pages.
 ********************************************************************************************************************************/

@Controller
public class ARSController {

	@Autowired
	IUserService iUserService;
	@Autowired
	IBookingInformationService iBookingInformationService;
	@Autowired
	IFlightService iFlightService;

	ModelAndView mv = null;

	/************************************************************************************************************************************
	 * Method Name : index
	 * Description : This method will add Flight Object, sourceList, destinationList and navigate the user to the ARS_User_HomePage page and to ARS_User_ErrorPage if any Exception is caught.
	 * Return Type : ModelAndView 
	 ***********************************************************************************************************************************/
	
	@RequestMapping("/")
	public ModelAndView index() 
	{

		try{
			HashSet<String> sourceList =iFlightService.showSource();
			HashSet<String> destinationList =iFlightService.showDestination();
			mv = new ModelAndView("ARS_User_HomePage");
			mv.addObject("flight", new Flight());
			mv.addObject("sourceList", sourceList);
			mv.addObject("destinationList", destinationList);
		}
		catch(AIRSException airsException)
		{
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			return mv;
		}
		
		return mv;

	}

	/************************************************************************************************************************************
	 * Method Name : home
	 * Description : This method will navigate the user to the ARS_User_HomePage page and to ARS_User_ErrorPage if any Exception is caught.
	 * Return Type : ModelAndView 
	 ***********************************************************************************************************************************/
	
	@RequestMapping("/mainHome")
	public ModelAndView home()
	{

		try{
			HashSet<String> sourceList =iFlightService.showSource();
			HashSet<String> destinationList =iFlightService.showDestination();
			mv = new ModelAndView("ARS_User_HomePage");
			mv.addObject("flight", new Flight());
			mv.addObject("sourceList", sourceList);
			mv.addObject("destinationList", destinationList);
		}
		catch(AIRSException airsException)
		{
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			return mv;
		}
		return mv;
	}

	/************************************************************************************************************************************
	 * Method Name : mainLogin
	 * Description : This method will add User Object and navigate the user to the ARS_User_Login page.
	 * Return Type : ModelAndView 
	 ***********************************************************************************************************************************/
	
	@RequestMapping("/mainLogin")
	public ModelAndView mainLogin()
	{

		mv = new ModelAndView("ARS_User_Login");
		mv.addObject("user", new User());
		return mv;
	}
	
	/************************************************************************************************************************************
	 * Method Name : about
	 * Description : This method will navigate the user to the ARS_User_AboutUs.
	 * Return Type : ModelAndView 
	 ***********************************************************************************************************************************/
	
	@RequestMapping("/aboutUs")
	public ModelAndView about()
	{
		return new ModelAndView("ARS_User_AboutUs");
	}
	
	/************************************************************************************************************************************
	 * Method Name : register
	 * Description : This method will add User Object, userExist and navigate the user to the ARS_User_Register page.
	 * Return Type : ModelAndView 
	 ***********************************************************************************************************************************/
	
	@RequestMapping("/register")
	public ModelAndView register()
	{

		mv = new ModelAndView("ARS_User_Register");
		mv.addObject("user", new User());
		mv.addObject("userExist", false);
		return mv;
	}

	/************************************************************************************************************************************
	 * Method Name : registerSearch
	 * Description : This method will bind flightNo, type, noOfSeats, userExist, user Object and navigate user to ARS_User_Login page.
	 * Return Type : ModelAndView 
	 * @param      : @RequestParam("flightNo") 
	 * @param      : @RequestParam("type") 
	 * @param      : @RequestParam("noOfSeats")
	 ***********************************************************************************************************************************/
	
	@RequestMapping("/registerSearch")
	public ModelAndView registerSearch(@RequestParam("flightNo") int flightNo,@RequestParam("type") String type,@RequestParam("noOfSeats") int noOfSeats)
	{

		mv = new ModelAndView("ARS_User_Register");
		mv.addObject("user", new User());
		mv.addObject("userExist", false);
		mv.addObject("flightNo", flightNo);
		mv.addObject("type", type);
		mv.addObject("noOfSeats",noOfSeats);
		return mv;
	}
	
	/************************************************************************************************************************************
	 * Method Name : confirmRegister
	 * Description : 1. This method will navigate the user to the ARS_User_Register page.
	                 2. To ARS_User_RegisterSuccess if user is registered successfully.   
	                 3. To ARS_User_Register if username given already exists.
	                 4. To ARS_User_ErrorPage if any Exception occurs.
	 * Return Type : ModelAndView 
	 * @param      : @ModelAttribute("user") @Valid User user
	 * @param      : BindingResult result
	 ***********************************************************************************************************************************/
	
	@RequestMapping(value="/confirmRegister",method=RequestMethod.POST)
	public ModelAndView confirmRegister(@ModelAttribute("user") @Valid User user,BindingResult result){


		if(result.hasErrors()){
			mv=new ModelAndView("ARS_User_Register");
			return mv;

		}
		try {
			boolean uExist=iUserService.userExisting(user.getUsername());
			if(uExist)
			{
				mv=new ModelAndView("ARS_User_Register");
				mv.addObject("userExist", uExist);
				return mv;

			}
			else
			{
				user.setRole("USER");
				iUserService.addUser(user);
				return new ModelAndView("ARS_User_RegisterSuccess");
			}
		} catch (AIRSException airsException) {
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			return mv;
		}

	}
	
	/************************************************************************************************************************************
	 * Method Name : confirmRegisterSearch
	 * Description : 1. This method will navigate the user to the ARS_User_Register page while directly searching Flights.
	                 2. To ARS_User_RegisterSuccess if user is registered successfully.   
	                 3. To ARS_User_Register if username given already exists.
	                 4. To ARS_User_ErrorPage if any Exception occurs.
	 * Return Type : ModelAndView 
	 * @param      : @ModelAttribute("user") @Valid User user
	 * @param      : BindingResult result
	 * @param      : @RequestParam("flightNo") 
	 * @param      : @RequestParam("type") 
	 * @param      : @RequestParam("noOfSeats")
	 ***********************************************************************************************************************************/
	
	@RequestMapping(value="/confirmRegisterSearch",method=RequestMethod.POST)
	public ModelAndView confirmRegisterSearch(@ModelAttribute("user") @Valid User user,BindingResult result,
			@RequestParam("flightNo") int flightNo,@RequestParam("type") String type,@RequestParam("noOfSeats") int noOfSeats){


		if(result.hasErrors()){
			mv=new ModelAndView("ARS_User_Register");
			return mv;

		}
		try {
			boolean uExist=iUserService.userExisting(user.getUsername());
			if(uExist)
			{
				mv=new ModelAndView("ARS_User_Register");
				mv.addObject("userExist", uExist);
				return mv;

			}
			else
			{
				user.setRole("USER");
				iUserService.addUser(user);
				mv = new ModelAndView("ARS_User_Login");
				mv.addObject("flightNo", flightNo);
				mv.addObject("type", type);
				mv.addObject("noOfSeats",noOfSeats);
				mv.addObject("msg","Registration Success!! Login to Continue.");
				return mv;
			}
		} catch (AIRSException airsException) {
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			return mv;
		}

	}

	/************************************************************************************************************************************
	 * Method Name : beforeLogin
	 * Description : This method will bind flightNo, type, noOfSeats, user Object and navigate user to ARS_User_Login page.
	 * Return Type : ModelAndView 
	 * @param      : @RequestParam("flightNo") 
	 * @param      : @RequestParam("type") 
	 * @param      : @RequestParam("noOfSeats")
	 ***********************************************************************************************************************************/
	
	@RequestMapping("/beforeLogin")
	public ModelAndView beforeLogin(@RequestParam("flightNo") int flightNo,@RequestParam("type") String type,@RequestParam("noOfSeats") int noOfSeats)
	{

		mv = new ModelAndView("ARS_User_Login");
		mv.addObject("flightNo", flightNo);
		mv.addObject("type", type);
		mv.addObject("noOfSeats",noOfSeats);
		mv.addObject("user", new User());
		return mv;
	}

	/************************************************************************************************************************************
	 * Method Name : searchFlight
	 * Description : 1.This method will bind flights list, type,noOfSeats, flight Object and navigate the user to ARS_User_RetrieveFlights.
	                 2.If any exception occurs, this method navigates user to ARS_User_ErrorPage.
	 * Return Type : ModelAndView 
	 * @param      : @RequestParam("source")
	 * @param      : @RequestParam("destination")
	 * @param      : @RequestParam("departureDate")
	 * @param      : @RequestParam("classType")
	 * @param      : @RequestParam("numOfSeats")
	 ***********************************************************************************************************************************/
	
	@RequestMapping(value="/retrieveFlight")
	public ModelAndView searchFlight(@RequestParam("source") String source,@RequestParam("destination") String destination,
			@RequestParam("departureDate") String depDate, @RequestParam("classType") String type,@RequestParam("numOfSeats") int noOfSeats) 
	{

		try{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate lDate = LocalDate.parse(depDate, formatter);
			Date departDate = Date.valueOf(lDate);
			List<Flight> flightList = iFlightService.showFlight(source,destination,departDate);
			mv = new ModelAndView("ARS_User_RetrieveFlights");
			mv.addObject("flights", flightList);
			mv.addObject("type", type);
			mv.addObject("noOfSeats",noOfSeats);
			mv.addObject("flight", new Flight());
		} catch (AIRSException|DateTimeParseException airsException) {
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			return mv;
		}
		
		return mv;
	}
	
	/************************************************************************************************************************************
	 * Method Name : loginSearchFlight
	 * Description : 1.This method will bind flights list, type,noOfSeats, flight Object and navigate the user to ARS_User_RetrieveFlights.
	                 2.If any exception occurs, this method navigates user to ARS_User_ErrorPage.
	 * Return Type : ModelAndView 
	 * @param      : @RequestParam("source")
	 * @param      : @RequestParam("destination")
	 * @param      : @RequestParam("departureDate")
	 * @param      : @RequestParam("classType")
	 * @param      : @RequestParam("numOfSeats")
	 * @param      : @RequestParam("username")
	 ***********************************************************************************************************************************/
	

	@RequestMapping(value="/loginRetrieveFlight")
	public ModelAndView loginSearchFlight(@RequestParam("source") String source,@RequestParam("destination") String destination,
			@RequestParam("departureDate") String depDate, @RequestParam("classType") String type,@RequestParam("numOfSeats") int noOfSeats,
			@RequestParam("username") String username) 
	{

		try{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate lDate = LocalDate.parse(depDate, formatter);
			Date departDate = Date.valueOf(lDate);
			List<Flight> flightList = iFlightService.showFlight(source,destination,departDate);
			mv = new ModelAndView("ARS_User_RetrieveFlights");
			mv.addObject("flights", flightList);
			mv.addObject("type", type);
			mv.addObject("noOfSeats",noOfSeats);
			mv.addObject("username", username);
			mv.addObject("flight", new Flight());
		} catch (AIRSException|DateTimeParseException airsException) {
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			mv.addObject("username", username);
			return mv;
		}
		return mv;
	}

	/************************************************************************************************************************************
	 * Method Name : bookTicket
	 * Description : 1.This method will bind bookingInformation Object, username and navigate the user to ARS_User_BookTicket.
	                 2.If any exception occurs, this method navigates user to ARS_User_ErrorPage.
	 * Return Type : ModelAndView 
	 * @param      : @RequestParam("flightNo")
	 * @param      : @RequestParam("type")
	 * @param      : @RequestParam("numOfSeats")
	 * @param      : @RequestParam("username")
	 ***********************************************************************************************************************************/
	
	@RequestMapping(value="/bookTicket")
	public ModelAndView bookTicket(@RequestParam("flightNo") int flightNo,@RequestParam("type") String type,@RequestParam("noOfSeats") int noOfSeats,
			@RequestParam("username") String username){

		try{
			Flight flight = iFlightService.showFlight(flightNo);
			BookingInformation bookingInformation = iBookingInformationService.addBooking(flight, noOfSeats, type, username);
			mv = new ModelAndView("ARS_User_BookTicket");
			mv.addObject("bookingInformation", bookingInformation);
			mv.addObject("username", username);
		} catch (AIRSException airsException) {
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			mv.addObject("username", username);
			return mv;
		}
		return mv;
	}

	/************************************************************************************************************************************
	 * Method Name : confirmBooking
	 * Description : 1.This method will bind bookingInformation Object, username and navigate the user to ARS_User_BookTicket if any errors occur.
	                 2.If any exception occurs, this method navigates user to ARS_User_ErrorPage.
	                 3.This method will navigate to ARS_User_Success if booking is done successfully.
	 * Return Type : ModelAndView 
	 * @param      : @ModelAttribute("bookingInformation") @Valid BookingInformation bookingInformation
	 * @param      : @BindingResult result
	 * @param      : @RequestParam("username")
	 ***********************************************************************************************************************************/
	
	@RequestMapping(value="/confirmBooking",method=RequestMethod.POST)
	public ModelAndView confirmBooking(@ModelAttribute("bookingInformation") @Valid BookingInformation bookingInformation,BindingResult result,@RequestParam("username") String username)
	{

		if(result.hasErrors()){
			mv=new ModelAndView("ARS_User_BookTicket");
			mv.addObject("bookingInformation", bookingInformation);
			mv.addObject("username", username);
			return mv;

		}
		try
		{
			boolean ticketBooked = iBookingInformationService.addBooking(bookingInformation);
			if(ticketBooked){
				mv = new ModelAndView("ARS_User_Success");
				mv.addObject("successMessage","Booking");
				mv.addObject("username", username);
			}
		}
		catch (AIRSException airsException) {
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			mv.addObject("username", username);
			return mv;
		}
		return mv;
	}

	/************************************************************************************************************************************
	 * Method Name : loginSearch
	 * Description : 1.This method will bind flight Object, username, sourceList, destinationList and navigate the user to ARS_User_HomePage if credentials are valid.
	                 2.If any exception occurs, this method navigates user to ARS_User_ErrorPage.
	                 3.This method will navigate to ARS_User_Login if credentials are invalid.
	 * Return Type : ModelAndView 
	 * @param      : @ModelAttribute("user")
	 ***********************************************************************************************************************************/
	
	@RequestMapping(value="/loginSearch")
	public ModelAndView loginSearch(@ModelAttribute("user") User user)
	{
		try{
			if(iUserService.validateLogin(user.getUsername(),user.getPassword()))
			{
				HashSet<String> sourceList =iFlightService.showSource();
				HashSet<String> destinationList =iFlightService.showDestination();
				mv = new ModelAndView("ARS_User_HomePage");
				mv.addObject("flight", new Flight());
				mv.addObject("sourceList", sourceList);
				mv.addObject("destinationList", destinationList);
				mv.addObject("username", user.getUsername());
				return mv;
			}
			else 
			{
				mv = new ModelAndView("ARS_User_Login");	
				mv.addObject("message","Invalid Login credentials");
				return mv;
			}
		} catch (AIRSException airsException) {
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			mv.addObject("username", user.getUsername());
			return mv;
		}
	}

	/************************************************************************************************************************************
	 * Method Name : loginSearchHome
	 * Description : 1.This method will bind flight Object, username, sourceList, destinationList and navigate the user to ARS_User_HomePage.
	                 2.If any exception occurs, this method navigates user to ARS_User_ErrorPage.
	 * Return Type : ModelAndView 
	 * @param      : @RequestParam("uname")
	 ***********************************************************************************************************************************/
	
	@RequestMapping(value="/loginSearchHome")
	public ModelAndView loginSearchHome(@RequestParam("uname") String username) 
	{
		try{
			HashSet<String> sourceList =iFlightService.showSource();
			HashSet<String> destinationList =iFlightService.showDestination();
			mv = new ModelAndView("ARS_User_HomePage");
			mv.addObject("flight", new Flight());
			mv.addObject("sourceList", sourceList);
			mv.addObject("destinationList", destinationList);
			mv.addObject("username", username);
		}catch (AIRSException airsException) {
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			mv.addObject("username", username);
			return mv;
		}
		return mv;	
	}

	/************************************************************************************************************************************
	 * Method Name : showBookings
	 * Description : 1.This method will bind username, bookings and navigate the user to ARS_User_ShowBookings.
	                 2.If any exception occurs, this method navigates user to ARS_User_ErrorPage.
	 * Return Type : ModelAndView 
	 * @param      : @RequestParam("uname")
	 ***********************************************************************************************************************************/
	
	@RequestMapping(value="/showBookings")
	public ModelAndView showBookings(@RequestParam("uname") String username) 
	{
		try{
			List<BookingInformation> bookings = iBookingInformationService.showBookings(username);
			mv = new ModelAndView("ARS_User_ShowBookings");
			mv.addObject("username", username);
			mv.addObject("bookings", bookings);
		}catch (AIRSException airsException) {
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			mv.addObject("username", username);
			return mv;
		}
		return mv;

	}

	/************************************************************************************************************************************
	 * Method Name : login
	 * Description : 1.This method will bind username, bookingInformation Object and navigate the user to ARS_User_BookTicket.
	                 2.If any exception occurs, this method navigates user to ARS_User_ErrorPage.
	                 3.This method will navigate to ARS_User_Login if credentials are invalid.
	 * Return Type : ModelAndView 
	 * @param      : @ModelAttribute("user")
	 * @param      : @RequestParam("flightNo")
	 * @param      : @RequestParam("type")
	 * @param      : @RequestParam("noOfSeats")
	 ***********************************************************************************************************************************/
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") User user,
			@RequestParam("flightNo") int flightNo,@RequestParam("type") String type,@RequestParam("noOfSeats") int noOfSeats) 
	{

		try{
		if(iUserService.validateLogin(user.getUsername(),user.getPassword()))
		{

			Flight flight = iFlightService.showFlight(flightNo);

			BookingInformation bookingInformation = iBookingInformationService.addBooking(flight, noOfSeats, type,user.getUsername());
			mv = new ModelAndView("ARS_User_BookTicket");
			mv.addObject("bookingInformation", bookingInformation);
			mv.addObject("username", user.getUsername());
			return mv;
		}
		else 
		{
			mv = new ModelAndView("ARS_User_Login");	
			mv.addObject("message","Invalid Login credentials");
			return mv;
		}
		}catch (AIRSException airsException) {
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			mv.addObject("username", user.getUsername());
			return mv;
		}
	}

	/************************************************************************************************************************************
	 * Method Name : cancel
	 * Description : This method will bind username, bookingId and navigate the user to ARS_User_CancelTicket.
	 * Return Type : ModelAndView 
	 * @param      : @RequestParam("bId")
	 * @param      : @RequestParam("uname")
	 ***********************************************************************************************************************************/
	
	@RequestMapping(value="/cancel")
	public ModelAndView cancel(@RequestParam("bId") int bookingId,@RequestParam("uname") String username,@RequestParam("noOfPassengers") String noOfPassengers)
	{
		mv = new ModelAndView("ARS_User_CancelTicket");
		mv.addObject("bookingId", bookingId);
		mv.addObject("username", username);
		mv.addObject("noOfPassengers", noOfPassengers);
		return mv;
	}

	/************************************************************************************************************************************
	 * Method Name : confirmCancel
	 * Description : 1.This method will bind username, successmessage and navigate the user to ARS_User_Success if cancellation is success.
	                 2.If any exception occurs, this method navigates user to ARS_User_ErrorPage.
	                 3.This method will bind bookings navigate to ARS_User_ShowBookings if cancellation is not done.
	 * Return Type : ModelAndView 
	 * @param      : @RequestParam("bookingId")
	 * @param      : @RequestParam("username")
	 ***********************************************************************************************************************************/
	
	@RequestMapping(value="/confirmCancel",method=RequestMethod.POST)
	public ModelAndView confirmCancel(@RequestParam("bookingId") int bookingId,@RequestParam("username") String username, @RequestParam("noOfPassengers") String noOfPassengers)
	{
		try {
			
			boolean ticketCancelled = iBookingInformationService.cancelBooking(bookingId,noOfPassengers);
			if(ticketCancelled)
			{
				mv = new ModelAndView("ARS_User_Success");
				mv.addObject("username", username);
				mv.addObject("successMessage","Cancellation");
			}
			else
			{
				List<BookingInformation> bookings = iBookingInformationService.showBookings(username);
				mv = new ModelAndView("ARS_User_ShowBookings");
				mv.addObject("bookings", bookings);
			}
		} catch (AIRSException airsException) {
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			mv.addObject("username", username);
			return mv;
		}
		return mv;
	}

	/************************************************************************************************************************************
	 * Method Name : update
	 * Description : 1.This method will bind username, bookingInformation and navigate the user to ARS_User_UpdateTicket.
	                 2.If any exception occurs, this method navigates user to ARS_User_ErrorPage.
	 * Return Type : ModelAndView 
	 * @param      : @RequestParam("bId")
	 * @param      : @RequestParam("uname")
	 ***********************************************************************************************************************************/
	
	@RequestMapping(value="/update")
	public ModelAndView update(@RequestParam("bId") int bookingId, @RequestParam("uname") String username) 
	{
		try{
		BookingInformation bookingInformation = iBookingInformationService.showBooking(bookingId);
		mv = new ModelAndView("ARS_User_UpdateTicket");
		mv.addObject("booking", bookingInformation);
		mv.addObject("username", username);
		}catch (AIRSException airsException) {
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			mv.addObject("username", username);
			return mv;
		}
		return mv;
	}

	/************************************************************************************************************************************
	 * Method Name : confirmUpdate
	 * Description : 1.This method will bind username, successmessage and navigate the user to ARS_User_Success if updation is success.
	                 2.If any exception occurs, this method navigates user to ARS_User_ErrorPage.
	 * Return Type : ModelAndView 
	 * @param      : @ModelAttribute("booking")
	 ***********************************************************************************************************************************/
	
	@RequestMapping(value="/confirmUpdate",method=RequestMethod.POST)
	public ModelAndView confirmUpdate(@ModelAttribute("booking") @Valid BookingInformation bookingInformation, BindingResult result){
		
		if(result.hasErrors())
		{
			mv = new ModelAndView("ARS_User_UpdateTicket");
			mv.addObject("booking", bookingInformation);
			mv.addObject("username", bookingInformation.getUsername());
			return mv;
		}
		
		try{
			iBookingInformationService.updateBooking(bookingInformation);
			mv = new ModelAndView("ARS_User_Success");
			mv.addObject("username",bookingInformation.getUsername());
			mv.addObject("successMessage","Updation");
		}catch (AIRSException airsException) {
			mv = new ModelAndView("ARS_User_ErrorPage");
			mv.addObject("errorMessage",airsException.getMessage());
			mv.addObject("username",bookingInformation.getUsername());
			return mv;
		}
		return mv;
	}

}

