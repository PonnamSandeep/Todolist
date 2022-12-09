package com.example.todolist7.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist7.dto.TodoDTO;
import com.example.todolist7.entity.Todo;
import com.example.todolist7.repository.TodoRepository;
import com.example.todolist7.serviceexception.TodoException;

@Service
public  class TodoServiceImpl implements TodoService{
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public List<TodoDTO> getTodoList() throws TodoException{
		return TodoDTO.GetTodo(todoRepository.findAll().stream().collect(Collectors.toList()));
	}
	
	@Override
	public Todo getTodo(String name) throws TodoException{
		Optional<Todo> todo=todoRepository.findById(name);
		return todo.orElse(null);
	}
	
	@Override
	public Todo updateTodo(Todo todo) throws TodoException{
		if(todoRepository.findById(todo.getName()).equals(null)) {
			throw new TodoException("Service.cannot_add_task");
		}
		else {
			return todoRepository.save(todo);
		}
	}
	
	@Override
	public String addTodo(Todo todo) {
		if(!todoRepository.existsById(todo.getName())) {
			todoRepository.save(todo);
			return "Todo saved successfully";
		}
		else {
			return "Todo with given name already exists";
		}
	}
	
	@Override
	public boolean deteteTodo(String name)throws TodoException{
		boolean deleted=false;
		Optional<Todo> todo=todoRepository.findById(name);
		if(todo.isPresent()) {
			todoRepository.delete(todo.get());
			deleted=true;
		}
		return deleted;
		
	}
}