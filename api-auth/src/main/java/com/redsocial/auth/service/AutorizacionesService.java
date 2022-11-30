package com.redsocial.auth.service;

import java.util.ArrayList;

import com.redsocial.auth.entity.Autorizaciones;
import com.redsocial.auth.modelo.AutorizacionesDto;
import com.redsocial.auth.modelo.ConfirmacionResumenDto;

public interface AutorizacionesService {
	Autorizaciones guardarAutorizacion(AutorizacionesDto Autorizacion);
	Autorizaciones obtenerAutorizacionById(String id);
	ArrayList<AutorizacionesDto> obtenerAutorizaciones();
	ConfirmacionResumenDto modificaById(AutorizacionesDto authDto);
}
