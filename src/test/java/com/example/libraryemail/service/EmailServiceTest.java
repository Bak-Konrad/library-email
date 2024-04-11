package com.example.libraryemail.service;

import com.example.libraryemail.model.MessageModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {
    @InjectMocks
    private EmailService emailService;

    @Mock
    private JavaMailSender mailSender;

    @Test
    public void testSendMessage() {
        MessageModel messageModel = MessageModel.builder()
                .email("user1@example.com")
                .message("Dupa")
                .build();
        List<MessageModel> models = List.of(messageModel);

        emailService.sendMessage(models);
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

}
