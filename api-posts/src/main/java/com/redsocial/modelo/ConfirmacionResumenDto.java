package com.redsocial.modelo;

public class ConfirmacionResumenDto {

	private String mensaje;
	
	public ConfirmacionResumenDto() {
		
	}

	public ConfirmacionResumenDto(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
