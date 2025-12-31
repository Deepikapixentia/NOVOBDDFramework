package com.novo.exceptions;

public class InvalidBrowserException extends RuntimeException {
	public  InvalidBrowserException() {
		super("InValidBrowserException, Select the valid browser");
		
	}
}
