package com.redsocial.friendships.service;

public class FriendshipNoEncontradoException extends RuntimeException {
  private final String id;

  public FriendshipNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static FriendshipNoEncontradoException from(String message, String id) {
    return new FriendshipNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
