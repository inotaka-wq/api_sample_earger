package com.example.api_sample;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

	private final BookMapper bookMapper;

	public BookController(BookMapper bookMapper, AuthorMapper authorMapper) {
		this.bookMapper = bookMapper;
	}

	@QueryMapping
	public Book bookById(@Argument Integer id) {
		return bookMapper.getById(id);
	}

	@QueryMapping
	public List<Book> bookAll() {
		return bookMapper.findAll();
	}

	@QueryMapping
	public List<Book> bookAllWithAuthors() {
		return bookMapper.findWithAuthors();
	}

}