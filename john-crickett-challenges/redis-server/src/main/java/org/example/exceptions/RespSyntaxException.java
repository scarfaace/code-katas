package org.example.exceptions;

public class RespSyntaxException extends RuntimeException {

  public RespSyntaxException(String message) {
    super(message);
  }

  public RespSyntaxException(String message, Throwable cause) {
    super(message, cause);
  }

}
