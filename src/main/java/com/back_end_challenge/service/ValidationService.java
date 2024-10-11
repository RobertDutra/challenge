package com.back_end_challenge.service;

import com.back_end_challenge.exceptions.InvalidException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidationService {

    private static final String EMAIL_PATTERN =
            "^(?=.{1,64}@)[A-Za-z0-9-]+(.[A-Za-z0-9-]+)@[^-][A-Za-z0-9-]+(.[A-Za-z0-9-]+)(.[A-Za-z]{2,})$";

    private static final String NAME_PATTERN = "^[A-Za-zÀ-ÖØ-öø-ÿ\\s]+$";

    public boolean patternMatchesEmail(String email) {
        return Pattern.compile(EMAIL_PATTERN)
                .matcher(email)
                .matches();
    }

    public boolean patternMatchesName(String name) {
        return Pattern.compile(NAME_PATTERN)
                .matcher(name)
                .matches();
    }

    public void isInvalidEmail(String email) throws InvalidException {

        if (!patternMatchesEmail(email)){
            throw new InvalidException("The email is invalid");
        }
    }

    public void isInvalidName(String name) throws InvalidException {
        if (name.trim().isEmpty()){
            throw new InvalidException("The name is empty");
        }
        if (!patternMatchesName(name)){
            throw new InvalidException("The name is invalid");
        }
    }

}
