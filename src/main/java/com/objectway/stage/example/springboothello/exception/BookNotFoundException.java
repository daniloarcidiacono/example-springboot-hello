package com.objectway.stage.example.springboothello.exception;

/**
 * Exception thrown when a book is not found.
 */
public class BookNotFoundException extends ServiceException {
	public BookNotFoundException(final String id) {
		super(String.format("Could not find book with id '%s'", id));
	}
}
