package com.redsocial.auth.service.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.redsocial.auth.AuthRabbitConfigConsumer;
import com.redsocial.auth.modelo.AutorizacionesDto;
import com.redsocial.auth.service.AutorizacionesServiceImpl;

@Component
public class AuthConsumer {

	public static final Logger logger = LoggerFactory.getLogger(AuthConsumer.class);
	private Gson json = new Gson();
	private AutorizacionesServiceImpl autorizacionServiceImpl;

	public AuthConsumer(AutorizacionesServiceImpl autorizacionServiceImpl) {
		this.autorizacionServiceImpl = autorizacionServiceImpl;
	}

	@RabbitListener(queues = AuthRabbitConfigConsumer.QUEUE_AUTH_SOLICITAR)
	public void listenSolicitudes(Message message) {
		String body = new String(message.getBody());
		logger.info("Event autorizaciones de solicitudes" + body);

		AutorizacionesDto authDto = json.fromJson(body, AutorizacionesDto.class);

			autorizacionServiceImpl.guardarAutorizacion(authDto);
	}
}
