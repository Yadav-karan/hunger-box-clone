package com.hungerboxclone.hungerbox.exception;

public class NoSuchCustomerException extends RuntimeException{

	public NoSuchCustomerException(){
		
	}
	
	public NoSuchCustomerException(String msg) {
		super(msg);
	}

}
