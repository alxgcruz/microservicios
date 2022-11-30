package com.redsocial.comments.modelo;

public class ComentariosDto {

	private String id;
	private String comentario;
	private String idUsuario;
	private String idPublicacion;
	private Boolean autorizado;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(String idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public Boolean getAutorizado() {
		return autorizado;
	}

	public void setAutorizado(Boolean autorizado) {
		this.autorizado = autorizado;
	}

}
