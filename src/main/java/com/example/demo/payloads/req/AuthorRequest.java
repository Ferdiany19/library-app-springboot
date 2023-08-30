package com.example.demo.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AuthorRequest {
    @NotEmpty(message = "name is required!")
    private String name;
    private String socialMedia;
}
