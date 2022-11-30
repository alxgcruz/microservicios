package com.redsocial.comments.api;

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

import com.redsocial.comments.modelo.ComentariosDto;
import com.redsocial.comments.modelo.ConfirmacionResumenDto;
import com.redsocial.comments.service.ComentariosServiceImpl;

@RestController
@RequestMapping("comments/v1")
public class ComentariosController {

	private static final Logger log = Logger.getLogger(ComentariosController.class);
	@Autowired
	private ComentariosServiceImpl comentariosService;

	@PostMapping
	@ResponseStatus(CREATED)
	public ComentariosDto crear(@RequestBody ComentariosDto comentario) {
		log.info(">>> comments/v1 creando comentario");
		return comentariosService.guardarComentario(comentario).to();
	}

	@GetMapping("/{idPost}")
	@ResponseStatus(OK)
	public ArrayList<ComentariosDto> obtenerComentarios(@PathVariable("idPost") String idPost) {
		log.info(">>> comments/v1 obtenerComentarios por Post ");
		return comentariosService.obtenerComentariosById(idPost);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(OK)
	public ConfirmacionResumenDto eliminaComentario(@PathVariable("id") String id) {
		log.info(">>> comments/v1 eliminaComentario ");
		return comentariosService.eliminaComentarioById(id);
	}

}
