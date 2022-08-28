package com.itsglobal.TodoList.config;

import com.itsglobal.TodoList.common.Constants;
import com.itsglobal.TodoList.dto.respones.ErrorResponse;
import com.itsglobal.TodoList.exceptions.RecordNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@SuppressWarnings({ "unchecked", "rawtypes" })
class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private Map<String, String> errors;

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(Constants.HTTP_CODE_404, new Date(),
                String.format(Constants.RECORD_NOT_FOUND, ex.getLocalizedMessage()), errors);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse(Constants.HTTP_CODE_400, new Date(), ex.getLocalizedMessage(), errors);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}