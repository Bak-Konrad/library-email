package com.example.libraryemail.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.libraryemail.model.MessageModel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import java.util.List;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSendEmails() throws Exception {
        // Given
        List<MessageModel> messageModels = new ArrayList<>();
        MessageModel message1 = MessageModel.builder()
                .message("Test message 1")
                .email("test1@example.com")
                .build();

        MessageModel message2 = MessageModel.builder()
                .email("test2@example.com")
                .message("Test message 2")
                .build();

        messageModels.add(message1);
        messageModels.add(message2);

        //When//Then
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/mail")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(messageModels)))
                .andExpect(status().isOk());
    }
}
