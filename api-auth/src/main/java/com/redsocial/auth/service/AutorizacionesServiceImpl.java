package com.redsocial.auth.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.redsocial.auth.service.remote.AuthProducer;
import com.redsocial.auth.entity.Autorizaciones;
import com.redsocial.auth.modelo.AutorizacionesDto;
import com.redsocial.auth.modelo.ConfirmacionResumenDto;
import com.redsocial.auth.repository.AutorizacionesRepository;

@Service
public class AutorizacionesServiceImpl implements AutorizacionesService {

	private AutorizacionesRepository autorizacionesRepository;
	private Logger log = Logger.getLogger(AutorizacionesServiceImpl.class);
	private Gson json = new Gson();
	private AuthProducer authProducer;

	public AutorizacionesServiceImpl(AutorizacionesRepository autorizacionesRepository) {
		this.autorizacionesRepository = autorizacionesRepository;
	}

	@Override
	public Autorizaciones guardarAutorizacion(AutorizacionesDto autorizacion) {
		Autorizaciones nuevoAutorizacion = autorizacionesRepository.saveAndFlush(Autorizaciones.from(autorizacion));
		return nuevoAutorizacion;
	}

	@Override
	public ArrayList<AutorizacionesDto> obtenerAutorizaciones() {
		List<Autorizaciones> autorizaciones = autorizacionesRepository.findAll();
		ArrayList<AutorizacionesDto> list = new ArrayList<AutorizacionesDto>();
		for(Autorizaciones auth:autorizaciones) {
			list.add(auth.to());
		}
		return list;
	}


	@Override
	public Autorizaciones obtenerAutorizacionById(String id) {
		return autorizacionesRepository.findById(id)
				.orElseThrow(() -> AutorizacionNoEncontradoException.from("No se encontro la autorizacion", id));
	}

	@Override
	public ConfirmacionResumenDto modificaById(AutorizacionesDto authDto) {
		Autorizaciones autorizacion = autorizacionesRepository.findById(authDto.getId())
				.orElseThrow(() -> AutorizacionNoEncontradoException.from("No se encontro la autorizacion", authDto.getId()));
		autorizacion.setEstatus(authDto.getEstatus());
		autorizacion.setFechaAutorizacion(new Date().toString());
		ConfirmacionResumenDto resumenConfirmacion = new ConfirmacionResumenDto("Se cambió el estado de la autorizacion "+autorizacion.getId());
		log.info("Cambiando de estado la solicitud...");

		if("FRIENDSHIP".equals(authDto.getTipoAuth())) {
			authProducer.sendFriendshipMessage(json.toJson(authDto));
		} else {
			authProducer.sendCommentMessage(json.toJson(authDto));
		}

		return resumenConfirmacion;
	}

}
