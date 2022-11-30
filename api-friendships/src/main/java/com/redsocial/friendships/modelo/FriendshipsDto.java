package com.redsocial.friendships.modelo;

public class FriendshipsDto {

	private String id;
	private String idUsuario;
	private String idAmigo;
	private Boolean authorized;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdAmigo() {
		return idAmigo;
	}

	public void setIdAmigo(String idAmigo) {
		this.idAmigo = idAmigo;
	}

	public Boolean getAuthorized() {
		return authorized;
	}

	public void setAuthorized(Boolean authorized) {
		this.authorized = authorized;
	}

}
