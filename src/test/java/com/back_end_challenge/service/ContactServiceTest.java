package com.back_end_challenge.service;

import com.back_end_challenge.entity.ContactForm;
import com.back_end_challenge.exceptions.InvalidException;
import com.back_end_challenge.exceptions.InvalidRecaptchaException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @InjectMocks
    private ContactService contactService;

    @Mock
    private ValidationService validationService;

    @Mock
    private RecaptchaService recaptchaService;

    static final ContactForm CONTACT_FORM = new ContactForm("string", "string", "lucas", "lucas@gmail.com");
    static final ContactForm INVALID_EMAIL = new ContactForm("string", "string", "lucas", "lucasgmail.com");
    static final ContactForm INVALID_NAME = new ContactForm("string", "string", "", "lucas@gmail.com");

    @Test
    public void submitform_withValidContactForm_doNotThrowAnyException() {
        assertThatCode(() -> contactService.submitForm(CONTACT_FORM)).doesNotThrowAnyException();
    }

    @Test
    public void submitform_withInvalidName_ThrowsException() throws InvalidException {
        doThrow(new InvalidException("")).when(validationService).isInvalidName(INVALID_NAME.getName());
        assertThatThrownBy(() -> contactService.submitForm(INVALID_NAME)).isInstanceOf(InvalidException.class);
    }

    @Test
    public void submitform_withInvalidEmail_ThrowsException() throws InvalidException {
        doThrow(new InvalidException("")).when(validationService).isInvalidEmail(INVALID_EMAIL.getEmail());
        assertThatThrownBy(() -> contactService.submitForm(INVALID_EMAIL)).isInstanceOf(InvalidException.class);
    }

    @Test
    public void submitform_withInvalidRecaptcha_ThrowsException() throws InvalidRecaptchaException {
        doThrow(new InvalidRecaptchaException("")).when(recaptchaService).isValidRecaptcha(CONTACT_FORM.getGRecaptchaResponse());
        assertThatThrownBy(() -> contactService.submitForm(CONTACT_FORM)).isInstanceOf(InvalidRecaptchaException.class);
    }
}
