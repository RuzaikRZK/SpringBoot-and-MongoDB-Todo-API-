package com.todoapp.app.service;

import com.todoapp.app.model.ToDo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToDoService {
    ResponseEntity<?> newTodo(ToDo toDo);
    ResponseEntity<?> markTodoDone(String id,ToDo toDo);
    ResponseEntity<?> removeTodo(String id);
    ResponseEntity<?> viewAllTodo();
}
