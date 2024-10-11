package com.back_end_challenge.service;

import com.back_end_challenge.exceptions.InvalidException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class ValidationServiceTest {

    @InjectMocks
    private ValidationService validationService;

    static final String NAME_VALID = "Lucas";
    static final String NAME_INVALID = "Lucas2";
    static final String NAME_EMPTY = "";
    static final String EMAIL_VALID = "lucas@gmail.com";
    static final String EMAIL_INVALID = "lucasgmail.com";

    @Test
    public void validateContact_withValidName_doNotThrowAnyException() {
        assertThatCode(() -> validationService.isInvalidName(NAME_VALID)).doesNotThrowAnyException();
    }

    @Test
    public void validateContact_withInvalidName_ThrowsException() {
        assertThatThrownBy(() -> validationService.isInvalidName(NAME_INVALID)).isInstanceOf(InvalidException.class);

    }

    @Test
    public void validateContact_withEmptyName_ThrowsException() {
        assertThatThrownBy(() -> validationService.isInvalidName(NAME_EMPTY)).isInstanceOf(InvalidException.class);

    }

    @Test
    public void validateContact_withValidEmail_doNotThrowAnyException() {
        assertThatCode(() -> validationService.isInvalidEmail(EMAIL_VALID)).doesNotThrowAnyException();
    }

    @Test
    public void validateContact_withInvalidEmail_ThrowsException() {
        assertThatThrownBy(() -> validationService.isInvalidEmail(EMAIL_INVALID)).isInstanceOf(InvalidException.class);
    }

    @Test
    public void patternMatchesName_isValid(){

        boolean isTrue = validationService.patternMatchesName(NAME_VALID);

        assertTrue(isTrue);
    }

    @Test
    public void patternMatchesName_isInvalid(){

        boolean isFalse= validationService.patternMatchesName(NAME_INVALID);

        assertFalse(isFalse);
    }

    @Test
    public void patternMatchesEmail_isValid(){

        boolean isTrue = validationService.patternMatchesEmail(EMAIL_VALID);

        assertTrue(isTrue);
    }

    @Test
    public void patternMatchesEmail_isInvalid(){

        boolean isFalse = validationService.patternMatchesEmail(EMAIL_INVALID);

        assertFalse(isFalse);
    }
}
