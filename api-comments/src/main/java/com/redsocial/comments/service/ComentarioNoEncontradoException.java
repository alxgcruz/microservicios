package com.redsocial.comments.service;

public class ComentarioNoEncontradoException extends RuntimeException {
  private final String id;

  public ComentarioNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static ComentarioNoEncontradoException from(String message, String id) {
    return new ComentarioNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
