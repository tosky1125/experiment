package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("DI Container without spring framework")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println(memberService);
        System.out.println(memberService2);
    }
}
