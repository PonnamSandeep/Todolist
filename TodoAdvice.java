package com.example.todolist7.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.todolist7.serviceexception.TodoException;

@Component
@ResponseBody
public class TodoAdvice {
	
	@ExceptionHandler(TodoException.class)
	public ResponseEntity<String> exhandler(TodoException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exhandler1(Exception e){
		return new ResponseEntity<String>("Internal error",HttpStatus.BAD_REQUEST);
	}
}