package com.dev.wellness.exception;

public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {

    this(message, null);
  }

  public NotFoundException(String message, Throwable cause) {

    super(message, cause);
  }

}