package com.resume.exceptions;

public class InternalServerErrorException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InternalServerErrorException() {
        super("Internal Server Error.");
    }

    public InternalServerErrorException(String message) {
        super(message);
    }

}
