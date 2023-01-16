package org.zerock.w2.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoVO { // VO 는 '읽기전용' 으로 사용하는 경우 많음


    private Long tno; // 번호
    private String title; // 데이터 제목
    private LocalDate dueDate; // 만료일
    private boolean finished; // 완료 여부

}
// DB 내에 생성한 tbl_todo 테이블의 칼럼들을 기준으로 작성
// 객체 생성시 Builder 패턴을 이용하기 위해 어노테이션 추가