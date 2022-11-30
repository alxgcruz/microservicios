package com.redsocial.auth.service.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.redsocial.auth.AuthRabbitConfigConsumer;
@Component
public class AuthProducer {

	private RabbitTemplate rabbitTemplate;

	public static final Logger logger = LoggerFactory.getLogger(AuthProducer.class);

	public AuthProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendFriendshipMessage(String contractEvent) {
		rabbitTemplate.convertAndSend(AuthRabbitConfigConsumer.QUEUE_FRIENDSHIP_CONFIRMAR, contractEvent);
		logger.info(">>>Envio de AMISTAD correctamente...");
	}

	public void sendCommentMessage(String contractEvent) {
		rabbitTemplate.convertAndSend(AuthRabbitConfigConsumer.QUEUE_COMMENT_CONFIRMAR, contractEvent);
		logger.info(">>>Envio de COMENTARIO correctamente...");
	}
}
