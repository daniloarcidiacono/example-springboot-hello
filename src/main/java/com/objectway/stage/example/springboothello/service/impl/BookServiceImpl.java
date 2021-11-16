package com.objectway.stage.example.springboothello.service.impl;

import com.objectway.stage.example.springboothello.dto.BookDTO;
import com.objectway.stage.example.springboothello.exception.BookNotFoundException;
import com.objectway.stage.example.springboothello.exception.ServiceException;
import com.objectway.stage.example.springboothello.service.BookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	@Value("${service.failure-rate}")
	private float failureRate;

	@Override
	public BookDTO findBook(final String id) throws ServiceException {
		final boolean shouldThrow = Math.random() < failureRate;
		if (shouldThrow) {
			throw new BookNotFoundException(id);
		}

		return new BookDTO()
			.setIbsn("isbn")
			.setTitle("Title")
			.setPrice((float)Math.random() * 10);
	}
}
