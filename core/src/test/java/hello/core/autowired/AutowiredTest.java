package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
       // ac.getBean()
    }

    static class TestBean{
        @Autowired(required = false) //의존관계 없음 메서드 호출 안됨 //자동 주입할 대상 없으면 수정자 메서드 자체가 호출 안됨
        public void setNoBean1(Member member1){
            System.out.println("member = " + member1);

        }
        @Autowired
        public void setNoBean2(@Nullable Member member2){ //호출은 되지만, null로 들어옴
            System.out.println("member = " + member2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member3){ // 자동 주입할 대상이 없으면 Optional.empty가 입력
            System.out.println("member = " + member3);
        }
    }
}
