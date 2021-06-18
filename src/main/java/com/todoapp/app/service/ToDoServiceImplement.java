package com.todoapp.app.service;

import com.todoapp.app.model.ToDo;
import com.todoapp.app.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImplement implements ToDoService{

    @Autowired
    ToDoRepository toDoRepository;

    @Override
    public ResponseEntity<?> newTodo(ToDo toDo) {
        try {
            toDo.setCreatedDate(dateFormatter("dd-MM-yyyy"));
            toDoRepository.save(toDo);
            return new ResponseEntity<>("Todo Successfully Added !", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> markTodoDone(String id, ToDo toDo) {
        Optional<ToDo>  optionalToDo = toDoRepository.findById(id);
        if(optionalToDo.isPresent()){
            ToDo getOptionalTodo = optionalToDo.get();
            getOptionalTodo.setCompleteStatus(toDo.isCompleteStatus());
            getOptionalTodo.setTitle(getOptionalTodo.getTitle());
            getOptionalTodo.setDescription(getOptionalTodo.getDescription());
            getOptionalTodo.setCreatedDate(getOptionalTodo.getCreatedDate());
            getOptionalTodo.setEndDate(dateFormatter("dd-MM-yyyy"));
            toDoRepository.save(getOptionalTodo);
            return new ResponseEntity<>("Todo Mark as Done !",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Todo ID Not Found ! :"+id,HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> removeTodo(String id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        if(optionalToDo.isPresent()){
            toDoRepository.deleteById(id);
            return new ResponseEntity<>("Todo Deleted Successfully !",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Delete Unsuccess Todo Id not found"+id,HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> viewAllTodo() {
        List<ToDo> todoList = new ArrayList<>();
        todoList = toDoRepository.findAll();
        if(todoList.isEmpty()){
            return  new ResponseEntity<>("Data Not Available !",HttpStatus.NOT_FOUND);
        }else{
            return  new ResponseEntity<>(todoList,HttpStatus.OK);
        }

    }

    String dateFormatter(String pattern){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern(pattern);
        String formattedDate = localDateTime.format(dateTimeFormatter);
        return formattedDate;
    }
}
