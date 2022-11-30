package com.redsocial.comments.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.redsocial.comments.modelo.ComentariosDto;

@Entity
@Table(name = "comments")
public class Comentarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	@NotBlank
	private String comentario;
	@Column(name = "id_usuario")
	@NotBlank
	private String idUsuario;
	@Column(name = "id_publicacion")
	@NotBlank
	private String idPublicacion;
	private Boolean autorizado;

	public static Comentarios from(ComentariosDto comentariosDto) {
		Comentarios comentario = new Comentarios();
		comentario.setComentario(comentariosDto.getComentario());
		comentario.setIdUsuario(comentariosDto.getIdUsuario());
		comentario.setIdPublicacion(comentariosDto.getIdPublicacion());
		comentario.setAutorizado(comentariosDto.getAutorizado());

		return comentario;
	}

	public ComentariosDto to() {

		ComentariosDto comentario = new ComentariosDto();
		comentario.setId(getId());
		comentario.setComentario(getComentario());
		comentario.setIdUsuario(getIdUsuario());
		comentario.setIdPublicacion(getIdPublicacion());
		comentario.setAutorizado(getAutorizado());

		return comentario;
	}

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
