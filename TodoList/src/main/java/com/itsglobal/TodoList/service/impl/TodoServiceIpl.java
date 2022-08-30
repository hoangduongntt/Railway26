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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceIpl implements TodoService {
    public static List<Todo> todoDeleteList = new ArrayList<>();
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private ModelMapper modelMapper;
    public List<Todo> getAllTodo() {
        return todoRepository.findAllAndDeleteFlag(Constants.DELETE_FALSE);
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
            Todo todo =  new Todo();
            todo.setId(todoDelete.get().getId());
            todo.setDescription(todoDelete.get().getDescription());
            todo.setTaskName(todoDelete.get().getTaskName());
            todo.setDeleteFlag(true);
            todoRepository.save(todo);
            return new ApiResponse(Constants.HTTP_CODE_200, Constants.DELETE_SUCCESS, "");
        }
    }

    @Override
    public List<Todo> getDeleteTodoList() {return todoRepository.findAllAndDeleteFlag(Constants.DELETE_TRUE);
    }

    public List<Todo> findTodoByName(String name ) {
        List<Todo> todos = todoRepository.findByTaskName(name, Constants.DELETE_FALSE );
        return  todos;
    }

    public List<Todo> findDeletedByName(String name ) {
        List<Todo> todos = todoRepository.findByTaskName(name, Constants.DELETE_TRUE );
        return  todos;
    }
}
