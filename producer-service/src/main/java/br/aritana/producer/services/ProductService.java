package br.aritana.producer.services;

import dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.aritana.commons.constants.RabbitMQConstants.EXCHANGE_MARKETPLACE_DIRECT;
import static br.aritana.commons.constants.RabbitMQConstants.ROUTING_KEY_PRODUCT_LOG;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {
    private final RabbitTemplate rabbitTemplate;

    public void createProduct(ProductDTO dto){
        log.info("Sending a message to exchange " +  dto.toString());
        rabbitTemplate.convertAndSend(EXCHANGE_MARKETPLACE_DIRECT, ROUTING_KEY_PRODUCT_LOG, dto);
    }
}
