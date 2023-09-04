package basic.core.repository;

import basic.core.member.Member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}
