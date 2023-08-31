package com.example.demo.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BorrowTransactionRequest {
    @NotEmpty(message = "Judul is Required!")
    private String judul;
    @NotEmpty(message = "Username is Required!")
    private String username;
}
