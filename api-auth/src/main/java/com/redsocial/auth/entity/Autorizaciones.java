package com.redsocial.auth.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.redsocial.auth.modelo.AutorizacionesDto;

@Entity
@Table(name = "auth")
public class Autorizaciones implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	@Column(name = "id_evento")
	@NotBlank
	private String idEvento;
	@Column(name = "tipo_auth")
	@NotBlank
	private String tipoAuth;
	@Column(name = "fecha_creacion")
	@NotBlank
	private String fechaCreacion;
	@Column(name = "fecha_autorizacion")
	@NotBlank
	private String fechaAutorizacion;
	private Boolean estatus;

	public static Autorizaciones from(AutorizacionesDto autorizacionsDto) {
		Autorizaciones autorizacion = new Autorizaciones();
		autorizacion.setIdEvento(autorizacionsDto.getIdEvento());
		autorizacion.setTipoAuth(autorizacionsDto.getTipoAuth());
		autorizacion.setFechaCreacion(autorizacionsDto.getFechaCreacion());
		autorizacion.setFechaAutorizacion(autorizacionsDto.getFechaAutorizacion());
		autorizacion.setEstatus(autorizacionsDto.getEstatus());

		return autorizacion;
	}

	public AutorizacionesDto to() {

		AutorizacionesDto autorizacion = new AutorizacionesDto();
		autorizacion.setId(getId());
		autorizacion.setIdEvento(getIdEvento());
		autorizacion.setTipoAuth(getTipoAuth());
		autorizacion.setFechaCreacion(getFechaCreacion());
		autorizacion.setFechaAutorizacion(getFechaAutorizacion());
		autorizacion.setEstatus(getEstatus());

		return autorizacion;
	}

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
