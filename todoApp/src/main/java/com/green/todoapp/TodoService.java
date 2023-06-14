package com.green.todoapp;

import com.green.todoapp.model.*;
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

    public int insTodo(TodoInsDto dto) {
        TodoEntity entity = new TodoEntity();
        entity.setCtnt(dto.getCtnt());
        int result = mapper.insTodo(entity);
        System.out.println(result);
        if (result == 1) {
            return entity.getItodo();//itodo값
        }
        return 0;
    }

    public List<TodoVo> selTodo () {
        return mapper.selTodo();
    }

    public int updFinish(TodoFinishDto dto) {
        TodoEntity entity = new TodoEntity();
        entity.setItodo(dto.getItodo());

        int result = mapper.updFinish(entity);
        System.out.println(entity.getFinishYn());
        return entity.getFinishYn();
    }

    public int delTodo(int itodo) {
        TodoEntity entity = new TodoEntity();
        entity.setItodo(itodo);
        return mapper.delTodo(entity);
    }
}
