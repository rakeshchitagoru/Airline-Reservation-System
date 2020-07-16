package com.cg.ars.exception;


/*****************************************************************************************************************************
 * @author       : Team1
 * File Name     : ARSException.java
 * Package       : com.cg.ars.exception
 * Description   : AIRSException handles the exceptions and displays the corresponding error messages.
 ********************************************************************************************************************************/

public class AIRSException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public AIRSException() {
		super();
	}
	public AIRSException(String msg){
		super(msg);
		
	}
	
}
