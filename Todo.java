package com.example.todolist7.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todo")
public class Todo {
              @Column(name="name")
              @Id
              private String name;
              @Column(name="priority")
              private int priority;        

              @Column(name="expecteddate")
              private LocalDate date;
              
              public Todo() {
            	  super();
            	  
              }    
              public Todo(String name, int priority, LocalDate date) {
            	  super();
            	  this.name=name;
            	  this.priority=priority;
            	  this.date=date;
              }
              public String getName() {
               return name;

              }
              public void setName(String name) {
                 this.name=name;
              }
              public int getPriority() {
                return priority;
              }

              public void setPriority(int priority) {
                this.priority=priority;

              }
              public LocalDate getDate() {
                 return date;
              }

              public void setDate(LocalDate date) {
                 this.date=date;
              }
              @Override
              public String toString() {
            	  return "TodoDTO [name=" + name + ", priority= " + priority + ", date="+date + "]";
              }
}