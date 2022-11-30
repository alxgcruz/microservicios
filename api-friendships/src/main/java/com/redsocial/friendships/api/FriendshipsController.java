package com.redsocial.friendships.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.redsocial.friendships.modelo.FriendshipsDto;
import com.redsocial.friendships.modelo.ConfirmacionResumenDto;
import com.redsocial.friendships.service.FriendshipsServiceImpl;

@RestController
@RequestMapping("friendships/v1")
public class FriendshipsController {

	private static final Logger log = Logger.getLogger(FriendshipsController.class);
	@Autowired
	private FriendshipsServiceImpl friendshipsService;

	@PostMapping
	@ResponseStatus(CREATED)
	public FriendshipsDto crear(@RequestBody FriendshipsDto friendship) {
		log.info(">>> friends/v1 creando friendship");
		return friendshipsService.guardarFriendship(friendship).to();
	}

	@GetMapping("/{idUsuario}")
	@ResponseStatus(OK)
	public ArrayList<FriendshipsDto> obtenerFriendship(@PathVariable("idUsuario") String idUsuario) {
		log.info(">>> friends/v1 obtenerFriendship ");
		return friendshipsService.obtenerFriendshipById(idUsuario);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(OK)
	public ConfirmacionResumenDto eliminaFriendship(@PathVariable("id") String id) {
		log.info(">>> friends/v1 eliminaFriendship ");
		return friendshipsService.eliminaFriendshipById(id);
	}

}
