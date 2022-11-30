package com.redsocial.friendships.service;

import java.util.ArrayList;

import com.redsocial.friendships.entity.Friendships;
import com.redsocial.friendships.modelo.FriendshipsDto;
import com.redsocial.friendships.modelo.remote.AuthRemoteDto;
import com.redsocial.friendships.modelo.ConfirmacionResumenDto;

public interface FriendshipsService {
	Friendships guardarFriendship(FriendshipsDto Friendship);
	ArrayList<FriendshipsDto> obtenerFriendshipById(String idUsuario);
	ConfirmacionResumenDto eliminaFriendshipById(String id);
	ConfirmacionResumenDto modificaById(AuthRemoteDto authDto);
}
