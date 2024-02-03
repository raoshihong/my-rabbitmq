package com.paic.my;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author raoshihong
 * @date 2024/2/3 8:40 PM
 */
@EnableRabbit   // 开启基于注解的RabbitMQ模式
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
