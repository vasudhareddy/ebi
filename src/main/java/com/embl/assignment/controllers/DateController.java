package com.embl.assignment.controllers;

import com.embl.assignment.model.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.format.*;

@RestController
public class DateController {

    @GetMapping(value = "/date", produces = MediaType.APPLICATION_JSON_VALUE)
    public DateResponse fetchDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy");
        String format = formatter.format(ZonedDateTime.now());
        DateResponse dateResponse = new DateResponse(format);
        return dateResponse;
    }
}
