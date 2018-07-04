package com.example.spring.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.spring.rabbitmq.service.TaskReceiver;
import com.example.spring.rabbitmq.service.TaskSender;

@Configuration
public class RabbitMQConfiguration {

	@Bean
    public Queue hello() {
        return new Queue("hello");
    }
	
    private static class ReceiverConfig {

        @Bean
        public TaskReceiver receiver() {
            return new TaskReceiver();
        }

    }

}
