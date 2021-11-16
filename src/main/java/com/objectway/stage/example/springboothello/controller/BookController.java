package com.objectway.stage.example.springboothello.controller;

import com.objectway.stage.example.springboothello.controller.dto.BookPartialDTO;
import com.objectway.stage.example.springboothello.dto.BookDTO;
import com.objectway.stage.example.springboothello.dto.LibraryDTO;
import com.objectway.stage.example.springboothello.exception.ServiceException;
import com.objectway.stage.example.springboothello.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

// POST /repository/{id}/star
@RestController
@RequestMapping("/books")
@Validated
public class BookController {
	private static final BookDTO bookOne = new BookDTO()
		.setIbsn("abc1234")
		.setTitle("title")
		.setLibrary(
			new LibraryDTO()
				.setName("Infinite library")
				.setAddress("Address")
		);

	private static final BookDTO bookTwo = new BookDTO()
		.setIbsn("abc5678")
		.setTitle("titleTwo")
		.setLibrary(
			new LibraryDTO()
				.setName("Infinite library 2")
				.setAddress("Address 2")
		);

	@Autowired
	private BookService bookService;

	@GetMapping
	public List<BookDTO> getBook(@RequestParam(required = false) @Min(1) final Integer page,
								 @RequestParam(required = false) final Integer count,
								 @RequestParam(required = false) final String title) {
		return Arrays.asList(bookOne, bookTwo);
	}

	@GetMapping("/{id}")
	public BookDTO getBook(@PathVariable final String id) throws ServiceException {
		return bookService.findBook(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String saveBook(@Valid @RequestBody final BookDTO book) {
		// 200 OK
		return String.valueOf(UUID.randomUUID());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateBook(@RequestBody final BookDTO book) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Void> patchBook(@RequestBody final BookPartialDTO book) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping
	public void deleteAll() {
	}

	@DeleteMapping("/{id}")
	public void deleteAll(@PathVariable final String id) {
	}
}


//@RequestMapping("/books")

// CRUD
// Create, Read, Update, Delete
// POST, GET, PUT/PATCH, DELETE
//
// @RequestParam
// GET /books?page=1&count=5&title=Design	List<BookDTO>
// @PathVariable
// GET /books/{id}		BookDTO
// @RequestBody
// {
//    "title": "..."
// }
//
// POST /books
// PUT /books/{id}
// PATCH /books/{id}
// DELETE /books: cancelli tutti i libri
// DELETE /books/{id}: cancelli tutti i libri
