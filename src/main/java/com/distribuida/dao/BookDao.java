package com.distribuida.dao;

import com.distribuida.db.Books;

import java.util.List;

public interface BookDao {

List<Books> findAll();
Books findById(int id);
Books update(Books books);
Books insert(Books books);
void delete(int id);
}
