package com.example.todolist7.serviceexception;


@SuppressWarnings("serial")
public class TodoException extends Exception {
	
	@SuppressWarnings("unused")
	private String message;
	public TodoException(String message) {
		super(message);
		this.message=message;
	}
	
	

}
