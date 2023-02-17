package com.distribuida.controllers;

import com.distribuida.db.Books;

import java.util.List;

public interface BooksController {
	List<Books> findAll();
	Books findById(int id);
	Books update(int id, Books books);
	Books insert(Books books);
	void delete(int id);
}
