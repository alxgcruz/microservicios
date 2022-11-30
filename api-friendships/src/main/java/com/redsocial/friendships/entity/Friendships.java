package com.redsocial.friendships.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.redsocial.friendships.modelo.FriendshipsDto;

@Entity
@Table(name = "friendships")
public class Friendships implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	@Column(name = "id_usuario")
	@NotBlank
	private String idUsuario;
	@Column(name = "id_amigo")
	@NotBlank
	private String idAmigo;
	private Boolean authorized;

	public static Friendships from(FriendshipsDto friendshipsDto) {
		Friendships friendship = new Friendships();
		friendship.setIdUsuario(friendshipsDto.getIdUsuario());
		friendship.setIdAmigo(friendshipsDto.getIdAmigo());
		friendship.setAuthorized(friendshipsDto.getAuthorized());

		return friendship;
	}

	public FriendshipsDto to() {

		FriendshipsDto friendship = new FriendshipsDto();
		friendship.setId(getId());
		friendship.setIdUsuario(getIdUsuario());
		friendship.setIdAmigo(getIdAmigo());
		friendship.setAuthorized(getAuthorized());

		return friendship;
	}

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
