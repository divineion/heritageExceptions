package com.divineion.utils.exceptions;
	/**
	 * This class represents a custom exception used to ensure that an input value is positive
	 */
@SuppressWarnings("serial")
public class PositiveIntegerValueRequiredException extends Exception {
	
	public PositiveIntegerValueRequiredException(String message) {
		super(message);
	}

}
