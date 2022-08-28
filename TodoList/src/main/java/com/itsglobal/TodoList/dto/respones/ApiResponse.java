package com.itsglobal.TodoList.dto.respones;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ApiResponse {
    private int status;
    private String message;
    private Object item;

    public ApiResponse (int status, String message, Object item) {
        this.status = status;
        this.message = message;
        this.item = item;
    }
}
