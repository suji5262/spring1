package hello.hello.spring;

import hello.hello.spring.aop.TimeTraceAop;
import hello.hello.spring.repository.*;
import hello.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//   /*
//   * jpa
//   * */
//    private final EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    /*
    *
    * */
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    /*
    * 스프링 jpa
    * */
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }

//    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
////        return new JDBCMemberRepository(dataSource);
//        // DB에 접근
//
////        return new JDBCTemplateMemberRepository(dataSource);
//
////        return new JpaMemberRepository(em); // jpa
//    }


    /*
     * aop 등록해서 쓰기
     */
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    } // bean 에 등록해서 써도됨


}
