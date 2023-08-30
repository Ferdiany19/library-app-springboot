package com.example.demo.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookRequest {
    @NotEmpty(message = "Title is required!")
    private String judul;

    @Size(max = 4, message = "Year cannot be over 4 char")
    private String tahunTerbit;

    @NotEmpty(message = "Author is Required!")
    private String namaPengarang;
    private String namaPenerbit;
}
