package com.example.todolist7.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todolist7.dto.TodoDTO;
import com.example.todolist7.entity.Todo;
import com.example.todolist7.serviceexception.TodoException;

@RequestMapping
public interface TodoService {

 

              List<TodoDTO> getTodoList() throws TodoException;
              Todo getTodo(String name) throws TodoException;
              String addTodo(Todo todo) throws TodoException;
              Todo updateTodo(Todo todo) throws TodoException;              
			  boolean deteteTodo(String name) throws TodoException;
		

			





			




			






 

}