package basic.core.repository;

import basic.core.member.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // 동시성 이유가 있기때문에 실무에선 ConcurrnetHashMap  써야 함 예제상 해시맵 이용
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
