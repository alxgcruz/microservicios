package com.redsocial.service;

public class UsuarioNoEncontradoException extends RuntimeException {
  private final String id;

  public UsuarioNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static UsuarioNoEncontradoException from(String message, String id) {
    return new UsuarioNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
