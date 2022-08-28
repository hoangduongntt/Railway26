package com.itsglobal.TodoList.service;

import com.itsglobal.TodoList.dto.respones.ApiResponse;
import com.itsglobal.TodoList.entity.Todo;
import com.itsglobal.TodoList.form.Request;

import java.util.List;

public interface TodoService {
    public List<Todo> getAllTodo();
    public Todo getTodoById(Long id);
    public ApiResponse createAndUpdateTodo (Request request);
    public ApiResponse deleteTodo (long id);

//    public Todo getTodoByTaskName(String name);
}
