package com.todoapp.app;

import com.todoapp.app.model.ToDo;
import com.todoapp.app.service.ToDoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ToDoServiceTest {

    @Autowired
    ToDoService toDoService;

    @DisplayName("Test user can create Todo")
    @Test
    void testNewTodo(){
        ToDo sampleToDo = new ToDo();
        sampleToDo.setTitle("testTitle");
        sampleToDo.setDescription("testDescription");
        sampleToDo.setCompleteStatus(false);
        ResponseEntity exceptResponseEntity = new ResponseEntity("Todo Successfully Added !", HttpStatus.OK);
        assertEquals(exceptResponseEntity,toDoService.newTodo(sampleToDo));
    }

    @DisplayName("Test user can mark Todo as done, if id is present")
    @Test
    void testMarkTodoDoneIf_IDPrsenet(){

        ToDo samplToDo = new ToDo();
        samplToDo.setCompleteStatus(true);
        ResponseEntity exceptResponseEntity = new ResponseEntity("Todo Mark as Done !",HttpStatus.OK);
        assertEquals(exceptResponseEntity,toDoService.markTodoDone("60ccadae8805b7471cc1d3a8",samplToDo));

    }

    @DisplayName("Test user can't mark Todo as done, if id is not present")
    @Test
    void testMarkTodoDoneIf_IDNotPrsenet(){

        ToDo samplToDo = new ToDo();
        samplToDo.setCompleteStatus(true);
        ResponseEntity exceptResponseEntity = new ResponseEntity("Todo ID Not Found ! :"+"60ccadae88",HttpStatus.NOT_FOUND);
        assertEquals(exceptResponseEntity,toDoService.markTodoDone("60ccadae88",samplToDo));

    }

    @DisplayName("Test user can remove Todo, if id is present")
    @Test
    void testRemoveTodoIf_IDPresent(){
        ResponseEntity exceptResponseEntity = new ResponseEntity("Todo Deleted Successfully !",HttpStatus.OK);
        assertEquals(exceptResponseEntity,toDoService.removeTodo("60ccaf02a540ea40e5789c70"));
    }

    @DisplayName("Test user can't remove Todo, if id is not present")
    @Test
    void testRemoveTodoIf_IDNotPresent(){
        ResponseEntity exceptResponseEntity = new ResponseEntity("Delete Unsuccess Todo Id not found"+"60ccaf02a540e",HttpStatus.NOT_FOUND);
        assertEquals(exceptResponseEntity,toDoService.removeTodo("60ccaf02a540e"));
    }





}
