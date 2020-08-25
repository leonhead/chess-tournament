package com.leonhead.chessplan.exceptions;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5132606114196141233L;

	public EntityNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EntityNotFoundException(String arg0) {
		super(arg0);
	}

	public EntityNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
