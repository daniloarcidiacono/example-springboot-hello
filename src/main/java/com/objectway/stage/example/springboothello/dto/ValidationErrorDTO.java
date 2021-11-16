package com.objectway.stage.example.springboothello.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ValidationErrorDTO extends ErrorDTO {
	/**
	 * Error map.
	 *
	 * <p>Key is the field name
	 * <p>Value is the error description.
	 */
	private Map<String, String> errors = new HashMap<>();
}
