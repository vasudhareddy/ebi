package com.embl.assignment.controllers;

import com.embl.assignment.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.format.*;

@RestController
public class DateController {

    @Value("${datepattern}")
    String datePattern;

    @GetMapping(value = "/date", produces = MediaType.APPLICATION_JSON_VALUE)
    public DateResponse fetchDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        String format = formatter.format(ZonedDateTime.now());
        DateResponse dateResponse = new DateResponse(format);
        return dateResponse;
    }
}
