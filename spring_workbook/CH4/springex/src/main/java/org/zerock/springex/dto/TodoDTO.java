package org.zerock.springex.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private Long tno;
    private String title;
    private LocalDate localDate;
    private boolean finished;
    private String writer;

}
