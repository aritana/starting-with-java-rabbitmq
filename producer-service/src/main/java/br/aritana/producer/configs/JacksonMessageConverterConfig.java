package br.aritana.producer.configs;

import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.json.JsonMapper;

/**
 * Ensures {@link org.springframework.amqp.rabbit.core.RabbitTemplate} serializes payloads as JSON
 * (not {@code application/x-java-serialized-object}), matching the consumer's Jackson converter.
 */
@Configuration
public class JacksonMessageConverterConfig {

    @Bean
    public JacksonJsonMessageConverter jacksonJsonMessageConverter(JsonMapper jsonMapper) {
        return new JacksonJsonMessageConverter(jsonMapper);
    }
}
