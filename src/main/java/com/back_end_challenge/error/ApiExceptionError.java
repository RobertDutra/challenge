package com.back_end_challenge.error;

import com.back_end_challenge.dto.DefaultErrorDTO;
import com.back_end_challenge.exceptions.InvalidException;
import com.back_end_challenge.exceptions.InvalidRecaptchaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionError extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidException.class)
    public ResponseEntity<?> invalidException(InvalidException e, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        DefaultErrorDTO body = DefaultErrorDTO.builder().type("about:blank").status(status).detail(e.getMessage()).instance("/api/contact").build();
        return handleExceptionInternal(e, body, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(InvalidRecaptchaException.class)
    public ResponseEntity<?> invalidRecaptchaException(InvalidRecaptchaException e, WebRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        DefaultErrorDTO body = DefaultErrorDTO.builder().type("about:blank").status(status).detail(e.getMessage()).instance("/api/contact").build();
        return handleExceptionInternal(e, body, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> throwableNotFoundException(Throwable e, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        var msg = "Some generic error name.";
        DefaultErrorDTO body = DefaultErrorDTO.builder().type("about:blank").status(status).detail(msg).instance("/api/contact").build();
        return handleExceptionInternal((Exception) e, body, new HttpHeaders(), status, request);
    }
}


