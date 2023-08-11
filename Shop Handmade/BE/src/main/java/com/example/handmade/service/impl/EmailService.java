package com.example.handmade.service.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("the78901234@gmail.com");
        message.setSubject("kkk");
        message.setText("text");
        emailSender.send(message);
    }
}
