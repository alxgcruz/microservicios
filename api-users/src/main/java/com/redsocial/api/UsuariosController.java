package com.redsocial.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.redsocial.modelo.UsuariosDto;
import com.redsocial.modelo.ConfirmacionResumenDto;
import com.redsocial.service.UsuariosServiceImpl;

@RestController
@RequestMapping("users/v1")
public class UsuariosController {

	private static final Logger log = Logger.getLogger(UsuariosController.class);
	@Autowired
	private UsuariosServiceImpl usuariosService;

	@PostMapping
	@ResponseStatus(CREATED)
	public UsuariosDto crear(@RequestBody UsuariosDto usuario) {
		log.info(">>> users/v1 creando usuario");
		return usuariosService.guardarUsuario(usuario).to();
	}

	@GetMapping
	@ResponseStatus(OK)
	public ArrayList<UsuariosDto> obtenerUsuarios() {
		log.info(">>> users/v1 obtenerUsuarios ");
		return usuariosService.obtenerUsuarios();
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public UsuariosDto obtenerUsuario(@PathVariable("id") String id) {
		log.info(">>> users/v1 obtenerUsuario ");
		return usuariosService.obtenerUsuarioById(id).to();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(OK)
	public ConfirmacionResumenDto desactivaUsuario(@PathVariable("id") String id) {
		log.info(">>> users/v1 desactivaUsuario ");
		return usuariosService.desactivaUsuarioById(id);
	}

}
