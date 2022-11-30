package com.redsocial.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import com.redsocial.entity.Posts;
import com.redsocial.modelo.PostsDto;
import com.redsocial.modelo.ConfirmacionResumenDto;
import com.redsocial.repository.PostsRepository;

@Service
public class PostsServiceImpl implements PostsService {

	private PostsRepository postsRepository;
	private Logger log = Logger.getLogger(PostsServiceImpl.class);

	public PostsServiceImpl(PostsRepository postsRepository) {
		this.postsRepository = postsRepository;
	}

	@Override
	public Posts guardarPost(PostsDto post) {
		Posts nuevoPost = postsRepository.saveAndFlush(Posts.from(post));
		log.info(">>> nuevo Post creado");
		return nuevoPost;
	}

	@Override
	public Posts obtenerPostById(String id) {
		return postsRepository.findById(id)
				.orElseThrow(() -> PostNoEncontradoException.from("No se encontró el post", id));
	}

	@Override
	public ArrayList<PostsDto> obtenerPostsByUser(String idUsuario) {
		ArrayList<PostsDto> list = new ArrayList<PostsDto>();
		ArrayList<Posts> posts = postsRepository.findByIdUsuario(idUsuario);
		for(Posts post:posts) {
			list.add(post.to());
		}
		return list;
	}

	@Override
	public ConfirmacionResumenDto eliminaPostById(String id) {
		Posts post = postsRepository.findById(id)
				.orElseThrow(() -> PostNoEncontradoException.from("No se encontró el post", id));

		postsRepository.delete(post);
		ConfirmacionResumenDto resumenConfirmacion = new ConfirmacionResumenDto("Se eliminó el post "+post.getId());
		
		return resumenConfirmacion;
	}

}
