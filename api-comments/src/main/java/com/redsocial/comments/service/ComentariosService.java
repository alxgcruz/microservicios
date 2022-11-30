package com.redsocial.comments.service;

import java.util.ArrayList;

import com.redsocial.comments.entity.Comentarios;
import com.redsocial.comments.modelo.ComentariosDto;
import com.redsocial.comments.modelo.ConfirmacionResumenDto;
import com.redsocial.comments.modelo.remote.AuthRemoteDto;

public interface ComentariosService {
	Comentarios guardarComentario(ComentariosDto Comentario);
	ArrayList<ComentariosDto> obtenerComentariosById(String idPost);
	ConfirmacionResumenDto eliminaComentarioById(String id);
	ConfirmacionResumenDto modificaById(AuthRemoteDto authDto);
}
