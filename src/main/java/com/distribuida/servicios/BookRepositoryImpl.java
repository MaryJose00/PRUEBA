package com.distribuida.servicios;

import com.distribuida.dao.BookDao;
import com.distribuida.db.Books;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

/*     @Inject DbClient dbClient;

   private static Book map(DbRow row) {
        var id = row.column(1).as(Integer.class);
        var isbn = row.column(2).as(String.class);
        var title = row.column(3).as(String.class);
        var author = row.column(4).as(String.class);
        var price = row.column(5).as(BigDecimal.class);

        return new Book( id, isbn, title, author, price.doubleValue() );
    }

    private static Optional<Book> mapOpt(Optional<DbRow> row) {
        if( row.isPresent() ) {
            return Optional.of( BookRepositoryImpl.map(row.get()) );
        }
        else {
            return Optional.empty();
        }
    }*/

    @Inject
    private BookDao bookDao;

    @Override
    public List<Books> findAll() {
        try {
            return bookDao.findAll();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Books findById(int id) {
        try {
               return bookDao.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Books insert(Books books) {
        try {
            return bookDao.insert(books);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

        @Override
        public Books update(Books books) {
            try {
                return bookDao.update(books);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void delete(int id) {
            try {
                 bookDao.delete(id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
}

