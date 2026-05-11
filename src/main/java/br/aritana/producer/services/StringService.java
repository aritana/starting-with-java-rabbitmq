package br.aritana.producer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.aritana.producer.configs.RabbitMQConfig.EXG_NAME_MARKETPLACE;
import static br.aritana.producer.configs.RabbitMQConfig.RK_PRODUCT_LOG;

@Log4j2
@Service
@RequiredArgsConstructor
public class StringService {
    private final RabbitTemplate rabbitTemplate;

    public void produce(String message) {
        log.info("Received Messsage " + message);
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, message);
    }


}
