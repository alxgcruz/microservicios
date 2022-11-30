package com.redsocial.service.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.redsocial.PostsRabbitConfigConsumer;
import com.redsocial.modelo.PostsDto;
import com.redsocial.service.PostsService;
@Component
public class PostsConsumer {

	public static final Logger logger = LoggerFactory.getLogger(PostsConsumer.class);
	private PostsService postsSrv;
	private Gson json = new Gson();

	public PostsConsumer(
			PostsService postsSrv) {
		this.postsSrv = postsSrv;
	}

	@RabbitListener(queues = PostsRabbitConfigConsumer.QUEUE_REDSOCIAL_NEWPOST)
	public void listenNewPost(Message message) {
		String body = new String(message.getBody());
		logger.info("Event new post >> " + body);

		PostsDto postDto = json.fromJson(body, PostsDto.class);

		postsSrv.guardarPost(postDto);
	}
}
