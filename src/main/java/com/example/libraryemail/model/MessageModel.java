package com.example.libraryemail.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageModel {
    private String message;
    private String email;

}
