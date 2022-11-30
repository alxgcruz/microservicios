package com.redsocial.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.redsocial.modelo.UsuariosDto;

@Entity
@Table(name = "users")
public class Usuarios implements Serializable {

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
	private String nombre;
	@Column(name = "apellido_paterno")
	@NotBlank
	private String apellidoPaterno;
	@Column(name = "apellido_materno")
	@NotBlank
	private String apellidoMaterno;
	@Column(name = "fecha_nacimiento")
	@NotBlank
	private String fechaNacimiento;
	@NotBlank
	private String sexo;
	@NotBlank
	private String email;
	private String password;
	private Boolean estatus;

	public static Usuarios from(UsuariosDto usuariosDto) {
		Usuarios usuario = new Usuarios();
		usuario.setNombre(usuariosDto.getNombre());
		usuario.setApellidoPaterno(usuariosDto.getApellidoPaterno());
		usuario.setApellidoMaterno(usuariosDto.getApellidoMaterno());
		usuario.setFechaNacimiento(usuariosDto.getFechaNacimiento());
		usuario.setSexo(usuariosDto.getSexo());
		usuario.setEmail(usuariosDto.getEmail());
		usuario.setPassword(usuariosDto.getPassword());
		usuario.setEstatus(usuariosDto.getEstatus());

		return usuario;
	}

	public UsuariosDto to() {

		UsuariosDto usuario = new UsuariosDto();
		usuario.setId(getId());
		usuario.setNombre(getNombre());
		usuario.setApellidoPaterno(getApellidoPaterno());
		usuario.setApellidoMaterno(getApellidoMaterno());
		usuario.setFechaNacimiento(getFechaNacimiento());
		usuario.setSexo(getSexo());
		usuario.setEmail(getEmail());
		usuario.setPassword(getPassword());
		usuario.setEstatus(getEstatus());

		return usuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

}
