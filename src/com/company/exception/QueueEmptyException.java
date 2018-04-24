package com.company.exception;


public class QueueEmptyException extends RuntimeException {
	
	public QueueEmptyException(String err) {
		super(err);
	}	
}
