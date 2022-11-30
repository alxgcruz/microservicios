package com.redsocial.friendships.service.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.redsocial.friendships.FriendshipsRabbitConfigConsumer;
@Component
public class AuthProducer {

	private RabbitTemplate rabbitTemplate;

	public static final Logger logger = LoggerFactory.getLogger(AuthProducer.class);

	public AuthProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessage(String contractEvent) {
		rabbitTemplate.convertAndSend(FriendshipsRabbitConfigConsumer.QUEUE_AUTH_SOLICITAR, contractEvent);
		logger.info(">>>Envio de mensaje desde friendships correctamente...");
	}
}
