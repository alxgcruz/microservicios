package com.redsocial.service;

import java.util.ArrayList;

import com.redsocial.entity.Posts;
import com.redsocial.modelo.PostsDto;
import com.redsocial.modelo.ConfirmacionResumenDto;

public interface PostsService {
	Posts guardarPost(PostsDto Post);
	Posts obtenerPostById(String id);
	ArrayList<PostsDto> obtenerPostsByUser(String idUsuario);
	ConfirmacionResumenDto eliminaPostById(String id);
}
