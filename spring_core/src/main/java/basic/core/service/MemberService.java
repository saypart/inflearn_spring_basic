package basic.core.service;

import basic.core.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
