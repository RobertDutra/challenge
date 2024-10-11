package com.back_end_challenge.controller;

import com.back_end_challenge.entity.ContactForm;
import com.back_end_challenge.exceptions.InvalidException;
import com.back_end_challenge.service.ContactService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContactController.class)
@AutoConfigureMockMvc
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ContactService service;

    static final ContactForm CONTACT_FORM = new ContactForm("string", "string", "lucas", "lucas@gmail.com");
    static final ContactForm INVALID_NAME = new ContactForm("string", "string", "", "lucas@gmail.com");
    static final ContactForm INVALID_EMAIL = new ContactForm("string", "string", "lucas", "lucasgmail.com");

    @Test
    public void submitForm_WithValidContact_ReturnsCreated() throws Exception {
        mockMvc.perform(post("/api/contact").content(objectMapper.writeValueAsString(CONTACT_FORM))
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    public void submitForm_WithInvalidName_ReturnsBadRequest() throws Exception {
        doThrow(new InvalidException("")).when(service).submitForm(INVALID_NAME);

        mockMvc.perform(post("/api/contact").content(objectMapper.writeValueAsString(INVALID_NAME))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());

    }

    @Test
    public void submitForm_WithInvalidEmail_ReturnsBadRequest() throws Exception {
        doThrow(new InvalidException("")).when(service).submitForm(INVALID_EMAIL);

        mockMvc.perform(post("/api/contact").content(objectMapper.writeValueAsString(INVALID_EMAIL))
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
    }
}
