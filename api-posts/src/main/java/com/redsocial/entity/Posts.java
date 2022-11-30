package com.redsocial.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.redsocial.modelo.PostsDto;

@Entity
@Table(name = "posts")
public class Posts implements Serializable {

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
	private String descripcion;
	@Column(name = "id_usuario")
	@NotBlank
	private String idUsuario;
	@Column(name = "fecha_post")
	@NotBlank
	private String fechaPost;

	public static Posts from(PostsDto postsDto) {
		Posts post = new Posts();
		post.setDescripcion(postsDto.getDescripcion());
		post.setIdUsuario(postsDto.getIdUsuario());
		post.setFechaPost(postsDto.getFechaPost());
		return post;
	}

	public PostsDto to() {

		PostsDto post = new PostsDto();
		post.setId(getId());
		post.setDescripcion(getDescripcion());
		post.setIdUsuario(getIdUsuario());
		post.setFechaPost(getFechaPost());

		return post;
	}

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
