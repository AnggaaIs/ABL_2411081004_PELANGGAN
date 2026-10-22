package com.angga.pelanggan.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

  public static final String USER_REGISTERED_QUEUE = "user.registered.queue";

  public static final String PELANGGAN_EVENT_QUEUE = "pelanggan.event.queue";

  @Bean
  public Queue userRegisteredQueue() {
    return new Queue(USER_REGISTERED_QUEUE, true);
  }

  @Bean
  public Queue pelangganEventQueue() {
    return new Queue(PELANGGAN_EVENT_QUEUE, true);
  }
}
