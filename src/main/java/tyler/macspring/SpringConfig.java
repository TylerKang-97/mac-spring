package tyler.macspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tyler.macspring.repository.MemberRepository;
import tyler.macspring.repository.MemoryMemberRepository;
import tyler.macspring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
