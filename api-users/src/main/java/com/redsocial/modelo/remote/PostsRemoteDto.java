package com.redsocial.modelo.remote;

public class PostsRemoteDto {

	private String id;
	private String descripcion;
	private String idUsuario;
	private String fechaPost;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getFechaPost() {
		return fechaPost;
	}

	public void setFechaPost(String fechaPost) {
		this.fechaPost = fechaPost;
	}

}
