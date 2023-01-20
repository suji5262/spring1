package org.zerock.springex.mapper;

import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll(); // 가장 최근에 등록된 TodoVO 가 우선적으로 출력되게

    TodoVO selectOne(Long no); // TodoMapper 조회기능 개발

    void delete(Long tno); // 삭제 기능

    void update(TodoVO todoVO); // 수정 기능

    List<TodoVO> selectList(PageRequestDTO pageRequestDTO); // PageRequestDTO 를 파라미터로 처리

    int getCount(PageRequestDTO pageRequestDTO);
    // 화면 페이지 번호들을 구성하기 위해 -> 전체 데이터의 수를 알아야됨
    // 나중에 검색을 대비해 PageRequestDTO를 파라미터로 받도록 처리
}
