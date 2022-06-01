package com.fsoft.exeptionHandle;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;


@RestControllerAdvice
public class ApiExceptionHandle extends ResponseEntityExceptionHandler {

    /**
     * NoSuchElementException sẽ được xử lý riêng tại đây
     */
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage NotFoundException(Exception ex, WebRequest request) {
        return new ErrorMessage(404, "Not Found, please check again!");
    }
    /**
     * ConstraintViolationException sẽ được xử lý riêng tại đây
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleConstraintViolationException(Exception ex, WebRequest request) {
        return new ErrorMessage(400, "Constraint, please check again!");
        }



}
