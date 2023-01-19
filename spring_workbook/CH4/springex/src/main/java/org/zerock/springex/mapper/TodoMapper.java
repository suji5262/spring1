package org.zerock.springex.mapper;

import org.zerock.springex.domain.TodoVO;

import java.util.List;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll(); // 가장 최근에 등록된 TodoVO 가 우선적으로 출력되게

    TodoVO selectOne(Long no); // TodoMapper 조회기능 개발

    void delete(Long tno); // 삭제 기능

    void update(TodoVO todoVO); // 수정 기능
}
