package com.example.todolist7.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.todolist7.entity.Todo;

public class TodoDTO {
              private  String name;
              private int priority;
              private LocalDate date;


              public String getName() {
                   return name;
              }

              public void setName(String name) {
                   this.name = name;
              }

              public int getPriority() {
                    return priority;
              }

              public void setPriority(int priority) {
                    this.priority = priority;
              }

              public LocalDate getDate() {
                     return date;
              }

              public void setDate(LocalDate date) {
                     this.date = date;
              }

              @Override
              public String toString() {
                   return "TodoDTO [name=" +  name  + ", priority=" + priority + ", date=" + date + "]";
              }

             

              public static   List<TodoDTO> GetTodo(List<Todo> todo){
                     List<TodoDTO> todoList=new ArrayList<>();
                     for(Todo i:todo) {
                          TodoDTO todo1=new TodoDTO();
                          todo1.setName(i.getName());
                          todo1.setPriority(i.getPriority());
                          todo1.setDate(i.getDate());
                          todoList.add(todo1);
                  }
                            return todoList;
              }

 

}