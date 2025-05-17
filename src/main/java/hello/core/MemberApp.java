package hello.core;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService memberService = new AppConfig().memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member shawn = new Member(1L, "Shawn", Grade.VIP);
        memberService.join(shawn);

        Member member = memberService.findMember(1L);
        System.out.println("findMember = " + member.getName());
        System.out.println("new Member = " + shawn.getName());
    }
}
