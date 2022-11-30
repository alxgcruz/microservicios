package com.redsocial.comments;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentsRabbitConfigConsumer {

	public final static String QUEUE_AUTH_SOLICITAR = "queue-auth-solicitar-autorizacion";
	public final static String QUEUE_COMMENT_CONFIRMAR = "queue-comment-cambiar-autorizacion";

	@Bean
	Queue queue() {
		return new Queue(QUEUE_AUTH_SOLICITAR);
	}

	@Bean
	Queue queue2() {
		return new Queue(QUEUE_COMMENT_CONFIRMAR);
	}


	@Bean
	TopicExchange exchange() {
		return new TopicExchange("exchange-principal");
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(QUEUE_AUTH_SOLICITAR);
	}
	
	@Bean
	Binding binding2(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(QUEUE_COMMENT_CONFIRMAR);
	}
	
}
