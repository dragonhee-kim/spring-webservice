package com.chuno.found;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories //spring boot 사용시 사용하지 않아도 자동 설정됨.
public class  FoundApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoundApplication.class, args);
    }

}
