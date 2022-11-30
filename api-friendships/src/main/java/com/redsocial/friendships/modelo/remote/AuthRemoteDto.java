package com.redsocial.friendships.modelo.remote;

public class AuthRemoteDto {

	private String id;
	private String idEvento;
	private String tipoAuth;
	private String fechaCreacion;
	private String fechaAutorizacion;
	private Boolean estatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}
	
	public String getTipoAuth() {
		return tipoAuth;
	}

	public void setTipoAuth(String tipoAuth) {
		this.tipoAuth = tipoAuth;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	public void setFechaAutorizacion(String fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

}
