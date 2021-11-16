package com.objectway.stage.example.springboothello.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BookPartialDTO {
	private String price;
}
