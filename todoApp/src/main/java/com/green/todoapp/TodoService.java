package com.green.todoapp;

import com.green.todoapp.model.TodoEntity;
import com.green.todoapp.model.TodoInsDto;
import com.green.todoapp.model.TodoUpdDto;
import com.green.todoapp.model.TodoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoMapper mapper;

    @Autowired
    public TodoService(TodoMapper mapper) {
        this.mapper = mapper;
    }

    public Long insTodo(TodoInsDto dto) {
        TodoEntity entity = new TodoEntity();
        entity.setCtnt(dto.getCtnt());
        Long result = mapper.insTodo(entity);
        System.out.println(result);
        if (result == 1L) {
            return entity.getItodo();//itodo값
        }
        return 0L;
    }

    public List<TodoVo> selTodo () {
        return mapper.selTodo();
    }

    public Long updTodo(TodoUpdDto dto) {
        mapper.updTodo(dto);
        return null;
    }
}
