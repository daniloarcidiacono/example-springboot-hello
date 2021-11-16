package com.objectway.stage.example.springboothello.advice;

import com.objectway.stage.example.springboothello.dto.ErrorDTO;
import com.objectway.stage.example.springboothello.dto.ValidationErrorDTO;
import com.objectway.stage.example.springboothello.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.UUID;

@RestControllerAdvice
public class BookControllerAdvice {
	@ExceptionHandler(BookNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDTO handleBookNotFound(final BookNotFoundException ex) {
		return new ErrorDTO()
			.setMessage(ex.getMessage())
			.setCorrelationId(String.valueOf(UUID.randomUUID()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationErrorDTO handleMethodArgumentNotValid(final MethodArgumentNotValidException ex) {
		// Init the result
		final ValidationErrorDTO result = (ValidationErrorDTO) new ValidationErrorDTO()
			.setMessage("Validation error")
			.setCorrelationId(String.valueOf(UUID.randomUUID()));

		// Convert errors from Spring Framework to our ValidationErrorDTO map
		int i = 0;
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			final String fieldName = error.getField();
			final String fieldError = error.getDefaultMessage();
			result.getErrors().put(fieldName, fieldError);
		}

		return result;
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationErrorDTO handleConstraintViolationException(final ConstraintViolationException ex) {
		// Init the result
		final ValidationErrorDTO result = (ValidationErrorDTO) new ValidationErrorDTO()
			.setMessage("Validation error")
			.setCorrelationId(String.valueOf(UUID.randomUUID()));

		// Convert errors from Spring Framework to our ValidationErrorDTO map
		for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
			final String fieldName = constraintViolation.getPropertyPath().toString();
			final String fieldError = constraintViolation.getMessage();
			result.getErrors().put(fieldName, fieldError);
		}

		return result;
	}
}
