package com.redsocial.comments.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.redsocial.comments.entity.Comentarios;
import com.redsocial.comments.modelo.ComentariosDto;
import com.redsocial.comments.modelo.ConfirmacionResumenDto;
import com.redsocial.comments.modelo.remote.AuthRemoteDto;
import com.redsocial.comments.repository.ComentariosRepository;
import com.redsocial.comments.service.remote.AuthProducer;

@Service
public class ComentariosServiceImpl implements ComentariosService {

	private ComentariosRepository comentariosRepository;
	private Logger log = Logger.getLogger(ComentariosServiceImpl.class);
	private Gson json = new Gson();
	@Autowired
	private AuthProducer authProducer;

	public ComentariosServiceImpl(ComentariosRepository comentariosRepository) {
		this.comentariosRepository = comentariosRepository;
	}

	@Override
	public Comentarios guardarComentario(ComentariosDto comentario) {
		Comentarios nuevoComentario = comentariosRepository.saveAndFlush(Comentarios.from(comentario));
		
		log.info(">> Comentario creado, creando post inicial...");
		
		AuthRemoteDto newAuth = new AuthRemoteDto();
		newAuth.setEstatus(false);
		newAuth.setTipoAuth("COMMENT");
		newAuth.setFechaCreacion(new Date().toString());
		newAuth.setFechaAutorizacion(null);
		
		authProducer.sendMessage(json.toJson(newAuth));
		
		
		return nuevoComentario;
	}

	@Override
	public ArrayList<ComentariosDto> obtenerComentariosById(String idPost) {
		List<Comentarios> comentarios = comentariosRepository.findByIdPublicacion(idPost);
		ArrayList<ComentariosDto> list = new ArrayList<ComentariosDto>();
		for(Comentarios comment:comentarios) {
			list.add(comment.to());
		}
		return list;
	}

	@Override
	public ConfirmacionResumenDto eliminaComentarioById(String id) {
		Comentarios comentario = comentariosRepository.findById(id)
				.orElseThrow(() -> ComentarioNoEncontradoException.from("No se encontro el comentario", id));
		comentariosRepository.delete(comentario);
		ConfirmacionResumenDto resumenConfirmacion = new ConfirmacionResumenDto("Se eliminó el comentario "+comentario.getId());
		
		return resumenConfirmacion;
	}

	@Override
	public ConfirmacionResumenDto modificaById(AuthRemoteDto authDto) {
		Comentarios comentario = comentariosRepository.findById(authDto.getIdEvento())
				.orElseThrow(() -> ComentarioNoEncontradoException.from("No se encontro la comentario", authDto.getIdEvento()));
		comentario.setAutorizado(authDto.getEstatus());
		
		ConfirmacionResumenDto resumenConfirmacion = new ConfirmacionResumenDto("Se cambió el estado de la comentario "+comentario.getId());
		return resumenConfirmacion;
	}
}
