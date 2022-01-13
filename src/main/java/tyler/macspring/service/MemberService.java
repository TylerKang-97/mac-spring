package tyler.macspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tyler.macspring.domain.Member;
import tyler.macspring.repository.MemberRepository;
import tyler.macspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// @Service //Spring이 컨테이너에 등록
public class MemberService {

    private final MemberRepository memberRepository;
    //@Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } // DI(의존성 주입)

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 확인
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     *전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
