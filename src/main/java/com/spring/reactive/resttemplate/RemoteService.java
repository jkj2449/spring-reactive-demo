package com.spring.reactive.resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class RemoteService {
    @RestController
    public static class RemoteController {
        @GetMapping("/service")
        public String service() throws InterruptedException {
            Thread.sleep(2000);
            return "/service";
        }
    }

    public static void main(String[] args) {
        System.setProperty("server.port","8081");
        System.setProperty("server.tomcat.max-threads","1000");
        SpringApplication.run(RemoteService.class, args);

    }
}
