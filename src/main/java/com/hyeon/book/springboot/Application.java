package com.hyeon.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // JPA Auditing 활성화
@SpringBootApplication  //Spring Boot의 자동 설정, Bean 읽기와 생성을 모두 자동화
//앞으로 만들 프로젝트의 메인 클래스
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS를 실행
    }
}
