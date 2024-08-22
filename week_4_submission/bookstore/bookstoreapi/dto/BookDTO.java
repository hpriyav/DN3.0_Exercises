package com.example.bookstoreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO {
    private Long id;
	 @JsonProperty("bookTitle")
    private String title;
    private String author;
    private Double price;
    private String isbn;
}
