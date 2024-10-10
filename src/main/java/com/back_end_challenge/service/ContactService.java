package com.back_end_challenge.service;

import com.back_end_challenge.entity.ContactForm;
import com.back_end_challenge.exceptions.InvalidException;
import com.back_end_challenge.exceptions.InvalidRecaptchaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private RecaptchaService recaptchaService;

    @Autowired
    private ValidationService validationService;



    public void submitForm(ContactForm form) throws InvalidException, InvalidRecaptchaException {
        validationService.isInvalidName(form.getName());
        validationService.isInvalidEmail(form.getEmail());
        recaptchaService.verifyRecaptcha(form.getGRecaptchaResponse());

    }
}
