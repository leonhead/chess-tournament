package com.leonhead.chessplan.exceptions;

public class EntityDuplicateException extends RuntimeException {

	private static final long serialVersionUID = -1238392006792408411L;

	public EntityDuplicateException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EntityDuplicateException(String arg0) {
		super(arg0);
	}

	public EntityDuplicateException(Throwable arg0) {
		super(arg0);
	}
}
