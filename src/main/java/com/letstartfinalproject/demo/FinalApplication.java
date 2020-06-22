package com.letstartfinalproject.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = @Info(title="Product API",version = "2.0"))
public class FinalApplication {

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(FinalApplication.class, args);

    }
}
