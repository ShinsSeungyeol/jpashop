package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    @DisplayName("회원가입")
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("shinseungyeol");

        //when
        Long savedId = memberService.join(member);

        //then
        Assertions.assertThat(member).isEqualTo(memberRepository.findOne(savedId));
    }


    @Test
    @DisplayName("중복된 회원은 가입할 수 없다.")
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim1");

        Member member2 = new Member();
        member2.setName("kim1");

        //when
        memberService.join(member1);

        assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });
    }

}