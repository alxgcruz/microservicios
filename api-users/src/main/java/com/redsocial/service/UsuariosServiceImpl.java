package com.redsocial.service;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.redsocial.entity.Usuarios;
import com.redsocial.modelo.UsuariosDto;
import com.redsocial.modelo.remote.PostsRemoteDto;
import com.redsocial.modelo.ConfirmacionResumenDto;
import com.redsocial.repository.UsuariosRepository;
import com.redsocial.service.remote.UsersProducer;

@Service
public class UsuariosServiceImpl implements UsuariosService {

	private UsuariosRepository usuariosRepository;
	private Logger log = Logger.getLogger(UsuariosServiceImpl.class);
	private Gson json = new Gson();
	@Autowired
	private UsersProducer usuariosProducer;

	public UsuariosServiceImpl(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}

	@Override
	public Usuarios guardarUsuario(UsuariosDto usuario) {
		Usuarios nuevoUsuario = usuariosRepository.saveAndFlush(Usuarios.from(usuario));
		
		log.info(">> Usuario creado, creando post inicial...");

		PostsRemoteDto newPost = new PostsRemoteDto();
		newPost.setDescripcion("Mi primer post automático");
		newPost.setIdUsuario(nuevoUsuario.getId());
		newPost.setFechaPost("28-11-2022 13:00");
		
		usuariosProducer.sendMessage(json.toJson(newPost));
		
		return nuevoUsuario;
	}

	@Override
	public ArrayList<UsuariosDto> obtenerUsuarios() {
		List<Usuarios> usuarios = usuariosRepository.findAll();
		ArrayList<UsuariosDto> list = new ArrayList<UsuariosDto>();
		for(Usuarios user:usuarios) {
			list.add(user.to());
		}
		return list;
	}


	@Override
	public Usuarios obtenerUsuarioById(String id) {
		return usuariosRepository.findById(id)
				.orElseThrow(() -> UsuarioNoEncontradoException.from("No se encontro el usuario", id));
	}

	@Override
	public ConfirmacionResumenDto desactivaUsuarioById(String id) {
		Usuarios usuario = usuariosRepository.findById(id)
				.orElseThrow(() -> UsuarioNoEncontradoException.from("No se encontro el usuario", id));
		usuario.setEstatus(false);
		ConfirmacionResumenDto resumenConfirmacion = new ConfirmacionResumenDto("Se desactivó al usuario "+usuario.getId());
		
		return resumenConfirmacion;
	}

}
