package com.todoapp.app.controller;

import com.todoapp.app.model.ToDo;
import com.todoapp.app.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Todo")
public class TodoController {

    @Autowired
    ToDoService toDoService;

    @RequestMapping(value = "/createNewTodo", method = RequestMethod.POST)
    public ResponseEntity<?> createNewTodo(@RequestBody ToDo toDo){
        return toDoService.newTodo(toDo);
    }

    @RequestMapping(value = "/markTodoDone/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> markTodoAsDone(@PathVariable String id, @RequestBody ToDo toDo){
        return toDoService.markTodoDone(id, toDo);
    }

    @RequestMapping(value = "/removeTodo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeTodo(@PathVariable String id){
        return toDoService.removeTodo(id);
    }

    @RequestMapping(value = "/viewAllTodo", method = RequestMethod.GET)
    public ResponseEntity<?> viewAllTodo(){
        return toDoService.viewAllTodo();
    }
}
