package com.back_end_challenge.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class RecaptchaServiceTest {

    @InjectMocks
    private RecaptchaService recaptchaService;

    static final String VALID_RECAPTCHA = "recaptcha Reponse";

    @Test
    public void validateRecaptchat_withValidRecaptcha_doNotThrowAnyException() {
        assertThatCode(() -> recaptchaService.isValidRecaptcha(VALID_RECAPTCHA)).doesNotThrowAnyException();
    }

    @Test
    public void recaptcha_isValid(){

        boolean isTrue = recaptchaService.verifyRecaptcha(VALID_RECAPTCHA);

        assertTrue(isTrue);
    }

}
