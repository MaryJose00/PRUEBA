package com.distribuida.dao;

import com.distribuida.db.Books;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class BookDaoImp implements BookDao {
@Inject
EntityManager entityManager;
@Override
public List<Books> findAll() {
	return entityManager.createQuery("SELECT books FROM Books books", Books.class).getResultList();
}

@Override
public Books findById(int id) {
	return (Books) entityManager.find(Books.class, id);
}

	@Override
	@Transactional
	public Books update(Books books) {
	try {
		entityManager.getTransaction().begin();
		entityManager.merge(books);
		entityManager.getTransaction().commit();
		entityManager.close();
		return books;
	} catch (Exception e) {
		entityManager.getTransaction().rollback();
		entityManager.close();
	}
	return null;
}


	@Override
	@Transactional
	public Books insert(Books books) {
	try {
		entityManager.getTransaction().begin();
		entityManager.persist(books);
		entityManager.getTransaction().commit();
		entityManager.close();
		return books;
	} catch (Exception e) {
		entityManager.getTransaction().rollback();
		entityManager.close();
	}
	return null;
}

	@Override

 	public void delete(int id) {
	final Object obj = findById(id);
	if (obj != null) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(obj);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			entityManager.close();
		}
	}
	}
}
