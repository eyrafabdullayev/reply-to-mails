package com.example.mailmanagement.service.impl;

import com.example.mailmanagement.config.MailConfig;
import com.example.mailmanagement.model.Feedback;
import com.example.mailmanagement.service.inter.MailServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MailServiceCustomImpl implements MailServiceCustom {

    @Autowired
    private MailConfig emailConfig;

    @Override
    public void sendEmail(Feedback feedback) {
        // Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailConfig.getHost());
        mailSender.setPort(emailConfig.getPort());
        mailSender.setUsername(emailConfig.getUsername());
        mailSender.setPassword(emailConfig.getPassword());

        // Create an mail instance
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailConfig.getUsername());
        message.setTo(feedback.getTo());
        message.setSubject(feedback.getSubject());
        message.setText(feedback.getBody());

        // Send mail
        mailSender.send(message);
    }
}
