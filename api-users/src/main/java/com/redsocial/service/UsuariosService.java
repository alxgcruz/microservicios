package com.redsocial.service;

import java.util.ArrayList;

import com.redsocial.entity.Usuarios;
import com.redsocial.modelo.UsuariosDto;
import com.redsocial.modelo.ConfirmacionResumenDto;

public interface UsuariosService {
	Usuarios guardarUsuario(UsuariosDto Usuario);
	Usuarios obtenerUsuarioById(String id);
	ArrayList<UsuariosDto> obtenerUsuarios();
	ConfirmacionResumenDto desactivaUsuarioById(String id);
}
