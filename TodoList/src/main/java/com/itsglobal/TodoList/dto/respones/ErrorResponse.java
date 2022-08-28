package com.itsglobal.TodoList.dto.respones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private Integer status;
    private Date timestamp;
    private String error;
    private Map<String, String> mess;
}
