package com.distribuida.servicios;

import com.distribuida.db.Books;

import java.util.List;

public interface BookRepository {
    List<Books> findAll( );

    Books findById(int id);

    Books insert(Books books);

    Books update(Books books);

    void delete( int id );

}
