package com.example.todolist7.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist7.dto.TodoDTO;
import com.example.todolist7.entity.Todo;
import com.example.todolist7.service.TodoService;
import com.example.todolist7.serviceexception.TodoException;

@RestController
public class TodoController {
	

          
             @Autowired
             private TodoService todoService;
              
              @SuppressWarnings("unused")
			@Autowired
              private Environment environment;
              
              @GetMapping("/todo")
              public ResponseEntity<List<TodoDTO>> getTodoList() throws TodoException{
            	  return ResponseEntity.ok(todoService.getTodoList());
              }
              
              @GetMapping("/todo/{name}")
              public ResponseEntity<Todo> getTodo(@PathVariable("name")String name) throws TodoException {
            	  Todo todo = todoService.getTodo(name);
            	  return todo !=null?new ResponseEntity<>(todo,HttpStatus.OK)
            			  :new ResponseEntity<>(HttpStatus.NOT_FOUND);
              }
              
              @PostMapping("/todo")
              public String addTodo(@RequestBody Todo todo) throws TodoException  {
            	  return todoService.addTodo(todo);
              }

              @PutMapping("/todo")
              public Todo updateTodo(@RequestBody Todo todo) throws TodoException{
            	  return todoService.updateTodo(todo) ;
              }
              
			  @DeleteMapping("/todo/{name}")
			  public boolean deleteTodo(@PathVariable String name) throws TodoException{
				  return todoService.deteteTodo(name);               	
              }

             

}