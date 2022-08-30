package com.itsglobal.TodoList.form;

import com.itsglobal.TodoList.common.Constants;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Request {

    private Long id;
    @NotBlank(message = Constants.VALIDATE_THE_FIELD)
    private String taskName;
    private String description;
    private Boolean deleteFlag;
}
