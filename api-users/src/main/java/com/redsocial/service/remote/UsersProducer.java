package com.redsocial.service.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.redsocial.UsersRabbitConfigConsumer;
@Component
public class UsersProducer {

	private RabbitTemplate rabbitTemplate;

	public static final Logger logger = LoggerFactory.getLogger(UsersProducer.class);

	public UsersProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessage(String contractEvent) {
		rabbitTemplate.convertAndSend(UsersRabbitConfigConsumer.QUEUE_REDSOCIAL_NEWPOST, contractEvent);
		logger.info(">>>Envio de post inicial correctamente...");
	}
}
