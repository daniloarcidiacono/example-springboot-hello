package com.objectway.stage.example.springboothello.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// Getter/Setter, Equals, HashCode
@Data
@Accessors(chain = true)
public class LibraryDTO {
	@NotEmpty
	private String name;

	@NotEmpty
	private String address;
}
