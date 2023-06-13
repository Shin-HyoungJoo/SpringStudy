package com.green.todoapp;

import com.green.todoapp.model.TodoInsDto;
import com.green.todoapp.model.TodoVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any; //any
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//[클래스명.이름] 안하고 [이름(메소드)]만 쓰고싶을때 import static

@WebMvcTest(TodoController.class)//빈
class TodoControllerTest {

    @Autowired
    private MockMvc mvc;    // mvc = 테스트단에서 요청 보내줄 때 씀

    @MockBean   //Mock = 가짜, MockBeam = 가짜빈
    private TodoService service;    //가짜 service가 컨트롤러 service에 주입

    @Test
    @DisplayName("TODO - 등록")
    void postTodo() throws Exception {
        //given(환경설정) - when(데이터 값 가져옴) - then(검증) 패턴

        //given - 테스트 세팅 - 가짜 업무를 준다
        given(service.insTodo(any(TodoInsDto.class))).willReturn(3L);
        //Mockito 임포트
        //service.insTodo() 메서드가 호출되었을 때,
        //인자로 전달되는 TodoInsDto 객체의 타입은 중요하지 않고, 아무 객체나 전달될 수 있다 (any(TodoInsDto.class)),
        //이 메서드는 3L을 반환하도록 설정한다.

        //when - 실제 실행
        String json = "{\"ctnt\": \"빨래 개기\"}";

        ResultActions ra = mvc.perform(post("/api/todo")
                ///api의 todo 경로에 대해 HTTP POST 요청을 시뮬레이션하는 코드입니다.
                .content(json)  //내용은 json변수 안의 내용
                .contentType(MediaType.APPLICATION_JSON));  // 타입은 제이슨

        //then - 검증
        ra.andExpect(status().isOk())   //웹통신에서 ok는 200
                .andExpect(content().string("3"))
                .andDo(print());
        //.andExpect(status().isOk())는 HTTP 응답의 상태 코드가 200 (OK)인지를 검증하는 코드입니다.
        // 즉, 예상되는 응답 상태 코드가 200이어야 합니다.

        //.andExpect(content().string("3"))는 응답의 본문(content) 내용이 "3"인지를 검증하는 코드입니다.
        // 즉, 예상되는 응답 본문은 "3"이어야 합니다.

        //.andDo(print())은 테스트 실행 중에 요청 및 응답의 정보를 출력하는 코드입니다.
        // 따라서 테스트 실행 중에 요청 및 응답의 내용을 콘솔에 출력합니다.

        verify(service).insTodo(any()); //service의 insTodo메소드 실행됐는지 체크(검증)
    }

    @Test
    @DisplayName("TODO - 리스트")
    void getTodo() throws Exception {
        //given - when - then

        //given
        List<TodoVo> mockList = new ArrayList<>();
        mockList.add(new TodoVo(1L, "테스트", "2077", null,1,"2023-01-01"));
        mockList.add(new TodoVo(2L, "테스트2", "2077", "abc.jpg",0,"2023-11-11"));
        given(service.selTodo()).willReturn(mockList);

        //when
        ResultActions ra = mvc.perform(get("/api/todo"));

        //then
        ra.andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(mockList.size())))
                .andExpect(jsonPath("$[*].itodo").exists())//모든 배열(아이템 or 로우 or 데이터)에 존재하는지
                .andExpect(jsonPath("$[0].itodo").value(1)) //0번에 itodo가 1인지
                .andExpect(jsonPath("$[0].ctnt").value("테스트"))
                .andDo(print());

        verify(service).selTodo();
    }
}