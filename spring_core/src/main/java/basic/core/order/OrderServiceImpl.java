package basic.core.order;

import basic.core.discount.DiscountPolicy;
import basic.core.member.Member;
import basic.core.repository.MemberRepository;

public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private  final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // 인터페이스에만 의존하도록 만들기

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
