package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP should have 10% discount")
    void discount_vip_0() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        int discountAmount = rateDiscountPolicy.discount(member, 10000);
        assertThat(discountAmount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Basic should have no discount")
    void discount_basic_0() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.BASIC);

        int discountAmount = rateDiscountPolicy.discount(member, 10000);
        assertThat(discountAmount).isEqualTo(0);
    }
}