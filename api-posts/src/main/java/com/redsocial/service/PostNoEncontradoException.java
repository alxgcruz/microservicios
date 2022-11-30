package com.redsocial.service;

public class PostNoEncontradoException extends RuntimeException {
  private final String id;

  public PostNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static PostNoEncontradoException from(String message, String id) {
    return new PostNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
