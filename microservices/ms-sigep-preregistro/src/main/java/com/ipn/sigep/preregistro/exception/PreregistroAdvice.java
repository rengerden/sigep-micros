package com.ipn.sigep.preregistro.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.ipn.sigep.preregistro.constant.Constants;
import com.ipn.sigep.preregistro.model.ErrorResponse;
import com.ipn.sigep.preregistro.model.ErrorType;
import java.time.ZonedDateTime;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * The Class PreregistroAdvice.
 */
@RestControllerAdvice
public class PreregistroAdvice {

  /**
   * Handler para SQLIntegrityConstraintViolationException.
   *
   * @param req ok.
   * @param ex ok.
   * @return the error response
   */
  @ExceptionHandler(DataIntegrityViolationException.class)
  @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
  public ErrorResponse resolveSqlIntegrityViolation(HttpServletRequest req,
      DataIntegrityViolationException ex) {
    return ErrorResponse.builder().type(ErrorType.WARN.name())
        .datetime(ZonedDateTime.now().toString()).details(ex.getCause().getLocalizedMessage())
        .uuid(req.getHeader(Constants.HEADER_UUID)).build();
  }


  /**
   * Handler para EntityNotFoundException.
   *
   * @param req HttpServletRequest
   * @param ex EntityNotFoundException
   * @return the error response
   */

  @ExceptionHandler(JsonMappingException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorResponse resolveSqlEntityNotFoundException(HttpServletRequest req,
      JsonMappingException ex) {
    return ErrorResponse.builder().type(ErrorType.WARN.name())
        .datetime(ZonedDateTime.now().toString()).details(ex.getLocalizedMessage())
        .uuid(req.getHeader(Constants.HEADER_UUID)).build();
  }

  /**
   * Handler para EntityNotFoundException.
   *
   * @param req HttpServletRequest
   * @param ex EntityNotFoundException
   * @return the error response
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorResponse resolveMethodArgumentNotValidException(HttpServletRequest req,
      MethodArgumentNotValidException ex) {
    return ErrorResponse.builder().type(ErrorType.WARN.name())
        .datetime(ZonedDateTime.now().toString()).details(getErrorDetail(ex.getBindingResult()))
        .uuid(req.getHeader(Constants.HEADER_UUID)).build();
  }


  /**
   * Gets the error detail.
   *
   * @param result the result
   * @return the error detail
   */
  private String getErrorDetail(BindingResult result) {
    return Objects.isNull(result.getAllErrors().get(Constants.VALOR_INT_0).getDefaultMessage())
        ? result.getAllErrors().get(Constants.VALOR_INT_0).getDefaultMessage()
        : Constants.EMPTY_STRING;
  }
}
