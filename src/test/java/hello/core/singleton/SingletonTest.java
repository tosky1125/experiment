package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("DI Container without spring framework")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();
        assertThat(memberService).isNotSameAs(memberService2);
    }


    @Test
    @DisplayName("Singleton    Service Test")
    void singletonPatternInstanceUsage() {
        SingletonService singletonService = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        assertThat(singletonService).isInstanceOf(SingletonService.class);
        assertThat(singletonService).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("Spring Container & Singleton")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isSameAs(memberService2);
    }
}
