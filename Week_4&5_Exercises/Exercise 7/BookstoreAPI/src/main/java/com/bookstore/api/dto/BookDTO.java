package com.bookstore.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookDTO {
	 	private Long id;

	    @JsonProperty("book_title")
	    private String title;

	    private String author;
	    private double price;

	    @JsonProperty("isbn_number")
	    private String isbn;
}
