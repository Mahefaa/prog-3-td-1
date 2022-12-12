package app.prog.controller.exception;

import app.prog.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InternalExceptionHandler {
  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity<NotFoundException> handleNotFoundException(NotFoundException e) {
    return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
  }
}
