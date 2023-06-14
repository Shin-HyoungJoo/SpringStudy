package com.green.todoapp;

import com.green.todoapp.model.TodoDelDto;
import com.green.todoapp.model.TodoEntity;
import com.green.todoapp.model.TodoVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@ActiveProfiles("test") //yaml 프로필 test의 세팅과 매핑
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoMapperTest {

    @Autowired
    private TodoMapper mapper;

    @Test
    void insTodo() {
        //given
        TodoEntity entity = new TodoEntity();

        entity.setCtnt("테스트");

        int result = mapper.insTodo(entity);

        System.out.println(entity.getItodo());
        assertEquals(4, entity.getItodo()); //다음 인서트되는 itodo값
        assertEquals(1, result);


    }

    @Test
    void selTodo() {
        List<TodoVo> list = mapper.selTodo();

        assertEquals(3,list.size());
        TodoVo vo = list.get(0);
        assertEquals(1,vo.getItodo());
        assertEquals("가", vo.getCtnt());

    }

    @Test
    void updFinish() {
        TodoEntity entity = new TodoEntity();
        entity.setItodo(1);

        int result = mapper.updFinish(entity);

        assertEquals(1,result);
    }

    @Test
    @DisplayName("TodoMapper - Todo 삭제")
    void delTodo() {
        int expectedResult = 1;
        TodoEntity entity = new TodoEntity();
        entity.setItodo(1);

        int actualResult = mapper.delTodo(entity);
        assertEquals(expectedResult, actualResult);
    }
}