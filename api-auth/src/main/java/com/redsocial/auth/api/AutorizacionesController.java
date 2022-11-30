package com.redsocial.auth.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.redsocial.auth.modelo.AutorizacionesDto;
import com.redsocial.auth.modelo.ConfirmacionResumenDto;
import com.redsocial.auth.service.AutorizacionesServiceImpl;

@RestController
@RequestMapping("auth/v1")
public class AutorizacionesController {

	private static final Logger log = Logger.getLogger(AutorizacionesController.class);
	@Autowired
	private AutorizacionesServiceImpl autorizacionesService;

	@PostMapping
	@ResponseStatus(CREATED)
	public AutorizacionesDto crear(@RequestBody AutorizacionesDto autorizacion) {
		log.info(">>> auth/v1 creando autorizacion");
		return autorizacionesService.guardarAutorizacion(autorizacion).to();
	}

	@GetMapping
	@ResponseStatus(OK)
	public ArrayList<AutorizacionesDto> obtenerAutorizaciones() {
		log.info(">>> auth/v1 obtenerAutorizaciones ");
		return autorizacionesService.obtenerAutorizaciones();
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public AutorizacionesDto obtenerAutorizacion(@PathVariable("id") String id) {
		log.info(">>> auth/v1 obtenerAutorizacion ");
		return autorizacionesService.obtenerAutorizacionById(id).to();
	}

	@PutMapping("/autorizaciones/confirmaciones")
	@ResponseStatus(OK)
	public ConfirmacionResumenDto confirmacion(@RequestBody AutorizacionesDto autorizacionDto){
		return autorizacionesService.modificaById(autorizacionDto);
	}

}
