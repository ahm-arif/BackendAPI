package com.dev.wellness.controllers;

import com.dev.wellness.exception.NotFoundException;
import com.dev.wellness.models.outbounds.wrapper.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler({ NotFoundException.class, NoHandlerFoundException.class })
  public BaseResponse notFoundException(Exception e) {

    log.error(e.getMessage(), e);

    return BaseResponse.builder()
            .code(HttpStatus.NOT_FOUND.value())
            .status(e.getMessage())
            .build();
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Throwable.class)
  public BaseResponse genericException(
          Throwable e
  ) {

    log.error(e.getMessage(), e);

    return BaseResponse.builder()
            .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .status(e.getMessage())
            .build();
  }
}
