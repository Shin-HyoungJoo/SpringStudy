package com.green.todoapp;

import com.green.todoapp.model.*;
import org.junit.jupiter.api.DisplayName;
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
import static org.mockito.ArgumentMatchers.anyInt;
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
        when(mapper.insTodo(any(TodoEntity.class))).thenReturn(1);

        TodoInsDto dto = new TodoInsDto();
        dto.setCtnt("내용 입력");
        int result = service.insTodo(dto);

        assertEquals(0, result);

        verify(mapper).insTodo(any(TodoEntity.class));
    }

    @Test
    void selTodo() {
        //given
        List<TodoVo> list = new ArrayList<>();
        list.add(new TodoVo(12,"내용","2077",null, 1, "2023-06-13"));
        list.add(new TodoVo(12,"내용","2007","abc.jpg",0,null));

        //when
        when(mapper.selTodo()).thenReturn(list);
        List<TodoVo> list1 = service.selTodo();

        //then
        assertEquals(list1, list);
        verify(mapper).selTodo();
    }

    @Test
    @DisplayName("TodoService - Todo 완료처리 토글")
    void updFinish() {
        TodoFinishDto dto = new TodoFinishDto();
        dto.setItodo(1);

        when(mapper.updFinish(any())).thenReturn(1);
        int result = service.updFinish(dto);

        assertEquals(0, result);
        verify(mapper).updFinish(any());
    }

    @Test
    @DisplayName("TodoService - 삭제")
    void delTodo() {
       int expectedResult = 1;

        when(mapper.delTodo(any(TodoEntity.class))).thenReturn(expectedResult);

        int result = service.delTodo(anyInt());
        assertEquals(expectedResult, result);

        verify(mapper).delTodo(any(TodoEntity.class));
    }
}