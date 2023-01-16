package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex2.dao.TodoDAO;
import org.zerock.jdbcex2.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception { // 현재 시간을 출력하는 test
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testInsert() throws Exception { // 데이터 추가
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2023, 1, 15))
                .build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void testList() throws Exception { // 모든 데이터 조회
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception { // 특정한 데이터 조회

        Long tno = 1L; // tno 1인 데이터 조회
        // 반드시 존재하는 번호를 이용

        TodoVO vo = todoDAO.selectOne(tno);
        System.out.println(vo);
    }

    @Test
    public void testUpdateOne() throws Exception { // 수정
        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("Sample Title...")
                .dueDate(LocalDate.of(2023, 1, 15))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);
    }



}
