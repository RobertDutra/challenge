package com.back_end_challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactForm {

    private String gRecaptchaResponse;
    private String comment;
    private String name;
    private String email;


}
