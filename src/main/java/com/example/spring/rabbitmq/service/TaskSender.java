package com.example.spring.rabbitmq.service;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskSender {

	@Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    int dots = 0;
    int count = 0;

    @PostConstruct
    public void send() {
    		try {
	    		for (int i = 0; i < 5; i++) {
		        String message = "hello" + i;
		        template.convertAndSend(queue.getName(), message);
		        System.out.println(" [x] Sent '" + message + "'");
	    		}
    		} catch (Exception e) {
				e.printStackTrace();
		}
    }
	
}
