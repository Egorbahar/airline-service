package com.godeltech.web.handler;

import com.godeltech.exception.ResourceNotFoundException;
import com.godeltech.exception.StatusException;
import com.godeltech.exception.WeatherConditionsException;
import com.godeltech.web.dto.response.ErrorResponseDto;
import com.godeltech.web.dto.response.ExceptionResponseDto;
import com.godeltech.web.validator.Violation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus httpStatus,
                                                                  WebRequest request) {
        final List<Violation> violations = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> new Violation(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        log.error(exception.getMessage());
        return new ResponseEntity<>(new ErrorResponseDto(httpStatus, violations), httpStatus);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exception,
                                                            WebRequest request) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        final List<Violation> violations = exception.getConstraintViolations().stream()
                .map(violation -> new Violation(violation.getInvalidValue().toString(), violation.getMessage()))
                .collect(Collectors.toList());
        log.error(exception.getMessage());
        return new ResponseEntity<>(new ErrorResponseDto(httpStatus, violations), httpStatus);
    }

    @ExceptionHandler(value = WeatherConditionsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleWeatherConditionsException(WeatherConditionsException exception, WebRequest request) {
        ExceptionResponseDto errorResponseDto = new ExceptionResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        log.error(exception.getMessage());
        return handleExceptionInternal(exception, errorResponseDto, new HttpHeaders(), errorResponseDto.getHttpStatus(), request);
    }

    @ExceptionHandler(value = StatusException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleStatusException(StatusException exception, WebRequest request) {
        ExceptionResponseDto errorResponseDto = new ExceptionResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        log.error(exception.getMessage());
        return handleExceptionInternal(exception, errorResponseDto, new HttpHeaders(), errorResponseDto.getHttpStatus(), request);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        ExceptionResponseDto errorResponseDto = new ExceptionResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        log.error(exception.getMessage());
        return handleExceptionInternal(exception, errorResponseDto, new HttpHeaders(), errorResponseDto.getHttpStatus(), request);
    }
}
