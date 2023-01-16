package org.zerock.jdbcex2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO { //

    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;


}
// TotoVO 와 완젆 간은 구조를 가지고 있으나 어노테이션에서 차이가 있음
// -> @Data 사용 (getter/setter/toString/equals/hashCode 등)