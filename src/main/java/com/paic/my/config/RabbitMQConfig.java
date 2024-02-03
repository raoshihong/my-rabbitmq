package com.paic.my.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author raoshihong
 * @date 2024/2/3 9:11 PM
 */
@Configuration
public class RabbitMQConfig {

    /**
     *  此处设置，将对象以json的方式发送出去，存储在队列中
     *  若不配置默认是对象序列化以后发送出去，在rabbitmq web端看到队列中存储的是一串序列化后的乱码
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }


}
