package inflern.spring.service;

import inflern.spring.domain.Member;
import inflern.spring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@RequiredArgsConstructor
//@Service
@Transactional //jpa 사용시 트랜잭션필요
public class MemberService {
    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /** 회원 가입
     */

    public Long join(Member member) {

//        long start = System.currentTimeMillis();
//        try {
            validateDuplicateMember(member); //중복 회원검증
            memberRepository.save(member);
            return member.getId();
//        }finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("join = "+timeMs+"ms");
//        }


    }

    private void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
//        long start = System.currentTimeMillis();
//        try {
            return memberRepository.findAll();
//        }finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("findAll = "+timeMs+"ms");
//        }
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
