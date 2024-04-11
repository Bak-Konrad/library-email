package com.example.libraryemail.controller;

import com.example.libraryemail.model.MessageModel;
import com.example.libraryemail.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class MailController {
    private final EmailService emailService;

    @PostMapping("/mail")
    public void sendEmails(@RequestBody List<MessageModel> messageModels) {
        emailService.sendMessage(messageModels);
    }

}
