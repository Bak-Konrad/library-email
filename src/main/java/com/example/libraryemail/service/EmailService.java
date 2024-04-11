package com.example.libraryemail.service;

import com.example.libraryemail.model.MessageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    public SimpleMailMessage prepareMessage(MessageModel model) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("smietnikowe665@gmail.com");
        mailMessage.setTo(model.getEmail());
        mailMessage.setSubject("Library subscription info");
        mailMessage.setText(model.getMessage());
        return mailMessage;
    }

    public void sendMessage(List<MessageModel> messages) {
        if (!messages.isEmpty()) {
            messages.forEach(messageModel -> mailSender.send(prepareMessage(messageModel)));
        }
    }
}
