package com.sessionTwo.biblioteca.GestionBiblioteca.Repository;

import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Editorial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends CrudRepository<Editorial, Integer> {
}
