package com.itsglobal.TodoList.service.impl;

import com.itsglobal.TodoList.common.Constants;
import com.itsglobal.TodoList.dto.respones.ApiResponse;
import com.itsglobal.TodoList.entity.Todo;
import com.itsglobal.TodoList.exceptions.RecordNotFoundException;
import com.itsglobal.TodoList.form.Request;
import com.itsglobal.TodoList.repository.TodoRepository;
import com.itsglobal.TodoList.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceIpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }
    public Todo getTodoById(Long id) {
        return todoRepository.findByIdAndDeleteFlag(id, Constants.DELETE_FALSE)
                .orElseThrow(() -> new RecordNotFoundException(Constants.RECORD_NOT_FOUND));
    }


    @Override
    public ApiResponse createAndUpdateTodo(Request request) {
        Todo todo = modelMapper.map(request , Todo.class);
        Optional<Todo> updateTodo = todoRepository.findById(request.getId());
        if (updateTodo.isEmpty()) {
            var todoUpdated = todoRepository.save(todo);
            return new ApiResponse(Constants.HTTP_CODE_200, Constants.CREATE_SUCCESS, todoUpdated);
        }else {
            updateTodo.get().setTaskName(todo.getTaskName());
            updateTodo.get().setDescription(todo.getDescription());
            updateTodo.get().setDeleteFlag(todo.getDeleteFlag());
            todoRepository.save(updateTodo.get());
            return new ApiResponse(Constants.HTTP_CODE_200, Constants.UPDATE_SUCCESS, request);
        }
    }

    @Override
    public ApiResponse deleteTodo(long id) {
        Optional<Todo> todoDelete = todoRepository.findById(id);
        if (todoDelete.isEmpty()) {
            throw new RecordNotFoundException(Constants.RECORD_NOT_FOUND);
        }else {
            todoRepository.deleteById(id);
            return new ApiResponse(Constants.HTTP_CODE_200, Constants.DELETE_SUCCESS, "");
        }
    }

//    @Override
//    public Todo getTodoByTaskName(String name) {
//        Todo todo = todoDao.getTodoByTaskName(name);
//        return  todo;
//    }

    public List<Todo> fingByTaskName(String name) {
        List<Todo> todos = todoRepository.findByTaskName(name);
        return  todos;
    }

}
