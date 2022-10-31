package com.uol.api.handler;

import com.uol.api.exceptions.FailRequestHttpException;
import com.uol.api.exceptions.GroupIsFullException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {GroupIsFullException.class})
    protected ResponseEntity<Object> handlerGroupIsFull(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Hi! This group is full. Please, try again with other group. :)";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {FailRequestHttpException.class})
    protected ResponseEntity<Object> handlerFailRequestHttp(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Hi! We are having technical problems. Please try again later. :)";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
