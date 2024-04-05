package hello.core.beanfind;

import hello.core.order.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //빈 정의된 이름 확인
        for (String beanDefinitionName : beanDefinitionNames) { //iter 단축키(자동 for문 생성)
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + ", object = "+bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); //빈 메타데이터 정보

            //BeanDefinition.ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //BeanDefinition.ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈 //스프링 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){ //스프링 빈 말고 개발한 빈들만
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + ", object = "+bean);
            }
        }
    }
}
