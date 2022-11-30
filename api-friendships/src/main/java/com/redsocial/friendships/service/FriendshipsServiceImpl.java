package com.redsocial.friendships.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.redsocial.friendships.entity.Friendships;
import com.redsocial.friendships.modelo.FriendshipsDto;
import com.redsocial.friendships.modelo.remote.AuthRemoteDto;
import com.redsocial.friendships.modelo.ConfirmacionResumenDto;
import com.redsocial.friendships.repository.FriendshipsRepository;
import com.redsocial.friendships.service.remote.AuthProducer;

@Service
public class FriendshipsServiceImpl implements FriendshipsService {

	private FriendshipsRepository friendshipsRepository;
	private Logger log = Logger.getLogger(FriendshipsServiceImpl.class);
	private Gson json = new Gson();
	private AuthProducer authProducer;

	public FriendshipsServiceImpl(FriendshipsRepository friendshipsRepository) {
		this.friendshipsRepository = friendshipsRepository;
	}

	@Override
	public Friendships guardarFriendship(FriendshipsDto friendship) {
		Friendships newFriendship = friendshipsRepository.saveAndFlush(Friendships.from(friendship));
		
		log.info(">> Friendship creado, pidiendo autorizacion...");

		
		AuthRemoteDto newAuth = new AuthRemoteDto();
		newAuth.setEstatus(false);
		newAuth.setTipoAuth("FRIENDSHIP");
		newAuth.setFechaCreacion(new Date().toString());
		newAuth.setFechaAutorizacion(null);
		
		authProducer.sendMessage(json.toJson(newAuth));
		
		return newFriendship;
	}

	@Override
	public ArrayList<FriendshipsDto> obtenerFriendshipById(String idUsuario) {
		List<Friendships> friendships = friendshipsRepository.findByIdUsuario(idUsuario);
		ArrayList<FriendshipsDto> list = new ArrayList<FriendshipsDto>();
		for(Friendships friend:friendships) {
			list.add(friend.to());
		}
		return list;
	}

	@Override
	public ConfirmacionResumenDto eliminaFriendshipById(String id) {
		Friendships friendship = friendshipsRepository.findById(id)
				.orElseThrow(() -> FriendshipNoEncontradoException.from("No se encontro el friendship", id));
		friendshipsRepository.delete(friendship);
		ConfirmacionResumenDto resumenConfirmacion = new ConfirmacionResumenDto("Se eliminó la friendship "+friendship.getId());
		
		return resumenConfirmacion;
	}

	@Override
	public ConfirmacionResumenDto modificaById(AuthRemoteDto authDto) {
		Friendships friendship = friendshipsRepository.findById(authDto.getIdEvento())
				.orElseThrow(() -> FriendshipNoEncontradoException.from("No se encontro la friendship", authDto.getIdEvento()));
		friendship.setAuthorized(authDto.getEstatus());
		
		ConfirmacionResumenDto resumenConfirmacion = new ConfirmacionResumenDto("Se cambió el estado de la friendship "+friendship.getId());
		return resumenConfirmacion;
	}

}
