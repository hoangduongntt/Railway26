package com.itsglobal.TodoList.entity;

import com.itsglobal.TodoList.common.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "todo")
@NoArgsConstructor
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private String taskName;

    @Column
    private String description;

    @Column
    private Boolean deleteFlag;

    public Todo(String taskName,  String description, Boolean deleteFlag) {
        this.taskName = taskName;
        this.description = description;
        this.deleteFlag =  deleteFlag;
    }
}
