package com.keny.pager;

public class PageNotSupportException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PageNotSupportException() {
		super();
	}

	public PageNotSupportException(String message, Throwable cause) {
		super(message, cause);
	}

	public PageNotSupportException(String message) {
		super(message);
	}

	public PageNotSupportException(Throwable cause) {
		super(cause);
	}
}