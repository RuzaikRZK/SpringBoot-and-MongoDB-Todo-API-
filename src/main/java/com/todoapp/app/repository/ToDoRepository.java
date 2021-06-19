package com.todoapp.app.repository;

import com.todoapp.app.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends MongoRepository<ToDo,String> {

}
