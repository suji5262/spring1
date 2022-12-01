package org.zerock.jdbces.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter // 읽기전용, getTno(), getTitle()을 호출할 수 있음
@Builder // 객체 생성시 빌더 패턴을 이용하기 위해서, TodoVO.builder().build()와 같은 형태로 객체를 생성할 수 있음
@ToString
public class TodoVo {

    private Long ton;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
