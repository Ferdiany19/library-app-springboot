package com.example.demo.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ReturnTransactionRequest {
    @NotEmpty(message = "Id is required!")
    private String id;
}
