package tyler.macspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tyler.macspring.repository.*;
import tyler.macspring.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // private EntityManager em;

   /* @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    */

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /*
    @Bean
    public MemberRepository memberRepository() {
        //return new JdbcTemplateMemberRepository(dataSource);
       // return new JdbcMemberRepository(dataSource);
       // return new JpaMemberRepository(em);
    }
     */
}
