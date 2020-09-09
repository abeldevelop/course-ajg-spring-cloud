package com.abeldevelop.course.ajgspringcloud.products.exception;

public class NotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public NotFoundException(String code) {
    super(code);
  }

  public NotFoundException(String code, Throwable cause) {
    super(code, cause);
  }
}
