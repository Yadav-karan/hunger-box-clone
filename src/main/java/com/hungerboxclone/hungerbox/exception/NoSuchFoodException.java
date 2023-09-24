package com.hungerboxclone.hungerbox.exception;

public class NoSuchFoodException extends RuntimeException{

	public NoSuchFoodException() {
		
	}
	
	public NoSuchFoodException(String msg) {
		super(msg);
	}
}
