package com.sessionTwo.biblioteca.GestionBiblioteca.Repository;

import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepositiry extends CrudRepository<Book,Integer> {

    @Query(value = "select * from tbl_book;", nativeQuery = true)
    List<Book> findAllBooks();
}
