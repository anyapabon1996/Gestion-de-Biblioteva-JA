package com.sessionTwo.biblioteca.GestionBiblioteca.Repository;

import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends CrudRepository<Book, Integer> {
}
