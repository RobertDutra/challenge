package com.back_end_challenge.controller;

import com.back_end_challenge.entity.ContactForm;
import com.back_end_challenge.exceptions.InvalidException;
import com.back_end_challenge.exceptions.InvalidRecaptchaException;
import com.back_end_challenge.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void submitContactForm(@RequestBody ContactForm form) throws InvalidException, InvalidRecaptchaException {
        service.submitForm(form);
    }
}
