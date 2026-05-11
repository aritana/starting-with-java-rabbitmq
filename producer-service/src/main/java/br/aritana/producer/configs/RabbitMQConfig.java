package br.aritana.producer.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AMQP topology and {@link RabbitAdmin} setup.
 * <p>
 * By default, {@link RabbitAdmin} registers a connection listener and declares topology when the
 * <strong>first</strong> broker connection opens. A producer that never publishes therefore never
 * opens a connection and never declares queues or exchanges.
 * <p>
 * {@code @Bean(initMethod = "initialize")} runs {@link RabbitAdmin#initialize()} during bean
 * creation so topology exists before HTTP traffic, and the process fails fast if the broker is
 * unreachable. {@link RabbitAdmin#setAutoStartup(boolean)} stays {@code true} so declarations are
 * replayed after connection recovery.
 */
@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_MARKETPLACE_DIRECT = "marketplace.direct";
    public static final String QUEUE_PRODUCT_LOG = "product.log";
    public static final String ROUTING_KEY_PRODUCT_LOG = "product.log";

    @Bean
    public Queue productLogQueue() {
        return new Queue(QUEUE_PRODUCT_LOG, true, false, false);
    }

    @Bean
    public DirectExchange marketplaceDirectExchange() {
        return new DirectExchange(EXCHANGE_MARKETPLACE_DIRECT, true, false);
    }

    @Bean
    public Binding productLogBinding(Queue productLogQueue, DirectExchange marketplaceDirectExchange) {
        return BindingBuilder.bind(productLogQueue).to(marketplaceDirectExchange).with(ROUTING_KEY_PRODUCT_LOG);
    }

    /**
     * Eager declaration via {@code initMethod}; without it, topology waits for the first live AMQP
     * connection (publish or listener).
     */
    @Bean(initMethod = "initialize")
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin admin = new RabbitAdmin(connectionFactory);
        admin.setAutoStartup(true);
        return admin;
    }
}
