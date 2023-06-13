package com.green.todoapp;

import com.green.todoapp.model.TodoEntity;
import com.green.todoapp.model.TodoInsDto;
import com.green.todoapp.model.TodoVo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)  //@WebMvcTest 비슷함
@Import({TodoService.class})
class TodoServiceTest {

    @MockBean
    private TodoMapper mapper;

    @Autowired
    private TodoService service;


    @Test
    void insTodo() {
        when(mapper.insTodo(any(TodoEntity.class))).thenReturn(1L);

        TodoInsDto dto = new TodoInsDto();
        dto.setCtnt("내용 입력");
        Long result = service.insTodo(dto);

        assertEquals(null, result);

        verify(mapper).insTodo(any(TodoEntity.class));
    }

    @Test
    void selTodo() {
        //given
        List<TodoVo> list = new ArrayList<>();
        list.add(new TodoVo(12L,"내용","2077",null, 1, "2023-06-13"));
        list.add(new TodoVo(12L,"내용","2007","abc.jpg",0,null));

        //when
        when(mapper.selTodo()).thenReturn(list);
        List<TodoVo> list1 = service.selTodo();

        //then
        assertEquals(list1, list);
        verify(mapper).selTodo();
    }
}