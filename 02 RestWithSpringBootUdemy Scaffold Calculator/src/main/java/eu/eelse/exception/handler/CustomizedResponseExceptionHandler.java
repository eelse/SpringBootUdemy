package eu.eelse.exception.handler;

import eu.eelse.exception.ExceptionResponse;
import eu.eelse.exception.UnsupportedMathOperationException;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
    ExceptionResponse response =
        new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UnsupportedMathOperationException.class)
  public ResponseEntity<ExceptionResponse> handleBadRequestExceptions(
      Exception ex, WebRequest request) {
    ExceptionResponse response =
        new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
}
