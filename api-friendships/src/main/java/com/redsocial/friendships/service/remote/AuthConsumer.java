package com.redsocial.friendships.service.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.redsocial.friendships.FriendshipsRabbitConfigConsumer;
import com.redsocial.friendships.modelo.remote.AuthRemoteDto;
import com.redsocial.friendships.service.FriendshipsServiceImpl;

@Component
public class AuthConsumer {

	public static final Logger logger = LoggerFactory.getLogger(AuthConsumer.class);
	private Gson json = new Gson();
	private FriendshipsServiceImpl friendshipsServiceImpl;

	public AuthConsumer(FriendshipsServiceImpl friendshipsServiceImpl) {
		this.friendshipsServiceImpl = friendshipsServiceImpl;
	}

	@RabbitListener(queues = FriendshipsRabbitConfigConsumer.QUEUE_FRIENDSHIP_CONFIRMAR)
	public void listenSolicitudes(Message message) {
		String body = new String(message.getBody());
		logger.info("Event autorizaciones de solicitudes" + body);

		AuthRemoteDto authDto = json.fromJson(body, AuthRemoteDto.class);

			friendshipsServiceImpl.modificaById(authDto);
	}
}
