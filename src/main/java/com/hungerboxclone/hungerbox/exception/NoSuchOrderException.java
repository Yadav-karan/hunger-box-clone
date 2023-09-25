package com.hungerboxclone.hungerbox.exception;

public class NoSuchOrderException extends RuntimeException {

	public NoSuchOrderException() {
		
	}

	public NoSuchOrderException(String msg) {
		super(msg);
	}
}
