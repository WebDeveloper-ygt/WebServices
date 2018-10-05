package com.learn.NewsApplication.exception;

public class BadRequestExcept extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadRequestExcept(String message) {
		super(message);
		
	}

	
}
