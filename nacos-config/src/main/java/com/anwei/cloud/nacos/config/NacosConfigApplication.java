package com.anwei.cloud.nacos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class NacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class, args);
    }

    @RestController
    @RefreshScope
    class SampleController {

        @Value("${user.name}")
        String userName;

        // 25 是默认值，未配置user.age则使用25
        @Value("${user.age:25}")
        int age;

        @RequestMapping("/user")
        public String simple() {
            return "Hello Nacos Config!" + "Hello " + userName + " " + age + "!";
        }
    }
}
