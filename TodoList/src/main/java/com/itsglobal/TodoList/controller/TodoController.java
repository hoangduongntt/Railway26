package com.itsglobal.TodoList.controller;

import com.itsglobal.TodoList.common.Constants;
import com.itsglobal.TodoList.dto.respones.ApiResponse;
import com.itsglobal.TodoList.dto.TodoDto;
import com.itsglobal.TodoList.entity.Todo;
import com.itsglobal.TodoList.form.Request;
import com.itsglobal.TodoList.service.impl.TodoServiceIpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/v1")
@Validated
public class TodoController {
    @Autowired
    TodoServiceIpl todoServiceIpl;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<ApiResponse> getAllTodo(){
        List<Todo> todoList =  todoServiceIpl.getAllTodo();
        List<TodoDto> dtos = modelMapper.map(todoList, new TypeToken<List<Todo>>(){}.getType());
        return ResponseEntity.ok(new ApiResponse(Constants.HTTP_CODE_200, Constants.SUCCESS, dtos))  ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getTodoById(@PathVariable Long id){
        Todo todo = todoServiceIpl.getTodoById(id);
        TodoDto dto = modelMapper.map(todo, TodoDto.class);
        return ResponseEntity.ok(new ApiResponse(Constants.HTTP_CODE_200, Constants.SUCCESS,dto))  ;
    }

    @PostMapping("/insert")
    public ResponseEntity<ApiResponse>  addTodo(@RequestBody @Valid Request request) {
            return  ResponseEntity.ok().body(todoServiceIpl.createAndUpdateTodo(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteTodo(@PathVariable long id) {
        return  ResponseEntity.ok().body(todoServiceIpl.deleteTodo(id));
    }

    @GetMapping ("/search")
    public  ResponseEntity<ApiResponse>  getByTaskName(@RequestParam String name){
        List<Todo> todos = todoServiceIpl.findTodoByName(name);
        return ResponseEntity.ok(new ApiResponse(Constants.HTTP_CODE_200, Constants.SUCCESS,todos))  ;
    }
    @GetMapping ("/searchDeleted")
    public  ResponseEntity<ApiResponse>  getDeletedByName(@RequestParam String name){
        List<Todo> todos = todoServiceIpl.findDeletedByName(name);
        return ResponseEntity.ok(new ApiResponse(Constants.HTTP_CODE_200, Constants.SUCCESS,todos))  ;
    }
    @GetMapping ("/deletedList")
    public ResponseEntity<ApiResponse>  getDeleteTodoList(){
        List<Todo> deletedTodoList = todoServiceIpl.getDeleteTodoList();
        return ResponseEntity.ok(new ApiResponse(Constants.HTTP_CODE_200, Constants.SUCCESS,deletedTodoList))  ;
    }
}
