package com.embl.assignment.commonexception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;

import java.time.*;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage();
        message.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        message.setTimestamp(LocalDateTime.now());
        message.setMessage(ex.getMessage());
        message.setDescription(request.getDescription(false));
        return message;
    }
}
