package br.aritana.producer;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class RabbitmqApplicationTests {

    /** Avoid eager {@link RabbitAdmin#initialize()} against a real broker during unit context load. */
    @MockitoBean
    RabbitAdmin rabbitAdmin;

    @Test
    void contextLoads() {
    }

}
