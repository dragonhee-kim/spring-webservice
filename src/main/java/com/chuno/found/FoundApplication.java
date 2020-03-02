package com.chuno.found;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing //createAt, updatedAt 사용시  넣어줘야함. jpa Autiting 어노테이션 활성화하는 어노테이션
@EnableJpaRepositories //spring boot 사용시 사용하지 않아도 자동 설정됨.
@SpringBootApplication
public class  FoundApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoundApplication.class, args);
    }

}
