package com.itsglobal.TodoList.dto;

import lombok.Data;

@Data
public class TodoDto {
    private long id;
    private String taskName;
    private String description;
    private Boolean deleteFlag;
}
