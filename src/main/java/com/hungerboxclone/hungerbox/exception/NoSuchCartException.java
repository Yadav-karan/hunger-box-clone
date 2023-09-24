package com.hungerboxclone.hungerbox.exception;

public class NoSuchCartException extends RuntimeException {

	public NoSuchCartException() {

	}

	public NoSuchCartException(String msg) {
		super(msg);
	}
}
