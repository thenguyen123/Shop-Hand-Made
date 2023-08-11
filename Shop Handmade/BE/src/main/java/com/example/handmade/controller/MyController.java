package com.example.handmade.controller;

import com.example.handmade.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class MyController {
//    private final EmailService emailService;
//
//    @Autowired
//    public MyController(EmailService emailService) {
//        this.emailService = emailService;
//    }
//
//    @GetMapping("/api/public/send-email")
//    public String sendEmail() {
//        // Gọi phương thức gửi email trong EmailService
//        emailService.sendEmail();
////        emailService.sendEmail("example@example.com", "Subject", "Content");
//
//        return "Email sent";
//    }
//}
