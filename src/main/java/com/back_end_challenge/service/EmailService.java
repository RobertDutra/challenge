package com.back_end_challenge.service;

import com.back_end_challenge.entity.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private ValidationService validationService;

    @Autowired
    private JavaMailSender mailSender;

    @Value ("${spring.mail.username}")
    private String emailFrom;

    public void sendEmailToCompany(ContactForm contactForm){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo(emailFrom);
        message.setSubject("Thanks for contacting us!");
        message.setText("We have received your message: " + contactForm.getComment());
        mailSender.send(message);
    }

    public void sendEmailToUser(ContactForm contactForm){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo(contactForm.getEmail());
        message.setSubject("Thanks for contacting us!");
        message.setText("We have received your message: " + contactForm.getComment());
        mailSender.send(message);
    }
}
