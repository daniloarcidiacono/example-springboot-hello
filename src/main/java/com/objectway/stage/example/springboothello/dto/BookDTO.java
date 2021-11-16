package com.objectway.stage.example.springboothello.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// Getter/Setter, Equals, HashCode
@Data
@Accessors(chain = true)
public class BookDTO {
	@NotNull
	private String title;

	// != null && != ""
	@NotEmpty
	private String ibsn;

	@Min(0)
	private float price;

	@Email
	private String email;

	@Valid
	private LibraryDTO library;
}
