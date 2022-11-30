package com.redsocial;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostsRabbitConfigConsumer {

	public final static String QUEUE_REDSOCIAL_NEWPOST = "queue-redsocial-newpost";

	@Bean
	Queue queue() {
		return new Queue(QUEUE_REDSOCIAL_NEWPOST);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("exchange-principal");
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(QUEUE_REDSOCIAL_NEWPOST);
	}
	
}
