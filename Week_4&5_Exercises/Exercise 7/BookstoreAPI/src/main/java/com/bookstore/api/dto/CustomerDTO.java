package com.bookstore.api.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonSetter;

@Data
public class CustomerDTO {
	private Long id;

    @JsonSetter("full_name")
    private String name;

    private String email;
    private String address;
}
