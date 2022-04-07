package springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//@EnableJpaAuditing//JPA Auditing 활성화
@SpringBootApplication //스프링부트의 자동 설정, 스프링 bean 읽기와 생성을 모두 자동으로 설정
public class Application {

    public static void main(String[] args){

//        try {
//            SpringApplication.run(Application.class, args);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        SpringApplication.run(Application.class, args); //내장 WAS 실행


    }
}
