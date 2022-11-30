package com.redsocial.auth.service;

public class AutorizacionNoEncontradoException extends RuntimeException {
  private final String id;

  public AutorizacionNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static AutorizacionNoEncontradoException from(String message, String id) {
    return new AutorizacionNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
