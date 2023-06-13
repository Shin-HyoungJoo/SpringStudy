package com.green.todoapp;

import com.green.todoapp.model.TodoEntity;
import com.green.todoapp.model.TodoUpdDto;
import com.green.todoapp.model.TodoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    Long insTodo(TodoEntity entity);
    List<TodoVo> selTodo ();
    int updTodo(TodoUpdDto dto);
}
