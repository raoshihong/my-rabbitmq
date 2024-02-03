package com.paic.my.config;

import com.paic.my.domain.dto.PersonDto;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @author raoshihong
 * @date 2024/2/3 8:47 PM
 */
@Service
public class RabbitMQListener {

    // 设置该方法为默认调用方法(注意无法使用MessageConverter接收消息)
    @RabbitListener(containerFactory = "rabbitListenerContainerFactory",
        bindings = {
            @QueueBinding(
                value = @Queue(
                    name = "springboot.rabbitmq-queue"
                    /*arguments = {
                            //设置队列中所有消息的过期时间
                            @Argument(
                                    name = "x-message-ttl",
                                    value = "1000",
                                    type = "java.lang.Integer"
                            ),
                            //设置队列为死信队列
                            @Argument(
                                    name = "x-dead-letter-exchange",
                                    value = "exchange.dlx"
                            )
                    }*/
                ),
                exchange = @Exchange(name = "springboot.rabbitmq-exchange", type = ExchangeTypes.DIRECT),
                key = "key.springboot.order"
            )
        }
    )
    @RabbitHandler
    public void handleMessage(@Payload PersonDto message){
        System.out.println(message);
    }


}
