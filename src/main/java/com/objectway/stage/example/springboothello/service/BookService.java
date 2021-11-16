package com.objectway.stage.example.springboothello.service;

import com.objectway.stage.example.springboothello.dto.BookDTO;
import com.objectway.stage.example.springboothello.exception.BookNotFoundException;
import com.objectway.stage.example.springboothello.exception.ServiceException;

/**
 * Service for handling books.
 */
public interface BookService {
	/**
	 * Searches for the book having the given id.
	 * @param id the book id (cannot be null)
	 * @return the book
	 * @throws ServiceException if an error occurs
	 * @throws BookNotFoundException if no book exists with the given id.
	 */
	BookDTO findBook(final String id) throws ServiceException;
}
