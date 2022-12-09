package com.example.todolist7.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todolist7.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo,String> {	
	Optional<Todo> findById(String name);
}