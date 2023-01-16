package org.zerock.w2.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO { // 서비스 계층과 컨트롤러에서 사용

    private String mid;
    private String mpw;
    private String mname;
    private String uuid;


}
