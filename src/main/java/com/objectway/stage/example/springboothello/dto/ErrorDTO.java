package com.objectway.stage.example.springboothello.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ErrorDTO {
	private String message;
	private String correlationId;
}
